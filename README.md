## Build docker image

```docker build -t crawler .```

## Running

```docker run -v $PWD/images/:/crawler/images -e URL=https://en.wikipedia.org/wiki/YouTube crawler```

or

```./docker-run.sh```
