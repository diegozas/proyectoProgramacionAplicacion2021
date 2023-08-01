package controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import datatypes.DtArtista;
import datatypes.DtUsuario;
import excepciones.PasswordIncorrectaExcepcion;
import excepciones.UsuarioRepetidoExcepcion;
import interfaces.IControladorUsuario;
import logica.Artista;
import logica.Espectador;
import logica.Usuario;
import manejador.ManejadorUsuario;

public class ControladorUsuario implements IControladorUsuario {
	private String password;
	
	@Override
	public void setPassword(String pass) {
		this.password=pass;
	}
	
	@Override
	public boolean verificarPassword(String pass) {
		boolean correcto=false;
		if(pass.equals(this.password)) {
			correcto=true;
		}
		return correcto;
	}
	
	
	@Override
	public void altaUsuario(DtUsuario dtusuario) throws UsuarioRepetidoExcepcion, PasswordIncorrectaExcepcion {
		// TODO Auto-generated method stub
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		String nick=dtusuario.getNickname();
		String email=dtusuario.getEmail();
		
		if(!verificarPassword(dtusuario.getPass())) {
			throw new PasswordIncorrectaExcepcion("La contrasena no coincide");
		}
		
		else if(mu.existeUsuario(email,nick)) {
			throw new UsuarioRepetidoExcepcion ("Ya existe un Usuario con ese nick o email");
			
		}else {
			
			if(dtusuario instanceof DtArtista) {
				Usuario artista=new Artista(dtusuario.getNickname(),dtusuario.getNombre(),dtusuario.getApellido(),dtusuario.getEmail(),dtusuario.getFnac(),dtusuario.getPass(),((DtArtista) dtusuario).getDescripcion(),((DtArtista) dtusuario).getBiografia(),((DtArtista) dtusuario).getSitioWeb());
				/*usr = new Artista();//transformo dtARtista en artista
				usr.setCorreoElectronico(dtusuario.getEmail());
				usr.setNickname(dtusuario.getNickname());
				usr.setFechaNacimiento(dtusuario.getFnac());
				usr.setNombre(dtusuario.getNombre());
				usr.setApellido(dtusuario.getApellido());
				//datos que requiere el artista
				usr.setDescripcionGeneral(((DtArtista) dtusuario).getDescripcion());
				usr.setLinkSitioWeb(((DtArtista) dtusuario).getSitioWeb());
				usr.setBiografia(((DtArtista) dtusuario).getBiografia());//es opcional
				*/
				mu.agregarUsuario(artista);
			}//hasta acá es el artista
			else {
				Usuario esp= new Espectador(dtusuario.getNickname(),dtusuario.getNombre(),dtusuario.getApellido(),dtusuario.getEmail(),dtusuario.getFnac(),dtusuario.getPass());
			 
				
				/*usr.setCorreoElectronico(dtusuario.getEmail());
				usr.setNickname(dtusuario.getNickname());
				usr.setFechaNacimiento(dtusuario.getFnac());
				usr.setNombre(dtusuario.getNombre());
				usr.setApellido(dtusuario.getApellido());*/
				mu.agregarUsuario(esp);
			}// si fuera espectador
		}


	}
	/*public void ListarUsuarioConsola() {
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		if(mu.hayUsuarios()){
			List<String> listaNN = mu.listarUsuariosNick();
			for(String s : listaNN) {
				System.out.println(s);
			}
		}
	}*/
	
	@Override
	public void cargarDatos() {
		ManejadorUsuario mu=ManejadorUsuario.getInstancia();
		Date fecha=new Date(1994-1900,8-1,20);
		Usuario a1=new Artista("dZas","Diego","Zas","diego@diego",fecha,"123","no hay","vacio","diego.com");
		Usuario a2=new Artista("prueba","prueba","prueba","prueba@pruba",fecha,"123","vacio","vacio","prueba.com");
		Usuario a3=new Espectador("probando","probando","probando","probando@probando",fecha,"123");
		
		mu.agregarUsuario(a1);
		mu.agregarUsuario(a2);
		mu.agregarUsuario(a3);
	}
	
	
	
	
}
