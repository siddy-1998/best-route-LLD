## LLD - Best Route

### Problem Statement
https://docs.google.com/document/d/1CuE3BCxy8DHUizm4B8dy5_LCT_XnMKkH5sli-zrVP_k/edit#heading=h.yezr843psqv3

### Assumptions
https://docs.google.com/document/d/1CuE3BCxy8DHUizm4B8dy5_LCT_XnMKkH5sli-zrVP_k/edit#heading=h.670bslje0y5
1. Considering only one DE (Aman), 2 Restaurant (R1, R2), 2 Customers (C1,C2) only for simplicity. Hence we will consider five locations: Aman's start location, R1, R2, C1, and C2.
2. Aman must visit each location (R1, R2, C1, C2) once to complete the deliveries.
3. Every location is connected to every other location.
4. Journey stops at either C1 or C2
5.  C1 requests R1 and C2 requests R2.
6. Aman, R1, and R2 are all notified at the same time, and all parties confirm their readiness immediately.
7. We will use the haversine formula to calculate distances between locations.
8. Travel time is calculated based on a constant average speed of 20 km/h.
9. The goal is to minimize the total delivery time, considering both travel and meal preparation time.
10. The output should include the optimal route and the total time required to complete the deliveries.
11. For simplicity, all locations are given as latitude and longitude pairs.
12. Left out error/exception handling, assuming user intelligently gives correct inputs.


### Flow
https://docs.google.com/document/d/1CuE3BCxy8DHUizm4B8dy5_LCT_XnMKkH5sli-zrVP_k/edit#heading=h.8amgovcnymj8

### UML
https://docs.google.com/document/d/1CuE3BCxy8DHUizm4B8dy5_LCT_XnMKkH5sli-zrVP_k/edit#heading=h.bwvf2nxv6zuv
1. Objects
   - Customer
   - Restaurant
   - Delivery Executive
2. Important Classes
   - RoutingStrategy
   - DeliveryOptimiser
   - ShortestTimeBasedRouting
3. Pattern Followed
   - Strategy Design : This helps us to define algos that can be invoked to optimise delivery. For example, you can define different routing strategies based on different objectives (eg minimizing total time, minimizing travel distance, etc). This pattern allows you to switch strategies easily without modifying the rest of the code.

### Code
1. Build on same base as shown in UML and flow part.
2. Calculates the distance between two geo-locations using the haversine formula. (https://www.geeksforgeeks.org/haversine-formula-to-find-distance-between-two-points-on-a-sphere/)
3. Algorithm to figure out shortest time
   - Generate all permutations of routes with correct sequence (R1 should be visited before C1)
   - Calculate the time taken for all above valid routes
   - Get the route taking min amount of time.
4. Print route and time
5. Note : In real this problem is a weighted graph related problem, where we need to find the shortest path from source to destination where weights assigned to the edges are based on time.

### Github : https://github.com/siddy-1998/best-route-LLD

### Further Enhancements
1. develop algo to consider multiple entities
2. By consider states like idle, reached resturant r1 etc : we can use State design pattern here
3. By considering C1 C2 or customers as observers and DE as observable : we can use Observer Design pattern this wil help to notify customers when the state of DE is changed.

