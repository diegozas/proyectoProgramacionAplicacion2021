package testing;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fabrica.Fabrica;
import interfaces.ICDejarDeSeguirUsuario;
import logica.Usuario;
import manejador.ManejadorUsuario;

public class TestDejarSeguir {
	@Test
	public void seguidoresTest() {
		Fabrica fabrica=Fabrica.getInstancia();
		ICDejarDeSeguirUsuario icon=fabrica.getICDejarDeSeguirUsuario();
		ArrayList<String> nickSeguidores=icon.seguidores("usuario");
		assertNotNull(nickSeguidores);
	}
	
	@Test
	public void dejarSeguirUsuarioTest() {
		Fabrica fabrica=Fabrica.getInstancia();
		ICDejarDeSeguirUsuario icon=fabrica.getICDejarDeSeguirUsuario();
		ManejadorUsuario mu=ManejadorUsuario.getInstancia();
		
		//Usuario usuarioDejarSeguir= mu.getUsuario("usuarioEsp");
		icon.dejarSeguirUsuario("usuarioEsp", "usuario");
		
		Usuario test= mu.getUsuario("usuario");
		List<Usuario> seguidos=test.getSeguidos();
		assertNotNull(seguidos);
	}
	
	
	
	
}
