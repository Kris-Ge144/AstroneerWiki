package AstroneerWiki.Util;

import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;

import javax.swing.*;

public class ButtonLoader extends JButton {
    private ImageIcon colorIcon;
    private ImageIcon grayIcon;
    private boolean active = false;

    public ButtonLoader(String text, String imagePath) {
        super(text);

        // Bild laden
        java.net.URL url = getClass().getResource(imagePath);
        if (url != null) {
        	ImageIcon original = new ImageIcon(url);
        	int width = 240; // Button-Breite
        	int height = 135; // Button-Höhe
        	Image scaledColor = original.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            colorIcon = new ImageIcon(scaledColor);
            grayIcon = new ImageIcon(toGray(scaledColor));
            setPreferredSize(new Dimension(width, height));
        } else {
            System.err.println("❌ Bild nicht gefunden: " + imagePath);
        }

        // Button-Design: flach, rechteckig
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setHorizontalTextPosition(CENTER);
        setVerticalTextPosition(CENTER);
        setFont(FontLoader.getCustomFont(20f));

        // Start mit grauem Bild
        setIcon(grayIcon);

        // Hover-Listener
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!active && colorIcon != null) {
                    setIcon(colorIcon);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!active && grayIcon != null) {
                    setIcon(grayIcon);
                }
            }
        });
    }

    // Aktiv setzen
    public void setActive(boolean active) {
        this.active = active;
        if (active && colorIcon != null) {
            setIcon(colorIcon);
        } else if (!active && grayIcon != null) {
            setIcon(grayIcon);
        }
    }

    // Utility: Bild in Graustufen
    private Image toGray(Image srcImg) {
        BufferedImage gray = new BufferedImage(
                srcImg.getWidth(null),
                srcImg.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2 = gray.createGraphics();
        g2.drawImage(srcImg, 0, 0, null);
        g2.setComposite(AlphaComposite.SrcAtop);

        // Farbfilter -> Graustufen
        ColorConvertOp op = new ColorConvertOp(
                ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
        op.filter(gray, gray);
        g2.dispose();

        return gray;
    }
}
