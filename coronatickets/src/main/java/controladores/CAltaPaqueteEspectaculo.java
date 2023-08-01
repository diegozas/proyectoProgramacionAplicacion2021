package controladores;

import java.util.Date;

import datatypes.DtPaqueteEspectaculo;
import excepciones.EspectaculoRepetidoExcepcion;
import excepciones.PaqueteEspectaculoRepetidoExcepcion;
import interfaces.ICAaltaPaqueteEspectaculo;
import logica.PaqueteEspectaculo;
import manejador.ManejadorPaqueteEspectaculo;

public class CAltaPaqueteEspectaculo implements ICAaltaPaqueteEspectaculo {
	private DtPaqueteEspectaculo dte;
	private Date fechaAlta;
	
	@Override
	public void ingresarDatos(DtPaqueteEspectaculo dt, Date fechaAlta) {
		this.dte=dt;
		this.fechaAlta=fechaAlta;

	}
	
	
	@Override
	public void altaPaqueteEspectaculo() throws PaqueteEspectaculoRepetidoExcepcion {
		ManejadorPaqueteEspectaculo mp=ManejadorPaqueteEspectaculo.getInstancia();
		if(mp.existePaquete(dte.getNombre())) {
			throw new PaqueteEspectaculoRepetidoExcepcion("Ya existe un paquete de espectaculo con ese nombre!");
		}else {
			PaqueteEspectaculo p=new PaqueteEspectaculo(dte.getNombre(),dte.getDescripcion(),dte.getDescuento(),fechaAlta,dte.getFechaInicio(),dte.getFechaFin());
			mp.agregarPaqueteEspectaculo(p);
		}
	
	}

}
