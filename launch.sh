#!/bin/bash

# Step 0: Free up ports if needed
echo "Checking for processes on ports 9092 and 8080..."

for port in 9092 8080; do
  pid=$(lsof -ti :$port)
  if [ -n "$pid" ]; then
    echo "Killing process $pid on port $port"
    kill -9 $pid
  fi
done

# Step 1: Build the app
echo "Building the app..."
./mvnw clean package -DskipTests

# Step 2: Start Docker services
echo "Starting Docker services..."
docker-compose up --build -d

# Step 3: Optional wait to ensure readiness
echo "Waiting for Kafka and dependencies to be ready..."
sleep 10

# Step 4: Run the Spring Boot app JAR
echo "Running the app..."
java -jar target/SentinelShield-1.0-SNAPSHOT.jar
