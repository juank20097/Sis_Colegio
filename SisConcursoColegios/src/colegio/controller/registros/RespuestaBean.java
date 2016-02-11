package colegio.controller.registros;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import colegio.manager.RegistrosDAO;
import colegio.model.entidades.ColOpcionesRespuesta;
import colegio.model.entidades.ColRespuesta;

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
	
	private Integer valor;

	// variable de almacenamiento de datos
	private Integer idguardar;

	public RespuestaBean() {
		LogginBean.verificarSession();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		login = (LogginBean) session.getAttribute("logginBean");
		valor = login.getEstudiante().getEstId();
		manager = new RegistrosDAO();
	}

	/**
	 * @return the idguardar
	 */
	public Integer getIdguardar() {
		return idguardar;
	}

	/**
	 * @param idguardar
	 *            the idguardar to set
	 */
	public void setIdguardar(Integer idguardar) {
		this.idguardar = idguardar;
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
	 * Metodo para guardar la respuesta de una pregunta
	 * 
	 * @return
	 */
	public void insertarRespuesta() {
		try {
			ColOpcionesRespuesta or = new ColOpcionesRespuesta();
			or = manager.OpcionesByID(idguardar);
			List<ColRespuesta> lr = manager.findRespuestasxEstudiantePregunta(or
					.getColPregunta().getPreId(), valor);
			if (lr.size() == 0) {
				manager.insertarRespuesta(new Timestamp(new Date().getTime()),
						or.getOprId(), or.getColPregunta().getPreId(), valor, true);
			} else {
				for (ColRespuesta res : lr)
					manager.editarRespuesta(res.getResId(), new Timestamp(
							new Date().getTime()), or.getOprId());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}