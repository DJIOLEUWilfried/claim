package com.kozao.views;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;



public class TestSendEmail {

	public static void main(String[] args) {
		
		/*
		// Email d'envoi   andymat080@gmail.com  "MonEntreprise Support"
        final String username = "djioleuwilfried@gmail.com";  
        final String password = "phuw pmkm cbui cpjs"; 
//        final String password = "@Tatzen2025#";  

        // Destinataire  
        String toEmail = "djioleuwilfried@gmail.com";

        // Configuration SMTP (ici pour Gmail)
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Authentification
        Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

        try {
            // Création du message
            message.setFrom(new InternetAddress(expediteurEmail, "Wilfried Tech")); // Nom affiché chez le destinataire
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(toEmail)
            );
            message.setSubject("Test Email depuis Java SE");
            message.setText("Bonjour, Andy ceci est un second test d'envoi d'email depuis Java SE.");

            // Envoi
            Transport.send(message);

            System.out.println("\n\n Email envoyé avec succès!");

        } catch (MessagingException e) {
        	 System.out.println("\n\n Email non envoyé ! \n\n");
            e.printStackTrace();
        }
        */
		
		
		final String expediteurEmail = "djioleuwilfried@gmail.com";
        final String motDePasseApp = "phuw pmkm cbui cpjs"; // Mot de passe d'application Gmail

        String destinataire = "andymat080@gmail.com";  // andymat080@gmail.com
        String sujet = "Message Java SE";
        String contenu = "Bonjour Andy, ceci est un second message envoyé depuis une application Java.";

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

            // Masquer l'adresse et afficher un nom personnalisé
            message.setFrom(new InternetAddress(expediteurEmail, "Kozao Africa")); // Nom affiché chez le destinataire

            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinataire));
            message.setSubject(sujet);
            message.setText(contenu);

            Transport.send(message);
            System.out.println(" Email envoyé avec nom personnalisé !");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(" Échec de l'envoi.");
        }
		
		
		
		
		
		
		
		
		
		
		
	}

}
