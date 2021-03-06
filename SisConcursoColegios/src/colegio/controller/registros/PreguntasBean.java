package colegio.controller.registros;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

import colegio.acceso.entidades.Lista;
import colegio.controller.generic.Mensaje;
import colegio.manager.RegistrosDAO;
import colegio.model.entidades.ColEstudiante;
import colegio.model.entidades.ColEvaluacion;
import colegio.model.entidades.ColEvaluacionEstudiantil;
import colegio.model.entidades.ColOpcionesRespuesta;
import colegio.model.entidades.ColPregunta;
import colegio.model.entidades.ColRespuesta;

/**
 * @author jestevez
 * 
 */
@ViewScoped
@ManagedBean
public class PreguntasBean implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2703554307740171932L;

	// Llamada de los Dao y clases genericas
	private RegistrosDAO manager;

	private LogginBean login;
	// variable de almacenamiento de datos
		private Integer idguardar;
	// Atributos de las Preguntas
	/** @pdOid 982cbb14-137f-42ea-8f91-8772ab8b75ab */
	private Integer pre_id;
	/** @pdOid 261a5f6f-0cff-4853-9c12-d3b888c69c32 */
	private String pre_grupo_tematica;
	/** @pdOid 0188ba77-8e69-4350-bd97-3256a1e663fe */
	private String pre_topico;
	/** @pdOid fa89abf2-66b7-448f-9401-33017fb4539d */
	private String pre_img_enunciado;
	/** @pdOid 12ec372c-3a3d-46de-be7a-a7c4f590acf1 */
	private String pre_img_pregunta;

	// Atributo para carga de preguntas
	private List<ColPregunta> lpre = new ArrayList<ColPregunta>();
	private List<Lista> lres = new ArrayList<Lista>();
	
	//Edici�n
	private List<ColPregunta> preguntasResueltas;
	private List<ColPregunta> preguntasNoResueltas;
	private ColPregunta preguntaCargada;
	private int preguntaValor;
	private List<SelectItem> opcionesDeRespuesta;
	private ColEstudiante valor; 

	// Atributo para carga de Area
	private String p_area;
	private boolean dato;

	// Atributo para tomar el tiempo
	private String time;

	// Atributos para mostrar resultados
	private String tiempo_eva;
	private Integer calificacion = 0;
	private Timestamp tiempoactual;

	public PreguntasBean() {
		//LogginBean.verificarSession();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		login = (LogginBean) session.getAttribute("logginBean");
		valor = login.getEstudiante();
		dato=false;
		manager = new RegistrosDAO();
		lpre = new ArrayList<ColPregunta>();
		lres = new ArrayList<Lista>();
		preguntasResueltas = new ArrayList<ColPregunta>();
		preguntasNoResueltas = new ArrayList<ColPregunta>();
		opcionesDeRespuesta = new ArrayList<SelectItem>();
//		llenarPreguntas();
//		insertarEva();
	}
	
	public Integer getIdguardar() {
		return idguardar;
	}
	
	public void setIdguardar(Integer idguardar) {
		this.idguardar = idguardar;
	}
	
	public ColEstudiante getValor() {
		return valor;
	}

	public String getTiempo_eva() {
		return tiempo_eva;
	}

	public void setTiempo_eva(String tiempo_eva) {
		this.tiempo_eva = tiempo_eva;
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}

	/**
	 * @return the lres
	 */
	public List<Lista> getLres() {
		return lres;
	}

	/**
	 * @param lres
	 *            the lres to set
	 */
	public void setLres(List<Lista> lres) {
		this.lres = lres;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * @return the p_area
	 */
	public String getP_area() {
		return p_area;
	}

	/**
	 * @param p_area
	 *            the p_area to set
	 */
	public void setP_area(String p_area) {
		p_area = valor.getEstArea();
		this.p_area = p_area;
	}

	/**
	 * @return the lpre
	 */
	public List<ColPregunta> getLpre() {
		return lpre;
	}

	/**
	 * @return the pre_id
	 */
	public Integer getPre_id() {
		return pre_id;
	}

	/**
	 * @param pre_id
	 *            the pre_id to set
	 */
	public void setPre_id(Integer pre_id) {
		this.pre_id = pre_id;
	}

	/**
	 * @return the pre_grupo_tematica
	 */
	public String getPre_grupo_tematica() {
		return pre_grupo_tematica;
	}

	/**
	 * @param pre_grupo_tematica
	 *            the pre_grupo_tematica to set
	 */
	public void setPre_grupo_tematica(String pre_grupo_tematica) {
		this.pre_grupo_tematica = pre_grupo_tematica;
	}

	/**
	 * @return the pre_topico
	 */
	public String getPre_topico() {
		return pre_topico;
	}

	/**
	 * @param pre_topico
	 *            the pre_topico to set
	 */
	public void setPre_topico(String pre_topico) {
		this.pre_topico = pre_topico;
	}

	/**
	 * @return the pre_img_enunciado
	 */
	public String getPre_img_enunciado() {
		return pre_img_enunciado;
	}

	/**
	 * @param pre_img_enunciado
	 *            the pre_img_enunciado to set
	 */
	public void setPre_img_enunciado(String pre_img_enunciado) {
		this.pre_img_enunciado = pre_img_enunciado;
	}

	/**
	 * @return the pre_img_pregunta
	 */
	public String getPre_img_pregunta() {
		return pre_img_pregunta;
	}

	/**
	 * @param pre_img_pregunta
	 *            the pre_img_pregunta to set
	 */
	public void setPre_img_pregunta(String pre_img_pregunta) {
		this.pre_img_pregunta = pre_img_pregunta;
	}
	
	public List<ColPregunta> getPreguntasNoResueltas() {
		return preguntasNoResueltas;
	}
	
	public List<ColPregunta> getPreguntasResueltas() {
		return preguntasResueltas;
	}
	
	public void setPreguntasNoResueltas(List<ColPregunta> preguntasNoResueltas) {
		this.preguntasNoResueltas = preguntasNoResueltas;
	}
	
	public void setPreguntasResueltas(List<ColPregunta> preguntasResueltas) {
		this.preguntasResueltas = preguntasResueltas;
	}
	
	public List<SelectItem> getOpcionesDeRespuesta() {
		return opcionesDeRespuesta;
	}
	
	public void setOpcionesDeRespuesta(List<SelectItem> opcionesDeRespuesta) {
		this.opcionesDeRespuesta = opcionesDeRespuesta;
	}
	
	public int getPreguntaValor() {
		return preguntaValor;
	}
	
	public void setPreguntaValor(int preguntaValor) {
		this.preguntaValor = preguntaValor;
	}
	
	public ColPregunta getPreguntaCargada() {
		return preguntaCargada;
	}
	
	public void setPreguntaCargada(ColPregunta preguntaCargada) {
		this.preguntaCargada = preguntaCargada;
	}
	
	/**
	 * Metodo para listar todos los Datos de la Entidad
	 * 
	 * @return
	 */
	public List<ColPregunta> getListPreguntas() {
		List<ColPregunta> p = new ArrayList<ColPregunta>();
		try {
			p = manager.findAllPreguntas();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	
	public void llenarPreguntas(){
//		if(manager.redireccionarEvaluacion(valor.getEstId()))
//			cargarPreguntasEdicion();
//		else
			cargarPreguntas();
	}
	
//	private void cargarPreguntasEdicion() {
//		preguntasResueltas = manager.findPreguntasContestadasByEstudiante(valor.getEstId());
//		preguntasNoResueltas = manager.findPreguntasNoContestadasByEstudiante(valor.getEstId());
//	}
	
	public void cargarPregunta(ColPregunta pregunta){
		preguntaCargada = pregunta;
		cargarOpcionesPorPregunta(pregunta);
		preguntaValor = manager.findIdRespuestaByPreguntaEstudiante(pregunta, valor.getEstId());
		RequestContext.getCurrentInstance().execute("PF('dlgCP').show();");
	}
	
	private void cargarOpcionesPorPregunta(ColPregunta pregunta) {
		opcionesDeRespuesta.clear();
		for (ColOpcionesRespuesta opcion : pregunta.getColOpcionesRespuestas()) {
			opcionesDeRespuesta.add(new SelectItem(opcion.getOprId(), opcion.getOprOpcion()));
		}
	}
	
	public void editarPreguntaCargada(){
		try {
			manager.editarRespuestaEstudiante(preguntaCargada,valor.getEstId(),preguntaValor);
			RequestContext.getCurrentInstance().execute("PF('dlgCP').hide();");
			Mensaje.crearMensajeINFO("Datos almacenados correctamente");
		} catch (Exception e) {
			Mensaje.crearMensajeERROR("Error! "+e.getMessage());
		}
	}
	
	public boolean estaDesabilitadoBoton(ColPregunta pregunta){
		return !manager.respuestaEditable(pregunta, valor.getEstId());
	}
	
	public boolean activar(ColPregunta pre){
		ColRespuesta respuesta = manager.findRespuestasxEstudiantePregunta1(pre.getPreId(), valor.getEstId());
		if (respuesta == null){
			return false;
		}else{
			return true;
		}
		
	}

	/**
	 * Metodo para cargar las preguntas y opciones de respuesta de cada
	 * Evaluaci�n
	 */
	public void cargarPreguntas() {
//		for (ColPregunta pre : manager.findPreguntasEstudiante(valor.getEstArea().trim())) {
//				lpre.add(pre);
//				this.cargaOpcRespuesta(pre);
//		}
//		manager.insertarMac(login.getEstudiante().getEstId(),
//				Funciones.conseguirMAC());
		this.insertarEva();
//		Collections.shuffle(lpre);
//		Collections.shuffle(lres);
	}
	
	
	/**
	 * Metodo para cargar respuesta que ya estan contestas desactivadas
	 * 
	 * @param pregunta
	 */
	public void cargaOpcRespuesta(ColPregunta pregunta){
		ColRespuesta resp=manager.findRespuestasxEstudiantePregunta1(
				pregunta.getPreId(), valor.getEstId());
		if (resp==null){
			for (ColOpcionesRespuesta op : manager
					.findOpcionesxPregunta(pregunta.getPreId())) {
				Lista l = new Lista();
				l.setOpcionesRespuesta(op);
				l.setEnable(false);
				lres.add(l);
			}
		}
		else{
			for (ColOpcionesRespuesta op : manager
					.findOpcionesxPregunta(pregunta.getPreId())) {
				Lista l = new Lista();
				l.setOpcionesRespuesta(op);
				l.setEnable(true);
				lres.add(l);
			}
		}
	}
	
	

	/**
	 * Metodo de generacio de tiempo de la evaluaci�n y control del mismo
	 */
	public void calculoTiempo() {
		if (valor.getEstFechaFin().getTime() >= new Date()
				.getTime()) {
			this.tiempo();
		} else {
			time = "00:00";
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('poll').stop();");
			this.calculoEvaEstudiantil();
			context.execute("PF('close').show();");
		}
	}

	/**
	 * Metodo de mostrar y calcular el tiempo
	 */
	public void tiempo() {
		long timer = valor.getEstFechaFin().getTime()
				- new Date().getTime();

		long minutos = 0;
		long segundos = 0;

		minutos = timer / (60 * 1000);
		while (minutos >= 60) {
			minutos = minutos - 60;
		}

		segundos = timer / 1000;
		while (segundos >= 60) {
			segundos = segundos - 60;
		}

		time = minutos + ":" + segundos;
	}

	/**
	 * Metodo para salir de una evaluacion con muestra de resultado
	 */
	public void salir() {
		try {
			login.logout();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("/SisConcursoColegios/index.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo para insertar evaluaciones_estudiantil no repetidas
	 */
	public void insertarEva() {
		dato=true;
		if (dato==true){
		Integer eval = 0;
		System.out.println(valor.getEstArea()+"   si entra");
		ColEvaluacion eva=manager.findEvaluacionxArea(valor.getEstArea());
		if (eva!=null)
			eval= eva.getEvaId();
		ColEvaluacionEstudiantil eest= manager.EvaEstudiantilByID(valor.getEstId());
		if (eest==null){
			manager.insertarEvaEstudiantil(valor.getEstId(),
					eval, new Timestamp(new Date().getTime()), null, null);
		}
		}
	}

	/**
	 * Metodo para cambiar el estado de bloqueado
	 * 
	 * @param pregunta
	 */
	public void bloqueo(ColPregunta pregunta) {
		for (Lista or : lres) {
			if (or.getOpcionesRespuesta().getColPregunta().getPreId() == pregunta
					.getPreId()) {
				or.setEnable(true);
				for (ColRespuesta res: manager.findRespuestasxEstudiantePregunta(pregunta.getPreId(), valor.getEstId())){
					//	manager.editarRespuestaEstado(res.getResId(), false);
						manager.editarRespuestaEstadoString(res.getResId(), "F");
				}
			}
		}
	}

	/**
	 * Metodo lanzado para ver resultados de estudiantes y cierre de dialog y stop de poll
	 */
	public void verResultado() {
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('poll').stop();");
		this.calculoEvaEstudiantil();
		context.execute("PF('close').show();");
	}
	
	/**
	 * Metodo de calculo de calificacion y tiempo de cada evaluaci�n
	 */
	public void calculoEvaEstudiantil() {
		calificacion=0;
		List<ColRespuesta> res = manager.findAllRespuestas();
		for (ColRespuesta r : res) {
			if (r.getEstId() == valor.getEstId()) {
				calificacion += r.getColOpcionesRespuesta().getOprValor();
			}
		}
		List<ColEvaluacionEstudiantil> ee = manager.findAllEvaEstudiantil();
		for (ColEvaluacionEstudiantil eva : ee) {
			if (eva.getColEstudiante().getEstId() == valor.getEstId()) {
				tiempoactual= new Timestamp(new Date().getTime());
				this.totalTiempo(eva);
				manager.editarEvaEstudiantil(eva.getEesId(), tiempoactual, calificacion, tiempo_eva);
				break;
			}
		}

	}
	
	/**
	 * Metodo de c�lculo de tiempo
	 * 
	 * @param eva_est
	 */
	public void totalTiempo(ColEvaluacionEstudiantil eva_est) {
		tiempo_eva ="";
		long time = tiempoactual.getTime()
				- eva_est.getEesFechaIni().getTime();

		long minutos = 0;
		long segundos = 0;

		minutos = time / (60 * 1000);
		while (minutos >= 60) {
			minutos = minutos - 60;
		}

		segundos = time / 1000;
		while (segundos >= 60) {
			segundos = segundos - 60;
		}

		tiempo_eva = minutos + ":" + segundos;

	}

	
	/**
	 * Metodo para mostrar un resultado
	 * 
	 * @param pregunta
	 * @return
	 */
	public String mostrarRespuesta(ColPregunta pregunta){
		StringBuilder s= new StringBuilder();
		for (ColRespuesta resp: manager.findRespuestasxEstudiantePregunta(pregunta.getPreId(), valor.getEstId())){
			s.append(resp.getColOpcionesRespuesta().getOprOpcion());
		}
		return s.toString();
	}
	
	public void insertarRespuesta() {
		try {
			ColOpcionesRespuesta or = manager.OpcionesByID(getIdguardar());
			if (or==null){
				Mensaje.crearMensajeINFO("La pregunta que usted selecciono, no pudo ser leida vuelva a seleccionarla");
			}else{
			List<ColRespuesta> lr = manager.findRespuestasxEstudiantePregunta(or
					.getColPregunta().getPreId(), valor.getEstId());
			if (lr.size() == 0) {
				manager.insertarRespuesta(new Timestamp(new Date().getTime()),
						or.getOprId(), or.getColPregunta().getPreId(), valor.getEstId(), true);
			} else {
				for (ColRespuesta res : lr)
					manager.editarRespuesta(res.getResId(), new Timestamp(
							new Date().getTime()), or.getOprId());
			}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Metodos de traslado
	public String iniciarMate(){
		this.insertarEva();
		return "eval_mate.xhtml";
	}
	
	public String iniciarBiol(){
		System.out.println(valor.getEstId());
		this.insertarEva();
		return "eval_biologia.xhtml";
	}
	
	public String iniciarQuim(){
		System.out.println(valor.getEstId());
		this.insertarEva();
		return "eval_quimica.xhtml";
	}
	
	public String iniciarFisi(){
		System.out.println(valor.getEstId());
		this.insertarEva();
		return "eval_fisica.xhtml";
	}
}
