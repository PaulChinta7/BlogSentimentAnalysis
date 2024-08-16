from flask import Flask,request,jsonify
import pickle
import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import classification_report, accuracy_score
from confluent_kafka import Producer
from flask_cors import CORS



with open('model.pkl', 'rb') as model_file:
    model = pickle.load(model_file)

with open('vectorizer.pkl', 'rb') as vectorizer_file:
    vectorizer = pickle.load(vectorizer_file)
app = Flask(__name__)

CORS(app)
# Kafka configuration
KAFKA_BROKER = 'localhost:9092'  # Replace with your Kafka broker address
KAFKA_TOPIC = 'COMMENT_TOPIC'       # Replace with your Kafka topic name

producer = Producer({'bootstrap.servers': KAFKA_BROKER})

@app.route('/')
def hello_world():
    return 'Hello, World!'

# http://localhost:8080/blogs/addComment?id=66bd1fc749d9a82bf5c5d662 using RestTemplate
@app.route('/addComment', methods=['POST'])
def print_comment():
    
    data = request.json
    if not data or 'comment' not in data:
        return jsonify({'error': 'Invalid input'}), 400
    post_id = request.args.get('id')
    username=data["username"]
    comment = data['comment']
    rating=data["rating"]
    new_text = []
    new_text.append(comment)
    new_text_features = vectorizer.transform(new_text)
    predictions = model.predict(new_text_features)

    # object = {"username":"paul","comment":"very good",rating:prediction[0]}

    kafka_message = {
        "username": username,
        "comment": comment,
        "rating": int(predictions[0])  # Convert prediction to int if needed
    }
    # kafka sends an object to the topic, and to send a new comment.
    producer.produce(KAFKA_TOPIC, key=username, value=str(kafka_message))
    producer.flush() 

    # send back an object to tell that the comment is negative and you should be respectful. {"msg":Please be respectful/ Comment added succesfully}
    print(f'Prediction: {predictions}')
    print(kafka_message)
    return jsonify({'status': str(predictions[0])}), 200

if __name__ == '__main__':
    app.run(debug=True)
