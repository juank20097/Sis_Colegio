package colegio.model.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the col_instituciones_senescyt database table.
 * 
 */
@Entity
@Table(name="col_instituciones_senescyt")
@NamedQuery(name="ColInstitucionesSenescyt.findAll", query="SELECT c FROM ColInstitucionesSenescyt c")
public class ColInstitucionesSenescyt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sen_amie")
	private String senAmie;

	@Column(name="sen_correo")
	private String senCorreo;

	@Column(name="sen_direccion")
	private String senDireccion;

	@Column(name="sen_nombre")
	private String senNombre;

	@Column(name="sen_provincia")
	private String senProvincia;

	@Column(name="sen_rep_apellidos")
	private String senRepApellidos;

	@Column(name="sen_rep_cargo")
	private String senRepCargo;

	@Column(name="sen_rep_cedula")
	private String senRepCedula;

	@Column(name="sen_rep_celular")
	private String senRepCelular;

	@Column(name="sen_rep_correo")
	private String senRepCorreo;

	@Column(name="sen_rep_nombres")
	private String senRepNombres;

	@Column(name="sen_rep_telefono")
	private String senRepTelefono;

	@Column(name="sen_telefono")
	private String senTelefono;

	@Column(name="sen_zona")
	private String senZona;

	public ColInstitucionesSenescyt() {
	}

	public String getSenAmie() {
		return this.senAmie;
	}

	public void setSenAmie(String senAmie) {
		this.senAmie = senAmie;
	}

	public String getSenCorreo() {
		return this.senCorreo;
	}

	public void setSenCorreo(String senCorreo) {
		this.senCorreo = senCorreo;
	}

	public String getSenDireccion() {
		return this.senDireccion;
	}

	public void setSenDireccion(String senDireccion) {
		this.senDireccion = senDireccion;
	}

	public String getSenNombre() {
		return this.senNombre;
	}

	public void setSenNombre(String senNombre) {
		this.senNombre = senNombre;
	}

	public String getSenProvincia() {
		return this.senProvincia;
	}

	public void setSenProvincia(String senProvincia) {
		this.senProvincia = senProvincia;
	}

	public String getSenRepApellidos() {
		return this.senRepApellidos;
	}

	public void setSenRepApellidos(String senRepApellidos) {
		this.senRepApellidos = senRepApellidos;
	}

	public String getSenRepCargo() {
		return this.senRepCargo;
	}

	public void setSenRepCargo(String senRepCargo) {
		this.senRepCargo = senRepCargo;
	}

	public String getSenRepCedula() {
		return this.senRepCedula;
	}

	public void setSenRepCedula(String senRepCedula) {
		this.senRepCedula = senRepCedula;
	}

	public String getSenRepCelular() {
		return this.senRepCelular;
	}

	public void setSenRepCelular(String senRepCelular) {
		this.senRepCelular = senRepCelular;
	}

	public String getSenRepCorreo() {
		return this.senRepCorreo;
	}

	public void setSenRepCorreo(String senRepCorreo) {
		this.senRepCorreo = senRepCorreo;
	}

	public String getSenRepNombres() {
		return this.senRepNombres;
	}

	public void setSenRepNombres(String senRepNombres) {
		this.senRepNombres = senRepNombres;
	}

	public String getSenRepTelefono() {
		return this.senRepTelefono;
	}

	public void setSenRepTelefono(String senRepTelefono) {
		this.senRepTelefono = senRepTelefono;
	}

	public String getSenTelefono() {
		return this.senTelefono;
	}

	public void setSenTelefono(String senTelefono) {
		this.senTelefono = senTelefono;
	}

	public String getSenZona() {
		return this.senZona;
	}

	public void setSenZona(String senZona) {
		this.senZona = senZona;
	}

}