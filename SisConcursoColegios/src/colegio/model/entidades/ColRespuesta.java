package colegio.model.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the col_respuesta database table.
 * 
 */
@Entity
@Table(name="col_respuesta")
@NamedQuery(name="ColRespuesta.findAll", query="SELECT c FROM ColRespuesta c")
public class ColRespuesta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COL_RESPUESTA_RESID_GENERATOR", sequenceName="SEQ_RESPUESTA", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COL_RESPUESTA_RESID_GENERATOR")
	@Column(name="res_id")
	private Integer resId;

	private Integer idx;

	@Column(name="res_fecha")
	private Timestamp resFecha;

	//bi-directional many-to-one association to ColEvaluacionEstudiantil
	@OneToMany(mappedBy="colRespuesta1")
	private List<ColEvaluacionEstudiantil> colEvaluacionEstudiantils1;

	//bi-directional many-to-one association to ColEvaluacionEstudiantil
	@OneToMany(mappedBy="colRespuesta2")
	private List<ColEvaluacionEstudiantil> colEvaluacionEstudiantils2;

	//bi-directional many-to-one association to ColOpcionesRespuesta
	@ManyToOne
	@JoinColumn(name="col_opc_respuesta")
	private ColOpcionesRespuesta colOpcionesRespuesta1;

	//bi-directional many-to-one association to ColOpcionesRespuesta
	@ManyToOne
	@JoinColumn(name="opr_id")
	private ColOpcionesRespuesta colOpcionesRespuesta2;

	//bi-directional many-to-one association to ColPregunta
	@ManyToOne
	@JoinColumn(name="col_pregunta")
	private ColPregunta colPregunta1;

	//bi-directional many-to-one association to ColPregunta
	@ManyToOne
	@JoinColumn(name="pre_id")
	private ColPregunta colPregunta2;

	public ColRespuesta() {
	}

	public Integer getResId() {
		return this.resId;
	}

	public void setResId(Integer resId) {
		this.resId = resId;
	}

	public Integer getIdx() {
		return this.idx;
	}

	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	public Timestamp getResFecha() {
		return this.resFecha;
	}

	public void setResFecha(Timestamp resFecha) {
		this.resFecha = resFecha;
	}

	public List<ColEvaluacionEstudiantil> getColEvaluacionEstudiantils1() {
		return this.colEvaluacionEstudiantils1;
	}

	public void setColEvaluacionEstudiantils1(List<ColEvaluacionEstudiantil> colEvaluacionEstudiantils1) {
		this.colEvaluacionEstudiantils1 = colEvaluacionEstudiantils1;
	}

	public ColEvaluacionEstudiantil addColEvaluacionEstudiantils1(ColEvaluacionEstudiantil colEvaluacionEstudiantils1) {
		getColEvaluacionEstudiantils1().add(colEvaluacionEstudiantils1);
		colEvaluacionEstudiantils1.setColRespuesta1(this);

		return colEvaluacionEstudiantils1;
	}

	public ColEvaluacionEstudiantil removeColEvaluacionEstudiantils1(ColEvaluacionEstudiantil colEvaluacionEstudiantils1) {
		getColEvaluacionEstudiantils1().remove(colEvaluacionEstudiantils1);
		colEvaluacionEstudiantils1.setColRespuesta1(null);

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
		colEvaluacionEstudiantils2.setColRespuesta2(this);

		return colEvaluacionEstudiantils2;
	}

	public ColEvaluacionEstudiantil removeColEvaluacionEstudiantils2(ColEvaluacionEstudiantil colEvaluacionEstudiantils2) {
		getColEvaluacionEstudiantils2().remove(colEvaluacionEstudiantils2);
		colEvaluacionEstudiantils2.setColRespuesta2(null);

		return colEvaluacionEstudiantils2;
	}

	public ColOpcionesRespuesta getColOpcionesRespuesta1() {
		return this.colOpcionesRespuesta1;
	}

	public void setColOpcionesRespuesta1(ColOpcionesRespuesta colOpcionesRespuesta1) {
		this.colOpcionesRespuesta1 = colOpcionesRespuesta1;
	}

	public ColOpcionesRespuesta getColOpcionesRespuesta2() {
		return this.colOpcionesRespuesta2;
	}

	public void setColOpcionesRespuesta2(ColOpcionesRespuesta colOpcionesRespuesta2) {
		this.colOpcionesRespuesta2 = colOpcionesRespuesta2;
	}

	public ColPregunta getColPregunta1() {
		return this.colPregunta1;
	}

	public void setColPregunta1(ColPregunta colPregunta1) {
		this.colPregunta1 = colPregunta1;
	}

	public ColPregunta getColPregunta2() {
		return this.colPregunta2;
	}

	public void setColPregunta2(ColPregunta colPregunta2) {
		this.colPregunta2 = colPregunta2;
	}

}