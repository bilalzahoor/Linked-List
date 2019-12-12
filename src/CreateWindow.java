import java. awt.EventQueue;

import  javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class CreateWindow {

	public JFrame frame;
	static home homeWin;
	public JTextField textFieldNoOfNodes;
	 public int n;
	 JLabel lblNumOnly;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateWindow window = new CreateWindow(homeWin);
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
	public CreateWindow(home home) {
		CreateWindow.homeWin=home;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		homeWin.btnNewButton.setEnabled(true);
		homeWin.btnCreate.setEnabled(true);
		homeWin.btnDelete.setEnabled(true);
		homeWin.btnDestroy.setEnabled(true);
		homeWin.lblSearch.setEnabled(true);
		homeWin.btnCount.setEnabled(true);
		
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				homeWin.btnNewButton.setEnabled(false);
				homeWin.btnDelete.setEnabled(false);
				homeWin.btnDestroy.setEnabled(false);
				homeWin.lblSearch.setEnabled(false);
				homeWin.btnCount.setEnabled(false);
				homeWin.lblError.setVisible(true);
				homeWin.comboBox.setEnabled(true);
				homeWin.btnCreate.setEnabled(true);
			}
			@Override
			public void windowOpened(WindowEvent arg0) {
				homeWin.lblError.setText("ENTER THE NO OF NODE`S!");
				homeWin.lblError.setVisible(true);
			}
		});
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(new Color(240, 230, 140));
		frame.setBounds(100, 100, 689, 415);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ENTER THE NUMBER OF NODES:");
		lblNewLabel.setFont(new Font("Nirmala UI", Font.BOLD, 16));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(111, 96, 247, 52);
		frame.getContentPane().add(lblNewLabel);
		
		textFieldNoOfNodes = new JTextField();
		textFieldNoOfNodes.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				char c = evt.getKeyChar();
				if(Character.isLetter(c) || Character.isWhitespace(c)){
					textFieldNoOfNodes.setEditable(false);
					lblNumOnly.setText("Enter Number`s Only!");
					
				}
				else{
					textFieldNoOfNodes.setEditable(true);
					lblNumOnly.setVisible(false);
				}
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				lblNumOnly.setText("");
			}
		});
		textFieldNoOfNodes.setBounds(361, 106, 125, 36);
		frame.getContentPane().add(textFieldNoOfNodes);
		textFieldNoOfNodes.setColumns(10);
		
		
		JButton btnNewButton = new JButton("CREATE");
		btnNewButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				lblNumOnly.setText("");
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Nirmala Ul", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(230, 230, 250));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				n = Integer.parseInt(textFieldNoOfNodes.getText().toString());
				//n = n;
				homeWin.lblSearch.setText(""+n);
				if(textFieldNoOfNodes.getText().trim().isEmpty()){
					lblNumOnly.setText("Field Is Empty!");
				}
				else{
				 n = Integer.parseInt(textFieldNoOfNodes.getText().toString());
				NodesWindow win = new NodesWindow(n);
				homeWin.lblError.setText("Enter The Element`s To be Stored!");
				win.frame.setVisible(true);
				frame.setVisible(false);
				}
			}
		});
		btnNewButton.setBounds(245, 190, 143, 35);
		frame.getContentPane().add(btnNewButton);
		
		lblNumOnly = new JLabel("");
		lblNumOnly.setBounds(393, 265, 152, 16);
		frame.getContentPane().add(lblNumOnly);
	}
}
