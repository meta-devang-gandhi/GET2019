package com.metacube.EADSESSION7.Service.Implimentation;

import com.metacube.EADSESSION7.Service.IMailSender;

/*
 * Represent the Mock mail sender.
 */
public class MockMailSender implements IMailSender {

	@Override
	//Method to send mock type mail.
	public String sendMail() {
		return "Mock mail send";
	}

}
