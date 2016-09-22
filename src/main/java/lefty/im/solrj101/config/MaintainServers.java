package lefty.im.solrj101.config;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lefty.im.solrj101.MainWindow;
import lefty.im.solrj101.config.controls.NodeServer;

import java.awt.GridBagLayout;
import javax.swing.JSplitPane;
import java.awt.GridBagConstraints;
import javax.swing.JToolBar;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JTabbedPane;

public class MaintainServers extends JDialog {

	private final static Logger logger = LoggerFactory.getLogger( MaintainServers.class);
	
	static private JPanel contentPanel = null;
	JSplitPane splitPane=null;

	JTree treeServer=null; // tree with the SOLR server name
	JTabbedPane tabbedServerPropertyPane=null; // tabbed pane to edit/display server properties
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		try {
			MaintainServers dialog = new MaintainServers();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	class NodeServerRenderer implements TreeCellRenderer{
		private JLabel label;
		URL imageUrl=null;
		Icon imageIcon=null;
		
		NodeServerRenderer(){
			label=new JLabel();
		}
		public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf,
				int row, boolean hasfocus) {
			
			Object o = ((DefaultMutableTreeNode) value).getUserObject();
			if (o instanceof NodeServer){
				NodeServer nodeS = (NodeServer) o;
				
				//imageUrl = getClass().getResource(nodeS.getNodeIcon());
//				 imageUrl = getClass().getResource("solrserver.jpg");
				Icon imageIcon = UIManager.getIcon("OptionPane.informationIcon");
				
				if (imageUrl!=null){
					label.setIcon(new ImageIcon(imageUrl));
				}
				
				if (imageIcon!=null){
					label.setIcon(imageIcon);
				}
					

				label.setText("X"+nodeS.getServerHumanName());
				
			}
			else{
				label.setIcon(null);
				label.setText(""+value);
				
			}
			
			return label;
		}
		
	}
	/**
	 * Create the dialog.
	 */
	public MaintainServers() {
		logger.debug("Constructing MaintainServers");
		contentPanel = new JPanel();
		
		setBounds(100, 100, 570, 391);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JToolBar toolBar = new JToolBar();
			GridBagConstraints gbc_toolBar = new GridBagConstraints();
			gbc_toolBar.insets = new Insets(0, 0, 5, 5);
			gbc_toolBar.gridx = 0;
			gbc_toolBar.gridy = 0;
			contentPanel.add(toolBar, gbc_toolBar);
		}
		{
			JToolBar toolBar = new JToolBar();
			GridBagConstraints gbc_toolBar = new GridBagConstraints();
			gbc_toolBar.insets = new Insets(0, 0, 5, 0);
			gbc_toolBar.gridx = 1;
			gbc_toolBar.gridy = 0;
			contentPanel.add(toolBar, gbc_toolBar);
		}
		{
			splitPane = new JSplitPane();
			GridBagConstraints gbc_splitPane = new GridBagConstraints();
			gbc_splitPane.gridwidth = 2;
			gbc_splitPane.insets = new Insets(0, 0, 0, 5);
			gbc_splitPane.fill = GridBagConstraints.BOTH;
			gbc_splitPane.gridx = 0;
			gbc_splitPane.gridy = 1;
			contentPanel.add(splitPane, gbc_splitPane);
			{
				treeServer = new JTree();
				splitPane.setLeftComponent(treeServer);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						logger.debug("OK pressed in MaintainServers--->dispose()");
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		initVariables();
		
		
	}


	private void initVariables() {
		ManagedServers.ReadServerDataFromConfig();
		ArrayList<SOLRServer> listServers =ManagedServers.getManagedServers();
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("root");
		
		for(SOLRServer s:listServers){
			NodeServer nodeSrv=new NodeServer("solrserver.png",s.getHumanName());
			String humanName=s.getHumanName();
			root.add(new DefaultMutableTreeNode(humanName));
			//root.add(new DefaultMutableTreeNode(nodeSrv));
		}
		
		treeServer = new JTree(root);
		//treeServer.setCellRenderer( new NodeServerRenderer());
		
		splitPane.setLeftComponent(treeServer);
		{
			tabbedServerPropertyPane = new JTabbedPane(JTabbedPane.TOP);
			splitPane.setRightComponent(tabbedServerPropertyPane);
		}
		
		tabbedServerPropertyPane.add(new JButton("Server"), "Server");
		tabbedServerPropertyPane.add(new JButton("Core"), "Core");
		
		
	}

}
