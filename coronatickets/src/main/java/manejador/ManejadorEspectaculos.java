package manejador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import datatypes.DtEspectaculoFull;
import logica.Espectaculo;
import persistencia.Conexion;

public class ManejadorEspectaculos {
	private static ManejadorEspectaculos instancia=null;
	//private List<Espectaculo> espectaculos = new ArrayList<>();
	
	private ManejadorEspectaculos() {}
	
	public static ManejadorEspectaculos getInstancia() {
		if(instancia==null)
			instancia=new ManejadorEspectaculos();
		return instancia;
	}
	
	
	public boolean existeFuncion(String funcion) {
		boolean retorno =false;
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("select e from Espectaculo e");
		List<Espectaculo> listaEspectaculo = (List<Espectaculo>) query.getResultList();
		
		
		for(Espectaculo e:listaEspectaculo) {
			if(e.existeFuncion(funcion)) {
				retorno=true;
			}
		}
		return retorno;
		
	}
	
	
	
	
	
	public void agregarEspectaculo(Espectaculo esp) {
		//espectaculos.add(esp);
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(esp);
		
		em.getTransaction().commit();
	}
	
	public Espectaculo buscarEspectaculo(String espectaculo) {
		//Espectaculo retorno=null;
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		 Espectaculo retorno= em.find(Espectaculo.class, espectaculo);
		
		
		/*for(Espectaculo e:espectaculos) {
			if(e.getNombre().equals(espectaculo))
				retorno=e;
		}*/
		
		return retorno;
	}
	
	public boolean existeEspectaculo(String nombre) {
		boolean retorno =false;
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("select e from Espectaculo e");
		List<Espectaculo> listaEspectaculo = (List<Espectaculo>) query.getResultList();
		
		
		for(Espectaculo e:listaEspectaculo) {
			if(e.getNombre().equals(nombre)) {
				retorno=true;
			}
		}
		return retorno;
	}
	
	@SuppressWarnings("null")
	public ArrayList<String> getEspectaculosArtista(String artista){
		ArrayList<String> retorno=new ArrayList<String>();
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("select e from Espectaculo e");
		List<Espectaculo> listaEspectaculo = (List<Espectaculo>) query.getResultList();
		
		for(Espectaculo e:listaEspectaculo) {
			if(e.getArtista().getNickname().equals(artista)) {
				retorno.add(e.getNombre());
			}
		}
		return retorno;
	}
	
	
	@SuppressWarnings("null")
		public List<String> obtenerEspectaculos(){
		

		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("select e from Espectaculo e");
		List<Espectaculo> listaEspectaculo = (List<Espectaculo>) query.getResultList();
		
		
		List<String> retorno=new ArrayList<String>();
		for(Espectaculo e:listaEspectaculo) {
			retorno.add(e.getNombre());
		}
		return retorno;
	}
	
	/*public DtEspectaculoFull obtenerDtEspectaculoFull(String nombre) {
		DtEspectaculoFull dt=null;
		Espectaculo esp=this.buscarEspectaculo(nombre);
		if(esp !=null) {
			dt=new DtEspectaculoFull(esp.getNombre(),esp.getArtista(),"plataforma", esp.getDuracion(), esp.getCantMin(),
					esp.getCantMax(), esp.getUrl(), esp.getFechaRegistro(), esp.getCosto(), esp.getDescripcion(), esp.obtenerFunciones());
		}		
		return dt;
	}
	*/
}
