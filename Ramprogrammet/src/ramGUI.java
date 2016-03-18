import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.text.DecimalFormat;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Dimension;

public class ramGUI extends JFrame {

	private JPanel contentPane;
	private ramProgramLogic ramprogramLogic;
	private JLabel clockLabel;
	DecimalFormat timeFormat = new DecimalFormat("00");

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ramGUI frame = new ramGUI();
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
	public ramGUI() {
		
		setMinimumSize(new Dimension(1920, 1080));
		setSize(new Dimension(1920, 1080));
		this.setUndecorated(true);


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 861, 624);
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);

		clockLabel = new JLabel("");
		clockLabel.setForeground(SystemColor.desktop);
		clockLabel.setBackground(SystemColor.controlLtHighlight);
		clockLabel.setFont(new Font("Futura", Font.BOLD, 26));
		clockLabel.setBounds(1655, 982, 205, 38);
		contentPane.add(clockLabel);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBounds(1645, 979, 215, 41);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ramGUI.class.getResource("/test/sommarkurser.jpg")));
		lblNewLabel.setBounds(0, 0, 1920, 1080);
		contentPane.add(lblNewLabel);

		ramprogramLogic = new ramProgramLogic(this);

	}

	public void setTimeOnLabel(String AlarmTime) {
		// TODO Auto-generated method stub
		clockLabel.setText(AlarmTime);
	}
}