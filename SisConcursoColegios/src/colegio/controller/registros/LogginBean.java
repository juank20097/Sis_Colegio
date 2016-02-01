package colegio.controller.registros;

/**
 * 
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import colegio.acceso.entidades.Menu;
import colegio.controller.generic.Mensaje;
import colegio.manager.ManagerAcceso;
import colegio.manager.RegistrosDAO;
import colegio.model.entidades.ColEstudiante;
import colegio.model.entidades.ColEvaluacionEstudiantil;
import colegio.model.entidades.ColInstitucion;

/**
 * @author jestevez
 * 
 */
@SessionScoped
@ManagedBean
public class LogginBean {

	private ManagerAcceso mngAcc;
	private RegistrosDAO manager;

	private List<Menu> menu;

	// Atributo para el nombre del Estudiante
	private String est_nombre;

	private long dia;
	private long hora;
	private long minuto;
	private long segundo;

	private long t_par;

	private String time;

	// Atributos para el loggin
	private String usuario;
	private String contrasena;

	// Atributo para obtener la institucion
	private ColInstitucion institucion;
	private ColEstudiante estudiante;

	private StreamedContent file;
	private StreamedContent file2;
	private StreamedContent file3;

	// atributo de control de parametros
	private boolean parametroIns;

	//atributo de calificacion
	private Integer calificacion=0;
	
	public LogginBean() {
		institucion = new ColInstitucion();
		manager = new RegistrosDAO();
		mngAcc = new ManagerAcceso();
		this.DownloadFile();
		this.DownloadFile2();
		this.DownloadFile3();
		t_par = 0L;
		// this.validarParametroIns();
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}

	public StreamedContent getFile3() {
		return file3;
	}

	public void setFile3(StreamedContent file3) {
		this.file3 = file3;
	}

	public ColEstudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(ColEstudiante estudiante) {
		this.estudiante = estudiante;
	}

	/**
	 * @return the institucion
	 */
	public ColInstitucion getInstitucion() {
		return institucion;
	}

	/**
	 * @param institucion
	 *            the institucion to set
	 */
	public void setInstitucion(ColInstitucion institucion) {
		this.institucion = institucion;
	}

	/**
	 * @return the est_nombre
	 */
	public String getEst_nombre() {
		return est_nombre;
	}

	/**
	 * @param est_nombre
	 *            the est_nombre to set
	 */
	public void setEst_nombre(String est_nombre) {
		this.est_nombre = est_nombre;
	}

	/**
	 * @return the parametroIns
	 */
	public boolean isParametroIns() {
		// ColParametro p = manager.ParametroByNombre("institucion");
		// parametroIns=p.isPar_valor();
		return parametroIns;
	}

	/**
	 * @param parametroIns
	 *            the parametroIns to set
	 */
	public void setParametroIns(boolean parametroIns) {
		this.parametroIns = parametroIns;
	}

	public StreamedContent getFile2() {
		return file2;
	}

	public StreamedContent getFile() {
		return file;
	}

	/**
	 * @return the menu
	 */
	public List<Menu> getMenu() {
		return menu;
	}

