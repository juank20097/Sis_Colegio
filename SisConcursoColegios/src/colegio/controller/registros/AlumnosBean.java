package colegio.controller.registros;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import colegio.controller.generic.Funciones;
import colegio.controller.generic.Mensaje;
import colegio.manager.RegistrosDAO;
import colegio.model.entidades.ColEstudiante;
import colegio.model.entidades.ColInstitucion;

import java.text.DateFormat;

/**
 * @author jestevez
 * 
 */
@SessionScoped
@ManagedBean
public class AlumnosBean {

	// Llamada de los Dao y clases genericas
	private RegistrosDAO manager;

	private LogginBean login;

	// Atributos de las Instituciones
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

	// Atributos de la clase Alumnos o Estudiantes
	/** @pdOid f7991f2f-85ca-4b70-b578-f0828e7bfdfd */
	private Integer est_id;
	/** @pdOid 1988f0e7-6b53-4731-8df7-98939b4b38fc */
	private String est_nombres;
	/** @pdOid 91a50da5-24d0-4472-8ff0-2e38eb693e26 */
	private String est_apellidos;
	/** @pdOid 1fba5213-3d89-49f2-bbe0-f2e10293e068 */
	private String est_cedula;
	/** @pdOid 9e631c6d-1d9b-4ffb-b4ce-2f0d7f5c1412 */
	private String est_area;
	/** @pdOid 1edf84fb-fa87-4420-a47a-07f9ea68fc91 */
	private String est_telefono;
	/** @pdOid 11a95b50-7e37-48f4-b03b-06723c87665d */
	private String est_correo;
	/** @pdOid b0f40126-b7b7-463c-985e-174b80f3fb65 */
	private String est_clave;
	/** @pdOid 43dfe8a9-664c-442a-9934-c7f8edf0b600 */
	private char est_estado;
	/** @pdOid 42d0bf78-8e43-48db-8cc7-45668a649eff */
	private Date est_fecha_ini;
	/** @pdOid 2cc735ab-15b4-49e9-a2f5-7f42a9c4b194 */
	private Date est_fecha_fin;
	/** @pdOid d24abecb-79ba-45eb-839e-d6618d53b981 */
	private String est_mac;

	// atributos de notificación de estudiantes
	private List<ColEstudiante> lest;
	private List<ColEstudiante> allest;

	private String var_ins;
	private String var_are;

	// Atributos para registro de fechas
	private Date fecha_ini;
	private Date fecha_fin;

	private long dia;
	private long hora;
	private long minuto;

	public AlumnosBean() {
		LogginBean.verificarSession();
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		login = (LogginBean) session.getAttribute("logginBean");
		
		
		manager = new RegistrosDAO();
		lest = new ArrayList<ColEstudiante>();
		allest = new ArrayList<ColEstudiante>();
		dia = 0;
		hora = 0;
		minuto = 0;
	}

	/**
	 * @return the dia
	 */
	public long getDia() {
		return dia;
	}

	/**
	 * @param dia
	 *            the dia to set
	 */
	public void setDia(long dia) {
		this.dia = dia;
	}

	/**
	 * @return the hora
	 */
	public long getHora() {
		return hora;
	}

	/**
	 * @param hora
	 *            the hora to set
	 */
	public void setHora(long hora) {
		this.hora = hora;
	}

	/**
	 * @return the minuto
	 */
	public long getMinuto() {
		return minuto;
	}

	/**
	 * @param minuto
	 *            the minuto to set
	 */
	public void setMinuto(long minuto) {
		this.minuto = minuto;
	}

	/**
	 * @return the fecha_ini
	 */
	public Date getFecha_ini() {
		return fecha_ini;
	}

	/**
	 * @param fecha_ini
	 *            the fecha_ini to set
	 */
	public void setFecha_ini(Date fecha_ini) {
		this.fecha_ini = fecha_ini;
	}

	/**
	 * @return the fecha_fin
	 */
	public Date getFecha_fin() {
		return fecha_fin;
	}

	/**
	 * @param fecha_fin
	 *            the fecha_fin to set
	 */
	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	/**
	 * @return the var_ins
	 */
	public String getVar_ins() {
		return var_ins;
	}

	/**
	 * @param var_ins
	 *            the var_ins to set
	 */
	public void setVar_ins(String var_ins) {
		this.var_ins = var_ins;
	}

	/**
	 * @return the var_are
	 */
	public String getVar_are() {
		return var_are;
	}

	/**
	 * @param var_are
	 *            the var_are to set
	 */
	public void setVar_are(String var_are) {
		this.var_are = var_are;
	}

	/**
	 * @return the allest
	 */
	public List<ColEstudiante> getAllest() {
		return allest;
	}

	/**
	 * @param allest
	 *            the allest to set
	 */
	public void setAllest(List<ColEstudiante> allest) {
		this.allest = allest;
	}

