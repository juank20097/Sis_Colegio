package colegio.model.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the col_evaluacion database table.
 * 
 */
@Entity
@Table(name="col_evaluacion")
@NamedQuery(name="ColEvaluacion.findAll", query="SELECT c FROM ColEvaluacion c")
public class ColEvaluacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COL_EVALUACION_EVAID_GENERATOR", sequenceName="SEQ_EVALUACION", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COL_EVALUACION_EVAID_GENERATOR")
	@Column(name="eva_id")
	private Integer evaId;

	@Column(name="eva_area")
	private String evaArea;

	@Column(name="eva_estado")
	private String evaEstado;

	@Column(name="eva_nombre")
	private String evaNombre;

	@Column(name="eva_periodo")
	private String evaPeriodo;

	//bi-directional many-to-one association to ColEvaluacionEstudiantil
	@OneToMany(mappedBy="colEvaluacion")
	private List<ColEvaluacionEstudiantil> colEvaluacionEstudiantils;

	//bi-directional many-to-one association to ColPregunta
	@OneToMany(mappedBy="colEvaluacion")
	private List<ColPregunta> colPreguntas;

	public ColEvaluacion() {
	}

	public Integer getEvaId() {
		return this.evaId;
	}

	public void setEvaId(Integer evaId) {
		this.evaId = evaId;
	}

	public String getEvaArea() {
		return this.evaArea;
	}

	public void setEvaArea(String evaArea) {
		this.evaArea = evaArea;
	}

	public String getEvaEstado() {
		return this.evaEstado;
	}

	public void setEvaEstado(String evaEstado) {
		this.evaEstado = evaEstado;
	}

	public String getEvaNombre() {
		return this.evaNombre;
	}

	public void setEvaNombre(String evaNombre) {
		this.evaNombre = evaNombre;
	}

	public String getEvaPeriodo() {
		return this.evaPeriodo;
	}

	public void setEvaPeriodo(String evaPeriodo) {
		this.evaPeriodo = evaPeriodo;
	}

	public List<ColEvaluacionEstudiantil> getColEvaluacionEstudiantils() {
		return this.colEvaluacionEstudiantils;
	}

	public void setColEvaluacionEstudiantils(List<ColEvaluacionEstudiantil> colEvaluacionEstudiantils) {
		this.colEvaluacionEstudiantils = colEvaluacionEstudiantils;
	}

	public ColEvaluacionEstudiantil addColEvaluacionEstudiantil(ColEvaluacionEstudiantil colEvaluacionEstudiantil) {
		getColEvaluacionEstudiantils().add(colEvaluacionEstudiantil);
		colEvaluacionEstudiantil.setColEvaluacion(this);

		return colEvaluacionEstudiantil;
	}

	public ColEvaluacionEstudiantil removeColEvaluacionEstudiantil(ColEvaluacionEstudiantil colEvaluacionEstudiantil) {
		getColEvaluacionEstudiantils().remove(colEvaluacionEstudiantil);
		colEvaluacionEstudiantil.setColEvaluacion(null);

		return colEvaluacionEstudiantil;
	}

	public List<ColPregunta> getColPreguntas() {
		return this.colPreguntas;
	}

	public void setColPreguntas(List<ColPregunta> colPreguntas) {
		this.colPreguntas = colPreguntas;
	}

	public ColPregunta addColPregunta(ColPregunta colPregunta) {
		getColPreguntas().add(colPregunta);
		colPregunta.setColEvaluacion(this);

		return colPregunta;
	}

	public ColPregunta removeColPregunta(ColPregunta colPregunta) {
		getColPreguntas().remove(colPregunta);
		colPregunta.setColEvaluacion(null);

		return colPregunta;
	}

}