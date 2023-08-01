package fabrica;


import controladores.ControladorAltaEspectaculo;
import controladores.ControladorAltaPlataforma;
import controladores.ControladorConsultaEspectaculo;
import interfaces.ICAaltaPaqueteEspectaculo;
import interfaces.ICAgregarEspectaculoPaqueteEspectaculo;
import interfaces.ICAltaFuncionEspectaculo;
import interfaces.ICConsultaFuncionEspectaculo;
import interfaces.ICConsultaPaqueteEspectaculo;
import interfaces.ICConsultaUsuario;
import interfaces.ICDejarDeSeguirUsuario;
import interfaces.ICModificarDatosUsuario;
import interfaces.ICRegistroFuncion;
import interfaces.ICSeguirUsuario;
import controladores.CAgregarEspectaculoPaqueteEspectaculo;
import controladores.CAltaFuncionEspectaculo;
import controladores.CAltaPaqueteEspectaculo;
import controladores.CConsultaFuncionEspectaculo;
import controladores.CConsultaPaqueteEspectaculo;
import controladores.CConsultaUsuario;
import controladores.CDejarSeguirUsuario;
import controladores.CModificarDatosUsuario;
import controladores.CRegistroFuncion;
import controladores.CSeguirUsuario;
import interfaces.IControladorAltaEspectaculo;
import interfaces.IControladorAltaPlataforma;
import interfaces.IControladorConsultaEspectaculo;
import controladores.ControladorUsuario;
import interfaces.IControladorUsuario;



public class Fabrica {//Fabrica es de tipo singleton
	private static Fabrica instancia = null;	

	public Fabrica() {}//constructor privado
	public static Fabrica getInstancia() {

		if (instancia == null)
			instancia = new Fabrica();
		return instancia;
	}


	public ICAltaFuncionEspectaculo getICAltaFuncionEspectaculo() {
		return new CAltaFuncionEspectaculo();
	}
	
	public ICConsultaFuncionEspectaculo getICConsultaFuncionEspectaculo() {
		return new CConsultaFuncionEspectaculo();
	}

	
	public IControladorAltaEspectaculo getIControladorAltaEspectaculo() {
		return new ControladorAltaEspectaculo();
	}
	public IControladorConsultaEspectaculo getIControladorConsultaEspectaculo() {
		return new ControladorConsultaEspectaculo();
	}	

	public IControladorUsuario getIControladorUsuario() {//creo un metodo que accede al Usuario
		return new ControladorUsuario();
	}
	
	public IControladorAltaPlataforma getIControladorAltaPlataforma() {
		return new ControladorAltaPlataforma();
	}
	
	public ICSeguirUsuario getICSeguirUsuario() {
		return new CSeguirUsuario();
	}
	
	public ICDejarDeSeguirUsuario getICDejarDeSeguirUsuario(){
		return new CDejarSeguirUsuario();
	}

	public ICConsultaUsuario getICConsultaUsuario() {
		return new CConsultaUsuario();
	}
	
	public ICAaltaPaqueteEspectaculo getICAaltaPaqueteEspectaculo() {
		return new CAltaPaqueteEspectaculo();
	}
	
	public ICAgregarEspectaculoPaqueteEspectaculo getICAgregarEspectaculoPaqueteEspectaculo(){
		return new CAgregarEspectaculoPaqueteEspectaculo();
	}

	public ICConsultaPaqueteEspectaculo getICConsultaPaqueteEspectaculo() {
		return new CConsultaPaqueteEspectaculo();
	}
	
	public ICModificarDatosUsuario getICModificarDatosUsuario() {
		return new CModificarDatosUsuario(); 
	}


	public ICRegistroFuncion getICRegistroFuncion() {
		return new CRegistroFuncion();
	}
	
	
}









