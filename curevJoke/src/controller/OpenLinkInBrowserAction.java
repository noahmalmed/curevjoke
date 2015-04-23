package controller;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

/**
 * Action Listener that has a URL associated with and opens the URL when envoked
 * @author noahmalmed
 *
 */
public class OpenLinkInBrowserAction implements ActionListener {
	
	private URL url;
	
	public OpenLinkInBrowserAction(URL url){
		this.url = url;
	}

	@Override
	public void actionPerformed(ActionEvent aE) {
		// Based in code found at: http://stackoverflow.com/a/10967469
		Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
	    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
	        try {
	            desktop.browse(url.toURI());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
		
	}

}
