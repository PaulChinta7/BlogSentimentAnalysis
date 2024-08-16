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

```
git clone PaulChinta7/BlogSentimentAnalysis.git
cd BlogSentimentAnalysis
```

### Running the Services

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
Kaggle Dataset: You will find the ipynb file in the backend-ml folder along with the pickle file for the model and tokenizer.
```
https://www.kaggle.com/datasets/cosmos98/twitter-and-reddit-sentimental-analysis-dataset/data
cd backend-ml
```


## How It Works

### Creating and Managing Posts:
> Users can create blog posts, add images, text, and interact with the posts through upvotes and downvotes.

### Comment Analysis:
> When a comment is added, it is sent to the NLP Service for sentiment analysis.
The NLP Service processes the comment using a custom model and determines its sentiment.

###  Comment Integration:
> The sentiment result, along with the comment details, is sent back to the Blog Service using Kafka.
The Blog Service updates the post with the new comment, sorted by sentiment.

### Display:
> Comments are displayed on the blog posts in order of sentiment, with positive comments shown first.


Contact
For any questions or inquiries, please contact paulchinta7@gmail.com.
![image](https://github.com/user-attachments/assets/cba72a91-adb9-4071-b95f-56f70733c490)
![BlogsentimentPostGif](https://github.com/user-attachments/assets/2cc0435d-1bb6-45b5-b9dd-4cc5549ef7ca)
![post](https://github.com/user-attachments/assets/4f2e371f-237c-4020-9d8c-c59e02e4d37b)


