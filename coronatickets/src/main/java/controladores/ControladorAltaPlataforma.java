package controladores;


import excepciones.PlataformaRepetidaExcepcion;
import interfaces.IControladorAltaPlataforma;
import logica.Plataforma;
import manejador.ManejadorPlataforma;

public class ControladorAltaPlataforma implements IControladorAltaPlataforma {
	
	private String nombre;
	private String descripcion;
	private String url;
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public void ingresarDatos(String nombre, String descripcion, String url) {
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
		this.setUrl(url);
	}
	
	@Override
	public boolean verificar() {
		ManejadorPlataforma mp=ManejadorPlataforma.getInstancia();
		return mp.existePlataforma(this.nombre);
	}
	
	@Override
	public void altaPlataforma() throws PlataformaRepetidaExcepcion {
		if (this.verificar())
			throw new PlataformaRepetidaExcepcion("Plataforma ya existe. Se debe Modificar el nombre");
		else {
			Plataforma nuevaPlataforma = new Plataforma(this.nombre,this.descripcion,this.url);
			/*nuevaPlataforma.setNombre(this.nombre);
			nuevaPlataforma.setDescripcion(this.descripcion);
			nuevaPlataforma.setUrl(this.url);*/ 
			ManejadorPlataforma mp=ManejadorPlataforma.getInstancia();
			mp.agregarPlataforma(nuevaPlataforma);
		}
	}
	
	@Override
	public void cargarDatos() {
		ManejadorPlataforma mp=ManejadorPlataforma.getInstancia();
		Plataforma p1=new Plataforma("Plataforma 1","prueba","hola");
		Plataforma p2=new Plataforma("Plataforma 2","algo","holaa");
		Plataforma p3=new Plataforma("Plataforma 3","nose","holaa");
		
		mp.agregarPlataforma(p1);
		mp.agregarPlataforma(p2);
		mp.agregarPlataforma(p3);
	
	
	}
	
}