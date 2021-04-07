# Problem Statement
Consider a country with long roads and houses along the road. Assume that the residents of all houses use cell phones. We want to place cell phone towers along the road, and each cell phone tower covers a range of 9 miles. Create a greedy algorithm that allows the fewest cell phone towers. Additionally, create a brute force algorithm to complete the same problem and compare the results and efficiency.

Your program should output the number of towers needed and the location of each tower.

# Solution Summary
Input: int[] x ; array of houses
Output: List y ; List of cell towers

Greedy Algorithm:
Starting at mile marker 9, iterating by 1, through the last house's mile marker - 9, determine the coverage a cell phone tower would have if built there. From these coverages, pick the greatest one and build a tower. Repeat the process until all houses are covered.


Brute Force Algorithm:
Starting at mile marker 9, place a cell tower at every 18th increment in order to ensure full coverage to all houses.

# Test Case 1

## Using:
int[] testHouses = {3, 5, 8, 10, 14, 19, 21, 25, 29, 31, 37, 39, 44, 55, 59, 63, 66, 69, 75, 80};

## Results in:

Brute Force Approach:
Number of cell towers Required: 5
Placed at mile markers: 9 27 45 63 81 

Greedy Approach:
Number of cell towers Required: 5
Placed at mile markers: 12 34 38 64 71

Based on this result, it seems the greedy approach has no real advantage over the brute force, in fact, it seems worse given how much more complex it is. However, the problem of this brute force approach is that it is dumb, the following test will show this.

# Test Case 2

## Using:
int[] testHouses = {3, 5, 8, 37, 39, 44, 80};

## Results in: 

Brute Force Approach:
Number of cell towers Required: 5
Placed at mile markers: 9 27 45 63 81 

Greedy Approach:
Number of cell towers Required: 3
Placed at mile markers: 12 46 71

As you can see, the brute force approach generates unnecessary cell towers, as it simply increments mile markers without any regard to whether building at that mile marker will actually cover any house. Though the greedy approach is much more complex, it avoids building any tower that would not cover at least one house. Not only that, but it will also work to achieve the minimum number of towers possible, as seen in the next test case.

# Test Case 3

## Using:
int[] testHouses = {8, 19};

# Results in:
Brute Force Approach:
Number of cell towers Required: 2
Placed at mile markers: 9 27 

Greedy Approach:
Number of cell towers Required: 1
Placed at mile markers: 10 

As is shown, not only does the greedy approach avoid building towers where there are no houses, it also minimizes the amount of towers built by choosing the mile marker which would have the highest coverage if a cell tower is built there, avoiding cases of building two towers when one would suffice in this example.

