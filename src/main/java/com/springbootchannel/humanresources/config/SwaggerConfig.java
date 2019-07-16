package com.springbootchannel.humanresources.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.springbootchannel.humanresources"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
        //.useDefaultResponseMessages(false);
    }

    private ApiInfo apiInfo()
    {
        return new ApiInfoBuilder().title("Human Resources")
                .description("Human Resources API Documentation")
                .contact(new Contact("Human Resources", "www.mandoob.com", "reda_mesery@yahoo.com"))
                .version("v1")
                .build();
    }
}
