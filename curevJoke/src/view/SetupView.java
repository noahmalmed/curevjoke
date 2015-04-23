package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import net.miginfocom.swing.MigLayout;

public class SetupView extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JCheckBox nytButton;
	private JCheckBox worldButton;
	private JCheckBox nationalButton;
	private JCheckBox frontPageButton;
	private JButton continueButton;
	private JButton quitButton;

	public SetupView(){
		setLayout(new MigLayout("","[][][]","[]20[][][][]1[]1[]10[]"));
		setTitle("CurEvJoke, the current events joke generator!");
		
		JLabel titleField = new JLabel("To begin please select a news source and the type of news you want");		
		titleField.setFont(StaticFonts.TITLE_FONT);		
		add(titleField, "wrap");
		
		JLabel sourceField = new JLabel("Select News Source");
		add(sourceField, "wrap");
		
		nytButton = new JCheckBox("New York Times");
		nytButton.setSelected(true);
		add(nytButton, "wrap");
		
		JLabel newsTypeField = new JLabel("Select News Type");
		add(newsTypeField, "wrap");
		
		worldButton = new JCheckBox("World News");
		worldButton.setSelected(true);
		add(worldButton, "wrap");
		
		nationalButton = new JCheckBox("National News");
		add(nationalButton, "wrap");
		
		frontPageButton = new JCheckBox("Front Page");
		add(frontPageButton, "wrap");

		quitButton = new JButton("Quit");
		add(quitButton, "cell 0 7");
		
		
		continueButton = new JButton("Continue");
		add(continueButton, "cell 1 7");
		
				
		pack();
	}
	
	/**
	 * Add controllers to the pressable buttons
	 * @param controller
	 */
	public void addController(ActionListener controller){
		quitButton.addActionListener(controller);
		continueButton.addActionListener(controller);
	}
	
	/**
	 * Display a notification to the user to press the correct buttons
	 */
	public void displayInvalidButtonsPressed(){
		JOptionPane.showMessageDialog(this,
			    "Please select at least one news source and at least one news type",
			    "Invalid Parameters",
			    JOptionPane.ERROR_MESSAGE);
	}
	
	
	public boolean nytPressed(){
		return nytButton.isSelected();
	}
	
	public boolean worldNewsPressed(){
		return worldButton.isSelected();
	}
	
	public boolean nationalNewsPressed(){
		return nationalButton.isSelected();
	}
	
	public boolean frontPageNewsPressed(){
		return frontPageButton.isSelected();
	}
	
	
	
}
