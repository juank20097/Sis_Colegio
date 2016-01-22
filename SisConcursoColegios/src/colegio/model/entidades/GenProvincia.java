package colegio.model.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the gen_provincia database table.
 * 
 */
@Entity
@Table(name="gen_provincia")
@NamedQuery(name="GenProvincia.findAll", query="SELECT g FROM GenProvincia g")
public class GenProvincia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pro_id")
	private Integer proId;

	private Integer idx;

	@Column(name="pro_nombre")
	private String proNombre;

	//bi-directional many-to-one association to GenZona
	@ManyToOne
	@JoinColumn(name="zon_id")
	private GenZona genZona1;

	//bi-directional many-to-one association to GenZona
	@ManyToOne
	@JoinColumn(name="gen_zona")
	private GenZona genZona2;

	public GenProvincia() {
	}

	public Integer getProId() {
		return this.proId;
	}

	public void setProId(Integer proId) {
		this.proId = proId;
	}

	public Integer getIdx() {
		return this.idx;
	}

	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	public String getProNombre() {
		return this.proNombre;
	}

	public void setProNombre(String proNombre) {
		this.proNombre = proNombre;
	}

	public GenZona getGenZona1() {
		return this.genZona1;
	}

	public void setGenZona1(GenZona genZona1) {
		this.genZona1 = genZona1;
	}

	public GenZona getGenZona2() {
		return this.genZona2;
	}

	public void setGenZona2(GenZona genZona2) {
		this.genZona2 = genZona2;
	}

}