package colegio.manager;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import colegio.acceso.entidades.Menu;
import colegio.acceso.entidades.Submenu;
import colegio.acceso.servicio.ConsumeREST;
import colegio.controller.generic.Mail;

public class ManagerAcceso {
	
	/**
	 * Lista de menus para menú dinámico
	 * @param menu
	 * @return List<Menu>
	 */
	public List<Menu> cargarMenu(JSONArray menu){
		List<Menu> menus = new ArrayList<Menu>();
		for (Object objmenu : menu) {
			Menu gmenu = new Menu();
			gmenu.setNombre(((JSONObject)objmenu).get("nombre").toString());
			gmenu.setLstLinks(new ArrayList<Submenu>());
			JSONArray jvistas = (JSONArray) ((JSONObject)objmenu).get("vistas");
			for (Object objvis : jvistas) {
				gmenu.getLstLinks().add(new Submenu(((JSONObject) objvis).get("nombre").toString(),
						((JSONObject) objvis).get("link").toString()));
			}
			menus.add(gmenu);
			gmenu=null;
		}	
		return menus;
	}
	
	@SuppressWarnings("unchecked")
	public List<Menu> loginWS(String usr, String pass, String aplicacion) throws Exception
	{
		List<Menu> lmenu = new ArrayList<Menu>();
		JSONObject salida = new JSONObject();
		salida.put("usr", usr);salida.put("pwd", pass);salida.put("apl", aplicacion);
		JSONObject respuesta = ConsumeREST.postClient("http://10.1.0.157:8080/sgupy/WSLogin/postPermisos",salida);
		if(!respuesta.get("status").equals("OK"))
			throw new Exception("ERROR al consultar sus permisos: "+respuesta.get("mensaje").toString());
		else
			lmenu = cargarMenu((JSONArray) respuesta.get("value"));
		return lmenu;
		
	}
	
	@SuppressWarnings("unchecked")
	public void MailWS(Mail m) throws Exception
	{
		JSONObject salida = new JSONObject();
		salida.put("id", m.getId());
		salida.put("para", m.getPara());
		salida.put("asunto", m.getAsunto());
		salida.put("body", m.getBody());
		JSONObject respuesta = ConsumeREST.postClient("http://10.2.32.177:8080/serviceMails/WSMailYachay",salida);
		if(!respuesta.get("status").equals("OK"))
			throw new Exception("ERROR al enviar sus correos: "+respuesta.get("mensaje").toString());
		else
			System.out.println("Mensaje Enviado");
	}
	
	
}