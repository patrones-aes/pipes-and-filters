# Image for run api
FROM python:3.11-alpine3.18

# Directory of work into image
WORKDIR /app

# Copy file with dependencies into image
COPY requirements.txt .

# Install dependencies
RUN pip install -r requirements.txt

# Copy app files into WORKDIR
COPY src src

# Copy command file into WORKDIR
COPY start.sh .

# Set permissions to command file
RUN chmod +x start.sh

# Expose port 5000
EXPOSE 5000

CMD [ "./start.sh" ]
