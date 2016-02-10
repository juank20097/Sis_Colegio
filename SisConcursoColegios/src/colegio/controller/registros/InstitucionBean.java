package colegio.controller.registros;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import colegio.controller.generic.Funciones;
import colegio.controller.generic.Mail;
import colegio.controller.generic.Mensaje;
import colegio.manager.ManagerAcceso;
import colegio.manager.RegistrosDAO;
import colegio.model.entidades.ColEstudiante;
import colegio.model.entidades.ColInstitucion;

/**
 * @author jestevez
 * 
 */
@SessionScoped
@ManagedBean
public class InstitucionBean {

	// Llamada de los Dao y clases genericas
	private RegistrosDAO manager;
	private ManagerAcceso ma;

	// Atributos de la clase Movimientos_Cabecera
	/** @pdOid f80b9469-ab73-42ca-b6db-4839f4c4285c */
	private Integer ins_id;
	/** @pdOid 19776823-edfe-4f57-91e8-9ef4620036c2 */
	private String ins_zona;
	/** @pdOid a27d34a4-e584-4da9-8ae7-f53c2f6dc206 */
	private String ins_provincia;
	/** @pdOid e2f1d9aa-b9f5-4ffb-bc1b-a79b132d1a36 */
	private String ins_nombre;
	/** @pdOid ebea2020-fada-4041-9e88-6db7b0c4a323 */
	private String ins_direccion;
	/** @pdOid 7c8fba72-d564-4fee-8ed6-a7b55994b1bc */
	private String ins_telefono;
	/** @pdOid 6b61fd9e-add1-4cff-9e33-1d8c5329bb69 */
	private String ins_correo;
	/** @pdOid b31c936e-cc14-4516-b202-cb2d2d80f723 */
	private String ins_amie;
	/** @pdOid d1eb0ccd-f7b8-48eb-8ceb-9ed657f56b1e */
	private Date ins_fecha;
	/** @pdOid a1d1bd02-757e-403b-951d-040d27f3e00a */
	private String ins_estado;
	/** @pdOid 34ad5091-413a-4e19-9166-074751be41a0 */
	private String ins_rep_nombres;
	/** @pdOid f8c23b0b-1efa-4b1e-885b-b4aadf1647d1 */
	private String ins_rep_apellidos;
	/** @pdOid d977c50f-3c5f-4ac7-b5f3-5572d9fad188 */
	private String ins_rep_cedula;
	/** @pdOid 3ed8f4be-4109-48c2-8cb3-9cd192321a04 */
	private String ins_rep_correo;
	/** @pdOid 434d00a0-966b-4b67-9a26-7ab1b4039434 */
	private String ins_rep_telefono;
	/** @pdOid 34e9ac21-acd6-4f97-9cb4-ad5c9f551fbd */
	private String ins_rep_cargo;
	/** @pdOid bd666802-1e66-4a8d-9f4a-de7838577249 */
	private String ins_rep_clave;
	/** @pdOid 4cc90d68-baa3-4e99-a4d3-06dc29c63e04 */
	private String ins_coo_nombres;
	/** @pdOid cf8bf5e6-601a-4bbb-9827-81223c0ae3e8 */
	private String ins_coo_apellidos;
	/** @pdOid 9300627c-ef21-4687-94e9-622259b04ee5 */
	private String ins_coo_cedula;
	/** @pdOid ee46b1b8-5ac5-4cd8-9ce9-5b56cfbfc11a */
	private String ins_coo_cargo;
	/** @pdOid 4dc05bae-1928-41c6-88eb-0884e5105363 */
	private String ins_coo_correo;
	/** @pdOid c895fceb-2b11-4b0e-a399-98bba9fd61c6 */
	private String ins_coo_telefono;

	// Atributos para la carga de los SMS a ser enviados
	private String SMS_general;
	private String SMS_coordinador;

	private String usuario;

