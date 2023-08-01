package datatypes;

import java.util.Date;

public class DtEspectaculo {
	private String nombre;
	private String nombreArtista;
	private String plataforma;
	private int duracion;
	private int minEsp;
	private int maxEsp;
	private String link;
	private Date fechaAlta;
	private float costo;
	private String desc;
	
	
	public DtEspectaculo() {
		super();
		
	}
	
	public DtEspectaculo(String nombre, String nombreArtista, String plataforma, int duracion, int minEsp, int maxEsp,
			String link, Date fechaAlta, float costo, String desc) {
		super();
		this.nombre = nombre;
		this.nombreArtista = nombreArtista;
		this.plataforma = plataforma;
		this.duracion = duracion;
		this.minEsp = minEsp;
		this.maxEsp = maxEsp;
		this.link = link;
		this.fechaAlta = fechaAlta;
		this.costo = costo;
		this.desc = desc;
	}
	
	
	public DtEspectaculo(String nombre, String nombreArtista,int duracion, int minEsp, int maxEsp,
			String link, Date fechaAlta, float costo, String desc) {
		super();
		this.nombre = nombre;
		this.nombreArtista = nombreArtista;
		this.duracion = duracion;
		this.minEsp = minEsp;
		this.maxEsp = maxEsp;
		this.link = link;
		this.fechaAlta = fechaAlta;
		this.costo = costo;
		this.desc = desc;
	}
	


	public String getNombre() {
		return nombre;
	}


	public String getNombreArtista() {
		return nombreArtista;
	}


	public String getPlataforma() {
		return plataforma;
	}


	public int getDuracion() {
		return duracion;
	}


	public int getMinEsp() {
		return minEsp;
	}


	public int getMaxEsp() {
		return maxEsp;
	}


	public String getLink() {
		return link;
	}


	public Date getFechaAlta() {
		return fechaAlta;
	}


	public float getCosto() {
		return costo;
	}


	public String getDesc() {
		return desc;
	}
	
	

	public String toString() {
		return "Nombre: "+ nombre+"\nArtista: "+ nombreArtista+"\nDuracion: "+ duracion+" minutos"+ 
		"\nMinimo Espectadores: "+ minEsp+ "\nMaximo Espectadores: "+ maxEsp+ "\nLink: "+ link+
		"\nCosto: "+costo+"$"+"\nDescpripcion: "+desc;
		
	}


}
