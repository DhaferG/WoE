package org.centrale.objet.woe.gui;

import javax.swing.*;
import org.centrale.objet.woe.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class GameGUI extends JPanel implements ActionListener, KeyListener {
    private static final int TILE_SIZE = 30;
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
        elementImages.put(NuageToxique.class, new ImageIcon(getClass().getResource("/images/cloud.png")).getImage());
        
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
    public void actionPerformed(ActionEvent e) {
        repaint(); // Repaint the panel to update character positions
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
                JOptionPane.showMessageDialog(this, "Arrow Keys to move, F to pick into inventory, C to combat, number keys to use inventory", "How to play", JOptionPane.INFORMATION_MESSAGE);
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
        int healthPercentage = (int) ((player.ptVie / (double) play.getMaxHealth()) * 100);
        String healthBarColor = "red"; // You can adjust this to change color based on health value
        
        String healthBar = "<div style='width: 100px; height: 20px; background-color: lightgray;'>" +
                        "<div style='width: " + healthPercentage + "px; height: 100%; background-color: " + healthBarColor + ";'></div>" +
                        "</div>";

        // Generate the HTML for the inventory slots (two rows of three)
        String inventorySlots = "<table border='1' cellpadding='10'>" +
                                "<tr>" +
                                "<td>Slot 1</td><td>Slot 2</td><td>Slot 3</td>" +
                                "</tr><tr>" +
                                "<td>Slot 4</td><td>Slot 5</td><td>Slot 6</td>" +
                                "</tr></table>";

        // Update the player info label with the new layout
        String info = "<html>" +
                    "<div style='display: flex;'>" +
                    "<div style='flex: 1;'>" + 
                    "Player: " + player.nom + "<br/>" +
                    "Attack Points: " + player.pageAtt + "<br/>" +
                    "Damage: " + player.degAtt + "<br/>" +
                    "Health: " + player.ptVie + "<br/>" +
                    "Range: " + player.distAttMax + "<br/>" +
                    "Position: (" + (int) player.pos.getX() + ", " + (int) player.pos.getY() + ")<br/>" +
                    "</div>" +
                    "<div style='flex: 1; display: flex; flex-direction: column; align-items: flex-end;'>" +
                    "<div>Health:<br/>" + healthBar + "</div>" +
                    "<div>Inventory:<br/>" + inventorySlots + "</div>" +
                    "</div>" +
                    "</div>" +
                    "</html>";

        playerInfoLabel.setText(info);
    }

    public static void main(String[] args) {
        World world = new World();
        world.creeMondeAlea(100);
        Joueur joueurHumain = new Joueur(world);

        // Create the main frame
        JFrame frame = new JFrame("World of ECN");
        frame.setLayout(new BorderLayout());

        // Create the player info panel
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BorderLayout());
        infoPanel.setBackground(Color.LIGHT_GRAY);

        // Create player info label
        JLabel playerInfoLabel = new JLabel();
        playerInfoLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        infoPanel.add(playerInfoLabel, BorderLayout.NORTH);

        // Create the game panel
        GameGUI gamePanel = new GameGUI(world, joueurHumain, playerInfoLabel);

        // Add the game panel (center) and player info panel (south)
        frame.add(gamePanel, BorderLayout.CENTER);
        frame.add(infoPanel, BorderLayout.SOUTH);

        // Set up the frame
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
