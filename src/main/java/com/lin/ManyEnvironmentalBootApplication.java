package com.lin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import uk.org.lidalia.sysoutslf4j.context.SysOutOverSLF4J;

@SpringBootApplication
@Slf4j
public class ManyEnvironmentalBootApplication {
	public static void main(String[] args) {
		SysOutOverSLF4J.sendSystemOutAndErrToSLF4J();
		log.info("knife4j 访问地址: {} ","http://127.0.0.1:8011/doc.html");
		log.info("Swagger-ui 访问地址: {}","http://127.0.0.1:8011/swagger-ui.html");
		SpringApplication.run(ManyEnvironmentalBootApplication.class, args);
	}

}
