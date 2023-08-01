package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import interfaces.IControladorAltaEspectaculo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SpinnerNumberModel;

import datatypes.DtEspectaculo;
import excepciones.EspectaculoRepetidoExcepcion;

import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

public class AltaEspectaculo extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nombreEspectaculo;
	private JTextField link;
	private JTextField costo;
	private JComboBox<String> plataformas;
	private JComboBox<String> artistas;
	private IControladorAltaEspectaculo icon;
	private JTextField maxEspectadores ;
	private JTextField minEspectadores;
	private JTextField duracion;
	private JTextArea descripcion;
	public AltaEspectaculo(IControladorAltaEspectaculo icon) {
		setTitle("Alta Espectaculo");
		setIconifiable(true);
		setClosable(true);
		setMaximizable(true);
		this.icon=icon;
		setBounds(100, 100, 589, 461);
		getContentPane().setLayout(null);
		
		nombreEspectaculo = new JTextField();
		nombreEspectaculo.setBounds(86, 95, 116, 22);
		getContentPane().add(nombreEspectaculo);
		nombreEspectaculo.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 98, 56, 16);
		getContentPane().add(lblNombre);
		
		descripcion = new JTextArea();
		descripcion.setBounds(12, 169, 189, 128);
		getContentPane().add(descripcion);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(12, 140, 124, 16);
		getContentPane().add(lblDescripcion);
		
		JLabel lblLink = new JLabel("Link");
		lblLink.setBounds(298, 140, 56, 16);
		getContentPane().add(lblLink);
		
		link = new JTextField();
		link.setBounds(379, 140, 116, 22);
		getContentPane().add(link);
		link.setColumns(10);
		
		costo = new JTextField();
		costo.setBounds(379, 95, 116, 22);
		getContentPane().add(costo);
		costo.setColumns(10);
		
		JLabel lblCosto = new JLabel("Costo");
		lblCosto.setBounds(298, 98, 56, 16);
		getContentPane().add(lblCosto);
		
		minEspectadores = new JTextField();
		minEspectadores.setBounds(433, 194, 62, 22);
		getContentPane().add(minEspectadores);
		
		maxEspectadores = new JTextField();
		maxEspectadores.setBounds(433, 229, 62, 22);
		getContentPane().add(maxEspectadores);
		
		JLabel lblMinEspectadores = new JLabel("Min. Espectaores");
		lblMinEspectadores.setBounds(298, 197, 110, 16);
		getContentPane().add(lblMinEspectadores);
		
		JLabel lblMaxEspectadores = new JLabel("Max.Espectadores");
		lblMaxEspectadores.setBounds(298, 232, 56, 16);
		getContentPane().add(lblMaxEspectadores);
		
		plataformas = new JComboBox<String>();
		plataformas.setBounds(379, 285, 116, 22);
		getContentPane().add(plataformas);
		
		JLabel lblPlataforma = new JLabel("Plataforma");
		lblPlataforma.setBounds(298, 288, 69, 16);
		getContentPane().add(lblPlataforma);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent esp) {
				if(controlarFormulario()) {
					altaEspectaculoActionPerformed(esp);
				}
			}
		});
		btnCrear.setBounds(450, 387, 97, 25);
		getContentPane().add(btnCrear);
		
		artistas = new JComboBox<String>();
		artistas.setBounds(379, 320, 116, 22);
		getContentPane().add(artistas);
		
		JLabel lblArtista = new JLabel("Artista");
		lblArtista.setBounds(298, 323, 56, 16);
		getContentPane().add(lblArtista);
		
		JLabel lblNewLabel_1 = new JLabel("Alta espectaculo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(409, 13, 152, 16);
		getContentPane().add(lblNewLabel_1);
		
		duracion = new JTextField();
		duracion.setBounds(86, 320, 116, 22);
		getContentPane().add(duracion);
		duracion.setColumns(10);
		
		JLabel lblDuracion = new JLabel("duracion");
		lblDuracion.setBounds(12, 323, 56, 16);
		getContentPane().add(lblDuracion);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelarAltaEspectaculo(e);
			}
		});
		btnNewButton.setBounds(275, 388, 89, 23);
		getContentPane().add(btnNewButton);

	}
	public void inicializarComboBoxes() {
		DefaultComboBoxModel<String> modelplataforma = new DefaultComboBoxModel<String>(icon.listarPlataforma());
		plataformas.setModel(modelplataforma);
		
		DefaultComboBoxModel<String> modelartistas = new DefaultComboBoxModel<String>(icon.listarArtistas());
		artistas.setModel(modelartistas);		
	}
	
	private void limpiarFormulario() {
        nombreEspectaculo.setText("");     
		duracion.setText("");
		descripcion.setText("");
		costo.setText("");
		minEspectadores.setText("");
		maxEspectadores.setText("");
		link.setText("");
 }
	private boolean controlarFormulario() {
		String costo = this.costo.getText();
		String minEsp=this.minEspectadores.getText();
		String maxEsp=this.maxEspectadores.getText();
		String nombre=this.nombreEspectaculo.getText();
		String desc=this.descripcion.getText();
		String duracion=this.duracion.getText();
		String link=this.link.getText();
		if(costo.isEmpty() || minEsp.isEmpty() || maxEsp.isEmpty() || nombre.isEmpty() || desc.isEmpty() || link.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No pueden quedar campos vacios", "Alta espectaculo", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		try {
			Float.parseFloat(costo);
			try {
				Integer.parseInt(minEsp);
				try {
					Integer.parseInt(maxEsp);
					try {
						Integer.parseInt(duracion);
					}catch(NumberFormatException e) {
						JOptionPane.showMessageDialog(this, "La duracion no puede contener letras", "Alta Espectaculo",
			                    JOptionPane.ERROR_MESSAGE);
					}
				}catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(this, "El maximo de espectadores debe ser numerico", "Alta Espectaculo",
		                    JOptionPane.ERROR_MESSAGE);
				}
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "El minimo de espectadores debe ser numerico", "Alta Espectaculo",
	                    JOptionPane.ERROR_MESSAGE);
			}
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(this, "El costo no debe ser con letras", "Alta Espectaculo",
                    JOptionPane.ERROR_MESSAGE);
            return false;
		}
		int min=Integer.parseInt(minEsp);
		int max=Integer.parseInt(maxEsp);
		int dur=Integer.parseInt(duracion);
		if(max < min) {
			JOptionPane.showMessageDialog(this, "El maximo de espectadores no puede ser menor que el minimo", "Alta Espectaculo",
                    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(dur<1) {
			JOptionPane.showMessageDialog(this, "La duracion no puede ser menor a 1", "Alta Espectaculo",
                    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;		
	}
	
	
	protected void cancelarAltaEspectaculo(ActionEvent arg0) {
		limpiarFormulario();
		setVisible(false);
	}
	
	
	
	
	protected void altaEspectaculoActionPerformed(ActionEvent arg0) {
		 String nombre =this.nombreEspectaculo.getText();
		 String artista =this.artistas.getSelectedItem().toString();
		 String plataforma=this.plataformas.getSelectedItem().toString();
		 int duracionEsp=Integer.parseInt(duracion.getText());
		 int min=Integer.parseInt(minEspectadores.getText());
		 int max=Integer.parseInt(maxEspectadores.getText());
		 String linkEsp=this.link.getText();
		 Date fechaAlta=new Date();
		 float costo=Float.parseFloat(this.costo.getText());
		 String descripcion=this.descripcion.getText();
		 DtEspectaculo dtEspectaculo=new DtEspectaculo(nombre,artista,plataforma,duracionEsp,min,max,linkEsp,fechaAlta,costo,descripcion);	
		 icon.ingresarDatos(dtEspectaculo);
		 try {
			 icon.altaEspectaculo();
			 JOptionPane.showMessageDialog(this, "El espectaculo se agrego correctamente", "Agregar Espectaculo", JOptionPane.INFORMATION_MESSAGE);
			 limpiarFormulario();
			 setVisible(false);
		 }catch(EspectaculoRepetidoExcepcion e){
			 JOptionPane.showMessageDialog(this, e.getMessage(), "Agregar Espectaculo", JOptionPane.ERROR_MESSAGE);			 
		 }
	}
}
