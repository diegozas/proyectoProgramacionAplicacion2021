package testing;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import fabrica.Fabrica;
import interfaces.ICSeguirUsuario;
import logica.Usuario;
import manejador.ManejadorUsuario;

public class TestSeguirUsuario {
	@Test
	public void sinSeguirTest() {
		Fabrica fabrica=Fabrica.getInstancia();
		ICSeguirUsuario icon=fabrica.getICSeguirUsuario();
		List<String> sinSeguirTest=icon.sinSeguir("usuario");
		assertNotNull(sinSeguirTest);
	}
	
	@Test
	public void seguirUsuarioTest() {
		Fabrica fabrica=Fabrica.getInstancia();
		ICSeguirUsuario icon=fabrica.getICSeguirUsuario();
		ManejadorUsuario mu=ManejadorUsuario.getInstancia();
		//Usuario usuarioSeguir= mu.getUsuario("usuarioEsp");
		icon.seguirUsuario("usuarioEsp", "usuario");
		Usuario test= mu.getUsuario("usuario");
		List<Usuario> seguidos=test.getSeguidos();
		assertNotNull(seguidos);
	}
	
	
	
	
}
