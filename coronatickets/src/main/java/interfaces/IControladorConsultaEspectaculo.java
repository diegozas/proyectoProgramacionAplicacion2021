package interfaces;

import java.util.List;

import datatypes.DtEspectaculoFull;

public interface IControladorConsultaEspectaculo {
	public List<String> seleccionarPlataforma(String plataforma);
	public DtEspectaculoFull selectEspectaculo(String espectaculo);
	public void selectFuncion(String funcion);
	public String[] listarPlataforma();
}
