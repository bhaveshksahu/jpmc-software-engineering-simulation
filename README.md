# jpmc-software-engineering-simulation
📌 Overview
This repository contains my implementation of the technical tasks for the JPMorgan Chase & Co. Software Engineering Job Simulation hosted on Forage. The project involves working with Midas-Core, a system designed to handle real-time market data and internal transaction processing.
The simulation provided hands-on experience with industry-standard backend technologies, focusing on how large-scale financial institutions manage asynchronous data streams and internal API services.

🛠️ Tech Stack:

->Language: Java

->Framework: Spring Boot

->Messaging: Apache Kafka

->Database: H2 In-Memory Database

->Build Tool: Maven/Gradle

🚀 Key Features & Task Implementation
1. Kafka Integration
Implemented a message listener to consume real-time transaction data from a Kafka topic.

->Objective: Ensure the system can process high-frequency data streams asynchronously.

->Outcome: Successfully deserialized JSON payloads and integrated them into the backend processing pipeline.

3. H2 Database Integration
Configured an H2 in-memory database to provide rapid data persistence during the simulation.


->Objective: Enable efficient storage and retrieval of transaction records without the overhead of a traditional external database setup.

5. REST API Development
Developed and integrated REST API Controllers to expose internal data to other services.

->Endpoints: Created routes to query specific transaction data and return structured JSON responses.

->Architecture: Followed the Controller-Service-Repository pattern for clean, maintainable code.

🏗️ Project Architecture

The system follows a modern event-driven architecture:

1. Ingestion: Market data is published to a Kafka topic
   
2. Processing: The Kafka Listener consumes these messages and performs business logic.
 
3. Persistence: Validated data is saved to the H2 Database.

4.  Exposure: The REST API provides a gateway for external clients to access the stored records.
   
🧠 Learning Outcomes
Completing this simulation allowed me to:

->Explore enterprise-level workflows and system design used by major financial firms.

->Understand the importance of asynchronous communication in high-performance computing.

->Gain practical experience in bridging the gap between theoretical knowledge and industry-standard tools.
