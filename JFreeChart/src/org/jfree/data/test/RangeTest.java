package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTest {
    private Range exampleRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { exampleRange = new Range(-10, 20);
    }

    //Intersect Tests

    @Test
    public void intersectNormalTest() {
    	
        assertTrue("The statement should be true", exampleRange.intersects(1,5));
    }
    
    @Test
    public void intersectBoundaryTest() {
    	
        assertTrue("The statement should be true", exampleRange.intersects(1,1));
    }
    
    @Test
    public void intersectAboveUpperTest() {
    	
        assertTrue("The statement should be true", exampleRange.intersects(1,2));
    }
    
    @Test
    public void intersectLowerUpperTest() {
    	
        assertFalse("The statement should be false", exampleRange.intersects(1,0));
    }
    
    @Test
    public void intersectFailLowerTest() {
    	
        assertFalse("The statement should be false", exampleRange.intersects(5,0));
    }
    
    //Shift Tests
    
    @Test
    public void shiftValidPositive() {
    	Range shiftRange = new Range(-10,15);
    	shiftRange = Range.shift(shiftRange, 12.5);
        assertEquals("The Upperbound should be 2.5",
        2.5, shiftRange.getLowerBound(), .000000001d);
    }
    
    @Test
    public void shiftValidZero() {
    	Range shiftRange = new Range(-10,15);
    	shiftRange = Range.shift(shiftRange,0);
        assertEquals("The Upperbound should be -10",
        -10, shiftRange.getLowerBound(), .000000001d);
    }
    
    @Test
    public void shiftValidNegative() {
    	Range shiftRange = new Range(-10,15);
    	shiftRange = Range.shift(shiftRange,-22.6);
        assertEquals("The Upperbound should be -32.6",
        -32.6, shiftRange.getLowerBound(), .000000001d);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void shiftPositive() {
    	Range shiftRange = new Range(-10,15);
    	shiftRange = Range.shift(null,15);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void shiftNullZero() {
    	Range shiftRange = new Range(-10,15);
    	shiftRange = Range.shift(null,0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void combineNullNegative() {
    	Range shiftRange = new Range(-10,15);
    	shiftRange = Range.shift(null,-22.6);
    	assertEquals("The Range Should Return NULL", shiftRange.getLowerBound());
    }
    
    //Contains test
    
    @Test
    public void containsBelowLowerBound() {
        assertFalse("Number is out of Range", exampleRange.contains(-11));
    }
    
    @Test
    public void containLowerBound() {
        assertTrue("Number is in Range", exampleRange.contains(-10));
    }
    
    @Test
    public void containAboveLowerBound() {
        assertTrue("Number is in Range", exampleRange.contains(-9.67));
    }

    @Test
    public void containNominal() {
        assertTrue("Number is in Range", exampleRange.contains(5.21));
    }

    @Test
    public void containBelowUpperBound() {
        assertTrue("Number is in Range", exampleRange.contains(19.934));
    }
    
    @Test
    public void containUpperBound() {
        assertTrue("Number is in Range", exampleRange.contains(20));
    }
    
    @Test
    public void containAboveUpperBound() {
        assertFalse("Number is out of Range", exampleRange.contains(21));
    }
    
    //Combine Test
 
    @Test
    public void TestNullAndValidLowerBound() {
    	Range range = Range.combine(null, new Range(2,4));
    	double lower_bound = range.getLowerBound();
    	assertEquals("Expected lower bound is 2.0. Actual lower bound is " + lower_bound, 2.0 , lower_bound,.000000001d);
    }
    //null + 2-4 = 2-4
    @Test
    public void TestNullAndValidUpperBound() {
    	Range range = Range.combine(null, new Range(2,4));
    	double upper_bound = range.getUpperBound();
    	assertEquals("Expected upper bound is 4.0. Actual upper bound is " + upper_bound, 4.0 , upper_bound,.000000001d);
    }
    // Upper bound does not operate correctly
    @Test
    public void TestValidAndNullLowerBound() {
    	Range range = Range.combine(new Range(2,4), null);
    	double lower_bound = range.getLowerBound();
    	assertEquals("Expected lower bound is 2.0. Actual lower bound is " + lower_bound, 2.0, lower_bound,.000000001d);
    }
    // 2-4 + null = 2-4
    @Test
    public void TestValidAndNullUpperBound() {
    	Range range = Range.combine(new Range(2,4), null);
    	double upper_bound = range.getUpperBound();
    	assertEquals("Expected lower bound is 4.0. Actual lower bound is " + upper_bound, 4.0, upper_bound,.000000001d);
    }
    //Upper Bound not operating correctly
    
    @Test (expected = java.lang.NullPointerException.class)
    public void TestNullAndNullLowerBound() {
    	Range range = Range.combine(null, null);
    	double lower_bound = range.getLowerBound();
    	assertNull("Expected lower bound is null. Actual lower bound is ", lower_bound);
    }
    // null + null = null
    
    @Test (expected = java.lang.NullPointerException.class)
    public void TestNullAndNullUpperBound() {
    	Range range = Range.combine(null, null);
    	double upper_bound = range.getUpperBound();
    	assertNull("Expected upper bound is null. Actual upper bound is ", upper_bound);
    }
    // works because upper bound obtains same value as lower bound
    //Expand to Include Test

    @Test
    public void TestValueInRangeLowerBound() {
    	Range range = Range.expandToInclude(new Range(1, 10), 5);
    	double value_in_range = range.getLowerBound();
    	assertEquals("Expected lower bound is 1.0. Actual lower bound is " + value_in_range, 1.0, value_in_range,.000000001d);
    }

    @Test
    public void TestValueInRangeUpperBound() {
    	Range range = Range.expandToInclude(new Range(1, 10), 5);
    	double value_in_range = range.getUpperBound();
    	assertEquals("Expected upper bound is 10.0. Actual upper bound is " + value_in_range, 10.0, value_in_range,.000000001d);
    }

    @Test
    public void TestValueGreaterThanMaxLowerBound() {
    	Range range = Range.expandToInclude(new Range(1, 10), 12);
    	double value_in_range = range.getLowerBound();
    	assertEquals("Expected lower bound is 1.0. Actual lower bound is " + value_in_range, 1.0, value_in_range,.000000001d);
    }

    @Test
	public void TestValueGreaterThanMaxUpperBound() {
		Range range = Range.expandToInclude(new Range(1, 10), 12);
		double value_in_range = range.getUpperBound();
		assertEquals("Expected upper bound is 12.0. Actual upper bound is " + value_in_range, 12.0, value_in_range,.000000001d);
	}

	@Test
	public void TestValueLessThanMinLowerBound() {
	Range range = Range.expandToInclude(new Range(5, 10), 2);
	double value_in_range = range.getLowerBound();
	assertEquals("Expected lower bound is 2.0. Actual lower bound is " + value_in_range, 2.0, value_in_range,.000000001d);
	}

	@Test
	public void TestValueLessThanMinUpperBound() {
	Range range = Range.expandToInclude(new Range(5, 10), 2);
	double value_in_range = range.getUpperBound();
	assertEquals("Expected upper bound is 10.0. Actual upper bound is " + value_in_range, 10.0, value_in_range,.000000001d);
	}

	@Test
	public void TestNullRangeValueUpperBound() {
	Range n_range = null;
	Range range = Range.expandToInclude(n_range, 5);
	double upper_bound = range.getUpperBound();
	assertEquals("Expected upper bound is 5.0. Actual upper bound is " + upper_bound, 5.0, upper_bound,.000000001d);
	}

	@Test
	public void TestNullRangeValueLowerBound() {
	Range n_range = null;
	Range range = Range.expandToInclude(n_range, 5);
	double lower_bound = range.getLowerBound();
	assertEquals("Expected lower bound is 5.0. Actual lower bound is " + lower_bound, 5.0, lower_bound,.000000001d);
	}

	@Test 
	public void TestNegativeValueLowerBound() {
	Range range = Range.expandToInclude(new Range(2,5), -1);
	double lower_bound = range.getLowerBound();
	assertEquals("Expected lower bound is -1.0. Actual lower bound is " + lower_bound, -1.0, lower_bound,.000000001d);
	}

	@Test 
	public void TestNegativeValueUpperBound() {
		Range range = Range.expandToInclude(new Range(2,5), -1);
		double upper_bound = range.getUpperBound();
		assertEquals("Expected upper bound is 5.0. Actual upper bound is " + upper_bound, 5.0, upper_bound,.000000001d);
	}

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}