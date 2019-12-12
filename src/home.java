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

import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;




public class home {

	static JFrame frame;
	static home homeWin;
	JButton btnCreate;
	JLabel lblSearch;
	private static JPanel panel_2;
	static JPanel panelList;
	static ArrayList<Node> nodes;
	static JLabel lblError;
	static JPanel panelNode;
	static JLabel lblLink2;
	static JLabel lblLink1;
	JPanel panelInsert;
	JPanel Deletepanel;
	JButton btnNewButton;
	JButton btnDelete;
	JButton btnDestroy;
	JRadioButton radioButton;
	JRadioButton rdbtnAt;
	JButton btnAtF;
	JButton btnAtR;
	JButton btnAtSP;
	JRadioButton rdbtnDat;
	JRadioButton rdbtnDatSP;
	JButton btnDatF;
	JButton btnDatR;
	JButton btnDatSP;
	JButton btnCount;
	JComboBox<Object> comboBox;
	private JTextField textFieldInsertElement;
	private JTextField Index;
	private JTextField Index1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JScrollPane structScroll;
	private JLabel lblEntrele;
	private static String LinkListType;
	

	/**
	 * Launch the application.
	 */
	public static void main (String[]args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home window   = new home();
					homeWin=window;
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
		LinkListType="SL";
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	  private void initialize() {
	
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 248, 255));
		frame.setBounds(0, 0, 1429, 809);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Panel MainPnl = new Panel();
		MainPnl.setBackground(new Color(233, 150, 122));
		MainPnl.setBounds(0, 0, 1379, 752);
		frame.getContentPane().add(MainPnl);
		MainPnl.setLayout(null);
		
		
		Panel panel = new Panel();
		panel.setBounds(0, 0, 1374, 63);
		MainPnl.add(panel);
		panel.setBackground(new Color(222, 184, 135));
		panel.setLayout(null);
		
			
			Label label = new Label("TYPE OF LIST:");
			label.setFont(new Font("Nirmala UI", Font.BOLD, 16));
			label.setBounds(31, 7, 121, 36);
			panel.add(label);
			
		
	
		
		comboBox = new JComboBox<Object>();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				String s =comboBox.getSelectedItem().toString();
				if(s.compareTo("SINGLY LIST")==0){
					LinkListType="SL";
					
				}
				else if(s.compareTo("CIRCULAR LIST")==0){
					LinkListType="CL";
				}
				else if(s.compareTo("DOUBLY LIST")==0){
					LinkListType="DL";
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"SINGLY LIST", "CIRCULAR LIST","DOUBLY LIST" }));
		comboBox.setFont(new Font("Nirmala UI", Font.BOLD, 14));
		comboBox.setBackground(new Color(230, 230, 250));
		comboBox.setBounds(158, 7, 142, 36);
		panel.add(comboBox);
		
		Label lblOprList = new Label("LIST OF  OPERATIONS:");
		lblOprList.setFont(new Font("Nirmala UI", Font.BOLD, 16));
		lblOprList.setBounds(389 , 10, 195, 33);
		panel.add(lblOprList);
		
		btnCreate = new JButton("CREATE");
		btnCreate.setFont(new Font("Nirmala UI", Font.BOLD, 14));
		btnCreate.setBounds(590, 7, 142, 36);
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CreateWindow win = new CreateWindow(homeWin);
				win.frame.setVisible(true);
				//frame.setVisible(false);
				btnCreate.setEnabled(false);
				lblError.setVisible(false);
				comboBox.setEnabled(false);
			}
		});
		btnCreate.setBackground(Color.LIGHT_GRAY);
		panel.add(btnCreate);
		
		btnNewButton = new JButton("INSERT");
		btnNewButton.setFont(new Font("Nirmala UI", Font.BOLD, 14));
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					textFieldInsertElement.setText("");
					Index.setText("");
					panelInsert.setVisible(true);
					Deletepanel.setVisible(false);
					btnNewButton.setEnabled(false);
					btnDelete.setEnabled(true);
					lblSearch.setVisible(false);
					
					
					
				}
				
			}
		);
		btnNewButton.setBounds(744, 9, 144, 34);
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		panel.add(btnNewButton);
		
		btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Nirmala UI", Font.BOLD, 14));
		btnDelete.setEnabled(false);
		btnDelete.addActionListener(new ActionListener() {
			
         public void actionPerformed(ActionEvent arg0) {
        	 if(nodes!=null){
					Deletepanel.setVisible(true);
					panelInsert.setVisible(false);
					btnNewButton.setEnabled(true);
					btnDelete.setEnabled(false);
					lblSearch.setVisible(false);
					
				}
			
			}
         }
		);
		btnDelete.setBackground(Color.LIGHT_GRAY);
		btnDelete.setBounds(900, 9, 144, 34);
		panel.add(btnDelete);
		
		lblSearch = new JLabel();
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.setFont(new Font("Nirmala UI", Font.BOLD, 14));
		lblSearch.setEnabled(false);
		lblSearch.setBackground(new Color(176, 196, 222));
		lblSearch.setBounds(1293, 7, 69, 34);
		lblSearch.setVisible(false);
		panel.add(lblSearch);
		
		
		btnDestroy = new JButton("DESTROY");
		btnDestroy.setBounds(1049, 7, 121, 36);
		panel.add(btnDestroy);
		btnDestroy.setEnabled(false);
		btnDestroy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelList.removeAll();
				panelList.getRootPane().revalidate();
				btnCreate.setEnabled(true);
				lblError.setVisible(true);
				btnNewButton.setEnabled(false);
				btnDelete.setEnabled(false);
				btnDestroy.setEnabled(false);
				lblError.setText("LinkedList Destroyed!");
				lblSearch.setText(null);
				lblSearch.setVisible(false);
				btnCount.setEnabled(false);
				comboBox.setEnabled(true);
				
					
					
					
				}
			}
		);
		btnDestroy.setFont(new Font("Nirmala UI", Font.BOLD, 14));
		btnDestroy.setBackground(Color.LIGHT_GRAY);
		
		btnCount = new JButton("Count");
		btnCount.setEnabled(false);
		btnCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblSearch.setVisible(true);
			}
		});
		btnCount.setBounds(1172, 7, 121, 36);
		panel.add(btnCount);
		btnCount.setFont(new Font("Nirmala UI", Font.BOLD, 14));
		btnCount.setBackground(Color.LIGHT_GRAY);
		 
		
		panelInsert = new JPanel();
		panelInsert.setBounds(983, 69, 369, 225);
		MainPnl.add(panelInsert);
		panelInsert.setBackground(new Color(240, 230, 140));
		panelInsert.setVisible(false);
		panelInsert.setLayout(null);
		
		btnAtR = new JButton("END");
		btnAtR.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		btnAtR.setBackground(new Color(224, 255, 255));
		btnAtR.setBounds(22, 107, 126, 34);
		panelInsert.add(btnAtR);
		btnAtR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InsertAtRear();
				}			
		});
		
		
		btnAtF = new JButton("FRONT");
		btnAtF.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		btnAtF.setBackground(new Color(224, 255, 255));
		btnAtF.setBounds(22, 60, 126, 34);
		panelInsert.add(btnAtF);
		btnAtF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				lblEntrele.setText("");
			}
		});
		btnAtF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			InsertAtFront();
				}
			}
		);
		
		
		textFieldInsertElement = new JTextField();
		textFieldInsertElement.setForeground(Color.BLACK);
		textFieldInsertElement.setBounds(252, 15, 107, 32);
		panelInsert.add(textFieldInsertElement);
		textFieldInsertElement.setColumns(10);
		textFieldInsertElement.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				lblEntrele.setText(null);
			}
			@Override
			public void keyPressed(KeyEvent evt) {
				char c = evt.getKeyChar();
				if(Character.isLetter(c) || Character.isWhitespace(c)){
					Index.setEditable(false);
					lblEntrele.setVisible(true);
					lblEntrele.setText("Enter Number`s Only!");
					
				}
				else{
					Index.setEditable(true);
					lblEntrele.setVisible(false);
				}
			}
		});
		
		JLabel lblEntr = new JLabel("ENTER THE ELEMENT TO INSERT:");
		lblEntr.setBounds(12, 13, 240, 34);
		panelInsert.add(lblEntr);
		lblEntr.setFont(new Font("Nirmala UI", Font.BOLD, 15));
		
		Index = new JTextField();
		Index.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				char c = evt.getKeyChar();
				if(Character.isLetter(c) || Character.isWhitespace(c)){
					Index.setEditable(false);
					lblEntrele.setVisible(true);
					lblEntrele.setText("Enter Number`s Only!");
					
				}
				else{
					Index.setEditable(true);
					lblEntrele.setVisible(false);
				}
			}
		});
		Index.setBounds(252, 160, 107, 34);
		Index.setEnabled(false);
		panelInsert.add(Index);
		Index.setColumns(10);
		
		btnAtSP = new JButton("INSERT AT");
		btnAtSP.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		btnAtSP.setBackground(new Color(224, 255, 255));
		btnAtSP.setEnabled(false);
		btnAtSP.setBounds(22, 160, 126, 34);
		panelInsert.add(btnAtSP);
		btnAtSP.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				InsertAtSP();
			}
		});
		
		
		radioButton = new JRadioButton("");
		radioButton.setBackground(new Color(240, 230, 140));
		radioButton.setSelected(true);
		buttonGroup.add(radioButton);
		radioButton.setBounds(156, 90, 25, 25);
		panelInsert.add(radioButton);
		radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAtSP.setEnabled(false);
				Index.setEnabled(false);
				btnAtF.setEnabled(true);
				btnAtR.setEnabled(true);
			}
		});
		
		
		rdbtnAt = new JRadioButton("");
		rdbtnAt.setBackground(new Color(240, 230, 140));
		buttonGroup.add(rdbtnAt);
		rdbtnAt.setBounds(156, 165, 25, 25);
		panelInsert.add(rdbtnAt);
		rdbtnAt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAtF.setEnabled(false);
				btnAtR.setEnabled(false);
				btnAtSP.setEnabled(true);
				Index.setEnabled(true);
			}
		});
		
		
		lblEntrele = new JLabel("");
		lblEntrele.setFont(new Font("Century", Font.BOLD, 13));
		lblEntrele.setForeground(new Color(255, 0, 0));
		lblEntrele.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntrele.setBounds(166, 207, 158, 16);
		lblEntrele.setVisible(false);
		panelInsert.add(lblEntrele);
		
		Deletepanel = new JPanel();
		Deletepanel.setBackground(new Color(240, 230, 140));
		Deletepanel.setBounds(983, 318, 362, 225);
		MainPnl.add(Deletepanel);
		Deletepanel.setVisible(false);
		
		Deletepanel.setLayout(null);
		
		btnDatF = new JButton("FRONT");
		btnDatF.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		btnDatF.setBackground(new Color(224, 255, 255));
		btnDatF.setBounds(32, 60, 122, 34);
		Deletepanel.add(btnDatF);
		btnDatF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 DelAtFront();
				}
		});
		
		
		btnDatR = new JButton("END");
		btnDatR.setForeground(new Color(0, 0, 0));
		btnDatR.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		btnDatR.setBackground(new Color(224, 255, 255));
		btnDatR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DelAtR();
			
			
			}
		});
		btnDatR.setBounds(32, 108, 122, 34);
		Deletepanel.add(btnDatR);
		
		btnDatSP = new JButton("DELETE AT");
		btnDatSP.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		btnDatSP.setEnabled(false);
		btnDatSP.setBackground(new Color(224, 255, 255));
		btnDatSP.setBounds(32, 167, 122, 34);
		Deletepanel.add(btnDatSP);
		btnDatSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DelAtSP();
			}
		});
		
		JLabel lblDeleteNode = new JLabel("DELETE NODE:");
		lblDeleteNode.setFont(new Font("Nirmala UI", Font.BOLD, 15));
		lblDeleteNode.setBounds(121, 13, 111, 34);
		Deletepanel.add(lblDeleteNode);
		
		Index1 = new JTextField();
		Index1.setBounds(239, 167, 111, 34);
		Index1.setEnabled(false);
		Deletepanel.add(Index1);
		Index1.setColumns(10);
		
		rdbtnDat = new JRadioButton("");
		rdbtnDat.setBackground(new Color(240, 230, 140));
		rdbtnDat.setSelected(true);
		buttonGroup_1.add(rdbtnDat);
		rdbtnDat.setBounds(162, 90, 30, 34);
		Deletepanel.add(rdbtnDat);
		rdbtnDat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnDatF.setEnabled(true);
				btnDatR.setEnabled(true);
				btnDatSP.setEnabled(false);
				Index1.setEnabled(false);
			}
		});
		
		rdbtnDatSP = new JRadioButton("");
		rdbtnDatSP.setBackground(new Color(240, 230, 140));
		buttonGroup_1.add(rdbtnDatSP);
		rdbtnDatSP.setBounds(162, 167, 30, 34);
		Deletepanel.add(rdbtnDatSP);
		rdbtnDatSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnDatSP.setEnabled(true);
				Index1.setEnabled(true);
				btnDatF.setEnabled(false);
				btnDatR.setEnabled(false);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 69, 971, 683);
		MainPnl.add(scrollPane);
		
		panel_2 = new JPanel();
		scrollPane.setViewportView(panel_2);
		panel_2.setBackground(new Color(253, 245, 230));
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 80));
		
		Component verticalStrut = Box.createVerticalStrut(500);
		panel_2.add(verticalStrut);
		
		
		panelList = new JPanel();
		panel_2.add(panelList);
		panelList.setLayout(new BoxLayout(panelList, BoxLayout.X_AXIS));
		
		structScroll = new JScrollPane();
		panelList.add(structScroll);
		
		lblError = new JLabel("LinkedList Visual`s!");
		lblError.setFont(new Font("Century Schoolbook", Font.BOLD, 40));
		lblError.setVisible(true);
		panel_2.add(lblError);
		
	 //}
	  }
	  
	   static void visualize(ArrayList<Node> n){
		   
		  nodes=n;
		  	JPanel panelStart = new JPanel();
			panelStart.setBorder(new LineBorder(new Color(0, 0, 0)));
			panelList.add(panelStart);
			panelStart.setLayout(new BoxLayout(panelStart, BoxLayout.Y_AXIS));
			
			JLabel lblNewLabel = new JLabel("FIRST ELEMENT");
			lblNewLabel.setPreferredSize(new Dimension(180, 20));
			lblNewLabel.setMinimumSize(new Dimension(180, 20));
			lblNewLabel.setMaximumSize(new Dimension(180, 20));
			lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
			panelStart.add(lblNewLabel);
			
			JLabel lblEntr = new JLabel(""+nodes.get(1).getData());
			lblEntr.setMinimumSize(new Dimension(180, 20));
			lblEntr.setMaximumSize(new Dimension(180, 20));
			lblEntr.setAlignmentX(Component.CENTER_ALIGNMENT);
			lblEntr.setHorizontalTextPosition(SwingConstants.CENTER);
			lblEntr.setHorizontalAlignment(SwingConstants.CENTER);
			lblEntr.setBorder(new LineBorder(Color.BLUE));
			panelStart.add(lblEntr);
			
			JLabel lblStart = new JLabel("ADD: "+nodes.get(1).getAddress().hashCode());
			lblStart.setPreferredSize(new Dimension(180, 20));
			lblStart.setMinimumSize(new Dimension(180, 20));
			lblStart.setMaximumSize(new Dimension(180, 20));
			lblStart.setAlignmentX(Component.CENTER_ALIGNMENT);
			lblStart.setHorizontalTextPosition(SwingConstants.CENTER);
			lblStart.setHorizontalAlignment(SwingConstants.CENTER);
			lblStart.setBorder(new LineBorder(new Color(0, 0, 0), 1));
			panelStart.add(lblStart);
			
			Component horizontalStrut = Box.createHorizontalStrut(40);
			panel_2.add(horizontalStrut);
			
		 for(int i=1;i<nodes.size();i++){
				panelNode = new JPanel();
				panelNode.setBorder(new LineBorder(new Color(0, 0, 0), 3));
				panelList.add(panelNode);
				
				panelList.add(horizontalStrut);
				//panelList.add
				panelNode.setLayout(new BoxLayout(panelNode, BoxLayout.Y_AXIS));
				
				JLabel lblAddress = new JLabel("ADD:"+nodes.get(i).getAddress().hashCode());
				lblAddress.setAlignmentX(Component.CENTER_ALIGNMENT);
				lblAddress.setHorizontalTextPosition(SwingConstants.CENTER);
				lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
			
				lblAddress.setMinimumSize(new Dimension(220, 20));
				lblAddress.setMaximumSize(new Dimension(220, 20));
				lblAddress.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.BLUE));
				panelNode.add(lblAddress);
				
				JPanel panelElementLabel = new JPanel();
				panelElementLabel.setMaximumSize(new Dimension(220, 20));
				panelElementLabel.setMaximumSize(new Dimension(220, 20));
				panelElementLabel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.BLUE));
				panelNode.add(panelElementLabel);
				panelElementLabel.setLayout(new BoxLayout(panelElementLabel, BoxLayout.X_AXIS));
				
				if(LinkListType.compareTo("DL")==0){
				lblError.setVisible(false);
				JLabel lblLink3 = new JLabel("LINK");
				lblLink3.setPreferredSize(new Dimension(40, 14));
				lblLink3.setMaximumSize(new Dimension(40, 14));
				lblLink3.setMaximumSize(new Dimension(40, 14));
				panelElementLabel.add(lblLink3);
				Component horizontalStrut_3 = Box.createHorizontalStrut(5);
				panelElementLabel.add(horizontalStrut_3);
				}
				
				JLabel lblData = new JLabel("DATA");
				lblData.setMaximumSize(new Dimension(40, 14));
				lblData.setMaximumSize(new Dimension(40, 14));
				lblData.setPreferredSize(new Dimension(40, 14));
				lblData.setBorder(new MatteBorder(0, 3, 0, 3, (Color) new Color(0, 0, 0)));
				panelElementLabel.add(lblData);
				
				Component horizontalStrut_1 = Box.createHorizontalStrut(30);
				panelElementLabel.add(horizontalStrut_1);
				
				JLabel lblLink = new JLabel("LINK");
				lblLink.setPreferredSize(new Dimension(40, 14));
				lblLink.setMaximumSize(new Dimension(40, 14));
				lblLink.setMaximumSize(new Dimension(40, 14));
				panelElementLabel.add(lblLink);
				
				JPanel panelElement = new JPanel();
				panelElement.setMaximumSize(new Dimension(220, 20));
				panelElement.setMaximumSize(new Dimension(220, 20));
				panelElement.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.BLUE));
				panelNode.add(panelElement);
				panelElement.setLayout(new BoxLayout(panelElement, BoxLayout.X_AXIS));
				
				if(LinkListType.compareTo("DL")==0){
					lblLink2 = new JLabel(""+nodes.get(i-1).hashCode());
					if(i != nodes.size()-1){
					//if(nodes.get(i).getNext()!=null){
					lblLink2.setText(""+nodes.get(i-1).hashCode());
					lblLink2.setPreferredSize(new Dimension(40, 14));
					lblLink2.setMaximumSize(new Dimension(40, 14));
					lblLink2.setMaximumSize(new Dimension(40, 14));
					}
					
				
					panelElement.add(lblLink2);	
					
				Component horizontalStrut_3 = Box.createHorizontalStrut(60);
				panelElement.add(horizontalStrut_3);
				JLabel lblData1 = new JLabel(nodes.get(i).getData()+"");
				lblData1.setPreferredSize(new Dimension(40, 14));
				lblData1.setMaximumSize(new Dimension(40, 14));
				lblData1.setMaximumSize(new Dimension(40, 14));
				lblData.setBorder(new MatteBorder(0, 3, 0, 3, (Color) new Color(0, 0, 0)));
				panelElement.add(lblData1);
				
				Component horizontalStrut_2 = Box.createHorizontalStrut(20);
				panelElement.add(horizontalStrut_2);
				
				lblError.setVisible(false);
				lblLink1 = new JLabel("NULL");
				if(i != nodes.size()-1){
				//if(nodes.get(i).getNext()!=null){
				lblLink1.setText(""+nodes.get(i).getNext().hashCode());
				lblLink1.setPreferredSize(new Dimension(40, 14));
				lblLink1.setMaximumSize(new Dimension(40, 14));
				lblLink1.setMaximumSize(new Dimension(40, 14));
				}
				
			
				panelElement.add(lblLink1);
				
				
				}
				else {
					JLabel lblData1 = new JLabel(nodes.get(i).getData()+"");
					lblData1.setPreferredSize(new Dimension(40, 14));
					lblData1.setMaximumSize(new Dimension(40, 14));
					lblData1.setMaximumSize(new Dimension(40, 14));
					lblData.setBorder(new MatteBorder(0, 0, 0, 3, (Color) new Color(0, 0, 0)));
					panelElement.add(lblData1);
					
					Component horizontalStrut_2 = Box.createHorizontalStrut(20);
					panelElement.add(horizontalStrut_2);
				}
		 
				
				if(LinkListType.compareTo("SL")==0){
				lblError.setVisible(false);
				JLabel lblLink1 = new JLabel("NULL");
				if(i != nodes.size()-1){
				//if(nodes.get(i).getNext()!=null){
				lblLink1.setText(""+nodes.get(i).getNext().hashCode());
				lblLink1.setPreferredSize(new Dimension(40, 14));
				lblLink1.setMaximumSize(new Dimension(40, 14));
				lblLink1.setMaximumSize(new Dimension(40, 14));
				}
				
			
				panelElement.add(lblLink1);
			}
				else if(LinkListType.compareTo("CL")==0){
					lblError.setVisible(false);
					JLabel lblLink1 = new JLabel(nodes.get(1).getAddress().hashCode()+"");
					if(i != nodes.size()-1){
					//if(nodes.get(i).getNext()!=null){
					lblLink1.setText(""+nodes.get(i).getNext().hashCode());
					lblLink1.setPreferredSize(new Dimension(40, 14));
					lblLink1.setMaximumSize(new Dimension(40, 14));
					lblLink1.setMaximumSize(new Dimension(40, 14));
					
					}
					
				
					panelElement.add(lblLink1);
					
				}
     }
}


