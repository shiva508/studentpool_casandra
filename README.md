#DOCKER
sudo docker run --rm -it -v /var/run/docker.sock:/var/run/docker.sock wagoodman/dive:latest studentpool_casandra

#BUILDING DOCKER IMAGE WITH SPRING BOOT
sudo mvn clean verify spring-boot:build-image

# BUILDING DOCKER IMAGE WITH fabric-8

sudo mvn clean verify -Pbuild-with-fabric-8

# BUILDING DOCKER IMAGE WITH JIB

sudo mvn clean verify -Pbuild-with-jib
