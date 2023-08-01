package datatypes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DtUsuario {
	private String nickname;
	private String nombre;
	private String apellido;
	private String email;
	private Date fnac;
	private List<String> seguidos=new ArrayList<String>();
	private List<String> seguidores=new ArrayList<String>();
	private String pass;
	
	public DtUsuario() {
		super();
	}

	public DtUsuario(String nickname, String nombre, String apellido, String email, Date fnac) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fnac = fnac;
	}
	
	public DtUsuario(String nickname, String nombre, String apellido, String email, Date fnac,List<String> seguidos,List<String> seguidores) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fnac = fnac;
		this.seguidos=seguidos;
		this.seguidores=seguidores;
		
	}
	
	
	
	
	
	
	public DtUsuario(String nickname, String nombre, String apellido, String email, Date fnac,String pass) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fnac = fnac;
		this.pass=pass;
	}

	public String getNickname() {
		return nickname;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getEmail() {
		return email;
	}

	public Date getFnac() {
		return fnac;
	}
	
	public String getPass() {
		return pass;
	}
	
	public String toStringBasico() {
		SimpleDateFormat fecha=new SimpleDateFormat("dd/MM/yyyy");
		String fecha1= fecha.format(fnac);
		
		return "Nombre: "+ nombre+"\nApellido: "+ apellido+ "\nFecha de Nacimiento: " + fecha1;
	}
	
	
	public String toString(){
		SimpleDateFormat fecha=new SimpleDateFormat("dd/MM/yyyy");
		String fecha1= fecha.format(fnac);
		
		return "Nombre: "+ nombre+"\nApellido: "+ apellido+"\nNickname: "+nickname+"\nEmail: "+email+ "\nFecha de Nacimiento: " + fecha1;
	}
	
	
	
	@SuppressWarnings("null")
	public String toStringSeguidores() {
		SimpleDateFormat fecha=new SimpleDateFormat("dd/MM/yyyy");
		String fecha1= fecha.format(fnac);
		List<String> seguidos=new ArrayList<String>();
		List<String> seguidores=new ArrayList<String>();
		String siguiendo="";
		String teSiguen="";
		
		if(seguidos.isEmpty()) {
			siguiendo="No sigue a ningun Usuario";
		}else {
			for(String s: seguidos) {
				siguiendo=s+"\n";
			}
		}
		
		if(seguidores.isEmpty()) {
			teSiguen="No lo sigue ningun Usuario";
		}else {
			for(String s:seguidores) {
				teSiguen=s+"\n";
			}
		}
		return "Nombre: "+ nombre+"\nApellido: "+ apellido+ "\nFecha de Nacimiento: " + fecha1+"\nUsuarios que sigues\n" + siguiendo+ "\nUsuaruis que te siguen\n" + teSiguen;
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

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFnac(Date fnac) {
		this.fnac = fnac;
	}

	public void setSeguidos(List<String> seguidos) {
		this.seguidos = seguidos;
	}

	public void setSeguidores(List<String> seguidores) {
		this.seguidores = seguidores;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
