import java. awt.EventQueue;

import  javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;


public class CreateWindow {

	public JFrame frame;
	private JTextField textFieldNoOfNodes;
	 public int n;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateWindow window = new CreateWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreateWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(new Color(245, 255, 250));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter the number of Nodes");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(33, 66, 188, 52);
		frame.getContentPane().add(lblNewLabel);
		
		textFieldNoOfNodes = new JTextField();
		textFieldNoOfNodes.setBounds(219, 82, 71, 20);
		frame.getContentPane().add(textFieldNoOfNodes);
		textFieldNoOfNodes.setColumns(10);
		
		
		JButton btnNewButton = new JButton("CREATE");
		btnNewButton.setBackground(new Color(230, 230, 250));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				 n = Integer.parseInt(textFieldNoOfNodes.getText().toString());
				NodesWindow win = new NodesWindow(n);
				win.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(121, 143, 134, 20);
		frame.getContentPane().add(btnNewButton);
	}
}
