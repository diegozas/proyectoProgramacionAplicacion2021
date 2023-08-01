package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import interfaces.ICConsultaFuncionEspectaculo;
import interfaces.ICConsultaPaqueteEspectaculo;
import logica.Espectaculo;
import manejador.ManejadorEspectaculos;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

import datatypes.DtEspectaculo;
import datatypes.DtFuncion;
import datatypes.DtPaqueteEspectaculo;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaPaqueteEspectaculo extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private ICConsultaPaqueteEspectaculo icon;
	private ICConsultaFuncionEspectaculo iconn;
	private JTextArea textAreaPaquete;
	private JTextArea textAreaEspectaculo;
	private JComboBox<String> comboBoxFuncion;
	private JComboBox<String> comboBoxEspectaculo;
	private JComboBox<String> comboBoxPaquete;
	private JTextArea textAreaFuncion;
	public ConsultaPaqueteEspectaculo(ICConsultaPaqueteEspectaculo icon,ICConsultaFuncionEspectaculo iconn) {
		setTitle("Consulta de Paquete");
		this.icon=icon;
		this.iconn=iconn;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
		setBounds(100, 100, 572, 392);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Paquetes");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 23, 82, 14);
		getContentPane().add(lblNewLabel);
		
		comboBoxPaquete = new JComboBox<String>();
		comboBoxPaquete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEspectaculos(e);
			}
		});
		comboBoxPaquete.setBounds(74, 20, 116, 22);
		getContentPane().add(comboBoxPaquete);
		
		textAreaPaquete = new JTextArea();
		textAreaPaquete.setEditable(false);
		textAreaPaquete.setBounds(30, 69, 166, 193);
		getContentPane().add(textAreaPaquete);
		
		JLabel lblNewLabel_1 = new JLabel("Espectaculo");
		lblNewLabel_1.setBounds(200, 24, 59, 14);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Info Paquete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datosPaquete(e);
			}
		});
		btnNewButton.setBounds(40, 278, 131, 23);
		getContentPane().add(btnNewButton);
		
		comboBoxEspectaculo = new JComboBox<String>();
		comboBoxEspectaculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarFunciones(e);
			}
		});
		comboBoxEspectaculo.setBounds(268, 20, 116, 22);
		getContentPane().add(comboBoxEspectaculo);
		
		textAreaEspectaculo = new JTextArea();
		textAreaEspectaculo.setEditable(false);
		textAreaEspectaculo.setBounds(221, 69, 149, 193);
		getContentPane().add(textAreaEspectaculo);
		
		JLabel lblNewLabel_2 = new JLabel("Funcion");
		lblNewLabel_2.setBounds(394, 24, 49, 14);
		getContentPane().add(lblNewLabel_2);
		
		comboBoxFuncion = new JComboBox();
		comboBoxFuncion.setBounds(453, 20, 99, 22);
		getContentPane().add(comboBoxFuncion);
		
		textAreaFuncion = new JTextArea();
		textAreaFuncion.setEditable(false);
		textAreaFuncion.setBounds(394, 69, 158, 193);
		getContentPane().add(textAreaFuncion);
		
		JButton btnNewButton_1 = new JButton("Info Espectaculo");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datosEspectaculo(e);
			}
		});
		btnNewButton_1.setBounds(231, 278, 139, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("InfoFuncion");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datosFuncion(e);
			}
		});
		btnNewButton_2.setBounds(404, 278, 131, 23);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Cancelar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar(e);
			}
		});
		btnNewButton_3.setBounds(243, 329, 102, 23);
		getContentPane().add(btnNewButton_3);

	}

	protected void cargarFunciones(ActionEvent arg0) {
		String espectaculo=this.comboBoxEspectaculo.getSelectedItem().toString();
		ManejadorEspectaculos me=ManejadorEspectaculos.getInstancia();
		Espectaculo e=me.buscarEspectaculo(espectaculo);
		DefaultComboBoxModel<String> modelfunciones=new DefaultComboBoxModel<String>(e.listarFunciones());
		if(modelfunciones.getSize()==0) {
			this.comboBoxFuncion.setSelectedIndex(-1);
			this.textAreaFuncion.setText("");
		}else{
			comboBoxFuncion.setModel(modelfunciones);
		}
	}
	
	protected void datosPaquete(ActionEvent arg0) {
		this.textAreaPaquete.setText("");
		String paquete=this.comboBoxPaquete.getSelectedItem().toString();
		DtPaqueteEspectaculo dtp=icon.datosPaquete(paquete);
		this.textAreaPaquete.setText(dtp.toString());
	}
	
	
	
	protected void inicializarComboBox() {
		DefaultComboBoxModel<String> modelespaquetes = new DefaultComboBoxModel<String>(icon.listarPaquetes());
		comboBoxPaquete.setModel(modelespaquetes);
	}
	
	
	protected void datosEspectaculo(ActionEvent arg0) {
		this.textAreaEspectaculo.setText("");
		String espectaculo=this.comboBoxEspectaculo.getSelectedItem().toString();
		ManejadorEspectaculos me=ManejadorEspectaculos.getInstancia();
		Espectaculo e=me.buscarEspectaculo(espectaculo);
		DtEspectaculo dte=e.getDtEspectaculo();
		this.textAreaEspectaculo.setText(dte.toString());
	}
	
	
	protected void datosFuncion(ActionEvent arg0) {
		this.textAreaFuncion.setText("");
		String especatculo=this.comboBoxEspectaculo.getSelectedItem().toString();
		String funcion=this.comboBoxFuncion.getSelectedItem().toString();
	
		iconn.elegirEspecatculo(especatculo);
		DtFuncion dtf=iconn.selectFuncion(funcion);
		String datos="Informacion de la Funcion";
		datos=datos+"\n" + dtf.toString();
		textAreaFuncion.setText(datos);
	}
	
	
	
	
	protected void cancelar(ActionEvent arg0) {
		this.comboBoxFuncion.removeAllItems();
		this.comboBoxEspectaculo.removeAllItems();
		limpiarFormulario();
		setVisible(false);
	}
	
	
	protected void limpiarFormulario() {
		this.textAreaEspectaculo.setText("");
		this.textAreaFuncion.setText("");
		this.textAreaPaquete.setText("");
	}
	
	
	protected void cargarEspectaculos(ActionEvent arg0) {
		String paquete=comboBoxPaquete.getSelectedItem().toString();
		String[] nombresEspectaculos=icon.listarEspectaculos(paquete);
		if(nombresEspectaculos.length!=0) {
			DefaultComboBoxModel<String> modelespectaculo = new DefaultComboBoxModel<String>(icon.listarEspectaculos(paquete));
			comboBoxEspectaculo.setModel(modelespectaculo);
		}else {
			comboBoxEspectaculo.setSelectedIndex(-1);
		}
	
	}
}