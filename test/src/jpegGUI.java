import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.MouseInfo;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

import org.jdesktop.swingx.prompt.PromptSupport;

import java.awt.BorderLayout;
import java.awt.Color;


import javax.swing.ImageIcon;
import javax.swing.JTable;



public class jpegGUI extends JFrame {

	private JPanel contentPane;
	private JTextField uploadField;
	private JTextField rubrikField;
	private JTextField datumField;
	private JTextField platsField;
	private JTextField tidField;
	private JLabel rubrikLabel;
	private JLabel rubriklabel3;
	private JLabel logoLabel;
	private JLabel platsLabel;
	private JLabel datumlabel;
	private JLabel tidLabel;
	private Panel panel;
	

	

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
		PromptSupport.setPrompt("Välj en bild", uploadField);
		
		JLabel lblNewLabel = new JLabel(" Välj bild från din dator:");
		lblNewLabel.setFont(new Font("Futura", Font.PLAIN, 16));
		lblNewLabel.setBounds(6, 6, 282, 26);
		contentPane.add(lblNewLabel);
		
		JButton uploadBtn = new JButton("Lägg till");
		uploadBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		uploadBtn.setBounds(300, 31, 71, 47);
		contentPane.add(uploadBtn);
		
		JButton rubrikBtn = new JButton("Lägg till");
		rubrikBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rubrikLabel.setText(rubrikField.getText());
				String i = rubrikField.getText();
				
				FontMetrics fm = rubrikLabel.getFontMetrics(rubrikLabel.getFont());
                int textWidth = fm.stringWidth(i);
                //int textStart = fm.
                
				rubrikField.setText("");
				
				rubriklabel3 = new JLabel("", rubriklabel3.CENTER);
				rubriklabel3.setForeground(Color.white);
				rubriklabel3.setHorizontalAlignment(SwingConstants.CENTER);
				rubriklabel3.setBounds(347-(textWidth/2), 25, textWidth+10, 47);
				
				panel.add(rubriklabel3);
				rubriklabel3.setOpaque(true);
				
