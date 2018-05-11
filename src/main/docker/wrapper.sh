#!/bin/bash
sleep 20

echo '#####Starting up springdocker with consul template project####'
java $JVM_ARGUMENTS -Djava.security.egd=file:/dev/./urandom -jar /springdocker.jar