package controladores;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;

import datatypes.DtEspectaculo;
import excepciones.EspectaculoRepetidoExcepcion;
import interfaces.IControladorAltaEspectaculo;
import logica.Artista;
import logica.Espectaculo;
import logica.Plataforma;
import manejador.ManejadorEspectaculos;
import manejador.ManejadorPlataforma;
import manejador.ManejadorUsuario;
import persistencia.Conexion;



public class ControladorAltaEspectaculo implements IControladorAltaEspectaculo {
	private String nombre;
	private String artista;
	private String plataforma;
	private int duracion;
	private int minEspectadores;
	private int maxEspectadores;
	private String link;
	private Date fechaAlta;
	private float costo;
	private String descripcion;
	
	@Override
	public void ingresarDatos(DtEspectaculo espectaculo) {
		this.nombre=espectaculo.getNombre();
		this.artista=espectaculo.getNombreArtista();
		this.plataforma=espectaculo.getPlataforma();
		this.duracion=espectaculo.getDuracion();
		this.minEspectadores=espectaculo.getMinEsp();
		this.maxEspectadores=espectaculo.getMaxEsp();
		this.link=espectaculo.getLink();
		this.fechaAlta=espectaculo.getFechaAlta();
		this.costo=espectaculo.getCosto();
		this.descripcion=espectaculo.getDesc();
	}

	@Override
	public boolean verificar() {
		ManejadorEspectaculos me=ManejadorEspectaculos.getInstancia();
		return me.existeEspectaculo(this.nombre);		
	}

	@Override
	public void altaEspectaculo() throws EspectaculoRepetidoExcepcion  {
		ManejadorEspectaculos me=ManejadorEspectaculos.getInstancia();
		ManejadorUsuario mu=ManejadorUsuario.getInstancia();
		if(verificar()) {
			throw new EspectaculoRepetidoExcepcion("Ya existe un espectaculo con ese nombre!");
		}
		Artista a=mu.buscarArtista(this.artista);
		Espectaculo esp=new Espectaculo(this.nombre,this.duracion,this.minEspectadores,this.maxEspectadores,this.link, this.fechaAlta, this.costo,
				this.descripcion,a);
		me.agregarEspectaculo(esp);		
		ManejadorPlataforma mp=ManejadorPlataforma.getInstancia();
		Plataforma p=mp.getPlataforma(this.plataforma);
		p.agregarEspectaculo(esp);
	
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	
	}
	
	
	
	
	@Override
	public void cargarDatos() {
		ManejadorPlataforma mp=ManejadorPlataforma.getInstancia();
		ManejadorEspectaculos me=ManejadorEspectaculos.getInstancia();
		ManejadorUsuario mu=ManejadorUsuario.getInstancia();
		Plataforma p1=mp.getPlataforma("Plataforma 1");
		Plataforma p2=mp.getPlataforma("Plataforma 2");
		Artista a=mu.buscarArtista("dZas");
		Date fecha=new Date();
		float x=250;
		Espectaculo e1=new Espectaculo("Espectaculo 1",20,35,50,"no hay",fecha,x,"tampoco",a);
		Espectaculo e2=new Espectaculo("Espectaculo 2",100,20,50,"no existe",fecha,x,"prueba",a);
		Espectaculo e3=new Espectaculo("Espectaculo 3",200,5,50,"no",fecha,x,"algo",a);
	
		me.agregarEspectaculo(e1);
		me.agregarEspectaculo(e2);
		me.agregarEspectaculo(e3);
		
		p1.agregarEspectaculo(e1);
		p1.agregarEspectaculo(e2);
		//p1.agregarEspectaculo(e3);
		
		p2.agregarEspectaculo(e3);
		
		/*e1.setPlataforma(p1);
		e2.setPlataforma(p1);
		e3.setPlataforma(p1);
		*/
		//e3.setPlataforma(p2);
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.getTransaction().commit();
			
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
	public String[] listarArtistas() {
		ArrayList<String> artistas;
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		artistas = mu.arrayNombArtista();
		String[] artistas_ret = new String[artistas.size()];
        int i=0;
        for(String a:artistas) {
        	artistas_ret[i]=a;
        	i++;
        }
        return artistas_ret;
	}
	
	

}
