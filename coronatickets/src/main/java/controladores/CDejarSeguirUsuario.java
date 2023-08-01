package controladores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import interfaces.ICDejarDeSeguirUsuario;
import logica.Usuario;
import manejador.ManejadorUsuario;
import persistencia.Conexion;

public class CDejarSeguirUsuario implements ICDejarDeSeguirUsuario {

	@Override
	public ArrayList<String> seguidores(String usuario) {
		ArrayList <String>seguidos=new ArrayList<String>();
		
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		
		Usuario u=mu.getUsuario(usuario);
		
		List<Usuario> seguidoss=u.getSeguidos();
		
		for(Usuario u1:seguidoss){
			seguidos.add(u1.getNickname());
		}
		
		return seguidos;
	}

	@Override
	public void dejarSeguirUsuario(String usuarioSeguido, String nick) {
		ManejadorUsuario mu=ManejadorUsuario.getInstancia();

		Usuario u=mu.getUsuario(nick);
		Usuario usuarioSeguidoo=mu.getUsuario(usuarioSeguido);

		u.dejarSeguirUsuario(usuarioSeguidoo);
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();

	}

}
