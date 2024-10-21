package org.centrale.objet.woe.gui;

import javax.swing.*;
import org.centrale.objet.woe.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class GameGUI extends JPanel implements ActionListener, KeyListener {
    private static final int TILE_SIZE = 25;
    private static final int WORLD_SIZE = 50; // 50x50 world grid
    private static final int VIEW_SIZE = WORLD_SIZE / 2; // 1/4 of the world grid visible (25x25 tiles)
    
    private World world;
    private Personnage player;
    private Joueur play;
    private Image playerImage;
    private Image backgroundImage;
    private Timer timer;
    private JLabel playerInfoLabel;
    
    // Images for different types of elements
    private Map<Class<? extends ElementDeJeu>, Image> elementImages;
    private Map<Class<? extends ElementDeJeu>, String> elementImagePaths;

    public GameGUI(World world, Joueur player, JLabel playerInfoLabel) {
        this.world = world;
        this.play = player;
        this.player = this.play.getPersonnage();
        this.playerInfoLabel = playerInfoLabel;

        // Load the player image
        this.setPlayerImage();
        
        // Load the background image
        this.backgroundImage = new ImageIcon(getClass().getResource("/images/background.png")).getImage();

        // Initialize the element images
        this.loadElementImages();
        this.loadElementImagePaths();

        this.setPreferredSize(new Dimension(VIEW_SIZE * TILE_SIZE, VIEW_SIZE * TILE_SIZE));
        this.setBackground(Color.WHITE);
        this.setFocusable(true);
        this.addKeyListener(this);
        timer = new Timer(100, this);
        timer.start();
        updatePlayerInfo(); // Initial display of player info
    }

    // Load different images for different classes
    private void loadElementImages() {
        elementImages = new HashMap<>();
        elementImages.put(Guerrier.class, new ImageIcon(getClass().getResource("/images/warrior.png")).getImage());
        elementImages.put(Archer.class, new ImageIcon(getClass().getResource("/images/archer.png")).getImage());
        elementImages.put(Paysan.class, new ImageIcon(getClass().getResource("/images/peasant.png")).getImage());
        elementImages.put(Loup.class, new ImageIcon(getClass().getResource("/images/wolf.png")).getImage());
        elementImages.put(Lapin.class, new ImageIcon(getClass().getResource("/images/rabbit.png")).getImage());
        elementImages.put(PotionSoin.class, new ImageIcon(getClass().getResource("/images/potion.png")).getImage());
        elementImages.put(Nourriture.class, new ImageIcon(getClass().getResource("/images/food.png")).getImage());
        elementImages.put(Epee.class, new ImageIcon(getClass().getResource("/images/sword.png")).getImage());
        elementImages.put(NuageToxique.class, new ImageIcon(getClass().getResource("/images/cloud.png")).getImage());
        
    }

    private void loadElementImagePaths() {
        elementImagePaths = new HashMap<>();
        elementImagePaths.put(Guerrier.class, "/images/warrior.png");
        elementImagePaths.put(Archer.class, "/images/archer.png");
        elementImagePaths.put(Paysan.class, "/images/peasant.png");
        elementImagePaths.put(Loup.class, "/images/wolf.png");
        elementImagePaths.put(Lapin.class, "/images/rabbit.png");
        elementImagePaths.put(PotionSoin.class, "/images/potion.png");
        elementImagePaths.put(Nourriture.class, "/images/food.png");
        elementImagePaths.put(NuageToxique.class, "/images/cloud.png");
        elementImagePaths.put(Epee.class, "/images/sword.png");
}

    public void setPlayerImage() {
        if (this.player instanceof Guerrier) {
            this.playerImage = new ImageIcon(getClass().getResource("/images/warriorplayer.png")).getImage();
        } else {
            this.playerImage = new ImageIcon(getClass().getResource("/images/archerplayer.png")).getImage(); 
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background image to cover the entire game area
        g.drawImage(this.backgroundImage, 0, 0, getWidth(), getHeight(), this);

        // Calculate the visible area of the map based on the player's position
        Point2D playerPos = player.pos;

        // Calculate camera position (top-left corner of the visible area)
        int cameraX = (int) playerPos.getX() - VIEW_SIZE / 2;
        int cameraY = (int) playerPos.getY() - VIEW_SIZE / 2;

        // Clamp the camera to the map edges
        cameraX = Math.max(0, Math.min(cameraX, WORLD_SIZE - VIEW_SIZE));
        cameraY = Math.max(0, Math.min(cameraY, WORLD_SIZE - VIEW_SIZE));

        // Draw only the visible part of the world (based on the camera position)
        for (ElementDeJeu creature : world.elems.values()) {
            Point2D pos = creature.pos;

            // Only draw creatures within the camera's view
            if (pos.getX() >= cameraX && pos.getX() < cameraX + VIEW_SIZE &&
                pos.getY() >= cameraY && pos.getY() < cameraY + VIEW_SIZE) {

                // Convert world coordinates to screen coordinates
                int screenX = (int) (pos.getX() - cameraX) * TILE_SIZE;
                int screenY = (int) (pos.getY() - cameraY) * TILE_SIZE;

                // Get the image associated with the creature's class
                Image creatureImage = elementImages.get(creature.getClass());

                if (creatureImage != null) {
                    g.drawImage(creatureImage, screenX, screenY, TILE_SIZE, TILE_SIZE, this);
                }
            }
        }

        // Draw the player character
        int playerScreenX = (int) (playerPos.getX() - cameraX) * TILE_SIZE;
        int playerScreenY = (int) (playerPos.getY() - cameraY) * TILE_SIZE;
        g.drawImage(this.playerImage, playerScreenX, playerScreenY, TILE_SIZE, TILE_SIZE, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) { // Repaint the panel to update character positions
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        // Handle arrow keys to move the player
        switch (keyCode) {
            case KeyEvent.VK_Q:
                int confirm = JOptionPane.showConfirmDialog(this, 
                "Are you sure you want to exit?", 
                "Confirm Exit", 
                JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0); // Exit the application
                }
            case KeyEvent.VK_P: // pause/unpause
                JOptionPane.showMessageDialog(this, "Game Paused. Press 'ENTER' to resume.", "Pause", JOptionPane.INFORMATION_MESSAGE);
                break;
            case KeyEvent.VK_H: 
                JOptionPane.showMessageDialog(this, "Arrow Keys to move, F to pick into inventory,"+ 
                "C to combat, number keys(on top of the 1st row of letters in keyboard) to use inventory \n "+
                "Kill wolves, warriors and archers to gain XP\n Gather items and use them for magic effects \n"+ 
                "Have fun", "How to play", JOptionPane.INFORMATION_MESSAGE);
                break;
            case KeyEvent.VK_UP:
                play.deplacer(0, -1);
                break;
            case KeyEvent.VK_DOWN:
                play.deplacer(0, 1); // Move down
                break;
            case KeyEvent.VK_LEFT:
                play.deplacer(-1, 0); // Move left
                break;
            case KeyEvent.VK_RIGHT:
                play.deplacer(1, 0); // Move right
                break;
            case KeyEvent.VK_F:
                play.addToInventory();
                break;
            case KeyEvent.VK_1:
                play.use(0);
                break;
            case KeyEvent.VK_2:
                play.use(1);
                break;
            case KeyEvent.VK_3:
                play.use(2);
                break;
            case KeyEvent.VK_4:
                play.use(3);
                break;
            case KeyEvent.VK_5:
                play.use(4);
                break;
            case KeyEvent.VK_6:
                play.use(5);
                break;
            case KeyEvent.VK_C:
                play.combattre();
                break;
        }
        this.play.update();
        updatePlayerInfo();
        this.world.update(this.play);
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not used
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }

    // Update the player info in the info panel
    private void updatePlayerInfo() {
        // Calculate health percentage and adjust for display
        int healthPercentage = (int) (((float)player.ptVie /(float)play.getMaxHealth()) * 100);
        
        // Generate the health bar with a red background and green foreground
        String healthBar = "<div style='width: 100px; height: 20px; background-color: red;'>" +
                            "<div style='width: " + healthPercentage + "px; height: 20px; background-color: green;'></div>" +
                            "</div>";
    
        StringBuilder inventorySlots = new StringBuilder();
        inventorySlots.append("<table border='1' cellpadding='10'><tr>");
    
        for (int i = 0; i < 6; i++) {
            Objet item = play.inventaire.getObjet(i);  // Method to get the item in the inventory slot
            if (item != null) {
                // Get the image path for the item class from elementImagePaths map
                String itemImagePath = elementImagePaths.get(item.getClass());
                if (itemImagePath != null) {
                    // Embed the image using the path in the HTML img tag
                    inventorySlots.append("<td><img src='")
                        .append(getClass().getResource(itemImagePath))
                        .append("' width='40' height='40'/></td>");  // Adjust image size as needed
                } else {
                    inventorySlots.append("<td>Unknown Item</td>");
                }
            } else {
                // If the slot is empty, display a placeholder or "Empty"
                inventorySlots.append("<td>Empty</td>");
            }
    
            // After 3 items, break the row
            if (i == 2) {
                inventorySlots.append("</tr><tr>");
            }
        }
    
        // Close the table after adding all slots
        inventorySlots.append("</tr></table>");
        
        StringBuilder effectsSlots = new StringBuilder();
        effectsSlots.append("<table border='1' cellpadding='10'><tr>");
        // Assuming 'player' has a list of effects or buffs (e.g., play.getEffects())
        for (Utilisable effect : play.Buffs) {
            // Get the image path for the effect class
            String effectImagePath = elementImagePaths.get(effect.getClass());
            if (effectImagePath != null) {
                // Embed the image and add effect text (e.g., effect type and duration)
                effectsSlots.append("<td><img src='")
                    .append(getClass().getResource(effectImagePath))
                    .append("' width='40' height='40'/><br/>")
                    .append("Type: ").append(effect.getBuffDetails()).append("<br/>")  // Effect type
                    .append("Duration: ").append(effect.BuffDuration()).append("</td>");  // Effect duration
            } else {
                // If no image found, just display effect info
                effectsSlots.append("<td>Unknown Effect<br/>")
                    .append("Type: ").append(effect.getBuffDetails()).append("<br/>")
                    .append("Duration: ").append(effect.BuffDuration()).append("</td>");
            }

            // After 3 effects, break the row
            if (effectsSlots.length() % 3 == 0) {
                effectsSlots.append("</tr><tr>");
            }
        }

        // If no effects are present, display "No Effects"
        if (play.Buffs.isEmpty()) {
            effectsSlots.append("<td>No Effects</td>");
        }
        // Generate the player stats section
        String playerStats = "Player: " + play.username + "<br/>" +
                                "Score: " + play.XP + "<br/>" +
                                "Attack Chance: " + player.pageAtt + "<br/>" +
                                "Damage: " + player.degAtt + "<br/>" +
                                "Health: " + player.ptVie + "<br/>" +
                                "Range: " + player.distAttMax + "<br/>" +
                                "Parry Chance: " + player.pagePar + "<br/>" +
                                "Parry Amount: " + player.ptPar + "<br/>" +
                                "Position: (" + (int) player.pos.getX() + ", " + (int) player.pos.getY() + ")<br/>";
        if (player instanceof Archer){
            playerStats+="Quiver Count: " + ((Archer)player).nbFleches + "<br/>";
        }
    
    // Update the player info label with the new layout using a table with three columns
    String info = "<html>" +
                    "<table style='width:100%;'>" +
                    "<tr>" +
                    "<td style='vertical-align:top;'>" + playerStats + "</td>" +   // Column 1: Player Stats
                    "<td style='vertical-align:top;'>" + inventorySlots + "</td>" + // Column 2: Inventory Slots
                    "<td style='vertical-align:top; text-align:right;'>Health:<br/>" + healthBar + "</td>" + // Column 3: Health Bar
                    "<td style='vertical-align:top; text-align:left;'>Effects:<br/>" + effectsSlots + "</td>" +  // Column 4: Effects
                    "</tr>" +
                    "</table>" +
                    "</html>";
        playerInfoLabel.setText(info);
    }
}
