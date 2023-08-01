package manejador;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import logica.Plataforma;

import logica.Usuario;
import persistencia.Conexion;



public class ManejadorPlataforma {
	
	private static ManejadorPlataforma instancia=null;
	//private List<Plataforma> plataformas = new ArrayList<>();
	
	
	private ManejadorPlataforma (){};
	
	public static ManejadorPlataforma getInstancia(){
		if(instancia == null)
			instancia = new ManejadorPlataforma();
		return instancia;		
	}
	
	public boolean existePlataforma(String nombrePlataforma) {
		boolean existe=false;
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("select p from Plataforma p");
		List<Plataforma> listaPlataforma = (List<Plataforma>) query.getResultList();
		
		
		
		for(Plataforma p:listaPlataforma) {
			if(p.getNombre().equals(nombrePlataforma)){
			existe=true;
			}
		}
		return existe;
	}
	
	public void agregarPlataforma(Plataforma plataforma) {
		//plataformas.add(plataforma);
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(plataforma);
		
		em.getTransaction().commit();
	
	}
	
	public List<Plataforma> getColeccionPlataformas(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("select p from Plataforma p");
		List<Plataforma> listaPlataforma = (List<Plataforma>) query.getResultList();
		
		
		List<Plataforma> coleccion = new ArrayList<>();
		for(Plataforma p:listaPlataforma) {
			coleccion.add(p);
		}
		return coleccion;
	}
	
	public Plataforma getPlataforma(String nombrePlataforma) {
		/*Plataforma pbuscada = null;
		for(Plataforma p:plataformas) {
			if(p.getNombre().equals(nombrePlataforma)) {
				pbuscada = p;
			}
		}
		return pbuscada;
		*/
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Plataforma plataforma = em.find(Plataforma.class, nombrePlataforma);
		return plataforma;
	
	}
	

	public ArrayList<String> obtenerPlataformas(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select p from Plataforma p");
		List<Plataforma> listaPlataforma = (List<Plataforma>) query.getResultList();
		
		ArrayList<String> nombres=new ArrayList<>();
		for(Plataforma p:listaPlataforma) {
			nombres.add(p.getNombre());
		}
		return nombres;
	}
	

}