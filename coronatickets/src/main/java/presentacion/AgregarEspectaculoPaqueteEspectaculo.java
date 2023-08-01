package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import interfaces.ICAgregarEspectaculoPaqueteEspectaculo;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarEspectaculoPaqueteEspectaculo extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	ICAgregarEspectaculoPaqueteEspectaculo icon;
	private JComboBox<String> comboBoxEspectaculos;
	private JComboBox<String> comboBoxPaquete;
	private JComboBox<String> comboBoxPlataforma;

	public AgregarEspectaculoPaqueteEspectaculo(ICAgregarEspectaculoPaqueteEspectaculo icon) {
		setTitle("Agregar Espectaculo a Paquete");
		setIconifiable(true);
		setClosable(true);
		setMaximizable(true);
		this.icon=icon;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		comboBoxPaquete = new JComboBox<String>();
		comboBoxPaquete.setBounds(72, 27, 109, 22);
		getContentPane().add(comboBoxPaquete);
		
		JLabel lblNewLabel = new JLabel("Paquete");
		lblNewLabel.setBounds(0, 31, 49, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Plataforma");
		lblNewLabel_1.setBounds(202, 31, 74, 14);
		getContentPane().add(lblNewLabel_1);
		
		comboBoxEspectaculos = new JComboBox<String>();
		comboBoxEspectaculos.setBounds(91, 92, 130, 22);
		getContentPane().add(comboBoxEspectaculos);
		
		JLabel lblNewLabel_2 = new JLabel("Espectaculos");
		lblNewLabel_2.setBounds(12, 96, 79, 14);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Agregar Espectaculo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarEspectaculoPaquete(e);
			}
		});
		btnNewButton.setBounds(51, 174, 141, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar(e);
			}
		});
		btnNewButton_1.setBounds(247, 174, 114, 23);
		getContentPane().add(btnNewButton_1);
		
		comboBoxPlataforma = new JComboBox<String>();
		comboBoxPlataforma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarEspectaculos(e);
			}
		});
		comboBoxPlataforma.setBounds(286, 27, 107, 22);
		getContentPane().add(comboBoxPlataforma);

	}
	
	protected void listarEspectaculos(ActionEvent arg0) {
		String plataforma=this.comboBoxPlataforma.getSelectedItem().toString();
		String paquete=this.comboBoxPaquete.getSelectedItem().toString();
		String[] nombresEspectaculos=icon.listarEspectaculosSinAgregar(plataforma, paquete);
		if(nombresEspectaculos.length!=0) {
			DefaultComboBoxModel<String> modelespectaculo = new DefaultComboBoxModel<String>(icon.listarEspectaculosSinAgregar(plataforma, paquete));
			comboBoxEspectaculos.setModel(modelespectaculo);
		}else {
			comboBoxEspectaculos.removeAllItems();
		}
		
		
	}
	
	
	protected void cancelar(ActionEvent arg0) {
		comboBoxEspectaculos.setSelectedIndex(-1);
		setVisible(false);
	}
	
	protected void inicializarComboBoxes() {
		DefaultComboBoxModel<String> modelespaquetes = new DefaultComboBoxModel<String>(icon.listarPaquetes());
		comboBoxPaquete.setModel(modelespaquetes);
		DefaultComboBoxModel<String> modelesplataforma = new DefaultComboBoxModel<String>(icon.listarPlataforma());
		comboBoxPlataforma.setModel(modelesplataforma);
	
	}
	
	protected void agregarEspectaculoPaquete(ActionEvent arg0) {
		String espectaculo=this.comboBoxEspectaculos.getSelectedItem().toString();
		String paquete=this.comboBoxPaquete.getSelectedItem().toString();
		icon.agregarEspectaculo(paquete, espectaculo);
		JOptionPane.showMessageDialog(this, "El Espectaculo se agrego correctamente", "Agregar Espectaculo a Paquete", JOptionPane.INFORMATION_MESSAGE);
		setVisible(false);
	}
	
}
