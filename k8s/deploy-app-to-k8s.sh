#!/bin/bash -ex
kubectl delete deployment springdockerk8s-deployment
kubectl delete service springdocker-service
kubectl create -f springdocker-deployment.yaml > start-app.log