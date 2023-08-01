package presentacion;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import fabrica.Fabrica;
import interfaces.ICAaltaPaqueteEspectaculo;
import interfaces.ICAgregarEspectaculoPaqueteEspectaculo;
import interfaces.ICAltaFuncionEspectaculo;
import interfaces.ICConsultaFuncionEspectaculo;
import interfaces.ICConsultaPaqueteEspectaculo;
import interfaces.ICConsultaUsuario;
import interfaces.ICModificarDatosUsuario;
import interfaces.ICRegistroFuncion;
import interfaces.IControladorAltaEspectaculo;
import interfaces.IControladorAltaPlataforma;
import interfaces.IControladorUsuario;
import publicadores.ControladoresPublish;
import interfaces.IControladorConsultaEspectaculo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal {

	private JFrame frmCoronaTickets;
	private AltaFuncionEspectaculo altaFuncionEspectaculoInternalFrame;
	private ConsultaFuncionEspectaculo consultaFuncionEspectaculoInternalFrame;
	private AltaUsario altaUsuarioInternalFrame;
	private AltaPlataforma altaPlataformaInternalFrame;
	private AltaEspectaculo altaEspectaculoInternalFrame;
	private ConsultaEspectaculo consultaEspectaculoInternalFrame;
	private ConsultaUsuario consultaUsuarioInternalFrame;
	private AltaPaqueteEspectaculo altaPaqueteEspectaculoInternalFrame;
	private AgregarEspectaculoPaqueteEspectaculo agregarEspectaculoPaqueteEspectaculoInternalFrame;
	private ConsultaPaqueteEspectaculo consultaPaqueteEspectaculoInternalFrame;
	private ModificarUsuario modificarUsuarioInternalFrame;
	private RegistroFuncion registroFuncionInternalFrame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmCoronaTickets.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
		
		ControladoresPublish controladores=new ControladoresPublish();
		//ICSeguirUsuarioPublish icsu=new ICSeguirUsuarioPublish();
		//ICDejarDeSeguirUsuarioPublish icdsu=new ICDejarDeSeguirUsuarioPublish();
		controladores.publicar();
		//icsu.publicar();
		//icdsu.publicar();
		
		
		Fabrica fabrica=Fabrica.getInstancia();
		ICAltaFuncionEspectaculo ICAFE = fabrica.getICAltaFuncionEspectaculo();
		ICConsultaFuncionEspectaculo ICCFE = fabrica.getICConsultaFuncionEspectaculo();
		
		IControladorAltaEspectaculo ICAE=fabrica.getIControladorAltaEspectaculo();
		IControladorUsuario ICU=fabrica.getIControladorUsuario();
		IControladorAltaPlataforma ICAP=fabrica.getIControladorAltaPlataforma();
		IControladorConsultaEspectaculo ICCE=fabrica.getIControladorConsultaEspectaculo();
		ICConsultaUsuario ICCU=fabrica.getICConsultaUsuario();
		ICAaltaPaqueteEspectaculo ICAPE=fabrica.getICAaltaPaqueteEspectaculo();
		ICAgregarEspectaculoPaqueteEspectaculo ICAEP=fabrica.getICAgregarEspectaculoPaqueteEspectaculo();
		ICConsultaPaqueteEspectaculo ICCPE=fabrica.getICConsultaPaqueteEspectaculo();
		ICModificarDatosUsuario ICMDU=fabrica.getICModificarDatosUsuario();
		ICRegistroFuncion ICRF=fabrica.getICRegistroFuncion();
		ICU.cargarDatos();
		ICAP.cargarDatos();
		ICAE.cargarDatos();
		ICAFE.cargarDatos();
		
		Dimension desktopSize = frmCoronaTickets.getSize();
		Dimension jInternalFrameSize;
		
		altaFuncionEspectaculoInternalFrame = new AltaFuncionEspectaculo(ICAFE);
		altaFuncionEspectaculoInternalFrame.setLocation(26, 53);
		jInternalFrameSize = altaFuncionEspectaculoInternalFrame.getSize();
		altaFuncionEspectaculoInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
		    (desktopSize.height- jInternalFrameSize.height)/2);
		
		altaFuncionEspectaculoInternalFrame.setVisible(false);
		frmCoronaTickets.getContentPane().add(altaFuncionEspectaculoInternalFrame);
		
		consultaFuncionEspectaculoInternalFrame=new ConsultaFuncionEspectaculo(ICCFE);
		altaFuncionEspectaculoInternalFrame.setLocation(26, 53);
		jInternalFrameSize = altaFuncionEspectaculoInternalFrame.getSize();
		altaFuncionEspectaculoInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
		    (desktopSize.height- jInternalFrameSize.height)/2);
		consultaFuncionEspectaculoInternalFrame.setVisible(false);
		frmCoronaTickets.getContentPane().add(consultaFuncionEspectaculoInternalFrame);
		
		altaUsuarioInternalFrame=new AltaUsario(ICU);
		altaFuncionEspectaculoInternalFrame.setLocation(26, 53);
		jInternalFrameSize = altaFuncionEspectaculoInternalFrame.getSize();
		altaFuncionEspectaculoInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
		    (desktopSize.height- jInternalFrameSize.height)/2);
		altaUsuarioInternalFrame.setVisible(false);
		frmCoronaTickets.getContentPane().add(altaUsuarioInternalFrame);
		
		altaPlataformaInternalFrame=new AltaPlataforma(ICAP);
		altaPlataformaInternalFrame.setLocation(26, 53);
		jInternalFrameSize = altaPlataformaInternalFrame.getSize();
		altaPlataformaInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
		    (desktopSize.height- jInternalFrameSize.height)/2);
		
		altaPlataformaInternalFrame.setVisible(false);
		frmCoronaTickets.getContentPane().add(altaPlataformaInternalFrame);
		
		altaEspectaculoInternalFrame=new AltaEspectaculo(ICAE);
		altaEspectaculoInternalFrame.setLocation(26, 53);
		jInternalFrameSize = altaEspectaculoInternalFrame.getSize();
		altaEspectaculoInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
			    (desktopSize.height- jInternalFrameSize.height)/2);
		altaEspectaculoInternalFrame.setVisible(false);
		frmCoronaTickets.getContentPane().add(altaEspectaculoInternalFrame);
		
		consultaEspectaculoInternalFrame=new ConsultaEspectaculo(ICCE);
		consultaEspectaculoInternalFrame.setLocation(26, 53);
		jInternalFrameSize = consultaEspectaculoInternalFrame.getSize();
		consultaEspectaculoInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
			    (desktopSize.height- jInternalFrameSize.height)/2);
		consultaEspectaculoInternalFrame.setVisible(false);
		frmCoronaTickets.getContentPane().add(consultaEspectaculoInternalFrame);
		
		
		consultaUsuarioInternalFrame=new ConsultaUsuario (ICCU,ICCFE);
		consultaUsuarioInternalFrame.setLocation(26, 53);
		jInternalFrameSize = consultaUsuarioInternalFrame.getSize();
		consultaUsuarioInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
			    (desktopSize.height- jInternalFrameSize.height)/2);
		consultaUsuarioInternalFrame.setVisible(false);
		frmCoronaTickets.getContentPane().add(consultaUsuarioInternalFrame);
		
		
		altaPaqueteEspectaculoInternalFrame=new AltaPaqueteEspectaculo(ICAPE);
		altaPaqueteEspectaculoInternalFrame.setLocation(26, 53);
		jInternalFrameSize = altaPaqueteEspectaculoInternalFrame.getSize();
		altaPaqueteEspectaculoInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
			    (desktopSize.height- jInternalFrameSize.height)/2);
		altaPaqueteEspectaculoInternalFrame.setVisible(false);
		frmCoronaTickets.getContentPane().add(altaPaqueteEspectaculoInternalFrame);
		
		agregarEspectaculoPaqueteEspectaculoInternalFrame=new AgregarEspectaculoPaqueteEspectaculo(ICAEP);
		agregarEspectaculoPaqueteEspectaculoInternalFrame.setLocation(26, 53);
		jInternalFrameSize = agregarEspectaculoPaqueteEspectaculoInternalFrame.getSize();
		agregarEspectaculoPaqueteEspectaculoInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
		    (desktopSize.height- jInternalFrameSize.height)/2);
		
		altaPlataformaInternalFrame.setVisible(false);
		frmCoronaTickets.getContentPane().add(agregarEspectaculoPaqueteEspectaculoInternalFrame);
		
		
		consultaPaqueteEspectaculoInternalFrame=new ConsultaPaqueteEspectaculo(ICCPE,ICCFE);
		consultaPaqueteEspectaculoInternalFrame.setLocation(26, 53);
		jInternalFrameSize = consultaPaqueteEspectaculoInternalFrame.getSize();
		consultaPaqueteEspectaculoInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
			    (desktopSize.height- jInternalFrameSize.height)/2);
		consultaPaqueteEspectaculoInternalFrame.setVisible(false);
		frmCoronaTickets.getContentPane().add(consultaPaqueteEspectaculoInternalFrame);
		
		
		modificarUsuarioInternalFrame=new ModificarUsuario(ICMDU);
		modificarUsuarioInternalFrame.setLocation(26, 53);
		jInternalFrameSize = modificarUsuarioInternalFrame.getSize();
		modificarUsuarioInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
		    (desktopSize.height- jInternalFrameSize.height)/2);
		modificarUsuarioInternalFrame.setVisible(false);
		frmCoronaTickets.getContentPane().add(modificarUsuarioInternalFrame);
		
		registroFuncionInternalFrame=new RegistroFuncion(ICRF);
		registroFuncionInternalFrame.setLocation(26, 53);
		jInternalFrameSize = registroFuncionInternalFrame.getSize();
		registroFuncionInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
		    (desktopSize.height- jInternalFrameSize.height)/2);
		registroFuncionInternalFrame.setVisible(false);
		frmCoronaTickets.getContentPane().add(registroFuncionInternalFrame);
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCoronaTickets = new JFrame();
		frmCoronaTickets.setTitle("Corona Tickets");
		frmCoronaTickets.setBounds(100, 100, 797, 676);
		frmCoronaTickets.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmCoronaTickets.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Altas");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Usuario");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaUsuarioInternalFrame.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Plataforma");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaPlataformaInternalFrame.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Espectaculo");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaEspectaculoInternalFrame.inicializarComboBoxes();
				altaEspectaculoInternalFrame.setVisible(true);
			}
		});
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Paquete Espectaculo");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaPaqueteEspectaculoInternalFrame.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_7);
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Funcion");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaFuncionEspectaculoInternalFrame.inicializarComboBoxes();
				altaFuncionEspectaculoInternalFrame.setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Registro Funcion");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registroFuncionInternalFrame.inicializarComboBoxes();
				registroFuncionInternalFrame.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_11);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Agregar Espectaculo a Paquete");
		mnNewMenu.add(mntmNewMenuItem_8);
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregarEspectaculoPaqueteEspectaculoInternalFrame.inicializarComboBoxes();
				agregarEspectaculoPaqueteEspectaculoInternalFrame.setVisible(true);
			}
		});
		
		JMenu mnNewMenu_1 = new JMenu("Consultas");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Espectaculo");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultaEspectaculoInternalFrame.inicializarComboBoxes();
				consultaEspectaculoInternalFrame.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Funcion");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultaFuncionEspectaculoInternalFrame.inicializarComboBoxes();
				consultaFuncionEspectaculoInternalFrame.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Usuario");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultaUsuarioInternalFrame.inicializarComboBoxes();
				consultaUsuarioInternalFrame.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Paquete Espectaculo");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consultaPaqueteEspectaculoInternalFrame.inicializarComboBox();
				consultaPaqueteEspectaculoInternalFrame.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_9);
		
		JMenu mnNewMenu_2 = new JMenu("Modificar");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Datos Usuario");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificarUsuarioInternalFrame.inicializarComboBox();
				modificarUsuarioInternalFrame.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_10);
	}
}
