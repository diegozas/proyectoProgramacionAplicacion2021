package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import datatypes.DtFuncion;
import fabrica.Fabrica;
import interfaces.ICConsultaFuncionEspectaculo;

public class TestConsultaFuncionEspectaculo {

	@Test
	public void selectPlataformaTest() {
		Fabrica fabrica=Fabrica.getInstancia();
		ICConsultaFuncionEspectaculo icon=fabrica.getICConsultaFuncionEspectaculo();
		List<String> nombresEspectaculosTest=icon.selectPlataforma("Plataforma");
		assertNotNull(nombresEspectaculosTest);
	}
	
	@Test
	public void selectEspectaculoTest() {
		Fabrica fabrica=Fabrica.getInstancia();
		ICConsultaFuncionEspectaculo icon=fabrica.getICConsultaFuncionEspectaculo();
		List<String> nombreFuncionesTest=icon.selectEspectaculo("Espectaculo");
		assertNotNull(nombreFuncionesTest);
	}
	
	
	@Test
	public void selectFuncionTest() {
		Fabrica fabrica=Fabrica.getInstancia();
		ICConsultaFuncionEspectaculo icon=fabrica.getICConsultaFuncionEspectaculo();
		icon.elegirEspecatculo("Espectaculo");
		DtFuncion dtf=icon.selectFuncion("Funcion");
		assertEquals("Funcion",dtf.getNombre());
	}
	
	@Test
	public void listarPlataformaTest() {
		Fabrica fabrica=Fabrica.getInstancia();
		ICConsultaFuncionEspectaculo icon=fabrica.getICConsultaFuncionEspectaculo();
		String[] nombresPlataformaTest=icon.listarPlataforma();
		int x=nombresPlataformaTest.length;
		assertFalse(x==0);	
	}
}
