package com.metacube.EADSESSION7.Service.Implimentation;

import com.metacube.EADSESSION7.Service.IMailSender;

/**
 *Represent the smtp mail sender. 
 */
public class SmtpMailSender implements IMailSender {

	@Override
	public String sendMail() {
		return "Smtp Mail send";
	}

}
