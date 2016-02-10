package colegio.controller.registros;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import colegio.controller.generic.Funciones;
import colegio.controller.generic.Mensaje;
import colegio.manager.RegistrosDAO;
import colegio.model.entidades.ColInstitucion;
import colegio.model.entidades.ColInstitucionesSenescyt;




/**
 * @author jestevez
 *
 */
@SessionScoped
@ManagedBean
public class FinstitucionBean {

	// Llamada de los Dao y clases genericas
	private RegistrosDAO manager;

	// Atributos de la clase Movimientos_Cabecera
	/** @pdOid f80b9469-ab73-42ca-b6db-4839f4c4285c */
	private Integer ins_id;
	/** @pdOid 19776823-edfe-4f57-91e8-9ef4620036c2 */
	private String ins_zona;
	/** @pdOid a27d34a4-e584-4da9-8ae7-f53c2f6dc206 */
	private String ins_provincia;
	/** @pdOid e2f1d9aa-b9f5-4ffb-bc1b-a79b132d1a36 */
	private String ins_nombre;
	/** @pdOid ebea2020-fada-4041-9e88-6db7b0c4a323 */
	private String ins_direccion;
	/** @pdOid 7c8fba72-d564-4fee-8ed6-a7b55994b1bc */
	private String ins_telefono;
	/** @pdOid 6b61fd9e-add1-4cff-9e33-1d8c5329bb69 */
	private String ins_correo;
	/** @pdOid b31c936e-cc14-4516-b202-cb2d2d80f723 */
	private String ins_amie;
	/** @pdOid d1eb0ccd-f7b8-48eb-8ceb-9ed657f56b1e */
	private Date ins_fecha;
	/** @pdOid a1d1bd02-757e-403b-951d-040d27f3e00a */
	private String ins_estado;
	/** @pdOid 34ad5091-413a-4e19-9166-074751be41a0 */
	private String ins_rep_nombres;
	/** @pdOid f8c23b0b-1efa-4b1e-885b-b4aadf1647d1 */
	private String ins_rep_apellidos;
	/** @pdOid d977c50f-3c5f-4ac7-b5f3-5572d9fad188 */
	private String ins_rep_cedula;
	/** @pdOid 3ed8f4be-4109-48c2-8cb3-9cd192321a04 */
	private String ins_rep_correo;
	/** @pdOid 434d00a0-966b-4b67-9a26-7ab1b4039434 */
	private String ins_rep_telefono;
	/** @pdOid 34e9ac21-acd6-4f97-9cb4-ad5c9f551fbd */
	private String ins_rep_cargo;
	/** @pdOid bd666802-1e66-4a8d-9f4a-de7838577249 */
	private String ins_rep_clave;
	/** @pdOid 4cc90d68-baa3-4e99-a4d3-06dc29c63e04 */
	private String ins_coo_nombres;
	/** @pdOid cf8bf5e6-601a-4bbb-9827-81223c0ae3e8 */
	private String ins_coo_apellidos;
	/** @pdOid 9300627c-ef21-4687-94e9-622259b04ee5 */
	private String ins_coo_cedula;
	/** @pdOid ee46b1b8-5ac5-4cd8-9ce9-5b56cfbfc11a */
	private String ins_coo_cargo;
	/** @pdOid 4dc05bae-1928-41c6-88eb-0884e5105363 */
	private String ins_coo_correo;
	/** @pdOid c895fceb-2b11-4b0e-a399-98bba9fd61c6 */
	private String ins_coo_telefono;

	// Atributos para la carga de los SMS a ser enviados
	private String SMS_general;
	private String SMS_coordinador;

	
	public FinstitucionBean() {
		manager = new RegistrosDAO();
		ins_zona = null;
	}

	/**
	 * @return the sMS_general
	 */
	public String getSMS_general() {
		return SMS_general;
	}

	/**
	 * @param sMS_general
	 *            the sMS_general to set
	 */
	public void setSMS_general(String sMS_general) {
		SMS_general = sMS_general;
	}

	/**
	 * @return the sMS_coordinador
	 */
	public String getSMS_coordinador() {
		return SMS_coordinador;
	}

	/**
	 * @param sMS_coordinador
	 *            the sMS_coordinador to set
	 */
	public void setSMS_coordinador(String sMS_coordinador) {
		SMS_coordinador = sMS_coordinador;
	}

	/**
	 * @return the ins_fecha
	 */
	public Date getIns_fecha() {
		return ins_fecha;
	}

	/**
	 * @param ins_fecha
	 *            the ins_fecha to set
	 */
	public void setIns_fecha(Date ins_fecha) {
		this.ins_fecha = ins_fecha;
	}

