package datatypes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DtEspectaculoFull {
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
	private List<String> funciones= new ArrayList<>();
	
	
	
	public DtEspectaculoFull(String nombre, String nombreArtista, String plataforma, int duracion, int minEsp,
			int maxEsp, String link, Date fechaAlta, float costo, String desc, List<String> funciones) {
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
		this.funciones = funciones;
	}

	public DtEspectaculoFull() {
		super();
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

	public List<String> getFunciones() {
		return funciones;
	}













}
