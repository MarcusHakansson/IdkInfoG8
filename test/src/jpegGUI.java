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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

//import org.jdesktop.swingx.prompt.PromptSupport;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import java.awt.SystemColor;



public class jpegGUI extends JFrame {

	private JPanel contentPane;
	private JTextField rubrikField;
	private JTextField datumField;
	private JTextField platsField;
	private JTextField tidField;
	private JLabel rubrikLabel;
	private JLabel rubriklabel3;
	private JLabel platsLabel;
	private JLabel datumlabel;
	private JLabel tidLabel;
	private Panel panel;
	private JTextArea infoTextArea;
	private JLabel uploadBildLabel;
	private static jpegGUI frame;
	private int widthPreviewImage = 550;
	private int heightPreviewImage = 500;
	private int widthPreview = 1152;
	private int heightPreview = 648;
	private JTextField txtCreators;
	
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
			
		setIconImage(Toolkit.getDefaultToolkit().getImage(jpegGUI.class.getResource("/Bilder/MAH_logotyp_original.jpg")));
		setTitle("MAH Infomall");
		setResizable(false);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1565, 799);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//PromptSupport.setPrompt("Välj en bild", uploadField);
		
		JLabel lblNewLabel = new JLabel("Bilden ska helst vara 550 x 500 pixlar:");
		lblNewLabel.setFont(new Font("Futura", Font.PLAIN, 16));
		lblNewLabel.setBounds(6, 10, 282, 26);
		contentPane.add(lblNewLabel);
		
		JButton uploadBtn = new JButton("V\u00E4lj bild fr\u00E5n din dator");
		uploadBtn.setFont(new Font("Futura Hv BT", Font.PLAIN, 20));
		uploadBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FileDialog fDialog = new FileDialog(frame, "Open", FileDialog.LOAD);
			    fDialog.setVisible(true);
			    String path = fDialog.getDirectory() + fDialog.getFile();
			    File f = new File(path);
			    ImageIcon imageIcon = new ImageIcon(path); // load the image to a imageIcon
			    Image image = imageIcon.getImage(); // transform it 
			    Image newimg = image.getScaledInstance(widthPreviewImage, heightPreviewImage,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
			    imageIcon = new ImageIcon(newimg);  // transform it back
			    uploadBildLabel.setIcon(new ImageIcon(newimg));  //lblBilden --> ska vara r�tt jlabel-icon i preview...
			}
		});
		uploadBtn.setBounds(6, 41, 365, 47);
		contentPane.add(uploadBtn);
		
		JButton rubrikBtn = new JButton("Ok");
		rubrikBtn.setFont(new Font("Futura Hv BT", Font.PLAIN, 16));
		rubrikBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rubrikLabel.setForeground(Color.BLACK);
				rubrikLabel.setText(rubrikField.getText());
				rubrikField.setText("");
				
			}
		});

		
		rubrikBtn.setBounds(300, 125, 71, 47);
		contentPane.add(rubrikBtn);
		
		rubrikField = new JTextField();
		rubrikField.setToolTipText("TEST");
		rubrikField.setFont(new Font("Futura", Font.PLAIN, 15));
		rubrikField.setColumns(10);
		rubrikField.setBounds(6, 125, 282, 47);
		contentPane.add(rubrikField);
		//PromptSupport.setPrompt("E.g. Sommarkurser i Niagara", rubrikField);
		
		JLabel lblRubrik = new JLabel(" Rubrik:\n");
		lblRubrik.setFont(new Font("Futura", Font.PLAIN, 16));
		lblRubrik.setBounds(6, 97, 282, 26);
		contentPane.add(lblRubrik);
		
		JButton datumTidBtn = new JButton("Ok");
		datumTidBtn.setFont(new Font("Futura Hv BT", Font.PLAIN, 16));
		datumTidBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tidLabel.setText(tidField.getText());
				tidField.setText("");
				tidLabel.setOpaque(true);
			}
		});
		datumTidBtn.setBounds(300, 292, 71, 47);
		contentPane.add(datumTidBtn);
		datumField = new JTextField();
		datumField.setFont(new Font("Futura", Font.PLAIN, 15));
		datumField.setColumns(10);
		contentPane.add(datumField);
		datumField.setBounds(6, 292, 117, 47);
		//PromptSupport.setPrompt("E.g. DD/MM -16", datumField);
		
		
		
		JLabel lblDatum = new JLabel(" Datum\n");
		lblDatum.setFont(new Font("Futura", Font.PLAIN, 16));
		lblDatum.setBounds(6, 262, 117, 26);
		contentPane.add(lblDatum);
		
		JButton platsBtn = new JButton("Ok");
		platsBtn.setFont(new Font("Futura Hv BT", Font.PLAIN, 16));
		platsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				platsLabel.setText(platsField.getText());
				platsField.setText("");
				platsLabel.setOpaque(true);
			
				
			}
		});
		platsBtn.setBounds(300, 210, 71, 47);
		contentPane.add(platsBtn);
		
		platsField = new JTextField();
		platsField.setFont(new Font("Futura", Font.PLAIN, 15));
		platsField.setColumns(10);
		platsField.setBounds(6, 210, 282, 47);
		contentPane.add(platsField);
		//PromptSupport.setPrompt("E.g. Plats", platsField);
		
		JLabel lblPlats = new JLabel(" Plats:");
		lblPlats.setFont(new Font("Futura", Font.PLAIN, 16));
		lblPlats.setBounds(6, 178, 138, 26);
		contentPane.add(lblPlats);
		
		JLabel lblTid = new JLabel(" Tid");
		lblTid.setFont(new Font("Futura", Font.PLAIN, 16));
		lblTid.setBounds(193, 262, 43, 26);
		contentPane.add(lblTid);
		
		JLabel lblInformation = new JLabel("Information:");
		lblInformation.setFont(new Font("Futura", Font.PLAIN, 16));
		lblInformation.setBounds(6, 355, 282, 26);
		contentPane.add(lblInformation);
		
		//JButton avbrytBtn = new JButton("Avbryt");
		//avbrytBtn.setBounds(726, 613, 117, 47);
		//contentPane.add(avbrytBtn);

		panel = new Panel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(377, 42, widthPreview,heightPreview);
		contentPane.add(panel);
		panel.setLayout(null);
				
		JButton sparaBtn = new JButton("Spara bilden");
		sparaBtn.setForeground(Color.WHITE);
		sparaBtn.setFont(new Font("Futura Hv BT", Font.PLAIN, 20));
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
					//int width = 1000, height = 650;
					Container c = getContentPane();
					c = panel;
					c.setSize(widthPreview, heightPreview);
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
		sparaBtn.setBounds(1363, 696, 166, 47);
		contentPane.add(sparaBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 384, 365, 359);
		contentPane.add(scrollPane);
		
		JTextArea infoField = new JTextArea();
		infoField.setFont(new Font("Sabon", Font.PLAIN, 22));
		infoField.setBorder(new EmptyBorder(10, 10, 10, 10));
		infoField.setWrapStyleWord(true);
		infoField.setLineWrap(true);
		scrollPane.setViewportView(infoField);
		
		JButton infoBtn = new JButton("Ok");
		infoBtn.setFont(new Font("Futura Hv BT", Font.PLAIN, 16));
		infoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				infoTextArea.setText(infoField.getText());
			}
		});
		infoBtn.setBounds(377, 696, 65, 47);
		contentPane.add(infoBtn);
		
		tidField = new JTextField();
		tidField.setFont(new Font("Futura", Font.PLAIN, 15));
		tidField.setColumns(10);
		tidField.setBounds(193, 292, 104, 47);
		contentPane.add(tidField);
		//PromptSupport.setPrompt("E.g. 12:00", tidField);
		
		
		JLabel lblFrhandsgrandska = new JLabel("F\u00F6rhandsgrandska\r\n");
		lblFrhandsgrandska.setFont(new Font("Futura", Font.PLAIN, 16));
		lblFrhandsgrandska.setBounds(377, 10, 150, 26);
		contentPane.add(lblFrhandsgrandska);
		
		uploadBildLabel = new JLabel("Din bild: \n550 x 500 pixlar");
		uploadBildLabel.setFont(new Font("Futura Hv BT", Font.PLAIN, 20));
		uploadBildLabel.setHorizontalAlignment(SwingConstants.CENTER);
		uploadBildLabel.setForeground(Color.WHITE);
		uploadBildLabel.setBounds(566, 85, 550, 500);
		
		panel.add(uploadBildLabel);
		
		rubrikLabel = new JLabel("Skriv en lockande rubrik");
		rubrikLabel.setBackground(Color.DARK_GRAY);
		rubrikLabel.setFont(new Font("Futura Hv BT", Font.PLAIN, 28));
		rubrikLabel.setForeground(Color.BLACK);
		rubrikLabel.setHorizontalAlignment(SwingConstants.LEFT);
		rubrikLabel.setBounds(149, 16, 967, 53);
		panel.add(rubrikLabel);
		
		datumlabel = new JLabel("");
		datumlabel.setBackground(Color.WHITE);
		datumlabel.setFont(new Font("Futura Hv BT", Font.PLAIN, 17));
		datumlabel.setHorizontalAlignment(SwingConstants.LEFT);
		datumlabel.setBounds(161, 163, 368, 21);
		panel.add(datumlabel);
		
		tidLabel = new JLabel("");
		tidLabel.setBackground(Color.WHITE);
		tidLabel.setFont(new Font("Futura Hv BT", Font.PLAIN, 17));
		tidLabel.setHorizontalAlignment(SwingConstants.LEFT);
		tidLabel.setBounds(161, 194, 368, 21);
		panel.add(tidLabel);
		
		JLabel label = new JLabel("PLATS: ");
		label.setBackground(Color.WHITE);
		label.setFont(new Font("Futura Hv BT", Font.PLAIN, 15));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(32, 132, 85, 21);
		panel.add(label);
		label.setOpaque(true);
		
		
		JLabel label_1 = new JLabel("DATUM: ");
		label_1.setBackground(Color.WHITE);
		label_1.setFont(new Font("Futura Hv BT", Font.PLAIN, 15));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(32, 163, 85, 21);
		panel.add(label_1);
		label_1.setOpaque(true);
		
		JLabel label_2 = new JLabel("TID: ");
		label_2.setBackground(Color.WHITE);
		label_2.setFont(new Font("Futura Hv BT", Font.PLAIN, 15));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(32, 194, 85, 21);
		panel.add(label_2);
		label_2.setOpaque(true);
		
		platsLabel = new JLabel("");
		platsLabel.setBackground(Color.WHITE);
		platsLabel.setFont(new Font("Futura Hv BT", Font.PLAIN, 17));
		platsLabel.setHorizontalAlignment(SwingConstants.LEFT);
		platsLabel.setBounds(161, 132, 368, 21);
		panel.add(platsLabel);
		
		infoTextArea = new JTextArea();
		infoTextArea.setBorder(new EmptyBorder(10, 10, 10, 10));
		infoTextArea.setText("H\u00E4r hamnar din informationstext.");
		infoTextArea.setWrapStyleWord(true);
		infoTextArea.setEditable(false);
		infoTextArea.setLineWrap(true);
		infoTextArea.setFont(new Font("Sabon", Font.PLAIN, 22));
		infoTextArea.setBounds(149, 232, 402, 353);
		panel.add(infoTextArea);
		infoTextArea.setOpaque(true);
		
		JLabel lblRubrikruta = new JLabel("");
		lblRubrikruta.setOpaque(true);
		lblRubrikruta.setBackground(Color.WHITE);
		lblRubrikruta.setBounds(0, 16, 1152, 51);
		panel.add(lblRubrikruta);
		
		JLabel label_3 = new JLabel("");
		label_3.setOpaque(true);
		label_3.setBackground(Color.WHITE);
		label_3.setBounds(985, 593, 167, 39);
		panel.add(label_3);
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setOpaque(true);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Sabon", Font.PLAIN, 22));
		textArea.setEditable(false);
		textArea.setBorder(new EmptyBorder(10, 10, 10, 10));
		textArea.setBounds(149, 85, 402, 148);
		panel.add(textArea);
		
		JButton button = new JButton("Ok");
		button.setFont(new Font("Futura Hv BT", Font.PLAIN, 16));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datumlabel.setText(datumField.getText());
				datumField.setText("");
				datumlabel.setOpaque(true);
			}
		});
		button.setBounds(125, 292, 65, 47);
		contentPane.add(button);
		
		txtCreators = new JTextField();
		txtCreators.setBorder(null);
		txtCreators.setEditable(false);
		txtCreators.setBackground(SystemColor.menu);
		txtCreators.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCreators.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtCreators.setText("Created by:  M. Bansell, K. Gelevska, M. H\u00E5kansson, J. H\u00E5konsson, M. Wendt, IDk15, MAH");
		txtCreators.setBounds(727, 723, 578, 26);
		contentPane.add(txtCreators);
		txtCreators.setColumns(10);
	}
}
