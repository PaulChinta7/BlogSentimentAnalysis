from flask import Flask, request, jsonify
# from confluent_kafka import Producer

app = Flask(__name__)


def delivery_report(err, msg):
    if err is not None:
        print(f"Message delivery failed: {err}")
    else:
        print(f"Message delivered to {msg.topic()} [{msg.partition()}]")

@app.route('/send', methods=['POST'])
def send_message():
    # Get JSON data from the request
    data = request.json
    if not data or 'message' not in data:
        return jsonify({'error': 'Invalid input'}), 400

    message = data['message']

    return jsonify({'status': 'Message sent to Kafka topic'}), 200

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)
