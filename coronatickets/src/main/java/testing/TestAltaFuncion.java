package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import datatypes.DtFuncion;
import excepciones.FuncionRepetidaExcepcion;
import fabrica.Fabrica;
import interfaces.ICAltaFuncionEspectaculo;
import interfaces.IControladorAltaEspectaculo;
import logica.Espectaculo;
import logica.Funcion;
import manejador.ManejadorEspectaculos;

public class TestAltaFuncion {
	
	@Test
	public void altaFuncionTest() throws FuncionRepetidaExcepcion {
		Fabrica fabrica=Fabrica.getInstancia();
		ICAltaFuncionEspectaculo icon=fabrica.getICAltaFuncionEspectaculo();
		ManejadorEspectaculos me=ManejadorEspectaculos.getInstancia();
		icon.selectEspectauclo("Espectaculo");
		List<String> nombres=new ArrayList<String>();
		Date fecha=new Date(2022-1900,1-0,20,15,00);
		DtFuncion dtf=new DtFuncion("Funcion",fecha,nombres);
		icon.ingresarDatos(dtf);
		icon.altaFuncion();
		Espectaculo e=me.buscarEspectaculo("Espectaculo");
		Funcion f=e.getFuncion("Funcion");
		
		assertEquals("Funcion",f.getNombre());
	}
	
	@Test(expected=FuncionRepetidaExcepcion.class)
	public void funcionRepetidaExcepcionTest() throws FuncionRepetidaExcepcion {
		Fabrica fabrica=Fabrica.getInstancia();
		ICAltaFuncionEspectaculo icon=fabrica.getICAltaFuncionEspectaculo();
		icon.selectEspectauclo("Espectaculo");
		List<String> nombres=new ArrayList<String>();
		Date fecha=new Date(2022-1900,1-0,20,15,00);
		DtFuncion dtf=new DtFuncion("Funcion",fecha,nombres);
		icon.ingresarDatos(dtf);
		icon.altaFuncion();
	}
	
	@Test
	public void listarArtistaTest() {
		Fabrica fabrica=Fabrica.getInstancia();
		ICAltaFuncionEspectaculo icon=fabrica.getICAltaFuncionEspectaculo();
		String[] nombresArtistasTest=icon.listarArtistas();
		int x=nombresArtistasTest.length;
		assertFalse(x==0);	
	}
	
	@Test
	public void listarPlataformaTest() {
		Fabrica fabrica=Fabrica.getInstancia();
		ICAltaFuncionEspectaculo icon=fabrica.getICAltaFuncionEspectaculo();
		String[] nombresPlataformaTest=icon.listarPlataforma();
		int x=nombresPlataformaTest.length;
		assertFalse(x==0);	
	}
	
	
	
	@Test
	public void selectPlataformaTest() {
		Fabrica fabrica=Fabrica.getInstancia();
		ICAltaFuncionEspectaculo icon=fabrica.getICAltaFuncionEspectaculo();
		List<String> nombresEspTest=icon.selectPlataforma("Plataforma");
		assertNotNull(nombresEspTest);
	}
	
	
	
}
