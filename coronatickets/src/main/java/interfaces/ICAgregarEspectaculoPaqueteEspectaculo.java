package interfaces;



public interface ICAgregarEspectaculoPaqueteEspectaculo {
	public String[] listarPaquetes();
	public String[] listarPlataforma();
	public String[] listarEspectaculosSinAgregar(String plataforma,String paquete);
	public void agregarEspectaculo(String paquete,String espectaculo);
}
