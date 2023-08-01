package controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import datatypes.DtFuncion;
import excepciones.FuncionRepetidaExcepcion;
import interfaces.ICAltaFuncionEspectaculo;
import logica.Artista;
import logica.Espectaculo;
import logica.Funcion;
import logica.Plataforma;
import logica.Usuario;
import manejador.ManejadorEspectaculos;
import manejador.ManejadorPlataforma;
import manejador.ManejadorUsuario;
import persistencia.Conexion;
public class CAltaFuncionEspectaculo implements ICAltaFuncionEspectaculo {
	private String nombreEspecatculo;
	private DtFuncion funcion;
	
	
	@Override
	public List<String> selectPlataforma(String nombre) {
		ManejadorPlataforma mp=ManejadorPlataforma.getInstancia();
		Plataforma p=mp.getPlataforma(nombre);
		List<String> nombres;
		nombres=p.getNombreEspectaculos();
		return nombres;
	}

	@Override
	public void selectEspectauclo(String nombreEsp) {
		this.nombreEspecatculo=nombreEsp;

	}

	public void ingresarDatos(DtFuncion funcion) {
		this.funcion=funcion;

	}

	@Override
	public boolean verificar() {
		ManejadorEspectaculos me=ManejadorEspectaculos.getInstancia();
		boolean existe=false;
		//Espectaculo e=me.buscarEspectaculo(this.nombreEspecatculo);
		if(me.existeFuncion(funcion.getNombre())){
			existe=true;
		}
		return existe;	
	}


	@Override
	public void altaFuncion() throws FuncionRepetidaExcepcion{
		ManejadorEspectaculos me=ManejadorEspectaculos.getInstancia();
		ManejadorUsuario mu= ManejadorUsuario.getInstancia();
		Espectaculo e=me.buscarEspectaculo(this.nombreEspecatculo);
		if(verificar()) {
			throw new FuncionRepetidaExcepcion("Ya existe una Funcion con ese nombre");
		}
		
		Funcion f=new Funcion (funcion.getNombre(),funcion.getFechaAlta()/*,funcion.getArtistas()*/);
		for(String s:funcion.getArtistas()) {
			Artista a=mu.buscarArtista(s);
			a.setInvitado(true);	
			f.agregarArtista(a);
		}
		e.agregarFuncion(f);
		//f.setEspectaculo(e);
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
	
		em.getTransaction().begin();
		//em.persist(f);
		em.persist(e);
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

	@Override
	public void cargarDatos() {
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		ManejadorEspectaculos me=ManejadorEspectaculos.getInstancia();
		Date fecha=new Date(2021-1900,12-1,10);
		Funcion f=new Funcion ("funcion1",fecha);
		Funcion f1=new Funcion ("funcion2",fecha);
		Espectaculo e=me.buscarEspectaculo("Espectaculo 1");
		Artista a=mu.buscarArtista("prueba");
		f.agregarArtista(a);
		e.agregarFuncion(f);
		e.agregarFuncion(f1);
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
	
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
	}

}
