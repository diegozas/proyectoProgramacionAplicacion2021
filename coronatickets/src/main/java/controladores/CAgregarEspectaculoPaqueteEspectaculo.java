package controladores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import interfaces.ICAgregarEspectaculoPaqueteEspectaculo;
import logica.Espectaculo;
import logica.PaqueteEspectaculo;
import logica.Plataforma;
import manejador.ManejadorEspectaculos;
import manejador.ManejadorPaqueteEspectaculo;
import manejador.ManejadorPlataforma;
import persistencia.Conexion;

public class CAgregarEspectaculoPaqueteEspectaculo implements ICAgregarEspectaculoPaqueteEspectaculo {

	@Override
	public String[] listarPaquetes() {
		ManejadorPaqueteEspectaculo mp=ManejadorPaqueteEspectaculo.getInstancia();
		List<String> nombresPaquetes=mp.getNombresPaquetes();
		String[] nombres_retorno=new String[nombresPaquetes.size()];
		int i=0;
		for(String s:nombresPaquetes) {
			nombres_retorno[i]=s;
			i++;
		}
		return nombres_retorno;
	}

	@Override
	public String[] listarPlataforma() {
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
	public String[] listarEspectaculosSinAgregar(String plataforma,String paquete) {
		ManejadorPlataforma mp = ManejadorPlataforma.getInstancia();
		ManejadorPaqueteEspectaculo mpe=ManejadorPaqueteEspectaculo.getInstancia();
		PaqueteEspectaculo pa=mpe.getPaquete(paquete);
		Plataforma p= mp.getPlataforma(plataforma);
		
		List<String> nombresEspectaculos=p.getNombreEspectaculos();
		List<String> nombres=new ArrayList<String>();
	
		for(String s:nombresEspectaculos) {
				if(!pa.existeEspectaculo(s)) {
					nombres.add(s);
				}
			}
			int i=0;
			String[] nombres_retorno=new String[nombres.size()];
			for(String s1:nombres) {
				nombres_retorno[i]=s1;
				i++;
			}
				
			return nombres_retorno;
}

		
		


	@Override
	public void agregarEspectaculo(String paquete,String espectaculo) {
		ManejadorPaqueteEspectaculo mpe=ManejadorPaqueteEspectaculo.getInstancia();
		ManejadorEspectaculos mp=ManejadorEspectaculos.getInstancia();
		
		PaqueteEspectaculo pa=mpe.getPaquete(paquete);
		
		Espectaculo e=mp.buscarEspectaculo(espectaculo);
		
		pa.agregarEspectaculo(e);
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(pa);
		em.getTransaction().commit();
	}

}
