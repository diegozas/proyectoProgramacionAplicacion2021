package interfaces;

import java.util.ArrayList;

import logica.Usuario;

public interface ICDejarDeSeguirUsuario {
	public ArrayList<String> seguidores(String usuario);
	public void dejarSeguirUsuario(String usuarioSeguido,String nick);
}
