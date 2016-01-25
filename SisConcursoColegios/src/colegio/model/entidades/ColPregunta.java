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

	@Column(name="pre_grupo_tematica")
	private String preGrupoTematica;

	@Column(name="pre_img_enunciado")
	private String preImgEnunciado;

	@Column(name="pre_img_pregunta")
	private String preImgPregunta;

	@Column(name="pre_topico")
	private String preTopico;

	//bi-directional many-to-one association to ColOpcionesRespuesta
	@OneToMany(mappedBy="colPregunta")
	private List<ColOpcionesRespuesta> colOpcionesRespuestas;

	//bi-directional many-to-one association to ColEvaluacion
	@ManyToOne
	@JoinColumn(name="eva_id")
	private ColEvaluacion colEvaluacion;

	//bi-directional many-to-one association to ColRespuesta
	@OneToMany(mappedBy="colPregunta")
	private List<ColRespuesta> colRespuestas;

	public ColPregunta() {
	}

	public Integer getPreId() {
		return this.preId;
	}

	public void setPreId(Integer preId) {
		this.preId = preId;
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

	public List<ColOpcionesRespuesta> getColOpcionesRespuestas() {
		return this.colOpcionesRespuestas;
	}

	public void setColOpcionesRespuestas(List<ColOpcionesRespuesta> colOpcionesRespuestas) {
		this.colOpcionesRespuestas = colOpcionesRespuestas;
	}

	public ColOpcionesRespuesta addColOpcionesRespuesta(ColOpcionesRespuesta colOpcionesRespuesta) {
		getColOpcionesRespuestas().add(colOpcionesRespuesta);
		colOpcionesRespuesta.setColPregunta(this);

		return colOpcionesRespuesta;
	}

	public ColOpcionesRespuesta removeColOpcionesRespuesta(ColOpcionesRespuesta colOpcionesRespuesta) {
		getColOpcionesRespuestas().remove(colOpcionesRespuesta);
		colOpcionesRespuesta.setColPregunta(null);

		return colOpcionesRespuesta;
	}

	public ColEvaluacion getColEvaluacion() {
		return this.colEvaluacion;
	}

	public void setColEvaluacion(ColEvaluacion colEvaluacion) {
		this.colEvaluacion = colEvaluacion;
	}

	public List<ColRespuesta> getColRespuestas() {
		return this.colRespuestas;
	}

	public void setColRespuestas(List<ColRespuesta> colRespuestas) {
		this.colRespuestas = colRespuestas;
	}

	public ColRespuesta addColRespuesta(ColRespuesta colRespuesta) {
		getColRespuestas().add(colRespuesta);
		colRespuesta.setColPregunta(this);

		return colRespuesta;
	}

	public ColRespuesta removeColRespuesta(ColRespuesta colRespuesta) {
		getColRespuestas().remove(colRespuesta);
		colRespuesta.setColPregunta(null);

		return colRespuesta;
	}

}