package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import datatypes.DtArtista;

@Entity
@DiscriminatorValue("A")
public class Artista extends Usuario {
	private String descripcionGeneral;
	private String biografia;
	private String linkSitioWeb;
	private boolean invitado=false;
	

	public boolean getInvitado() {
		return invitado;
	}
	public void setInvitado(boolean invitado) {
		this.invitado = invitado;
	}
	public Artista() {
		super();
	}
	public Artista(String nickname, String nombre, String apellido, String correoElectronico, Date fechaNacimiento,String pass,String descripcionGeneral, String biografia, String linkSitioWeb) {
		super(nickname,nombre,apellido,correoElectronico,fechaNacimiento,pass);
		this.descripcionGeneral = descripcionGeneral;
		this.biografia = biografia;
		this.linkSitioWeb = linkSitioWeb;
	}
	public String getDescripcionGeneral() {
		return descripcionGeneral;
	}
	public void setDescripcionGeneral(String descripcionGeneral) {
		this.descripcionGeneral = descripcionGeneral;
	}
	public String getBiografia() {
		return biografia;
	}
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	public String getLinkSitioWeb() {
		return linkSitioWeb;
	}
	public void setLinkSitioWeb(String linkSitioWeb) {
		this.linkSitioWeb = linkSitioWeb;
	}
	public DtArtista getDtArtista() {
		DtArtista nArtista = new DtArtista(this.nickname, this.nombre, this.apellido, this.correoElectronico, this.fechaNacimiento,
				this.password,this.descripcionGeneral, this.linkSitioWeb, this.biografia);
		return nArtista;
	}
	
	public DtArtista datosArtista() {
		DtArtista nArtista = new DtArtista(this.nickname, this.nombre, this.apellido, this.correoElectronico, this.fechaNacimiento,
				this.descripcionGeneral, this.linkSitioWeb, this.biografia);
		return nArtista;
	}
	
	public DtArtista datosArtistaSeguidor() {
		List<String> seguidoss=new ArrayList<String>();
		List<String> seguidoress=new ArrayList<String>();
		
		List<Usuario> seguidoUsuario=this.getSeguidos();
		//List<Usuario> seguidoresUsuario=this.getSeguidores();
		
		for(Usuario u:seguidoUsuario) {
			seguidoss.add(u.getNickname());
		}
		/*for(Usuario u: seguidoresUsuario) {
			seguidoress.add(u.getNickname());
		}*/
		DtArtista nArtista = new DtArtista(this.nickname, this.nombre, this.apellido, this.correoElectronico, this.fechaNacimiento,
				seguidoss,seguidoress,this.descripcionGeneral, this.linkSitioWeb, this.biografia);
		return nArtista;
	}
	
	
}
