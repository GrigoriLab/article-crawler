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
docker run --rm -v $PWD/db/:/crawler/db -v $PWD/images/:/crawler/images -e URL=$1 crawler
