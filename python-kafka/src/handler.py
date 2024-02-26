import time
import kafka_service

print("Hello")


def sync_queue():
    print("Synchronizing queue")
    ctrl = True
    while ctrl:
        response = {"message": "Hello from py-ApiRest"}
        re = kafka_service.consumer_kafka()
        print(response)
        print(re)
        time.sleep(5)



if __name__ == '__main__':
    print("Starting")
    sync_queue()
