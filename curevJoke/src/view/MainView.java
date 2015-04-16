package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;

public class MainView extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JCheckBox nytButton;
	private JCheckBox worldButton;
	private JCheckBox nationalButton;
	private JCheckBox frontPage;
	private JButton continueButton;
	private JButton quitButton;

	public MainView(){
		Font titleFont = new Font("Helvetica", Font.BOLD, 20);
		setLayout(new MigLayout("","[][][]","[]20[][][][]1[]1[]10[]"));
		setTitle("CurEvJoke, the current events joke generator!");
		
		JLabel titleField = new JLabel("To begin please select a news source and the type of news you want");		
		titleField.setFont(titleFont);
		
		add(titleField, "wrap");
		
		JLabel sourceField = new JLabel("Select News Source");
		add(sourceField, "wrap");
		
		nytButton = new JCheckBox("New York Times");
		add(nytButton, "wrap");
		
		JLabel newsTypeField = new JLabel("Select News Type");
		add(newsTypeField, "wrap");
		
		worldButton = new JCheckBox("World News");
		add(worldButton, "wrap");
		nationalButton = new JCheckBox("National News");
		add(nationalButton, "wrap");
		frontPage = new JCheckBox("Front Page");
		add(frontPage, "wrap");
		
		quitButton = new JButton("Quit");
		add(quitButton, "cell 0 7");
		continueButton = new JButton("Continue");
		add(continueButton, "cell 1 7");
		
		
		
		pack();
	}
	
	
	
}
