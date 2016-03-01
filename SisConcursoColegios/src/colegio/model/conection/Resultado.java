package colegio.model.conection;

import java.sql.Timestamp;

public class Resultado {
	private String insAmie;
	private String insNombre;
	private String insProvincia;
	private String estCedula; 
	private String estApellido;
	private String insCorreo;
	private String estNombre;
	private String estArea;
	private Timestamp fechaInicio;
	private Timestamp fechaFin;
	private String tiempo;
	private Integer calificacion;
	
	public Resultado() {
	}
	
	public Resultado(String insAmie, String insNombre, String insProvincia,
			String estCedula,String estCorreo, String estApellido, String estNombre,
			String estArea, Timestamp fechaInicio, Timestamp fechaFin,
			String tiempo, Integer calificacion) {
		this.insAmie = insAmie;
		this.insNombre = insNombre;
		this.insProvincia = insProvincia;
		this.estCedula = estCedula;
		this.insCorreo = estCorreo;
		this.estApellido = estApellido;
		this.estNombre = estNombre;
		this.estArea = estArea;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.tiempo = tiempo;
		this.calificacion = calificacion;
	}
	
	public Resultado(String insAmie, String insNombre, String insProvincia,
			String estCedula, String estApellido, String estNombre,
			String estArea, Timestamp fechaInicio, Timestamp fechaFin,
			String tiempo, Integer calificacion) {
		this.insAmie = insAmie;
		this.insNombre = insNombre;
		this.insProvincia = insProvincia;
		this.estCedula = estCedula;
		this.estApellido = estApellido;
		this.estNombre = estNombre;
		this.estArea = estArea;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.tiempo = tiempo;
		this.calificacion = calificacion;
	}
	
	public Resultado(String insAmie,String insNombre,String insProvincia, String estArea,
			String tiempo, Integer calificacion) {
		this.insAmie = insAmie;
		this.insNombre = insNombre;
		this.insProvincia = insProvincia;
		this.estArea = estArea;
		this.tiempo = tiempo;
		this.calificacion = calificacion;
	}



	/**
	 * @return the insCorreo
	 */
	public String getInsCorreo() {
		return insCorreo;
	}

	/**
	 * @param insCorreo the insCorreo to set
	 */
	public void setInsCorreo(String insCorreo) {
		this.insCorreo = insCorreo;
	}

	/**
	 * @return the insAmie
	 */
	public String getInsAmie() {
		return insAmie;
	}

	/**
	 * @param insAmie the insAmie to set
	 */
	public void setInsAmie(String insAmie) {
		this.insAmie = insAmie;
	}

	/**
	 * @return the insNombre
	 */
	public String getInsNombre() {
		return insNombre;
	}

	/**
	 * @param insNombre the insNombre to set
	 */
	public void setInsNombre(String insNombre) {
		this.insNombre = insNombre;
	}

	/**
	 * @return the insProvincia
	 */
	public String getInsProvincia() {
		return insProvincia;
	}

	/**
	 * @param insProvincia the insProvincia to set
	 */
	public void setInsProvincia(String insProvincia) {
		this.insProvincia = insProvincia;
	}

	/**
	 * @return the estCedula
	 */
	public String getEstCedula() {
		return estCedula;
	}

	/**
	 * @param estCedula the estCedula to set
	 */
	public void setEstCedula(String estCedula) {
		this.estCedula = estCedula;
	}

	/**
	 * @return the estApellido
	 */
	public String getEstApellido() {
		return estApellido;
	}

	/**
	 * @param estApellido the estApellido to set
	 */
	public void setEstApellido(String estApellido) {
		this.estApellido = estApellido;
	}

	/**
	 * @return the estNombre
	 */
	public String getEstNombre() {
		return estNombre;
	}

	/**
	 * @param estNombre the estNombre to set
	 */
	public void setEstNombre(String estNombre) {
		this.estNombre = estNombre;
	}
	
	public String getEstArea() {
		return estArea;
	}
	
	public void setEstArea(String estArea) {
		this.estArea = estArea;
	}
	
	/**
	 * @return the fechaInicio
	 */
	public Timestamp getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Timestamp fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return the fechaFin
	 */
	public Timestamp getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Timestamp fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * @return the tiempo
	 */
	public String getTiempo() {
		return tiempo;
	}

	/**
	 * @param tiempo the tiempo to set
	 */
	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	/**
	 * @return the calificacion
	 */
	public Integer getCalificacion() {
		return calificacion;
	}

	/**
	 * @param calificacion the calificacion to set
	 */
	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}
	
	
}