	public InstitucionBean() {
		LogginBean.verificarSession();
		manager = new RegistrosDAO();
		ma = new ManagerAcceso();
		ins_zona = null;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the sMS_general
	 */
	public String getSMS_general() {
		return SMS_general;
	}

	/**
	 * @param sMS_general
	 *            the sMS_general to set
	 */
	public void setSMS_general(String sMS_general) {
		SMS_general = sMS_general;
	}

	/**
	 * @return the sMS_coordinador
	 */
	public String getSMS_coordinador() {
		return SMS_coordinador;
	}

	/**
	 * @param sMS_coordinador
	 *            the sMS_coordinador to set
	 */
	public void setSMS_coordinador(String sMS_coordinador) {
		SMS_coordinador = sMS_coordinador;
	}

	/**
	 * @return the ins_fecha
	 */
	public Date getIns_fecha() {
		return ins_fecha;
	}

	/**
	 * @param ins_fecha
	 *            the ins_fecha to set
	 */
	public void setIns_fecha(Date ins_fecha) {
		this.ins_fecha = ins_fecha;
	}

	/**
	 * @return the ins_estado
	 */
	public String getIns_estado() {
		return ins_estado;
	}

	/**
	 * @param ins_estado
	 *            the ins_estado to set
	 */
	public void setIns_estado(String ins_estado) {
		this.ins_estado = ins_estado;
	}

	/**
	 * @return the ins_rep_clave
	 */
	public String getIns_rep_clave() {
		return ins_rep_clave;
	}

	/**
	 * @param ins_rep_clave
	 *            the ins_rep_clave to set
	 */
	public void setIns_rep_clave(String ins_rep_clave) {
		this.ins_rep_clave = ins_rep_clave;
	}

	/**
	 * @return the ins_id
	 */
	public Integer getIns_id() {
		return ins_id;
	}

	/**
	 * @param ins_id
	 *            the ins_id to set
	 */
	public void setIns_id(Integer ins_id) {
		this.ins_id = ins_id;
	}

	/**
	 * @return the ins_zona
	 */
	public String getIns_zona() {
		return ins_zona;
	}

	/**
	 * @param ins_zona
	 *            the ins_zona to set
	 */
	public void setIns_zona(String ins_zona) {
		this.ins_zona = ins_zona;
	}

	/**
	 * @return the ins_provincia
	 */
	public String getIns_provincia() {
		return ins_provincia;
	}

	/**
	 * @param ins_provincia
	 *            the ins_provincia to set
	 */
	public void setIns_provincia(String ins_provincia) {
		this.ins_provincia = ins_provincia;
	}

	/**
	 * @return the ins_nombre
	 */
	public String getIns_nombre() {
		return ins_nombre;
	}

	/**
	 * @param ins_nombre
	 *            the ins_nombre to set
	 */
	public void setIns_nombre(String ins_nombre) {
		this.ins_nombre = ins_nombre;
	}

	/**
	 * @return the ins_direccion
	 */
	public String getIns_direccion() {
		return ins_direccion;
	}

	/**
	 * @param ins_direccion
	 *            the ins_direccion to set
	 */
	public void setIns_direccion(String ins_direccion) {
		this.ins_direccion = ins_direccion;
	}

	/**
	 * @return the ins_telefono
	 */
	public String getIns_telefono() {
		return ins_telefono;
	}

	/**
	 * @param ins_telefono
	 *            the ins_telefono to set
	 */
	public void setIns_telefono(String ins_telefono) {
		this.ins_telefono = ins_telefono;
	}

	/**
	 * @return the ins_correo
	 */
	public String getIns_correo() {
		return ins_correo;
	}

	/**
	 * @param ins_correo
	 *            the ins_correo to set
	 */
	public void setIns_correo(String ins_correo) {
		this.ins_correo = ins_correo;
	}

	/**
	 * @return the ins_amie
	 */
	public String getIns_amie() {
		return ins_amie;
	}

	/**
	 * @param ins_amie
	 *            the ins_amie to set
	 */
	public void setIns_amie(String ins_amie) {
		this.ins_amie = ins_amie;
	}

	/**
	 * @return the ins_rep_nombres
	 */
	public String getIns_rep_nombres() {
		return ins_rep_nombres;
	}

	/**
	 * @param ins_rep_nombres
	 *            the ins_rep_nombres to set
	 */
	public void setIns_rep_nombres(String ins_rep_nombres) {
		this.ins_rep_nombres = ins_rep_nombres;
	}

	/**
	 * @return the ins_rep_apellidos
	 */
	public String getIns_rep_apellidos() {
		return ins_rep_apellidos;
	}

	/**
	 * @param ins_rep_apellidos
	 *            the ins_rep_apellidos to set
	 */
	public void setIns_rep_apellidos(String ins_rep_apellidos) {
		this.ins_rep_apellidos = ins_rep_apellidos;
	}

	/**
	 * @return the ins_rep_cedula
	 */
	public String getIns_rep_cedula() {
		return ins_rep_cedula;
	}

	/**
	 * @param ins_rep_cedula
	 *            the ins_rep_cedula to set
	 */
	public void setIns_rep_cedula(String ins_rep_cedula) {
		this.ins_rep_cedula = ins_rep_cedula;
	}

	/**
	 * @return the ins_rep_correo
	 */
	public String getIns_rep_correo() {
		return ins_rep_correo;
	}

	/**
	 * @param ins_rep_correo
	 *            the ins_rep_correo to set
	 */
	public void setIns_rep_correo(String ins_rep_correo) {
		this.ins_rep_correo = ins_rep_correo;
	}

	/**
	 * @return the ins_rep_telefono
	 */
	public String getIns_rep_telefono() {
		return ins_rep_telefono;
	}

	/**
	 * @param ins_rep_telefono
	 *            the ins_rep_telefono to set
	 */
	public void setIns_rep_telefono(String ins_rep_telefono) {
		this.ins_rep_telefono = ins_rep_telefono;
	}

	/**
	 * @return the ins_rep_cargo
	 */
	public String getIns_rep_cargo() {
		return ins_rep_cargo;
	}

	/**
	 * @param ins_rep_cargo
	 *            the ins_rep_cargo to set
	 */
	public void setIns_rep_cargo(String ins_rep_cargo) {
		this.ins_rep_cargo = ins_rep_cargo;
	}

	/**
	 * @return the ins_coo_nombres
	 */
	public String getIns_coo_nombres() {
		return ins_coo_nombres;
	}

	/**
	 * @param ins_coo_nombres
	 *            the ins_coo_nombres to set
	 */
	public void setIns_coo_nombres(String ins_coo_nombres) {
		this.ins_coo_nombres = ins_coo_nombres;
	}

	/**
	 * @return the ins_coo_apellidos
	 */
	public String getIns_coo_apellidos() {
		return ins_coo_apellidos;
	}

	/**
	 * @param ins_coo_apellidos
	 *            the ins_coo_apellidos to set
	 */
	public void setIns_coo_apellidos(String ins_coo_apellidos) {
		this.ins_coo_apellidos = ins_coo_apellidos;
	}

	/**
	 * @return the ins_coo_cedula
	 */
	public String getIns_coo_cedula() {
		return ins_coo_cedula;
	}

	/**
	 * @param ins_coo_cedula
	 *            the ins_coo_cedula to set
	 */
	public void setIns_coo_cedula(String ins_coo_cedula) {
		this.ins_coo_cedula = ins_coo_cedula;
	}

	/**
	 * @return the ins_coo_cargo
	 */
	public String getIns_coo_cargo() {
		return ins_coo_cargo;
	}

	/**
	 * @param ins_coo_cargo
	 *            the ins_coo_cargo to set
	 */
	public void setIns_coo_cargo(String ins_coo_cargo) {
		this.ins_coo_cargo = ins_coo_cargo;
	}

	/**
	 * @return the ins_coo_correo
	 */
	public String getIns_coo_correo() {
		return ins_coo_correo;
	}

	/**
	 * @param ins_coo_correo
	 *            the ins_coo_correo to set
	 */
	public void setIns_coo_correo(String ins_coo_correo) {
		this.ins_coo_correo = ins_coo_correo;
	}

	/**
	 * @return the ins_coo_telefono
	 */
	public String getIns_coo_telefono() {
		return ins_coo_telefono;
	}

	/**
	 * @param ins_coo_telefono
	 *            the ins_coo_telefono to set
	 */
	public void setIns_coo_telefono(String ins_coo_telefono) {
		this.ins_coo_telefono = ins_coo_telefono;
	}

	/**
	 * Metodo para listar todos los Datos de la Entidad
	 * 
	 * @return
	 */
	public List<ColInstitucion> getListInstituciones() {
		List<ColInstitucion> p = new ArrayList<ColInstitucion>();
		try {
			p = manager.findAllInstituciones();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	/**
	 * Metodo para carga una intitucion para ser visible ante alguna
	 * modificación
	 * 
	 * @param ins
	 * @return
	 */
	public String cargarInstitucion(ColInstitucion ins) {
		ins_id = ins.getInsId();
		ins_zona = ins.getInsZona();
		ins_provincia = ins.getInsProvincia();
		ins_nombre = ins.getInsNombre();
		ins_direccion = ins.getInsDireccion();
		ins_telefono = ins.getInsTelefono();
		ins_correo = ins.getInsCorreo();
		ins_estado = ins.getInsEstado();
		ins_amie = ins.getInsAmie();
		ins_rep_nombres = ins.getInsRepNombres();
		ins_rep_apellidos = ins.getInsRepApellidos();
		ins_rep_cedula = ins.getInsRepCedula();
		ins_rep_correo = ins.getInsRepCorreo();
		ins_rep_telefono = ins.getInsRepTelefono();
		ins_rep_cargo = ins.getInsRepCargo();
		ins_coo_nombres = ins.getInsCooNombres();
		ins_coo_apellidos = ins.getInsCooApellidos();
		ins_coo_cedula = ins.getInsCooCedula();
		ins_coo_cargo = ins.getInsCooCargo();
		ins_coo_telefono = ins.getInsCooTelefono();
		ins_coo_correo = ins.getInsCooCorreo();
		return "vregistro?faces-redirect=true";
	}

	/**
	 * Metodo para cambiao de estado
	 * 
	 * @return
	 */
	public String editarInstitucion() {
		// this.crearSMS(ins_id);
		this.htmlEnviar(ins_id);
		manager.editarInstitucion(ins_id, ins_estado);
		Mensaje.crearMensajeINFO("Estado Modificado Correctamente");
		return "validacion?faces-redirect=true";
	}

	/**
	 * Metodo para notificar a todas las Intituciones
	 */
	public void notificarAll() {
		this.htmlEnviar(ins_id);
	}

	/**
	 * Metodo de traslado
	 * 
	 * @return
	 */
	public String irValidacion() {
		// limpiar datos
		ins_zona = "";
		ins_provincia = "";
		ins_nombre = "";
		ins_direccion = "";
		ins_telefono = "";
		ins_correo = "";
		ins_amie = "";
		ins_rep_nombres = "";
		ins_rep_apellidos = "";
		ins_rep_cedula = "";
		ins_rep_correo = "";
		ins_rep_telefono = "";
		ins_rep_cargo = "";
		ins_coo_nombres = "";
		ins_coo_apellidos = "";
		ins_coo_cedula = "";
		ins_coo_cargo = "";
		ins_coo_telefono = "";
		ins_coo_correo = "";
		return "validacion?faces-redirect=true";
	}

	/**
	 * Metodo de listado de SelecItems
	 * 
	 * @return lista
	 */
	public List<SelectItem> getlistItemsEstados() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(Funciones.valorEstadoActivo,
				Funciones.valorEstadoActivo));
		lista.add(new SelectItem(Funciones.valorEstadoPendiente,
				Funciones.valorEstadoPendiente));
		lista.add(new SelectItem(Funciones.valorEstadoInactivo,
				Funciones.valorEstadoInactivo));
		return lista;
	}

	/**
	 * Metodo para llenar el mensaje de los correos y llamar al metodo de envio
	 * 
	 * @param ins_id
	 */
	public void htmlEnviar(Integer ins_id) {
		try {
			ColInstitucion i = manager.InstitucionByID(ins_id);
			String para = this.validarCorreo(i);
			List<ColEstudiante> est = this.filtrarEstudiante(i);
			Mail mail = new Mail();
			mail.setId("olimpiada");
			mail.setAsunto("Información de Registros");
			mail.setPara(para);
			String SMS_general = "<!DOCTYPE html>"
					+ "<html>"
					+ "<head>"
					+ "<meta charset=&quot;UTF-8&quot;>"
					+ "<title>Olimpiadas de Ciencias</title>"
					+ "</head>"
					+ "<body>"
					+ "<p>Estimado Coordinador,</p>"
					+ "<p>Le informamos que su instituci&oacute;n &quot;"+Funciones.cambiarFormato(i.getInsNombre())+"&quot; se registr&oacute; con &eacute;xito a las Olimpiadas de Ciencias.<br/>"
					+ "Usted puede revisar o modificar el registro de los estudiantes con las siguientes credenciales:</p>"
					+ "<p>Link: <a href=&quot;http://olimpiadasdeciencias.yachay.gob.ec/&quot;>olimpiadasdeciencias.yachay.gob.ec</a><br/>"
					+ "Usuario: "+i.getInsCooCedula()+"<br/>"
					+ "Pass: "+i.getInsCooClave()+"</p>"
					+ "<p>Recuerda que el 15 de febrero  ser&aacute;n las evaluaciones en l&iacute;nea,  nuestro equipo enviar&aacute; un correo electr&oacute;nico dos d&iacute;as antes de la evaluaci&oacute;n  a cada uno de  los estudiantes inscritos en la Olimpiada de Ciencias,  con las credenciales de ingreso (Usuario y Contrase&ntilde;a) los cuales deber&aacute;n ingresar en el link : <a href=&quot;http://olimpiadasdeciencias.yachay.gob.ec/&quot;>olimpiadasdeciencias.yachay.gob.ec</a>  para proceder a dar la prueba.  Les deseamos muchos &eacute;xitos.<p/>"
					+ "<p>A continuaci&oacute;n se detalla la lista de estudiantes registrados:</p>"
					+ "<table border=2>"
					+ "<tr>"
					+ "<td>C&eacute;dula</td><td>Nombres Completos</td><td>&Aacute;rea a Participar</td>"
					+ this.tabla(est) 
					+ "</table>"
					+ "<br/>"
					+ "<p>Saludos Cordiales<br/>"
					+ "Empresa P&uacute;blica Yachay EP.</p>"
					+ "</body>" 
					+ "</html>";
			mail.setBody(SMS_general);
			ma.MailWS(mail);
			// Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para cargar solo correos diferentes de null
	 * 
	 * @param ins
	 * @return
	 */
	public String validarCorreo(ColInstitucion ins) {
		String r = "";
		if (ins.getInsCorreo() != null) {
			r = r + ins.getInsCorreo() + ",";
		}
		if (ins.getInsCooCorreo() != null) {
			r = r + ins.getInsCooCorreo() + ",";
		}
		if (ins.getInsRepCorreo() != null) {
			r = r + ins.getInsRepCorreo() + ",";
		}
		return r;
	}

	/**
	 * Metodo para construir la tabla de estudiantes de una institución
	 * 
	 * @param est
	 * @return
	 */
	public String tabla(List<ColEstudiante> est) {
		StringBuilder sb = new StringBuilder();

		for (ColEstudiante col : est) {
			String c = "";
			if (col.getEstArea().equals("Matemáticas")) {
				c = "Matem&aacute;ticas";
			}
			if (col.getEstArea().equals("Física")) {
				c = "F&iacute;sica";
			}
			if (col.getEstArea().equals("Química")) {
				c = "Qu&iacute;mica";
			}
			if (col.getEstArea().equals("Biología")) {
				c = "Biolog&iacute;a";
			}

			sb.append("<tr><td>" + col.getEstCedula() + "</td><td>"
					+ Funciones.cambiarFormato(col.getEstApellidos()) + " "
					+ Funciones.cambiarFormato(col.getEstNombres()) + "</td><td>"
					+ c + "</td></tr>");
		}
		return sb.toString();
	}

	

	/**
	 * Metodo para filtrar a estudiantes segun una institución
	 * 
	 * @param ins
	 * @return
	 */
	public List<ColEstudiante> filtrarEstudiante(ColInstitucion ins) {
		List<ColEstudiante> lest = new ArrayList<ColEstudiante>();
		for (ColEstudiante col : manager.findAllEstudiantes()) {
			if (col.getColInstitucion().getInsId() == ins.getInsId()) {
				lest.add(col);
			}
		}
		return lest;
	}

	/**
	 * Metodo para llenar el mensaje de los correos y llamar al metodo de envio
	 * 
	 * @param ins_id
	 */
	public void crearSMS(Integer ins_id) {
		SMS_general = "";
		SMS_coordinador = "";
		try {
			ColInstitucion i = manager.InstitucionByID(ins_id);
			if (i.getInsEstado().trim()
					.equals(Funciones.valorEstadoActivo.trim())) {
				SMS_general = "Estimados. Representantes, "
						+ "\n"
						+ "\n Felicitaciones, su Institución Educativa "
						+ i.getInsNombre()
						+ " ha sido valida exitosamente, en este momento le llegará la información (código y usuario) al docente coordinador para que proceda a inscribir a los estudiantes seleccionados para el concurso Olimpiada de Ciencias – INNOPOLIS – 2016. "
						+ "\n"
						+ "\n Le recordamos que el 15 de febrero se realizará la evaluación online."
						+ "\n" + "\n Saludos Coordiales"
						+ "\n Empresa Pública Yachay EP";
				SMS_coordinador = "Sr/Sra. "
						+ i.getInsCooNombres()
						+ " "
						+ i.getInsCooApellidos()
						+ ","
						+ "\n"
						+ "\n Felicitaciones, su Institución Educativa "
						+ i.getInsNombre()
						+ " ha sido valida exitosamente, en este momento podrá inscribir a sus estudiantes en la Olimpiada de Ciencias – INNOPOLIS – 2016, en el siguiente link: http://olimpiadasdeciencias.yachay.gob.ec/ , donde deberá ingresar los siguientes datos."
						+ "\n"
						+ "\n Usuario: "
						+ i.getInsCooCedula()
						+ " "
						+ "\n Contraseña: "
						+ i.getInsCooClave()
						+ " "
						+ "\n"
						+ "\n Recuerde:"
						+ "\n •		Los estudiantes seleccionados para el concurso deberán estar cursando tercero de bachillerato y sólo podrán participar en UNA de las cuatro disciplinas: física, matemática, química y biología. "
						+ "\n •		El 15 de febrero se realizará la evaluación online, en el siguiente link : http://olimpiadasdeciencias.yachay.gob.ec/ "
						+ "\n •		El sistema automáticamente enviará a cada uno de los estudiantes, un código, que deberá ingresarlo el día de la evaluación."
						+ "\n" + "\n Saludos Coordiales"
						+ "\n Empresa Pública Yachay EP";
				this.sendSMS(i.getInsRepCorreo().trim(), i.getInsCooCorreo()
						.trim(), i.getInsCorreo().trim());
			}
			if (i.getInsEstado().trim()
					.equals(Funciones.valorEstadoInactivo.trim())) {
				SMS_general = "Srs. Representantes ,le informamos que la institución "
						+ i.getInsNombre()
						+ " NO fue aprobada para el Concurso de Ciencias.";
				SMS_coordinador = "Sr." + i.getInsCooNombres() + " "
						+ i.getInsCooApellidos()
						+ " ,le informamos que la institución "
						+ i.getInsNombre()
						+ " NO fue aprobada para el Concurso de Ciencias.";
				this.sendSMS(i.getInsRepCorreo().trim(), i.getInsCooCorreo()
						.trim(), i.getInsCorreo().trim());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para enviar correo
	 * 
	 * @param mail_representante
	 * @param mail_coordinador
	 * @param mail_institucion
	 */
	public void sendSMS(String mail_representante, String mail_coordinador,
			String mail_institucion) {
		try {
			Funciones.sendMail("olimpiadasdeciencia@yachay.gob.ec",
					mail_representante, "Concurso de Ciencias Yachay",
					SMS_general);
			Funciones.sendMail("olimpiadasdeciencia@yachay.gob.ec",
					mail_institucion, "Concurso de Ciencias Yachay",
					SMS_general);
			Funciones.sendMail("olimpiadasdeciencia@yachay.gob.ec",
					mail_coordinador, "Concurso de Ciencias Yachay",
					SMS_coordinador);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}