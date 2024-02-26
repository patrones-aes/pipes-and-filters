#!/bin/ash

while ! nc -z $KAFKA_HOST $KAFKA_PORT; do
    echo "Waiting for kafka"
    sleep 3
done

echo "Kafka is up - executing command"

python /app/src/handler.py
