package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import interfaces.ICAaltaPaqueteEspectaculo;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import datatypes.DtPaqueteEspectaculo;
import excepciones.PaqueteEspectaculoRepetidoExcepcion;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class AltaPaqueteEspectaculo extends JInternalFrame {
	ICAaltaPaqueteEspectaculo icon;
	private JTextField textNombre;
	private JTextField textDiaInicio;
	private JTextField textMesInicio;
	private JTextField textAnioInicio;
	private JTextField textDiaFin;
	private JTextField textMesFin;
	private JTextField textAnioFin;
	private JTextField textDescuento;
	private JTextArea textAreaDescripcion;


	
	public AltaPaqueteEspectaculo(ICAaltaPaqueteEspectaculo icon) {
		
		setTitle("Paquete Espectaculo");
		setIconifiable(true);
		setClosable(true);
		setMaximizable(true);
		this.icon=icon;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 21, 70, 14);
		getContentPane().add(lblNewLabel);
		
		textNombre = new JTextField();
		textNombre.setBounds(90, 19, 96, 20);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Descipcion");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(289, 38, 89, 14);
		getContentPane().add(lblNewLabel_1);
		
		textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setBounds(265, 63, 148, 123);
		getContentPane().add(textAreaDescripcion);
		
		textDiaInicio = new JTextField();
		textDiaInicio.setBounds(39, 93, 41, 20);
		getContentPane().add(textDiaInicio);
		textDiaInicio.setColumns(10);
		
		textMesInicio = new JTextField();
		textMesInicio.setBounds(119, 93, 48, 20);
		getContentPane().add(textMesInicio);
		textMesInicio.setColumns(10);
		
		textAnioInicio = new JTextField();
		textAnioInicio.setBounds(214, 93, 41, 20);
		getContentPane().add(textAnioInicio);
		textAnioInicio.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha Inicio");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(89, 68, 78, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Dia");
		lblNewLabel_3.setBounds(10, 96, 29, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mes");
		lblNewLabel_4.setBounds(90, 96, 49, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Anio");
		lblNewLabel_5.setBounds(177, 96, 29, 14);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Fecha FIn");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(84, 137, 83, 14);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Dia");
		lblNewLabel_7.setBounds(10, 172, 29, 14);
		getContentPane().add(lblNewLabel_7);
		
		textDiaFin = new JTextField();
		textDiaFin.setBounds(39, 172, 41, 20);
		getContentPane().add(textDiaFin);
		textDiaFin.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Mes");
		lblNewLabel_8.setBounds(90, 175, 29, 14);
		getContentPane().add(lblNewLabel_8);
		
		textMesFin = new JTextField();
		textMesFin.setBounds(119, 169, 29, 20);
		getContentPane().add(textMesFin);
		textMesFin.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Anio");
		lblNewLabel_9.setBounds(158, 172, 29, 14);
		getContentPane().add(lblNewLabel_9);
		
		textAnioFin = new JTextField();
		textAnioFin.setBounds(195, 169, 34, 20);
		getContentPane().add(textAnioFin);
		textAnioFin.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Descuento");
		lblNewLabel_10.setBounds(10, 224, 89, 14);
		getContentPane().add(lblNewLabel_10);
		
		textDescuento = new JTextField();
		textDescuento.setBounds(10, 249, 54, 20);
		getContentPane().add(textDescuento);
		textDescuento.setColumns(10);
		
		JButton btnNewButton = new JButton("Crear Paquete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaPaquete(e);
			}
		});
		btnNewButton.setBounds(135, 224, 130, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar(e);
			}
		});
		btnNewButton_1.setBounds(289, 224, 89, 23);
		getContentPane().add(btnNewButton_1);

	}
	
	
	protected void altaPaquete(ActionEvent arg0) {
		String nombre=this.textNombre.getText();
		String descripcion=this.textAreaDescripcion.getText();
		String diaInicio=this.textDiaInicio.getText();
		String mesInicio=this.textMesInicio.getText();
		String anioInicio=this.textAnioInicio.getText();
		String diaFin=this.textDiaFin.getText();
		String mesFin=this.textMesFin.getText();
		String anioFin=this.textAnioFin.getText();
		String descuento=this.textDescuento.getText();
		
		int diaPaqueteInicio = Integer.parseInt(diaInicio);
		int mesPaqueteInicio = Integer.parseInt(mesInicio);
		int anioPaqueteInicio = Integer.parseInt(anioInicio);
		
		int diaPaqueteFin = Integer.parseInt(diaFin);
		int mesPaqueteFin = Integer.parseInt(mesFin);
		int anioPaqueteFin = Integer.parseInt(anioFin);
		
		float des=Float.parseFloat(descuento);
		
		anioPaqueteInicio=anioPaqueteInicio-1900;
		anioPaqueteFin=anioPaqueteFin-1900;
		
		Date fechaInicio= new Date(anioPaqueteInicio,mesPaqueteInicio-1,diaPaqueteInicio); 
		Date fechaFin= new Date(anioPaqueteFin,mesPaqueteFin-1,diaPaqueteFin); 
		Date fechaAlta=new Date();
		
		DtPaqueteEspectaculo dtp=new DtPaqueteEspectaculo(nombre,descripcion,des,fechaInicio,fechaFin);
		icon.ingresarDatos(dtp, fechaAlta);
		try {
			icon.altaPaqueteEspectaculo();
			JOptionPane.showMessageDialog(this, "El paquete se agrego correctamente", "Agregar Paquete", JOptionPane.INFORMATION_MESSAGE);
			limpiarFormulario();
			setVisible(false);
		}catch(PaqueteEspectaculoRepetidoExcepcion e1) {
			JOptionPane.showMessageDialog(this, e1.getMessage(), "Agregar Paquete", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	
	
	
	protected void cancelar(ActionEvent arg0) {
		limpiarFormulario();
		setVisible(false);
	}
	protected void limpiarFormulario() {
		this.textNombre.setText("");
		this.textDescuento.setText("");
		this.textAreaDescripcion.setText("");
		this.textDiaInicio.setText("");
		this.textMesInicio.setText("");
		this.textAnioInicio.setText("");
		this.textDiaFin.setText("");
		this.textMesFin.setText("");
		this.textAnioFin.setText("");
	}
}
