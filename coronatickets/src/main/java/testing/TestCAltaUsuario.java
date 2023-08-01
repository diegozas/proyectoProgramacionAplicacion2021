package testing;
import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;

import datatypes.DtArtista;
import datatypes.DtEspectador;
import datatypes.DtUsuario;
import excepciones.PasswordIncorrectaExcepcion;
import excepciones.UsuarioRepetidoExcepcion;
import fabrica.Fabrica;
import interfaces.IControladorUsuario;
import logica.Espectador;
import logica.Usuario;
import manejador.ManejadorUsuario;
import persistencia.Conexion;
public class TestCAltaUsuario {
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void altaUsuarioPrueba() throws PasswordIncorrectaExcepcion, UsuarioRepetidoExcepcion{
		Fabrica fabrica=Fabrica.getInstancia();
		IControladorUsuario icon=fabrica.getIControladorUsuario();
		ManejadorUsuario mu=ManejadorUsuario.getInstancia();
		Date fecha=new Date(1994-1900,5,15);
		icon.setPassword("123");
		DtArtista u=new DtArtista("usuarioo","usuarioTest","usuarioTest","usuarioo@test",fecha,"123","test","test","test");
		icon.altaUsuario(u);
		
		Usuario prueba=mu.getUsuario("usuarioo");
		assertEquals("usuarioo",prueba.getNickname());
		
		
	}
	@SuppressWarnings("deprecation")
	@Test
	public void altaUsuarioEspectadorPrueba() throws PasswordIncorrectaExcepcion, UsuarioRepetidoExcepcion{
		Fabrica fabrica=Fabrica.getInstancia();
		IControladorUsuario icon=fabrica.getIControladorUsuario();
		ManejadorUsuario mu=ManejadorUsuario.getInstancia();
		Date fecha=new Date(1994-1900,5,15);
		icon.setPassword("123");
		DtUsuario u=new DtUsuario("usuarioEsp","usuarioTest","usuariTest","usuarioEsp@test",fecha,"123");
		icon.altaUsuario(u);
		Usuario prueba=mu.getUsuario("usuarioEsp");
		assertEquals("usuarioEsp",prueba.getNickname());
		
		
	}

	@SuppressWarnings("deprecation")
	@Test(expected = UsuarioRepetidoExcepcion.class)
	public void excepcionUsuarioRepetido() throws PasswordIncorrectaExcepcion, UsuarioRepetidoExcepcion {
		Fabrica fabrica=Fabrica.getInstancia();
		IControladorUsuario icon=fabrica.getIControladorUsuario();
		ManejadorUsuario mu=ManejadorUsuario.getInstancia();
		Date fecha=new Date(1994-1900,5,15);
		Usuario prueba=new Espectador("usuario","usuarioTest","usuarioTest","usuario@test",fecha,"123");
		mu.agregarUsuario(prueba);
		icon.setPassword("123");
		DtUsuario u1=new DtUsuario("usuario","usuarioTest","usuarioTest","usuario@test",fecha,"123");
		icon.altaUsuario(u1);
		
	}

	@Test(expected = PasswordIncorrectaExcepcion.class)
	public void excepcionPasswordIncorrecta() throws PasswordIncorrectaExcepcion, UsuarioRepetidoExcepcion {
		Fabrica fabrica=Fabrica.getInstancia();
		IControladorUsuario icon=fabrica.getIControladorUsuario();
		Date fecha=new Date(1994-1900,5,15);
		DtUsuario u1=new DtUsuario("usuario","usuarioTest","usuarioTest","usuario@test",fecha,"123");
		icon.setPassword("1");
		icon.altaUsuario(u1);
	}
	
	
}
