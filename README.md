# BlogSentimentAnalysis

## Overview
BlogSentimentAnalysis is a microservice-based project designed to enhance user experience on blog platforms by analyzing and sorting comments based on their sentiment. 
### The project consists of two primary microservices:
* Blog Service: Built with Spring Boot and using MongoDB for data storage.
* NLP Service: Implemented in Flask, using a custom-built NLP model for sentiment analysis.

The core functionality of the project includes creating and managing blog posts, comments, and sentiment analysis of these comments.

## Features
### Blog Service:

> Create and manage blog posts.
Add comments to posts.
Handle various interactions such as adding images, text, upvoting, and downvoting.
Persist comments to the relevant posts in MongoDB from a kafka consumer.
### NLP Service:

> Analyze comments to determine sentiment (positive, negative, or neutral).
Use a custom-trained NLP model with 91% accuracy.
Comment Sorting:Comments are sorted from positive to negative to improve user experience and reduce toxicity.

### Communication:
> Comments are analyzed by the NLP service and the results are communicated back to the Blog Service using Kafka.
The Blog Service listens for comment events and updates the blog posts accordingly.

# Setup and Installation
Clone the Repository

bash
Copy code
git clone https://github.com/yourusername/BlogSentimentAnalysis.git
cd BlogSentimentAnalysis
Running the Services

Backend (Blog Service):
Navigate to the backend folder and run the Spring Boot application.
```
cd backend
./mvnw spring-boot:run
```
NLP Service:
Navigate to the backend-ml folder and run the Flask application.
```
cd backend-ml
python app.py
```
Kafka, Zookeeper, and MongoDB:
Use Docker Compose to start the necessary services.

```
cd backend
docker-compose up --build
```
Frontend:
Navigate to the frontend folder and start the development server.

```
cd frontend
npm start
```



![post](https://github.com/user-attachments/assets/3bc6401a-2f4f-46a8-869f-a0325cefa063)

![image](https://github.com/user-attachments/assets/5640c0d6-5526-45a9-9ad4-7d678a18f871)
