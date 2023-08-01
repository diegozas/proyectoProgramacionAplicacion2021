package controladores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import interfaces.ICSeguirUsuario;
import logica.Usuario;
import manejador.ManejadorUsuario;
import persistencia.Conexion;

public class CSeguirUsuario implements ICSeguirUsuario {
	//private String usuario;
	
	
	@SuppressWarnings("null")
	@Override
	public ArrayList<String> sinSeguir(String usuario) {
		//this.usuario=usuario;
		ArrayList <String>noSeguidos=new ArrayList<String>();
		
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		
		ArrayList<String> nickUsuarios=mu.getNickUsuarios();
		Usuario u=mu.getUsuario(usuario);
		
		List<Usuario> seguidos=u.getSeguidos();
		
		for(String s:nickUsuarios){
			if(!u.sigueUsuario(s) && !u.getNickname().equals(s)){
				noSeguidos.add(s);
				}
			}
		return noSeguidos;
	}
	
	@Override
	public void seguirUsuario(String usuarioSeguir,String nick) {
			ManejadorUsuario mu=ManejadorUsuario.getInstancia();

			Usuario u=mu.getUsuario(nick);
			Usuario uSeguir=mu.getUsuario(usuarioSeguir);
	
			u.seguirUsuario(uSeguir);
			
			Conexion conexion = Conexion.getInstancia();
			EntityManager em = conexion.getEntityManager();
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
		
	
		
		
	}

}
