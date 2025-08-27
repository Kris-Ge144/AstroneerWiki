package AstroneerWiki.Model;

import AstroneerWiki.Util.ButtonLoader;

public class HighlightButtonModel {
	private final ButtonLoader[] buttons;
	
	public HighlightButtonModel(ButtonLoader... buttons) {
		this.buttons = buttons;
	}
	
	public void highlight(ButtonLoader active) {
		for (ButtonLoader b: buttons) {
			b.setActive(b == active);
		}
	}
}