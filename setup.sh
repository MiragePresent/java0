#!/bin/bash

mvn clean install && mvn formatter:format

java -jar "/app/java0/target/java0-${APP_VERSION}.jar"