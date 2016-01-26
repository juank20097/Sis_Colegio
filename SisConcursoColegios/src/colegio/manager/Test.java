/**
 * 
 */
package colegio.manager;


import java.util.ArrayList;
import java.util.List;

import colegio.model.entidades.ColPregunta;



/**
 * @author jestevez
 *
 */
public class Test {
	
	
	public Test() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		
//		try {
//			Funciones.sendMail("jestevez@yachay.gob.ec",
//					"juank20097@yopmail.com",
//					"Notificación de Olimpiadas de Ciencias", "hola");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//	RegistrosDAO r = new RegistrosDAO();
		ManagerDAO m = new ManagerDAO();
//		List<ColInstitucion> g=new ArrayList<>();
//		g=m.findWhere(ColInstitucion.class, "o.insZona=", null);
//		System.out.println(g.size());
		
		List<ColPregunta> t=new ArrayList<>();
		t=m.findAllAleatorioP(ColPregunta.class);
		System.out.println(t.size());
//	List<COL_Instituciones_Senescyt> c= new ArrayList<COL_Instituciones_Senescyt>();
//	c=r.findAllInstitucionesS();
//	System.out.println(c.size());
//	
//	COL_Instituciones_Senescyt z = new COL_Instituciones_Senescyt();
//	try {
//		z=r.InstitucionSByID("01H00076");
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
		
//	System.out.println(Funciones.validadorDeCedula("1001551785"));
//	System.out.println(z.getSen_nombre());
//	System.out.println(h.Activado());
	
	
//	l=r.findAllEstudiantesActivos('A');
//	l=r.findAllEstudiantesXID(14);
//	System.out.println(l.size());
//	System.out.println(Funciones.conseguirMAC());
		
//	COL_Parametros p=r.ParametroByNombre("institucion");
//	System.out.println(p.isPar_valor());
//	System.out.println(p.isPar_entidad());
	}

}
