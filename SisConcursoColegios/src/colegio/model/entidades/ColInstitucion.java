package colegio.model.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the col_institucion database table.
 * 
 */
@Entity
@Table(name="col_institucion")
@NamedQuery(name="ColInstitucion.findAll", query="SELECT c FROM ColInstitucion c")
public class ColInstitucion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COL_INSTITUCION_INSID_GENERATOR", sequenceName="SEQ_INSTITUCION", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COL_INSTITUCION_INSID_GENERATOR")
	@Column(name="ins_id")
	private Integer insId;

	@Column(name="ins_amie")
	private String insAmie;

	@Column(name="ins_coo_apellidos")
	private String insCooApellidos;

	@Column(name="ins_coo_cargo")
	private String insCooCargo;

	@Column(name="ins_coo_cedula")
	private String insCooCedula;

	@Column(name="ins_coo_clave")
	private String insCooClave;

	@Column(name="ins_coo_correo")
	private String insCooCorreo;

	@Column(name="ins_coo_nombres")
	private String insCooNombres;

	@Column(name="ins_coo_telefono")
	private String insCooTelefono;

	@Column(name="ins_correo")
	private String insCorreo;

	@Column(name="ins_direccion")
	private String insDireccion;

	@Column(name="ins_estado")
	private String insEstado;

	@Column(name="ins_fecha")
	private Timestamp insFecha;

	@Column(name="ins_nombre")
	private String insNombre;

	@Column(name="ins_provincia")
	private String insProvincia;

	@Column(name="ins_rep_apellidos")
	private String insRepApellidos;

	@Column(name="ins_rep_cargo")
	private String insRepCargo;

	@Column(name="ins_rep_cedula")
	private String insRepCedula;

	@Column(name="ins_rep_correo")
	private String insRepCorreo;

	@Column(name="ins_rep_nombres")
	private String insRepNombres;

	@Column(name="ins_rep_telefono")
	private String insRepTelefono;

	@Column(name="ins_telefono")
	private String insTelefono;

	@Column(name="ins_zona")
	private String insZona;

	//bi-directional many-to-one association to ColEstudiante
	@OneToMany(mappedBy="colInstitucion1")
	private List<ColEstudiante> colEstudiantes1;

	//bi-directional many-to-one association to ColEstudiante
	@OneToMany(mappedBy="colInstitucion2")
	private List<ColEstudiante> colEstudiantes2;

	public ColInstitucion() {
	}

	public Integer getInsId() {
		return this.insId;
	}

	public void setInsId(Integer insId) {
		this.insId = insId;
	}

	public String getInsAmie() {
		return this.insAmie;
	}

	public void setInsAmie(String insAmie) {
		this.insAmie = insAmie;
	}

	public String getInsCooApellidos() {
		return this.insCooApellidos;
	}

	public void setInsCooApellidos(String insCooApellidos) {
		this.insCooApellidos = insCooApellidos;
	}

	public String getInsCooCargo() {
		return this.insCooCargo;
	}

	public void setInsCooCargo(String insCooCargo) {
		this.insCooCargo = insCooCargo;
	}

	public String getInsCooCedula() {
		return this.insCooCedula;
	}

	public void setInsCooCedula(String insCooCedula) {
		this.insCooCedula = insCooCedula;
	}

	public String getInsCooClave() {
		return this.insCooClave;
	}

	public void setInsCooClave(String insCooClave) {
		this.insCooClave = insCooClave;
	}

	public String getInsCooCorreo() {
		return this.insCooCorreo;
	}

	public void setInsCooCorreo(String insCooCorreo) {
		this.insCooCorreo = insCooCorreo;
	}

	public String getInsCooNombres() {
		return this.insCooNombres;
	}

	public void setInsCooNombres(String insCooNombres) {
		this.insCooNombres = insCooNombres;
	}

	public String getInsCooTelefono() {
		return this.insCooTelefono;
	}

	public void setInsCooTelefono(String insCooTelefono) {
		this.insCooTelefono = insCooTelefono;
	}

	public String getInsCorreo() {
		return this.insCorreo;
	}

	public void setInsCorreo(String insCorreo) {
		this.insCorreo = insCorreo;
	}

	public String getInsDireccion() {
		return this.insDireccion;
	}

	public void setInsDireccion(String insDireccion) {
		this.insDireccion = insDireccion;
	}

	public String getInsEstado() {
		return this.insEstado;
	}

	public void setInsEstado(String insEstado) {
		this.insEstado = insEstado;
	}

	public Timestamp getInsFecha() {
		return this.insFecha;
	}

	public void setInsFecha(Timestamp insFecha) {
		this.insFecha = insFecha;
	}

	public String getInsNombre() {
		return this.insNombre;
	}

	public void setInsNombre(String insNombre) {
		this.insNombre = insNombre;
	}

	public String getInsProvincia() {
		return this.insProvincia;
	}

	public void setInsProvincia(String insProvincia) {
		this.insProvincia = insProvincia;
	}

	public String getInsRepApellidos() {
		return this.insRepApellidos;
	}

	public void setInsRepApellidos(String insRepApellidos) {
		this.insRepApellidos = insRepApellidos;
	}

	public String getInsRepCargo() {
		return this.insRepCargo;
	}

	public void setInsRepCargo(String insRepCargo) {
		this.insRepCargo = insRepCargo;
	}

	public String getInsRepCedula() {
		return this.insRepCedula;
	}

	public void setInsRepCedula(String insRepCedula) {
		this.insRepCedula = insRepCedula;
	}

	public String getInsRepCorreo() {
		return this.insRepCorreo;
	}

	public void setInsRepCorreo(String insRepCorreo) {
		this.insRepCorreo = insRepCorreo;
	}

	public String getInsRepNombres() {
		return this.insRepNombres;
	}

	public void setInsRepNombres(String insRepNombres) {
		this.insRepNombres = insRepNombres;
	}

	public String getInsRepTelefono() {
		return this.insRepTelefono;
	}

	public void setInsRepTelefono(String insRepTelefono) {
		this.insRepTelefono = insRepTelefono;
	}

	public String getInsTelefono() {
		return this.insTelefono;
	}

	public void setInsTelefono(String insTelefono) {
		this.insTelefono = insTelefono;
	}

	public String getInsZona() {
		return this.insZona;
	}

	public void setInsZona(String insZona) {
		this.insZona = insZona;
	}

	public List<ColEstudiante> getColEstudiantes1() {
		return this.colEstudiantes1;
	}

	public void setColEstudiantes1(List<ColEstudiante> colEstudiantes1) {
		this.colEstudiantes1 = colEstudiantes1;
	}

	public ColEstudiante addColEstudiantes1(ColEstudiante colEstudiantes1) {
		getColEstudiantes1().add(colEstudiantes1);
		colEstudiantes1.setColInstitucion1(this);

		return colEstudiantes1;
	}

	public ColEstudiante removeColEstudiantes1(ColEstudiante colEstudiantes1) {
		getColEstudiantes1().remove(colEstudiantes1);
		colEstudiantes1.setColInstitucion1(null);

		return colEstudiantes1;
	}

	public List<ColEstudiante> getColEstudiantes2() {
		return this.colEstudiantes2;
	}

	public void setColEstudiantes2(List<ColEstudiante> colEstudiantes2) {
		this.colEstudiantes2 = colEstudiantes2;
	}

	public ColEstudiante addColEstudiantes2(ColEstudiante colEstudiantes2) {
		getColEstudiantes2().add(colEstudiantes2);
		colEstudiantes2.setColInstitucion2(this);

		return colEstudiantes2;
	}

	public ColEstudiante removeColEstudiantes2(ColEstudiante colEstudiantes2) {
		getColEstudiantes2().remove(colEstudiantes2);
		colEstudiantes2.setColInstitucion2(null);

		return colEstudiantes2;
	}

}