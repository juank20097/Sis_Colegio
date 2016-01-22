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
	@OneToMany(mappedBy="colEvaluacion1")
	private List<ColEvaluacionEstudiantil> colEvaluacionEstudiantils1;

	//bi-directional many-to-one association to ColEvaluacionEstudiantil
	@OneToMany(mappedBy="colEvaluacion2")
	private List<ColEvaluacionEstudiantil> colEvaluacionEstudiantils2;

	//bi-directional many-to-one association to ColPregunta
	@OneToMany(mappedBy="colEvaluacion1")
	private List<ColPregunta> colPreguntas1;

	//bi-directional many-to-one association to ColPregunta
	@OneToMany(mappedBy="colEvaluacion2")
	private List<ColPregunta> colPreguntas2;

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

	public List<ColEvaluacionEstudiantil> getColEvaluacionEstudiantils1() {
		return this.colEvaluacionEstudiantils1;
	}

	public void setColEvaluacionEstudiantils1(List<ColEvaluacionEstudiantil> colEvaluacionEstudiantils1) {
		this.colEvaluacionEstudiantils1 = colEvaluacionEstudiantils1;
	}

	public ColEvaluacionEstudiantil addColEvaluacionEstudiantils1(ColEvaluacionEstudiantil colEvaluacionEstudiantils1) {
		getColEvaluacionEstudiantils1().add(colEvaluacionEstudiantils1);
		colEvaluacionEstudiantils1.setColEvaluacion1(this);

		return colEvaluacionEstudiantils1;
	}

	public ColEvaluacionEstudiantil removeColEvaluacionEstudiantils1(ColEvaluacionEstudiantil colEvaluacionEstudiantils1) {
		getColEvaluacionEstudiantils1().remove(colEvaluacionEstudiantils1);
		colEvaluacionEstudiantils1.setColEvaluacion1(null);

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
		colEvaluacionEstudiantils2.setColEvaluacion2(this);

		return colEvaluacionEstudiantils2;
	}

	public ColEvaluacionEstudiantil removeColEvaluacionEstudiantils2(ColEvaluacionEstudiantil colEvaluacionEstudiantils2) {
		getColEvaluacionEstudiantils2().remove(colEvaluacionEstudiantils2);
		colEvaluacionEstudiantils2.setColEvaluacion2(null);

		return colEvaluacionEstudiantils2;
	}

	public List<ColPregunta> getColPreguntas1() {
		return this.colPreguntas1;
	}

	public void setColPreguntas1(List<ColPregunta> colPreguntas1) {
		this.colPreguntas1 = colPreguntas1;
	}

	public ColPregunta addColPreguntas1(ColPregunta colPreguntas1) {
		getColPreguntas1().add(colPreguntas1);
		colPreguntas1.setColEvaluacion1(this);

		return colPreguntas1;
	}

	public ColPregunta removeColPreguntas1(ColPregunta colPreguntas1) {
		getColPreguntas1().remove(colPreguntas1);
		colPreguntas1.setColEvaluacion1(null);

		return colPreguntas1;
	}

	public List<ColPregunta> getColPreguntas2() {
		return this.colPreguntas2;
	}

	public void setColPreguntas2(List<ColPregunta> colPreguntas2) {
		this.colPreguntas2 = colPreguntas2;
	}

	public ColPregunta addColPreguntas2(ColPregunta colPreguntas2) {
		getColPreguntas2().add(colPreguntas2);
		colPreguntas2.setColEvaluacion2(this);

		return colPreguntas2;
	}

	public ColPregunta removeColPreguntas2(ColPregunta colPreguntas2) {
		getColPreguntas2().remove(colPreguntas2);
		colPreguntas2.setColEvaluacion2(null);

		return colPreguntas2;
	}

}