	/**
	 * @param menu
	 *            the menu to set
	 */
	public void setMenu(List<Menu> menu) {
		this.menu = menu;
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
	 * @return the contrasena
	 */
	public String getContrasena() {
		return contrasena;
	}

	/**
	 * @param contrasena
	 *            the contrasena to set
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	public String ingresoLogin() {
		String r = "";
		if (usuario != null && contrasena != null) {
			r = this.resultado();
			if (r.isEmpty() || r == "") {
				r = this.loginEst();
			}
			if (r.isEmpty() || r == "") {
				r = this.login();
			}
		} else {
			Mensaje.crearMensajeERROR("Usuario o contraseña Inexistente");
			r = "";
		}
		if (r == "a") {
			r = "";
		}
		return r;
	}

	public String resultado() {
		String r = "";
		for (ColEstudiante e : manager.findAllEstudiantes()) {
			if (e.getEstCedula().trim().equals(usuario.trim())) {
				for (ColEvaluacionEstudiantil ev : manager
						.findAllEvaEstudiantil()) {
					if (ev.getColEstudiante().getEstId() == e.getEstId()
							&& ev.getEesCalificacion() != null) {
						calificacion = ev.getEesCalificacion();
						RequestContext context = RequestContext
								.getCurrentInstance();
						context.execute("PF('close').show();");
						r = "a";
					}
				}
			}
		}
		return r;
	}

	/**
	 * Metodo para ingresar al sistema como Coordinador
	 * 
	 * @param usu
	 * @param pass
	 * @return
	 */
	public String loginCoo() {
		String r = "";
		List<ColInstitucion> i = manager.findAllInstituciones();
		for (ColInstitucion ins : i) {
			if (ins.getInsCooCedula().trim().equals(usuario.trim())
					&& ins.getInsCooClave().trim().equals(contrasena.trim())
					&& ins.getInsEstado().trim().equals("Aprobado".trim())) {
				setInstitucion(ins);
				// session.setAttribute("sessionBean", usuario);
				r = "views/alumnos?faces-redirect=true";
				break;
			}
		}
		return r;
	}

	/**
	 * Metodo para ingresar al sistema como Coordinador
	 * 
	 * @param usu
	 * @param pass
	 * @return
	 */
	public String loginEst() {
		String r = "";
		List<ColEstudiante> e;
		e = manager.findAllEstudiantes();
		for (ColEstudiante est : e) {
			if (est.getEstCedula().trim().equals(usuario.trim())
					&& est.getEstClave().trim().equals(contrasena.trim())
					&& est.getEstEstado().equals("N")) {
				if ((new Date().after(est.getEstFechaIni()))
						&& (new Date().before(est.getEstFechaFin()))) {
					setEstudiante(est);
					r = "views/evaluacion.xhtml";
					break;
				}
				if ((new Date().after(est.getEstFechaIni()))
						&& (new Date().after(est.getEstFechaFin()))) {
					RequestContext context = RequestContext
							.getCurrentInstance();
					context.execute("PF('close').show();");
					r = "a";
				} else {
					est_nombre = est.getEstNombres() + " "
							+ est.getEstApellidos();
					t_par = est.getEstFechaIni().getTime();
					RequestContext context = RequestContext
							.getCurrentInstance();
					context.execute("PF('info').show();");
					context.execute("PF('poll').start();");
					r = "a";
				}
			}
		}
		return r;
	}

	public String cerrarDialog() {
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('poll').stop();");
		return "";
	}

	/**
	 * Permite logearse al sistema
	 * 
	 * @return
	 */
	public String login() {
		try {
			List<Menu> lstmenu = mngAcc.loginWS(getUsuario(), getContrasena(),
					"OLIMP");
			if (lstmenu.isEmpty())
				throw new Exception("Usuario o contraseña Inexistente.");
			setMenu(lstmenu);
			setContrasena("");
			// session.setAttribute("sessionBean", usuario);
			return "views/index?faces-redirect=true";
		} catch (Exception e) {
			Mensaje.crearMensajeWARN(e.getMessage());
			return "";
		}
	}

	/**
	 * Permite deslogearse del sistema
	 * 
	 * @return
	 */
	public String logout() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.invalidate();
		institucion = null;
		setMenu(new ArrayList<Menu>());
		setUsuario(null);
		setContrasena(null);
		setInstitucion(null);
		setEstudiante(null);
		return "/index?faces-redirect=true";
	}

	/**
	 * Método para verifiar la existencia de la sesión
	 * 
	 * @param rol
	 *            de usuario
	 * @return Clase Usuario
	 */
	public static String verificarSession() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		LogginBean log = (LogginBean) session.getAttribute("logginBean");
		String user = log.getUsuario();
		if (user == null || user.isEmpty()) {
			try {
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect("/SisConcursoColegios/faces/index.xhtml");
			} catch (IOException ex) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, ex
								.getMessage(), null));
			}
			return null;
		} else {
			return user;
		}
	}

	/**
	 * Metodo para download archivos
	 */
	public void DownloadFile() {
		InputStream stream = ((ServletContext) FacesContext
				.getCurrentInstance().getExternalContext().getContext())
				.getResourceAsStream("/resources/docs/Reglamento-Olimpiada Ciencias INNOPOLIS 17-12-2015.pdf");
		file = new DefaultStreamedContent(stream, "application/pdf",
				"Reglamento-Olimpiada Ciencias INNOPOLIS 17-12-2015.pdf");
	}

	public void DownloadFile2() {
		InputStream stream2 = ((ServletContext) FacesContext
				.getCurrentInstance().getExternalContext().getContext())
				.getResourceAsStream("/resources/docs/pasos de inscripcion.pdf");
		file2 = new DefaultStreamedContent(stream2, "application/pdf",
				"Pasos de Inscripción.pdf");

	}

	public void DownloadFile3() {
		try {
			InputStream stream3 = ((ServletContext) FacesContext
					.getCurrentInstance().getExternalContext().getContext())
					.getResourceAsStream("/resources/docs/FormatoRegistroEstudiantes.xlsx");
			file3 = new DefaultStreamedContent(
					stream3,
					"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
					"Formato Registro Estudiantes.xlsx");
		} catch (Exception e) {
			System.out.println("Descarga de Archivo Cancelado");
		}

	}

	public void redirect() throws Exception {
		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		externalContext
				.redirect("http://www.ciudadyachay.com/es/eventos/olimpiada-de-ciencias-innopolis");
	}

	/**
	 * Metodo para culacular el tiempo entre 2 fechas
	 */
	public void calculoTiempo() {
		if (t_par != 0L) {
			long t_actual = new Date().getTime();
			if (t_par >= t_actual) {
				long t_total = t_par - t_actual;

				dia = t_total / (24 * 60 * 60 * 1000);
				hora = t_total / (60 * 60 * 1000);
				while (hora >= 24) {
					hora = hora - 24;
				}
				minuto = t_total / (60 * 1000);
				while (minuto >= 60) {
					minuto = minuto - 60;
				}
				segundo = t_total / 1000;
				while (segundo >= 60) {
					segundo = segundo - 60;
				}
				time = "Dias: " + dia + "\n Horas: " + hora + "\n Minutos: "
						+ minuto + "\n Segundos: " + segundo;
			} else {
				time = "Dias: 0 \n Horas: 0 \n Minutos: 0 \n Segundos: 0";
			}
		}

		System.out.println(time);
	}

}
