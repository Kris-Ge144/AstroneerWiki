package AstroneerWiki.View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.text.Highlighter.Highlight;

import AstroneerWiki.Controller.MenuController;
import AstroneerWiki.Model.HighlightButtonModel;
import AstroneerWiki.Util.ButtonFactory;
import AstroneerWiki.Util.ButtonLoader;
import AstroneerWiki.Util.FontLoader;

public class StartMenuView extends JFrame {

    private static StartMenuView instance;
    private JPanel contentPanel;
    private CardLayout cardLayout;
    private MenuController controller;
    private HighlightButtonModel buttonHighlighter;
    private Map<String, ButtonLoader> viewButtonMap;

    // Buttons
    private ButtonLoader planetMenuBtn;
    private ButtonLoader resourceMenuBtn;
    private ButtonLoader vehicleMenuBtn;
    private ButtonLoader baseBuildingMenuBtn;
    private ButtonLoader toolEquipmentMenuBtn;
    private ButtonLoader researchMenuBtn;
    private ButtonLoader hazardFaunaMenuBtn;
    private ButtonLoader cosmeticMenuBtn;
    private ButtonLoader exitAppBtn;
    
    
    // Singleton
    private StartMenuView() {
        setTitle("Astroneer Wiki");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       

        // Custom Font für global
        UIManager.put("Button.font", FontLoader.getCustomFont(20f));
        UIManager.put("Label.font", FontLoader.getCustomFont(16f));
        
        // Controller initialisieren
        controller = new MenuController(this, buttonHighlighter, viewButtonMap);

        // CardLayout für alle Views
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout); // ⚠️ kein Hintergrund mehr hier!
        add(contentPanel, BorderLayout.CENTER);

        // Startmenü-Panel erstellen (hat eigenen Hintergrund!)
        JPanel startMenuPanel = createStartMenuPanel();

        // Panels registrieren
        contentPanel.add(startMenuPanel, "StartView");
        contentPanel.add(new PlanetView(this, controller), "PlanetView");
        contentPanel.add(new VehicleView(this, controller), "VehicleView");
        contentPanel.add(new ResourceView(this, controller), "ResourceView");
        contentPanel.add(new BaseBuildingView(this, controller), "BaseBuildingView");
        contentPanel.add(new ToolEquipmentView(this, controller), "ToolEquipmentView");
        contentPanel.add(new ResearchView(this, controller), "ResearchView");
        contentPanel.add(new HazardFaunaView(this, controller), "HazardFaunaView");
        contentPanel.add(new CosmeticView(this, controller), "CosmeticView");
        
        // Highlight-Modell erstellen
        buttonHighlighter = new HighlightButtonModel(
        		planetMenuBtn, resourceMenuBtn, vehicleMenuBtn,
        		baseBuildingMenuBtn, toolEquipmentMenuBtn, researchMenuBtn,
        		hazardFaunaMenuBtn, cosmeticMenuBtn, exitAppBtn
        );
     
        // Map für View-zu-Button
        viewButtonMap = new HashMap<>();
        viewButtonMap.put("PlanetView", planetMenuBtn);
        viewButtonMap.put("ResourceView", resourceMenuBtn);
        viewButtonMap.put("VehicleView", vehicleMenuBtn);
        viewButtonMap.put("BaseBuildingView", baseBuildingMenuBtn);
        viewButtonMap.put("ToolEquipmentView", toolEquipmentMenuBtn);
        viewButtonMap.put("ResearchView", researchMenuBtn);
        viewButtonMap.put("HazardFaunaView", hazardFaunaMenuBtn);
        viewButtonMap.put("CosmeticView", cosmeticMenuBtn);

        // Standardmäßig Startmenü anzeigen
        showCard("StartView");
    }

    // Startmenü mit eigenem Hintergrund
    private JPanel createStartMenuPanel() {
        JPanel panel = new JPanel(new BorderLayout()) {
            private Image bg = new ImageIcon(
                getClass().getResource("/img/background/StartMenuBg.jpg")
            ).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (bg != null) {
                    g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
              
        panel.setOpaque(false);

        // Titel
        JLabel appTitleLbl = new JLabel("Wiki", JLabel.CENTER);
        appTitleLbl.setFont(FontLoader.getCustomFont(48f));
        panel.add(appTitleLbl, BorderLayout.NORTH);

        // Button-Leiste
        JPanel buttonPnl = new JPanel(new GridLayout(1, 4, 10, 10));
        buttonPnl.setOpaque(false);
        buttonPnl.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        planetMenuBtn = ButtonFactory.standartPlanetButton();
        resourceMenuBtn = ButtonFactory.standartResourceButton();
        vehicleMenuBtn = ButtonFactory.standartVehicleButton();
        baseBuildingMenuBtn = ButtonFactory.standartBaseBuildingButton();
        toolEquipmentMenuBtn = ButtonFactory.standartToolEquipmentButton();
        researchMenuBtn = ButtonFactory.standartResearchButton();
        hazardFaunaMenuBtn = ButtonFactory.standartHazardFaunaButton();
        cosmeticMenuBtn = ButtonFactory.standartCosmeticButton();
        exitAppBtn = ButtonFactory.standartExitButton();
        
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
                      
        // panel.add(exitButtonPnl, BorderLayout.SOUTH);
        panel.add(buttonPnl, BorderLayout.SOUTH);

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


