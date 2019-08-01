import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;

import java.awt.Font;




public class home {

	static JFrame frame;
	JButton btnCreate;
	private static JPanel panel_2;
	static JPanel panelList;
	static ArrayList<Node> nodes;
	static JPanel panelNode; 
	JPanel panelInsert;
	JPanel Deletepanel;
	private JTextField textFieldInsertElement;
	private JTextField textField;
	private JTextField Index;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main (String[]args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home window   = new home();
					home.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	  private void initialize() {
	
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 248, 255));
		frame.setBounds(0, 0, 1053, 644);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBounds(0, 0, 1035, 597);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 77, 639, 405);
		panel_1.add(scrollPane);
		
		panel_2 = new JPanel();
		scrollPane.setViewportView(panel_2);
		panel_2.setBackground(new Color(253, 245, 230));
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 80));
		
		
		panelList = new JPanel();
		panel_2.add(panelList);
		panelList.setLayout(new BoxLayout(panelList, BoxLayout.X_AXIS));
		
		
		Panel panel = new Panel();
		panel.setBounds(0, 0, 1035, 58);
		panel_1.add(panel);
		panel.setBackground(new Color(255, 222, 173));
		panel.setLayout(null);
		
			
			Label label = new Label("TYPE OF LIST");
			label.setFont(new Font("Dialog", Font.BOLD, 12));
			label.setBounds(30, 5, 83, 22);
			panel.add(label);
			
		
	
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(230, 230, 250));
		comboBox.setBounds(120, 7, 93, 20);
		comboBox.addItem("SINGLY LIST");
		comboBox.addItem("DOUBLY LIST");
		comboBox.addItem("CIRCULAR LIST");
		panel.add(comboBox);
		
		Label label_1 = new Label("LIST OPERATIONS");
		label_1.setFont(new Font("Dialog", Font.BOLD, 12));
		label_1.setBounds(263 , 5, 121, 22);
		panel.add(label_1);
		
		btnCreate = new JButton("CREATE");
		btnCreate.setBounds(389, 5, 82, 23);
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CreateWindow win = new CreateWindow();
				win.frame.setVisible(true);
				frame.setVisible(false);
				
			}
		});
		btnCreate.setBackground(new Color(230, 230, 250));
		panel.add(btnCreate);
		
		JButton btnNewButton = new JButton("INSERT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(nodes!=null){
					panelInsert.setVisible(true);
				}
				
			}
		});
		btnNewButton.setBounds(483, 4, 82, 23);
		btnNewButton.setBackground(new Color(230, 230, 250));
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.addActionListener(new ActionListener() {
			
         public void actionPerformed(ActionEvent arg0) {
        	 if(nodes!=null){
					Deletepanel.setVisible(true);
					
				}
			
			}
         }
		);
		btnNewButton_1.setBackground(new Color(230, 230, 250));
		btnNewButton_1.setBounds(577, 5, 82, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("SEARCH");
		btnNewButton_2.setBackground(new Color(230, 230, 250));
		btnNewButton_2.setBounds(671, 4, 82, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("COUNT");
		btnNewButton_3.setBackground(new Color(230, 230, 250));
		btnNewButton_3.setBounds(765, 4, 83, 23);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("MODIFY");
		btnNewButton_4.setBounds(860, 4, 100, 23);
		panel.add(btnNewButton_4);
		 
		
		panelInsert = new JPanel();
		panelInsert.setBounds(672, 77, 262, 165);
		panel_1.add(panelInsert);
		panelInsert.setBackground(new Color(222, 184, 135));
		panelInsert.setVisible(false);
		panelInsert.setLayout(null);
		
		JButton btnNewButton_6 = new JButton("END");
		btnNewButton_6.setBackground(new Color(230, 230, 250));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int ele = Integer.parseInt(textFieldInsertElement.getText());
				Node n = new Node(ele);
				nodes.get(nodes.size()-1).setNext(n);
				nodes.add(n);
				panelList.removeAll();
				home.visualize(nodes);
				
				panelList.getRootPane().revalidate();
			}
		});
		btnNewButton_6.setBounds(20, 73, 101, 23);
		panelInsert.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("FRONT");
		btnNewButton_7.setBackground(new Color(230, 230, 250));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int ele = Integer.parseInt(textFieldInsertElement.getText());
				Node n = new Node(ele);
				nodes.add(1,n);
				nodes.get(0).setNext(n.getAddress());
				n.setNext(nodes.get(2).getAddress());
				panelList.removeAll();
				home.visualize(nodes);
				//n++;
				
				panelList.getRootPane().revalidate();
				
				
				
			}
		});
		btnNewButton_7.setBounds(20, 37, 101, 23);
		panelInsert.add(btnNewButton_7);
		
		textFieldInsertElement = new JTextField();
		textFieldInsertElement.setBounds(190, 7, 60, 18);
		panelInsert.add(textFieldInsertElement);
		textFieldInsertElement.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter the element to Insert");
		lblNewLabel_1.setBounds(20, 9, 168, 15);
		panelInsert.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		
		Index = new JTextField();
		Index.setBounds(147, 110, 74, 22);
		panelInsert.add(Index);
		Index.setColumns(10);
		
		JButton SetPosition = new JButton("INSERT AT");
		SetPosition.setBackground(new Color(230, 230, 250));
		SetPosition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int ele = Integer.parseInt(textFieldInsertElement.getText());
				Node n = new Node(ele);
				int index1 = Integer.parseInt(Index.getText().toString());		
				nodes.add(index1,n);
				nodes.get(0).setNext(n.getAddress());
				index1++;
				n.setNext(nodes.get(index1).getAddress());
				panelList.removeAll();
				home.visualize(nodes);
				//n++;
				
				panelList.getRootPane().revalidate();
				}
		});
		SetPosition.setBounds(20, 109, 101, 25);
		panelInsert.add(SetPosition);
		
		Deletepanel = new JPanel();
		Deletepanel.setBackground(new Color(222, 184, 135));
		Deletepanel.setBounds(672, 288, 262, 182);
		panel_1.add(Deletepanel);
		Deletepanel.setVisible(false);
		
		Deletepanel.setLayout(null);
		
		JButton btnNewButton_5 = new JButton("FRONT");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Node n = nodes.get(1).getAddress();
				nodes.get(0).setNext(n);
				nodes.remove(1);
				panelList.removeAll();
				home.visualize(nodes);
				//n++;
				
				panelList.getRootPane().revalidate();
			
			}
		
		});
		btnNewButton_5.setBounds(12, 64, 97, 25);
		Deletepanel.add(btnNewButton_5);
		
		JButton btnNewButton_8 = new JButton("END");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnNewButton_8.setBounds(12, 103, 97, 25);
		Deletepanel.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("DELETE AT");
		btnNewButton_9.setBounds(12, 144, 97, 25);
		Deletepanel.add(btnNewButton_9);
		
		textField_1 = new JTextField();
		textField_1.setBounds(134, 145, 83, 22);
		Deletepanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDeleteNode = new JLabel("DELETE NODE");
		lblDeleteNode.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDeleteNode.setBounds(67, 13, 111, 25);
		Deletepanel.add(lblDeleteNode);
		
		
		
		
		
				
		
		

		
		
	//}
	  }
	   static void visualize(ArrayList<Node> n){
		  nodes=n;
		  JPanel panelStart = new JPanel();
			panelStart.setBorder(new LineBorder(new Color(0, 0, 0)));
			panelList.add(panelStart);
			panelStart.setLayout(new BoxLayout(panelStart, BoxLayout.Y_AXIS));
			
			JLabel lblNewLabel = new JLabel("START");
			lblNewLabel.setPreferredSize(new Dimension(40, 14));
			lblNewLabel.setMaximumSize(new Dimension(40, 14));
			lblNewLabel.setMaximumSize(new Dimension(40, 14));
			lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			lblNewLabel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
			panelStart.add(lblNewLabel);
			
			JLabel lblStart = new JLabel(nodes.get(0).getAddress().hashCode()+"");
			lblStart.setPreferredSize(new Dimension(40, 14));
			lblStart.setMaximumSize(new Dimension(40, 14));
			lblStart.setMaximumSize(new Dimension(40, 14));
			lblStart.setAlignmentX(Component.CENTER_ALIGNMENT);
			panelStart.add(lblStart);
			
			Component horizontalStrut = Box.createHorizontalStrut(40);
			panel_2.add(horizontalStrut);

		 for(int i=1;i<nodes.size();i++){
				panelNode = new JPanel();
				panelNode.setBorder(new LineBorder(new Color(0, 0, 0), 2));
				panelList.add(panelNode);
				
		panelList.add(horizontalStrut);
				//panelList.add
				panelNode.setLayout(new BoxLayout(panelNode, BoxLayout.Y_AXIS));
				
				JLabel lblAddress = new JLabel("ADD:"+nodes.get(i).getAddress().hashCode());
				lblAddress.setAlignmentX(Component.CENTER_ALIGNMENT);
				lblAddress.setHorizontalTextPosition(SwingConstants.CENTER);
				lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
			
				lblAddress.setMinimumSize(new Dimension(120, 14));
				lblAddress.setMaximumSize(new Dimension(120, 14));
				lblAddress.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.BLUE));
				panelNode.add(lblAddress);
				
				JPanel panelElementLabel = new JPanel();
				panelElementLabel.setMaximumSize(new Dimension(120, 10));
				panelElementLabel.setMaximumSize(new Dimension(120, 20));
				panelElementLabel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.BLUE));
				panelNode.add(panelElementLabel);
				panelElementLabel.setLayout(new BoxLayout(panelElementLabel, BoxLayout.X_AXIS));
				
				JLabel lblData = new JLabel("DATA");
				lblData.setMaximumSize(new Dimension(40, 14));
				lblData.setMaximumSize(new Dimension(40, 14));
				lblData.setPreferredSize(new Dimension(40, 14));
				lblData.setBorder(new MatteBorder(0, 0, 0, 3, (Color) new Color(0, 0, 0)));
				panelElementLabel.add(lblData);
				
				Component horizontalStrut_1 = Box.createHorizontalStrut(20);
				panelElementLabel.add(horizontalStrut_1);
				
				JLabel lblLink = new JLabel("LINK");
				lblLink.setPreferredSize(new Dimension(40, 14));
				lblLink.setMaximumSize(new Dimension(40, 14));
				lblLink.setMaximumSize(new Dimension(40, 14));
				panelElementLabel.add(lblLink);
				JPanel panelElement = new JPanel();
				panelElement.setMaximumSize(new Dimension(120, 10));
				panelElement.setMaximumSize(new Dimension(120, 20));
				panelElement.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.BLUE));
				panelNode.add(panelElement);
				panelElement.setLayout(new BoxLayout(panelElement, BoxLayout.X_AXIS));
				
				JLabel lblData1 = new JLabel(nodes.get(i).getData()+"");
				lblData1.setPreferredSize(new Dimension(40, 14));
				lblData1.setMaximumSize(new Dimension(40, 14));
				lblData1.setMaximumSize(new Dimension(40, 14));
				lblData.setBorder(new MatteBorder(0, 0, 0, 3, (Color) new Color(0, 0, 0)));
				panelElement.add(lblData1);
				
				Component horizontalStrut_2 = Box.createHorizontalStrut(20);
				panelElement.add(horizontalStrut_2);
				
				JLabel lblLink1 = new JLabel("NULL");
				if(nodes.get(i).getNext()!=null)
					lblLink1.setText(nodes.get(i).getNext().hashCode()+"");
				lblLink1.setPreferredSize(new Dimension(40, 14));
				lblLink1.setMaximumSize(new Dimension(40, 14));
				lblLink1.setMaximumSize(new Dimension(40, 14));
				if(i>0)
				{
			
				}
				panelElement.add(lblLink1);
     }
}
}