	/**
	 * @return the lest
	 */
	public List<ColEstudiante> getLest() {
		return lest;
	}

	/**
	 * @param lest
	 *            the lest to set
	 */
	public void setLest(List<ColEstudiante> lest) {
		this.lest = lest;
	}

	/**
	 * @return the ins_id
	 */
	public Integer getIns_id() {
		ins_id = login.getInstitucion().getInsId();
		System.out.println(ins_id);
		return ins_id;
	}

	/**
	 * @return the ins_zona
	 */
	public String getIns_zona() {
		ins_zona = login.getInstitucion().getInsZona();
		return ins_zona;
	}

	/**
	 * @return the ins_provincia
	 */
	public String getIns_provincia() {
		ins_provincia = login.getInstitucion().getInsProvincia();
		return ins_provincia;
	}

	/**
	 * @return the ins_nombre
	 */
	public String getIns_nombre() {
		ins_nombre = login.getInstitucion().getInsNombre();
		return ins_nombre;
	}

	/**
	 * @return the ins_direccion
	 */
	public String getIns_direccion() {
		ins_direccion = login.getInstitucion().getInsDireccion();
		return ins_direccion;
	}

	/**
	 * @return the ins_telefono
	 */
	public String getIns_telefono() {
		ins_telefono = login.getInstitucion().getInsTelefono();
		return ins_telefono;
	}

	/**
	 * @return the ins_correo
	 */
	public String getIns_correo() {
		ins_correo = login.getInstitucion().getInsCorreo();
		return ins_correo;
	}

	/**
	 * @return the ins_amie
	 */
	public String getIns_amie() {
		ins_amie = login.getInstitucion().getInsAmie();
		return ins_amie;
	}

	/**
	 * @return the est_id
	 */
	public Integer getEst_id() {
		return est_id;
	}

	/**
	 * @param est_id
	 *            the est_id to set
	 */
	public void setEst_id(Integer est_id) {
		this.est_id = est_id;
	}

	/**
	 * @return the est_nombres
	 */
	public String getEst_nombres() {
		return est_nombres;
	}

	/**
	 * @param est_nombres
	 *            the est_nombres to set
	 */
	public void setEst_nombres(String est_nombres) {
		this.est_nombres = est_nombres;
	}

	/**
	 * @return the est_apellidos
	 */
	public String getEst_apellidos() {
		return est_apellidos;
	}

	/**
	 * @param est_apellidos
	 *            the est_apellidos to set
	 */
	public void setEst_apellidos(String est_apellidos) {
		this.est_apellidos = est_apellidos;
	}

	/**
	 * @return the est_cedula
	 */
	public String getEst_cedula() {
		return est_cedula;
	}

	/**
	 * @param est_cedula
	 *            the est_cedula to set
	 */
	public void setEst_cedula(String est_cedula) {
		this.est_cedula = est_cedula;
	}

	/**
	 * @return the est_area
	 */
	public String getEst_area() {
		return est_area;
	}

	/**
	 * @param est_area
	 *            the est_area to set
	 */
	public void setEst_area(String est_area) {
		this.est_area = est_area;
	}

	/**
	 * @return the est_telefono
	 */
	public String getEst_telefono() {
		return est_telefono;
	}

	/**
	 * @param est_telefono
	 *            the est_telefono to set
	 */
	public void setEst_telefono(String est_telefono) {
		this.est_telefono = est_telefono;
	}

	/**
	 * @return the est_correo
	 */
	public String getEst_correo() {
		return est_correo;
	}

	/**
	 * @param est_correo
	 *            the est_correo to set
	 */
	public void setEst_correo(String est_correo) {
		this.est_correo = est_correo;
	}

	/**
	 * @return the est_clave
	 */
	public String getEst_clave() {
		return est_clave;
	}

	/**
	 * @param est_clave
	 *            the est_clave to set
	 */
	public void setEst_clave(String est_clave) {
		this.est_clave = est_clave;
	}

	/**
	 * @return the est_estado
	 */
	public char getEst_estado() {
		return est_estado;
	}

	/**
	 * @param est_estado
	 *            the est_estado to set
	 */
	public void setEst_estado(char est_estado) {
		this.est_estado = est_estado;
	}

	/**
	 * @return the est_fecha_ini
	 */
	public Date getEst_fecha_ini() {
		return est_fecha_ini;
	}

	/**
	 * @param est_fecha_ini
	 *            the est_fecha_ini to set
	 */
	public void setEst_fecha_ini(Date est_fecha_ini) {
		this.est_fecha_ini = est_fecha_ini;
	}

	/**
	 * @return the est_fecha_fin
	 */
	public Date getEst_fecha_fin() {
		return est_fecha_fin;
	}

