package interfaces;

import datatypes.DtEspectaculo;
import excepciones.EspectaculoRepetidoExcepcion;

public interface IControladorAltaEspectaculo {
	public void ingresarDatos( DtEspectaculo espectaculo);
	public boolean verificar();
	public void altaEspectaculo() throws EspectaculoRepetidoExcepcion;
	public void cargarDatos();
	
	public String[] listarPlataforma();
	public String[] listarArtistas();
}
