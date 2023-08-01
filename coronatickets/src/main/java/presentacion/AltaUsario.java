package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
//import com.toedter.calendar.JDateChooser;

import datatypes.DtArtista;
import datatypes.DtUsuario;
import excepciones.UsuarioRepetidoExcepcion;
import excepciones.PasswordIncorrectaExcepcion;
import fabrica.Fabrica;
import interfaces.IControladorUsuario;
import logica.Artista;
import logica.Usuario;

import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class AltaUsario extends JInternalFrame {
	private IControladorUsuario icon;
	private JTextField textNickname;
	private JTextField textMail;
	private JTextField textNombreUsuario;
	private JTextField textApellidoUsuario;
	private JTextField textSitioWebArtista;
	private JButton btnAceptar;
	private JCheckBox chbxArtista;
	private JTextField textoDia;
	private JTextField textoMes;
	private JTextField textoAnio;
	private JTextArea textDescripcionArtista;
	private JTextArea textBiografiaArtista;
	 
	/**
	 * Launch the application.
	 */
	//Creo una FABRICA para probar
	//Fabrica fb = new Fabrica().getInstancia();
	//IControladorUsuario icu = fb.getIControladorUsuario();
	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaUsario frame = new AltaUsario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public AltaUsario(IControladorUsuario icon) {
		this.icon=icon;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
		setBounds(100, 100, 450, 335);
		getContentPane().setLayout(null);
		
		JLabel lblnickName = new JLabel("Nickname");
		lblnickName.setBounds(23, 11, 50, 28);
		getContentPane().add(lblnickName);
		
		textNickname = new JTextField();
		textNickname.setBounds(83, 15, 112, 20);
		getContentPane().add(textNickname);
		textNickname.setColumns(10);
		
		JLabel lblMail = new JLabel("E-Mail");
		lblMail.setBounds(242, 18, 38, 14);
		getContentPane().add(lblMail);
		
		textMail = new JTextField();
		textMail.setBounds(290, 15, 112, 20);
		getContentPane().add(textMail);
		textMail.setColumns(10);
		
		JLabel lblNombreUsario = new JLabel("Nombre");
		lblNombreUsario.setBounds(23, 53, 46, 14);
		getContentPane().add(lblNombreUsario);
		
		textNombreUsuario = new JTextField();
		textNombreUsuario.setBounds(83, 50, 112, 20);
		getContentPane().add(textNombreUsuario);
		textNombreUsuario.setColumns(10);
		
		JLabel lblApellidoUsuario = new JLabel("Apellido");
		lblApellidoUsuario.setBounds(230, 53, 50, 14);
		getContentPane().add(lblApellidoUsuario);
		
		textApellidoUsuario = new JTextField();
		textApellidoUsuario.setBounds(290, 50, 112, 20);
		getContentPane().add(textApellidoUsuario);
		textApellidoUsuario.setColumns(10);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setBounds(23, 89, 104, 14);
		getContentPane().add(lblFechaDeNacimiento);
		
		//JCalendar de FECHA dE NACIMIENTO
		//JDateChooser dateFechaNac = new JDateChooser();
		//dateFechaNac.setBounds(137, 81, 91, 28);
		//getContentPane().add(dateFechaNac);
		
		//CheckBox de ARTISTA
		chbxArtista = new JCheckBox("Artista");
		chbxArtista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chbxArtista.isSelected()) {
					textDescripcionArtista.setEditable(true);
					textSitioWebArtista.setEditable(true);
					textBiografiaArtista.setEditable(true);
				}else {
					textDescripcionArtista.setEditable(false);
					textSitioWebArtista.setEditable(false);
					textBiografiaArtista.setEditable(false);
				}
			}
		});
		chbxArtista.setBounds(23, 128, 65, 23);
		getContentPane().add(chbxArtista);
		chbxArtista.setSelected(true);
		
		JLabel lblDescripcionArtista = new JLabel("Descripcion");
		lblDescripcionArtista.setBounds(23, 154, 89, 14);
		getContentPane().add(lblDescripcionArtista);
		
		JLabel lblSitioWebArtisa = new JLabel("Sitio Web");
		lblSitioWebArtisa.setBounds(122, 154, 73, 14);
		getContentPane().add(lblSitioWebArtisa);
		
		textSitioWebArtista = new JTextField();
		textSitioWebArtista.setBounds(199, 151, 203, 20);
		getContentPane().add(textSitioWebArtista);
		textSitioWebArtista.setColumns(10);
		
		JLabel lblBiografiaArtista = new JLabel("Biografia");
		lblBiografiaArtista.setBounds(252, 182, 72, 14);
		getContentPane().add(lblBiografiaArtista);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkFormulario()) {
					crear(e);	
				}
			}
		});
		btnAceptar.setBounds(252, 270, 89, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
				setVisible(false);
			}
		});
		btnCancelar.setBounds(23, 270, 89, 23);
		getContentPane().add(btnCancelar);
		
		textoDia = new JTextField();
		textoDia.setBounds(168, 86, 96, 20);
		getContentPane().add(textoDia);
		textoDia.setColumns(10);
		
		textoMes = new JTextField();
		textoMes.setBounds(168, 117, 96, 20);
		getContentPane().add(textoMes);
		textoMes.setColumns(10);
		
		textoAnio = new JTextField();
		textoAnio.setBounds(317, 86, 50, 20);
		getContentPane().add(textoAnio);
		textoAnio.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Mes");
		lblNewLabel.setBounds(133, 120, 25, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Dia");
		lblNewLabel_1.setBounds(145, 89, 25, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Anio");
		lblNewLabel_2.setBounds(290, 89, 51, 14);
		getContentPane().add(lblNewLabel_2);
		
		textDescripcionArtista = new JTextArea();
		textDescripcionArtista.setBounds(23, 179, 112, 72);
		getContentPane().add(textDescripcionArtista);
		
		textBiografiaArtista = new JTextArea();
		textBiografiaArtista.setBounds(214, 195, 203, 64);
		getContentPane().add(textBiografiaArtista);
		
		
		
		}
		

	protected void crear(ActionEvent arg0) {
		String txNickName = textNickname.getText();
		String txMail = textMail.getText();
		String txNombre = textNombreUsuario.getText();
		String txApellido = textApellidoUsuario.getText();
		//Date date = dateFechaNac.getDate();//guardo como DATE mi objeto JCALENDAR
		
		String dia= this.textoDia.getText();
		String mes=this.textoMes.getText();
		String anio=this.textoAnio.getText();
		int diaFecha = Integer.parseInt(dia);
		int mesFecha = Integer.parseInt(mes);
		int anioFecha = Integer.parseInt(anio);
		
		anioFecha=anioFecha-1900;
		Date fechaNac=new Date(anioFecha,mesFecha-1,diaFecha);
		//Artista				
		String txDescArtista = textDescripcionArtista.getText();
		String txSitioWebArt = textSitioWebArtista.getText();
		String txBioArtista = textBiografiaArtista.getText();
		icon.setPassword("123");
		DtUsuario dtu=new DtUsuario(txNickName,txNombre,txApellido,txMail,fechaNac,"123");
		DtArtista dta=new DtArtista(txNickName,txNombre,txApellido,txMail,fechaNac,"123",txDescArtista,txSitioWebArt,txBioArtista);
		if(chbxArtista.isSelected()) {
			//llamada al Controlador
			try {
				icon.altaUsuario(dta);
				JOptionPane.showMessageDialog(this, "Se agrego al Artista correctamente", "Agregar Usuario", JOptionPane.INFORMATION_MESSAGE);
				limpiarFormulario();
				setVisible(false);
			}catch(UsuarioRepetidoExcepcion | PasswordIncorrectaExcepcion u) {
				JOptionPane.showMessageDialog(this, u.getMessage(), "Agregar Usuario", JOptionPane.ERROR_MESSAGE);
			}
			
		}else {//espectador
			try {
				icon.altaUsuario(dtu);
				JOptionPane.showMessageDialog(this, "Se agrego al Usuario correctamente", "Agregar Usuario", JOptionPane.INFORMATION_MESSAGE);
				limpiarFormulario();
				setVisible(false);
			}catch(UsuarioRepetidoExcepcion | PasswordIncorrectaExcepcion u) {
				JOptionPane.showMessageDialog(this, u.getMessage(), "Agregar Usuario", JOptionPane.ERROR_MESSAGE);
			}
		
		}
		
	}


	private boolean checkFormulario() {
		String txNickName = textNickname.getText();
		String txMail = textMail.getText();
		String txNombre = textNombreUsuario.getText();
		String txApellido = textApellidoUsuario.getText();
		
		String dia= this.textoDia.getText();
		String mes=this.textoMes.getText();
		String anio=this.textoAnio.getText();
		
		String txDescArtista = textDescripcionArtista.getText();
		String txSitioWebArt = textSitioWebArtista.getText();
		String txBioArtista = textBiografiaArtista.getText();
		
		
		
		if(chbxArtista.isSelected()) {
			if(txNickName.isEmpty()||txMail.isEmpty()||txNombre.isEmpty()||txApellido.isEmpty()||dia.isEmpty()||mes.isEmpty()||anio.isEmpty()||txDescArtista.isEmpty()||txSitioWebArt.isEmpty()||txBioArtista.isEmpty()) {
				JOptionPane.showMessageDialog(this, "No pueden quedar campos vacios", "Alta Usuario", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}else {
			if(txNickName.isEmpty()||txMail.isEmpty()||txNombre.isEmpty()||txApellido.isEmpty()||dia.isEmpty()||mes.isEmpty()||anio.isEmpty()) {
				JOptionPane.showMessageDialog(this, "No pueden quedar campos vacios", "Alta Usuario", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		
		try {
			Integer.parseInt(dia);
			try {
				Integer.parseInt(mes);
				try {
					Integer.parseInt(anio);
				}catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(this, "El anio no puede contener letras", "Alta Usuario",
		                    JOptionPane.ERROR_MESSAGE);
					return false;
				}
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "El mes no puede contener letras", "Alta Usuario",
	                    JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "El dia no puede contener letras", "Alta Usuario",
                    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		

		int diaa = Integer.parseInt(dia);
		int mess = Integer.parseInt(mes);
		int anioo = Integer.parseInt(anio);
		  if(diaa<1||diaa>31) {
	        	JOptionPane.showMessageDialog(this, "El dia no puede ser mayor a 31 o menor a 1", "Alta Usuario",
	                    JOptionPane.ERROR_MESSAGE);
	        	return false;
	        }else if(mess>12||mess<1) {
	        	JOptionPane.showMessageDialog(this, "El mes no puede ser menor a 1 o mayor a 12", "Alta Usuario",
	                    JOptionPane.ERROR_MESSAGE);
	        	return false;
	        }else if(mess==2&& diaa>29) {
	        	JOptionPane.showMessageDialog(this, "El mes de febrero no puede tener mas de 29 dias", "Alta Usuario",
	                    JOptionPane.ERROR_MESSAGE);
	        	return false;
	        }else if(mess==2 && diaa==29) {
	        	if(anioo % 4!=0 || (anioo % 100==0 && anioo % 400!=0)){
	        		JOptionPane.showMessageDialog(this, "El anio que ingreso no es bisiesto por lo tanto febrero tiene 28 dias", "Alta Usaurio",
	                        JOptionPane.ERROR_MESSAGE);
	        		return false;
	        	}
	        }else if(anioo<1900) {
	        	JOptionPane.showMessageDialog(this, "El anio no puede ser menos a 1900", "Alta Funcion",
	                    JOptionPane.ERROR_MESSAGE);
	    		return false;
		
	        }
		  
		return true;
		
	}
	
	
	
	
	private void limpiarFormulario() {
		textNickname.setText("");
		textMail.setText("");
		textNombreUsuario.setText("");
		textApellidoUsuario.setText("");
		textDescripcionArtista.setText("");
		textSitioWebArtista.setText("");
		textBiografiaArtista.setText("");
		textoDia.setText("");
		textoMes.setText("");
		textoAnio.setText("");
	}
}
