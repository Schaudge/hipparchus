/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
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
package org.apache.commons.math.stat.inference;

import java.util.Collection;
import org.apache.commons.math.MathException;
import org.apache.commons.math.exception.ConvergenceException;
import org.apache.commons.math.exception.DimensionMismatchException;
import org.apache.commons.math.exception.MaxCountExceededException;
import org.apache.commons.math.exception.NotPositiveException;
import org.apache.commons.math.exception.NotStrictlyPositiveException;
import org.apache.commons.math.exception.NullArgumentException;
import org.apache.commons.math.exception.OutOfRangeException;
import org.apache.commons.math.exception.ZeroException;
import org.apache.commons.math.stat.descriptive.StatisticalSummary;

/**
 * A collection of static methods to create inference test instances or to
 * perform inference tests.
 *
 * @since 1.1
 * @version $Id$
 */
public class TestUtils  {

    /** Singleton TTest instance. */
    private static final TTest T_TEST = new TTestImpl();

    /** Singleton ChiSquareTest instance. */
    private static final ChiSquareTest CHI_SQUARE_TEST = new ChiSquareTest();

    /** Singleton OneWayAnova instance. */
    private static final OneWayAnova ONE_WAY_ANANOVA = new OneWayAnova();

    /**
     * Prevent instantiation.
     */
    private TestUtils() {
        super();
    }

    // CHECKSTYLE: stop JavadocMethodCheck

    /**
     * @see org.apache.commons.math.stat.inference.TTest#homoscedasticT(double[], double[])
     */
    public static double homoscedasticT(double[] sample1, double[] sample2)
        throws IllegalArgumentException {
        return T_TEST.homoscedasticT(sample1, sample2);
    }

    /**
     * @see org.apache.commons.math.stat.inference.TTest#homoscedasticT(org.apache.commons.math.stat.descriptive.StatisticalSummary, org.apache.commons.math.stat.descriptive.StatisticalSummary)
     */
    public static double homoscedasticT(StatisticalSummary sampleStats1,
        StatisticalSummary sampleStats2)
        throws IllegalArgumentException {
        return T_TEST.homoscedasticT(sampleStats1, sampleStats2);
    }

    /**
     * @see org.apache.commons.math.stat.inference.TTest#homoscedasticTTest(double[], double[], double)
     */
    public static boolean homoscedasticTTest(double[] sample1, double[] sample2,
            double alpha)
        throws IllegalArgumentException, MathException {
        return T_TEST.homoscedasticTTest(sample1, sample2, alpha);
    }

    /**
     * @see org.apache.commons.math.stat.inference.TTest#homoscedasticTTest(double[], double[])
     */
    public static double homoscedasticTTest(double[] sample1, double[] sample2)
        throws IllegalArgumentException, MathException {
        return T_TEST.homoscedasticTTest(sample1, sample2);
    }

    /**
     * @see org.apache.commons.math.stat.inference.TTest#homoscedasticTTest(org.apache.commons.math.stat.descriptive.StatisticalSummary, org.apache.commons.math.stat.descriptive.StatisticalSummary)
     */
    public static double homoscedasticTTest(StatisticalSummary sampleStats1,
        StatisticalSummary sampleStats2)
        throws IllegalArgumentException, MathException {
        return T_TEST.homoscedasticTTest(sampleStats1, sampleStats2);
    }

    /**
     * @see org.apache.commons.math.stat.inference.TTest#pairedT(double[], double[])
     */
    public static double pairedT(double[] sample1, double[] sample2)
        throws IllegalArgumentException, MathException {
        return T_TEST.pairedT(sample1, sample2);
    }

    /**
     * @see org.apache.commons.math.stat.inference.TTest#pairedTTest(double[], double[], double)
     */
    public static boolean pairedTTest(double[] sample1, double[] sample2,
        double alpha)
        throws IllegalArgumentException, MathException {
        return T_TEST.pairedTTest(sample1, sample2, alpha);
    }

    /**
     * @see org.apache.commons.math.stat.inference.TTest#pairedTTest(double[], double[])
     */
    public static double pairedTTest(double[] sample1, double[] sample2)
        throws IllegalArgumentException, MathException {
        return T_TEST.pairedTTest(sample1, sample2);
    }

    /**
     * @see org.apache.commons.math.stat.inference.TTest#t(double, double[])
     */
    public static double t(double mu, double[] observed)
        throws IllegalArgumentException {
        return T_TEST.t(mu, observed);
    }

