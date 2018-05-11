FROM java:8
ENV JVM_ARGUMENTS ''
ARG JAR_FILE
ADD ${JAR_FILE} springdocker.jar
ADD wrapper.sh wrapper.sh
RUN bash -c 'chmod +x /wrapper.sh'
RUN bash -c 'touch /springdocker.jar'
ENTRYPOINT ["/bin/bash", "/wrapper.sh"]
