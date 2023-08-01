package interfaces;

import excepciones.PlataformaRepetidaExcepcion;

public interface IControladorAltaPlataforma {
	
	public void ingresarDatos(String nombre, String descripcion, String url);
	
	public boolean verificar();
	
	
	public void altaPlataforma() throws PlataformaRepetidaExcepcion;
	public void cargarDatos();

}