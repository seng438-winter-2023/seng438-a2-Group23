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

Partitions for ExpandToInclude:
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



// write down the name of the test methods and classes. Organize the based on
the source code method // they test. identify which tests cover which partitions
you have explained in the test strategy section //above

# 4 How the team work/effort was divided and managed

Text…

# 5 Difficulties encountered, challenges overcome, and lessons learned

Text…

# 6 Comments/feedback on the lab itself

Text…
