mvn dockerfile:build
docker tag springdockerk8s:0.0.1 zefiber/zetest:springdockerfork8s_v5
docker push zefiber/zetest:springdockerfork8s_v5