	/**
	 * @return the ins_estado
	 */
	public String getIns_estado() {
		return ins_estado;
	}

	/**
	 * @param ins_estado
	 *            the ins_estado to set
	 */
	public void setIns_estado(String ins_estado) {
		this.ins_estado = ins_estado;
	}

	/**
	 * @return the ins_rep_clave
	 */
	public String getIns_rep_clave() {
		return ins_rep_clave;
	}

	/**
	 * @param ins_rep_clave
	 *            the ins_rep_clave to set
	 */
	public void setIns_rep_clave(String ins_rep_clave) {
		this.ins_rep_clave = ins_rep_clave;
	}

	/**
	 * @return the ins_id
	 */
	public Integer getIns_id() {
		return ins_id;
	}

	/**
	 * @param ins_id
	 *            the ins_id to set
	 */
	public void setIns_id(Integer ins_id) {
		this.ins_id = ins_id;
	}

	/**
	 * @return the ins_zona
	 */
	public String getIns_zona() {
		return ins_zona;
	}

	/**
	 * @param ins_zona
	 *            the ins_zona to set
	 */
	public void setIns_zona(String ins_zona) {
		this.ins_zona = ins_zona;
	}

	/**
	 * @return the ins_provincia
	 */
	public String getIns_provincia() {
		return ins_provincia;
	}

	/**
	 * @param ins_provincia
	 *            the ins_provincia to set
	 */
	public void setIns_provincia(String ins_provincia) {
		this.ins_provincia = ins_provincia;
	}

	/**
	 * @return the ins_nombre
	 */
	public String getIns_nombre() {
		return ins_nombre;
	}

	/**
	 * @param ins_nombre
	 *            the ins_nombre to set
	 */
	public void setIns_nombre(String ins_nombre) {
		this.ins_nombre = ins_nombre;
	}

	/**
	 * @return the ins_direccion
	 */
	public String getIns_direccion() {
		return ins_direccion;
	}

	/**
	 * @param ins_direccion
	 *            the ins_direccion to set
	 */
	public void setIns_direccion(String ins_direccion) {
		this.ins_direccion = ins_direccion;
	}

	/**
	 * @return the ins_telefono
	 */
	public String getIns_telefono() {
		return ins_telefono;
	}

	/**
	 * @param ins_telefono
	 *            the ins_telefono to set
	 */
	public void setIns_telefono(String ins_telefono) {
		this.ins_telefono = ins_telefono;
	}

	/**
	 * @return the ins_correo
	 */
	public String getIns_correo() {
		return ins_correo;
	}

	/**
	 * @param ins_correo
	 *            the ins_correo to set
	 */
	public void setIns_correo(String ins_correo) {
		this.ins_correo = ins_correo;
	}

	/**
	 * @return the ins_amie
	 */
	public String getIns_amie() {
		return ins_amie;
	}

	/**
	 * @param ins_amie
	 *            the ins_amie to set
	 */
	public void setIns_amie(String ins_amie) {
		this.ins_amie = ins_amie;
	}

	/**
	 * @return the ins_rep_nombres
	 */
	public String getIns_rep_nombres() {
		return ins_rep_nombres;
	}

	/**
	 * @param ins_rep_nombres
	 *            the ins_rep_nombres to set
	 */
	public void setIns_rep_nombres(String ins_rep_nombres) {
		this.ins_rep_nombres = ins_rep_nombres;
	}

	/**
	 * @return the ins_rep_apellidos
	 */
	public String getIns_rep_apellidos() {
		return ins_rep_apellidos;
	}

	/**
	 * @param ins_rep_apellidos
	 *            the ins_rep_apellidos to set
	 */
	public void setIns_rep_apellidos(String ins_rep_apellidos) {
		this.ins_rep_apellidos = ins_rep_apellidos;
	}

	/**
	 * @return the ins_rep_cedula
	 */
	public String getIns_rep_cedula() {
		return ins_rep_cedula;
	}

	/**
	 * @param ins_rep_cedula
	 *            the ins_rep_cedula to set
	 */
	public void setIns_rep_cedula(String ins_rep_cedula) {
		this.ins_rep_cedula = ins_rep_cedula;
	}

	/**
	 * @return the ins_rep_correo
	 */
	public String getIns_rep_correo() {
		return ins_rep_correo;
	}

	/**
	 * @param ins_rep_correo
	 *            the ins_rep_correo to set
	 */
	public void setIns_rep_correo(String ins_rep_correo) {
		this.ins_rep_correo = ins_rep_correo;
	}

	/**
	 * @return the ins_rep_telefono
	 */
	public String getIns_rep_telefono() {
		return ins_rep_telefono;
	}

