mvn -f ArticleCrawler/pom.xml package
java  -classpath ArticleCrawler/target/classes/:./jsoup-1.11.3.jar com.ArticleCrawler.ArticleCrawler https://en.wikipedia.org/wiki/YouTube
