from kafka import KafkaConsumer


def consumer_kafka():
    kafka_consumer = KafkaConsumer(
        'positions',
        bootstrap_servers='kafka:29092',
    )
    print(kafka_consumer.config)
    print(kafka_consumer.bootstrap_connected())
    try:
        for message in kafka_consumer:
            print(f"Received message: {message.value}")

    except KeyboardInterrupt:
        pass
    finally:
        kafka_consumer.close()
