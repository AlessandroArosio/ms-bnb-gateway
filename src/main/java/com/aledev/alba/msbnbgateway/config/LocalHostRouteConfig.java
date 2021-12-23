package com.aledev.alba.msbnbgateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocalHostRouteConfig {

    @Bean
    public RouteLocator localHostRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/api/v1/busInfo/*", "/api/v1/busInfo*")
                        .uri("http://localhost:8080"))
                .route(r -> r.path("/api/v1/bookings*", "/api/v1/bookings/*")
                        .uri("http://localhost:8095"))
                .route(r -> r.path("/api/v1/addon*", "/api/v1/addon/*")
                        .uri("http://localhost:8090"))
                .route(r -> r.path("/api/v1/addonOrder*", "/api/v1/addonOrder/*")
                        .uri("http://localhost:8090"))
                .build();
    }
}
