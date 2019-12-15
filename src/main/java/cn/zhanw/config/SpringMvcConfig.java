package cn.zhanw.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.*;

/**
 * springmvc配置：
 * 1.开启包扫描扫描controller层
 * 2.开启mvc支持
 * 3.静态资源放行
 */
//替换xml配置文件，使用注解形式
@Configuration//用于定义配置类，可替换xml配置文件
//1.3  加载映射文件
@ComponentScan(basePackages={"cn.zhanw.controller","cn.zhanw.utils"})
//开启mvc支持
@EnableWebMvc

@EnableAspectJAutoProxy
public class SpringMvcConfig implements WebMvcConfigurer {
    /**
     * 配置静态资源
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

}
