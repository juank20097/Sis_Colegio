package colegio.manager;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import colegio.controller.generic.Funciones;
import colegio.model.entidades.ColEstudiante;
import colegio.model.entidades.ColEvaluacion;
import colegio.model.entidades.ColEvaluacionEstudiantil;
import colegio.model.entidades.ColInstitucion;
import colegio.model.entidades.ColInstitucionesSenescyt;
import colegio.model.entidades.ColOpcionesRespuesta;
import colegio.model.entidades.ColPregunta;
import colegio.model.entidades.ColRespuesta;

/**
 * Clase MatriculasDAO permite manejar el HibernateDAO en conveniencia a la
 * gestion de matricula y reservas
 * 
 * @author Juan Carlos Estévez Hidalgo
 * @version 1.0
 * 
 */

public class RegistrosDAO {

	// Campos de la clase
	private ManagerDAO manager;

	/**
	 * Constructor para la utilizacion de metodos de la clase HibernateDAO
	 * 
	 * @param manager
	 *            El parametro manager inicializa la utilizacion de la clase
	 *            HIbernateDAO y todos sus metodos
	 */
	public RegistrosDAO() {
		manager = new ManagerDAO();

	}// Cierre del Constructor

	// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Creación de metodos para el manejo de la tabla ColInstitucion
	 * 
	 */

	/**
	 * Metodo para listar todas los existentes
	 * 
	 * @return La lista de todas encontradas
	 */
	@SuppressWarnings("unchecked")
	public List<ColInstitucion> findAllInstituciones() {
		try {
			return manager.findAll(ColInstitucion.class);
		} catch (Exception e) {
			System.out.println("error fndAllInstituciones");
			e.printStackTrace();
			return null;
		}
	}// Cierre del metodo

	/**
	 * Metodo para obtener un Dato mediante un ID
	 * 
	 * @param id_per
	 *            Tipo integer de busqueda
	 * @return El objeto Movimiento encontrado mediante el ID
	 */
	public ColInstitucion InstitucionByID(Integer id_ins) throws Exception {
		return (ColInstitucion) manager.findById(ColInstitucion.class, id_ins);
	}// Cierre del metodo

	/**
	 * Metodo para ingresar un Dato a la base de datos
	 * 
	 * @param zona
	 * @param provincia
	 * @param nombre
	 * @param direccion
	 * @param telefono
	 * @param correo
	 * @param amie
	 * @throws Exception
	 */
	public void insertarInstitucion(String zona, String provincia,
			String nombre, String direccion, String telefono, String correo,
			String amie, String rep_nombres, String rep_apellidos,
			String rep_cedula, String rep_correo, String rep_telefono,
			String rep_cargo, String coo_nombres, String coo_apellidos,
			String coo_cedula, String coo_cargo, String coo_telefono,
			String coo_correo) throws Exception {
		try {
			ColInstitucion ins = new ColInstitucion();

			// Datos de Entidad
			ins.setInsZona(zona);
			ins.setInsProvincia(provincia);
			ins.setInsNombre(nombre);
			ins.setInsDireccion(direccion);
			ins.setInsTelefono(telefono);
			ins.setInsCorreo(correo);
			ins.setInsAmie(amie);
			ins.setInsFecha(new Timestamp(new Date().getTime()));
			ins.setInsEstado("Pendiente");

			// Datos de Representante
			ins.setInsRepNombres(rep_nombres);
			ins.setInsRepApellidos(rep_apellidos);
			ins.setInsRepCargo(rep_cargo);
			ins.setInsRepCedula(rep_cedula);
			ins.setInsRepCorreo(rep_correo);
			ins.setInsRepTelefono(rep_telefono);

			// Datos de Coordinador
			ins.setInsCooApellidos(coo_apellidos);
			ins.setInsCooCargo(coo_cargo);
			ins.setInsCooCedula(coo_cedula);
			ins.setInsCooCorreo(coo_correo);
			ins.setInsCooNombres(coo_nombres);
			ins.setInsCooTelefono(coo_telefono);
			ins.setInsCooClave(Funciones.randomString(8));

			manager.insertar(ins);
			System.out.println("Bien_insertar_Institucion");
		} catch (Exception e) {
			System.out.println("Error_insertar_Institucion");
			System.out.println(e);
			e.printStackTrace();
		}

	}// Cierre del metodo

