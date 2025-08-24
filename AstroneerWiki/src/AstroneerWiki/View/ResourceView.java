package AstroneerWiki.View;

import javax.swing.JLabel;
import javax.swing.JPanel;

import AstroneerWiki.Controller.MenuController;

public class ResourceView extends JPanel{

	public ResourceView(StartMenuView mainView, MenuController controller) {
		add(new JLabel("Resource View"));
	}

}
