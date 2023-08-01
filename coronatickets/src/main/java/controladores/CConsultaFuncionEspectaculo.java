package controladores;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtFuncion;
import interfaces.ICConsultaFuncionEspectaculo;
import logica.Espectaculo;
import logica.Funcion;
import logica.Plataforma;
import manejador.ManejadorEspectaculos;
import manejador.ManejadorPlataforma;

public class CConsultaFuncionEspectaculo implements ICConsultaFuncionEspectaculo {
	private String nombreEsp;
	
	@Override
	public List<String> selectPlataforma(String nombre) {
		ManejadorPlataforma mp=ManejadorPlataforma.getInstancia();
		Plataforma p=mp.getPlataforma(nombre);
		List<String> nombres;
		nombres=p.getNombreEspectaculos();
		return nombres;
	}

	@Override
	public List<String> selectEspectaculo(String nombreEsp) {
		ManejadorEspectaculos me=ManejadorEspectaculos.getInstancia();
		Espectaculo e=me.buscarEspectaculo(nombreEsp);
		List<String> nombres=e.getFunciones();
		return nombres;
	}
	
	@Override
	public void elegirEspecatculo(String nombreEsp) {
		this.nombreEsp=nombreEsp;
	}
	
	
	
	
	@Override
	public DtFuncion selectFuncion(String nombreFuncion) {
		ManejadorEspectaculos me=ManejadorEspectaculos.getInstancia();
		Espectaculo e=me.buscarEspectaculo(this.nombreEsp);
		Funcion f=e.getFuncion(nombreFuncion);
		DtFuncion dtf=f.getDtFuncion();
		return dtf;
		
	}

	public String[] listarPlataforma() {
		ArrayList<String> plataformas;
		ManejadorPlataforma mp = ManejadorPlataforma.getInstancia();
		plataformas = mp.obtenerPlataformas();
		String[] plataformas_ret = new String[plataformas.size()];
        int i=0;
        for(String p:plataformas) {
        	plataformas_ret[i]=p;
        	i++;
        }
        return plataformas_ret;
	}
	
	
}
