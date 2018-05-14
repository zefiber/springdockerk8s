mvn -DskipTests clean package dockerfile:build

docker tag springdockerk8sdemo:0.0.1 zefiber/springdockerk8sdemo:0.0.5
docker push zefiber/springdockerk8sdemo:0.0.5

kubectl delete deployment springdockerk8s-deployment
kubectl delete service springdocker-service
kubectl create -f springdocker-deployment.yaml