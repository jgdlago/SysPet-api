package com.petshopSystem.serviceImple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImple {

    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailServiceImple(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }
    
    public void emailGenerator(String to, String randomPassword) {
    	String emailText = "Seja Bem vindo cliente SysPet! \n\n"
    			+ "Esta é sua senha gerada aleatóriamente: "+randomPassword;
    	
    	String subject = "Seu acesso SysPet chegou!";
    	
    	this.sendEmail(to, subject, emailText);
    }
    
}
