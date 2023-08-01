package publicadores;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import datatypes.DtArtista;
import datatypes.DtFuncion;
import datatypes.DtUsuario;
import excepciones.FuncionRepetidaExcepcion;
import excepciones.PasswordIncorrectaExcepcion;
import excepciones.UsuarioRepetidoExcepcion;
import fabrica.Fabrica;
import interfaces.ICAltaFuncionEspectaculo;
import interfaces.ICDejarDeSeguirUsuario;
import interfaces.ICSeguirUsuario;
import interfaces.IControladorUsuario;
import logica.Artista;
import logica.Espectaculo;
import logica.Espectador;
import logica.Funcion;
import logica.Plataforma;
import logica.Usuario;
import manejador.ManejadorEspectaculos;
import manejador.ManejadorPlataforma;
import manejador.ManejadorUsuario;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladoresPublish {
	private ManejadorUsuario mu;
	private Endpoint endpoint;
	private Fabrica fabrica;
	private ICSeguirUsuario icSeguirUsuario;
	private ICDejarDeSeguirUsuario icdejarSeguirUsuario;
	private IControladorUsuario icUsuario;
	private ICAltaFuncionEspectaculo icAlta;
	
	public ControladoresPublish(){
		mu=ManejadorUsuario.getInstancia();
		fabrica=Fabrica.getInstancia();
		icSeguirUsuario=fabrica.getICSeguirUsuario();
		icdejarSeguirUsuario=fabrica.getICDejarDeSeguirUsuario();
		icUsuario=fabrica.getIControladorUsuario();
		icAlta=fabrica.getICAltaFuncionEspectaculo();
	}
	
	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://localhost:9128/ControladoresPublish", this);
		
	}

	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	
	
	
	//Metodos a publicar
	@WebMethod
	public boolean existeUsuarioPassword(String log,String pass) {
		return (mu.existeUsuarioPassword(log, pass));
	}


	@WebMethod
	public Usuario getUsuario(String log) {
		Usuario retorno=mu.getUsuario(log);
		return retorno;
	}
	
	
	@WebMethod
	public Artista buscarArtista(String nick) {
		Artista artista=mu.buscarArtista(nick);
		return artista;
	}
	
	@WebMethod
	public Espectador buscarEspectador(String nick) {
		Espectador espectador=mu.buscarEspectador(nick);
		return espectador;
	}
	
	//---------------------------------------------------------------------------
	
	//Metodos del controlador Seguir Usuario
	@WebMethod
	public String[] sinSeguir(String usuario){
		ArrayList<String> sinSeguir=icSeguirUsuario.sinSeguir(usuario);
		String[] nickRetorno=new String[sinSeguir.size()];
		int i=0;
		for(String s:sinSeguir) {
			nickRetorno[i]=s;
			i++;
		}
		return nickRetorno;
	}
	
	@WebMethod
	public void seguirUsuario(String usuarioSeguir,String nick) {
		icSeguirUsuario.seguirUsuario(usuarioSeguir, nick);
	}
	
	//-------------------------------------------------------------------
	//Metodos del controlador dejar seguir usuario
	@WebMethod
	public String[]  seguidores(String usuario){
		ArrayList<String> siguiendo=icdejarSeguirUsuario.seguidores(usuario);
		String[] nickRetorno=new String[siguiendo.size()];
		int i=0;
		for(String s:siguiendo) {
			nickRetorno[i]=s;
			i++;
		}
		return nickRetorno;
	}
	
	@WebMethod
	public void dejarSeguirUsuario(String usuarioSeguido,String nick) {
		icdejarSeguirUsuario.dejarSeguirUsuario(usuarioSeguido, nick);
	}
	
	
	//--------------------------------------------------
	//Metodos del controlador alta usuario
	
	
	public void altaUsuario(DtUsuario dt,String pass) throws PasswordIncorrectaExcepcion, UsuarioRepetidoExcepcion {
		icUsuario.setPassword(pass);
		icUsuario.altaUsuario(dt);
	}
	
	//Esta funcion esta para que quede publicado una funcion con dtArtista
	public void altaArtista(String nickname, String nombre, String apellido, String correoElectronico, Date fechaNac,String password, String descArtista, String sitioWebArt, String bioArtista,String cofirmarPassword) throws PasswordIncorrectaExcepcion, UsuarioRepetidoExcepcion{
		icUsuario.setPassword(cofirmarPassword);
		DtArtista dta=new DtArtista(nickname,nombre,apellido,correoElectronico,fechaNac,password,descArtista,sitioWebArt,bioArtista);
		icUsuario.altaUsuario(dta);
	}
	
	
	
	//
	public String[] getPlataformas() {
		ManejadorPlataforma mp=ManejadorPlataforma.getInstancia();		
		List<String> plataformas=mp.obtenerPlataformas();
		String[] nombresPlataformas=new String[plataformas.size()];
		int i=0;
		for (String s:plataformas) {
			nombresPlataformas[i]=s;
			i++;
		}
		return nombresPlataformas;
	}
	
	
	
	public Espectaculo getEspectaculo(String nombre) {
		ManejadorEspectaculos me = ManejadorEspectaculos.getInstancia();
		Espectaculo e=me.buscarEspectaculo(nombre);
		return e;
	}
	
	public Funcion funcion() {
		Date fecha=new Date();
		Funcion f=new Funcion("funcion",fecha);
		return f;
	}
	

	public String[] getFuncionesEspectaculo(String esp) {
		ManejadorEspectaculos me = ManejadorEspectaculos.getInstancia();
		Espectaculo e=me.buscarEspectaculo(esp);
		List<String> nombres=e.getFunciones();
		String[] nombresFuncion=new String[nombres.size()];
		int i=0;
		for(String s:nombres) {
			nombresFuncion[i]=s;
			i++;
		}
		return nombresFuncion;
	}


	public Plataforma getPlataforma(String nombre) {
		ManejadorPlataforma mp=ManejadorPlataforma.getInstancia();	
		Plataforma p=mp.getPlataforma(nombre);
		return p;
	}
	
	
	public String[] listarEspectaculos(String nombrePlataforma) {
		ManejadorPlataforma mp=ManejadorPlataforma.getInstancia();	
		Plataforma p=mp.getPlataforma(nombrePlataforma);
		String[] nombres=p.listarEspectaculos();
		return nombres;
	}
	
	
	
	public Funcion getFuncion(String espectaculo,String funcion) {
		ManejadorEspectaculos me = ManejadorEspectaculos.getInstancia();
		Espectaculo e=me.buscarEspectaculo(espectaculo);
		Funcion f=e.getFuncion(funcion);
		return f;
		
	}
	
	
	public String[] getArtistasInvitados(String espectaculo,String funcion) {
		ManejadorEspectaculos me = ManejadorEspectaculos.getInstancia();
		Espectaculo e=me.buscarEspectaculo(espectaculo);
		Funcion f=e.getFuncion(funcion);
		
		List<String> nombres=f.getArtistasInvitados();
		
		String[] nombresRetorno=new String[nombres.size()];
		int i=0;
		for(String s:nombres) {
			nombresRetorno[i]=s;
			i++;
		}
		return nombresRetorno;
	
	}
	
	
	@WebMethod
	public void altaFuncion(DtFuncion dt,String espectaculo) throws FuncionRepetidaExcepcion {
		icAlta.selectEspectauclo(espectaculo);
		icAlta.ingresarDatos(dt);
		icAlta.altaFuncion();
		
	}
	
	
	
	@WebMethod 
	public String[] getEspectaculosArtista(String nombreArt) {
		ManejadorEspectaculos mp=ManejadorEspectaculos.getInstancia();
		ArrayList<String> nombres=mp.getEspectaculosArtista(nombreArt);
		String[] nombresRetorno=new String[nombres.size()];
		
		int i=0;
		for(String s:nombres) {
			nombresRetorno[i]=s;
			i++;
		}
		return nombresRetorno;
	}
	
	public String[] arrayNombArtista(){
		ManejadorUsuario mu=ManejadorUsuario.getInstancia();
		List<String> nombres=mu.arrayNombArtista();
		String[] nombresRetorno=new String[nombres.size()];
		int i=0;
		for(String s: nombres) {
			nombresRetorno[i]=s;
			i++;
		}
		return nombresRetorno;
		
	}
	
}
