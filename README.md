# cache-redis

## Getting Started

This is an example of how you may cache your application with redis.
To get a local copy up and running follow these simple steps.

### Prerequisites

This example need to run redis in a docker.

``` 
docker run -it \
    --name redis \
    -p 6379:6379 \
    redis:5.0.3
```

### Running locally 
``` 
mvn spring-boot:run
```
