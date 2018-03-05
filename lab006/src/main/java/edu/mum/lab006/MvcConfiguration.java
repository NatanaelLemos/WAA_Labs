package edu.mum.lab006;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class MvcConfiguration {

	@Bean 
	public MessageSource messageSource() { 
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource(); 
		messageSource.setBasename("/resources/messages"); 
		messageSource.setDefaultEncoding("UTF-8"); 
		return messageSource; 
	} 

	@Bean 
	public LocaleResolver localeResolver() { 
		SessionLocaleResolver localeResolver = new SessionLocaleResolver(); 
		localeResolver.setDefaultLocale(Locale.ENGLISH); 
		return localeResolver; 
	} 

}
