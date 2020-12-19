package com.qf.ssm.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.Arrays;

@Configuration
@EnableWebMvc
@ComponentScan({"com.qf.ssm.controller"})
public class SpringMvcConfig implements WebMvcConfigurer {


        @Override//解决跨域  ip  请求方式
        public void addCorsMappings(CorsRegistry registry) {
            // 设置允许跨域的路径
            registry.addMapping("/**")
                    // 设置允许跨域请求的域名
                    .allowedOrigins("*")
                    // 是否允许证书 cookie
                    .allowCredentials(true)
                    // 设置允许的方法
                    .allowedMethods("GET", "POST", "DELETE", "PUT")
                    // 设置允许的header属性
                    .allowedHeaders("*")
                    // 跨域允许时间
                    .maxAge(3600);
        }


    //配合fastJson支持
    @Bean
    public FastJsonHttpMessageConverter fastJsonHttpMessageConverter(){
        FastJsonHttpMessageConverter fastJson = new FastJsonHttpMessageConverter();
        fastJson.setDefaultCharset(Charset.forName("UTF-8"));
        fastJson.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON));

        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setCharset(Charset.forName("UTF-8"));
        fastJsonConfig.setSerializerFeatures(
                //指定null按照协商好的配置返回  list集合为空------>返回[]
                SerializerFeature.WriteNullListAsEmpty,
                //日期格式  使得返回的日期类型默认为yyyy-MM-dd hh:mm:ss
                SerializerFeature.WriteDateUseDateFormat,
                //美化格式
                SerializerFeature.PrettyFormat,
                SerializerFeature.WriteMapNullValue,
                //有一个String类型的属性为空，就写成""
                SerializerFeature.WriteNullListAsEmpty,
                //禁止循环引用检测
                SerializerFeature.DisableCircularReferenceDetect
        );
        fastJson.setFastJsonConfig(fastJsonConfig);
        return fastJson;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }


    //文件解析器
    @Bean("multipartResolver")
    public CommonsMultipartResolver commonsMultipartResolver(){
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxInMemorySize(1024*1024*80);
        commonsMultipartResolver.setDefaultEncoding("utf-8");
        return commonsMultipartResolver;
    }


}
