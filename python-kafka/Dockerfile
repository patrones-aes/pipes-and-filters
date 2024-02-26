##Image for run api
FROM python:3.11-alpine
## Directory of work into image
WORKDIR /app
##Copy file with dependencies into image
COPY requirements.txt .
##Install dependencies
RUN pip install -r requirements.txt


##Copy app files into WORKDIR
COPY . .
## Comman to run Api from flask
##CMD ["python","./src/handler.py","run"]
##COPY entrypoint.sh .
#RUN chmod +x entrypoint.sh
#ENTRYPOINT ["ls"]
#ENTRYPOINT ["python","src/handler.py"]
CMD ["python","src/handler.py"]