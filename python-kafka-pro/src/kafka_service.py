import json
import threading
import time

from kafka import KafkaConsumer, KafkaProducer

from json import dumps


def producer_kafka():
    print("producer_kafka")
    ctrl = 10
    while ctrl > 0:
        producer = KafkaProducer(
            bootstrap_servers='kafka:29092',
            api_version=(0, 9),
            value_serializer=lambda x: dumps(x).encode('utf-8')
        )
        producer.send('positions', {'position': ctrl})
        producer.flush()
        ctrl = ctrl - 1
        print('Sent 10 positions: ,ctrl = {}'.format(ctrl))
        time.sleep(5)


def consumer_kafka():
    threading.Thread(target=producer_kafka).start()

    #producer_kafka()
    kafka_consumer = KafkaConsumer(
        'positions',
        max_poll_records=100,
        value_deserializer=lambda m: json.loads(m.decode('ascii')),
        bootstrap_servers='kafka:29092',
        auto_offset_reset='earliest'  # ,'smallest'
    )
    print("config: ", kafka_consumer.config)
    print("connected", kafka_consumer.bootstrap_connected())
    array_message = []
    try:
        print("1")
        if not kafka_consumer.bootstrap_connected():
            print("no Connected to Kafka")
            return {"message": "", "success": "False"}
        print(2)
        for message in kafka_consumer:
            print("8")
            print(json.loads(message.value))
            # array_message.append(message.value)
            # return {"message": array_message, "success": "True"}
        print(3)
    except KeyboardInterrupt:
        pass
    finally:
        kafka_consumer.close()
