# ManyEnvironmentalBoot

## 多环境开发打包命令


1.clean compile package -Dmaven.test.skip=true -Ptest

2.clean compile package -Dmaven.test.skip=true -Pdev

3.clean compile package -Dmaven.test.skip=true -Ppro


**运行时添加 --spring.profiles.active=test 指定运行环境**


## 验证logback是否能记录 System.out.println() 日志信息
1. 依赖pd4ml enableDebugInfo() 验证和观测是否记录


## 尝试使用 knife4j
1. 主要参考SwaggerConfig配置(相比 Swagger-Ui 多 @EnableSwaggerBootstrapUi 注解)