void InsertAtFront(){	
	if(textFieldInsertElement.getText().trim().isEmpty()){
		lblEntrele.setText("Enter the Element!");
		lblEntrele.setVisible(true);
	}
	else{
	lblError.setVisible(false);
	panelInsert.setVisible(false);
	btnNewButton.setEnabled(true);
	int data = Integer.parseInt(textFieldInsertElement.getText());
	Node n = new Node(data);
	nodes.add(1,n);
	//nodes.get(data).setNext(n);  //ForCircular
	n.setNext(nodes.get(2).getAddress());
	n.setNext(n.getAddress().getNext());
	
	panelList.removeAll();
	home.visualize(nodes);
	lblSearch.revalidate();
	lblSearch.setText(nodes.size()-1+"");
	panelList.getRootPane().revalidate();
					}
				}

void InsertAtRear(){
	if(textFieldInsertElement.getText().trim().isEmpty()){
		lblEntrele.setText("Enter the Element!");
		lblEntrele.setVisible(true);
	}
	else{
	lblError.setVisible(false);
	panelInsert.setVisible(false);
	btnNewButton.setEnabled(true);
	int ele = Integer.parseInt(textFieldInsertElement.getText());
	Node n = new Node(ele);
	nodes.get(nodes.size()-1).setNext(n);
	nodes.add(n);
	panelList.removeAll();
	home.visualize(nodes);
	lblSearch.revalidate();
	lblSearch.setText(nodes.size()-1+"");
	panelList.getRootPane().revalidate();
	
				}
	
		}
