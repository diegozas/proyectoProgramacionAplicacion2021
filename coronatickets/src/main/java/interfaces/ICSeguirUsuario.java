package interfaces;

import java.util.ArrayList;
import java.util.List;

import logica.Usuario;

public interface ICSeguirUsuario {
	public ArrayList<String> sinSeguir(String usuario);
	public void seguirUsuario(String usuarioSeguir,String nick);
}
