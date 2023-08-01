package presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JTextPane;

import datatypes.DtFuncion;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import interfaces.IControladorConsultaEspectaculo;
import logica.Espectaculo;
import logica.Funcion;
import logica.Plataforma;
import manejador.ManejadorEspectaculos;
import manejador.ManejadorPlataforma;
import java.awt.event.ActionListener;

public class ConsultaEspectaculo extends JInternalFrame {
	
	private JTextField nombre;
	private JTextField artista;
	private JTextField duracion;
	private JTextField costo;
	private JTextField minEsp;
	private JTextField maxEsp;
	private JTextField link;
	private JComboBox<String> espectaculos;
	private JComboBox<String> plataformas;
	private JComboBox<String> funciones;
	private JTextArea descripcion;
	private IControladorConsultaEspectaculo icon;
	private JButton btnVer;
	private JTextArea dataFuncion;
	

	public ConsultaEspectaculo(IControladorConsultaEspectaculo icon) {
		setClosable(true);
		this.icon=icon;
		setBounds(100, 100, 666, 564);
		getContentPane().setLayout(null);
		
		nombre = new JTextField();
		nombre.setEditable(false);
		nombre.setBounds(124, 63, 116, 22);
		getContentPane().add(nombre);
		nombre.setColumns(10);
		
		artista = new JTextField();
		artista.setEditable(false);
		artista.setBounds(124, 98, 116, 22);
		getContentPane().add(artista);
		artista.setColumns(10);
		
		duracion = new JTextField();
		duracion.setEditable(false);
		duracion.setBounds(124, 133, 116, 22);
		getContentPane().add(duracion);
		duracion.setColumns(10);
		
		costo = new JTextField();
		costo.setEditable(false);
		costo.setBounds(124, 168, 116, 22);
		getContentPane().add(costo);
		costo.setColumns(10);
		
		minEsp = new JTextField();
		minEsp.setEditable(false);
		minEsp.setBounds(124, 203, 116, 22);
		getContentPane().add(minEsp);
		minEsp.setColumns(10);
		
		maxEsp = new JTextField();
		maxEsp.setEditable(false);
		maxEsp.setBounds(124, 238, 116, 22);
		getContentPane().add(maxEsp);
		maxEsp.setColumns(10);
		
		descripcion = new JTextArea();
		descripcion.setEditable(false);
		descripcion.setBounds(285, 98, 231, 154);
		getContentPane().add(descripcion);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(38, 66, 56, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Artista");
		lblNewLabel_1.setBounds(38, 101, 56, 16);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Duracion");
		lblNewLabel_2.setBounds(38, 136, 56, 16);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Costo");
		lblNewLabel_3.setBounds(38, 171, 56, 16);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Min.Espectadores");
		lblNewLabel_4.setBounds(12, 206, 116, 16);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Max.Espectadores");
		lblNewLabel_5.setBounds(12, 241, 127, 19);
		getContentPane().add(lblNewLabel_5);
		
		link = new JTextField();
		link.setEditable(false);
		link.setBounds(124, 272, 116, 22);
		getContentPane().add(link);
		link.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Link");
		lblNewLabel_6.setBounds(38, 273, 56, 16);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Descripcion");
		lblNewLabel_7.setBounds(346, 66, 127, 16);
		getContentPane().add(lblNewLabel_7);
		
		funciones = new JComboBox();
		funciones.setBounds(373, 272, 121, 22);
		getContentPane().add(funciones);
		
		JLabel lblNewLabel_8 = new JLabel("Funciones");
		lblNewLabel_8.setBounds(285, 275, 66, 16);
		getContentPane().add(lblNewLabel_8);
		
		JButton btnVerFuncion = new JButton("Ver funcion");
		btnVerFuncion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				infoFuncion(e);
			}
		});
		btnVerFuncion.setBounds(521, 271, 103, 25);
		getContentPane().add(btnVerFuncion);
		
		espectaculos = new JComboBox();
		espectaculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnVer.setEnabled(true);
			}
		});
		espectaculos.setBounds(330, 13, 116, 22);
		getContentPane().add(espectaculos);
		
		plataformas = new JComboBox();
		plataformas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarEspectaculos(e);
			}
		});
		plataformas.setBounds(124, 13, 116, 22);
		getContentPane().add(plataformas);
		
		JLabel lblNewLabel_9 = new JLabel("Plataforma");
		lblNewLabel_9.setBounds(12, 16, 90, 16);
		getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Espectaculo");
		lblNewLabel_10.setBounds(252, 16, 83, 16);
		getContentPane().add(lblNewLabel_10);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				setVisible(false);
			}
		});
		btnSalir.setBounds(100, 348, 97, 25);
		getContentPane().add(btnSalir);
		
		btnVer = new JButton("Ver");
		btnVer.setEnabled(false);
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEspectaculo(e);
				listarFunciones(e);
			}
		});
		btnVer.setBounds(460, 12, 56, 25);
		getContentPane().add(btnVer);
		
		dataFuncion = new JTextArea();
		dataFuncion.setEditable(false);
		dataFuncion.setBounds(295, 309, 258, 168);
		getContentPane().add(dataFuncion);

	}
	
	public void inicializarComboBoxes() {
		DefaultComboBoxModel<String> modelplataforma = new DefaultComboBoxModel<String>(icon.listarPlataforma());
		plataformas.setModel(modelplataforma);
			
	}
	
	protected void listarEspectaculos(ActionEvent arg0) {
		String plataforma = this.plataformas.getSelectedItem().toString();
		ManejadorPlataforma mp=ManejadorPlataforma.getInstancia();
		Plataforma p=mp.getPlataforma(plataforma);
		
		DefaultComboBoxModel<String> modelespectaculo = new DefaultComboBoxModel<String>(p.listarEspectaculos());
		espectaculos.setModel(modelespectaculo);
		
	}
	
	protected void listarFunciones(ActionEvent arg0) {
		String espectaculo=this.espectaculos.getSelectedItem().toString();
		ManejadorEspectaculos me=ManejadorEspectaculos.getInstancia();
		Espectaculo e=me.buscarEspectaculo(espectaculo);
		DefaultComboBoxModel<String> modelfunciones=new DefaultComboBoxModel<String>(e.listarFunciones());
		funciones.setModel(modelfunciones);
	}
	
	protected void cargarEspectaculo(ActionEvent arg0) {
		limpiarr();
		String espectaculo=this.espectaculos.getSelectedItem().toString();
		ManejadorEspectaculos me=ManejadorEspectaculos.getInstancia();
		Espectaculo e=me.buscarEspectaculo(espectaculo);		
		 this.nombre.setText(e.getNombre());;
		 this.artista.setText(e.getArtista().getNickname());;
		 this.duracion.setText(String.valueOf(e.getDuracion()));;
		 this.costo.setText(String.valueOf(e.getCosto()));;
		 this.minEsp.setText(String.valueOf(e.getCantMin()));;
		 this.maxEsp.setText(String.valueOf(e.getCantMax()));;
		 this.link.setText(e.getUrl());;
		 this.descripcion.setText(e.getDescripcion());;
	}
	protected void infoFuncion(ActionEvent arg0) {
		String espectaculo=this.espectaculos.getSelectedItem().toString();
		ManejadorEspectaculos me=ManejadorEspectaculos.getInstancia();
		Espectaculo e=me.buscarEspectaculo(espectaculo);
		Funcion f=e.getFuncion(funciones.getSelectedItem().toString());
		DtFuncion dtf=f.getDtFuncion();
		dataFuncion.setText(dtf.toString());		
	}
	
	private void limpiar() {
		 this.nombre.setText("");;
		 this.artista.setText("");;
		 this.duracion.setText("");;
		 this.costo.setText("");;
		 this.minEsp.setText("");;
		 this.maxEsp.setText("");;
		 this.link.setText("");;
		 this.descripcion.setText("");;
		 funciones.removeAllItems();
		 espectaculos.removeAllItems();
		 this.dataFuncion.setText("");
	}
	
	private void limpiarr() {
		 this.nombre.setText("");;
		 this.artista.setText("");;
		 this.duracion.setText("");;
		 this.costo.setText("");;
		 this.minEsp.setText("");;
		 this.maxEsp.setText("");;
		 this.link.setText("");;
		 this.descripcion.setText("");;
		 this.dataFuncion.setText("");
	}
}
