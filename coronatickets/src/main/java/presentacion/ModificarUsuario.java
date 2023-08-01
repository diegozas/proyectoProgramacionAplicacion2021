package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import interfaces.ICModificarDatosUsuario;
import logica.Usuario;
import manejador.ManejadorUsuario;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;

import datatypes.DtUsuario;

import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class ModificarUsuario extends JInternalFrame {
	private ICModificarDatosUsuario icon;
	private static final long serialVersionUID = 1L;
	private JComboBox<String> comboBoxUsuario;
	private JTextArea textAreaUsuario;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldDia;
	private JTextField textFieldMes;
	private JTextField textFieldAnio;

	
	public ModificarUsuario(ICModificarDatosUsuario icon) {
		setTitle("Modificar Usuario");
		this.icon=icon;
		setIconifiable(true);
		setClosable(true);
		setMaximizable(true);
		setBounds(100, 100, 586, 321);
		getContentPane().setLayout(null);
		
		comboBoxUsuario = new JComboBox();
		comboBoxUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarDatos(e);
			}
		});
		comboBoxUsuario.setBounds(102, 24, 95, 22);
		getContentPane().add(comboBoxUsuario);
		
		JLabel lblNewLabel = new JLabel("Usuarios");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(21, 28, 71, 14);
		getContentPane().add(lblNewLabel);
		
		textAreaUsuario = new JTextArea();
		textAreaUsuario.setBounds(0, 76, 197, 85);
		getContentPane().add(textAreaUsuario);
		
		JButton btnNewButton = new JButton("Modificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarDatos(e);
			}
		});
		btnNewButton.setBounds(21, 258, 89, 23);
		getContentPane().add(btnNewButton);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(318, 78, 96, 20);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Datos que puede Cambiar");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(285, 44, 155, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(229, 81, 64, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Apellido");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(229, 118, 49, 14);
		getContentPane().add(lblNewLabel_3);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(318, 115, 96, 20);
		getContentPane().add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		textFieldDia = new JTextField();
		textFieldDia.setBounds(262, 170, 96, 20);
		getContentPane().add(textFieldDia);
		textFieldDia.setColumns(10);
		
		textFieldMes = new JTextField();
		textFieldMes.setBounds(262, 218, 96, 20);
		getContentPane().add(textFieldMes);
		textFieldMes.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Dia");
		lblNewLabel_4.setBounds(229, 173, 49, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Mes");
		lblNewLabel_5.setBounds(229, 221, 35, 14);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Anio");
		lblNewLabel_6.setBounds(391, 173, 49, 14);
		getContentPane().add(lblNewLabel_6);
		
		textFieldAnio = new JTextField();
		textFieldAnio.setBounds(436, 170, 96, 20);
		getContentPane().add(textFieldAnio);
		textFieldAnio.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar(e);
			}
		});
		btnNewButton_1.setBounds(131, 258, 89, 23);
		getContentPane().add(btnNewButton_1);

	}
	
	
	protected void modificarDatos(ActionEvent arg0) {
		String usuario=this.comboBoxUsuario.getSelectedItem().toString();
		String nombre=this.textFieldNombre.getText();
		String apellido=this.textFieldApellido.getText();
		String dia=this.textFieldDia.getText();
		String mes=this.textFieldMes.getText();
		String anio=this.textFieldAnio.getText();
		Date fechaModificar;
		int diaUsuario;
		int mesUsuario;
		int anioUsuario;
		if(!dia.isEmpty()&&!mes.isEmpty()&&!anio.isEmpty()) {
			diaUsuario = Integer.parseInt(dia);
			mesUsuario = Integer.parseInt(mes);
			anioUsuario = Integer.parseInt(anio);
			anioUsuario=anioUsuario-1900;
			fechaModificar=new Date(anioUsuario,mesUsuario-1,diaUsuario);
		}else {
			diaUsuario = 0;
			mesUsuario = 0;
			anioUsuario=0;
			fechaModificar=new Date(0,0,0);
		}
		
		
		ManejadorUsuario mu=ManejadorUsuario.getInstancia();
		Usuario u=mu.getUsuario(usuario);
		DtUsuario dtu=new DtUsuario(u.getNickname(),nombre,apellido,u.getCorreoElectronico(),fechaModificar);
		icon.modificarDatos(usuario, dtu);
		JOptionPane.showMessageDialog(this, "Se modificaron los datos correctamente", "Modificar datos Usaurio", JOptionPane.INFORMATION_MESSAGE);
		limpiarFormulario();
		setVisible(false);
		
	}
	
	protected void inicializarComboBox() {
		DefaultComboBoxModel<String> modelUsuario = new DefaultComboBoxModel<String>(icon.nickUsuarios());
		comboBoxUsuario.setModel(modelUsuario);
	}
	
	protected void cancelar(ActionEvent arg0) {
		limpiarFormulario();
		setVisible(false);
	}
	
	protected void limpiarFormulario() {
		this.textAreaUsuario.setText("");
		this.textFieldDia.setText("");
		this.textFieldMes.setText("");
		this.textFieldAnio.setText("");
		this.textFieldNombre.setText("");
		this.textFieldApellido.setText("");
	}
	
	
	
	protected void mostrarDatos(ActionEvent arg0) {
		this.textAreaUsuario.setText("");
		String nick=this.comboBoxUsuario.getSelectedItem().toString();
		DtUsuario dtu=icon.datosUsuario(nick);
		this.textAreaUsuario.setText(dtu.toStringBasico());
	}
	
}
