package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import datatypes.DtFuncion;
import excepciones.FuncionRepetidaExcepcion;
import interfaces.ICAltaFuncionEspectaculo;
import logica.Espectaculo;
import logica.Plataforma;
import manejador.ManejadorPlataforma;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;

import java.awt.Font;

public class AltaFuncionEspectaculo extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private ICAltaFuncionEspectaculo icon;
	private JTextField nombreFuncion;
	private JTextField diaTexto;
	private JTextField mesTexto;
	private JTextField anioTexto;
	private JTextField textoHora;
	private JTextField textoMinuto;
	private JComboBox<String> comboBoxPlataforma;
	private JComboBox<String> comboBoxArtistas;
	private JComboBox<String> comboBoxEspectaculo;
	private List<String> artistasInvitados=new ArrayList<>();
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaFuncionEspectaculo frame = new AltaFuncionEspectaculo();
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
	public AltaFuncionEspectaculo(ICAltaFuncionEspectaculo icon) {
		this.icon=icon;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
		setBounds(100, 100, 512, 405);
		getContentPane().setLayout(null);
		setTitle("Agregar una Funcion");
		JLabel lblNewLabel = new JLabel("Plataforma");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 32, 74, 25);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Espectaculo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 75, 74, 20);
		getContentPane().add(lblNewLabel_1);
		
		comboBoxEspectaculo = new JComboBox<String>();
		comboBoxEspectaculo.setBounds(82, 79, 130, 25);
		getContentPane().add(comboBoxEspectaculo);
		
		JLabel dia = new JLabel("Nombre");
		dia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		dia.setBounds(10, 140, 62, 14);
		getContentPane().add(dia);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkFormulario()) {
					altaFuncionActionPerformed(e);	
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(65, 301, 96, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelarAltaFuncionActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBounds(213, 301, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		nombreFuncion = new JTextField();
		nombreFuncion.setBounds(58, 137, 96, 20);
		getContentPane().add(nombreFuncion);
		nombreFuncion.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Artistas");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(271, 37, 49, 14);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_2 = new JLabel("Dia");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 183, 49, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mes");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 208, 49, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Anio");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(10, 233, 49, 14);
		getContentPane().add(lblNewLabel_4);
		
		diaTexto = new JTextField();
		diaTexto.setBounds(37, 180, 96, 20);
		getContentPane().add(diaTexto);
		diaTexto.setColumns(10);
		
		mesTexto = new JTextField();
		mesTexto.setBounds(37, 205, 96, 20);
		getContentPane().add(mesTexto);
		mesTexto.setColumns(10);
		
		anioTexto = new JTextField();
		anioTexto.setBounds(37, 230, 96, 20);
		getContentPane().add(anioTexto);
		anioTexto.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Hora");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(143, 183, 49, 14);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Minuto");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(143, 219, 49, 14);
		getContentPane().add(lblNewLabel_7);
		
		textoHora = new JTextField();
		textoHora.setBounds(176, 180, 96, 20);
		getContentPane().add(textoHora);
		textoHora.setColumns(10);
		
		textoMinuto = new JTextField();
		textoMinuto.setBounds(191, 217, 96, 20);
		getContentPane().add(textoMinuto);
		textoMinuto.setColumns(10);
		
		comboBoxArtistas = new JComboBox<String>();
		comboBoxArtistas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarArtistaInvitadoActionPerformed(e);
			}
		});
		comboBoxArtistas.setBounds(330, 34, 112, 22);
		getContentPane().add(comboBoxArtistas);
		
		comboBoxPlataforma = new JComboBox<String>();
		comboBoxPlataforma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarEspectaculosDePlataformaActionPerformed(e); 
			}
		});
		comboBoxPlataforma.setBounds(82, 34, 130, 22);
		getContentPane().add(comboBoxPlataforma);

	}
	
	public void inicializarComboBoxes() {
		DefaultComboBoxModel<String> modelplataforma = new DefaultComboBoxModel<String>(icon.listarPlataforma());
		comboBoxPlataforma.setModel(modelplataforma);
		
		DefaultComboBoxModel<String> modelartistas = new DefaultComboBoxModel<String>(icon.listarArtistas());
		comboBoxArtistas.setModel(modelartistas);
		
	}
	
	protected void listarEspectaculosDePlataformaActionPerformed(ActionEvent arg0) {
		String plataforma = this.comboBoxPlataforma.getSelectedItem().toString();
		ManejadorPlataforma mp=ManejadorPlataforma.getInstancia();
		Plataforma p=mp.getPlataforma(plataforma);
		
		DefaultComboBoxModel<String> modelespectaculo = new DefaultComboBoxModel<String>(p.listarEspectaculos());
		comboBoxEspectaculo.setModel(modelespectaculo);
	
	}
	
	protected void agregarArtistaInvitadoActionPerformed(ActionEvent arg0) {
		String artista = this.comboBoxArtistas.getSelectedItem().toString();
		//if(noExisteArtista(artista)) {
			this.artistasInvitados.add(artista);
			
		JOptionPane.showMessageDialog(this, "Se agrego al Artista " + artista, "Agregar Funcion",
                JOptionPane.INFORMATION_MESSAGE);
		//}
	}
	
	private boolean noExisteArtista(String artista) {
		boolean existe=false;
		for(String f: this.artistasInvitados) {
			if (f.equals(artista))
				existe=true;
		}
		if(existe) 
			 JOptionPane.showMessageDialog(this, "Ya se agrego a ese Artista", "Agregar Funcion",
	                    JOptionPane.ERROR_MESSAGE);
			 return false;
		 
	} 
	
	
	
	
	protected void altaFuncionActionPerformed(ActionEvent arg0) {
		String nombre=this.nombreFuncion.getText();
		String dia= this.diaTexto.getText();
		String mes=this.mesTexto.getText();
		String anio=this.anioTexto.getText();
		String hora=this.textoHora.getText();
		String minuto=this.textoMinuto.getText();
		String espectaculo = this.comboBoxEspectaculo.getSelectedItem().toString();
		int diaFuncion = Integer.parseInt(dia);
		int mesFuncion = Integer.parseInt(mes);
		int anioFuncion = Integer.parseInt(anio);
		int horaFuncion = Integer.parseInt(hora);
		int minutoFuncion = Integer.parseInt(minuto);
		
		anioFuncion=anioFuncion-1900;
		Date fecha= new Date(anioFuncion,mesFuncion-1,diaFuncion,horaFuncion,minutoFuncion);
		DtFuncion dt=new DtFuncion(nombre,fecha,this.artistasInvitados);
		icon.ingresarDatos(dt);
		icon.selectEspectauclo(espectaculo);
		try {
			icon.altaFuncion();
			JOptionPane.showMessageDialog(this, "La Funcion se agrego correctamente", "Agregar Funcion", JOptionPane.INFORMATION_MESSAGE);
			limpiarFormulario();
			this.artistasInvitados.clear();
			setVisible(false);
		}catch(FuncionRepetidaExcepcion e1) {
			JOptionPane.showMessageDialog(this, e1.getMessage(), "Agregar Funcion", JOptionPane.ERROR_MESSAGE);
		
		}
		
	}
	
	protected void cancelarAltaFuncionActionPerformed(ActionEvent arg0) {
		limpiarFormulario();
		this.artistasInvitados.clear();
		setVisible(false);
	}
	
	
	private void limpiarFormulario() {
        nombreFuncion.setText("");
        diaTexto.setText("");
		mesTexto.setText("");
		anioTexto.setText("");
		textoHora.setText("");
		textoMinuto.setText("");
		comboBoxEspectaculo.removeAllItems();
		
 }
	
	private boolean checkFormulario() {
	     String nombre= nombreFuncion.getText();
		 String dia= diaTexto.getText();
		 String mes=mesTexto.getText();
		 String anio=anioTexto.getText();
		 String hora=textoHora.getText();
		 String minuto=textoMinuto.getText();
	if(nombre.isEmpty() || dia.isEmpty() || mes.isEmpty() || anio.isEmpty() || hora.isEmpty() || minuto.isEmpty()) {
		JOptionPane.showMessageDialog(this, "No pueden quedar campos vacios", "Alta Funcion", JOptionPane.ERROR_MESSAGE);
		return false;
	}
		try {
			Integer.parseInt(dia);
			try {
				Integer.parseInt(mes);
				try {
					Integer.parseInt(anio);
					try {
						Integer.parseInt(hora);
						try {
							Integer.parseInt(minuto);
						}catch(NumberFormatException e){
							JOptionPane.showMessageDialog(this, "Los minutos no puede contener letras", "Alta Funcion",
				                    JOptionPane.ERROR_MESSAGE);
							return false;
						}
					}catch(NumberFormatException e) {
						JOptionPane.showMessageDialog(this, "La hora no puede contener letras", "Alta Funcion",
			                    JOptionPane.ERROR_MESSAGE);
						return false;
					}
				}catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(this, "El anio no puede contener letras", "Alta Funcion",
		                    JOptionPane.ERROR_MESSAGE);
					return false;
				}
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "El mes no puede contener letras", "Alta Funcion",
	                    JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "El dia no puede contener letras", "Alta Funcion",
                    JOptionPane.ERROR_MESSAGE);
			return false;
		}
        int diaa=Integer.parseInt(dia);
        int mess=Integer.parseInt(mes);
        int anioo=Integer.parseInt(anio);
        int horaa=Integer.parseInt(hora);
        int minutoss=Integer.parseInt(minuto);
        if(diaa<1||diaa>31) {
        	JOptionPane.showMessageDialog(this, "El dia no puede ser mayor a 31 o menor a 1", "Alta Funcion",
                    JOptionPane.ERROR_MESSAGE);
        	return false;
        }else if(mess>12||mess<1) {
        	JOptionPane.showMessageDialog(this, "El mes no puede ser menor a 1 o mayor a 12", "Alta Funcion",
                    JOptionPane.ERROR_MESSAGE);
        	return false;
        }else if(mess==2&& diaa>29) {
        	JOptionPane.showMessageDialog(this, "El mes de febrero no puede tener mas de 29 dias", "Alta Funcion",
                    JOptionPane.ERROR_MESSAGE);
        	return false;
        }else if(mess==2 && diaa==29) {
        	if(anioo % 4!=0 || (anioo % 100==0 && anioo % 400!=0)){
        		JOptionPane.showMessageDialog(this, "El anio que ingreso no es bisiesto por lo tanto febrero tiene 28 dias", "Alta Funcion",
                        JOptionPane.ERROR_MESSAGE);
        		return false;
        	}
        }else if(anioo<1900) {
        	JOptionPane.showMessageDialog(this, "El anio no puede ser menos a 1900", "Alta Funcion",
                    JOptionPane.ERROR_MESSAGE);
    		return false;
        }else if(horaa<0||horaa>23) {
        	JOptionPane.showMessageDialog(this, "La hora no puede ser menor a 0 o mayor a 23", "Alta Funcion",
                    JOptionPane.ERROR_MESSAGE);
    		return false;
        }else if(minutoss<0||minutoss>59) {
        	JOptionPane.showMessageDialog(this, "Los minutos no pueden ser menor a 0 o mayor a 59", "Alta Funcion",
                    JOptionPane.ERROR_MESSAGE);
    		return false;
        }
        
        return true;
	}
	
}
	
