import json
from kafka import KafkaConsumer
import pymongo

if __name__ == '__main__':
    print("Starting Kafka Consumer")

    client = pymongo.MongoClient("mongodb://mongo:27017/")
    mydb = client["countryDB"]
    mycol = mydb["countries"]
    # Kafka Consumer
    consumer = KafkaConsumer(
        'countries',
        bootstrap_servers='kafka:9092'
    )

    for message in consumer:
        # print("message", json.loads(message.value.decode('utf-8')))
        mydict = json.loads(message.value.decode('utf-8'))

        if mydict.get('languages').get('spa'):
            new_country = {
                "name_country": mydict["name"]["official"],
                "region": mydict.get('region'),
                "subregion": mydict.get('subregion'),
                "languages": mydict.get('languages').get('spa')
            }
            x = mycol.insert_one(new_country)
            print("mongo response", x.inserted_id)
