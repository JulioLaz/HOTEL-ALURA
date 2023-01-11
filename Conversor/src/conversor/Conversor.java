package conversor;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Conversor extends JFrame {
	private JTextField xCantidad;
	private JTextField xResultado;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conversor frame = new Conversor();
					frame.setLocationRelativeTo(null); 
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Conversor() {
		
		getContentPane().setBackground(new Color(100,100,100));
		getContentPane().setLayout(null);
		
		xCantidad = new JTextField();
		xCantidad.setBounds(150, 30, 100, 50);
		xCantidad.setBackground(new Color(210,250,250));
		xCantidad.setHorizontalAlignment(SwingConstants.CENTER);;
		
		getContentPane().add(xCantidad);
		
		JLabel jLabel = new JLabel("MONTO");
		jLabel.setForeground(Color.WHITE);
		jLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel.setBounds(150, 5, 100, 20);
		getContentPane()
		.add(jLabel);
		
		JComboBox jComboBox = new JComboBox();
		jComboBox.setModel(new DefaultComboBoxModel(new String[] {
				"PesosArg a Euro",
				"Euro a PesosArg", 
				"PesosArg a Dolar",
				"Dolar a PesosArg", 
				"Dolar a Euro",
				"Euro a Dolar",
		}));
		
		jComboBox.setBounds(10, 30, 120, 50);
		getContentPane()
		.add(jComboBox);
		
		JLabel jLabel_Convertir = new JLabel("RESULTADO");
		jLabel_Convertir.setForeground(Color.WHITE);
		jLabel_Convertir.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel_Convertir.setBounds(270, 5, 100, 20);
		getContentPane().add(jLabel_Convertir);
		
		xResultado = new JTextField();
		xResultado.setColumns(10);
		xResultado.setForeground(Color.red);
		xResultado.setBounds(270, 30, 100, 50);
		xResultado.setBackground(new Color(210,250,250));
		xResultado.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		getContentPane().add(xResultado);
				
		JButton jButton = new JButton("CONVERTIR");
		jButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jButton.setForeground(Color.black);
		jButton.setBackground(new Color(71,192,192));
		jButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double moneda =0, resultado=0;
				int selectedOption=0;
				MonedaConversor monedaconversion = new MonedaConversor();
				if (!xCantidad.getText().isEmpty()) {
					
					moneda = Double.parseDouble(xCantidad.getText());
					monedaconversion.setMoneda(moneda); 
					selectedOption= jComboBox.getSelectedIndex()+1;
					resultado= monedaconversion.Menu_conversion(selectedOption);
					
					double roundDbl = Math.round(resultado*100.0)/100.0;
					
					xResultado.setText(Double.toString(roundDbl));  
				}
				
			}
		});
		jButton.setBounds(130, 100, 140, 40);
		getContentPane().add(jButton);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 200);
	}
}

