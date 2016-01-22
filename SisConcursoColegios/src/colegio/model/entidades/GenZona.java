package colegio.model.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the gen_zona database table.
 * 
 */
@Entity
@Table(name="gen_zona")
@NamedQuery(name="GenZona.findAll", query="SELECT g FROM GenZona g")
public class GenZona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="zon_id")
	private Integer zonId;

	@Column(name="zon_nombre")
	private String zonNombre;

	//bi-directional many-to-one association to GenProvincia
	@OneToMany(mappedBy="genZona1")
	private List<GenProvincia> genProvincias1;

	//bi-directional many-to-one association to GenProvincia
	@OneToMany(mappedBy="genZona2")
	private List<GenProvincia> genProvincias2;

	public GenZona() {
	}

	public Integer getZonId() {
		return this.zonId;
	}

	public void setZonId(Integer zonId) {
		this.zonId = zonId;
	}

	public String getZonNombre() {
		return this.zonNombre;
	}

	public void setZonNombre(String zonNombre) {
		this.zonNombre = zonNombre;
	}

	public List<GenProvincia> getGenProvincias1() {
		return this.genProvincias1;
	}

	public void setGenProvincias1(List<GenProvincia> genProvincias1) {
		this.genProvincias1 = genProvincias1;
	}

	public GenProvincia addGenProvincias1(GenProvincia genProvincias1) {
		getGenProvincias1().add(genProvincias1);
		genProvincias1.setGenZona1(this);

		return genProvincias1;
	}

	public GenProvincia removeGenProvincias1(GenProvincia genProvincias1) {
		getGenProvincias1().remove(genProvincias1);
		genProvincias1.setGenZona1(null);

		return genProvincias1;
	}

	public List<GenProvincia> getGenProvincias2() {
		return this.genProvincias2;
	}

	public void setGenProvincias2(List<GenProvincia> genProvincias2) {
		this.genProvincias2 = genProvincias2;
	}

	public GenProvincia addGenProvincias2(GenProvincia genProvincias2) {
		getGenProvincias2().add(genProvincias2);
		genProvincias2.setGenZona2(this);

		return genProvincias2;
	}

	public GenProvincia removeGenProvincias2(GenProvincia genProvincias2) {
		getGenProvincias2().remove(genProvincias2);
		genProvincias2.setGenZona2(null);

		return genProvincias2;
	}

}