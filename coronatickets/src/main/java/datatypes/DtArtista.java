package datatypes;

import java.util.Date;
import java.util.List;

public class DtArtista extends DtUsuario {
	protected String nickname;
	protected String nombre;
	protected String apellido;
	protected String correoElectronico;
	protected Date fechaNacimiento;
	protected String password;
	private String descripcion;
	private String sitioWeb;
	private String biografia;//recordar que es opcional
	
	

	
	public DtArtista(String nickname, String nombre, String apellido, String correoElectronico, Date fechaNacimiento,
			String pass,String descripcion, String sitioWeb, String biografia) {
		super(nickname,nombre,apellido,correoElectronico,fechaNacimiento,pass);
		this.descripcion = descripcion;
		this.sitioWeb = sitioWeb;
		this.biografia = biografia;
	}
	
	public DtArtista(String nickname, String nombre, String apellido, String correoElectronico, Date fechaNacimiento,
			String descripcion, String sitioWeb, String biografia) {
		super(nickname,nombre,apellido,correoElectronico,fechaNacimiento);
		this.descripcion = descripcion;
		this.sitioWeb = sitioWeb;
		this.biografia = biografia;
	}
	
	
	public DtArtista(String nickname, String nombre, String apellido, String correoElectronico, Date fechaNacimiento,
			List<String> seguidos,List<String> seguidores,String descripcion, String sitioWeb, String biografia) {
		super(nickname,nombre,apellido,correoElectronico,fechaNacimiento,seguidos,seguidores);
		this.descripcion = descripcion;
		this.sitioWeb = sitioWeb;
		this.biografia = biografia;
	}
	
	
	public void setPassword(String pass) {
		this.password=pass;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public String getSitioWeb() {
		return sitioWeb;
	}
	
	public String getBiografia() {
		return biografia;
	}

	
	@SuppressWarnings("null")
	public String toString() {
		String bio="";
		if(bio.isEmpty()) {
			bio="Vacio";
		}else {
			bio=this.biografia;
		}
		return super.toString() +"\nDescripcion: "+ descripcion+ "\nSitio Web: "+sitioWeb+"\nBiografia: " +bio;
	}
	
	
	@SuppressWarnings("null")
	public String toStringSeguidores() {
		String bio="";
		if(bio.isEmpty()) {
			bio="Vacio";
		}else {
			bio=this.biografia;
		}
		return super.toStringSeguidores() +"\nDescripcion: "+ descripcion+ "\nSitio Web: "+sitioWeb+"\nBiografia: " +bio;
		
	}
	
	
}
