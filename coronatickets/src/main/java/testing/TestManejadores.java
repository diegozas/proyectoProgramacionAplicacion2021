package testing;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import logica.Plataforma;
import manejador.ManejadorEspectaculos;
import manejador.ManejadorPlataforma;
import manejador.ManejadorUsuario;

public class TestManejadores {
	
	//Manejeador Plataforma
	@Test
	public void getColeccionPlataformasTest() {
		ManejadorPlataforma mp=ManejadorPlataforma.getInstancia();
		List<Plataforma> plataformas=mp.getColeccionPlataformas();
		assertNotNull(plataformas);
	}
	
	//Manejador Espectaculo
	@Test
	public void getEspectaculosArtistaTest() {
		ManejadorEspectaculos me=ManejadorEspectaculos.getInstancia();
		ArrayList<String> nombreEspArtista=me.getEspectaculosArtista("usuarioo");
		assertNotNull(nombreEspArtista);
	}
	@Test
	public void obtenerEspectaculosTest() {
		ManejadorEspectaculos me=ManejadorEspectaculos.getInstancia();
		List<String> nombresEsp=me.obtenerEspectaculos();
		assertNotNull(nombresEsp);
	}
	
	//Manejador Usuario
	@Test
	public void existeUsuarioPasswordTest() {
		ManejadorUsuario mu=ManejadorUsuario.getInstancia();
		assertTrue(mu.existeUsuarioPassword("usuario", "123"));
	}
	
	
	
	
	
	
}
