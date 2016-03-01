package colegio.manager;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import colegio.model.conection.Resultado;
import colegio.model.conection.SingletonJDBC;
import colegio.model.entidades.ColInstitucion;

public class ManagerConexion {

	private ManagerDAO mngDAO;

	private SingletonJDBC con;

	public ManagerConexion() {
		con = SingletonJDBC.getInstance();
		mngDAO = new ManagerDAO();
	}

	public List<Resultado> resultadoEvaluaciones() throws Exception {
		List<Resultado> listado = new ArrayList<Resultado>();
		ResultSet consulta = con
				.consultaSQL("select i.ins_amie as amie,  ins_nombre as inom, ins_provincia as iprov, "
						+ "e.est_cedula as eci, e.est_apellidos as eap, e.est_nombres as enom, e.est_area as earea, e.est_fecha_ini as fi, e.est_fecha_fin as ff, "
						+ "ee.ees_tiempo as tiempo, ee.ees_calificacion as calificacion "
						+ "from col_evaluacion_estudiantil ee,  col_estudiante e, col_institucion i "
						+ "where ee.est_id = e.est_id AND e.ins_id = i.ins_id "
						+ "and ee.ees_fecha_ini is not null and ee.ees_fecha_fin is not null "
						+ "order by e.est_area, ee.ees_calificacion desc, ee.ees_tiempo asc;");
		if (consulta != null) {
			while (consulta.next()) {
				listado.add(new Resultado(
				consulta.getString("amie"), 
				consulta.getString("inom"), 
				consulta.getString("iprov"),
				consulta.getString("eci"), 
				consulta.getString("eap"),
				consulta.getString("enom"),
				consulta.getString("earea"),
				consulta.getTimestamp("fi"), 
				consulta.getTimestamp("ff"), 
				consulta.getString("tiempo"), 
				consulta.getInt("calificacion")));
			}
		}
		System.out.println(listado.size());
		return listado;
	}

	public List<Resultado> resultadoEvaluaciones(int idInstitucion,
			String materia) throws Exception {
		List<Resultado> listado = new ArrayList<Resultado>();
		StringBuilder sql = new StringBuilder();
		sql.append("select i.ins_amie as amie,  ins_nombre as inom, ins_provincia as iprov, "
				+ "e.est_cedula as eci, e.est_apellidos as eap, e.est_nombres as enom, e.est_area as earea, e.est_fecha_ini as fi, e.est_fecha_fin as ff, "
				+ "ee.ees_tiempo as tiempo, ee.ees_calificacion as calificacion "
				+ "from col_evaluacion_estudiantil ee, col_estudiante e, col_institucion i "
				+ "where ee.est_id = e.est_id AND e.ins_id = i.ins_id ");
		if (idInstitucion != 0)
			sql.append("and i.ins_id=" + idInstitucion + " ");
		if (!materia.trim().isEmpty())
			sql.append("and e.est_area='" + materia + "'");
		sql.append("and ee.ees_fecha_ini is not null and ee.ees_fecha_fin is not null order by e.est_area, ee.ees_calificacion desc, ee.ees_tiempo asc;");
		ResultSet consulta = con.consultaSQL(sql.toString());
		if (consulta != null) {
			while (consulta.next()) {
				listado.add(new Resultado(
				consulta.getString("amie"), 
				consulta.getString("inom"), 
				consulta.getString("iprov"), 
				consulta.getString("eci"), 
				consulta.getString("eap"), 
				consulta.getString("enom"), 
				consulta.getString("earea"), 
				consulta.getTimestamp("fi"), 
				consulta.getTimestamp("ff"), 
				consulta.getString("tiempo"), 
				consulta.getInt("calificacion")));
			}
		}
		return listado;
	}

	public List<Resultado> resultadoEvaluacionesGanadores() throws Exception {
		List<Resultado> listado = new ArrayList<Resultado>();
		ResultSet consulta = con
				.consultaSQL("select distinct on(est_area,ins_amie) e.est_area as earea, e.est_correo as ecorreo, i.ins_amie as amie, i.ins_nombre as inom, i.ins_provincia as iprov,"
						+ " e.est_cedula as eci, e.est_apellidos as eap, e.est_nombres as enom, e.est_fecha_ini as fi, e.est_fecha_fin as ff,"
						+ " min(ee.ees_tiempo) as tiempo, max(ee.ees_calificacion) as valor"
						+ " from col_evaluacion_estudiantil as ee, col_estudiante as e, col_institucion as i"
						+ " where ee.est_id = e.est_id AND e.ins_id = i.ins_id"
						+ " and ee.ees_fecha_ini is not null and ee.ees_fecha_fin is not null"
						+ " group by i.ins_amie, i.ins_nombre, i.ins_provincia, e.est_cedula, e.est_apellidos, e.est_nombres, e.est_area,e.est_correo, e.est_fecha_ini, e.est_fecha_fin,"
						+ " ee.ees_tiempo , ee.ees_calificacion order by e.est_area, i.ins_amie ,ee.ees_calificacion desc,ee.ees_tiempo asc, i.ins_nombre;");
		if (consulta != null) {
			while (consulta.next()) {
				listado.add(new Resultado(consulta.getString("amie"), consulta
						.getString("inom"), consulta.getString("iprov"),
						consulta.getString("eci"), consulta
								.getString("ecorreo"), consulta
								.getString("eap"), consulta.getString("enom"),
						consulta.getString("earea"), consulta
								.getTimestamp("fi"), consulta
								.getTimestamp("ff"), consulta
								.getString("tiempo"), consulta.getInt("valor")));
			}
		}
		System.out.println(listado.size());
		return listado;
	}

	public List<Resultado> resultadoTotalGanadores() throws Exception {
		List<Resultado> listado = new ArrayList<Resultado>();
		ResultSet consulta = con
				.consultaSQL("select distinct on(est_area,ins_amie) e.est_area as earea,i.ins_amie as amie, i.ins_nombre as inom,i.ins_provincia as iprov,"
						+ " min(ee.ees_tiempo) as tiempo, max(ee.ees_calificacion) as valor"
						+ "	from col_evaluacion_estudiantil as ee, col_estudiante as e, col_institucion as i"
						+ " where ee.est_id = e.est_id AND e.ins_id = i.ins_id"
						+ " and ee.ees_fecha_ini is not null and ee.ees_fecha_fin is not null"
						+ " group by i.ins_amie, i.ins_nombre, i.ins_provincia, e.est_cedula, e.est_apellidos, e.est_nombres, e.est_area, e.est_fecha_ini, e.est_fecha_fin, "
						+ "ee.ees_tiempo , ee.ees_calificacion "
						+ "order by e.est_area, i.ins_amie ,ee.ees_calificacion desc,ee.ees_tiempo asc, i.ins_nombre; ");
		if (consulta != null) {
			while (consulta.next()) {
				listado.add(new Resultado(consulta.getString("amie"), consulta
						.getString("inom"), consulta.getString("iprov"),
						consulta.getString("earea"), consulta
								.getString("tiempo"), consulta.getInt("valor")));
			}
		}
		System.out.println(listado.size());
		return listado;
	}

	@SuppressWarnings("unchecked")
	public List<ColInstitucion> findAllInstituciones() {
		return mngDAO.findAll(ColInstitucion.class, "o.insNombre");
	}

}
