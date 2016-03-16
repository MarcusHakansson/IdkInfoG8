import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.text.DecimalFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Dimension;

public class ClockGUI extends JFrame {

	private JPanel contentPane;
	private ClockLogic clockLogic;
	private JLabel clockLabel;
	DecimalFormat timeFormat = new DecimalFormat("00");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClockGUI frame = new ClockGUI();
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
	public ClockGUI() {
		setMinimumSize(new Dimension(1920, 1080));
		setSize(new Dimension(1920, 1080));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 861, 624);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);

		clockLabel = new JLabel("");
		clockLabel.setForeground(SystemColor.desktop);
		clockLabel.setBackground(SystemColor.controlLtHighlight);
		clockLabel.setFont(new Font("Futura", Font.BOLD, 18));
		clockLabel.setBounds(1752, 982, 138, 38);
		contentPane.add(clockLabel);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBounds(1748, 979, 142, 41);
		contentPane.add(panel);

		clockLogic = new ClockLogic(this);

	}

	public void setTimeOnLabel(String AlarmTime) {
		// TODO Auto-generated method stub
		clockLabel.setText(AlarmTime);
	}
}
