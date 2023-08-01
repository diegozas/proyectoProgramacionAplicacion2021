package controladores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import excepciones.ExisteRegistroExcepcion;
import interfaces.ICRegistroFuncion;
import logica.Espectaculo;
import logica.Espectador;
import logica.Funcion;
import logica.Plataforma;
import logica.Usuario;
import manejador.ManejadorEspectaculos;
import manejador.ManejadorPlataforma;
import manejador.ManejadorUsuario;
import persistencia.Conexion;

public class CRegistroFuncion implements ICRegistroFuncion {

	@Override
	public String[] listarPlataformas() {
		ArrayList<String> plataformas;
		ManejadorPlataforma mp = ManejadorPlataforma.getInstancia();
		plataformas = mp.obtenerPlataformas();
		String[] plataformas_ret = new String[plataformas.size()];
        int i=0;
        for(String p:plataformas) {
        	plataformas_ret[i]=p;
        	i++;
        }
        return plataformas_ret;
	}

	
	@Override
	public String[] listarEspectadores() {
		ManejadorUsuario mu=ManejadorUsuario.getInstancia();
		List<String> nicksEspectador=mu.nickEspectadores();
		String[] nick_retorno=new String[nicksEspectador.size()];
		int i=0;
		for(String s:nicksEspectador) {
			nick_retorno[i]=s;
			i++;
		}
		return nick_retorno;
		
	}
	@Override
	public String[] espectaculosPlataforma(String plataforma) {
		ManejadorPlataforma mp=ManejadorPlataforma.getInstancia();
		Plataforma p=mp.getPlataforma(plataforma);
		String[] espectaculos=p.listarEspectaculos();
		return espectaculos;
	}

	@Override
	public String[] funcionesEspectaculo(String espectaculo) {
		ManejadorEspectaculos me=ManejadorEspectaculos.getInstancia();
		Espectaculo e=me.buscarEspectaculo(espectaculo);
		String[] funciones=e.listarFunciones();
		return funciones;
	}

	@Override
	public void registroFuncion(String usuario,String espectaculo,String funcion) throws ExisteRegistroExcepcion {
		ManejadorUsuario mu=ManejadorUsuario.getInstancia();
		ManejadorEspectaculos me=ManejadorEspectaculos.getInstancia();
		Espectaculo e=me.buscarEspectaculo(espectaculo);
		Funcion f=e.getFuncion(funcion);
		Espectador esp=mu.buscarEspectador(usuario);
		esp.agregarFuncion(f);
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(esp);
		em.getTransaction().commit();
		
		
	}

}
