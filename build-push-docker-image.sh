mvn dockerfile:build
docker image rm -f zefiber/zetest:springdockerfork8s_v6
docker tag springdockerk8sdemo:0.0.1 zefiber/zetest:springdockerfork8s_v7
docker push zefiber/zetest:springdockerfork8s_v7

kubectl delete deployment springdockerk8s-deployment
kubectl delete service springdocker-service
kubectl create -f springdocker-deployment.yaml