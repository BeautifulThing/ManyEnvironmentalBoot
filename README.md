# ManyEnvironmentalBoot

## 多环境开发打包命令


1.clean compile package -Dmaven.test.skip=true -Ptest
2.clean compile package -Dmaven.test.skip=true -Pdev
3.clean compile package -Dmaven.test.skip=true -Pprd


**运行时添加 --spring.profiles.active=test 指定运行环境**