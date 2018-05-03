## Build docker image

```docker build -t crawler .```

## Running

```docker run --rm -v $PWD/db/:/crawler/db -v $PWD/images/:/crawler/images -e URL=https://en.wikipedia.org/wiki/YouTube crawler```

or

```./docker-run.sh https://en.wikipedia.org/wiki/YouTube```
