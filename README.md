# Spring / Spring Boot / Spring Cloud sandbox projects

### Big picture

![Big picture](./docs/images/DemoZuulHystrix-BigPicture.png)

### Run projects

From each maven sub-modules directory, launch with: `mvn spring-boot:run`

The `spring-cloud-netflix-eureka` sub-module uses one profile `peer1` or `peer2` : 
```
mvn spring-boot:run -Drun.profiles=peer{1|2}
```

