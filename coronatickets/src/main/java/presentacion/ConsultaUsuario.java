package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import interfaces.ICConsultaFuncionEspectaculo;
import interfaces.ICConsultaUsuario;
import logica.Artista;
import logica.Espectaculo;
import logica.Espectador;
import logica.Funcion;
import logica.Usuario;
import manejador.ManejadorEspectaculos;
import manejador.ManejadorUsuario;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;

import datatypes.DtArtista;
import datatypes.DtEspectador;
import datatypes.DtFuncion;
import datatypes.DtUsuario;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class ConsultaUsuario extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private ICConsultaUsuario icon;
	private ICConsultaFuncionEspectaculo iconn;
	private JComboBox<String> comboBoxUsuario;
	private JTextArea textUsuario;
	private JTextArea textAreaEspectaculo;
	private JComboBox<String> comboBoxEspectaculo;
	private JComboBox<String> comboBoxFunciones;
	private JTextArea textAreaFuncion;
	
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public ConsultaUsuario(ICConsultaUsuario icon,ICConsultaFuncionEspectaculo iconn) {
		this.icon=icon;
		this.iconn=iconn;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
		setBounds(100, 100, 724, 376);
		getContentPane().setLayout(null);
		
		comboBoxUsuario = new JComboBox();
		comboBoxUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEspectaculos(e);
			}
		});
		comboBoxUsuario.setBounds(74, 40, 123, 22);
		getContentPane().add(comboBoxUsuario);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 42, 72, 14);
		getContentPane().add(lblNewLabel);
		
		comboBoxEspectaculo = new JComboBox();
		comboBoxEspectaculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarFunciones(e);
			}
		});
		comboBoxEspectaculo.setBounds(299, 40, 154, 22);
		getContentPane().add(comboBoxEspectaculo);
		
		JLabel lblNewLabel_1 = new JLabel("Espectaculo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(217, 43, 72, 14);
		getContentPane().add(lblNewLabel_1);
		
		textUsuario = new JTextArea();
		textUsuario.setEditable(false);
		textUsuario.setBounds(10, 121, 187, 186);
		getContentPane().add(textUsuario);
		
		textAreaEspectaculo = new JTextArea();
		textAreaEspectaculo.setEditable(false);
		textAreaEspectaculo.setBounds(304, 121, 154, 162);
		getContentPane().add(textAreaEspectaculo);
		
		JLabel lblNewLabel_2 = new JLabel("Datos Usuario");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(71, 89, 96, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Espectaculo");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(304, 96, 113, 14);
		getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Info Usuario");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostarDatosUsuario(e);
			}
		});
		btnNewButton.setBounds(47, 313, 120, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Info Espectaculo");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarEspectaculo(e);
			}
		});
		btnNewButton_1.setBounds(314, 294, 131, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cancelar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar(e);
			}
		});
		btnNewButton_2.setBounds(191, 313, 89, 23);
		getContentPane().add(btnNewButton_2);
		
		comboBoxFunciones = new JComboBox();
		comboBoxFunciones.setBounds(561, 40, 113, 22);
		getContentPane().add(comboBoxFunciones);
		
		JLabel lblNewLabel_4 = new JLabel("Funciones");
		lblNewLabel_4.setBounds(477, 44, 74, 14);
		getContentPane().add(lblNewLabel_4);
		
		textAreaFuncion = new JTextArea();
		textAreaFuncion.setBounds(510, 121, 164, 162);
		getContentPane().add(textAreaFuncion);
		
		JLabel lblNewLabel_5 = new JLabel("Funcion");
		lblNewLabel_5.setBounds(540, 91, 82, 14);
		getContentPane().add(lblNewLabel_5);
		
		JButton btnNewButton_3 = new JButton("Info Funcion");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarFuncion(e);
			}
		});
		btnNewButton_3.setBounds(544, 294, 130, 23);
		getContentPane().add(btnNewButton_3);

	}
	
	
	
	
	public void inicializarComboBoxes() {
		DefaultComboBoxModel<String> modelUsuario = new DefaultComboBoxModel<String>(icon.nickUsuarios());
		comboBoxUsuario.setModel(modelUsuario);
		
	}
	
	
	protected void cargarEspectaculos(ActionEvent arg0) {
		String usuario=this.comboBoxUsuario.getSelectedItem().toString();
		ManejadorEspectaculos me= ManejadorEspectaculos.getInstancia();
		ManejadorUsuario mu=ManejadorUsuario.getInstancia();
		Usuario u=mu.getUsuario(usuario);
		
		if(u instanceof Artista) {
			String nick=u.getNickname();
			DefaultComboBoxModel<String> modelEspectaculo = new DefaultComboBoxModel<String>(icon.nobresEspectaculos(nick));
			if(modelEspectaculo.getSize()==0) {
				this.comboBoxEspectaculo.removeAllItems();
				//this.comboBoxFunciones.setSelectedIndex(-1);
			}else {
				comboBoxEspectaculo.setModel(modelEspectaculo);
			}
			
			
		}else if(u instanceof Espectador) {
			DefaultComboBoxModel<String> modelFuncion = new DefaultComboBoxModel<String>(icon.funcionesEspectador(usuario));
			if(modelFuncion.getSize()==0) {
				this.comboBoxEspectaculo.removeAllItems();
				comboBoxFunciones.setSelectedIndex(-1);
			}else {
				comboBoxFunciones.setModel(modelFuncion);
			}
		
		}
	
	}
	
	
	
	protected void mostrarEspectaculo(ActionEvent arg0) {
		String espectaculo=this.comboBoxEspectaculo.getSelectedItem().toString();
		ManejadorEspectaculos me=ManejadorEspectaculos.getInstancia();
		Espectaculo e=me.buscarEspectaculo(espectaculo);
		this.textAreaEspectaculo.setText(e.getDtEspectaculo().toString());
		
	}
	
	
	
	protected void mostarDatosUsuario(ActionEvent arg0) {
		this.textUsuario.setText("");
		
		String nick=this.comboBoxUsuario.getSelectedItem().toString();
		ManejadorUsuario mu=ManejadorUsuario.getInstancia();
		Usuario u=mu.getUsuario(nick);
		if(u instanceof Artista) {
			DtArtista dta=((Artista) u).datosArtista();
			String s="Artista\n";
			this.textUsuario.setText(s+dta.toString());
		}else if(u instanceof Espectador) {
			this.textAreaFuncion.setText("");
			this.textAreaEspectaculo.setText("");
			DtUsuario dtu=u.datosUsuario();
			String s="Espectador\n";
			comboBoxEspectaculo.removeAllItems();
			this.textUsuario.setText(s+dtu.toString());
			if(((Espectador) u).getFunciones().length==0) {
				comboBoxFunciones.removeAllItems();
			}
		}
	
	}
	protected void mostrarFuncion(ActionEvent arg0) {
		this.textAreaFuncion.setText("");
		ManejadorUsuario mu=ManejadorUsuario.getInstancia();
		Usuario u=mu.getUsuario(comboBoxUsuario.getSelectedItem().toString());
		if(u instanceof Espectador) {
			String funcion=this.comboBoxFunciones.getSelectedItem().toString();
			Funcion f=((Espectador) u).getFuncion(funcion);
			DtFuncion dtf=f.getDtFuncion();
			String datos="Informacion de la Funcion";
			datos=datos+"\n" + dtf.toString();
			textAreaFuncion.setText(datos);
		}else {
			String especatculo=this.comboBoxEspectaculo.getSelectedItem().toString();
			String funcion=this.comboBoxFunciones.getSelectedItem().toString();
		
			iconn.elegirEspecatculo(especatculo);
			DtFuncion dtf=iconn.selectFuncion(funcion);
			String datos="Informacion de la Funcion";
			datos=datos+"\n" + dtf.toString();
			textAreaFuncion.setText(datos);
			
		}
	}
	
	
	protected void cargarFunciones(ActionEvent arg0) {
			String espectaculo=this.comboBoxEspectaculo.getSelectedItem().toString();
			ManejadorEspectaculos me=ManejadorEspectaculos.getInstancia();
			Espectaculo e=me.buscarEspectaculo(espectaculo);
			DefaultComboBoxModel<String> modelfunciones=new DefaultComboBoxModel<String>(e.listarFunciones());
			if(modelfunciones.getSize()==0) {
				this.comboBoxFunciones.setSelectedIndex(-1);
			}else{
				comboBoxFunciones.setModel(modelfunciones);
			}
			
	}
	
	
	
	protected void cancelar(ActionEvent arg0) {
		limpiarFormulario();
		//this.comboBoxFunciones.removeAllItems();
		this.comboBoxEspectaculo.removeAllItems();
		setVisible(false);
	}
	
	protected void limpiarFormulario() {
		this.textUsuario.setText("");
		this.textAreaEspectaculo.setText("");
		this.textAreaFuncion.setText("");
	}
	
	
	
	
	
}
