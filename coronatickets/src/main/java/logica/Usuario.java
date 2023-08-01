package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import datatypes.DtArtista;
import datatypes.DtUsuario;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Usuario {
	@Id
	protected String nickname;
	protected String nombre;
	protected String apellido;
	protected String correoElectronico;
	protected Date fechaNacimiento;
	protected String password;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Usuario> seguidos = new ArrayList<Usuario>();
	
	/*@ManyToMany(mappedBy = "seguidos")
	private List<Usuario> seguidores = new ArrayList<Usuario>();	
	*/
	
	public List<Usuario> getSeguidos() {
		return seguidos;
	}

	public void setSeguidos(List<Usuario> seguidos) {
		this.seguidos = seguidos;
	}

	/*public List<Usuario> getSeguidores() {
		return seguidores;
	}*/

	/*public void setSeguidores(List<Usuario> seguidores) {
		this.seguidores = seguidores;
	}*/
	
	//Modificar los seguidos
	public void seguirUsuario(Usuario u) {
		if (!this.seguidos.contains(u)) {
			this.seguidos.add(u);
			//u.agregarSeguidor(this);
		}
	}
	
	public void dejarSeguirUsuario(Usuario u) {
		this.seguidos.remove(u);
		//u.quitarSeguidor(this);
	}
	/*
	//Modificar los seguidores
	public void agregarSeguidor(Usuario u) {
		if (!this.seguidores.contains(u)) {
			this.seguidores.add(u);			
		}

	}
	*/
	/*public void quitarSeguidor(Usuario u) {
		this.seguidores.remove(u);
	}

	*/
	public boolean sigueUsuario(String s) {
		boolean sigue=false;
		if(!seguidos.isEmpty()) {
			for(Usuario u:seguidos) {
				if(u.getNickname().contentEquals(s)) {
					sigue =true;
				}
			}
		}
		return sigue;
		
	}
	
	public Usuario(String nickname, String nombre, String apellido, String correoElectronico, Date fechaNacimiento,String password) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correoElectronico = correoElectronico;
		this.fechaNacimiento = fechaNacimiento;
		this.password=password;
	}
	
	
	
	
	public Usuario() {
		super();
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public DtUsuario getDtUsuario() {
		DtUsuario nUsu = new DtUsuario(this.nickname, this.nombre, this.apellido, this.correoElectronico, this.fechaNacimiento,this.password);
		
		return nUsu;
	}

	
	public DtUsuario datosUsuarioSeguidor() {
		List<String> seguidoss=new ArrayList<String>();
		List<String> seguidoress=new ArrayList<String>();
		for(Usuario u:seguidos) {
			seguidoss.add(u.getNickname());
		}
		
		//for(Usuario u: seguidores) {
			//seguidoress.add(u.getNickname());
		//}
		
		DtUsuario nUsu = new DtUsuario(this.nickname, this.nombre, this.apellido, this.correoElectronico, this.fechaNacimiento,seguidoss,seguidoress);
		return nUsu;
	}
	
	
	public DtUsuario datosUsuario() {
		DtUsuario nUsu = new DtUsuario(this.nickname, this.nombre, this.apellido, this.correoElectronico, this.fechaNacimiento);
		
		return nUsu;
	}
	
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
