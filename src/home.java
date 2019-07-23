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




public class home {

	static JFrame frame;
	JButton btnCreate;
	private static JPanel panel_2;
	static JPanel panelList;
	static ArrayList<Node> nodes;
	static JPanel panelNode; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home window   = new home();
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
	public home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	  private void initialize() {
	
		frame = new JFrame();
		frame.setBounds(0, 0, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	  
		
		Panel panel = new Panel();
		panel.setBounds(5, 5, 792, 33);
		panel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
	
		
		Label label = new Label("Type of LIST");
		label.setBounds(0, 5, 71, 22);
		panel.add(label);
	 
		
	
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(77, 5, 93, 20);
		comboBox.addItem("Singly List");
		comboBox.addItem("Doubly List");
		comboBox.addItem("Cirular List");
		panel.add(comboBox);
		
		Label label_1 = new Label("LIST OPERATIONS");
		label_1.setBounds(176 , 5, 121, 22);
		panel.add(label_1);
		
		btnCreate = new JButton("CREATE");
		btnCreate.setBounds(309, 4, 82, 23);
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CreateWindow win = new CreateWindow();
				win.frame.setVisible(true);
				frame.setVisible(false);
				
			}
		});
		btnCreate.setBackground(Color.WHITE);
		panel.add(btnCreate);
		
		JButton btnNewButton = new JButton("INSERT");
		btnNewButton.setBounds(401, 4, 82, 23);
		btnNewButton.setBackground(Color.WHITE);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(493, 5, 82, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("SEARCH");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(585, 5, 82, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("COUNT");
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBounds(677, 5, 83, 23);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("MODIFY");
		btnNewButton_4.setBounds(312, 33, 71, 23);
		panel.add(btnNewButton_4);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(35, 124, 648, 291);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 33, 567, 228);
		panel_1.add(scrollPane);
		
		panel_2 = new JPanel();
		scrollPane.setViewportView(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 80));
		
		panelList = new JPanel();
		panel_2.add(panelList);
		panelList.setLayout(new BoxLayout(panelList, BoxLayout.X_AXIS));
		
				
		
		

		
	//	
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
			lblNewLabel.setMinimumSize(new Dimension(40, 14));
			lblNewLabel.setMaximumSize(new Dimension(40, 14));
			lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			lblNewLabel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
			panelStart.add(lblNewLabel);
			
			JLabel lblStart = new JLabel(nodes.get(0).getAddress().hashCode()+"");
			lblStart.setPreferredSize(new Dimension(40, 14));
			lblStart.setMinimumSize(new Dimension(40, 14));
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
				panelElementLabel.setMinimumSize(new Dimension(120, 10));
				panelElementLabel.setMaximumSize(new Dimension(120, 20));
				panelElementLabel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.BLUE));
				panelNode.add(panelElementLabel);
				panelElementLabel.setLayout(new BoxLayout(panelElementLabel, BoxLayout.X_AXIS));
				
				JLabel lblData = new JLabel("DATA");
				lblData.setMinimumSize(new Dimension(40, 14));
				lblData.setMaximumSize(new Dimension(40, 14));
				lblData.setPreferredSize(new Dimension(40, 14));
				lblData.setBorder(new MatteBorder(0, 0, 0, 3, (Color) new Color(0, 0, 0)));
				panelElementLabel.add(lblData);
				
				Component horizontalStrut_1 = Box.createHorizontalStrut(20);
				panelElementLabel.add(horizontalStrut_1);
				
				JLabel lblLink = new JLabel("LINK");
				lblLink.setPreferredSize(new Dimension(40, 14));
				lblLink.setMinimumSize(new Dimension(40, 14));
				lblLink.setMaximumSize(new Dimension(40, 14));
				panelElementLabel.add(lblLink);
				JPanel panelElement = new JPanel();
				panelElement.setMinimumSize(new Dimension(120, 10));
				panelElement.setMaximumSize(new Dimension(120, 20));
				panelElement.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.BLUE));
				panelNode.add(panelElement);
				panelElement.setLayout(new BoxLayout(panelElement, BoxLayout.X_AXIS));
				
				JLabel lblData1 = new JLabel(nodes.get(i).getData()+"");
				lblData1.setPreferredSize(new Dimension(40, 14));
				lblData1.setMinimumSize(new Dimension(40, 14));
				lblData1.setMaximumSize(new Dimension(40, 14));
				lblData.setBorder(new MatteBorder(0, 0, 0, 3, (Color) new Color(0, 0, 0)));
				panelElement.add(lblData1);
				
				Component horizontalStrut_2 = Box.createHorizontalStrut(20);
				panelElement.add(horizontalStrut_2);
				
				JLabel lblLink1 = new JLabel("NULL");
				if(nodes.get(i).getNext()!=null)
					lblLink1.setText(nodes.get(i).getNext().hashCode()+"");
				lblLink1.setPreferredSize(new Dimension(40, 14));
				lblLink1.setMinimumSize(new Dimension(40, 14));
				lblLink1.setMaximumSize(new Dimension(40, 14));
				if(i>0)
				{
			
				}
				panelElement.add(lblLink1);
	  }
}
}