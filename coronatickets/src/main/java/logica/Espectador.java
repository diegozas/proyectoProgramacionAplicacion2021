package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("E")
public class Espectador extends Usuario {
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Funcion> registroFuncion = new ArrayList<>();

	public Espectador() {
		super();
	}
	
	public Espectador (String nickname, String nombre, String apellido, String correoElectronico, Date fechaNacimiento,String password) {
		super(nickname,nombre,apellido,correoElectronico,fechaNacimiento,password);
	}

	public List<Funcion> getRegistroFuncio() {
		return registroFuncion;
	}

	public void setRegistroFuncio(List<Funcion> registroFuncio) {
		this.registroFuncion = registroFuncio;
	}

	public boolean getEstaRegistrado(String funcion) {
		boolean existe=false;
		for(Funcion f:registroFuncion) {
			if(f.getNombre().equals(funcion));
			existe=true;
		}
		return existe;
	}


	public String[] getFuncionesSinCanjear() {
		String[] funciones=new String[registroFuncion.size()];
		int i=0;
		for(Funcion f:registroFuncion) {
			if(!f.isCanjeado()) {
				funciones[i]=f.getNombre();
				i++;
			}
		}	
		return funciones;
	}
	
	
	public String[] getFunciones() {
		String[] funciones=new String[registroFuncion.size()];
		int i=0;
		for(Funcion f:registroFuncion) {
			funciones[i]=f.getNombre();
			i++;
		}	
		return funciones;
	}
	
	
	
	
	public Funcion getFuncion(String funcion) {
		Funcion retorno = null;
		for(Funcion f:registroFuncion) {
			if(f.getNombre().equals(funcion)){
				retorno=f;
			}
		}
		return retorno;
	
	}
	
	public void agregarFuncion(Funcion f) {
		this.registroFuncion.add(f);
	}
	
}
