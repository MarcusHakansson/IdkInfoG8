import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

import org.jdesktop.swingx.prompt.PromptSupport;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.imageio.ImageIO;
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
	private JTextArea infoTextArea;
	private JTextArea infoField;
	private JLabel uploadBildLabel;
	private static jpegGUI frame;
	private int width = 500;
	private int height = 500;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				    frame = new jpegGUI();
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
		setBounds(100, 100, 1435, 808);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//PromptSupport.setPrompt("Välj en bild", uploadField);
		
		JLabel lblNewLabel = new JLabel("Bilden ska helst vara 500 x 500 pixlar:");
		lblNewLabel.setFont(new Font("Futura", Font.PLAIN, 16));
		lblNewLabel.setBounds(6, 6, 282, 26);
		contentPane.add(lblNewLabel);
		
		JButton uploadBtn = new JButton("V\u00E4lj bild fr\u00E5n din dator");
		uploadBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		uploadBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FileDialog fDialog = new FileDialog(frame, "Open", FileDialog.LOAD);
			    fDialog.setVisible(true);
			    String path = fDialog.getDirectory() + fDialog.getFile();
			    File f = new File(path);
			    ImageIcon imageIcon = new ImageIcon(path); // load the image to a imageIcon
			    Image image = imageIcon.getImage(); // transform it 
			    Image newimg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
			    imageIcon = new ImageIcon(newimg);  // transform it back
			    uploadBildLabel.setIcon(new ImageIcon(newimg));  //lblBilden --> ska vara r�tt jlabel-icon i preview...
			}
		});
		uploadBtn.setBounds(6, 31, 365, 47);
		contentPane.add(uploadBtn);
		
		JButton rubrikBtn = new JButton("Ok");
		rubrikBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rubrikLabel.setForeground(Color.BLACK);
				
				rubrikLabel.setText(rubrikField.getText());
				String i = rubrikField.getText();
				
				FontMetrics fm = rubrikLabel.getFontMetrics(rubrikLabel.getFont());
                int textWidth = fm.stringWidth(i);
                //int textStart = fm.
                
				rubrikField.setText("");
				
				rubriklabel3 = new JLabel("", rubriklabel3.LEFT);
				rubriklabel3.setForeground(Color.white);
				rubriklabel3.setHorizontalAlignment(SwingConstants.LEFT);
				rubriklabel3.setBounds(247-(textWidth/2), 25, textWidth+10, 47);
				
				panel.add(rubriklabel3);
				rubriklabel3.setOpaque(true);
				
				//System.out.println(i+"=" + textWidth);
				
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
		//PromptSupport.setPrompt("E.g. Sommarkurser i Niagara", rubrikField);
		
		JLabel lblRubrik = new JLabel(" Rubrik:\n");
		lblRubrik.setFont(new Font("Futura", Font.PLAIN, 16));
		lblRubrik.setBounds(6, 90, 282, 26);
		contentPane.add(lblRubrik);
		
		JButton datumTidBtn = new JButton("Ok");
		datumTidBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//datumlabel.setText(datumField.getText());
				tidLabel.setText(tidField.getText());
				
				//datumField.setText("");
				tidField.setText("");
				
				//datumlabel.setOpaque(true);
				tidLabel.setOpaque(true);
			
			}
		});
		datumTidBtn.setBounds(300, 284, 71, 47);
		contentPane.add(datumTidBtn);
		datumField = new JTextField();
		datumField.setFont(new Font("Futura", Font.PLAIN, 15));
		datumField.setColumns(10);
		contentPane.add(datumField);
		datumField.setBounds(6, 284, 117, 47);
		//PromptSupport.setPrompt("E.g. DD/MM -16", datumField);
		
		
		
		JLabel lblDatum = new JLabel(" Datum\n");
		lblDatum.setFont(new Font("Futura", Font.PLAIN, 16));
		lblDatum.setBounds(6, 259, 117, 26);
		contentPane.add(lblDatum);
		
		JButton platsBtn = new JButton("Ok");
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
		//PromptSupport.setPrompt("E.g. Plats", platsField);
		
		JLabel lblPlats = new JLabel(" Plats:");
		lblPlats.setFont(new Font("Futura", Font.PLAIN, 16));
		lblPlats.setBounds(6, 174, 138, 26);
		contentPane.add(lblPlats);
		
		JLabel lblTid = new JLabel(" Tid");
		lblTid.setFont(new Font("Futura", Font.PLAIN, 16));
		lblTid.setBounds(193, 259, 43, 26);
		contentPane.add(lblTid);
		
		JLabel lblInformation = new JLabel("Information");
		lblInformation.setFont(new Font("Futura", Font.PLAIN, 16));
		lblInformation.setBounds(6, 347, 282, 26);
		contentPane.add(lblInformation);
		
		//JButton avbrytBtn = new JButton("Avbryt");
		//avbrytBtn.setBounds(726, 613, 117, 47);
		//contentPane.add(avbrytBtn);

		panel = new Panel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(377, 31, 1000, 650);
		contentPane.add(panel);
		panel.setLayout(null);
				
		JButton sparaBtn = new JButton("Spara bilden");
		sparaBtn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		sparaBtn.setBackground(Color.RED);
		sparaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//metod f�r att �ppna sparadialog
				//v�lj plats att spara p�
				FileDialog fDialog = new FileDialog(frame, "Save", FileDialog.SAVE);
		        fDialog.setVisible(true);
		        String path = fDialog.getDirectory() + fDialog.getFile();
		        File f = new File(path);
				try {
					int width = 1000, height = 650;
					Container c = getContentPane();
					c = panel;
					c.setSize(width, height);
					BufferedImage bi = new BufferedImage(c.getWidth(), c.getHeight(), BufferedImage.TYPE_INT_ARGB);
				    c.paint(bi.getGraphics());	
				    ImageIO.write(bi, "PNG", new File(path + ".png"));
				    //ImageIO.write(bi, "JPEG", new File("c:\\yourImageName.JPG"));
				    //ImageIO.write(bi, "gif", new File("c:\\yourImageName.GIF"));
				    //ImageIO.write(bi, "BMP", new File("c:\\yourImageName.BMP"));
			    } catch (IOException ie) {
			      ie.printStackTrace();
			    }
			}
		});
		sparaBtn.setBounds(1194, 689, 183, 47);
		contentPane.add(sparaBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 377, 365, 359);
		contentPane.add(scrollPane);
		
		JTextArea infoField = new JTextArea();
		infoField.setWrapStyleWord(true);
		infoField.setLineWrap(true);
		scrollPane.setViewportView(infoField);
		
		JButton infoBtn = new JButton("Ok");
		infoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				infoTextArea.setText(infoField.getText());
			}
		});
		infoBtn.setBounds(377, 689, 65, 47);
		contentPane.add(infoBtn);
		
		tidField = new JTextField();
		tidField.setFont(new Font("Futura", Font.PLAIN, 15));
		tidField.setColumns(10);
		tidField.setBounds(193, 284, 104, 47);
		contentPane.add(tidField);
		//PromptSupport.setPrompt("E.g. 12:00", tidField);
		
		
		JLabel lblFrhandsgrandska = new JLabel("F\u00F6rhandsgrandska\r\n");
		lblFrhandsgrandska.setFont(new Font("Futura", Font.PLAIN, 16));
		lblFrhandsgrandska.setBounds(383, -1, 150, 26);
		contentPane.add(lblFrhandsgrandska);
		
		rubrikLabel = new JLabel("Skriv en lockande rubrik");
		rubrikLabel.setBackground(Color.DARK_GRAY);
		rubrikLabel.setFont(new Font("Futura", Font.PLAIN, 28));
		rubrikLabel.setForeground(Color.WHITE);
		rubrikLabel.setHorizontalAlignment(SwingConstants.LEFT);
		rubrikLabel.setBounds(157, 16, 714, 53);
		panel.add(rubrikLabel);
		
		
		logoLabel = new JLabel("");
		logoLabel.setIcon(new ImageIcon("/Users/Marcus/Documents/STUDIER/IxD/PROGRAMMING/GitHub/IdkInfoG8/test/Pics/logowhitetxt.png"));
		logoLabel.setBounds(6, 6, 100, 131);
		panel.add(logoLabel);
		
		datumlabel = new JLabel("");
		datumlabel.setFont(new Font("Futura", Font.PLAIN, 15));
		datumlabel.setHorizontalAlignment(SwingConstants.CENTER);
		datumlabel.setBounds(6, 363, 100, 21);
		panel.add(datumlabel);
		
		tidLabel = new JLabel("");
		tidLabel.setFont(new Font("Futura", Font.PLAIN, 15));
		tidLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tidLabel.setBounds(6, 467, 100, 21);
		panel.add(tidLabel);
		
		JLabel label = new JLabel("PLATS: ");
		label.setBackground(Color.WHITE);
		label.setFont(new Font("Futura", Font.PLAIN, 15));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(6, 235, 69, 21);
		panel.add(label);
		label.setOpaque(true);
		
		
		JLabel label_1 = new JLabel("DATUM: ");
		label_1.setBackground(Color.WHITE);
		label_1.setFont(new Font("Futura", Font.PLAIN, 15));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(6, 333, 69, 21);
		panel.add(label_1);
		label_1.setOpaque(true);
		
		JLabel label_2 = new JLabel("TID: ");
		label_2.setBackground(Color.WHITE);
		label_2.setFont(new Font("Futura", Font.PLAIN, 15));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(6, 430, 69, 21);
		panel.add(label_2);
		label_2.setOpaque(true);
		
		platsLabel = new JLabel("");
		platsLabel.setFont(new Font("Futura", Font.PLAIN, 15));
		platsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		platsLabel.setBounds(6, 268, 100, 21);
		panel.add(platsLabel);
		
		infoTextArea = new JTextArea();
		infoTextArea.setText("H\u00E4r hamnar din informationstext.");
		infoTextArea.setWrapStyleWord(true);
		infoTextArea.setEditable(false);
		infoTextArea.setLineWrap(true);
		infoTextArea.setFont(new Font("Futura", Font.PLAIN, 15));
		infoTextArea.setBounds(157, 85, 319, 500);
		panel.add(infoTextArea);
		infoTextArea.setOpaque(true);
		
		uploadBildLabel = new JLabel("Din bild: \n500 x 500 pixlar");
		uploadBildLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		uploadBildLabel.setHorizontalAlignment(SwingConstants.CENTER);
		uploadBildLabel.setForeground(Color.WHITE);
		uploadBildLabel.setBounds(491, 85, 500, 500);
		
		panel.add(uploadBildLabel);
		
		JButton button = new JButton("Ok");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datumlabel.setText(datumField.getText());
				//tidLabel.setText(tidField.getText());
				
				datumField.setText("");
				//tidField.setText("");
				
				datumlabel.setOpaque(true);
				//tidLabel.setOpaque(true);
			}
		});
		button.setBounds(125, 284, 53, 47);
		contentPane.add(button);
		
	}
}
