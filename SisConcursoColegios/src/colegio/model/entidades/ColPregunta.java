package colegio.model.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the col_pregunta database table.
 * 
 */
@Entity
@Table(name="col_pregunta")
@NamedQuery(name="ColPregunta.findAll", query="SELECT c FROM ColPregunta c")
public class ColPregunta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COL_PREGUNTA_PREID_GENERATOR", sequenceName="SEQ_PREGUNTA", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COL_PREGUNTA_PREID_GENERATOR")
	@Column(name="pre_id")
	private Integer preId;

	private Integer idx;

	@Column(name="pre_grupo_tematica")
	private String preGrupoTematica;

	@Column(name="pre_img_enunciado")
	private String preImgEnunciado;

	@Column(name="pre_img_pregunta")
	private String preImgPregunta;

	@Column(name="pre_topico")
	private String preTopico;

	//bi-directional many-to-one association to ColOpcionesRespuesta
	@OneToMany(mappedBy="colPregunta1")
	private List<ColOpcionesRespuesta> colOpcionesRespuestas1;

	//bi-directional many-to-one association to ColOpcionesRespuesta
	@OneToMany(mappedBy="colPregunta2")
	private List<ColOpcionesRespuesta> colOpcionesRespuestas2;

	//bi-directional many-to-one association to ColEvaluacion
	@ManyToOne
	@JoinColumn(name="col_evaluacion")
	private ColEvaluacion colEvaluacion1;

	//bi-directional many-to-one association to ColEvaluacion
	@ManyToOne
	@JoinColumn(name="eva_id")
	private ColEvaluacion colEvaluacion2;

	//bi-directional many-to-one association to ColRespuesta
	@OneToMany(mappedBy="colPregunta1")
	private List<ColRespuesta> colRespuestas1;

	//bi-directional many-to-one association to ColRespuesta
	@OneToMany(mappedBy="colPregunta2")
	private List<ColRespuesta> colRespuestas2;

	public ColPregunta() {
	}

	public Integer getPreId() {
		return this.preId;
	}

	public void setPreId(Integer preId) {
		this.preId = preId;
	}

	public Integer getIdx() {
		return this.idx;
	}

	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	public String getPreGrupoTematica() {
		return this.preGrupoTematica;
	}

	public void setPreGrupoTematica(String preGrupoTematica) {
		this.preGrupoTematica = preGrupoTematica;
	}

	public String getPreImgEnunciado() {
		return this.preImgEnunciado;
	}

	public void setPreImgEnunciado(String preImgEnunciado) {
		this.preImgEnunciado = preImgEnunciado;
	}

	public String getPreImgPregunta() {
		return this.preImgPregunta;
	}

	public void setPreImgPregunta(String preImgPregunta) {
		this.preImgPregunta = preImgPregunta;
	}

	public String getPreTopico() {
		return this.preTopico;
	}

	public void setPreTopico(String preTopico) {
		this.preTopico = preTopico;
	}

	public List<ColOpcionesRespuesta> getColOpcionesRespuestas1() {
		return this.colOpcionesRespuestas1;
	}

	public void setColOpcionesRespuestas1(List<ColOpcionesRespuesta> colOpcionesRespuestas1) {
		this.colOpcionesRespuestas1 = colOpcionesRespuestas1;
	}

	public ColOpcionesRespuesta addColOpcionesRespuestas1(ColOpcionesRespuesta colOpcionesRespuestas1) {
		getColOpcionesRespuestas1().add(colOpcionesRespuestas1);
		colOpcionesRespuestas1.setColPregunta1(this);

		return colOpcionesRespuestas1;
	}

	public ColOpcionesRespuesta removeColOpcionesRespuestas1(ColOpcionesRespuesta colOpcionesRespuestas1) {
		getColOpcionesRespuestas1().remove(colOpcionesRespuestas1);
		colOpcionesRespuestas1.setColPregunta1(null);

		return colOpcionesRespuestas1;
	}

	public List<ColOpcionesRespuesta> getColOpcionesRespuestas2() {
		return this.colOpcionesRespuestas2;
	}

	public void setColOpcionesRespuestas2(List<ColOpcionesRespuesta> colOpcionesRespuestas2) {
		this.colOpcionesRespuestas2 = colOpcionesRespuestas2;
	}

	public ColOpcionesRespuesta addColOpcionesRespuestas2(ColOpcionesRespuesta colOpcionesRespuestas2) {
		getColOpcionesRespuestas2().add(colOpcionesRespuestas2);
		colOpcionesRespuestas2.setColPregunta2(this);

		return colOpcionesRespuestas2;
	}

	public ColOpcionesRespuesta removeColOpcionesRespuestas2(ColOpcionesRespuesta colOpcionesRespuestas2) {
		getColOpcionesRespuestas2().remove(colOpcionesRespuestas2);
		colOpcionesRespuestas2.setColPregunta2(null);

		return colOpcionesRespuestas2;
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

	public List<ColRespuesta> getColRespuestas1() {
		return this.colRespuestas1;
	}

	public void setColRespuestas1(List<ColRespuesta> colRespuestas1) {
		this.colRespuestas1 = colRespuestas1;
	}

	public ColRespuesta addColRespuestas1(ColRespuesta colRespuestas1) {
		getColRespuestas1().add(colRespuestas1);
		colRespuestas1.setColPregunta1(this);

		return colRespuestas1;
	}

	public ColRespuesta removeColRespuestas1(ColRespuesta colRespuestas1) {
		getColRespuestas1().remove(colRespuestas1);
		colRespuestas1.setColPregunta1(null);

		return colRespuestas1;
	}

	public List<ColRespuesta> getColRespuestas2() {
		return this.colRespuestas2;
	}

	public void setColRespuestas2(List<ColRespuesta> colRespuestas2) {
		this.colRespuestas2 = colRespuestas2;
	}

	public ColRespuesta addColRespuestas2(ColRespuesta colRespuestas2) {
		getColRespuestas2().add(colRespuestas2);
		colRespuestas2.setColPregunta2(this);

		return colRespuestas2;
	}

	public ColRespuesta removeColRespuestas2(ColRespuesta colRespuestas2) {
		getColRespuestas2().remove(colRespuestas2);
		colRespuestas2.setColPregunta2(null);

		return colRespuestas2;
	}

}