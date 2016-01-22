package colegio.model.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the col_evaluacion_estudiantil database table.
 * 
 */
@Entity
@Table(name="col_evaluacion_estudiantil")
@NamedQuery(name="ColEvaluacionEstudiantil.findAll", query="SELECT c FROM ColEvaluacionEstudiantil c")
public class ColEvaluacionEstudiantil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COL_EVALUACION_ESTUDIANTIL_EESID_GENERATOR", sequenceName="SEQ_EVA_ESTUDIANTIL", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COL_EVALUACION_ESTUDIANTIL_EESID_GENERATOR")
	@Column(name="ees_id")
	private Integer eesId;

	@Column(name="ees_calificacion")
	private double eesCalificacion;

	@Column(name="ees_fecha_fin")
	private Timestamp eesFechaFin;

	@Column(name="ees_fecha_ini")
	private Timestamp eesFechaIni;

	private Integer idx;

	//bi-directional many-to-one association to ColEstudiante
	@ManyToOne
	@JoinColumn(name="col_estudiante")
	private ColEstudiante colEstudiante1;

	//bi-directional many-to-one association to ColEstudiante
	@ManyToOne
	@JoinColumn(name="est_id")
	private ColEstudiante colEstudiante2;

	//bi-directional many-to-one association to ColEvaluacion
	@ManyToOne
	@JoinColumn(name="col_evaluacion")
	private ColEvaluacion colEvaluacion1;

	//bi-directional many-to-one association to ColEvaluacion
	@ManyToOne
	@JoinColumn(name="eva_id")
	private ColEvaluacion colEvaluacion2;

	//bi-directional many-to-one association to ColRespuesta
	@ManyToOne
	@JoinColumn(name="res_id")
	private ColRespuesta colRespuesta1;

	//bi-directional many-to-one association to ColRespuesta
	@ManyToOne
	@JoinColumn(name="col_respuesta")
	private ColRespuesta colRespuesta2;

	public ColEvaluacionEstudiantil() {
	}

	public Integer getEesId() {
		return this.eesId;
	}

	public void setEesId(Integer eesId) {
		this.eesId = eesId;
	}

	public double getEesCalificacion() {
		return this.eesCalificacion;
	}

	public void setEesCalificacion(double eesCalificacion) {
		this.eesCalificacion = eesCalificacion;
	}

	public Timestamp getEesFechaFin() {
		return this.eesFechaFin;
	}

	public void setEesFechaFin(Timestamp eesFechaFin) {
		this.eesFechaFin = eesFechaFin;
	}

	public Timestamp getEesFechaIni() {
		return this.eesFechaIni;
	}

	public void setEesFechaIni(Timestamp eesFechaIni) {
		this.eesFechaIni = eesFechaIni;
	}

	public Integer getIdx() {
		return this.idx;
	}

	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	public ColEstudiante getColEstudiante1() {
		return this.colEstudiante1;
	}

	public void setColEstudiante1(ColEstudiante colEstudiante1) {
		this.colEstudiante1 = colEstudiante1;
	}

	public ColEstudiante getColEstudiante2() {
		return this.colEstudiante2;
	}

	public void setColEstudiante2(ColEstudiante colEstudiante2) {
		this.colEstudiante2 = colEstudiante2;
	}

	public ColEvaluacion getColEvaluacion1() {
		return this.colEvaluacion1;
	}

	public void setColEvaluacion1(ColEvaluacion colEvaluacion1) {
		this.colEvaluacion1 = colEvaluacion1;
	}

	public ColEvaluacion getColEvaluacion2() {
		return this.colEvaluacion2;
	}

	public void setColEvaluacion2(ColEvaluacion colEvaluacion2) {
		this.colEvaluacion2 = colEvaluacion2;
	}

	public ColRespuesta getColRespuesta1() {
		return this.colRespuesta1;
	}

	public void setColRespuesta1(ColRespuesta colRespuesta1) {
		this.colRespuesta1 = colRespuesta1;
	}

	public ColRespuesta getColRespuesta2() {
		return this.colRespuesta2;
	}

	public void setColRespuesta2(ColRespuesta colRespuesta2) {
		this.colRespuesta2 = colRespuesta2;
	}

}