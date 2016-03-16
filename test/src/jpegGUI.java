import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Panel;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class jpegGUI extends JFrame {

	private JPanel contentPane;
	private JTextField uploadField;
	private JTextField rubrikField;
	private JTextField datumField;
	private JTextField platsField;
	private JTextField tidField;
	private JLabel rubrikLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jpegGUI frame = new jpegGUI();
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
	public jpegGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		uploadField = new JTextField();
		uploadField.setFont(new Font("Futura", Font.PLAIN, 15));
		uploadField.setBounds(6, 31, 282, 47);
		contentPane.add(uploadField);
		uploadField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel(" Välj bild från din dator:");
		lblNewLabel.setFont(new Font("Futura", Font.PLAIN, 16));
		lblNewLabel.setBounds(6, 6, 282, 26);
		contentPane.add(lblNewLabel);
		
		JButton uploadBtn = new JButton("Lägg till");
		uploadBtn.setBounds(300, 31, 71, 47);
		contentPane.add(uploadBtn);
		
		JButton rubrikBtn = new JButton("Lägg till");
		rubrikBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rubrikLabel.setText(rubrikField.getText());
			}
		});
		rubrikBtn.setBounds(300, 115, 71, 47);
		contentPane.add(rubrikBtn);
		
		rubrikField = new JTextField();
		rubrikField.setFont(new Font("Futura", Font.PLAIN, 15));
		rubrikField.setColumns(10);
		rubrikField.setBounds(6, 115, 282, 47);
		contentPane.add(rubrikField);
		
		JLabel lblRubrik = new JLabel(" Rubrik:\n");
		lblRubrik.setFont(new Font("Futura", Font.PLAIN, 16));
		lblRubrik.setBounds(6, 90, 282, 26);
		contentPane.add(lblRubrik);
		
		JButton datumTidBtn = new JButton("Lägg till");
		datumTidBtn.setBounds(300, 199, 71, 47);
		contentPane.add(datumTidBtn);
		
		datumField = new JTextField();
		datumField.setFont(new Font("Futura", Font.PLAIN, 15));
		datumField.setColumns(10);
		datumField.setBounds(6, 199, 117, 47);
		contentPane.add(datumField);
		
		JLabel lblDatum = new JLabel(" Datum\n");
		lblDatum.setFont(new Font("Futura", Font.PLAIN, 16));
		lblDatum.setBounds(6, 174, 230, 26);
		contentPane.add(lblDatum);
		
		JButton platsBtn = new JButton("Lägg till");
		platsBtn.setBounds(300, 284, 71, 47);
		contentPane.add(platsBtn);
		
		platsField = new JTextField();
		platsField.setFont(new Font("Futura", Font.PLAIN, 15));
		platsField.setColumns(10);
		platsField.setBounds(6, 283, 282, 47);
		contentPane.add(platsField);
		
		JLabel lblPlats = new JLabel(" Plats:");
		lblPlats.setFont(new Font("Futura", Font.PLAIN, 16));
		lblPlats.setBounds(6, 258, 282, 26);
		contentPane.add(lblPlats);
		
		JLabel lblTid = new JLabel(" Tid");
		lblTid.setFont(new Font("Futura", Font.PLAIN, 16));
		lblTid.setBounds(171, 174, 43, 26);
		contentPane.add(lblTid);
		
		JLabel lblInformation = new JLabel("Information");
		lblInformation.setFont(new Font("Futura", Font.PLAIN, 16));
		lblInformation.setBounds(6, 374, 282, 26);
		contentPane.add(lblInformation);
		
		JButton avbrytBtn = new JButton("Avbryt");
		avbrytBtn.setBounds(726, 613, 117, 47);
		contentPane.add(avbrytBtn);
		
		JButton sparaBtn = new JButton("Spara");
		sparaBtn.setBounds(860, 613, 117, 47);
		contentPane.add(sparaBtn);
		
		JButton infoBtn = new JButton("Lägg till");
		infoBtn.setBounds(866, 412, 111, 189);
		contentPane.add(infoBtn);
		
		JTextArea infoField = new JTextArea();
		infoField.setFont(new Font("Futura", Font.PLAIN, 15));
		infoField.setBounds(6, 412, 846, 189);
		contentPane.add(infoField);
		
		tidField = new JTextField();
		tidField.setFont(new Font("Futura", Font.PLAIN, 15));
		tidField.setColumns(10);
		tidField.setBounds(171, 199, 117, 47);
		contentPane.add(tidField);
		
		JLabel lblFrhandsgrandska = new JLabel("Förhandsgrandska\n");
		lblFrhandsgrandska.setFont(new Font("Futura", Font.PLAIN, 16));
		lblFrhandsgrandska.setBounds(383, 6, 150, 26);
		contentPane.add(lblFrhandsgrandska);
		
		Panel panel = new Panel();
		panel.setBounds(377, 31, 613, 369);
		contentPane.add(panel);
		panel.setLayout(null);
		
		rubrikLabel = new JLabel("");
		rubrikLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rubrikLabel.setFont(new Font("Futura", Font.BOLD, 28));
		rubrikLabel.setBounds(140, 6, 467, 47);
		panel.add(rubrikLabel);
	}
}
