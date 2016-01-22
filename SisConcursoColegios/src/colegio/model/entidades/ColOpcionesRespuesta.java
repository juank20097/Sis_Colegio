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

	private Integer idx;

	@Column(name="opr_opcion")
	private String oprOpcion;

	@Column(name="opr_respuesta")
	private String oprRespuesta;

	@Column(name="opr_valor")
	private double oprValor;

	//bi-directional many-to-one association to ColPregunta
	@ManyToOne
	@JoinColumn(name="col_pregunta")
	private ColPregunta colPregunta1;

	//bi-directional many-to-one association to ColPregunta
	@ManyToOne
	@JoinColumn(name="pre_id")
	private ColPregunta colPregunta2;

	//bi-directional many-to-one association to ColRespuesta
	@OneToMany(mappedBy="colOpcionesRespuesta1")
	private List<ColRespuesta> colRespuestas1;

	//bi-directional many-to-one association to ColRespuesta
	@OneToMany(mappedBy="colOpcionesRespuesta2")
	private List<ColRespuesta> colRespuestas2;

	public ColOpcionesRespuesta() {
	}

	public Integer getOprId() {
		return this.oprId;
	}

	public void setOprId(Integer oprId) {
		this.oprId = oprId;
	}

	public Integer getIdx() {
		return this.idx;
	}

	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	public String getOprOpcion() {
		return this.oprOpcion;
	}

	public void setOprOpcion(String oprOpcion) {
		this.oprOpcion = oprOpcion;
	}

	public String getOprRespuesta() {
		return this.oprRespuesta;
	}

	public void setOprRespuesta(String oprRespuesta) {
		this.oprRespuesta = oprRespuesta;
	}

	public double getOprValor() {
		return this.oprValor;
	}

	public void setOprValor(double oprValor) {
		this.oprValor = oprValor;
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

	public List<ColRespuesta> getColRespuestas1() {
		return this.colRespuestas1;
	}

	public void setColRespuestas1(List<ColRespuesta> colRespuestas1) {
		this.colRespuestas1 = colRespuestas1;
	}

	public ColRespuesta addColRespuestas1(ColRespuesta colRespuestas1) {
		getColRespuestas1().add(colRespuestas1);
		colRespuestas1.setColOpcionesRespuesta1(this);

		return colRespuestas1;
	}

	public ColRespuesta removeColRespuestas1(ColRespuesta colRespuestas1) {
		getColRespuestas1().remove(colRespuestas1);
		colRespuestas1.setColOpcionesRespuesta1(null);

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
		colRespuestas2.setColOpcionesRespuesta2(this);

		return colRespuestas2;
	}

	public ColRespuesta removeColRespuestas2(ColRespuesta colRespuestas2) {
		getColRespuestas2().remove(colRespuestas2);
		colRespuestas2.setColOpcionesRespuesta2(null);

		return colRespuestas2;
	}

}