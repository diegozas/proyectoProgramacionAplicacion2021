package testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestAltaPlataforma.class, TestCAltaUsuario.class,TestAltaEspectaculo.class,TestAltaFuncion.class,TestConsultaFuncionEspectaculo.class,TestSeguirUsuario.class,TestDejarSeguir.class,TestManejadores.class,TestLogica.class,TestConsultaEspectaculo.class })
public class TestProyecto {
	
}