	/**
	 * Metodo para editar una entidad
	 * 
	 * @param ins_id
	 * @param ins_estado
	 */
	public void editarInstitucion(Integer ins_id, String ins_estado) {
		try {
			ColInstitucion ins = this.InstitucionByID(ins_id);
			ins.setInsEstado(ins_estado);
			manager.actualizar(ins);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Creación de metodos para el manejo de la tabla ColInstitucionesSenescyt
	 * 
	 */

	/**
	 * Metodo para listar todas los existentes
	 * 
	 * @return La lista de todas encontradas
	 */
	@SuppressWarnings("unchecked")
	public List<ColInstitucionesSenescyt> findAllInstitucionesS()
			throws Exception {
		return manager.findAll(ColInstitucionesSenescyt.class);
	}// Cierre del metodo

	/**
	 * Metodo para obtener un Dato mediante un ID
	 * 
	 * @param id_per
	 *            Tipo integer de busqueda
	 * @return El objeto Movimiento encontrado mediante el ID
	 */
	public ColInstitucionesSenescyt InstitucionSByID(String id_amie)
			throws Exception {
		return (ColInstitucionesSenescyt) manager.findById(
				ColInstitucionesSenescyt.class, id_amie);
	}// Cierre del metodo

	// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Creación de metodos para el manejo de la tabla ColEstudiantes
	 * 
	 */

	/**
	 * Metodo para listar todas los existentes
	 * 
	 * @return La lista de todas encontradas
	 */
	@SuppressWarnings("unchecked")
	public List<ColEstudiante> findAllEstudiantes() {
		return manager.findAll(ColEstudiante.class);
	}// Cierre del metodo

	/**
	 * Metodo para listar todas los existentes
	 * 
	 * @return La lista de todas encontradas
	 */
	@SuppressWarnings("unchecked")
	public List<ColEstudiante> findAllEstudiantesXID(Integer id_ins) {
		List<ColEstudiante> c = new ArrayList<ColEstudiante>();
		//toñito
//		c= manager.findAllWhereId(ColEstudiante.class, "colInstitucion.insId", id_ins);
		List<ColEstudiante> le = manager.findAll(ColEstudiante.class);
		for (ColEstudiante col : le) {
			if (col.getColInstitucion().getInsId() == id_ins) {
				c.add(col);
			}
		}
		return c;
	}// Cierre del metodo

	/**
	 * Metodo para listar todas los existentes
	 * 
	 * @return La lista de todas encontradas
	 */
	@SuppressWarnings("unchecked")
	public List<ColEstudiante> findAllEstudiantesActivos(String estado) {
		return manager.findWhere(ColEstudiante.class, "est_estado='" + estado
				+ "'", null);
	}// Cierre del metodo

	/**
	 * Metodo para obtener un Dato mediante un ID
	 * 
	 * @param id_per
	 *            Tipo integer de busqueda
	 * @return El objeto Movimiento encontrado mediante el ID
	 */
	public ColEstudiante EstudianteByID(Integer est_id) throws Exception {
		return (ColEstudiante) manager.findById(ColEstudiante.class, est_id);
	}// Cierre del metodo

	/**
	 * Metodo para ingresar un Dato a la base de datos
	 * 
	 * @param nombres
	 * @param apellidos
	 * @param cedula
	 * @param area
	 * @param telefono
	 * @param correo
	 */
	public void insertarEstudiante(String nombres, String apellidos,
			String cedula, String area, String telefono, String correo,
			Integer id_ins) throws Exception {
		try {
			ColEstudiante est = new ColEstudiante();
			ColInstitucion ins = new ColInstitucion();
			est.setEstNombres(nombres);
			est.setEstApellidos(apellidos);
			est.setEstCedula(cedula);
			est.setEstCorreo(correo);
			est.setEstArea(area);
			est.setEstTelefono(telefono);
			est.setEstEstado("A");
			ins = this.InstitucionByID(id_ins);
			est.setColInstitucion(ins);
			est.setEstClave(Funciones.randomString(5));
			manager.insertar(est);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Metodo para editar una entidad
	 * 
	 * @param ins_id
	 * @param ins_estado
	 */
	public void editarEstudiante(Integer est_id, String est_estado,
			Date est_fechai, Date est_fechaf) {
		try {
			ColEstudiante est = this.EstudianteByID(est_id);
			est.setEstFechaIni(new Timestamp(est_fechai.getTime()));
			est.setEstFechaFin(new Timestamp(est_fechaf.getTime()));
			est.setEstEstado(est_estado);
			manager.actualizar(est);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo para editar una entidad
	 * 
	 * @param ins_id
	 * @param ins_estado
	 */
	public void insertarMac(Integer est_id, String mac) {
		try {
			ColEstudiante est = this.EstudianteByID(est_id);
			est.setEstMac(mac);
			manager.actualizar(est);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void eliminarEstudiante(Integer id_est) {
		try {
			manager.eliminar(ColEstudiante.class, id_est);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Creación de metodos para el manejo de la tabla ColPreguntas
	 * 
	 */

	/**
	 * Metodo para listar todas los existentes
	 * 
	 * @return La lista de todas encontradas
	 */
	@SuppressWarnings("unchecked")
	public List<ColPregunta> findAllPreguntas() {
		return manager.findAllAleatorioP(ColPregunta.class);
		// return manager.findAllAleatorioP(ColPregunta.class);
	}// Cierre del metodo
	
	/**
	 * Metodo para listar todas los existentes
	 * 
	 * @return La lista de todas encontradas
	 */
	@SuppressWarnings("unchecked")
	public List<ColRespuesta> findRespuestasxEstudiantePregunta(Integer id_pregunta, Integer id_estudiante) {
		return manager.findAllWhere(ColRespuesta.class, "o.colPregunta.preId ="+id_pregunta+" and o.estId ="+id_estudiante);
	}// Cierre del metodo
	
	/**
	 * Metodo para listar todas los existentes
	 * 
	 * @return La lista de todas encontradas
	 */
	@SuppressWarnings("unchecked")
	public List<ColPregunta> findPreguntasEstudiante(String area) {
		return manager.findAllWhere(ColPregunta.class, "o.colEvaluacion.evaArea = '"+area+"' order by o.preId ASC");
		// return manager.findAllAleatorioP(ColPregunta.class);
	}// Cierre del metodo

	/**
	 * Metodo para obtener un Dato mediante un ID
	 * 
	 * @param id_per
	 *            Tipo integer de busqueda
	 * @return El objeto encontrado mediante el ID
	 */
	public ColPregunta PreguntaByID(Integer id_pre) throws Exception {
		return (ColPregunta) manager.findById(ColPregunta.class, id_pre);
	}// Cierre del metodo
	
	/**
	 * Retorna el string para direccionar a la evaluación por estudiante
	 * @param idEstudiante
	 * @return boolean
	 */
	public boolean redireccionarEvaluacion(int idEstudiante){
		if(findPreguntasContestadasByEstudiante(idEstudiante).size()>0)
			return true;
		else
			return false;
	}
	
	/**
	 * Busca las preguntas ya realizadas
	 * @param idEstudiante
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ColPregunta> findPreguntasContestadasByEstudiante(int idEstudiante){
		return manager.findWhere(ColPregunta.class, 
				"o.colOpcionesRespuestas IN (SELECT r.colOpcionesRespuesta FROM ColRespuesta r WHERE r.estId="+idEstudiante+")", null);
	}
	
	/**
	 * Busca las preguntas no contestadas
	 * @param idEstudiante
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ColPregunta> findPreguntasNoContestadasByEstudiante(int idEstudiante){
		return manager.findWhere(ColPregunta.class, 
				"o.colEvaluacion.evaId="+findAreaEvaluacionIDByEstudiante(idEstudiante)+
				" AND o.preId NOT IN (SELECT r.colPregunta.preId FROM ColRespuesta r WHERE r.estId="+idEstudiante+")", null);
	}
	
	/**
	 * Busca el id de la evaluación segun el estudiante
	 * @param idEstudiante
	 * @return
	 */
	public int findAreaEvaluacionIDByEstudiante(int idEstudiante){
		return ((ColEvaluacion) manager.findWhere(ColEvaluacion.class, 
				"UPPER(o.evaArea) IN (SELECT UPPER(e.estArea) FROM ColEstudiante e WHERE e.estId="+idEstudiante+")", null).get(0)).getEvaId();
	}
	// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Creación de metodos para el manejo de la tabla ColOpcionesRespuestas
	 * 
	 */

	/**
	 * Metodo para listar todas los existentes
	 * 
	 * @return La lista de todas encontradas
	 */
	@SuppressWarnings("unchecked")
	public List<ColOpcionesRespuesta> findAllOpciones() {
		return manager.findAll(ColOpcionesRespuesta.class);
	}// Cierre del metodo
	
	/**
	 * Metodo para listar todas los existentes
	 * 
	 * @return La lista de todas encontradas
	 */
	@SuppressWarnings("unchecked")
	public List<ColOpcionesRespuesta> findOpcionesxPregunta(Integer pre_id) {
		return manager.findAllWhere(ColOpcionesRespuesta.class, "o.colPregunta.preId = "+pre_id);
	}// Cierre del metodo

	/**
	 * Metodo para obtener un Dato mediante un ID
	 * 
	 * @param id_per
	 *            Tipo integer de busqueda
	 * @return El objeto encontrado mediante el ID
	 */
	public ColOpcionesRespuesta OpcionesByID(Integer id_pre) throws Exception {
		return (ColOpcionesRespuesta) manager.findById(
				ColOpcionesRespuesta.class, id_pre);
	}// Cierre del metodo

	// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Creación de metodos para el manejo de la tabla ColRespuestas
	 * 
	 */
	
	/**
	 * Metodo para listar todas los existentes
	 * 
	 * @return La lista de todas encontradas
	 */
	@SuppressWarnings("unchecked")
	public List<ColRespuesta> findWhereRespuestas(Integer id_pregunta, Integer id_estudiante) {
		return manager.findAllWhere(ColRespuesta.class, "o.colPregunta.preId ="+id_pregunta+" and o.estId ="+id_estudiante);
	}// Cierre del metodo
	
	/**
	 * Metodo para listar todas los existentes
	 * 
	 * @return La lista de todas encontradas
	 */
	@SuppressWarnings("unchecked")
	public List<ColRespuesta> findAllRespuestas() {
		return manager.findAll(ColRespuesta.class);
	}// Cierre del metodo

	/**
	 * Metodo para obtener un Dato mediante un ID
	 * 
	 * @param id_per
	 *            Tipo integer de busqueda
	 * @return El objeto encontrado mediante el ID
	 */
	public ColRespuesta RespuestasByID(Integer id_res) throws Exception {
		return (ColRespuesta) manager.findById(
				ColRespuesta.class, id_res);
	}// Cierre del metodo
	
	/**
	 * Metodo para ingresar un Dato a la base de datos
	 * 
	 * @param nombres
	 * @param apellidos
	 * @param cedula
	 * @param area
	 * @param telefono
	 * @param correo
	 */
	public void insertarRespuesta(Timestamp fecha, Integer ores, Integer pre, Integer est, Boolean estado) throws Exception {
		try {
			ColOpcionesRespuesta opciones_res = new ColOpcionesRespuesta();
			ColPregunta pregunta = new ColPregunta();
			ColRespuesta res = new ColRespuesta();
			res.setResFecha(fecha);
			opciones_res = this.OpcionesByID(ores);
			res.setColOpcionesRespuesta(opciones_res);
			pregunta = this.PreguntaByID(pre);
			res.setColPregunta(pregunta);
			res.setEstId(est);
			res.setResEditable(estado);
			manager.insertar(res);
			System.out.println("Bien_guardado_Respuesta");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Mal_guardado_Respuesta");
		}

	}
	
	/**
	 * Metodo para ingresar un Dato a la base de datos
	 * 
	 * @param nombres
	 * @param apellidos
	 * @param cedula
	 * @param area
	 * @param telefono
	 * @param correo
	 */
	public void editarRespuesta(Integer id_res,Timestamp fecha, Integer ores) throws Exception {
		try {
			ColRespuesta res = RespuestasByID(id_res);
			ColOpcionesRespuesta opciones_res = new ColOpcionesRespuesta();
			res.setResFecha(fecha);
			opciones_res = this.OpcionesByID(ores);
			res.setColOpcionesRespuesta(opciones_res);
			manager.actualizar(res);
			System.out.println("Bien_actualizado_Respuesta");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Mal_guardado_Respuesta");
		}

	}
	
	
	/**
	 * Metodo para ingresar un Dato a la base de datos
	 * 
	 * @param nombres
	 * @param apellidos
	 * @param cedula
	 * @param area
	 * @param telefono
	 * @param correo
	 */
	public void editarRespuestaEstado(Integer id_res,Boolean estado) {
		try {
			ColRespuesta res = RespuestasByID(id_res);
			res.setResEditable(estado);
			manager.actualizar(res);
			System.out.println("Bien_actualizado_Respuesta_Estado");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Mal_guardado_Respuesta_Estado");
		}

	}
	
	/**
	 * Busca el ID de la Opción de respuesta seleccionada por el estudiante en una pregunta
	 * @param pregunta
	 * @param idEstudiante
	 * @return
	 */
	public int findIdRespuestaByPreguntaEstudiante(ColPregunta pregunta, int idEstudiante){
		return ((ColRespuesta) manager.findWhere(ColRespuesta.class, 
				"o.colPregunta.preId="+pregunta.getPreId()+" AND o.estId="+idEstudiante, null).get(0)).getColOpcionesRespuesta().getOprId();
	}
	
	// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Creación de metodos para el manejo de la tabla ColEvaluacionEstudiantil
	 * 
	 */
	
	/**
	 * Metodo para listar todas los existentes
	 * 
	 * @return La lista de todas encontradas
	 */
	@SuppressWarnings("unchecked")
	public List<ColEvaluacionEstudiantil> findAllEvaEstudiantil() {
		return manager.findAll(ColEvaluacionEstudiantil.class);
	}// Cierre del metodo

	/**
	 * Metodo para obtener un Dato mediante un ID
	 * 
	 * @param id_per
	 *            Tipo integer de busqueda
	 * @return El objeto encontrado mediante el ID
	 */
	public ColEvaluacionEstudiantil EvaEstudiantilByID(Integer id_ees) throws Exception {
		return (ColEvaluacionEstudiantil) manager.findById(
				ColEvaluacionEstudiantil.class, id_ees);
	}// Cierre del metodo
	
	/**
	 * Metodo para ingresar un Dato a la base de datos
	 * 
	 * @param nombres
	 * @param apellidos
	 * @param cedula
	 * @param area
	 * @param telefono
	 * @param correo
	 */
	public void insertarEvaEstudiantil(Integer estudiante, Integer evaluacion, Timestamp fecha_ini, Timestamp fecha_fin, Integer calificacion) {
		try {
			ColEvaluacionEstudiantil eva_estudiantil = new ColEvaluacionEstudiantil();
			ColEstudiante est = new ColEstudiante();
			ColEvaluacion eva = new ColEvaluacion();
			
			est = this.EstudianteByID(estudiante);
			eva = this.EvaluacionByID(evaluacion);
			
			eva_estudiantil.setColEstudiante(est);
			eva_estudiantil.setColEvaluacion(eva);
			eva_estudiantil.setEesFechaIni(fecha_ini);
			eva_estudiantil.setEesFechaFin(fecha_fin);
			eva_estudiantil.setEesCalificacion(calificacion);
			manager.insertar(eva_estudiantil);
			System.out.println("Bien_guardado_Evaluacion_Estudiantil");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Mal_guardado_Evaluacion_Estudiantil");
		}

	}
	
	/**
	 * Metodo para editar un Dato a la base de datos
	 * 
	 * @param eest_id
	 * @param fecha_fin
	 * @param calificacion
	 */
	public void editarEvaEstudiantil(Integer eest_id, Timestamp fecha_fin, Integer calificacion, String tiempo) {
		try {
			ColEvaluacionEstudiantil eva_estudiantil = this.EvaEstudiantilByID(eest_id);
			eva_estudiantil.setEesFechaFin(fecha_fin);
			eva_estudiantil.setEesCalificacion(calificacion);
			eva_estudiantil.setEesTiempo(tiempo);
			manager.actualizar(eva_estudiantil);
			System.out.println("Bien_actualizado_Evaluacion_Estudiantil");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Mal_actualizado_Evaluacion_Estudiantil");
		}

	}
	
	// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/**
		 * Creación de metodos para el manejo de la tabla ColEvaluacion
		 * 
		 */
		
		/**
		 * Metodo para listar todas los existentes
		 * 
		 * @return La lista de todas encontradas
		 */
		@SuppressWarnings("unchecked")
		public List<ColEvaluacion> findAllEvaluacion() {
			return manager.findAll(ColEvaluacion.class);
		}// Cierre del metodo

		/**
		 * Metodo para obtener un Dato mediante un ID
		 * 
		 * @param id_per
		 *            Tipo integer de busqueda
		 * @return El objeto encontrado mediante el ID
		 */
		public ColEvaluacion EvaluacionByID(Integer id_ees) throws Exception {
			return (ColEvaluacion) manager.findById(
					ColEvaluacion.class, id_ees);
		}// Cierre del metodo
}
