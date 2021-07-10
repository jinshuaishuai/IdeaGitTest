package com.jin.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname SwaggerConfig
 * @Description Swagger配置类
 * @Date 2021/7/10 13:57
 * @Created by jinshuai
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

    @Value("${swagger.enable}")
    private boolean enableSwagger;

    @Bean
    public Docket document() {
        return new Docket(DocumentationType.SWAGGER_2)
                //文档的基础信息
                .apiInfo(apiInfo())
                .enable(enableSwagger)
                .select()
                //扫描的包
                .apis(RequestHandlerSelectors.basePackage("com.jin.controller"))
                //该包下的所有方法
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(setHeaderToken())
                ;
    }

    public List<Parameter> setHeaderToken() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name("token").description("token").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        return pars;
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //文章标题
                .title("测试项目接口API文档")
                //创建人信息.
                .contact(new springfox.documentation.service.Contact("风清扬", "", "fengqingyang@abc.com"))
                //版本号
                .version("1.0")
                //描述
                .description("有问题请邮件咨询风清扬")
                .build();
    }

}

