package AstroneerWiki.View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import AstroneerWiki.Controller.MenuController;

public class StartMenuView extends JFrame {

    private static StartMenuView instance;
    private JPanel contentPanel;
    private CardLayout cardLayout;
    private MenuController controller;
    private Image backgroundImage;

    // Singleton
    private StartMenuView() {
        setTitle("Astroneer Wiki");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Hintergrundbild laden mit Debug
        java.net.URL url = getClass().getResource("/img/background/StartMenuBg.jpg");
        System.out.println("URL = " + url); // Debug
        if (url != null) {
            backgroundImage = new ImageIcon(url).getImage();
        } else {
            System.err.println("❌ Hintergrundbild konnte nicht geladen werden!");
        }

        // CardLayout für alle Views
        cardLayout = new CardLayout();

        // Panel mit Hintergrund
        contentPanel = new JPanel(cardLayout) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };

        add(contentPanel, BorderLayout.CENTER);

        // Controller initialisieren
        controller = new MenuController(this);

        // Startmenü-Panel erstellen
        JPanel startMenuPanel = createStartMenuPanel();

        // Panels registrieren
        contentPanel.add(startMenuPanel, "StartMenu");
        contentPanel.add(new PlanetView(this, controller), "PlanetView");
        contentPanel.add(new VehicleView(this, controller), "VehicleView");
        contentPanel.add(new ResourceView(this, controller), "ResourceView");
        contentPanel.add(new BaseBuildingView(this, controller), "BaseBuildingView");
        contentPanel.add(new ToolEquipmentView(this, controller), "ToolEquipmentView");
        contentPanel.add(new ResearchView(this, controller), "ResearchView");
        contentPanel.add(new HazardFaunaView(this, controller), "HazardFaunaView");
        contentPanel.add(new CosmeticView(this, controller), "CosmeticView");

        // Standardmäßig Startmenü anzeigen
        showCard("StartMenu");
    }

    // Erzeugt das Startmenü-Panel mit allen Buttons
    private JPanel createStartMenuPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);

        // Titel
        JLabel appTitleLbl = new JLabel("Wiki", JLabel.CENTER);
        appTitleLbl.setFont(new Font("bdastroneer.ttf", Font.BOLD, 32));
        panel.add(appTitleLbl, BorderLayout.NORTH);

        // Button-Leiste
        JPanel buttonPnl = new JPanel();
        buttonPnl.setOpaque(false);

        JButton planetMenuBtn = new JButton("Planets");
        JButton resourceMenuBtn = new JButton("Resources");
        JButton vehicleMenuBtn = new JButton("Vehicles");
        JButton baseBuildingMenuBtn = new JButton("Bases & Buildings");
        JButton toolEquipmentMenuBtn = new JButton("Tools & Equipment");
        JButton researchMenuBtn = new JButton("Research & Bytes");
        JButton hazardFaunaMenuBtn = new JButton("Hazards & Fauna");
        JButton cosmeticMenuBtn = new JButton("Cosmetics");
        JButton exitAppBtn = new JButton("Exit");

        // Buttons hinzufügen
        buttonPnl.add(planetMenuBtn);
        buttonPnl.add(resourceMenuBtn);
        buttonPnl.add(vehicleMenuBtn);
        buttonPnl.add(baseBuildingMenuBtn);
        buttonPnl.add(toolEquipmentMenuBtn);
        buttonPnl.add(researchMenuBtn);
        buttonPnl.add(hazardFaunaMenuBtn);
        buttonPnl.add(cosmeticMenuBtn);
        buttonPnl.add(exitAppBtn);

        // Aktionen
        planetMenuBtn.addActionListener(e -> controller.showView("PlanetView"));
        resourceMenuBtn.addActionListener(e -> controller.showView("ResourceView"));
        vehicleMenuBtn.addActionListener(e -> controller.showView("VehicleView"));
        baseBuildingMenuBtn.addActionListener(e -> controller.showView("BaseBuildingView"));
        toolEquipmentMenuBtn.addActionListener(e -> controller.showView("ToolEquipmentView"));
        researchMenuBtn.addActionListener(e -> controller.showView("ResearchView"));
        hazardFaunaMenuBtn.addActionListener(e -> controller.showView("HazardFaunaView"));
        cosmeticMenuBtn.addActionListener(e -> controller.showView("CosmeticView"));
        exitAppBtn.addActionListener(e -> System.exit(0));

        panel.add(buttonPnl, BorderLayout.CENTER);

        return panel;
    }

    // Methode, um Panels zu wechseln
    public void showCard(String name) {
        cardLayout.show(contentPanel, name);
    }

    // Singleton Getter
    public static StartMenuView getInstance() {
        if (instance == null) {
            instance = new StartMenuView();
        }
        return instance;
    }

    // Main zum Testen
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            StartMenuView.getInstance().setVisible(true);
        });
    }
}