	/**
	 * @param ins_rep_telefono
	 *            the ins_rep_telefono to set
	 */
	public void setIns_rep_telefono(String ins_rep_telefono) {
		this.ins_rep_telefono = ins_rep_telefono;
	}

	/**
	 * @return the ins_rep_cargo
	 */
	public String getIns_rep_cargo() {
		return ins_rep_cargo;
	}

	/**
	 * @param ins_rep_cargo
	 *            the ins_rep_cargo to set
	 */
	public void setIns_rep_cargo(String ins_rep_cargo) {
		this.ins_rep_cargo = ins_rep_cargo;
	}

	/**
	 * @return the ins_coo_nombres
	 */
	public String getIns_coo_nombres() {
		return ins_coo_nombres;
	}

	/**
	 * @param ins_coo_nombres
	 *            the ins_coo_nombres to set
	 */
	public void setIns_coo_nombres(String ins_coo_nombres) {
		this.ins_coo_nombres = ins_coo_nombres;
	}

	/**
	 * @return the ins_coo_apellidos
	 */
	public String getIns_coo_apellidos() {
		return ins_coo_apellidos;
	}

	/**
	 * @param ins_coo_apellidos
	 *            the ins_coo_apellidos to set
	 */
	public void setIns_coo_apellidos(String ins_coo_apellidos) {
		this.ins_coo_apellidos = ins_coo_apellidos;
	}

	/**
	 * @return the ins_coo_cedula
	 */
	public String getIns_coo_cedula() {
		return ins_coo_cedula;
	}

	/**
	 * @param ins_coo_cedula
	 *            the ins_coo_cedula to set
	 */
	public void setIns_coo_cedula(String ins_coo_cedula) {
		this.ins_coo_cedula = ins_coo_cedula;
	}

	/**
	 * @return the ins_coo_cargo
	 */
	public String getIns_coo_cargo() {
		return ins_coo_cargo;
	}

	/**
	 * @param ins_coo_cargo
	 *            the ins_coo_cargo to set
	 */
	public void setIns_coo_cargo(String ins_coo_cargo) {
		this.ins_coo_cargo = ins_coo_cargo;
	}

	/**
	 * @return the ins_coo_correo
	 */
	public String getIns_coo_correo() {
		return ins_coo_correo;
	}

	/**
	 * @param ins_coo_correo
	 *            the ins_coo_correo to set
	 */
	public void setIns_coo_correo(String ins_coo_correo) {
		this.ins_coo_correo = ins_coo_correo;
	}

	/**
	 * @return the ins_coo_telefono
	 */
	public String getIns_coo_telefono() {
		return ins_coo_telefono;
	}

	/**
	 * @param ins_coo_telefono
	 *            the ins_coo_telefono to set
	 */
	public void setIns_coo_telefono(String ins_coo_telefono) {
		this.ins_coo_telefono = ins_coo_telefono;
	}

