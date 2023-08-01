package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import excepciones.PlataformaRepetidaExcepcion;
import fabrica.Fabrica;
import interfaces.IControladorAltaPlataforma;
import logica.Plataforma;
import manejador.ManejadorPlataforma;

public class TestAltaPlataforma {
	
	
	@Test
	public void crearPlataforma() throws PlataformaRepetidaExcepcion {
		Fabrica fabrica=Fabrica.getInstancia();
		IControladorAltaPlataforma icon=fabrica.getIControladorAltaPlataforma();
		ManejadorPlataforma mp=ManejadorPlataforma.getInstancia();
		icon.ingresarDatos("plataforma", "test", "test.com");
		icon.altaPlataforma();
		Plataforma esperado=mp.getPlataforma("plataforma");
		assertEquals("plataforma",esperado.getNombre());
	}

	@Test(expected= PlataformaRepetidaExcepcion.class)
	public void plataformaRepetidaExcepcion() throws PlataformaRepetidaExcepcion {
		Fabrica fabrica=Fabrica.getInstancia();
		IControladorAltaPlataforma icon=fabrica.getIControladorAltaPlataforma();
		ManejadorPlataforma mp=ManejadorPlataforma.getInstancia();
		Plataforma p=new Plataforma("Plataforma","test","test.com");
		mp.agregarPlataforma(p);
		icon.ingresarDatos("Plataforma", "test", "test.com");
		icon.altaPlataforma();
	}



}
