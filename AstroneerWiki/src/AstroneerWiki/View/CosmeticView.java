package AstroneerWiki.View;

import javax.swing.JLabel;
import javax.swing.JPanel;

import AstroneerWiki.Controller.MenuController;

public class CosmeticView extends JPanel{

	public CosmeticView(StartMenuView mainView, MenuController controller) {
		add(new JLabel("Cosmetics View"));
	}

}
