## ACID Properties:

**transaction** is a single logical unit of work that accesses and possibly modifies the contents of a database

(in depth expalantion in notes)
Atomicity: All or none (taa actions in a transaction should happen or non should happen)
Consistency:
1.     Starts at a consistent state and end at a consistent state. Transactions helps to achieve that.
2.     Any data written to the database must be valid according to all defined rules, including but not limited to constraints, cascades, triggers, and any combination thereof 
    
### Isolation:

https://en.wikipedia.org/wiki/Isolation_(database_systems)#:~:text=Isolation%20is%20typically%20defined%20at,the%20use%20of%20temporary%20tables.
https://www.geeksforgeeks.org/transaction-isolation-levels-dbms/
https://medium.com/@darora8/transaction-isolation-in-postgres-ec4d34a65462
Various Isolation levels:
1. Dirty Read:
   - A Dirty read is a situation when a transaction reads data that has not yet been committed.
   - For example, Let’s say transaction 1 updates a row and leaves it uncommitted, meanwhile, Transaction 2 reads the updated row. If transaction 1 rolls back the change, transaction 2 will have read data that is considered never to have existed.
2. Non Repeatable read:
   - Non Repeatable read occurs when a transaction reads the same row twice and gets a different value each time.
   - For example, suppose transaction T1 reads data. Due to concurrency, another transaction T2 updates the same data and commit, Now if transaction T1 rereads the same data, it will retrieve a different value.
3. Phantom Read – 
   - Phantom Read occurs when two same queries are executed, but the rows retrieved by the two, are different. 
   - For example, suppose transaction T1 retrieves a set of rows that satisfy some search criteria. Now, Transaction T2 generates some new rows that match the search criteria for transaction T1. If transaction T1 re-executes the statement that reads the rows, it gets a different set of rows this time.

Isolation Levels:
1. Read Uncommited
2. Read Commited
3. Repeatable read
4. Serializable



### Durability: 

https://www.databricks.com/glossary/acid-transactions#:~:text=ACID%20is%20an%20acronym%20that,operations%20are%20called%20transactional%20systems.


## Normalization: 

# Indexing

# Sharding

# 
