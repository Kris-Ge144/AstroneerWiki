package AstroneerWiki.View;

import javax.swing.JLabel;
import javax.swing.JPanel;

import AstroneerWiki.Controller.MenuController;

public class HazardFaunaView extends JPanel{

	public HazardFaunaView(StartMenuView mainView, MenuController controller) {
		add(new JLabel("Hazards & Fauna View"));
	}

}
