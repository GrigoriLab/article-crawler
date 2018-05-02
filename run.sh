usage ()
{
  echo "Usage : $0 url"
  echo "Example : $0 https://en.wikipedia.org/wiki/YouTube"
  exit
}

if [ "$#" -lt 1 ]
then
  usage
fi
echo URL=$1
java  -classpath ArticleCrawler/target/classes/:./jsoup-1.11.3.jar:./sqlite-jdbc-3.21.0.jar com.ArticleCrawler.ArticleCrawler $1
