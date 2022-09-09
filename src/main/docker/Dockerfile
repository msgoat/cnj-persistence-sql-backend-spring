FROM eclipse-temurin:11-jre-alpine

LABEL maintainer="michael.theis@msg.group"
LABEL ${project.groupId}.${project.artifactId}.project="CloudTrain"
LABEL ${project.groupId}.${project.artifactId}.version="${project.version}"
LABEL ${project.groupId}.${project.artifactId}.description="${project.description}"

ARG ARG_JAVA_APPLICATION_HOME=/home/spring

ENV JAVA_APPLICATION_HOME=${ARG_JAVA_APPLICATION_HOME} \
    JAVA_OPTS="-XshowSettings:vm -XX:+UseG1GC -XX:MetaspaceSize=256m -XX:+DisableExplicitGC -XX:+UseStringDeduplication -XX:+ParallelRefProcEnabled" \
    EXT_JAVA_OPTS="" \
    DOCKER_JAVA_OPTS="-XX:+UseContainerSupport -XX:InitialRAMPercentage=75.0 -XX:MaxRAMPercentage=75.0" \
    AGENT_JAVA_OPTS="" \
    SPRING_JAVA_OPTS="" \
    SPRING_PROFILES_ACTIVE="default" \
    JAVA_APPLICATION=${ARG_JAVA_APPLICATION} \
    JAVA_APPLICATION_HOME=${ARG_JAVA_APPLICATION_HOME} \
    SPRING_SECURITY_OAUTH2_RESOURCESERVER_JWT_JWK_SET_URI="" \
    SPRING_SECURITY_OAUTH2_RESOURCESERVER_JWT_ISSUER_URI="" \
    POSTGRES_DB_HOST="" \
    POSTGRES_DB_PORT="" \
    POSTGRES_DB_NAME="" \
    POSTGRES_DB_USER="" \
    POSTGRES_DB_PASSWORD=""

RUN echo "adding run user spring to system" \
    && addgroup -S spring -g 1000 \
    && adduser -S spring -u 1000 -G spring

COPY docker-entrypoint.sh /
COPY *.jar ${ARG_JAVA_APPLICATION_HOME}/

RUN chown spring:spring /docker-entrypoint.sh \
    && chmod u+x /docker-entrypoint.sh \
    && chown -R spring:spring ${ARG_JAVA_APPLICATION_HOME}

# use user ID instead of user name to allow kubernetes to check non-root users
USER 1000

EXPOSE 8080

ENTRYPOINT ["/docker-entrypoint.sh"]
CMD ["java"]



