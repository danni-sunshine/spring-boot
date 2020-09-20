package com.ziwei.springboot.config;

import com.ziwei.springboot.controller.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//使用WebMvcConfigurerAdapter可以来扩展SpringMvc的功能
//@EnableWebMvc 不要接管SpringMvc,如果打开，静态资源文件都会访问不到
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter
{
    //可以直接添加viewController，直接将请求添加到要前往的界面
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/ziwei").setViewName("success");
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter(){

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard.html");
            }

            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //springboot已经做好了静态页面资源
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html","/","/user/login");
                //super.addInterceptors(registry);
            }
        };
        return adapter;
    }


}
