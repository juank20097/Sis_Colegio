package colegio.controller.registros;


import java.sql.Timestamp;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import colegio.controller.generic.Mensaje;
import colegio.manager.RegistrosDAO;
import colegio.model.entidades.ColOpcionesRespuesta;

/**
 * @author jestevez
 * 
 */
@SessionScoped
@ManagedBean
public class RespuestaBean {

	// Llamada de los Dao y clases genericas
	private RegistrosDAO manager;

	private LogginBean login;

	// Atributos de las Respuestas
	private Integer resId;
	private Timestamp resFecha;
	private Integer colOpcionesRespuesta;
	private Integer colPregunta;
	
	//variable de almacenamiento de datos
	private Integer idguardar;

	public RespuestaBean() {
		LogginBean.verificarSession();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		login = (LogginBean) session.getAttribute("logginBean");
		manager = new RegistrosDAO();
	}

	/**
	 * @return the idguardar
	 */
	public Integer getIdguardar() {
		return idguardar;
	}

	/**
	 * @param idguardar the idguardar to set
	 */
	public void setIdguardar(Integer idguardar) {
		this.idguardar = idguardar;
		if (getIdguardar()!=null || getIdguardar()!=0 ){
			this.insertarRespuesta();
		}
	}

	/**
	 * @return the login
	 */
	public LogginBean getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(LogginBean login) {
		this.login = login;
	}

	/**
	 * @return the resId
	 */
	public Integer getResId() {
		return resId;
	}

	/**
	 * @param resId
	 *            the resId to set
	 */
	public void setResId(Integer resId) {
		this.resId = resId;
	}

	/**
	 * @return the resFecha
	 */
	public Timestamp getResFecha() {
		return resFecha;
	}

	/**
	 * @param resFecha
	 *            the resFecha to set
	 */
	public void setResFecha(Timestamp resFecha) {
		this.resFecha = resFecha;
	}

	/**
	 * @return the colOpcionesRespuesta
	 */
	public Integer getColOpcionesRespuesta() {
		return colOpcionesRespuesta;
	}

	/**
	 * @param colOpcionesRespuesta
	 *            the colOpcionesRespuesta to set
	 */
	public void setColOpcionesRespuesta(Integer colOpcionesRespuesta) {
		this.colOpcionesRespuesta = colOpcionesRespuesta;
	}

	/**
	 * @return the colPregunta
	 */
	public Integer getColPregunta() {
		return colPregunta;
	}

	/**
	 * @param colPregunta
	 *            the colPregunta to set
	 */
	public void setColPregunta(Integer colPregunta) {
		this.colPregunta = colPregunta;
	}
	
	/**
	 * @return
	 */
	public void insertarRespuesta(){
		try {
			ColOpcionesRespuesta or = new ColOpcionesRespuesta();
			System.out.println("idguardar igual a:"+getIdguardar());
			or = manager.OpcionesByID(idguardar);
			manager.insertarRespuesta(new Timestamp(new Date().getTime()), or.getOprId(), or.getColPregunta().getPreId());
			Mensaje.crearMensajeINFO("Respuesta almacenada satisfactoriamente");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mostrar(){
		System.out.println(idguardar);
	}

}