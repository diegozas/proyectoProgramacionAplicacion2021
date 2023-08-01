package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Plataforma {
	@Id
	private String nombre;
	
	private String descripcion;
	private String url;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Espectaculo> espectaculos=new ArrayList<>();
	
	public Plataforma() {
		super();
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void agregarEspectaculo(Espectaculo e) {
		espectaculos.add(e);
	}
	
	public List<String> getNombreEspectaculos() {
		List<String> nombreEspectaculos=new ArrayList<String>();
		for(Espectaculo e:espectaculos) {
			nombreEspectaculos.add(e.getNombre());
		}
		return nombreEspectaculos;
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

    public Plataforma(String nombre, String descripcion, String url) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.url = url;
	}
	
}
