package com.aledev.alba.msbnbgateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("local-discovery")
@Configuration
public class LoadBalancedRoutesConfig {

    @Bean
    public RouteLocator loadBalancedRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/api/v1/busInfo/*", "/api/v1/busInfo*")
                        .uri("lb://bus-info-service"))
                .route(r -> r.path("/api/v1/bookings*", "/api/v1/bookings/*")
                        .uri("lb://booking-service"))
                .route(r -> r.path("/api/v1/addon*", "/api/v1/addon/*")
                        .uri("lb://addon-service"))
                .route(r -> r.path("/api/v1/addonOrder*", "/api/v1/addonOrder/*")
                        .uri("lb://addon-service"))
                .build();
    }
}