    /**
     * @see org.apache.commons.math.stat.inference.TTest#t(double, org.apache.commons.math.stat.descriptive.StatisticalSummary)
     */
    public static double t(double mu, StatisticalSummary sampleStats)
        throws IllegalArgumentException {
        return T_TEST.t(mu, sampleStats);
    }

    /**
     * @see org.apache.commons.math.stat.inference.TTest#t(double[], double[])
     */
    public static double t(double[] sample1, double[] sample2)
        throws IllegalArgumentException {
        return T_TEST.t(sample1, sample2);
    }

    /**
     * @see org.apache.commons.math.stat.inference.TTest#t(org.apache.commons.math.stat.descriptive.StatisticalSummary, org.apache.commons.math.stat.descriptive.StatisticalSummary)
     */
    public static double t(StatisticalSummary sampleStats1,
            StatisticalSummary sampleStats2)
        throws IllegalArgumentException {
        return T_TEST.t(sampleStats1, sampleStats2);
    }

    /**
     * @see org.apache.commons.math.stat.inference.TTest#tTest(double, double[], double)
     */
    public static boolean tTest(double mu, double[] sample, double alpha)
        throws IllegalArgumentException, MathException {
        return T_TEST.tTest(mu, sample, alpha);
    }

    /**
     * @see org.apache.commons.math.stat.inference.TTest#tTest(double, double[])
     */
    public static double tTest(double mu, double[] sample)
        throws IllegalArgumentException, MathException {
        return T_TEST.tTest(mu, sample);
    }

    /**
     * @see org.apache.commons.math.stat.inference.TTest#tTest(double, org.apache.commons.math.stat.descriptive.StatisticalSummary, double)
     */
    public static boolean tTest(double mu, StatisticalSummary sampleStats,
        double alpha)
        throws IllegalArgumentException, MathException {
        return T_TEST.tTest(mu, sampleStats, alpha);
    }

    /**
     * @see org.apache.commons.math.stat.inference.TTest#tTest(double, org.apache.commons.math.stat.descriptive.StatisticalSummary)
     */
    public static double tTest(double mu, StatisticalSummary sampleStats)
        throws IllegalArgumentException, MathException {
        return T_TEST.tTest(mu, sampleStats);
    }

    /**
     * @see org.apache.commons.math.stat.inference.TTest#tTest(double[], double[], double)
     */
    public static boolean tTest(double[] sample1, double[] sample2, double alpha)
        throws IllegalArgumentException, MathException {
        return T_TEST.tTest(sample1, sample2, alpha);
    }

    /**
     * @see org.apache.commons.math.stat.inference.TTest#tTest(double[], double[])
     */
    public static double tTest(double[] sample1, double[] sample2)
        throws IllegalArgumentException, MathException {
        return T_TEST.tTest(sample1, sample2);
    }

    /**
     * @see org.apache.commons.math.stat.inference.TTest#tTest(org.apache.commons.math.stat.descriptive.StatisticalSummary, org.apache.commons.math.stat.descriptive.StatisticalSummary, double)
     */
    public static boolean tTest(StatisticalSummary sampleStats1,
        StatisticalSummary sampleStats2, double alpha)
        throws IllegalArgumentException, MathException {
        return T_TEST.tTest(sampleStats1, sampleStats2, alpha);
    }

    /**
     * @see org.apache.commons.math.stat.inference.TTest#tTest(org.apache.commons.math.stat.descriptive.StatisticalSummary, org.apache.commons.math.stat.descriptive.StatisticalSummary)
     */
    public static double tTest(StatisticalSummary sampleStats1,
        StatisticalSummary sampleStats2)
        throws IllegalArgumentException, MathException {
        return T_TEST.tTest(sampleStats1, sampleStats2);
    }

    /**
     * @see org.apache.commons.math.stat.inference.ChiSquareTest#chiSquare(double[], long[])
     */
    public static double chiSquare(final double[] expected, final long[] observed)
        throws NotPositiveException, NotStrictlyPositiveException,
        DimensionMismatchException {
        return CHI_SQUARE_TEST.chiSquare(expected, observed);
    }

    /**
     * @see org.apache.commons.math.stat.inference.ChiSquareTest#chiSquare(long[][])
     */
    public static double chiSquare(final long[][] counts)
        throws NullArgumentException, NotPositiveException,
        DimensionMismatchException {
        return CHI_SQUARE_TEST.chiSquare(counts);
    }

