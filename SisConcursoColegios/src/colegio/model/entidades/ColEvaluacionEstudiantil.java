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
	private Integer eesCalificacion;

	@Column(name="ees_fecha_fin")
	private Timestamp eesFechaFin;

	@Column(name="ees_fecha_ini")
	private Timestamp eesFechaIni;

	//bi-directional many-to-one association to ColEstudiante
	@ManyToOne
	@JoinColumn(name="est_id")
	private ColEstudiante colEstudiante;

	//bi-directional many-to-one association to ColEvaluacion
	@ManyToOne
	@JoinColumn(name="eva_id")
	private ColEvaluacion colEvaluacion;

	public ColEvaluacionEstudiantil() {
	}

	public Integer getEesId() {
		return this.eesId;
	}

	public void setEesId(Integer eesId) {
		this.eesId = eesId;
	}

	public Integer getEesCalificacion() {
		return this.eesCalificacion;
	}

	public void setEesCalificacion(Integer eesCalificacion) {
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

	public ColEstudiante getColEstudiante() {
		return this.colEstudiante;
	}

	public void setColEstudiante(ColEstudiante colEstudiante) {
		this.colEstudiante = colEstudiante;
	}

	public ColEvaluacion getColEvaluacion() {
		return this.colEvaluacion;
	}

	public void setColEvaluacion(ColEvaluacion colEvaluacion) {
		this.colEvaluacion = colEvaluacion;
	}

}