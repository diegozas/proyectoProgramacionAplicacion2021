package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import interfaces.IControladorAltaPlataforma;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import excepciones.PlataformaRepetidaExcepcion;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaPlataforma extends JInternalFrame {
	private IControladorAltaPlataforma icon;
	private JTextField textoNombre;
	private JTextField textoDesc;
	private JTextField textoUrl;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaPlataforma frame = new AltaPlataforma();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public AltaPlataforma(IControladorAltaPlataforma icon) {
		setClosable(true);
		setTitle("Alta Plataforma");
		this.icon=icon;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 37, 49, 14);
		getContentPane().add(lblNewLabel);
		
		textoNombre = new JTextField();
		textoNombre.setBounds(69, 34, 96, 20);
		getContentPane().add(textoNombre);
		textoNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Descripcion");
		lblNewLabel_1.setBounds(10, 76, 64, 14);
		getContentPane().add(lblNewLabel_1);
		
		textoDesc = new JTextField();
		textoDesc.setBounds(69, 73, 96, 20);
		getContentPane().add(textoDesc);
		textoDesc.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("url");
		lblNewLabel_2.setBounds(38, 118, 21, 14);
		getContentPane().add(lblNewLabel_2);
		
		textoUrl = new JTextField();
		textoUrl.setBounds(69, 115, 96, 20);
		getContentPane().add(textoUrl);
		textoUrl.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkFormulario()) {
				altaPlataforma(e);
			}
		}
		});
		btnNewButton.setBounds(38, 191, 96, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(171, 191, 89, 23);
		getContentPane().add(btnNewButton_1);
		
	}
	
	
	
	
	protected void altaPlataforma(ActionEvent arg0) {
		String nombre=textoNombre.getText();
		String desc=textoDesc.getText();
		String url= textoUrl.getText();
		icon.ingresarDatos(nombre, desc, url);
		try {
			icon.altaPlataforma();
			JOptionPane.showMessageDialog(this, "Se agrego la Plataforma correctamente", "Agregar Plataforma", JOptionPane.INFORMATION_MESSAGE);
			limpiarFormulario();
			setVisible(false);
		}catch(PlataformaRepetidaExcepcion e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Agregar Plataforma", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void limpiarFormulario() {
		textoNombre.setText("");
		textoDesc.setText("");
		textoUrl.setText("");
	}
	
	
	private boolean checkFormulario() {
		String nombre=textoNombre.getText();
		String desc=textoDesc.getText();
		String url= textoUrl.getText();
		if(nombre.isEmpty()||desc.isEmpty()||url.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No pueden quedar campos vacios", "Alta Plataforma", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	
}
