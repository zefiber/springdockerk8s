#!/bin/bash
version="$1"

if [ -z "$1"] ;then
  mvn --batch-mode release:update-versions
  mvn -DskipTests clean package dockerfile:build
  export version=$(mvn help:evaluate -Dexpression=project.version | grep -e '^[^\[]')
fi

if [ "$version" = "" ] ;then
  version="0.0.7"
fi

echo zefiber/springdockerk8sdemo:$version



docker tag springdockerk8sdemo:$version zefiber/springdockerk8sdemo:$version
docker push zefiber/springdockerk8sdemo:$version

kubectl --namespace=jx delete deployment springdockerk8s-deployment
kubectl --namespace=jx delete service springdocker-service
kubectl --namespace=jx create -f springdocker-deployment.yaml
kubectl --namespace=jx set image deployment/springdockerk8s-deployment springdockerk8s=zefiber/springdockerk8sdemo:$version