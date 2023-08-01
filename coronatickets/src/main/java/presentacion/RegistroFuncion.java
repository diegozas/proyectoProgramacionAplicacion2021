package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import interfaces.ICRegistroFuncion;
import logica.Espectador;
import logica.Funcion;
import manejador.ManejadorUsuario;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import excepciones.ExisteRegistroExcepcion;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistroFuncion extends JInternalFrame {
	private ICRegistroFuncion icon;
	private JComboBox<String> comboBoxPlataforma;
	private JComboBox<String> comboBoxEspectaculos;
	private JComboBox<String> comboBoxEspectador;
	private JComboBox<String> comboBoxCanje;
	private List<String> funciones=new ArrayList<String>();
	private JComboBox<String> comboBoxFuncion;
	
	public RegistroFuncion(ICRegistroFuncion icon) {
		this.icon=icon;
		setIconifiable(true);
		setClosable(true);
		setMaximizable(true);
		setTitle("Registro Funcion");
		setBounds(100, 100, 528, 304);
		getContentPane().setLayout(null);
		
		comboBoxPlataforma = new JComboBox();
		comboBoxPlataforma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarEspectaculos(e);
			}
		});
		comboBoxPlataforma.setBounds(91, 27, 119, 22);
		getContentPane().add(comboBoxPlataforma);
		
		JLabel lblNewLabel = new JLabel("Plataformas");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 30, 78, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Espectaculos");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 109, 78, 14);
		getContentPane().add(lblNewLabel_1);
		
		comboBoxEspectaculos = new JComboBox();
		comboBoxEspectaculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarFunciones(e);
			}
		});
		comboBoxEspectaculos.setBounds(96, 106, 114, 22);
		getContentPane().add(comboBoxEspectaculos);
		
		JLabel lblNewLabel_2 = new JLabel("Espectadores");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(238, 30, 102, 14);
		getContentPane().add(lblNewLabel_2);
		
		comboBoxEspectador = new JComboBox();
		comboBoxEspectador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarFuncionesCanje(e);
			}
		});
		comboBoxEspectador.setBounds(350, 27, 127, 22);
		getContentPane().add(comboBoxEspectador);
		
		JLabel lblNewLabel_3 = new JLabel("Funciones");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 186, 78, 14);
		getContentPane().add(lblNewLabel_3);
		
		comboBoxFuncion = new JComboBox();
		comboBoxFuncion.setBounds(96, 183, 114, 22);
		getContentPane().add(comboBoxFuncion);
		
		comboBoxCanje = new JComboBox();
		comboBoxCanje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarFuncionCanje(e);
			}
		});
		comboBoxCanje.setBounds(363, 106, 114, 22);
		getContentPane().add(comboBoxCanje);
		
		JLabel lblNewLabel_4 = new JLabel("Funciones Canje");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(244, 110, 109, 14);
		getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Registro");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registroFuncion(e);
				
			}
		});
		btnNewButton.setBounds(366, 218, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar(e);
			}
		});
		btnNewButton_1.setBounds(251, 218, 89, 23);
		getContentPane().add(btnNewButton_1);

	}



	protected void agregarFuncionCanje(ActionEvent arg0) {
		String funcion=comboBoxCanje.getSelectedItem().toString();
		this.funciones.add(funcion);
		JOptionPane.showMessageDialog(this, "Se agrego la Funcion " + funcion+" para poder canjear", "Registro Funcion",
                JOptionPane.INFORMATION_MESSAGE);
	}

	protected void listarFunciones(ActionEvent arg0) {
		String espectaculo=comboBoxEspectaculos.getSelectedItem().toString();
		DefaultComboBoxModel<String> modelefunciones = new DefaultComboBoxModel<String>(icon.funcionesEspectaculo(espectaculo));
		comboBoxFuncion.setModel(modelefunciones);
	}

	protected void listarEspectaculos(ActionEvent arg0) {
		String plataforma=comboBoxPlataforma.getSelectedItem().toString();
		DefaultComboBoxModel<String> modelespectaculo = new DefaultComboBoxModel<String>(icon.espectaculosPlataforma(plataforma));
		comboBoxEspectaculos.setModel(modelespectaculo);
	}


	protected void inicializarComboBoxes() {
		DefaultComboBoxModel<String> modelUsuario = new DefaultComboBoxModel<String>(icon.listarEspectadores());
		comboBoxEspectador.setModel(modelUsuario);
		DefaultComboBoxModel<String> modelplataforma = new DefaultComboBoxModel<String>(icon.listarPlataformas());
		comboBoxPlataforma.setModel(modelplataforma);
	}


	protected void listarFuncionesCanje(ActionEvent arg0) {
		String espectador=comboBoxEspectador.getSelectedItem().toString();
		ManejadorUsuario mu=ManejadorUsuario.getInstancia();
		Espectador esp=mu.buscarEspectador(espectador);
		DefaultComboBoxModel<String> modelfuncioncanje = new DefaultComboBoxModel<String>(esp.getFuncionesSinCanjear());
		comboBoxCanje.setModel(modelfuncioncanje);
	}


	
	protected void registroFuncion(ActionEvent arg0) {
		String usuario=comboBoxEspectador.getSelectedItem().toString();
		String espectaculo=comboBoxEspectaculos.getSelectedItem().toString();
		String funcion=comboBoxFuncion.getSelectedItem().toString();
		ManejadorUsuario mu=ManejadorUsuario.getInstancia();
		if(this.funciones.isEmpty()) {
			try {
				icon.registroFuncion(usuario, espectaculo, funcion);
				JOptionPane.showMessageDialog(this, "Se registro a la Funcion "+funcion+" correctamente", "Registro Funcion", JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);
			} catch (ExisteRegistroExcepcion e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Registro Funcion", JOptionPane.ERROR_MESSAGE);
			}
		}else if(this.funciones.size()!=0 && this.funciones.size()<3) {
			this.funciones.clear();
			JOptionPane.showMessageDialog(this, "se deben ingresar 3 funciones para realizar el canje", "Registro Funcion", JOptionPane.ERROR_MESSAGE);
		}else if(this.funciones.size()==3) {
			try {
				icon.registroFuncion(usuario, espectaculo, funcion);
				JOptionPane.showMessageDialog(this, "Se registro a la Funcion "+funcion+" correctamente", "Registro Funcion", JOptionPane.INFORMATION_MESSAGE);
				Espectador esp=mu.buscarEspectador(usuario);
				for(String s: this.funciones) {
					Funcion f=esp.getFuncion(s);
					f.setCanjeado(true);
				}
				this.funciones.clear();
				setVisible(false);
			} catch (ExisteRegistroExcepcion e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Registro Funcion", JOptionPane.ERROR_MESSAGE);
			}
		}
	
	
	
	
	}
	
	
	
	protected void cancelar(ActionEvent arg0) {
		setVisible(false);
	}



}
