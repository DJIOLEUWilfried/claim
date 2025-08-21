package com.kozao.utils;

import java.util.Properties;
import java.util.Random;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.kozao.services.UserServiceImpl;

public class ClaimSendPasswordUtil {
	
	public static Logger logger = Logger.getLogger(UserServiceImpl.class.getName());

	
	public static String SendPassword(String email, String nameUser ) {
		
		String password = String.format("Claim%d", new Random().nextInt(1000));
		
		final String expediteurEmail = "djioleuwilfried@gmail.com";
        final String motDePasseApp = "phuw pmkm cbui cpjs"; // Mot de passe d'application Gmail

        String destinataire = email;  
        String sujet = "Mot de passe de votre compte";
        String contenu = String.format("\n Bonjour %s, votre mot de passe est : %s", nameUser.toUpperCase(), password);

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(expediteurEmail, motDePasseApp);
            }
        });
        
        try {
            Message message = new MimeMessage(session);

            // Masquer l'adresse et afficher un nom personnalisé "CLAIM"
            message.setFrom(new InternetAddress(expediteurEmail, "CLAIM")); // Nom affiché chez le destinataire

            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinataire));
            message.setSubject(sujet);
            message.setText(contenu);

            Transport.send(message);
            // System.out.println(" Email envoyé avec nom personnalisé !");
            
            return ClaimControlUserUtil.cryptPassWord(password);
            
        } catch (Exception e) {
			logger.warning(String.format("\n Email delivery failed. Error : %s", e));

        }
		
        return null;
	}


}
