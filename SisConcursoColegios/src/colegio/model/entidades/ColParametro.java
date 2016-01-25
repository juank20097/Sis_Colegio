package colegio.model.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the col_parametros database table.
 * 
 */
@Entity
@Table(name="col_parametros")
@NamedQuery(name="ColParametro.findAll", query="SELECT c FROM ColParametro c")
public class ColParametro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="par_id")
	private Integer parId;

	@Column(name="par_fecha")
	private Timestamp parFecha;

	@Column(name="par_referencia")
	private String parReferencia;

	public ColParametro() {
	}

	public Integer getParId() {
		return this.parId;
	}

	public void setParId(Integer parId) {
		this.parId = parId;
	}

	public Timestamp getParFecha() {
		return this.parFecha;
	}

	public void setParFecha(Timestamp parFecha) {
		this.parFecha = parFecha;
	}

	public String getParReferencia() {
		return this.parReferencia;
	}

	public void setParReferencia(String parReferencia) {
		this.parReferencia = parReferencia;
	}

}