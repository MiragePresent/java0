#!/bin/bash

cd /app/java0 && mvn clean install 

java -jar "/app/java0/target/java0-${APP_VERSION}.jar"