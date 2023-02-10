package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.*;

public class DataUtilitiesTest {

	// Calculate Column Total
	@Test(expected = java.lang.NullPointerException.class)
	public void calculateColumnTotalForNullLessColumn() {
		// setup
		Mockery mockingContext = new Mockery(); // create a context for mocking
		final Values2D values = mockingContext.mock(Values2D.class); // create a mock for the Values2D interface
		mockingContext.checking(new Expectations() { // create exceptions for the mock
			{
				one(values).getRowCount(); // expect the getRowCount() method to be called once
				will(returnValue(2)); // and return 2
				one(values).getValue(0, 1); // expect the getValue() method to be called once with the arguments (0, 1)
				will(returnValue(7.5)); // and return 7.5
				one(values).getValue(1, 1); // expect the getValue() method to be called once with the arguments (1, 1)
				will(returnValue(2.5)); // and return 2.5
			}
		});
		double result = DataUtilities.calculateColumnTotal(null, 1); // call the method under test
		// verify
		assertEquals(result, 10.0, .000000001d); // verify that the result is 10.0
		// tear-down: NONE in this test method
	}

	@Test(expected = java.lang.NullPointerException.class)
	public void calculateColumnTotalForNullEqualZero() {
		// setup
		Mockery mockingContext = new Mockery(); // create a context for mocking
		final Values2D values = mockingContext.mock(Values2D.class); // create a mock for the Values2D interface
		mockingContext.checking(new Expectations() { // create expectations for the mock
			{
				one(values).getRowCount(); // expect the getRowCount() method to be called once
				will(returnValue(2)); // and return 2
				one(values).getValue(0, 0); // expect the getValue() method to be called once with the arguments (0, 0)
				will(returnValue(12.54)); // and return 12.54
				one(values).getValue(1, 0); // expect the getValue() method to be called once with the arguments (1, 0)
				will(returnValue(27.46)); // and return 27.46
			}
		});
		double result = DataUtilities.calculateColumnTotal(null, 0); // call the method under test
		// verify
		assertEquals(result, 30.0, .000000001d); // verify that the result is 30.0
		// tear-down: NONE in this test method
	}

	@Test(expected = java.lang.NullPointerException.class)
	public void calculateColumnTotalForNullLargeColumn() {
		// setup
		Mockery mockingContext = new Mockery(); // create a context for mocking
		final Values2D values = mockingContext.mock(Values2D.class); // create a mock for the Values2D interface
		mockingContext.checking(new Expectations() { // create expectations for the mock
			{
				one(values).getRowCount(); // expect the getRowCount() method to be called once
				will(returnValue(2)); // and return 2
				one(values).getValue(0, 0); // expect the getValue() method to be called once with the arguments (0, 0)
				will(returnValue(12.54)); // and return 12.54
				one(values).getValue(1, 0); // expect the getValue() method to be called once with the arguments (1, 0)
				will(returnValue(27.46)); // and return 27.46
			}
		});
		double result = DataUtilities.calculateColumnTotal(null, 5); // call the method under test
		// verify
		assertEquals(result, 30.0, .000000001d); // verify that the result is 30.0
		// tear-down: NONE in this test method
	}

	@Test(expected = java.lang.NullPointerException.class) // test for null values
	public void calculateColumnTotalForNullLowerZero() { // test for negative column
		// setup
		Mockery mockingContext = new Mockery(); // create a context for mocking
		final Values2D values = mockingContext.mock(Values2D.class); // create a mock for the Values2D interface
		mockingContext.checking(new Expectations() { // create exceptions for mock
			{
				one(values).getRowCount(); // expect the getRowCount() method to be called once
				will(returnValue(2)); // and return 2
				one(values).getValue(0, 0); // expect the getValue() method to be called once with the arguments (0, 0)
				will(returnValue(12.54)); // and return 12.54
				one(values).getValue(1, 0); // expect the getValue() method to be called once with the arguments (1, 0)
				will(returnValue(27.46)); // and return 27.46
			}
		});
		double result = DataUtilities.calculateColumnTotal(null, -1); // call the method under test
		// verify
		assertEquals(result, 40.0, .000000001d); // verify that the result is 40.0
		// tear-down: NONE in this test method
	}

