FROM openjdk:11.0.10-jdk

ENV APPLICATION_USER ktor
RUN adduser --disabled-password  --gecos '' $APPLICATION_USER
ENV KTOR_ENV prod

# Copy directories and code
RUN mkdir /application
RUN mkdir /applicationsrc
COPY . /applicationsrc
# Permissions
RUN chown -R $APPLICATION_USER /application
RUN chown -R $APPLICATION_USER /applicationsrc

# Run gradle build
USER $APPLICATION_USER
WORKDIR /applicationsrc
RUN ./gradlew shadowJar

# Copy gradle build
RUN cp ./backend/core/build/libs/core-fat.jar /application/webserver.jar
WORKDIR /application

CMD ["java", "-server", "-jar", "webserver.jar"]