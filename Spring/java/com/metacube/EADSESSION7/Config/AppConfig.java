package com.metacube.EADSESSION7.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.metacube.EADSESSION7.Service.IMailSender;
import com.metacube.EADSESSION7.Service.Implimentation.MockMailSender;
import com.metacube.EADSESSION7.Service.Implimentation.SmtpMailSender;

/**
* It is a config class.
* Which is return the object of classes. 
**/
//@Configuration
@Component
public class AppConfig {
	
	@Bean
	//@Primary
	public IMailSender smtpMailSender(){
		return new SmtpMailSender();
	}
	
	@Bean
	@Primary
	public IMailSender mockMailSender(){
		return new MockMailSender();
	}
}
