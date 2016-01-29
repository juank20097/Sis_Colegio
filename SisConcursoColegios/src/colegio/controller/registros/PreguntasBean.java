package colegio.controller.registros;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import colegio.manager.RegistrosDAO;
import colegio.model.entidades.ColOpcionesRespuesta;
import colegio.model.entidades.ColPregunta;

/**
 * @author jestevez
 * 
 */
@SessionScoped
@ManagedBean
public class PreguntasBean {

	// Llamada de los Dao y clases genericas
	private RegistrosDAO manager;

	private LogginBean login;

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
	private List<ColOpcionesRespuesta> lres = new ArrayList<ColOpcionesRespuesta>();

	// Atributo para carga de Area
	private String p_area;

	// Atributo para tomar el tiempo
	private String time;

	public PreguntasBean() {
		LogginBean.verificarSession();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		login = (LogginBean) session.getAttribute("logginBean");
		manager = new RegistrosDAO();
		this.cargarPreguntas();
	}

	/**
	 * @return the lres
	 */
	public List<ColOpcionesRespuesta> getLres() {
		return lres;
	}

	/**
	 * @param lres
	 *            the lres to set
	 */
	public void setLres(List<ColOpcionesRespuesta> lres) {
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
		p_area = login.getEstudiante().getEstArea();
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

	public void cargarPreguntas() {
			lpre = new ArrayList<ColPregunta>();
			lres = new ArrayList<ColOpcionesRespuesta>();
			for (ColPregunta pre : manager.findAllPreguntas()) {
				if (pre.getColEvaluacion().getEvaArea().trim()
						.equals(login.getEstudiante().getEstArea().trim())) {
					lpre.add(pre);
					for (ColOpcionesRespuesta op : manager.findAllOpciones()) {
						if (op.getColPregunta().getPreId() == pre.getPreId()) {
							lres.add(op);
						}
				}
			}
			}
			Collections.shuffle(lpre);
			Collections.shuffle(lres);
	}

	public void calculoTiempo() {
		if (login.getEstudiante().getEstFechaFin().getTime() >= new Date()
				.getTime()) {
			long timer = login.getEstudiante().getEstFechaFin().getTime()
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
			System.out.println(time);
		} else {
			time = "00:00";
			try {
				login.logout();
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect("/SisConcursoColegios/faces/index.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	// ////////////////////////////////////////--------------Opciones
	// Respuestas---------------///////////////////////////////////////////

	// Atributos de las Preguntas
	private Integer oprId;
	private String oprOpcion;
	private String oprRespuesta;
	private BigDecimal oprValor;
	private Integer colPregunta;

	/**
	 * @return the oprId
	 */
	public Integer getOprId() {
		return oprId;
	}

	/**
	 * @param oprId
	 *            the oprId to set
	 */
	public void setOprId(Integer oprId) {
		this.oprId = oprId;
	}

	/**
	 * @return the oprOpcion
	 */
	public String getOprOpcion() {
		return oprOpcion;
	}

	/**
	 * @param oprOpcion
	 *            the oprOpcion to set
	 */
	public void setOprOpcion(String oprOpcion) {
		this.oprOpcion = oprOpcion;
	}

	/**
	 * @return the oprRespuesta
	 */
	public String getOprRespuesta() {
		return oprRespuesta;
	}

	/**
	 * @param oprRespuesta
	 *            the oprRespuesta to set
	 */
	public void setOprRespuesta(String oprRespuesta) {
		this.oprRespuesta = oprRespuesta;
	}

	/**
	 * @return the oprValor
	 */
	public BigDecimal getOprValor() {
		return oprValor;
	}

	/**
	 * @param oprValor
	 *            the oprValor to set
	 */
	public void setOprValor(BigDecimal oprValor) {
		this.oprValor = oprValor;
	}

	/**
	 * @return the colPregunta
	 */
	public Integer getColPregunta() {
		return colPregunta;
	}

	/**
	 * @param colPregunta
	 *            the colPregunta to set
	 */
	public void setColPregunta(Integer colPregunta) {
		this.colPregunta = colPregunta;
	}

	public List<ColOpcionesRespuesta> resp(ColPregunta p) {
		lres = new ArrayList<ColOpcionesRespuesta>();
		for (ColOpcionesRespuesta pre : manager.findAllOpciones()) {
			if (pre.getColPregunta().getPreId() == p.getPreId()) {
				lres.add(pre);
			}
		}
		return lres;
	}

}