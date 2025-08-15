package com.nest.renting.web.admin.custom.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * API documentation configuration for the back-office admin system.
 * Groups APIs by functional modules such as user, apartment, lease, and login management.
 */
@Configuration
public class Knife4jConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI().info(
                new Info()
                        .title("back-office system API")
                        .version("1.0")
                        .description("back-office system API")
                        .termsOfService("http://doc.xiaominfo.com")
                        .license(new License().name("Apache 2.0").url("http://doc.xiaominfo.com")))
                        .components(new Components().addSecuritySchemes("access_token", new SecurityScheme().type(SecurityScheme.Type.APIKEY).in(SecurityScheme.In.HEADER).name("access_token")));
    }

    @Bean
    public GroupedOpenApi systemAPI() {

        return GroupedOpenApi.builder().group("Administrative Management").
                addOperationCustomizer((operation, handlerMethod) -> operation.addSecurityItem(new SecurityRequirement().addList("access_token"))).
                pathsToMatch(
                        "/admin/system/**"
                ).
                build();
    }

    @Bean
    public GroupedOpenApi loginAPI() {

        return GroupedOpenApi.builder().group("Login management").
                addOperationCustomizer((operation, handlerMethod) -> operation.addSecurityItem(new SecurityRequirement().addList("access_token"))).
                pathsToMatch(
                        "/admin/login/**",
                        "/admin/info"
                ).
                build();
    }

    @Bean
    public GroupedOpenApi apartmentAPI() {

        return GroupedOpenApi.builder().group("Apartment Management").
                addOperationCustomizer((operation, handlerMethod) -> operation.addSecurityItem(new SecurityRequirement().addList("access_token"))).
                pathsToMatch(
                        "/admin/apartment/**",
                        "/admin/room/**",
                        "/admin/label/**",
                        "/admin/facility/**",
                        "/admin/fee/**",
                        "/admin/attr/**",
                        "/admin/payment/**",
                        "/admin/region/**",
                        "/admin/term/**",
                        "/admin/file/**"
                ).build();
    }
    @Bean
    public GroupedOpenApi leaseAPI() {
        return GroupedOpenApi.builder().group("Lease Management").
                addOperationCustomizer((operation, handlerMethod) -> operation.addSecurityItem(new SecurityRequirement().addList("access_token"))).
                pathsToMatch(
                        "/admin/appointment/**",
                        "/admin/agreement/**"
                ).build();
    }


    @Bean
    public GroupedOpenApi userAPI() {
        return GroupedOpenApi.builder().group("User Management").
                addOperationCustomizer((operation, handlerMethod) -> operation.addSecurityItem(new SecurityRequirement().addList("access_token"))).
                pathsToMatch(
                        "/admin/user/**"
                ).build();
    }
}