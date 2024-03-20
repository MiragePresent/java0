FROM alpine:3.19

RUN apk update \
    && apk add \
        bash \
        curl \
        openjdk21-jre \
        maven

COPY ./docker/java0/settings.xml /usr/share/java/maven-3/conf/settings.xml
COPY ./setup.sh /setup.sh

WORKDIR "/app"

RUN adduser runner \
    -H \
    -D \
    -u 1000 

# User permissions for maven local repository
RUN mkdir /.m2 \
    && chown -R runner /.m2 

# User permissions for the app
RUN chown -R runner /app 

# User permissions for the setup script
RUN chown runner /setup.sh \
    && chmod +x /setup.sh

USER runner

WORKDIR /app/java0

CMD ["/bin/bash", "/setup.sh"]
