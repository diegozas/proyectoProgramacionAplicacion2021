package datatypes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DtPaqueteEspectaculo {
	private String nombre;
	private String descripcion;
	private float descuento;
	private Date fechaInicio;
	private Date fechaFin;
	
	public DtPaqueteEspectaculo(){
		super();
	}
	
	public DtPaqueteEspectaculo(String nombre, String descripcion, float descuento, Date fechaInicio, Date fechaFin) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.descuento = descuento;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public float getDescuento() {
		return descuento;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}


	public String toString() {
		SimpleDateFormat fecha=new SimpleDateFormat("dd/MM/yyyy");
		String fechaIni= fecha.format(fechaInicio);
		String fechaF=fecha.format(fechaFin);

		return "Nombre: "+ nombre+"\nDescripcion: "+ descripcion+"\nDescuento "+descuento+"%"+"\nFecha Inicio: "+ fechaIni+"\nFecha Fin: "+fechaF; 
}


}
