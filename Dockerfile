FROM openjdk
WORKDIR /crawler
COPY ./ /crawler
RUN apt update && \
    apt install -y maven
RUN mvn -f ArticleCrawler/pom.xml package
CMD ["bash", "-c", "./run.sh ${URL}"]

