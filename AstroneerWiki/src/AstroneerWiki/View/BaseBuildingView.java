package AstroneerWiki.View;

import javax.swing.JLabel;
import javax.swing.JPanel;

import AstroneerWiki.Controller.MenuController;

public class BaseBuildingView extends JPanel{

	public BaseBuildingView(StartMenuView mainView, MenuController controller) {
		add(new JLabel("Bases & Buildings View"));
	}

}
