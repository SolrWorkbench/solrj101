package lefty.im.solrj101;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lefty.im.solrj101.config.MaintainServers;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class MainWindow {

	private final static Logger logger = LoggerFactory.getLogger( MainWindow.class);
	private JFrame frame;
	//private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logger.debug("Create MainWindow");
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		logger.debug("Construct MainWindow");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar mainMenuBar = new JMenuBar();
		frame.setJMenuBar(mainMenuBar);
		
		JMenu mnFile = new JMenu("File");
		mainMenuBar.add(mnFile);
		
		logger.debug("Initialize MainWindow");
		JMenuItem mntmConfigureServers = new JMenuItem("Configure Servers");
		mntmConfigureServers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					logger.debug("ActionListener activated: invoke MaintainServers()");
					MaintainServers dialog = new MaintainServers();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		mnFile.add(mntmConfigureServers);
		
		JMenu mnHelp = new JMenu("Help");
		mainMenuBar.add(mnHelp);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Help");
		mnHelp.add(mntmNewMenuItem);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AboutDialog dialog = new AboutDialog();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		mnHelp.add(mntmAbout);
	}
}
