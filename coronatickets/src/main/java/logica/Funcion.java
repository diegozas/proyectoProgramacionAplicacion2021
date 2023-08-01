package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import datatypes.DtFuncion;

@Entity
public class Funcion {
	@Id
	private String nombre;
	private Date fechaInicio;
	private boolean canjeado=false;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Artista> artistasInvitados = new ArrayList<>();
	
	
	/*@ManyToOne
	private Espectaculo espectaculo;
	
	*/
	
	public Funcion() {
		super();
	}
	
	public Funcion(String nombre, Date fechaInicio) {
		super();
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
	}

	
	/*public void setEspectaculo(Espectaculo e) {
		this.espectaculo=e;
	}
	*/
	
	
	
	
	
	
	public String getNombre() {
		return nombre;
	}
	
	
	public boolean isCanjeado() {
		return canjeado;
	}

	public void setCanjeado(boolean canjeado) {
		this.canjeado = canjeado;
	}

	public void agregarArtista(Artista a) {
		this.artistasInvitados.add(a);
	}
	
	
	public DtFuncion getDtFuncion() {
		List<String> nombres=new ArrayList<>();
		for(Artista a:artistasInvitados) {
			nombres.add(a.getNickname());
		}
		
		DtFuncion dt=new DtFuncion(this.nombre,this.fechaInicio,nombres);
		return dt;
					
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	
	
	public List<String> getArtistasInvitados() {
		List<String> nombres=new ArrayList<>();
		for(Artista a:artistasInvitados) {
			nombres.add(a.getNickname());
		}
		return nombres;
	}


}
