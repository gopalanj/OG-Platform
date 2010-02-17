/**
 * Copyright (C) 2009 - 2010 by OpenGamma Inc.
 * 
 * Please see distribution for license.
 */
package com.opengamma.financial.var;

import static org.junit.Assert.assertEquals;

import java.util.Collections;

import org.junit.Test;

import cern.colt.matrix.DoubleFactory1D;
import cern.colt.matrix.DoubleFactory2D;
import cern.colt.matrix.DoubleMatrix1D;
import cern.colt.matrix.DoubleMatrix2D;

import com.opengamma.financial.sensitivity.Sensitivity;
import com.opengamma.math.function.Function1D;

/**
 * @author emcleod
 * 
 */
public class DeltaMeanCalculatorTest {
  private static final Function1D<ParametricWithMeanVaRDataBundle, Double> F = new DeltaMeanCalculator();
  private static final DoubleMatrix1D EMPTY_VECTOR = DoubleFactory1D.dense.make(0);
  private static final DoubleMatrix1D VECTOR = DoubleFactory1D.dense.make(new double[] { 3 });
  private static final DoubleMatrix2D EMPTY_MATRIX = DoubleFactory2D.dense.make(0, 0);

  @Test(expected = IllegalArgumentException.class)
  public void testNullData() {
    F.evaluate((ParametricWithMeanVaRDataBundle) null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEmptyValueDeltaVector() {
    final ParametricWithMeanVaRDataBundle data = new ParametricWithMeanVaRDataBundle(Collections.<Sensitivity, DoubleMatrix1D> singletonMap(Sensitivity.VALUE_DELTA, VECTOR),
        Collections.<Sensitivity, DoubleMatrix1D> singletonMap(Sensitivity.VALUE_DELTA, EMPTY_VECTOR), Collections.<Sensitivity, DoubleMatrix2D> singletonMap(
            Sensitivity.VALUE_DELTA, EMPTY_MATRIX));
    F.evaluate(data);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEmptyMeanVector() {
    final ParametricWithMeanVaRDataBundle data = new ParametricWithMeanVaRDataBundle(Collections.<Sensitivity, DoubleMatrix1D> singletonMap(Sensitivity.VALUE_DELTA, EMPTY_VECTOR),
        Collections.<Sensitivity, DoubleMatrix1D> singletonMap(Sensitivity.VALUE_DELTA, VECTOR), Collections.<Sensitivity, DoubleMatrix2D> singletonMap(Sensitivity.VALUE_DELTA,
            EMPTY_MATRIX));
    F.evaluate(data);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testDifferentVectorSizes() {
    final DoubleMatrix1D v = DoubleFactory1D.dense.make(new double[] { 3., 4. });
    final ParametricWithMeanVaRDataBundle data = new ParametricWithMeanVaRDataBundle(Collections.<Sensitivity, DoubleMatrix1D> singletonMap(Sensitivity.VALUE_DELTA, v),
        Collections.<Sensitivity, DoubleMatrix1D> singletonMap(Sensitivity.VALUE_DELTA, VECTOR), Collections.<Sensitivity, DoubleMatrix2D> singletonMap(Sensitivity.VALUE_DELTA,
            EMPTY_MATRIX));
    F.evaluate(data);
  }

  @Test
  public void test() {
    final ParametricWithMeanVaRDataBundle data = new ParametricWithMeanVaRDataBundle(Collections.<Sensitivity, DoubleMatrix1D> singletonMap(Sensitivity.VALUE_DELTA, VECTOR),
        Collections.<Sensitivity, DoubleMatrix1D> singletonMap(Sensitivity.VALUE_DELTA, VECTOR), Collections.<Sensitivity, DoubleMatrix2D> singletonMap(Sensitivity.VALUE_DELTA,
            EMPTY_MATRIX));
    assertEquals(F.evaluate(data), 9, 1e-9);
  }
}
