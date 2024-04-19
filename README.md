## Need for a State Store

The primary requirement of the `nwq-group-builder` application is to designate a single claim as the primary claim within a unique group of claims. In our Kafka Streams application, we process each claim record individually. After a record has been processed and published to the output topic, its information is not retained. 
To effectively compare multiple claims within the same group, it is necessary to have a repository where these claims can be stored and accessed for comparison purposes. Therefore, for each veteran identified by a unique `veteranPersonID`, we create and maintain a record in the state store. This record logs all claims associated with the veteran, facilitating subsequent comparison operations

## Usage of the State Store

#### Data Merging and Initial Storage:
1. **Input Topic Processing:**
   - The input topics for Workload Management Fact, Deferral Aggregate Fact, and Claim Aggregate Fact are processed and merged using the `claimId` as a key.
2. **Storing GroupingFact:**
   - A `GroupingFact` is created and stored in the state store using the `veteranPersonID` as the key.

#### Initial Record Check:
3. **Check for First Record:**
   - If it is the first record for a `veteranPersonID`, the group designation remains unassigned (`null`).
4. **Record Comparison:**
   - If there are at least two records, a comparison is run to determine the primary claim based on criteria such as Ranking, VApriority, Avoidable, and Active.

#### Designation Assignment:
5. **Assigning Designations:**
   - Once a record is identified as primary, its `GroupDesignation` is set to "Primary" and all other records are labeled as "Secondary".
   - The updated `GroupingFact` is then sent to the output topic.

#### Handling New Primary Records:
6. **Updating Primary Designation:**
   - If a new record later qualifies as primary after a comparison:
     - The new record is marked as primary and published.
     - The previously designated primary record is retrieved from the state store, updated to "Secondary", and re-sent to the output topic.
   - This process ensures that the state store always contains the most recent and accurate designations for each `veteranPersonID`.
