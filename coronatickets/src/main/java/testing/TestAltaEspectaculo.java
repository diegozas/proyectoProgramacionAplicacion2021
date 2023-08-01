package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.Test;

import datatypes.DtEspectaculo;
import excepciones.EspectaculoRepetidoExcepcion;
import fabrica.Fabrica;
import interfaces.IControladorAltaEspectaculo;
import logica.Espectaculo;
import logica.Plataforma;
import manejador.ManejadorEspectaculos;
import manejador.ManejadorPlataforma;
import persistencia.Conexion;

public class TestAltaEspectaculo {

	@Test
	public void crearEspectaculo() throws EspectaculoRepetidoExcepcion {
		Fabrica fabrica=Fabrica.getInstancia();
		IControladorAltaEspectaculo icon=fabrica.getIControladorAltaEspectaculo();
		ManejadorEspectaculos me=ManejadorEspectaculos.getInstancia();
		Date fecha=new Date();
/*String nombre, String nombreArtista, String plataforma, int duracion, int minEsp, int maxEsp,
				String link, Date fechaAlta, float costo, String desc*/
		DtEspectaculo dte=new DtEspectaculo("Espectaculo","usuarioo","Plataforma",15,10,52,"test.com",fecha,2500,"test");
		icon.ingresarDatos(dte);
		icon.altaEspectaculo();
		Espectaculo esperado=me.buscarEspectaculo("Espectaculo");
		assertEquals("Espectaculo",esperado.getNombre());
	}


	@Test(expected=EspectaculoRepetidoExcepcion.class)
	public void espectaculoRepetidoExcepcionTest() throws EspectaculoRepetidoExcepcion {
		Fabrica fabrica=Fabrica.getInstancia();
		IControladorAltaEspectaculo icon=fabrica.getIControladorAltaEspectaculo();
		Date fecha=new Date();
/*String nombre, String nombreArtista, String plataforma, int duracion, int minEsp, int maxEsp,
				String link, Date fechaAlta, float costo, String desc*/
		DtEspectaculo dte=new DtEspectaculo("Espectaculo","usuarioo","Plataforma",15,10,52,"test.com",fecha,2500,"test");
		icon.ingresarDatos(dte);
		icon.altaEspectaculo();
	}
	
	
	
	@Test
	public void listarArtistaTest() {
		Fabrica fabrica=Fabrica.getInstancia();
		IControladorAltaEspectaculo icon=fabrica.getIControladorAltaEspectaculo();
		String[] nombresArtistasTest=icon.listarArtistas();
		int x=nombresArtistasTest.length;
		assertFalse(x==0);	
	}
	
	@Test
	public void listarPlataformaTest() {
		Fabrica fabrica=Fabrica.getInstancia();
		IControladorAltaEspectaculo icon=fabrica.getIControladorAltaEspectaculo();
		String[] nombresPlataformaTest=icon.listarPlataforma();
		int x=nombresPlataformaTest.length;
		assertFalse(x==0);	
	}
}
