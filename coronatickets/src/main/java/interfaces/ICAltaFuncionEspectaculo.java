package interfaces;

import java.util.List;

import datatypes.DtFuncion;
import excepciones.FuncionRepetidaExcepcion;

public interface ICAltaFuncionEspectaculo {
	public List<String> selectPlataforma(String nombre);
	public void selectEspectauclo(String nombreEsp);
	public void ingresarDatos(DtFuncion funcion);
	public boolean verificar(); 
	public void altaFuncion() throws FuncionRepetidaExcepcion;
	public void cargarDatos();
	public String[] listarPlataforma();
	public String[] listarArtistas();

}
