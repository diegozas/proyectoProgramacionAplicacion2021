package testing;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import datatypes.DtEspectaculoFull;
import fabrica.Fabrica;
import interfaces.IControladorConsultaEspectaculo;

public class TestConsultaEspectaculo {

	@Test
	public void test() {
		Fabrica fabrica=Fabrica.getInstancia();
		IControladorConsultaEspectaculo icon=fabrica.getIControladorConsultaEspectaculo();
		List<String> plataformas=icon.seleccionarPlataforma("plataforma");
		DtEspectaculoFull dteFull=icon.selectEspectaculo("esp");
		icon.selectFuncion("funcion");
		String[] plataformass=icon.listarPlataforma();
		int x= plataformass.length;
		assertTrue(x!=0);
	}
	
	
	
	
	
	
	
}
