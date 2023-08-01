package controladores;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtEspectaculoFull;
import interfaces.IControladorConsultaEspectaculo;
import manejador.ManejadorEspectaculos;
import manejador.ManejadorPlataforma;

public class ControladorConsultaEspectaculo implements IControladorConsultaEspectaculo {
	private List<String> funciones= new ArrayList<>();
	@Override
	public List<String> seleccionarPlataforma(String plataforma) {
		List<String> plataformas=new ArrayList<String>();
		
		return plataformas;
	}

	@Override
	public DtEspectaculoFull selectEspectaculo(String espectaculo) {
		ManejadorEspectaculos me=ManejadorEspectaculos.getInstancia();
		DtEspectaculoFull retorno=new DtEspectaculoFull();
		return retorno;
	}

	@Override
	public void selectFuncion(String funcion) {
		// TODO Auto-generated method stub

	}

	@Override
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
