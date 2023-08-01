package interfaces;

import datatypes.DtUsuario;

public interface ICModificarDatosUsuario {
	public String[] nickUsuarios();
	public DtUsuario datosUsuario(String usuario);
	public void modificarDatos(String usuario,DtUsuario dt);
}
