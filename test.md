One good data structure to represent this is a map<user_id, balance>, implemented using an in-memory Redis store.

### Scalability Approach

- Due to Redis limitations (1mil TPS per node), we partition our Redis cluster across multiple nodes.
- Example partitioning algorithm:

```
String accountID = "A";
int partitionNumber = 7;
int myPartition = accountID.hashCode() % partitionNumber;
```

- Zookeeper is used to store the number of partitions and addresses of Redis nodes, providing a highly-available configuration storage.

### Wallet Service

- A stateless service responsible for balance transfer operations.
- Easily scales horizontally to handle increased load.

### Concerns

- While this solution addresses scalability concerns, it does not support atomic balance transfer

[![wallet-service](https://github.com/preslavmihaylov/booknotes/raw/master/system-design/system-design-interview/chapter28/images/wallet-service.png)](https://github.com/preslavmihaylov/booknotes/blob/master/system-design/system-design-interview/chapter28/images/wallet-service.png)