void InsertAtSP(){
	
	if(textFieldInsertElement.getText().trim().isEmpty() || Index.getText().trim().isEmpty()){
		lblEntrele.setText("Enter the Element!");
		lblEntrele.setVisible(true);
	}
	else if(nodes.get(0).getNext()!= null){
		
			panelInsert.setVisible(false);
			btnNewButton.setEnabled(true);
			int ele = Integer.parseInt(textFieldInsertElement.getText());
			Node n = new Node(ele);
			int index1 = Integer.parseInt(Index.getText().toString());		
			nodes.add(index1,n);
			nodes.get(index1-1).setNext(n.getAddress());
			index1++;
			n.setNext(nodes.get(index1).getAddress());
			
			panelList.removeAll();
			home.visualize(nodes);
			//n++;
			lblSearch.revalidate();
			lblSearch.setText(nodes.size()-1+"");
			panelList.getRootPane().revalidate();	
		}
	else {
		lblEntrele.setText("error");
		lblEntrele.setVisible(true);
				}
			}
void DelAtFront(){
	
		Node n = nodes.get(0).getAddress();
		nodes.get(0).setNext(n.getAddress());
		nodes.get(0).setNext(n);
		nodes.remove(0);
		panelList.removeAll();
		home.visualize(nodes);
		lblSearch.revalidate();
		lblSearch.setText(nodes.size()-1+"");
		//n++;		
		panelList.getRootPane().revalidate();
		Deletepanel.setVisible(false);
		btnNewButton.setEnabled(true);
		btnDelete.setEnabled(true);
		
	}
	

void DelAtR(){
		Node n = nodes.get(nodes.size()-1).getAddress();
	    nodes.get(nodes.size()-1).setNext(n.getAddress());
	    nodes.get(nodes.size()-1).setNext(n);
	    panelList.getRootPane().revalidate();
	    nodes.remove(nodes.size()-1);
	    
	    panelList.removeAll();
		home.visualize(nodes);
		panelList.getRootPane().revalidate();
		lblSearch.revalidate();
		lblSearch.setText(nodes.size()-1+"");
		
		
		Deletepanel.setVisible(false);
		btnNewButton.setEnabled(true);
		btnDelete.setEnabled(true);
		
	
}

//DeleteATSPFIX

void DelAtSP(){
	
		int data = Integer.parseInt(Index1.getText());
		Node n = nodes.get(data+1).getAddress();
	    nodes.get(data-1).setNext(n.getAddress());
	    nodes.get(data-1).setNext(n);
		nodes.remove(data);
		//nodes.removeAll(nodes);
		panelList.removeAll();
		home.visualize(nodes);
		lblSearch.revalidate();
		lblSearch.setText(""+nodes.size());
		
		panelList.getRootPane().revalidate();
		btnDelete.setEnabled(true);
			
	}
}
