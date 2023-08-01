package controladores;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import datatypes.DtUsuario;
import interfaces.ICModificarDatosUsuario;
import logica.Usuario;
import manejador.ManejadorUsuario;
import persistencia.Conexion;

public class CModificarDatosUsuario implements ICModificarDatosUsuario {

	@Override
	public String[] nickUsuarios() {
		ManejadorUsuario mu=ManejadorUsuario.getInstancia();
		ArrayList<String> nickUsuarios=mu.getNickUsuarios();
		String[] nick_retorno=new String[nickUsuarios.size()];
		int i=0;
		for(String s:nickUsuarios) {
			nick_retorno[i]=s;
			i++;
		}
		return nick_retorno;
	}

	@Override
	public DtUsuario datosUsuario(String usuario) {
		ManejadorUsuario mu=ManejadorUsuario.getInstancia();
		Usuario u=mu.getUsuario(usuario);
		DtUsuario dtu=u.datosUsuario();
		return dtu;
	}

	
	@Override
	public void modificarDatos(String usuario, DtUsuario dt) {
		ManejadorUsuario mu=ManejadorUsuario.getInstancia();
		Usuario u=mu.getUsuario(usuario);
		if(!dt.getApellido().isEmpty()) {
			u.setApellido(dt.getApellido());
		}
		if(!dt.getNombre().isEmpty()) {
			u.setNombre(dt.getNombre());
		}
		if(dt.getFnac().getDay()!=0 && dt.getFnac().getMonth()>=0 && dt.getFnac().getYear()!=0) {
			u.setFechaNacimiento(dt.getFnac());
		}
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(u);
		
		em.getTransaction().commit();
	}

}
