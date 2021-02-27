package org.study;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
@PropertySource(value= {"classpath:/label.properties", "classpath:/application.properties"})
public class ServletInitializer extends SpringBootServletInitializer {

	@Bean
	 public MessageSource messageSource() {
	     ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	     messageSource.setBasenames("classpath:label");
	     messageSource.setDefaultEncoding("UTF-8");
	     return messageSource;
	 }
	
	  @Bean
	  public LocalValidatorFactoryBean validator() {
	      LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
	      bean.setValidationMessageSource(messageSource());
	      return bean;
	  } 
	  
	  @Bean
	    public InternalResourceViewResolver setupViewResolver() {
	 
	        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	 
	        resolver.setPrefix("/WEB-INF/views/");
	        resolver.setSuffix(".jsp");
	        return resolver;
	    }
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Springteam04Application.class);
	}

}