	/**
	 * Metodo para listar todos los Datos de la Entidad
	 * 
	 * @return
	 */
	public List<ColInstitucion> getListInstituciones() {
		List<ColInstitucion> p = new ArrayList<ColInstitucion>();
		try {
			p = manager.findAllInstituciones();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	
	/**
	 * Metodo para listar todos los Datos de la Entidad
	 * 
	 * @return
	 */
	public List<ColInstitucionesSenescyt> getListInstitucionesS() {
		List<ColInstitucionesSenescyt> p = new ArrayList<ColInstitucionesSenescyt>();
		try {
			p = manager.findAllInstitucionesS();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	
	/**
	 * Permite la creacion de un Dato a la Entidad
	 * 
	 * @return
	 */
	public String crearInstitucion() {
		String r = "";
		try {
			Integer u = 0;
			if (vacios()==true){
				Mensaje.crearMensajeERROR("Ingrese código AMIE para busqueda de Instituciones");
			}else{
			if (Funciones.validadorDeCedula(ins_coo_cedula.trim())==true){
			for (ColInstitucion insti : this.getListInstituciones()) {
				if (insti.getInsAmie().trim().equals(ins_amie.trim())) {
					u = 100000000;
				} else {
					u++;
				}
			}
			if (u == getListInstituciones().size()) {
				manager.insertarInstitucion(ins_zona, ins_provincia,
						ins_nombre, ins_direccion, ins_telefono, ins_correo,
						ins_amie, ins_rep_nombres, ins_rep_apellidos,
						ins_rep_cedula, ins_rep_correo, ins_rep_telefono,
						ins_rep_cargo, ins_coo_nombres, ins_coo_apellidos,
						ins_coo_cedula, ins_coo_cargo, ins_coo_telefono,
						ins_coo_correo);
				Mensaje.crearMensajeINFO("Registro de Institución Realizado con Exito");
				// limpiar datos
				ins_zona = "";
				ins_provincia = "";
				ins_nombre = "";
				ins_direccion = "";
				ins_telefono = "";
				ins_correo = "";
				ins_amie = "";
				ins_rep_nombres = "";
				ins_rep_apellidos = "";
				ins_rep_cedula = "";
				ins_rep_correo = "";
				ins_rep_telefono = "";
				ins_rep_cargo = "";
				ins_coo_nombres = "";
				ins_coo_apellidos = "";
				ins_coo_cedula = "";
				ins_coo_cargo = "";
				ins_coo_telefono = "";
				ins_coo_correo = "";
				r = "/index?faces-redirect=true";
			} else {
				Mensaje.crearMensajeERROR("Institución Registrada Anteriormente; Código AMIE Repetido");
				r = "";
			}
			}else{
			Mensaje.crearMensajeERROR("Cédula del Coordinador Erronea");
			r ="";
			}
			}
		} catch (Exception e) {
			Mensaje.crearMensajeERROR(e.getMessage());
		}
		return r;
	}



	/**
	 * Metodo de traslado
	 * 
	 * @return
	 */
	public String irIndex() {
		// limpiar datos
		ins_zona = "";
		ins_provincia = "";
		ins_nombre = "";
		ins_direccion = "";
		ins_telefono = "";
		ins_correo = "";
		ins_amie = "";
		ins_rep_nombres = "";
		ins_rep_apellidos = "";
		ins_rep_cedula = "";
		ins_rep_correo = "";
		ins_rep_telefono = "";
		ins_rep_cargo = "";
		ins_coo_nombres = "";
		ins_coo_apellidos = "";
		ins_coo_cedula = "";
		ins_coo_cargo = "";
		ins_coo_telefono = "";
		ins_coo_correo = "";
		Mensaje.crearMensajeWARN("Registro de Institución Cancelada");
		return "/index?faces-redirect=true";
	}

	

	
	
	/**
	 * Metodo para cargar los datos de la institucion y representante en la vista registro 
	 */
	public void buscarAmie(){
		ins_zona = "";
		ins_provincia = "";
		ins_nombre = "";
		ins_direccion = "";
		ins_telefono = "";
		ins_correo = "";
		ins_rep_nombres = "";
		ins_rep_apellidos = "";
		ins_rep_cedula = "";
		ins_rep_correo = "";
		ins_rep_telefono = "";
		ins_rep_cargo = "";
		ins_coo_nombres = "";
		ins_coo_apellidos = "";
		ins_coo_cedula = "";
		ins_coo_cargo = "";
		ins_coo_telefono = "";
		ins_coo_correo = "";
		Integer l=0;
		Integer u=0;
		List<ColInstitucion> ci=this.getListInstituciones();
		List<ColInstitucionesSenescyt> cis=this.getListInstitucionesS();
		try {
			if (ins_amie.isEmpty() || ins_amie==null){
				Mensaje.crearMensajeERROR("Código AMIE Requerido");
			}else{
				for (ColInstitucion insti : ci) {
					if (insti.getInsAmie().trim().equals(getIns_amie().trim())) {
						u = 0;
						break;
					} else {
						u++;
					}
				}
				
			if (u == ci.size()) {
			for (ColInstitucionesSenescyt is : cis) {
					if (is.getSenAmie().equals(ins_amie)){
						l=0;
						break;
					}else{
						l++;
					}
			}
			if (l!=cis.size()){
			ColInstitucionesSenescyt is=manager.InstitucionSByID(getIns_amie().trim());
			ins_zona = is.getSenZona();
			ins_provincia = is.getSenProvincia();
			ins_nombre = is.getSenNombre();
			ins_direccion = is.getSenDireccion();
			ins_telefono = is.getSenRepTelefono();
			ins_correo = is.getSenCorreo().toLowerCase();
			ins_rep_nombres = is.getSenRepNombres();
			ins_rep_apellidos = is.getSenRepApellidos();
			ins_rep_cedula = is.getSenRepCedula();
			ins_rep_correo = is.getSenRepCorreo().toLowerCase();
			ins_rep_telefono = is.getSenRepTelefono();
			ins_rep_cargo = is.getSenRepCargo();
			}else{
				Mensaje.crearMensajeERROR("El Código AMIE no Existe");
			}
			}else{
				Mensaje.crearMensajeERROR("Institución Registrada Anteriormente; Código AMIE Repetido");
			}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo para validar los datos vacio que viene de un código amie
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean vacios() throws Exception{
		boolean b=false;
		try {
			if (ins_amie==null || ins_amie.isEmpty()){
				b=true;
			}
			if (ins_nombre==null || ins_nombre.isEmpty()){
				b=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return b;
	}
	

}