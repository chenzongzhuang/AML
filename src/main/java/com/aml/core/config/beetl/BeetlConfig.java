package com.aml.core.config.beetl;

import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 集成beetl 使用Java Config 配置
 */
@Configuration
public class BeetlConfig {
	
	@Autowired
	private BeetlProperties beetlProperties;

	/**
     * beetl的配置
     */
    @Bean(initMethod = "init")
    public BeetlConfiguration beetlConfiguration() {
        BeetlConfiguration beetlConfiguration = new BeetlConfiguration();
        //设置模板资源加载器
        beetlConfiguration.setResourceLoader(new ClasspathResourceLoader(BeetlConfig.class.getClassLoader(), beetlProperties.getPrefix()));
        beetlConfiguration.setConfigProperties(beetlProperties.getProperties());
        return beetlConfiguration;
    }

    /**
     * beetl的视图解析器
     * @return
     */
    @Bean(name = "beetlViewResolver")
    public BeetlSpringViewResolver getBeetlSpringViewResolver() {
            BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
            beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
            beetlSpringViewResolver.setOrder(0);
            beetlSpringViewResolver.setConfig(beetlConfiguration());
            beetlSpringViewResolver.setSuffix(beetlProperties.getSuffix());
            return beetlSpringViewResolver;
    }
    
}
