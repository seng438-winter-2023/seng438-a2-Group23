**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group \#:      |  23   |
| -------------- | --- |
| Student Names: | Hamza Niaz    |
|                | Bilal Pasha    |
|                | Issam Akthar    |
|                | Yousef Hammad    |

# 1 Introduction

In this lab assignment, we are going to create automated tests using JUnit and other testing frameworks such as NUnit with a black box testing approach. The classes that we will be writing JUnit tests for are from the jfreechart.jar, specifically the Range.class and the DataUtilities.class whose details were provided in the given JavaDoc for this assignment. This assignment was split into multiple phases. In the first phase, we had to familiarize ourselves with automated unit testing using JUnit. This involves preparing the setup to begin testing, as well as learning the functionalities and navigation through the Eclipse IDE. In the second phase, we began to develop the unit test code for methods within the classes, beginning with the Range.class file. Unit tests will be created for several classes, while testing them against their specifications, which are explained in the JavaDoc file. The 5 methods that we chose for org.jfree.data.Range were intersect, shift, expandToInclude, contains and combine. For the DataUtilites.class, mocking is used to generate objects required for testing methods and exceptions in order to simulate tests. Overall, the lab will cover using Eclipse and writing unit tests via mocking.

# 2 Detailed description of unit test strategy

In the org.jfree.data.Range, we decided to perform unit testing on the following 5 methods. Those 5 methods include intersect, shift, expandToInclude, contains and combine. To understand the functionality of these methods, we began with studying the Javadoc file for the org.jfree.data.Rage class. Once we were familiar with the functionality of each method, it was straightforward to write the unit tests. For the methods that we tested, we tried to use the best case equivalence class testing. The constructor for the range class takes in two integers and make a range based on the lower and upper bound, aka the two integer arguments. Below are all the function that we tested and the way we tested them.



Tests done in the Range class:



Combine(Range range1, Range range2): The combine function takes in two Range objects and returns a Range object. The returned Range object is created by combining the two existing ranges given in the argument. We tested this method by passing a combination of null ranges, positive ranges, negative ranges, and zero ranges. 

ExpandToInclude(Range range, double value): The expand to include function takes in one range object and a double value. It returns a new range that includes the given value argument in it if it was not included in the original range. We tested this method by passing a combination of null range, positive range, negative range, and zero range. As for the value, we tested it with 0, value above the max, and value below the min.

Intersects(double lower, double upper): The intersects function was tested with equivalence class testing. The functions take in two double values and return true if the range intersects with the specified range, and false otherwise. We tested this function with valid bounds where the lower bound is less than or equal to the upper bound. We also tested this function with invalid values such as the lower bound being greater than the upper bound and boundaries that contain 0.

Shift(Range base, double delta): The shift function was tested with equivalence class testing. It takes a range object and a double value. It returns a range the size of the input range, which has been moved positively by the double value. We tested this method by passing valid range, null range, positive number for delta, negative number for delta, and 0 for delta.
Contains(double value): The contains function was tested with equivalence class testing. It takes in a double value to check if it is contained in a range. This function returns true if the value is within the range and false other wise. Testing this method was straightforward. We tested this function with the lower bound – 1, lower bound, lower bound + 1, numbers between the lower and upper bound, upper bound – 1, upper bound, and upper bound + 1.



Tests done in the DataUtilities class:



calculateColumnTotal(Values2D values, int column): This function takes in a Values2D object and an integer for the column number as arguments. It returns the sum of the values in one column of the supplied data table. With invalid input, a total of zero will be returned. To test this function, we performed equivalence class testing. We split the tests into two classes. One class includes null values, and the other class includes positive and negative numbers. We wanted to make sure that the function performs as intended for all the possible values. 

calculateRowTotal(Values2D values, int row): This function takes in a Values2D object and an integer for the row number as arguments. It returns the sum of the values in one row of the supplies data table. With invalid input, a total of zero will be returned. To test this function, we performed equivalence class testing. We did two equivalence classes that include null values as the first class and positive and negative values as the second class. We wanted to make sure that the functions work for all three of these inputs. We wanted to ensure that select a row as well as summing the values was tested.

CreateNumberArray(double[] data): This function takes in a array of doubles and it constructs an array of Number objects from an array of double primitives. To test this function, we had two equivalence class to thoroughly tests its functionality. The first class consists of null data where we checked for proper exception handling and the other class consists of positive and negative data. The class that contained positive and negative checks if the number array matches the double array we provided the function. With testing null, positive, and negative values, we cover all the possible combination of values for this function.  

