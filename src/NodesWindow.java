import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class NodesWindow {

	public JFrame frame;
	int noOfNodes;
	private JTextField textField;
	ArrayList<Node> nodes;
	JTextField[] textFields;
	Node start,temp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NodesWindow window = new NodesWindow(1);
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
	public NodesWindow(int n) {
		noOfNodes=n;
		nodes =new ArrayList<Node>();
		textFields= new JTextField[noOfNodes];
		initialize();
	}
///////////////////////////////////////////////////////l
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 451, 352);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 5, 342, 226);
		frame.getContentPane().add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		JButton btnNewButton = new JButton("Show Visual");
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int add=100;
				
				for(int i=0;i<noOfNodes;i++)
				{
					int data=Integer.parseInt(textFields[i].getText().toString());
					Node node = new Node(data);
					if(i==0) {
						temp=start=node;
						nodes.add(start);
					}
					else {
						temp.setNext(node);
						temp=node;
						
					}
			
					nodes.add(node);
					
				}
				home.visualize(nodes);
				frame.setVisible(false);
				home.frame.setVisible(true);
				
				
			}
		});
		btnNewButton.setBounds(10, 279, 103, 23);
		frame.getContentPane().add(btnNewButton);
		

		for(int i=0;i<noOfNodes;i++){
			Component verticalStrut = Box.createVerticalStrut(20);
			panel_2.add(verticalStrut);
			JPanel panel = new JPanel();
			panel_2.add(panel);
			panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));	
			
			Component horizontalStrut_1 = Box.createHorizontalStrut(20);
			panel.add(horizontalStrut_1);
			
			JLabel lblNewLabel = new JLabel("Node "+(i+1));
			panel.add(lblNewLabel);
			
			Component horizontalStrut = Box.createHorizontalStrut(40);
			panel.add(horizontalStrut);
			
			textField = new JTextField();
			panel.add(textField);
			textField.setColumns(10);
			textFields[i]=textField;
		}
	}
	
}
