# sanket-synechron

Design Considerations -
1. Design Principles: The SOLID principles, especially the Single Responsibility Principle, have been followed in separating the concerns of translating and counting words.
2. Design Patterns: In this case, no specific design patterns are required, but the WordCounter follows the principles of encapsulation and separation of concerns.
3. Optimal Algorithm: The optimal algorithm for storing and counting words is using a hash map (in-memory storage). This allows constant-time insertion and retrieval of words.
4. Memory Utilization: The memory usage is kept minimal by using a hash map to store the word counts. Words are stored in their English equivalents to save space.
5. Execution Context: The design is agnostic to the execution context and can be used in various environments without modifications. We can create docker image and can load on any environment easily.

Consider how clients will access the service. 
-> The rest endpoints are exposed and can be accessed from the url provided

Hosting: 
Can host the microservice on cloud platforms like AWS, Google Cloud, or Azure. 
Can choose a suitable instance type and set up the necessary networking configurations.

Resiliency: 
To ensure resiliency, we can follow below approaches :
Load Balancing: Add a load balancer to distribute incoming requests across multiple instances of the microservice.
Auto Scaling: By configuring auto-scaling (AWS instance) to automatically adjust the number of instances based on the incoming traffic.
Circuit Breakers: Implementing circuit breaker patterns to handle failures and prevent cascading failures.
Monitoring and Alerts: Set up monitoring and alerting systems to be notified of any performance or availability issues using
Prometheus and Grafana , New Relic , Elasticsearch  or Cloudwatch
