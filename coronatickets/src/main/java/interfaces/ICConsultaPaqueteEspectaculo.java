package interfaces;

import datatypes.DtPaqueteEspectaculo;

public interface ICConsultaPaqueteEspectaculo {
	public String[] listarPaquetes();
	public String[] listarEspectaculos(String paquete);
	public DtPaqueteEspectaculo datosPaquete(String paquete);
}
