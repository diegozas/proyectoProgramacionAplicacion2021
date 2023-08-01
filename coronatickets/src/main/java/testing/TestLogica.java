package testing;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import datatypes.DtArtista;
import datatypes.DtEspectaculo;
import datatypes.DtEspectador;
import datatypes.DtFuncion;
import datatypes.DtUsuario;
import logica.Artista;
import logica.Espectaculo;
import logica.Espectador;
import logica.Funcion;
import logica.Plataforma;
import logica.Usuario;

public class TestLogica {
	
	//Usuario
	@Test
	public void usuarioTest() {
		Artista artista=new Artista();
		Espectador espectador=new Espectador();
		Date fecha=new Date();
		List<Usuario> seguidos=new ArrayList<Usuario>();
		List<Usuario> seguidores=new ArrayList<Usuario>();
	
		artista.setNickname("artista");
		artista.setNombre("artistaTest");
		artista.setApellido("artistaApellido");
		artista.setCorreoElectronico("artista@test");
		artista.setFechaNacimiento(fecha);
		artista.setPassword("123");
		artista.setDescripcionGeneral("no tiene");
		artista.setBiografia("vacio");
		artista.setLinkSitioWeb("artista.com");
		//artista.setSeguidores(seguidores);
		artista.setSeguidos(seguidos);
		artista.setInvitado(true);
		
		
		espectador.setNickname("espectador");
		espectador.setNombre("espectadorTest");
		artista.setApellido("artistaApellido");
		espectador.setCorreoElectronico("espectador@test");
		espectador.setFechaNacimiento(fecha);
		espectador.setPassword("123");
		//artista.setSeguidores(seguidores);
		artista.setSeguidos(seguidos);
		
		
		artista.seguirUsuario(espectador);
		espectador.seguirUsuario(artista);
		
		DtArtista dta=artista.getDtArtista();
		DtArtista dtaSinPass=artista.datosArtista();
		DtArtista dtaSeguidor=artista.datosArtistaSeguidor();
		
		DtUsuario dtu=espectador.getDtUsuario();
		DtUsuario dtuSinPass=espectador.datosUsuario();
		DtUsuario dtuSeguidor=espectador.datosUsuarioSeguidor();
		
		DtEspectador dtesp=new DtEspectador();
		
		String datosUsuario=dta.toString();
		String datosUsuarioBasico=dtaSinPass.toStringBasico();
		String datosUsuarioSeguidor=dtaSeguidor.toStringSeguidores();
		
		Date fechaRet=artista.getFechaNacimiento();
		String apellido=artista.getApellido();
		String nombre=artista.getNombre();
		String link=artista.getLinkSitioWeb();
		String bio=artista.getBiografia();
		String descripcion=artista.getDescripcionGeneral();
		
		
		boolean sigueUsuario=artista.sigueUsuario("espectador");
		
		artista.dejarSeguirUsuario(espectador);
		
		
		
		assertEquals("espectador",espectador.getNickname());
		
	}


	//Espectaculo
	@Test
	public void espectaculoTest() {
		Artista test=new Artista();
		Funcion f=new Funcion();
		/*String nombre;
		int duracion;
		int cantMin;
		int cantMax;
		String url;
		Date fechaRegistro;
		float costo;
		String descripcion;
		*/
		Espectaculo espectaculo=new Espectaculo();
		Date fecha=new Date();
		espectaculo.setNombre("espectaculo");
		espectaculo.setDuracion(60);
		espectaculo.setCantMin(12);
		espectaculo.setCantMax(20);
		espectaculo.setUrl("esp.com");
		espectaculo.setFechaRegistro(fecha);
		espectaculo.setCosto(2200);
		espectaculo.setDescripcion("no tiene");
		espectaculo.setArtista(test);
		espectaculo.agregarFuncion(f);
		
		String[] funciones=espectaculo.listarFunciones();
		
		DtEspectaculo dte=espectaculo.getDtEspectaculo();
		
		int duracion=espectaculo.getDuracion();
		int min=espectaculo.getCantMin();
		int max=espectaculo.getCantMax();
		String url=espectaculo.getUrl();
		Date fechaReg=espectaculo.getFechaRegistro();
		float costo=espectaculo.getCosto();
		String descripcion=espectaculo.getDescripcion();
		
		
		assertEquals("espectaculo",espectaculo.getNombre());
	
	}


	//Funcion
	@Test
	public void funcionTest() {
		Funcion funcion=new Funcion();
		Artista artista=new Artista();
		artista.setNickname("artistaInvitado");
		Date fecha=new Date();
		
		funcion.setNombre("funcion");
		funcion.setFechaInicio(fecha);
		funcion.agregarArtista(artista);
		
		Date fechaFuncion=funcion.getFechaInicio();
		
		DtFuncion dtf=funcion.getDtFuncion();
		List<String> artistasInvitados=funcion.getArtistasInvitados();
		
		
		assertEquals("funcion",funcion.getNombre());
		
	}
	
	//Plataforma
	@Test
	public void testPlataforma() {
		Plataforma plataforma =new Plataforma();
		plataforma.setNombre("plataforma");
		plataforma.setDescripcion("no tiene");
		plataforma.setUrl("plataforma.com");
		Espectaculo esp=new Espectaculo();
		plataforma.agregarEspectaculo(esp);
		String[] espectaculos=plataforma.listarEspectaculos();
		String url=plataforma.getUrl();
		String desc=plataforma.getDescripcion();
		
		
		assertEquals("plataforma",plataforma.getNombre());
		
		
	}
	
	
	
	
}