CreateNumberArray2D(double[][] data): This function takes in a 2D array of doubles and it constructs an array of Number objects from an array of double primitives. To test this function, we had two equivalence class to thoroughly tests its functionality. The first class consists of null data where we checked for proper exception handling and the other class consists of positive and negative data. The class that contained positive and negative checks if the number of the 2D array matches the double 2D array we provided the function. With testing null, positive, and negative values, we cover all the possible combination of values for this function.  

GetCumulativePercentages(KeyedValues data): This function takes in a KeyedValue object and returns a KeyedValue instance that contains the cumulative percentage values for the data in another KeyedValues instance. The cumulative percentage is each value’s cumulative portion of the sum of all values. To test this function, we had two equivalence classes. The first classes consisted of null values, and it was to test proper exception handling. The second class we check that the expected cumulative percentages match the values calculated by the method under test.


# 3 Test cases developed
## Tests cases for the Range Class Methods
Partitions for Intersect Method:
- C1: The lower bound is less than or equal to the upper bound.
- C2: The lower bound is greater than the upper bound.
- C3: The upper bound is greater than or equal to the lower bound.
- C4: The upper bound is less than the lower bound.

| Class Name | Method Name             | Input Values | Relevant Conditions | Pass/Fail Criteria |
|------------|-------------------------|--------------|---------------------|--------------------|
| Range      | intersectNormalTest     | (1, 5)       | C1, C3              | Pass               |
| Range      | intersectBoundryTest    | (1, 1)       | C1, C3              | Pass               |
| Range      | intersectAboveUpperTest | (1, 2)       | C1, C3              | Pass               |
| Range      | intersectBelowLowerTest | (1, 0)       | C4                  | Pass               |
| Range      | intersectFailLowerTest | (5, 0)       | C2                  | Pass               |

Partitions for Shift Method:
- C1: The range is valid.
- C2: The range is null.
- C3: The value is positive.
- C4: The value is zero.
- C5: The value is negative.

| Class Name | Method Name             | Input Values | Relevant Conditions | Pass/Fail Criteria |
|------------|-------------------------|--------------|---------------------|--------------------|
| Range      | shiftValidPositive     | (Valid, 12.5)       | C1, C3              | Pass               |
| Range      | shiftValidZero    | (Valid, 0)       | C1, C5              | Pass               |
| Range      | shiftValidNegative | (Valid, -22.6)       | C1, C3              | Pass               |
| Range      | shiftPositive | (Null, 15)       | C2, C4                  | Pass               |
| Range      | shiftNullNegative | (Null, -22.6)       | C2, C6                  | Pass               |

Partitions for ExpandToInclude Method:
- C1: The range is valid.
- C2: The range is null.
- C3: The value is above the upper bound.
- C4: The value is below the lower bound.
- C5: The value is between the bounds.

| Class Name | Method Name             | Input Values | Relevant Conditions | Pass/Fail Criteria |
|------------|-------------------------|--------------|---------------------|--------------------|
| Range      | TestValueInRangeLowerBound     | (Valid, 5)       | C1, C5              | Pass               |
| Range      | TestValueInRangeUpperBound    | (Valid, 5)       | C1, C5              | Fail               |
| Range      | TestValueGreaterThanMaxLowerBound | (Valid, 12)       | C1, C3              | Pass               |
| Range      | TestValueGreaterThanMaxUpperBound | (Valid, 12)       | C1, C3                  | Fail               |
| Range      | TestValueLessThanMinUpperBound | (Valid, 2)       | C1, C4                  | Fail               |
| Range      | TestValueLessThanMinUpperBound | (Valid, 2)       | C1, C4              | Fail               |
| Range      | TestNullRangeValueUpperBound | (Null, 5)       | C2                  | Pass               |
| Range      | TestNullRangeValueLowerBound | (Null, 5)       | C2                  | Pass               |
| Range      | TestNegativeValueLowerBound     | (Valid, -1)       | C1, C4              | Fail               |
| Range      | TestNegativeValueUpperBound    | (Valid, -1)       | C1, C4              | Fail               |

Partitions for Contains Method:
- C1: A value just below the lower bound (BLB).
- C2: The value on the lower boundary (LB).
- C3: A value just above the lower boundary (ALB).
- C4: A nominal value (NOM).
- C5: A value just below the upper bound (BUB).
- C6: The value on the upper bound (UB).
- C7: A value just above the upper bound (AUB).

