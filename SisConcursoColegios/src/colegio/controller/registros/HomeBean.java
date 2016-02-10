package colegio.controller.registros;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
		idEstudiante = 6;
	}
	
	public String resolverEvaluacion(){
		return dao.redireccionarEvaluacion(idEstudiante);
	}

}
