package interfaces;

import excepciones.ExisteRegistroExcepcion;

public interface ICRegistroFuncion {
	public String[] listarPlataformas();
	public String[] listarEspectadores();
	public String[] espectaculosPlataforma(String plataforma);
	public String[] funcionesEspectaculo(String espectaculo);
	public void registroFuncion(String usuario,String espectaculo,String funcion) throws ExisteRegistroExcepcion;
}