| Class Name | Method Name             | Input Values | Relevant Conditions | Pass/Fail Criteria |
|------------|-------------------------|--------------|---------------------|--------------------|
| Range      | containsBelowLowerBound     | (-11)       | C1              | Fail               |
| Range      | containLowerBound    | (-10)      | C2              | Pass               |
| Range      | containAboveLowerBound | (-9.67)       | C3              | Pass               |
| Range      | containNominal | (5.21)      | C4                  | Pass               |
| Range      | containBelowUpperBound | (19.934)       | C5                  | Pass               |
| Range      | containUpperBound | (20)       | C6            | Pass               |
| Range      | containAboveUpperBound | (21)       | C7                  | Fail               |

Partitions for Combine Method:
- C1: Range a is null and b is valid. 
- C2: Range a is valid and b is null.
- C3: Ranges a and b are valid.
- C4: Ranges a and b are null.

| Class Name | Method Name             | Input Values | Relevant Conditions | Pass/Fail Criteria |
|------------|-------------------------|--------------|---------------------|--------------------|
| Range      | TestNullAndValidLowerBound     | (Null, Valid)       | C1              | Pass               |
| Range      | TestNullAndValidUpperBound    | (Null, Valid)       | C1              | Fail               |
| Range      | TestValidAndNullLowerBound | (Valid, Null)       | C2              | Pass               |
| Range      | TestValidAndNullUpperBound | (Valid, Null)       | C2                  | Fail               |
| Range      | TestNullAndNullLowerBound | (Null, Null)       | C4                  | Pass               |
| Range      | TestNullAndNullUpperBound     | (Null, Null)       | C4              | Pass               |
| Range      | TestValidAndValidUpperBound    | (Valid, Valid)       | C3              | Pass               |
| Range      | TestNullAndNullUpperBound | (Valid, Valid)       | C3              | Pass               |

## Tests cases for the DataUtilities Class Methods
Partitions for the CalculateColumnTotal Method:
- C1: Data is null.
- C2: Data is valid.
- C3: Number is less than or equal to columns.
- C4: Numer is greater than or equal to zero.
- C5: Number is less than zero.
- C6: Number is greater than columns.

| Class Name | Method Name             | Input Values | Relevant Conditions | Pass/Fail Criteria |
|------------|-------------------------|--------------|---------------------|--------------------|
| DataUtilities      | calculateColumnTotalForNullLessColumn     | (Null, Number <= Columns)       | C1, C3              | Pass               |
| DataUtilities      | calculateColumnTotalForNullEqualZero    | (Null, Number >= 0)       | C1, C4              | Pass               |
| DataUtilities      | calculateColumnTotalForNullLargeColumn | (Null, Number < 0)       | C1, C5              | Pass               |
| DataUtilities      | calculateColumnTotalForNullLowerZero | (Null, Number > Columns)       | C1, C6                  | Pass               |
| DataUtilities      | calculateColumnTotalNominalValue | (Valid, Number <= Columns)       | C2, C3                  | Pass               |
| DataUtilities      | calculateColumnValidListAboveZero | (Valid, Number >= 0)       | C2, C4                  | Pass               |
| DataUtilities      | calculateColumnValidListBelowZero | (Valid, Number < 0)       | C2, C5                  | Fail               |
| DataUtilities      | calculateColumnValidListAboveColumns | (Valid, Number > Columns)       | C2, C6                  | Fail               |

Partitions for the CalculateRowTotal Method:
- C1: Data is null.
- C2: Data is valid.
- C3: Number is less than or equal to rows.
- C4: Numer is greater than or equal to zero.
- C5: Number is less than zero.
- C6: Number is greater than rows.

| Class Name | Method Name             | Input Values | Relevant Conditions | Pass/Fail Criteria |
|------------|-------------------------|--------------|---------------------|--------------------|
| DataUtilities      | calculateRowTotalForNullLessRow     | (Null, Number <= Rows)       | C1, C3              | Pass               |
| DataUtilities      | calculateRowTotalForNullAtZero    | (Null, Number >= 0)       | C1, C4              | Pass               |
| DataUtilities      | calculateRowTotalForNullLargeColumn | (Null, Number < 0)       | C1, C5              | Pass               |
| DataUtilities      | calculateRowTotalForNullLowerZero | (Null, Number > Rows)       | C1, C6                  | Pass               |
| DataUtilities      | calculateRowTotalNominalValue | (Valid, Number <= Rows)       | C2, C3                  | Fail               |
| DataUtilities      | calculateRowValidListAboveZero | (Valid, Number >= 0)       | C2, C4                  | Fail               |
| DataUtilities      | calculateRowValidListBelowZero | (Valid, Number < 0)       | C2, C5                  | Fail               |
| DataUtilities      | calculateRowValidListAboveColumns | (Valid, Number > Rows)       | C2, C6                  | Fail               |

