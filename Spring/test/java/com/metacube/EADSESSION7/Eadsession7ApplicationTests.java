package com.metacube.EADSESSION7;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.metacube.EADSESSION7.Controller.AppController;
import com.metacube.EADSESSION7.Service.IMailSender;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public class Eadsession7ApplicationTests {

	  @Autowired
	private IMailSender mail;
	
	@Test
	@Ignore
	public void springEqualTest() {
		 String returnString = mail.sendMail();
		 Assert.assertEquals("Mock mail send", returnString);
	}
	
	@Test
	public void springNotEqualTest(){
		 String returnString = mail.sendMail(); 
		 Assert.assertNotEquals("Smtp mail send", returnString);
	}

}
