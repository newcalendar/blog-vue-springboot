package com.shimh.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.alibaba.fastjson.support.spring.FastJsonViewResponseBodyAdvice;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{
	
	
	@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        FastJsonHttpMessageConverter  fastConverter = new FastJsonHttpMessageConverter ();

        FastJsonConfig fastJsonConfig = new FastJsonConfig();

        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.PrettyFormat,SerializerFeature.WriteNullStringAsEmpty
        );

        fastConverter.setFastJsonConfig(fastJsonConfig);

        converters.add(fastConverter);
    }
	
	@Bean
	public FastJsonViewResponseBodyAdvice FastJsonViewResponseBodyAdvice(){
		FastJsonViewResponseBodyAdvice advice = new FastJsonViewResponseBodyAdvice();
		return advice;
	}
}