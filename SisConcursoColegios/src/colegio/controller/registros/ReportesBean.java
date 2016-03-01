package colegio.controller.registros;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import colegio.controller.generic.Mensaje;
import colegio.manager.ManagerConexion;
import colegio.model.conection.Resultado;
import colegio.model.entidades.ColInstitucion;


@ManagedBean
@ViewScoped
public class ReportesBean {
	
	ManagerConexion mngCon;
	
	private List<Resultado> listResultados;
	private String materia;
	private int institucion;
	
	public ReportesBean(){
		mngCon = new ManagerConexion();
		listResultados = new ArrayList<Resultado>();
		materia="";
		institucion=0;
		cargarResultados();
	}
	/**
	 * @return the listResultados
	 */
	public List<Resultado> getListResultados() {
		return listResultados;
	}
	/**
	 * @return the evaId
	 */
	public String getMateria() {
		return materia;
	}
	
	/**
	 * @param materia the materia to set
	 */
	public void setMateria(String materia) {
		this.materia = materia;
	}
	
	/**
	 * @return the institucion
	 */
	public int getInstitucion() {
		return institucion;
	}
	/**
	 * @param institucion the institucion to set
	 */
	public void setInstitucion(int institucion) {
		this.institucion = institucion;
	}
	/****************************** LISTA DE COMPONENTES ******************************/
	
	/**
	 * List de select item de las gerencias existentes
	 * 
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getInstituciones() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(0, "TODAS"));
		try {
			for (ColInstitucion ins : mngCon.findAllInstituciones()) {
				lista.add(new SelectItem(ins.getInsId(),ins.getInsNombre()));
			}
		} catch (Exception e) {
			Mensaje.crearMensajeERROR("Error al cargar las Instituciones. "
					+ e.getMessage());
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<SelectItem> getMaterias() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem("","TODAS"));
		lista.add(new SelectItem("Biología"));
		lista.add(new SelectItem("Física"));
		lista.add(new SelectItem("Matemáticas"));
		lista.add(new SelectItem("Química"));
		
		return lista;
	}
	/****************************** MÉTODOS ******************************/
	public void cargarResultados() {
		try {
			 listResultados.clear();
				listResultados.addAll(mngCon.resultadoEvaluaciones(institucion, materia));
		} catch (Exception e) {
			Mensaje.crearMensajeERROR("Error: " + e.getMessage());
			e.printStackTrace();
		}

	}
}
