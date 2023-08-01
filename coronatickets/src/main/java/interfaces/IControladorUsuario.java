package interfaces;

import datatypes.DtUsuario;
import excepciones.PasswordIncorrectaExcepcion;
import excepciones.UsuarioRepetidoExcepcion;

public interface IControladorUsuario {//esta es mi interfase
	public void altaUsuario(DtUsuario dtusuario) throws PasswordIncorrectaExcepcion,UsuarioRepetidoExcepcion;
	public boolean verificarPassword(String pass);
	public void setPassword(String pass);
	public void cargarDatos();
}
