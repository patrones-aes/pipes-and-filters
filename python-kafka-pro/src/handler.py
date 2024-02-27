import json as json
from concurrent.futures import ThreadPoolExecutor
from time import sleep
from kafka import KafkaProducer
import requests


# Set up Kafka producer
def serializer(message):
    return json.dumps(message).encode('utf-8')


# Kafka Producer
producer = KafkaProducer(
    bootstrap_servers=['kafka:9092'],
    value_serializer=serializer
)


def get_push_reords():
    with ThreadPoolExecutor(max_workers=16) as executor:
        print("put record")
        try:
            # Call filter 1
            response = requests.get('http://firstfilter:8080/countries/countries')

            for country in response.json():
                if country.get('subregion') == 'South America':
                    # print(country)
                    producer.send('countries', country)
                    sleep(5)

        except Exception as e:
            print(e)


def main():
    while True:
        get_push_reords()
        sleep(10)


if __name__ == "__main__":
    print("Starting Kafka Producer")
    main()