    /**
     * @see org.apache.commons.math.stat.inference.ChiSquareTest#chiSquareTest(double[], long[], double)
     */
    public static boolean chiSquareTest(final double[] expected, final long[] observed,
                                        final double alpha)
        throws NotPositiveException, NotStrictlyPositiveException,
        DimensionMismatchException, OutOfRangeException, MaxCountExceededException {
        return CHI_SQUARE_TEST.chiSquareTest(expected, observed, alpha);
    }

    /**
     * @see org.apache.commons.math.stat.inference.ChiSquareTest#chiSquareTest(double[], long[])
     */
    public static double chiSquareTest(final double[] expected, final long[] observed)
        throws NotPositiveException, NotStrictlyPositiveException,
        DimensionMismatchException, MaxCountExceededException {
        return CHI_SQUARE_TEST.chiSquareTest(expected, observed);
    }

    /**
     * @see org.apache.commons.math.stat.inference.ChiSquareTest#chiSquareTest(long[][], double)
     */
    public static boolean chiSquareTest(final long[][] counts, final double alpha)
        throws NullArgumentException, DimensionMismatchException,
        NotPositiveException, OutOfRangeException, MaxCountExceededException {
        return CHI_SQUARE_TEST.chiSquareTest(counts, alpha);
    }

    /**
     * @see org.apache.commons.math.stat.inference.ChiSquareTest#chiSquareTest(long[][])
     */
    public static double chiSquareTest(final long[][] counts)
        throws NullArgumentException, DimensionMismatchException,
        NotPositiveException, MaxCountExceededException {
        return CHI_SQUARE_TEST.chiSquareTest(counts);
    }

    /**
     * @see org.apache.commons.math.stat.inference.UnknownDistributionChiSquareTest#chiSquareDataSetsComparison(long[], long[])
     *
     * @since 1.2
     */
    public static double chiSquareDataSetsComparison(final long[] observed1,
                                                     final long[] observed2)
        throws DimensionMismatchException, NotPositiveException, ZeroException {
        return CHI_SQUARE_TEST.chiSquareDataSetsComparison(observed1, observed2);
    }

    /**
     * @see org.apache.commons.math.stat.inference.UnknownDistributionChiSquareTest#chiSquareTestDataSetsComparison(long[], long[])
     *
     * @since 1.2
     */
    public static double chiSquareTestDataSetsComparison(final long[] observed1,
                                                         final long[] observed2)
        throws DimensionMismatchException, NotPositiveException, ZeroException,
        MaxCountExceededException {
        return CHI_SQUARE_TEST.chiSquareTestDataSetsComparison(observed1, observed2);
    }

    /**
     * @see org.apache.commons.math.stat.inference.UnknownDistributionChiSquareTest#chiSquareTestDataSetsComparison(long[], long[], double)
     *
     * @since 1.2
     */
    public static boolean chiSquareTestDataSetsComparison(final long[] observed1,
                                                          final long[] observed2,
                                                          final double alpha)
        throws DimensionMismatchException, NotPositiveException,
        ZeroException, OutOfRangeException, MaxCountExceededException {
        return CHI_SQUARE_TEST.chiSquareTestDataSetsComparison(observed1, observed2, alpha);
    }

    /**
     * @see org.apache.commons.math.stat.inference.OneWayAnova#anovaFValue(Collection)
     *
     * @since 1.2
     */
    public static double oneWayAnovaFValue(final Collection<double[]> categoryData)
        throws NullArgumentException, DimensionMismatchException {
        return ONE_WAY_ANANOVA.anovaFValue(categoryData);
    }

    /**
     * @see org.apache.commons.math.stat.inference.OneWayAnova#anovaPValue(Collection)
     *
     * @since 1.2
     */
    public static double oneWayAnovaPValue(final Collection<double[]> categoryData)
        throws NullArgumentException, DimensionMismatchException,
        ConvergenceException, MaxCountExceededException {
        return ONE_WAY_ANANOVA.anovaPValue(categoryData);
    }

    /**
     * @see org.apache.commons.math.stat.inference.OneWayAnova#anovaTest(Collection,double)
     *
     * @since 1.2
     */
    public static boolean oneWayAnovaTest(final Collection<double[]> categoryData,
                                          final double alpha)
        throws NullArgumentException, DimensionMismatchException,
        OutOfRangeException, ConvergenceException, MaxCountExceededException {
        return ONE_WAY_ANANOVA.anovaTest(categoryData, alpha);
    }

    // CHECKSTYLE: resume JavadocMethodCheck

}
