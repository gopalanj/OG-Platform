/**
 * Copyright (C) 2009 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.financial.fudgemsg;

import static org.junit.Assert.assertEquals;

import org.fudgemsg.FudgeMsgField;
import org.fudgemsg.types.StringFieldType;
import org.junit.Test;

import com.opengamma.financial.convention.daycount.DayCount;
import com.opengamma.financial.convention.daycount.DayCountFactory;

/**
 * Test DayCount Fudge support.
 */
public class DayCountTest extends FinancialTestBase {

  private static final DayCount s_ref = DayCountFactory.INSTANCE.getDayCount("Act/360");

  @Test
  public void testCycle() {
    assertEquals(s_ref, cycleObject(DayCount.class, s_ref));
  }

  @Test
  public void testFromString() {
    assertEquals(s_ref, getFudgeContext().getFieldValue(DayCount.class,
        FudgeMsgField.of(StringFieldType.INSTANCE, s_ref.getConventionName())));
  }

}
