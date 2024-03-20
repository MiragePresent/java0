#!/bin/bash

mvn clean install && mvn spotless:apply

java -jar "/app/java0/target/java0-${APP_VERSION}.jar"