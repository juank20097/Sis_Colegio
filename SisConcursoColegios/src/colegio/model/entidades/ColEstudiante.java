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

	private Integer idx;

	//bi-directional many-to-one association to ColInstitucion
	@ManyToOne
	@JoinColumn(name="col_institucion")
	private ColInstitucion colInstitucion1;

	//bi-directional many-to-one association to ColInstitucion
	@ManyToOne
	@JoinColumn(name="ins_id")
	private ColInstitucion colInstitucion2;

	//bi-directional many-to-one association to ColEvaluacionEstudiantil
	@OneToMany(mappedBy="colEstudiante1")
	private List<ColEvaluacionEstudiantil> colEvaluacionEstudiantils1;

	//bi-directional many-to-one association to ColEvaluacionEstudiantil
	@OneToMany(mappedBy="colEstudiante2")
	private List<ColEvaluacionEstudiantil> colEvaluacionEstudiantils2;

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

	public Integer getIdx() {
		return this.idx;
	}

	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	public ColInstitucion getColInstitucion1() {
		return this.colInstitucion1;
	}

	public void setColInstitucion1(ColInstitucion colInstitucion1) {
		this.colInstitucion1 = colInstitucion1;
	}

	public ColInstitucion getColInstitucion2() {
		return this.colInstitucion2;
	}

	public void setColInstitucion2(ColInstitucion colInstitucion2) {
		this.colInstitucion2 = colInstitucion2;
	}

	public List<ColEvaluacionEstudiantil> getColEvaluacionEstudiantils1() {
		return this.colEvaluacionEstudiantils1;
	}

	public void setColEvaluacionEstudiantils1(List<ColEvaluacionEstudiantil> colEvaluacionEstudiantils1) {
		this.colEvaluacionEstudiantils1 = colEvaluacionEstudiantils1;
	}

	public ColEvaluacionEstudiantil addColEvaluacionEstudiantils1(ColEvaluacionEstudiantil colEvaluacionEstudiantils1) {
		getColEvaluacionEstudiantils1().add(colEvaluacionEstudiantils1);
		colEvaluacionEstudiantils1.setColEstudiante1(this);

		return colEvaluacionEstudiantils1;
	}

	public ColEvaluacionEstudiantil removeColEvaluacionEstudiantils1(ColEvaluacionEstudiantil colEvaluacionEstudiantils1) {
		getColEvaluacionEstudiantils1().remove(colEvaluacionEstudiantils1);
		colEvaluacionEstudiantils1.setColEstudiante1(null);

		return colEvaluacionEstudiantils1;
	}

	public List<ColEvaluacionEstudiantil> getColEvaluacionEstudiantils2() {
		return this.colEvaluacionEstudiantils2;
	}

	public void setColEvaluacionEstudiantils2(List<ColEvaluacionEstudiantil> colEvaluacionEstudiantils2) {
		this.colEvaluacionEstudiantils2 = colEvaluacionEstudiantils2;
	}

	public ColEvaluacionEstudiantil addColEvaluacionEstudiantils2(ColEvaluacionEstudiantil colEvaluacionEstudiantils2) {
		getColEvaluacionEstudiantils2().add(colEvaluacionEstudiantils2);
		colEvaluacionEstudiantils2.setColEstudiante2(this);

		return colEvaluacionEstudiantils2;
	}

	public ColEvaluacionEstudiantil removeColEvaluacionEstudiantils2(ColEvaluacionEstudiantil colEvaluacionEstudiantils2) {
		getColEvaluacionEstudiantils2().remove(colEvaluacionEstudiantils2);
		colEvaluacionEstudiantils2.setColEstudiante2(null);

		return colEvaluacionEstudiantils2;
	}

}