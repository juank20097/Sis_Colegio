package colegio.model.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the col_opciones_respuesta database table.
 * 
 */
@Entity
@Table(name="col_opciones_respuesta")
@NamedQuery(name="ColOpcionesRespuesta.findAll", query="SELECT c FROM ColOpcionesRespuesta c")
public class ColOpcionesRespuesta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COL_OPCIONES_RESPUESTA_OPRID_GENERATOR", sequenceName="SEQ_OPC_RESPUESTA", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COL_OPCIONES_RESPUESTA_OPRID_GENERATOR")
	@Column(name="opr_id")
	private Integer oprId;

	@Column(name="opr_opcion")
	private String oprOpcion;

	@Column(name="opr_valor")
	private Integer oprValor;

	//bi-directional many-to-one association to ColPregunta
	@ManyToOne
	@JoinColumn(name="pre_id")
	private ColPregunta colPregunta;

	//bi-directional many-to-one association to ColRespuesta
	@OneToMany(mappedBy="colOpcionesRespuesta")
	private List<ColRespuesta> colRespuestas;

	public ColOpcionesRespuesta() {
	}

	public Integer getOprId() {
		return this.oprId;
	}

	public void setOprId(Integer oprId) {
		this.oprId = oprId;
	}

	public String getOprOpcion() {
		return this.oprOpcion;
	}

	public void setOprOpcion(String oprOpcion) {
		this.oprOpcion = oprOpcion;
	}

	public Integer getOprValor() {
		return this.oprValor;
	}

	public void setOprValor(Integer oprValor) {
		this.oprValor = oprValor;
	}

	public ColPregunta getColPregunta() {
		return this.colPregunta;
	}

	public void setColPregunta(ColPregunta colPregunta) {
		this.colPregunta = colPregunta;
	}

	public List<ColRespuesta> getColRespuestas() {
		return this.colRespuestas;
	}

	public void setColRespuestas(List<ColRespuesta> colRespuestas) {
		this.colRespuestas = colRespuestas;
	}

	public ColRespuesta addColRespuesta(ColRespuesta colRespuesta) {
		getColRespuestas().add(colRespuesta);
		colRespuesta.setColOpcionesRespuesta(this);

		return colRespuesta;
	}

	public ColRespuesta removeColRespuesta(ColRespuesta colRespuesta) {
		getColRespuestas().remove(colRespuesta);
		colRespuesta.setColOpcionesRespuesta(null);

		return colRespuesta;
	}

}