	/**
	 * @param est_fecha_fin
	 *            the est_fecha_fin to set
	 */
	public void setEst_fecha_fin(Date est_fecha_fin) {
		this.est_fecha_fin = est_fecha_fin;
	}

	/**
	 * @return the est_mac
	 */
	public String getEst_mac() {
		return est_mac;
	}

	/**
	 * @param est_mac
	 *            the est_mac to set
	 */
	public void setEst_mac(String est_mac) {
		this.est_mac = est_mac;
	}

	/**
	 * Metodo para listar todos los Datos de la Entidad
	 * 
	 * @return
	 */
	public List<ColEstudiante> getListEstudiantes() {
		List<ColEstudiante> p = new ArrayList<ColEstudiante>();
		try {
			p = manager.findAllEstudiantes();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	/**
	 * Metodo para listar todos los Datos de la Entidad
	 * 
	 * @return
	 */
	public List<ColEstudiante> getListEstudiantesXIns() {
		List<ColEstudiante> p = new ArrayList<ColEstudiante>();
		try {
			p = manager.findAllEstudiantesXID(getIns_id());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	/**
	 * Metodo para registrar un estudiante
	 * 
	 * @return
	 */
	public String crearEstudiante() {
		try {
			Integer t = 0;
			List<ColEstudiante> le = manager.findAllEstudiantes();
			for (ColEstudiante est : le) {
				if (est.getEstCedula().trim().equals(est_cedula.trim())) {
					t = 0;
					break;
				} else {
					t++;

				}
			}
			if (t != le.size()) {
				Mensaje.crearMensajeERROR("Cédula del Estudiante ya Registrada");
			} else {
				if (Funciones.validadorDeCedula(est_cedula) != true) {
					Mensaje.crearMensajeERROR("Cédula del Estudiante Incorrecta");
				} else {
					System.out.println(est_area);
					if (est_area == null || est_area.equals("-1")) {
						Mensaje.crearMensajeERROR("Seleccione un Área a Participar");
					} else {
						manager.insertarEstudiante(est_nombres, est_apellidos,
								est_cedula, est_area, est_telefono, est_correo,
								getIns_id());
						// limpiar los Datos
						est_apellidos = "";
						est_area = "-1";
						est_cedula = "";
						est_clave = "";
						est_correo = "";
						est_estado = 'A';
						est_nombres = "";
						est_telefono = "";
						Mensaje.crearMensajeINFO("Estudiante añadido correctamente");
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public String eliminarEstudiante(ColEstudiante est) {
		manager.eliminarEstudiante(est.getEstId());
		Mensaje.crearMensajeINFO("Estudiante eliminado correctamente");
		return "";
	}

	/**
	 * Metodo de listado de SelecItems
	 * 
	 * @return lista
	 */
	public List<SelectItem> getlistItemsAreas() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(Funciones.vMatematicas,
				Funciones.valorMatematicas));
		lista.add(new SelectItem(Funciones.vBiologia, Funciones.valorBiologia));
		lista.add(new SelectItem(Funciones.vFisica, Funciones.valorFisica));
		lista.add(new SelectItem(Funciones.vQuimica, Funciones.valorQuimica));
		return lista;
	}

	/**
	 * Metodo para notificar a un listado de alumnos
	 */
	public String notificarAlumnos() {
		if ((fecha_ini == null || fecha_fin == null)
				|| (fecha_ini.after(fecha_fin))) {
			Mensaje.crearMensajeWARN("La Fechas Tienen un valor Nulo o la Fecha Inicio es Mayor a la Fecha Fin");

		} else {
			if (lest.size() == 0) {
				Mensaje.crearMensajeWARN("No se ha Seleccionado Ningun Estudiante para Notificar");
			} else {
				for (ColEstudiante es : lest) {
					try {
						manager.editarEstudiante(es.getEstId(), "N",
								fecha_ini, fecha_fin);
						String t = crearsmsAlumno(es.getEstNombres(),
								es.getEstApellidos(), es.getEstCedula(),
								es.getEstClave());
						Funciones.sendMail("olimpiadasdeciencia@yachay.gob.ec",
								es.getEstCorreo(),
								"Notificación de Olimpiadas de Ciencias", t);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				Mensaje.crearMensajeINFO("Noitificaciones Realizados Correctamente");
				fecha_ini = null;
				fecha_fin = null;
				allest = new ArrayList<ColEstudiante>();
			}
		}
		return "";
	}

	/**
	 * Metodo para notificar a todo los Alumnos Activos
	 */
	public String notificarAll() {
		lest = new ArrayList<ColEstudiante>();
		if ((fecha_ini == null || fecha_fin == null)
				|| (fecha_ini.after(fecha_fin))) {
			Mensaje.crearMensajeWARN("La Fechas Tienen un valor Nulo o la Fecha Inicio es Mayor a la Fecha Fin");
		} else {
			lest = manager.findAllEstudiantesActivos("A");
			for (ColEstudiante es : lest) {
				try {
					manager.editarEstudiante(es.getEstId(), "N", fecha_ini,
							fecha_fin);
					String t = crearsmsAlumno(es.getEstNombres(),
							es.getEstApellidos(), es.getEstCedula(),
						es.getEstClave());
					Funciones.sendMail("olimpiadasdeciencia@yachay.gob.ec",
							es.getEstCorreo(),
							"Notificación de Olimpiadas de Ciencias", t);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			Mensaje.crearMensajeINFO("Noitificaciones Realizados Correctamente");
			fecha_ini = null;
			fecha_fin = null;
			allest = new ArrayList<ColEstudiante>();
		}
		return "";
	}

	public String crearsmsAlumno(String nombre, String apellido, String cedula,
			String clave) {
		String sms = "";
		DateFormat fi = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		DateFormat ff = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		String a1 = fi.format(fecha_ini);
		String b1 = ff.format(fecha_fin);

		sms = "Sr./Sra. "
				+ nombre
				+ " "
				+ apellido
				+ "\n"
				+ "\n Felicitaciones querido estudiante has sido seleccionado para la primera fase del concurso Olimpiada de Ciencias – INNOPOLIS – 2016.  La prueba será vía online, en el siguiente link: http://olimpiadasdeciencias.yachay.gob.ec/ , donde deberá ingresar los siguientes datos."
				+ "\n" + "\n Usuario: " + cedula + "" + "\n Contraseña: "
				+ clave + "" + "\n"
				+ "\n Recuerde que usted dará la prueba desde " + a1
				+ ".hasta " + b1 + "  " + "\n" + "\n Exitos...!!!" + "\n"
				+ "\n" + "Saludos Coordiales" + "\n Empresa Pública Yachay EP";
		return sms;
	}

	/**
	 * Metodo para culacular el tiempo entre 2 fechas
	 */
	public void calculoTiempo() {
		if ((fecha_ini == null || fecha_fin == null)
				|| (fecha_ini.after(fecha_fin))) {
			Mensaje.crearMensajeWARN("La Fechas Tienen un valor Nulo o la Fecha Inicio es Mayor a la Fecha Fin");
		} else {
			long m = fecha_ini.getTime();
			long n = fecha_fin.getTime();

			long total = n - m;

			dia = total / (24 * 60 * 60 * 1000);
			hora = total / (60 * 60 * 1000);
			while (hora >= 24) {
				hora = hora - 24;
			}
			minuto = total / (60 * 1000);
			while (minuto >= 60) {
				minuto = minuto - 60;
			}
			Mensaje.crearMensajeINFO("Dias: " + dia + "\n Horas: " + hora
					+ "\n Minutos: " + minuto);
		}
	}

	/**
	 * Metodo de listado de SelecItems
	 * 
	 * @return lista
	 */
	public List<SelectItem> getlistItemsAreasN() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem("Matemáticas", "Matemáticas"));
		lista.add(new SelectItem("Biología", "Biología"));
		lista.add(new SelectItem("Física", "Física"));
		lista.add(new SelectItem("Química", "Química"));
		return lista;
	}

	/**
	 * Metodo de listado de SelecItems
	 * 
	 * @return lista
	 */
	public List<SelectItem> getlistItemsInstitucionN() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		List<ColInstitucion> ins;
		try {
			ins = manager.findAllInstituciones();
			for (ColInstitucion i : ins) {
				lista.add(new SelectItem(i.getInsNombre(), i.getInsNombre()));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lista;
	}

	/**
	 * Metodo para listar todas los estudiantes dependiendo su busqueda
	 * 
	 * @return
	 */
	public String generarListado() {
		allest = new ArrayList<ColEstudiante>();
		List<ColEstudiante> est;
		try {
			est = manager.findAllEstudiantes();
			if (var_are.equals("all") && var_ins.equals("all")) {
				allest = est;
			}
			if (!var_ins.equals("all") && var_are.equals("all")) {
				for (ColEstudiante e : est) {
					if (e.getColInstitucion().getInsNombre().trim()
							.equals(var_ins.trim())) {
						allest.add(e);
					}
				}
			}
			if (var_ins.equals("all") && !var_are.equals("all")) {
				for (ColEstudiante e : est) {
					if (e.getEstArea().trim().equals(var_are.trim())) {
						allest.add(e);
					}
				}
			}
			if (!var_ins.equals("all") && !var_are.equals("all")) {
				for (ColEstudiante e : est) {
					if (e.getEstArea().trim().equals(var_are.trim())
							&& e.getColInstitucion().getInsNombre().trim()
									.equals(var_ins.trim())) {
						allest.add(e);
					}
				}
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return "";
	}
}