				System.out.println(i+"=" + textWidth);
				
			}
		});

		
		rubrikBtn.setBounds(300, 115, 71, 47);
		contentPane.add(rubrikBtn);
		
		rubrikField = new JTextField();
		rubrikField.setToolTipText("TEST");
		rubrikField.setFont(new Font("Futura", Font.PLAIN, 15));
		rubrikField.setColumns(10);
		rubrikField.setBounds(6, 115, 282, 47);
		contentPane.add(rubrikField);
		PromptSupport.setPrompt("E.g. Sommarkurser i Niagara", rubrikField);
		
		JLabel lblRubrik = new JLabel(" Rubrik:\n");
		lblRubrik.setFont(new Font("Futura", Font.PLAIN, 16));
		lblRubrik.setBounds(6, 90, 282, 26);
		contentPane.add(lblRubrik);
		
		JButton datumTidBtn = new JButton("Lägg till");
		datumTidBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				datumlabel.setText(datumField.getText());
				tidLabel.setText(tidField.getText());
				
				datumField.setText("");
				tidField.setText("");
				
				datumlabel.setOpaque(true);
				tidLabel.setOpaque(true);
			
			}
		});
		datumTidBtn.setBounds(300, 284, 71, 47);
		contentPane.add(datumTidBtn);
		datumField = new JTextField();
		datumField.setFont(new Font("Futura", Font.PLAIN, 15));
		datumField.setColumns(10);
		contentPane.add(datumField);
		datumField.setBounds(6, 284, 138, 47);
		PromptSupport.setPrompt("E.g. DD/MM -16", datumField);
		
		
		
		JLabel lblDatum = new JLabel(" Datum\n");
		lblDatum.setFont(new Font("Futura", Font.PLAIN, 16));
		lblDatum.setBounds(6, 259, 117, 26);
		contentPane.add(lblDatum);
		
		JButton platsBtn = new JButton("Lägg till");
		platsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				platsLabel.setText(platsField.getText());
				platsField.setText("");
				platsLabel.setOpaque(true);
			
				
			}
		});
		platsBtn.setBounds(300, 200, 71, 47);
		contentPane.add(platsBtn);
		
		platsField = new JTextField();
		platsField.setFont(new Font("Futura", Font.PLAIN, 15));
		platsField.setColumns(10);
		platsField.setBounds(6, 199, 282, 47);
		contentPane.add(platsField);
		PromptSupport.setPrompt("E.g. Plats", platsField);
		
		JLabel lblPlats = new JLabel(" Plats:");
		lblPlats.setFont(new Font("Futura", Font.PLAIN, 16));
		lblPlats.setBounds(6, 174, 138, 26);
		contentPane.add(lblPlats);
		
		JLabel lblTid = new JLabel(" Tid");
		lblTid.setFont(new Font("Futura", Font.PLAIN, 16));
		lblTid.setBounds(171, 259, 43, 26);
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
		tidField.setBounds(171, 284, 117, 47);
		contentPane.add(tidField);
		PromptSupport.setPrompt("E.g. 12:00", tidField);
		
		
		JLabel lblFrhandsgrandska = new JLabel("Förhandsgrandska\n");
		lblFrhandsgrandska.setFont(new Font("Futura", Font.PLAIN, 16));
		lblFrhandsgrandska.setBounds(383, -1, 150, 26);
		contentPane.add(lblFrhandsgrandska);
		
		panel = new Panel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(377, 31, 613, 369);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		rubrikLabel = new JLabel("");
		rubrikLabel.setBackground(Color.DARK_GRAY);
		rubrikLabel.setFont(new Font("Futura", Font.PLAIN, 28));
		rubrikLabel.setForeground(Color.BLACK);
		rubrikLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rubrikLabel.setBounds(118, 25, 468, 47);
		panel.add(rubrikLabel);
		
		
		logoLabel = new JLabel("");
		logoLabel.setIcon(new ImageIcon("/Users/Marcus/Documents/STUDIER/IxD/PROGRAMMING/GitHub/IdkInfoG8/test/Pics/logowhitetxt.png"));
		logoLabel.setBounds(6, 6, 100, 131);
		panel.add(logoLabel);
		
		datumlabel = new JLabel("");
		datumlabel.setFont(new Font("Futura", Font.PLAIN, 15));
		datumlabel.setHorizontalAlignment(SwingConstants.CENTER);
		datumlabel.setBounds(82, 174, 69, 21);
		panel.add(datumlabel);
		
		tidLabel = new JLabel("");
		tidLabel.setFont(new Font("Futura", Font.PLAIN, 15));
		tidLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tidLabel.setBounds(82, 207, 69, 21);
		panel.add(tidLabel);
		
		JLabel label = new JLabel("PLATS: ");
		label.setBackground(Color.WHITE);
		label.setFont(new Font("Futura", Font.PLAIN, 15));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(6, 141, 69, 21);
		panel.add(label);
		label.setOpaque(true);
		
		
		JLabel label_1 = new JLabel("DATUM: ");
		label_1.setBackground(Color.WHITE);
		label_1.setFont(new Font("Futura", Font.PLAIN, 15));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(6, 174, 69, 21);
		panel.add(label_1);
		label_1.setOpaque(true);
		
		JLabel label_2 = new JLabel("TID: ");
		label_2.setBackground(Color.WHITE);
		label_2.setFont(new Font("Futura", Font.PLAIN, 15));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(6, 207, 69, 21);
		panel.add(label_2);
		label_2.setOpaque(true);
		
		platsLabel = new JLabel("");
		platsLabel.setFont(new Font("Futura", Font.PLAIN, 15));
		platsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		platsLabel.setBounds(82, 141, 120, 21);
		panel.add(platsLabel);
		
		
		
		
	
		
	}

}
