package controladores;

import java.util.List;

import datatypes.DtEspectaculo;
import datatypes.DtPaqueteEspectaculo;
import interfaces.ICConsultaPaqueteEspectaculo;
import logica.PaqueteEspectaculo;
import manejador.ManejadorPaqueteEspectaculo;

public class CConsultaPaqueteEspectaculo implements ICConsultaPaqueteEspectaculo {

	@Override
	public String[] listarPaquetes() {
		ManejadorPaqueteEspectaculo mp=ManejadorPaqueteEspectaculo.getInstancia();
		List<String> nombresPaquetes=mp.getNombresPaquetes();
		String[] nombres_retorno=new String[nombresPaquetes.size()];
		int i=0;
		for(String s:nombresPaquetes) {
			nombres_retorno[i]=s;
			i++;
		}
		return nombres_retorno;
	}

	@Override
	public String[] listarEspectaculos(String paquete) {
		ManejadorPaqueteEspectaculo mp=ManejadorPaqueteEspectaculo.getInstancia();
		PaqueteEspectaculo p=mp.getPaquete(paquete);
		String[] nombreEspectaculos=p.listarEspectaculos();
		return nombreEspectaculos;
	}

	@Override
	public DtPaqueteEspectaculo datosPaquete(String paquete) {
		ManejadorPaqueteEspectaculo mp=ManejadorPaqueteEspectaculo.getInstancia();
		PaqueteEspectaculo p=mp.getPaquete(paquete);
		DtPaqueteEspectaculo dtp=p.getDtPaqueteEspctaculo();
		return dtp;
	}

}
