package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import datatypes.DtFuncion;
import interfaces.ICConsultaFuncionEspectaculo;
import logica.Espectaculo;
import logica.Plataforma;
import manejador.ManejadorEspectaculos;
import manejador.ManejadorPlataforma;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class ConsultaFuncionEspectaculo extends JInternalFrame {
	private ICConsultaFuncionEspectaculo icon;
	private JComboBox<String> comboBoxPlataforma;
	private JComboBox<String> comboBoxEspectaculo;
	private JComboBox<String> comboBoxFuncion;
	private JTextPane funcionTexto;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaFuncionEspectaculo frame = new ConsultaFuncionEspectaculo();
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
	public ConsultaFuncionEspectaculo(ICConsultaFuncionEspectaculo icon) {
		this.icon=icon;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
		
		
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Plataforma");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 11, 66, 14);
		getContentPane().add(lblNewLabel);
		
		comboBoxPlataforma = new JComboBox();
		comboBoxPlataforma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarEspectaculos(e);
			}
			
		});
		comboBoxPlataforma.setBounds(84, 8, 118, 22);
		getContentPane().add(comboBoxPlataforma);
		
		JLabel lblNewLabel_1 = new JLabel("Espectaculo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 56, 76, 14);
		getContentPane().add(lblNewLabel_1);
		
		comboBoxEspectaculo = new JComboBox<String>();
		comboBoxEspectaculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarFunciones(e);
			}
		});
		comboBoxEspectaculo.setBounds(84, 53, 118, 22);
		getContentPane().add(comboBoxEspectaculo);
		
		JLabel lblNewLabel_2 = new JLabel("Funcion");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 104, 49, 14);
		getContentPane().add(lblNewLabel_2);
		
		comboBoxFuncion = new JComboBox<String>();
		comboBoxFuncion.setBounds(84, 104, 118, 22);
		getContentPane().add(comboBoxFuncion);
		
		JButton btnNewButton = new JButton("Ver Info");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				infoFuncion(e);
			}
		});
		btnNewButton.setBounds(10, 181, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelarInfo(e);
			}
		});
		btnNewButton_1.setBounds(10, 215, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		funcionTexto = new JTextPane();
		funcionTexto.setEditable(false);
		funcionTexto.setBounds(226, 24, 188, 200);
		getContentPane().add(funcionTexto);

	}
	
	public void inicializarComboBoxes() {
		DefaultComboBoxModel<String> modelplataforma = new DefaultComboBoxModel<String>(icon.listarPlataforma());
		comboBoxPlataforma.setModel(modelplataforma);
		
	}
	protected void listarEspectaculos(ActionEvent arg0) {
		String plataforma = this.comboBoxPlataforma.getSelectedItem().toString();
		ManejadorPlataforma mp=ManejadorPlataforma.getInstancia();
		Plataforma p=mp.getPlataforma(plataforma);
		
		DefaultComboBoxModel<String> modelespectaculo = new DefaultComboBoxModel<String>(p.listarEspectaculos());
		comboBoxEspectaculo.setModel(modelespectaculo);
		
	}
	
	protected void listarFunciones(ActionEvent arg0) {
		String espectaculo=this.comboBoxEspectaculo.getSelectedItem().toString();
		ManejadorEspectaculos me=ManejadorEspectaculos.getInstancia();
		Espectaculo e=me.buscarEspectaculo(espectaculo);
		DefaultComboBoxModel<String> modelfunciones=new DefaultComboBoxModel<String>(e.listarFunciones());
		comboBoxFuncion.setModel(modelfunciones);
	}
	
	protected void infoFuncion(ActionEvent arg0) {
		funcionTexto.setText("");
	
		String especatculo=this.comboBoxEspectaculo.getSelectedItem().toString();
		String funcion=this.comboBoxFuncion.getSelectedItem().toString();
	
		icon.elegirEspecatculo(especatculo);
		DtFuncion dtf=icon.selectFuncion(funcion);
		String datos="Informacion de la Funcion";
		datos=datos+"\n" + dtf.toString();
		funcionTexto.setText(datos);
	}
	
	protected void cancelarInfo(ActionEvent arg0) {
		funcionTexto.setText("");
		//comboBoxFuncion.removeAllItems();
		//comboBoxEspectaculo.removeAllItems();
		setVisible(false);
	}
}
