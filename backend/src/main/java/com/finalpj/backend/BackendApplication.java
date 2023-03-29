package com.finalpj.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.finalpj.backend.interceptor.JwtInterceptor;

@SpringBootApplication
public class BackendApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Autowired
	private JwtInterceptor jwtInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(jwtInterceptor).addPathPatterns("/ApplyStatus1") ;// 기본 적용 경로
//		.excludePathPatterns(Arrays.asList("[/1,/2,/3,/4,/5]"));// 적용 제외 경로
	}
}
