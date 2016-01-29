package colegio.controller.generic;

import java.math.BigInteger;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * @author jestevez
 * 
 */
public class Funciones {

	/**
	 * Atributos para el manejo de estados
	 */

	public static String valorEstadoActivo = "Aprobado";
	public static String valorEstadoInactivo = "Rechazado";
	public static String valorEstadoPendiente = "Pendiente";

	/**
	 * Atributos para el manejo de estados de Entidad especifica
	 */

	public static char vActivo = 'A';
	public static String valorEstadoNotificado = "Notificado";
	public static char vNotificado = 'N';
	public static String valorEstadoEvaluado = "Evaluado";
	public static char vEvaluado = 'E';

	/**
	 * Atributos para el manejo de ares de evaluacion
	 * 
	 */

	public static String valorMatematicas = "Área de Matemáticas";
	public static String vMatematicas = "Matemáticas";
	public static String valorQuimica = "Área de Química";
	public static String vQuimica = "Química";
	public static String valorFisica = "Área de Física";
	public static String vFisica = "Física";
	public static String valorBiologia = "Área de Biología";
	public static String vBiologia = "Biología";

	/**
	 * Convierte un cadena en codigo MD5
	 * 
	 * @param input
	 *            entrada de cadena para convertirla en MD5
	 * @return String MD5
	 */
	public static String getMD5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	// /**
	// * Transforma un array de Byte en un String Base64
	// *
	// * @param array
	// * @return String
	// */
	// public static String getBASE64(byte[] array) {
	// if (array == null || array.length == 0)
	// return "";
	// else {
	// return Base64.encodeBase64(array).toString();
	// }
	// }

	// /**
	// * Transforma un String Base64 en un array de Byte
	// * @param base64
	// * @return byte []
	// */
	// public static byte [] getByteArray(String base64){
	// if(base64.isEmpty())
	// return null;
	// else{
	// //return Base64.decodeBase64(base64);
	// }
	// }

	/**
	 * Transforma una fecha a String
	 * 
	 * @param fecha
	 * @return String
	 */
	public static String dateToString(Date fecha) {
		DateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		if (fecha == null)
			return "";
		else
			return formato.format(fecha).toString();
	}

	/**
	 * Transforma un string de fecha en Date
	 * 
	 * @param fecha
	 * @return Date
	 * @throws ParseException
	 */
	public static Date stringToDate(String fecha) throws ParseException {
		DateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		return formato.parse(fecha);
	}

	/**
	 * Evalua si una cadena es numerica
	 * 
	 * @param cadena
	 * @return
	 */
	public static boolean isNumeric(String cadena) {
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	/**
	 * Metodo para generar contraseñas randomicas
	 */
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static Random rnd = new Random();

	public static String randomString(int len) {
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}

	/**
	 * Metodo para enviar Mails
	 * 
	 * @param origen
	 * @param destinatario
	 * @param asunto
	 * @param mensaje
	 * @return
	 * @throws Exception
	 */
	public static boolean sendMail(String origen, String destinatario,
			String asunto, String mensaje) throws Exception {
		try {
			
			Properties props = new Properties();
			props.put("mail.smtp.host", "mail.yachay.gob.ec");
			props.put("mail.from", origen);
			props.put("mail.smtp.starttls.enable", "false");
			props.put("mail.smtp.ssl.enable", "false");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "587");

			Authenticator authenticator = new Authenticator();
			props.setProperty("mail.smtp.submitter", authenticator
					.getPasswordAuthentication().getUserName());
			BodyPart texto = new MimeBodyPart();
			texto.setText(mensaje);

			MimeMultipart multiParte = new MimeMultipart();
			multiParte.addBodyPart(texto);

			// Envio de correo de verificacion a la cuenta ingresada

			// InternetAddress ccArr[] = new InternetAddress[1];
			// ccArr[0] = new InternetAddress("jestevez@yachay.gob.ec");

			Session session = Session.getInstance(props, authenticator);
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(origen));
			// msg.setRecipients(Message.RecipientType.CC, ccArr);
			msg.addRecipients(Message.RecipientType.TO,
					InternetAddress.parse(destinatario));
			msg.setSubject(asunto);
			msg.setContent(multiParte);

			msg.setFrom();
			// msg.setRecipients(Message.RecipientType.TO,
			// "luiscorrea1988@hotmail.com");
			// also tried @gmail.com

			Transport transport;
			transport = session.getTransport("smtp");
			transport.connect();
			msg.saveChanges();
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Metodo de Autentificacion en el envio de Mails
	 * 
	 * @author jestevez
	 * 
	 */
	private static class Authenticator extends javax.mail.Authenticator {

		private PasswordAuthentication authentication;

		public Authenticator() {
			String username = "olimpiadasdeciencia";
			String password = "Ecuador2015";
			authentication = new PasswordAuthentication(username, password);
		}

		protected PasswordAuthentication getPasswordAuthentication() {
			return authentication;
		}
	}

	/**
	 * Metodo para validar cedula Ecuatoriana
	 * 
	 * @param cedula
	 * @return
	 */
	public static boolean validadorDeCedula(String cedula) {
		boolean cedulaCorrecta = false;
		try {
			if (cedula.length() == 10) // ConstantesApp.LongitudCedula
			{
				int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
				if (tercerDigito < 6) {
					// Coeficientes de validación cédula
					// El decimo digito se lo considera dígito verificador
					int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
					int verificador = Integer.parseInt(cedula.substring(9, 10));
					int suma = 0;
					int digito = 0;
					for (int i = 0; i < (cedula.length() - 1); i++) {
						digito = Integer.parseInt(cedula.substring(i, i + 1))
								* coefValCedula[i];
						suma += ((digito % 10) + (digito / 10));
					}
					if ((suma % 10 == 0) && (suma % 10 == verificador)) {
						cedulaCorrecta = true;
					} else if ((10 - (suma % 10)) == verificador) {
						cedulaCorrecta = true;
					} else {
						cedulaCorrecta = false;
					}
				} else {
					cedulaCorrecta = false;
				}
			} else {
				cedulaCorrecta = false;
			}
		} catch (NumberFormatException nfe) {
			cedulaCorrecta = false;
		} catch (Exception err) {
			System.out
					.println("Una excepcion ocurrio en el proceso de validadcion");
			cedulaCorrecta = false;
		}

		if (!cedulaCorrecta) {
			System.out.println("La Cédula ingresada es Incorrecta");
		}
		return cedulaCorrecta;
	}

	/**
	 * Metodo para obtener la MAC de un equipo
	 * 
	 * @return
	 */
	public static String conseguirMAC() {
		String sb = new String();
		NetworkInterface a;
		try {
			a = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
			byte[] mac = a.getHardwareAddress();

			for (int i = 0; i < mac.length; i++) {
				sb = (String.format("%02X%s", mac[i],
						(i < mac.length - 1) ? "-" : ""));
			}

			// lmac.setText("SE ha registrado la MAC exitosamente.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb;
	}

}
