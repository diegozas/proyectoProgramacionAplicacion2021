package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import datatypes.DtPaqueteEspectaculo;

@Entity
public class PaqueteEspectaculo {
	@Id
	private String nombre;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Espectaculo> espectaculos=new ArrayList<>();
	
	private String descripcion;
	private float descuento;
	private Date fechaAlta;
	private Date fechaInicio;
	private Date fechaFin;
	
	
	
	public PaqueteEspectaculo() {
		super();
	}
	
	public PaqueteEspectaculo(String nombre, String descripcion, float descuento, Date fechaAlta, Date fechaInicio,
			Date fechaFin) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.descuento = descuento;
		this.fechaAlta = fechaAlta;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getDescuento() {
		return descuento;
	}
	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	} 
	

	public DtPaqueteEspectaculo getDtPaqueteEspctaculo() {
		DtPaqueteEspectaculo dte = new DtPaqueteEspectaculo(nombre,descripcion,descuento,fechaInicio,fechaFin);
		return dte;
	}




	public void agregarEspectaculo(Espectaculo e) {
		this.espectaculos.add(e);
	}

	public String[] listarEspectaculos() {
		ArrayList<String> nombres=new ArrayList<>();
		for (Espectaculo e:espectaculos) {
			nombres.add(e.getNombre());
		}
		String[] espectaculos_ret = new String[nombres.size()];
        int i=0;
        for(String e:nombres) {
        	espectaculos_ret[i]=e;
        	i++;
        }
        return espectaculos_ret;	
	
	}

	public boolean existeEspectaculo(String esp) {
		boolean existe=false;
		for(Espectaculo e:espectaculos) {
			if(esp.equals(e.getNombre())) {
				existe=true;
			}
		}
		return existe;
	}

}
