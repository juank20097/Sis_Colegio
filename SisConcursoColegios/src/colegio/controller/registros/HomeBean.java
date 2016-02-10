package colegio.controller.registros;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import colegio.manager.RegistrosDAO;

@ViewScoped
@ManagedBean
public class HomeBean implements Serializable{

	/**
	 * SERIAL ID
	 */
	private static final long serialVersionUID = -2576456513362226909L;
	
	private RegistrosDAO dao;
	private int idEstudiante;
	
	public HomeBean() {
		dao = new RegistrosDAO();
		idEstudiante = ((LogginBean) ((HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false)).getAttribute("logginBean"))
				.getEstudiante().getEstId();
	}
	
	public String resolverEvaluacion(){
		if(!dao.redireccionarEvaluacion(idEstudiante))
			return "evaluacion";
		else
			return "evaluacionEd";
	}
}
