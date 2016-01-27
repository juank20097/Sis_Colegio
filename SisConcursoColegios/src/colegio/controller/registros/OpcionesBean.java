package colegio.controller.registros;


import java.math.BigDecimal;
import java.util.ArrayList;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import colegio.manager.RegistrosDAO;
import colegio.model.entidades.ColOpcionesRespuesta;
import colegio.model.entidades.ColPregunta;

/**
 * @author jestevez
 * 
 */
@SessionScoped
@ManagedBean
public class OpcionesBean {

	// Llamada de los Dao y clases genericas
	private RegistrosDAO manager;

	private LogginBean login;

	// Atributos de las Preguntas
	private Integer oprId;
	private String oprOpcion;
	private String oprRespuesta;
	private BigDecimal oprValor;
	private Integer colPregunta;

	public OpcionesBean() {
		LogginBean.verificarSession();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		login = (LogginBean) session.getAttribute("logginBean");
		manager = new RegistrosDAO();
	}

	/**
	 * @return the login
	 */
	public LogginBean getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(LogginBean login) {
		this.login = login;
	}

	/**
	 * @return the oprId
	 */
	public Integer getOprId() {
		return oprId;
	}

	/**
	 * @param oprId
	 *            the oprId to set
	 */
	public void setOprId(Integer oprId) {
		this.oprId = oprId;
	}

	/**
	 * @return the oprOpcion
	 */
	public String getOprOpcion() {
		return oprOpcion;
	}

	/**
	 * @param oprOpcion
	 *            the oprOpcion to set
	 */
	public void setOprOpcion(String oprOpcion) {
		this.oprOpcion = oprOpcion;
	}

	/**
	 * @return the oprRespuesta
	 */
	public String getOprRespuesta() {
		return oprRespuesta;
	}

	/**
	 * @param oprRespuesta
	 *            the oprRespuesta to set
	 */
	public void setOprRespuesta(String oprRespuesta) {
		this.oprRespuesta = oprRespuesta;
	}

	/**
	 * @return the oprValor
	 */
	public BigDecimal getOprValor() {
		return oprValor;
	}

	/**
	 * @param oprValor
	 *            the oprValor to set
	 */
	public void setOprValor(BigDecimal oprValor) {
		this.oprValor = oprValor;
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
	 * Metodo para listar todos los Datos de la Entidad
	 * 
	 * @return
	 */
	public List<ColOpcionesRespuesta> getListPreguntas() {
		List<ColOpcionesRespuesta> p = new ArrayList<ColOpcionesRespuesta>();
		try {
			p = manager.findAllOpciones();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	public List<ColOpcionesRespuesta> resp(ColPregunta p) {
		List<ColOpcionesRespuesta> lp;
		List<ColOpcionesRespuesta> lres=new ArrayList<ColOpcionesRespuesta>();;
		try {
			lp = manager.findAllOpciones();
			for (ColOpcionesRespuesta pre : lp) {
				if (pre.getColPregunta().getPreId()==p.getPreId()){
					lres.add(pre);
				}
			}
			return lres;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return lres;
		}
	}
}