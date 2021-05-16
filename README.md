# cache-redis

## Getting Started

This is an example of how you may give instructions on setting up your project locally.
To get a local copy up and running follow these simple example steps.

### Prerequisites

This is an example need to run redis in a docker.

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
