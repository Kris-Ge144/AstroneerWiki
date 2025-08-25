package AstroneerWiki.Util;

import java.awt.Font;
import java.io.InputStream;

public class FontLoader {
	
	private static Font baseFont;
	
	static {
		try {
			InputStream is = FontLoader.class.getResourceAsStream("/fonts/ndastroneer.ttf");
			baseFont = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (Exception e) {
			System.err.println("Fehler beim Laden der Schriftart; " + e.getMessage());
			baseFont = new Font("Arial", Font.PLAIN, 12);
		}
	}
	
	/**
	 * Liefert den Custom-Font in beliebiger Größe
	 */
	public static Font getCustomFont(float size) {
		return baseFont.deriveFont(size);
	}
}