Partitions for the CreateNumberArray Method:
- C1: Data is null.
- C2: Data is positive numbers.
- C3: Data is negative numbers.
- C4: Data is zeros.
- C5: Data is positive/negative numbers.

| Class Name | Method Name             | Input Values | Relevant Conditions | Pass/Fail Criteria |
|------------|-------------------------|--------------|---------------------|--------------------|
| DataUtilities      |  createNumberArrayNull    | (Null)       | C1              | Pass               |
| DataUtilities      | createNumberArrayPositive    | (Positive)       | C2              | Fail               |
| DataUtilities      |createNumberArrayNegative  | (Negative)       | C3             | Fail               |
| DataUtilities      | createNumberArrayZero | (0)       | C4                 | Fail               |
| DataUtilities      | createNumberArrayPositiveNegative | (Positive/Negative)       | C5                  | Fail               |

Partitions for the CreateNumberArray2D Method:
- C1: Data is null.
- C2: Data is positive numbers.
- C3: Data is negative numbers.
- C4: Data is positive/negative numbers.
- C5: Data is negative/positive numbers.
- C6: Data is zeros.

| Class Name | Method Name             | Input Values | Relevant Conditions | Pass/Fail Criteria |
|------------|-------------------------|--------------|---------------------|--------------------|
| DataUtilities      |  create2DNumberArrayNull    | (Null)       | C1              | Pass               |
| DataUtilities      |  create2DNumberArrayPositive   | (Positive)       | C2              | Fail               |
| DataUtilities      | create2DNumberArrayNegative | (Negative)       | C3             | Fail               |
| DataUtilities      | create2DNumberArrayPositiveNegative | (Positive/Negative)       | C4                 | Fail               |
| DataUtilities      | create2DNumberArrayNegativePositive | (Negative/Positive)       | C5                  | Fail               |
| DataUtilities      | create2DNumberArrayZero | (0)       | C5                  | Fail               |

Partitions for the GetCumulativePercentanges:
- C1: Data is null.
- C2: Data is positive numbers.
- C3: Data is negative numbers.
- C4: Data is positive/negative numbers.
- C5: Data is zeros.

| Class Name | Method Name             | Input Values | Relevant Conditions | Pass/Fail Criteria |
|------------|-------------------------|--------------|---------------------|--------------------|
| DataUtilities      |  getCumulativePercentsNull    | (Null)       | C1              | Pass               |
| DataUtilities      |  getCumulativePercentsPositive   | (Positive)       | C2              | Fail               |
| DataUtilities      | getCumulativePercentsNegative | (Negative)       | C3             | Fail               |
| DataUtilities      | getCumulativePercentsPositiveNegative | (Positive/Negative)       | C4                 | Fail               |
| DataUtilities      | getCumulativePercentsZero | (0)       | C5                  | Fail               |


# 4 How the team work/effort was divided and managed

Our team continued to pair-program for this assignment. We continued to use discord for communicating together. One group member cloned the github repository provided and shared it with the group. Each pair then proceeded to work on creating plans and writing tests. For the planning phase, the pairs would work together simultaneously. For the unit tests, one group member would share their screen and the other was in charge of monitoring and ensuring the tests were written correctly. When all the tests were complete, the entire group looked over all method details to ensure all cases were tested. 

We worked in the following pairs: 
Pair 1: Yousef and Hamza
Pair 2: Bilal and Issam 


# 5 Difficulties encountered, challenges overcome, and lessons learned

We initially had some problems with Eclipse as our group had never used it before. This included the initial setup and application navigation, but as we used the application and got more familiar with it, with assistance from the short tutorial posted on the assignment repository the challenges of using a new IDE was simplified. We also had some difficulties using JMock as our group had never worked with this library previously. To understand JMock better, the group worked together to find concepts and examples that covered JMocks and enhanced our understanding. Using Javadoc was also key however we made sure to think outside the box to ensure all cases were covered. Overall, the group's understanding with Eclipse and writing unit tests improved throughout the lab. 

# 6 Comments/feedback on the lab itself

The instructions for this lab were clear and much easier to follow in comparison to lab 1. Upon completing this lab, our understanding of unit testing and using eclipse improved. It was interesting to partake in a topic that we do not often do in our usual software development. Using mock objects in unit testing was also interesting as we were able to experiment and throw exceptions or return specific values that we wanted. Overall, it was an interesting lab to work on as we continued to improve our understanding in such a critical topic in software development. 
