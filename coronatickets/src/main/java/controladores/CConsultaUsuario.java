package controladores;

import java.util.ArrayList;

import interfaces.ICConsultaUsuario;
import logica.Espectador;
import logica.Usuario;
import manejador.ManejadorEspectaculos;
import manejador.ManejadorUsuario;

public class CConsultaUsuario implements ICConsultaUsuario {

	@Override
	public String[] nickUsuarios() {
		ManejadorUsuario mu=ManejadorUsuario.getInstancia();
		ArrayList <String> nickUsuarios=mu.getNickUsuarios();
		String[] nickUsuarioRetorno=new String[nickUsuarios.size()];
		int i=0;
		for(String s:nickUsuarios) {
			nickUsuarioRetorno[i]=s;
			i++;
		}
		
		return nickUsuarioRetorno;
	}

	@Override
	public String[] nobresEspectaculos(String usuario) {
		ManejadorEspectaculos me=ManejadorEspectaculos.getInstancia();
		ArrayList<String> espectaculos=me.getEspectaculosArtista(usuario);
		String[] espectaculos_retorno=new String[espectaculos.size()];
		int i=0;
		for(String s: espectaculos) {
			espectaculos_retorno[i]=s;
			i++;
		}
			
		return espectaculos_retorno;
	
	}


	@Override
	public String[] funcionesEspectador(String espectador) {
		ManejadorUsuario mu=ManejadorUsuario.getInstancia();
		Espectador esp=mu.buscarEspectador(espectador);
		String[] funciones=esp.getFunciones();
		return funciones;
		
		
	}




}
