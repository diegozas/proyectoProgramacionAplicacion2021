package manejador;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import logica.PaqueteEspectaculo;
import logica.Plataforma;
import persistencia.Conexion;

public class ManejadorPaqueteEspectaculo {
	
	
	private static  ManejadorPaqueteEspectaculo instancia=null;
	//private List<Plataforma> plataformas = new ArrayList<>();
	
	
	private  ManejadorPaqueteEspectaculo (){};
	
	public static  ManejadorPaqueteEspectaculo getInstancia(){
		if(instancia == null)
			instancia = new  ManejadorPaqueteEspectaculo();
		return instancia;		
	}
	
	
	
	public boolean existePaquete(String nombrePaquete) {
		boolean existe=false;
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("select p from PaqueteEspectaculo p");
		List<PaqueteEspectaculo> listaPaquete = (List<PaqueteEspectaculo>) query.getResultList();
		
		
		
		for(PaqueteEspectaculo p:listaPaquete) {
			if(p.getNombre().equals(nombrePaquete)){
			existe=true;
			}
		}
		return existe;
	}
	
	
	public void agregarPaqueteEspectaculo(PaqueteEspectaculo paquete) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(paquete);
		
		em.getTransaction().commit();
	
	}
	
	public List<String> getNombresPaquetes(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("select p from PaqueteEspectaculo p");
		List<PaqueteEspectaculo> listaPaquetes = (List<PaqueteEspectaculo>) query.getResultList();
		
		
		List<String> coleccion = new ArrayList<>();
		for(PaqueteEspectaculo p:listaPaquetes) {
			coleccion.add(p.getNombre());
		}
		return coleccion;
	}
	public PaqueteEspectaculo getPaquete(String nombrePaquete) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		PaqueteEspectaculo paquete = em.find(PaqueteEspectaculo.class, nombrePaquete);
		return paquete;
	
	}
	public List<PaqueteEspectaculo> getColeccionPaqueteEspectaculo(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("select p from PaqueteEspectaculo p");
		List<PaqueteEspectaculo> listaPaquete = (List<PaqueteEspectaculo>) query.getResultList();
		
		
		List<PaqueteEspectaculo> coleccion = new ArrayList<>();
		for(PaqueteEspectaculo p:listaPaquete) {
			coleccion.add(p);
		}
		return coleccion;
	}
	

}
