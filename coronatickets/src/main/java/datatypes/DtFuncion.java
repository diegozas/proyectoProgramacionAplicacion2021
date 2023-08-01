package datatypes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DtFuncion {
	private String nombre;
	private List<String> artistas= new ArrayList<>();
	private Date fechaAlta;
	
	public DtFuncion() {
		super();
	}

	public DtFuncion(String nombre, Date fechaAlta,List<String> artistas){
		super();
		this.nombre = nombre;
		this.fechaAlta = fechaAlta;
		this.artistas = artistas;
		
	}

	public String getNombre() {
		return nombre;
	}

	public List<String> getArtistas() {
		return this.artistas;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setArtistas(List<String> artistas) {
		this.artistas = artistas;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	@Override
	public String toString() {
		SimpleDateFormat fecha=new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat hora=new SimpleDateFormat("hh:mm");
		String fecha1= fecha.format(fechaAlta);
		String hora1 = hora.format(fechaAlta);
		String nombres="Artistas Invitados";
		if(this.artistas.isEmpty()) {
			nombres="No hay Artistas invitados";
		}else {
			for(String s:this.artistas) {
				nombres=nombres + "\n"+ s;
			}
		}
		return "Nombre: " + nombre + "\nFecha: " + fecha1 + "\nHora: " + hora1 +"\n\n"+ nombres;
	}

}
