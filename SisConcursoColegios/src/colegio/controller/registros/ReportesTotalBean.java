package colegio.controller.registros;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import colegio.controller.generic.Mensaje;
import colegio.model.conection.Resultado;
import colegio.model.conection.insti;
import colegio.model.entidades.ColInstitucion;
import colegio.manager.ManagerConexion;

@ManagedBean
@ViewScoped
public class ReportesTotalBean {
	
	ManagerConexion mngCon;
	
	private List<Resultado> listResultados;
	private List<insti> instituciones;
	
	private Integer hora;
	private Integer minuto;
	private Integer segundo;

	private Timestamp ts;
	
	public ReportesTotalBean(){
		mngCon = new ManagerConexion();
		listResultados = new ArrayList<Resultado>();
		instituciones = new ArrayList<insti>();
		hora = 0;
		minuto=0;
		segundo=0;
		cargarResultados();
		llenarDatos();
	}
	public List<insti> getInstituciones() {
		return instituciones;
	}
	public void setInstituciones(List<insti> instituciones) {
		this.instituciones = instituciones;
	}
	/**
	 * @return the listResultados
	 */
	public List<Resultado> getListResultados() {
		return listResultados;
	}
	
	/****************************** MÉTODOS ******************************/
	public void cargarResultados() {
		try {
			listResultados.clear();
			listResultados.addAll(mngCon.resultadoEvaluacionesGanadores());
		} catch (Exception e) {
			Mensaje.crearMensajeERROR("Error: " + e.getMessage());
			e.printStackTrace();
		}

	}
	
	public void llenarDatos(){
		try {
			instituciones.clear();
			for (ColInstitucion ins : mngCon.findAllInstituciones()) {
				insti dato = new insti();
				Integer sum_cal=0;
				Integer sum_num=0;
				hora=0;
				minuto=0;
				segundo=0;
				String tiempo=""; 
				for (Resultado res : mngCon.resultadoTotalGanadores()) {
					if (res.getInsNombre().trim().equals(ins.getInsNombre().trim())){
						sum_num++;
						sum_cal = sum_cal + res.getCalificacion();
						tiempo=sumaTiempo(StringToTimestamp(res.getTiempo()));
					}
				}
				dato.setInsCorreo(ins.getInsCooCorreo());
				dato.setInsAmie(ins.getInsAmie());
				dato.setInsProvincia(ins.getInsProvincia());
				dato.setInsNombre(ins.getInsNombre());
				dato.setCalificacion(sum_cal);
				dato.setAluNumero(sum_num);
				dato.setTiempo(tiempo);
				instituciones.add(dato);
			}
		} catch (Exception e) {
			Mensaje.crearMensajeERROR("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public Timestamp StringToTimestamp(String tiempo){
		String text = "2016-02-18 "+tiempo;
		ts = Timestamp.valueOf(text);
		return ts;
	}
	
	@SuppressWarnings("deprecation")
	public String sumaTiempo(Timestamp time){
		String rg="";
		
		hora = hora + time.getHours();
		
		minuto= minuto + time.getMinutes();
		while (minuto>=60){
			hora=hora+1;
			minuto=minuto-60;
		}
		
		segundo=segundo+time.getSeconds();
		while (segundo>=60){
			minuto=minuto+1;
			segundo=segundo-60;
		}
		
		String h=this.poner0(hora);
		String m=this.poner0(minuto);
		String s=this.poner0(segundo);
		
		rg = h+":"+m+":"+s;
		return rg;
	}
	
	public String poner0(Integer num){
		String t="";
		if (num<10){
			t="0"+num;
		}else{
			t=num.toString();
		}
		return t;
	}
	
	
}
