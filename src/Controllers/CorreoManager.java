package Controllers;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class CorreoManager {

    private static final String CORREO_EMISOR = "snaketournament@aol.com";
    private static final String CONTRASENA_EMISOR = "Sn@ke321--";

    public static void enviarCorreo(String destinatario, String asunto, String contenido) {
        // Configuración del servidor SMTP de AOL Mail
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.aol.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.enable", "true");

        // Crear la sesión de correo
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(CORREO_EMISOR, CONTRASENA_EMISOR);
            }
        });

        try {
            // Crear el mensaje de correo
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(CORREO_EMISOR));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject(asunto);
            message.setText(contenido);

            // Enviar el mensaje
            Transport.send(message);

            System.out.println("Correo enviado con éxito.");

        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Error al enviar el correo.");
        }
    }
}
