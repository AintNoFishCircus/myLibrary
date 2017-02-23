package kunde;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.CardLayout;
import javax.swing.JButton;

public class KundenverwaltungGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private Kundenliste list = new Kundenliste();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KundenverwaltungGUI frame = new KundenverwaltungGUI();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public KundenverwaltungGUI()throws ClassNotFoundException {
		setTitle("Kundenverwaltung");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		list.downloadData();
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 215, 434, 46);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 181, 215);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblVorname = new JLabel("Vorname:");
		lblVorname.setBounds(10, 87, 57, 14);
		panel_1.add(lblVorname);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 112, 57, 14);
		panel_1.add(lblName);
		
		JLabel lblStrasse = new JLabel("Strasse:");
		lblStrasse.setBounds(10, 137, 57, 14);
		panel_1.add(lblStrasse);
		
		textField = new JTextField();
		textField.setBounds(66, 84, 105, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(66, 109, 105, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(66, 134, 105, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblPlz = new JLabel("PLZ:");
		lblPlz.setBounds(10, 162, 46, 14);
		panel_1.add(lblPlz);
		
		JLabel lblOrt = new JLabel("Ort:");
		lblOrt.setBounds(10, 187, 46, 14);
		panel_1.add(lblOrt);
		
		textField_3 = new JTextField();
		textField_3.setBounds(66, 159, 105, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(66, 184, 105, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblKundendaten = new JLabel("Kundendaten:");
		lblKundendaten.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblKundendaten.setBounds(10, 11, 105, 14);
		panel_1.add(lblKundendaten);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(180, 107, 254, 97);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kontaktinformationen:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 4, 139, 14);
		panel_2.add(lblNewLabel);
		
		JLabel lblTel = new JLabel("Tel:");
		lblTel.setBounds(10, 29, 46, 14);
		panel_2.add(lblTel);
		
		JLabel lblMobil = new JLabel("Mobil:");
		lblMobil.setBounds(10, 54, 46, 14);
		panel_2.add(lblMobil);
		
		JLabel lblMail = new JLabel("Mail:");
		lblMail.setBounds(10, 79, 46, 14);
		panel_2.add(lblMail);
		
		textField_5 = new JTextField();
		textField_5.setBounds(44, 26, 150, 20);
		panel_2.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(44, 51, 150, 20);
		panel_2.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(44, 76, 150, 20);
		panel_2.add(textField_7);
		textField_7.setColumns(10);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane}));
		textField.setText(list.showData().getVorname());
		textField_1.setText(list.showData().getName());
	}
}
