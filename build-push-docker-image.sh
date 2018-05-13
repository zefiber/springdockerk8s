mvn dockerfile:build
docker image rm -f zefiber/zetest:springdockerfork8s_v6
docker tag springdockerk8sdemo:0.0.1 zefiber/zetest:springdockerfork8s_v6
docker push zefiber/zetest:springdockerfork8s_v6