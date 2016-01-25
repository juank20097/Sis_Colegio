package colegio.model.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the col_estudiante database table.
 * 
 */
@Entity
@Table(name="col_estudiante")
@NamedQuery(name="ColEstudiante.findAll", query="SELECT c FROM ColEstudiante c")
public class ColEstudiante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COL_ESTUDIANTE_ESTID_GENERATOR", sequenceName="SEQ_ESTUDIANTE", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COL_ESTUDIANTE_ESTID_GENERATOR")
	@Column(name="est_id")
	private Integer estId;

	@Column(name="est_apellidos")
	private String estApellidos;

	@Column(name="est_area")
	private String estArea;

	@Column(name="est_cedula")
	private String estCedula;

	@Column(name="est_clave")
	private String estClave;

	@Column(name="est_correo")
	private String estCorreo;

	@Column(name="est_estado")
	private String estEstado;

	@Column(name="est_fecha_fin")
	private Timestamp estFechaFin;

	@Column(name="est_fecha_ini")
	private Timestamp estFechaIni;

	@Column(name="est_mac")
	private String estMac;

	@Column(name="est_nombres")
	private String estNombres;

	@Column(name="est_telefono")
	private String estTelefono;

	//bi-directional many-to-one association to ColInstitucion
	@ManyToOne
	@JoinColumn(name="ins_id")
	private ColInstitucion colInstitucion;

	//bi-directional many-to-one association to ColEvaluacionEstudiantil
	@OneToMany(mappedBy="colEstudiante")
	private List<ColEvaluacionEstudiantil> colEvaluacionEstudiantils;

	public ColEstudiante() {
	}

	public Integer getEstId() {
		return this.estId;
	}

	public void setEstId(Integer estId) {
		this.estId = estId;
	}

	public String getEstApellidos() {
		return this.estApellidos;
	}

	public void setEstApellidos(String estApellidos) {
		this.estApellidos = estApellidos;
	}

	public String getEstArea() {
		return this.estArea;
	}

	public void setEstArea(String estArea) {
		this.estArea = estArea;
	}

	public String getEstCedula() {
		return this.estCedula;
	}

	public void setEstCedula(String estCedula) {
		this.estCedula = estCedula;
	}

	public String getEstClave() {
		return this.estClave;
	}

	public void setEstClave(String estClave) {
		this.estClave = estClave;
	}

	public String getEstCorreo() {
		return this.estCorreo;
	}

	public void setEstCorreo(String estCorreo) {
		this.estCorreo = estCorreo;
	}

	public String getEstEstado() {
		return this.estEstado;
	}

	public void setEstEstado(String estEstado) {
		this.estEstado = estEstado;
	}

	public Timestamp getEstFechaFin() {
		return this.estFechaFin;
	}

	public void setEstFechaFin(Timestamp estFechaFin) {
		this.estFechaFin = estFechaFin;
	}

	public Timestamp getEstFechaIni() {
		return this.estFechaIni;
	}

	public void setEstFechaIni(Timestamp estFechaIni) {
		this.estFechaIni = estFechaIni;
	}

	public String getEstMac() {
		return this.estMac;
	}

	public void setEstMac(String estMac) {
		this.estMac = estMac;
	}

	public String getEstNombres() {
		return this.estNombres;
	}

	public void setEstNombres(String estNombres) {
		this.estNombres = estNombres;
	}

	public String getEstTelefono() {
		return this.estTelefono;
	}

	public void setEstTelefono(String estTelefono) {
		this.estTelefono = estTelefono;
	}

	public ColInstitucion getColInstitucion() {
		return this.colInstitucion;
	}

	public void setColInstitucion(ColInstitucion colInstitucion) {
		this.colInstitucion = colInstitucion;
	}

	public List<ColEvaluacionEstudiantil> getColEvaluacionEstudiantils() {
		return this.colEvaluacionEstudiantils;
	}

	public void setColEvaluacionEstudiantils(List<ColEvaluacionEstudiantil> colEvaluacionEstudiantils) {
		this.colEvaluacionEstudiantils = colEvaluacionEstudiantils;
	}

	public ColEvaluacionEstudiantil addColEvaluacionEstudiantil(ColEvaluacionEstudiantil colEvaluacionEstudiantil) {
		getColEvaluacionEstudiantils().add(colEvaluacionEstudiantil);
		colEvaluacionEstudiantil.setColEstudiante(this);

		return colEvaluacionEstudiantil;
	}

	public ColEvaluacionEstudiantil removeColEvaluacionEstudiantil(ColEvaluacionEstudiantil colEvaluacionEstudiantil) {
		getColEvaluacionEstudiantils().remove(colEvaluacionEstudiantil);
		colEvaluacionEstudiantil.setColEstudiante(null);

		return colEvaluacionEstudiantil;
	}

}