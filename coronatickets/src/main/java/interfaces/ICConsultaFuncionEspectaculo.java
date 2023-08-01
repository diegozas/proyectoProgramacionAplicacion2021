package interfaces;

import java.util.List;

import datatypes.DtFuncion;
import logica.Funcion;

public interface ICConsultaFuncionEspectaculo {
	public List<String> selectPlataforma(String nombre);
	public List<String> selectEspectaculo(String nombreEsp);
	public void elegirEspecatculo(String nombreEsp);
	public DtFuncion selectFuncion(String nombreFuncion);
	public String[] listarPlataforma(); 
}
