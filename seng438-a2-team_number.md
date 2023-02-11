**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group \#:      |     |
| -------------- | --- |
| Student Names: |     |
|                |     |
|                |     |
|                |     |

# 1 Introduction

Text…

# 2 Detailed description of unit test strategy

// including the input partitions you have designed

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

// write down the name of the test methods and classes. Organize the based on
the source code method // they test. identify which tests cover which partitions
you have explained in the test strategy section //above

# 4 How the team work/effort was divided and managed

Text…

# 5 Difficulties encountered, challenges overcome, and lessons learned

Text…

# 6 Comments/feedback on the lab itself

Text…
