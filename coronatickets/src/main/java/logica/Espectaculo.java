package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import datatypes.DtEspectaculo;

@Entity
public class Espectaculo {
	@Id
	private String nombre;
	
	private int duracion;
	private int cantMin;
	private int cantMax;
	private String url;
	private Date fechaRegistro;
	private float costo;
	private String descripcion;
	
	@OneToOne
	private Artista artista;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Funcion> funciones=new ArrayList<>();
	
	/*
	@OneToMany(mappedBy = "espectaculo",cascade = CascadeType.ALL)
	private List<Funcion> funciones=new ArrayList<>();
	@ManyToOne
	private Plataforma plataforma;
	
	*/
	
	public Espectaculo() {}
	
	
	/*public void setPlataforma(Plataforma p) {
		this.plataforma=p;
	}
	*/
	
	
	public Espectaculo(String nombre, int duracion, int cantMin, int cantMax, String url, Date fechaRegistro, float costo,
			String descripcion,Artista artista) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
		this.cantMin = cantMin;
		this.cantMax = cantMax;
		this.url = url;
		this.fechaRegistro = fechaRegistro;
		this.costo = costo;
		this.descripcion = descripcion;
		this.artista=artista;
	}
	
	public Artista getArtista() {
		return artista;
	}
	
	public void setArtista(Artista artista) {
		this.artista=artista;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public int getCantMin() {
		return cantMin;
	}
	public void setCantMin(int cantMin) {
		this.cantMin = cantMin;
	}
	public int getCantMax() {
		return cantMax;
	}
	public void setCantMax(int cantMax) {
		this.cantMax = cantMax;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public float getCosto() {
		return costo;
	}
	public void setCosto(float costo) {
		this.costo = costo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	
	
	
	
	
	public Funcion getFuncion(String nombre) {
		Funcion aretornar=null;
		for(Funcion f:funciones) {
			if(f.getNombre().equals(nombre))
				aretornar=f;
		}
		return aretornar;
	}
	
	
	public void agregarFuncion(Funcion f) {
		this.funciones.add(f);
	}
	
	public boolean existeFuncion(String nombre) {
		boolean existe=false;
		for(Funcion f:funciones) {
			if(f.getNombre().equals(nombre))
				existe=true;
		}
		return existe;
	}
	
	public List<String> getFunciones() {
		List<String> funcionesNombres=new ArrayList<>();
		for(Funcion f:funciones) {
			funcionesNombres.add(f.getNombre());
		}
		return funcionesNombres;
	}
	
	public DtEspectaculo getDtEspectaculo() {
		DtEspectaculo dte=new DtEspectaculo(nombre,artista.getNickname(),duracion,cantMin,cantMax,url,fechaRegistro,costo,descripcion);
		return dte;
	}
	
	
	public String[] listarFunciones() {
		List<String> funcionesNombres=new ArrayList<>();
		for(Funcion f:funciones) {
			funcionesNombres.add(f.getNombre());
		}
		String[] funciones_ret = new String[funciones.size()];
        int i=0;
        for(String funcion:funcionesNombres) {
        	funciones_ret[i]=funcion;
        	i++;
        }
        return funciones_ret;
	}
	
	
	
	
	
}