	@Test
	public void calculateColumnTotalNominalValue() {
		// setup
		Mockery mockingContext = new Mockery(); // create a context for mocking
		final Values2D values = mockingContext.mock(Values2D.class); // create a mock for the Values2D interface
		mockingContext.checking(new Expectations() { // create exceptions for the mock
			{
				one(values).getRowCount(); // expect the getRowCount() method to be called once
				will(returnValue(4)); // and return 4
				one(values).getValue(0, 5); // expect the getValue() method to be called once with the arguments (0, 5)
				will(returnValue(11.23)); // and return 11.23
				one(values).getValue(1, 5); // expect the getValue() method to be called once with the arguments (1, 5)
				will(returnValue(12.76)); // and return 12.76
				one(values).getValue(2, 5); // expect the getValue() method to be called once with the arguments (2, 5)
				will(returnValue(52.5)); // and return 52.5
				one(values).getValue(3, 5); // expect the getValue() method to be called once with the arguments (3, 5)
				will(returnValue(48.5)); // and return 48.5
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 5); // call the method under test
		// verify
		assertEquals(result, 124.99, .000000001d);
		// tear-down: NONE in this test method
	}

	@Test
	public void calculateColumnValidListAboveZero() {
		// setup
		Mockery mockingContext = new Mockery(); // create a context for mocking
		final Values2D values = mockingContext.mock(Values2D.class); // create a mock for the Values2D interface
		mockingContext.checking(new Expectations() { // create exceptions for the mock
			{
				one(values).getRowCount(); // expect the getRowCount() method to be called once
				will(returnValue(4)); // and return 4
				one(values).getValue(0, 1); // expect the getValue() method to be called once with the arguments (0, 1)
				will(returnValue(12.54)); // and return 12.54
				one(values).getValue(1, 1); // expect the getValue() method to be called once with the arguments (1, 1)
				will(returnValue(27.46)); // and return 27.46
				one(values).getValue(2, 1); // expect the getValue() method to be called once with the arguments (2, 1)
				will(returnValue(12.54)); // and return 12.54
				one(values).getValue(3, 1); // expect the getValue() method to be called once with the arguments (3, 1)
				will(returnValue(27.46)); // and return 27.46
				one(values).getValue(0, 4);
				will(returnValue(11.23));
				one(values).getValue(1, 4);
				will(returnValue(12.76));
				one(values).getValue(2, 4);
				will(returnValue(52.5));
				one(values).getValue(3, 4);
				will(returnValue(48.5));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 1); // call the method under test
		// verify
		assertEquals(80, result, .000000001d);
		// tear-down: NONE in this test method
	}

	@Test(expected = java.lang.NullPointerException.class)
	public void calculateColumnValidListBelowZero() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(2));
				one(values).getValue(0, -3);
				will(returnValue(64));
				one(values).getValue(1, -3);
				will(returnValue(32));

			}
		});
		double result = DataUtilities.calculateColumnTotal(values, -3);
		// verify
		assertEquals(96, result, .000000001d);
		// tear-down: NONE in this test method
	}

	@Test
	public void calculateColumnValidListAboveColumns() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(2));
				one(values).getValue(0, 3);
				will(returnValue(64));
				one(values).getValue(1, 3);
				will(returnValue(32));

			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 15);
		// verify
		assertEquals(0, result, .000000001d);
		// tear-down: NONE in this test method
	}

	// Calculate Row Total

	@Test(expected = java.lang.NullPointerException.class)
	public void calculateRowTotalForNullLessRow() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(2));
				one(values).getValue(1, 0);
				will(returnValue(7.5));
				one(values).getValue(1, 1);
				will(returnValue(2.5));
			}
		});
		double result = DataUtilities.calculateRowTotal(null, 2);
		// verify
		assertEquals(result, 10.0, .000000001d);
		// tear-down: NONE in this test method
	}

	@Test(expected = java.lang.NullPointerException.class)
	public void calculateRowTotalForNullAtZero() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(3));
				one(values).getValue(0, 0);
				will(returnValue(12.54));
				one(values).getValue(0, 1);
				will(returnValue(27.46));
				one(values).getValue(0, 2);
				will(returnValue(-27.46));
			}
		});
		double result = DataUtilities.calculateColumnTotal(null, 0);
		// verify
		assertEquals(result, 30.0, .000000001d);
		// tear-down: NONE in this test method
	}

	@Test(expected = java.lang.NullPointerException.class)
	public void calculateColumnTotalForNullLargeRow() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(2));
				one(values).getValue(0, 0);
				will(returnValue(12.54));
				one(values).getValue(0, 1);
				will(returnValue(27.46));
			}
		});
		double result = DataUtilities.calculateRowTotal(null, 6);
		// verify
		assertEquals(result, 30.0, .000000001d);
		// tear-down: NONE in this test method
	}

	@Test(expected = java.lang.NullPointerException.class)
	public void calculateRowTotalForNullLowerZero() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(2));
				one(values).getValue(-1, 0);
				will(returnValue(12.54));
				one(values).getValue(-1, 1);
				will(returnValue(27.46));
			}
		});
		double result = DataUtilities.calculateRowTotal(null, -1);
		// verify
		assertEquals(result, 40.0, .000000001d);
		// tear-down: NONE in this test method
	}

	@Test
	public void calculateRowTotalNominalValue() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(2));
				one(values).getValue(3, 0);
				will(returnValue(11));
				one(values).getValue(3, 1);
				will(returnValue(12));

			}
		});
		double result = DataUtilities.calculateRowTotal(values, 0);
		// verify
		assertEquals(23, result, .000000001d);
		// tear-down: NONE in this test method
	}

	@Test
	public void calculateRowValidListAboveZero() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(2));
				one(values).getValue(0, 0);
				will(returnValue(10.0));
				one(values).getValue(0, 1);
				will(returnValue(20.0));

			}
		});
		double result = DataUtilities.calculateRowTotal(values, 0);
		// verify
		assertEquals(30, result, .000000001d);
		// tear-down: NONE in this test method
	}

	@Test
	public void calculateRowValidListBelowZero() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(2));
				one(values).getValue(-1, 0);
				will(returnValue(10.0));
				one(values).getValue(-1, 1);
				will(returnValue(20.0));

			}
		});
		double result = DataUtilities.calculateRowTotal(values, -1);
		// verify
		assertEquals(0, result, .000000001d);
		// tear-down: NONE in this test method
	}

	@Test
	public void calculateRowValidListAboveRow() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(2));
				one(values).getValue(1, 0);
				will(returnValue(10.0));
				one(values).getValue(1, 1);
				will(returnValue(20.0));

			}
		});
		double result = DataUtilities.calculateRowTotal(values, 100);
		// verify
		assertEquals(0, result, .000000001d);
		// tear-down: NONE in this test method
	}

	// Create Number Array

	@Test(expected = IllegalArgumentException.class)
	public void createNumberArrayNull() {
		// setup
		double testArr[] = null;
		Number result[] = DataUtilities.createNumberArray(testArr);
		// verify
		// tear-down: NONE in this test method
	}

	@Test
	public void createNumberArrayPositive() {
		// setup
		double testArr[] = { 1.0, 2.3, 3.45, 4.78 };
		Number result[] = DataUtilities.createNumberArray(testArr);
		Number expected[] = { 1.0, 2.3, 3.45, 4.78 };
		// verify
		assertArrayEquals("Elements in both arrays should be the same", expected, result);
		// tear-down: NONE in this test method
	}

	@Test
	public void createNumberArrayNegative() {
		// setup
		double testArr[] = { -1.0, -2.3, -3.45, -4.78 };
		Number result[] = DataUtilities.createNumberArray(testArr);
		Number expected[] = { -1.0, -2.3, -3.45, -4.78 };
		// verify
		assertArrayEquals("Elements in both arrays should be the same", expected, result);
		// tear-down: NONE in this test method
	}

	@Test
	public void createNumberArrayPositiveNegative() {
		// setup
		double testArr[] = { -1.0, 2.3, -3.45, 4.78 };
		Number result[] = DataUtilities.createNumberArray(testArr);
		Number expected[] = { -1.0, 2.3, -3.45, 4.78 };
		// verify
		assertArrayEquals("Elements in both arrays should be the same", expected, result);
		// tear-down: NONE in this test method
	}

	@Test
	public void createNumberArrayZero() {
		// setup
		double testArr[] = { 0 };
		Number result[] = DataUtilities.createNumberArray(testArr);
		Number expected[] = { 0 };
		// verify
		assertArrayEquals("Elements in both arrays should be the same", expected, result);
		// tear-down: NONE in this test method
	}

	// Create Number Array 2D
	@Test(expected = IllegalArgumentException.class)
	public void create2DNumberArrayNull() {
		// setup
		double testArr[][] = null;
		Number result[][] = DataUtilities.createNumberArray2D(testArr);
		// verify
		// tear-down: NONE in this test method
	}

	@Test
	public void create2DNumberArrayPositive() {
		// setup
		double testArr[][] = { { 1, 2, 3, 4 }, { 2.5, 4.6, 6.8, 8.10 } };
		Number result[][] = DataUtilities.createNumberArray2D(testArr);
		Number expected[][] = { { 1.0, 2.0, 3.0, 4.0 }, { 2.5, 4.6, 6.8, 8.10 } };
		// verify
		assertArrayEquals("Elements in both arrays should be the same", expected, result);
		// tear-down: NONE in this test method
	}

	@Test
	public void create2DNumberArrayNegative() {
		// setup
		double testArr[][] = { { -1, -2, -3, -4 }, { -2.5, -4.6, -6.8, -8.10 } };
		Number result[][] = DataUtilities.createNumberArray2D(testArr);
		Number expected[][] = { { -1.0, -2.0, -3.0, -4.0 }, { -2.5, -4.6, -6.8, -8.10 } };
		// verify
		assertArrayEquals("Elements in both arrays should be the same", expected, result);
		// tear-down: NONE in this test method
	}

	@Test
	public void create2DNumberArrayPositiveNegative() {
		// setup
		double testArr[][] = { { -1, 2, -3, 4 }, { 2.5, -4.6, 6.8, -8.10 } };
		Number result[][] = DataUtilities.createNumberArray2D(testArr);
		Number expected[][] = { { -1.0, -2.0, -3.0, -4.0 }, { -2.5, -4.6, -6.8, -8.10 } };
		// verify
		assertArrayEquals("Elements in both arrays should be the same", expected, result);
		// tear-down: NONE in this test method
	}

	@Test
	public void create2DNumberArrayPositiveZero() {
		// setup
		double testArr[][] = { { 0 } };
		Number result[][] = DataUtilities.createNumberArray2D(testArr);
		Number expected[][] = { { 0 } };
		// verify
		assertArrayEquals("Elements in both arrays should be the same", expected, result);
		// tear-down: NONE in this test method
	}

	// getCumulativePercentages
	@Test
	public void getCumulativePercentsNominal() {
		// setup
		Mockery mockingContext = new Mockery();
		final KeyedValues values = mockingContext.mock(KeyedValues.class);
		mockingContext.checking(new Expectations() {
			{
				atLeast(1).of(values).getItemCount();
				will(returnValue(3));

				atLeast(1).of(values).getKey(0);
				will(returnValue(0));
				atLeast(1).of(values).getKey(1);
				will(returnValue(1));
				atLeast(1).of(values).getKey(2);
				will(returnValue(2));

				atLeast(1).of(values).getValue(0);
				will(returnValue(5));
				atLeast(1).of(values).getValue(1);
				will(returnValue(9));
				atLeast(1).of(values).getValue(2);
				will(returnValue(2));

			}
		});
		KeyedValues result = DataUtilities.getCumulativePercentages(values);

		DefaultKeyedValues expected = new DefaultKeyedValues();
		Integer keyA = 0;
		Integer keyB = 1;
		Integer keyC = 2;

		expected.addValue(keyA, 0.3125);
		expected.addValue(keyB, 0.875);
		expected.addValue(keyC, 1.0);
		// verify
		assertEquals(expected, result);
		// tear-down: NONE in this test method
	}

	@Test(expected = IllegalArgumentException.class)
	public void getCumulativePercentsNull() {
		// setup
		KeyedValues result = DataUtilities.getCumulativePercentages(null);

	}

	@Test
	public void getCumulativePercentsNegative() {
		// setup
		Mockery mockingContext = new Mockery();
		final KeyedValues values = mockingContext.mock(KeyedValues.class);
		mockingContext.checking(new Expectations() {
			{
				atLeast(1).of(values).getItemCount();
				will(returnValue(3));

				atLeast(1).of(values).getKey(0);
				will(returnValue(0));
				atLeast(1).of(values).getKey(1);
				will(returnValue(1));
				atLeast(1).of(values).getKey(2);
				will(returnValue(2));

				atLeast(1).of(values).getValue(0);
				will(returnValue(-5));
				atLeast(1).of(values).getValue(1);
				will(returnValue(-9));
				atLeast(1).of(values).getValue(2);
				will(returnValue(-2));

			}
		});
		KeyedValues result = DataUtilities.getCumulativePercentages(values);

		DefaultKeyedValues expected = new DefaultKeyedValues();
		Integer keyA = 0;
		Integer keyB = 1;
		Integer keyC = 2;

		expected.addValue(keyA, 0.3125);
		expected.addValue(keyB, 0.875);
		expected.addValue(keyC, 1.0);
		// verify
		assertEquals(expected, result);
		// tear-down: NONE in this test method
	}

	@Test
	public void getCumulativePercentsZero() {
		// setup
		Mockery mockingContext = new Mockery();
		final KeyedValues values = mockingContext.mock(KeyedValues.class);
		mockingContext.checking(new Expectations() {
			{
				atLeast(1).of(values).getItemCount();
				will(returnValue(3));

				atLeast(1).of(values).getKey(0);
				will(returnValue(0));
				atLeast(1).of(values).getKey(1);
				will(returnValue(1));
				atLeast(1).of(values).getKey(2);
				will(returnValue(2));

				atLeast(1).of(values).getValue(0);
				will(returnValue(0));
				atLeast(1).of(values).getValue(1);
				will(returnValue(0));
				atLeast(1).of(values).getValue(2);
				will(returnValue(0));

			}
		});
		KeyedValues result = DataUtilities.getCumulativePercentages(values);

		DefaultKeyedValues expected = new DefaultKeyedValues();
		Integer keyA = 0;
		Integer keyB = 1;
		Integer keyC = 2;

		expected.addValue(keyA, 0);
		expected.addValue(keyB, 0);
		expected.addValue(keyC, 0);
		// verify
		assertEquals(expected, result);
		// tear-down: NONE in this test method
	}

}
