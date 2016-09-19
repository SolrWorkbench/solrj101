package lefty.im.solrj101.config;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.GridBagLayout;
import javax.swing.JSplitPane;
import java.awt.GridBagConstraints;
import javax.swing.JToolBar;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JTree;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import javax.swing.JTabbedPane;

public class MaintainServers extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JSplitPane splitPane;

	JTree treeServer; // tree witht he SOLR server name
	JTabbedPane tabbedServerPropertyPane; // tabbed pane to edit/display server properties
	
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


	/**
	 * Create the dialog.
	 */
	public MaintainServers() {
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
			String humanName=s.getHumanName();
			root.add(new DefaultMutableTreeNode(humanName));
		}
		
		treeServer = new JTree(root);
		splitPane.setLeftComponent(treeServer);
		{
			tabbedServerPropertyPane = new JTabbedPane(JTabbedPane.TOP);
			splitPane.setRightComponent(tabbedServerPropertyPane);
		}
		
		tabbedServerPropertyPane.add(new JButton("Server"), "Server");
		tabbedServerPropertyPane.add(new JButton("Core"), "Core");
		
		
	}
/*
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	*/
}
