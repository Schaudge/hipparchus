/*
 * Licensed to the Hipparchus project under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The Hipparchus project licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hipparchus.special;

import org.apache.commons.math3.util.FastMath;
import org.hipparchus.exception.LocalizedCoreFormats;
import org.hipparchus.exception.MathIllegalStateException;
import org.junit.Assert;
import org.junit.Test;

public class JacobiEllipticTest {

    @Test
    public void testCircular() {
        for (double m : new double[] { -1.0e-10, 0.0, 1.0e-10 }) {
         final double eps = 3 * FastMath.max(1.0e-14, FastMath.abs(m));
            final JacobiElliptic je = new JacobiElliptic(m);
            for (double t = -10; t < 10; t += 0.01) {
                final JacobiElliptic.CopolarN n = je.valuesN(t);
                Assert.assertEquals(FastMath.sin(t), n.sn(), eps);
                Assert.assertEquals(FastMath.cos(t), n.cn(), eps);
                Assert.assertEquals(1.0,             n.dn(), eps);
            }
        }
    }

    @Test
    public void testHyperbolic() {
        for (double m1 : new double[] { -1.0e-12, 0.0, 1.0e-12 }) {
            final double eps = 3 * FastMath.max(1.0e-14, FastMath.abs(m1));
            final JacobiElliptic je = new JacobiElliptic(1.0 - m1);
            for (double t = -3; t < 3; t += 0.01) {
                final JacobiElliptic.CopolarN n = je.valuesN(t);
                Assert.assertEquals(FastMath.tanh(t),       n.sn(), eps);
                Assert.assertEquals(1.0 / FastMath.cosh(t), n.cn(), eps);
                Assert.assertEquals(1.0 / FastMath.cosh(t), n.dn(), eps);
            }
        }
    }

    @Test
    public void testNoConvergence() {
        try {
            new JacobiElliptic(Double.NaN).valuesS(0.0);
            Assert.fail("an exception should have been thrown");
        } catch (MathIllegalStateException mise) {
            Assert.assertEquals(LocalizedCoreFormats.CONVERGENCE_FAILED, mise.getSpecifier());
        }
    }

    @Test
    public void testNegativeParameter() {
        Assert.assertEquals(0.49781366219021166315, new JacobiElliptic(-4.5).valuesN(8.3).sn(), 1.5e-10);
        Assert.assertEquals(0.86728401215332559984, new JacobiElliptic(-4.5).valuesN(8.3).cn(), 1.5e-10);
        Assert.assertEquals(1.45436686918553524215, new JacobiElliptic(-4.5).valuesN(8.3).dn(), 1.5e-10);
    }

    @Test
    public void testAbramowitzStegunExample1() {
        // Abramowitz and Stegun give a result of -1667, but Wolfram Alpha gives the following value
        Assert.assertEquals(-1392.11114434139393839735, new JacobiElliptic(0.64).valuesC(1.99650).nc(), 1.5e-10);
    }

    @Test
    public void testAbramowitzStegunExample2() {
        Assert.assertEquals(0.996253, new JacobiElliptic(0.19).valuesN(0.20).dn(), 1.0e-6);
    }

    @Test
    public void testAbramowitzStegunExample3() {
        Assert.assertEquals(0.984056, new JacobiElliptic(0.81).valuesN(0.20).dn(), 1.0e-6);
    }

    @Test
    public void testAbramowitzStegunExample4() {
        Assert.assertEquals(0.980278, new JacobiElliptic(0.81).valuesN(0.20).cn(), 1.0e-6);
    }

    @Test
    public void testAbramowitzStegunExample5() {
        Assert.assertEquals(0.60952, new JacobiElliptic(0.36).valuesN(0.672).sn(), 1.0e-5);
        Assert.assertEquals(1.1740, new JacobiElliptic(0.36).valuesC(0.672).dc(), 1.0e-4);
    }

    @Test
    public void testAbramowitzStegunExample7() {
        Assert.assertEquals(1.6918083, new JacobiElliptic(0.09).valuesS(0.5360162).cs(), 1.0e-7);
    }

    @Test
    public void testAbramowitzStegunExample8() {
        Assert.assertEquals(0.56458, new JacobiElliptic(0.5).valuesN(0.61802).sn(), 1.0e-5);
    }

    @Test
    public void testAbramowitzStegunExample9() {
        Assert.assertEquals(0.68402, new JacobiElliptic(0.5).valuesC(0.61802).sc(), 1.0e-5);
    }

    @Test
    public void testAllFunctions() {
        // reference was computed from Wolfram Alpha, using the square relations
        // from Abramowitz and Stegun section 16.9 for the functions Wolfram Alpha
        // did not understood (i.e. for the sake of validation we did *not* use the
        // relations from section 16.3 which are used in the Hipparchus implementation)
        final double u = 1.4;
        final double m = 0.7;
        final double[] reference = {
              0.92516138673582827365, 0.37957398289798418747, 0.63312991237590996850,
              0.41027866958131945027, 0.68434537093007175683, 1.08089249544689572795,
              1.66800134071905681841, 2.63453251554589286796, 2.43736775548306830513,
              1.57945467502452678756, 1.46125047743207819361, 0.59951990180590090343
        };
        final JacobiElliptic je = new JacobiElliptic(m);
        Assert.assertEquals(reference[ 0], je.valuesN(u).sn(), 2 * FastMath.ulp(reference[ 0]));
        Assert.assertEquals(reference[ 1], je.valuesN(u).cn(), 2 * FastMath.ulp(reference[ 1]));
        Assert.assertEquals(reference[ 2], je.valuesN(u).dn(), 2 * FastMath.ulp(reference[ 2]));
        Assert.assertEquals(reference[ 3], je.valuesS(u).cs(), 2 * FastMath.ulp(reference[ 3]));
        Assert.assertEquals(reference[ 4], je.valuesS(u).ds(), 2 * FastMath.ulp(reference[ 4]));
        Assert.assertEquals(reference[ 5], je.valuesS(u).ns(), 2 * FastMath.ulp(reference[ 5]));
        Assert.assertEquals(reference[ 6], je.valuesC(u).dc(), 2 * FastMath.ulp(reference[ 6]));
        Assert.assertEquals(reference[ 7], je.valuesC(u).nc(), 2 * FastMath.ulp(reference[ 7]));
        Assert.assertEquals(reference[ 8], je.valuesC(u).sc(), 2 * FastMath.ulp(reference[ 8]));
        Assert.assertEquals(reference[ 9], je.valuesD(u).nd(), 2 * FastMath.ulp(reference[ 9]));
        Assert.assertEquals(reference[10], je.valuesD(u).sd(), 2 * FastMath.ulp(reference[10]));
        Assert.assertEquals(reference[11], je.valuesD(u).cd(), 2 * FastMath.ulp(reference[11]));
    }

}
