package com.epam.microservices.api_gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p -> p.path("/get")
                .filters(f -> f
                        .addRequestHeader("MyHeader","MyURI")
                        .addRequestParameter("Param","MyValue"))
                .uri("http://httpbin.org:80"))
                .route(p -> p.path("/exchange/**")
                        .uri("lb://CURRENCY-EXCHANGE-SERVICE"))
                .route(p -> p.path("/currency-conversion/**")
                        .uri("lb://CURRENCY-CONVERSION-SERVICE"))
                .route(p -> p.path("/currency-conversion-custom/**")
                        .filters(f -> f.rewritePath(
                                "/currency-conversion-custom/(?<segment>.*)",
                                      "/currency-conversion/${segment}"
                        ))
                        .uri("lb://CURRENCY-CONVERSION-SERVICE"))

                .build();
    }
}
