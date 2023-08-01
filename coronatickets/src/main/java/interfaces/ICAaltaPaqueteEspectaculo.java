package interfaces;
import java.util.Date;
import datatypes.DtEspectaculo;
import datatypes.DtPaqueteEspectaculo;
import excepciones.EspectaculoRepetidoExcepcion;
import excepciones.PaqueteEspectaculoRepetidoExcepcion;

public interface ICAaltaPaqueteEspectaculo {
	public void ingresarDatos(DtPaqueteEspectaculo dt,Date fechaAlta);
	public void altaPaqueteEspectaculo() throws PaqueteEspectaculoRepetidoExcepcion;
}
