package org.centrale.objet.woe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameGUI extends JPanel implements ActionListener, KeyListener {
    private static final int TILE_SIZE = 30;
    private static final int WORLD_SIZE = 50; // 50x50 world grid
    private static final int VIEW_SIZE = WORLD_SIZE / 2; // 1/4 of the world grid visible (25x25 tiles)
    private World world; // Assume this is your world object
    private Personnage player; // The player character
    private Joueur play;
    private Image playerImage;
    private Timer timer;
    private JLabel playerInfoLabel;

    public GameGUI(World world, Joueur player, JLabel playerInfoLabel) {
        this.world = world;
        this.play = player;
        this.player = this.play.getPersonnage();
        this.playerInfoLabel = playerInfoLabel;
        this.setPlayerImage();
        this.setPreferredSize(new Dimension(VIEW_SIZE * TILE_SIZE, VIEW_SIZE * TILE_SIZE));
        this.setBackground(Color.WHITE);
        this.setFocusable(true);
        this.addKeyListener(this);
        timer = new Timer(100, this);
        timer.start();
        updatePlayerInfo(); // Initial display of player info
    }

    public void setPlayerImage() {
        if (this.player instanceof Guerrier) {
            this.playerImage = new ImageIcon("/home/dghanmi/warrior.png").getImage();
        } else {
            this.playerImage = new ImageIcon("/home/dghanmi/warrior.png").getImage(); // Use a different image for other types
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

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

                if (creature instanceof Guerrier) {
                    g.setColor(Color.RED);
                } else if (creature instanceof Archer) {
                    g.setColor(Color.ORANGE);
                } else if (creature instanceof Paysan) {
                    g.setColor(Color.BLUE);
                } else if (creature instanceof Loup) {
                    g.setColor(Color.GRAY);
                } else if (creature instanceof Epee) {
                    g.setColor(Color.CYAN);
                } else {
                    g.setColor(Color.PINK);
                }
                g.fillRect(screenX, screenY, TILE_SIZE, TILE_SIZE);
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
                break;
            case KeyEvent.VK_P: // Add this case to pause/unpause
                    JOptionPane.showMessageDialog(this, "Game Paused. Press 'P' to resume.", "Pause", JOptionPane.INFORMATION_MESSAGE);
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
        // Update player position and info
        updatePlayerInfo();
        this.world.update();
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
// Update the player info in the info panel
private void updatePlayerInfo() {
    // Generate the HTML for the health bar as a wide row
    int healthPercentage = (int) ((player.ptVie / (double) player.ptVie) * 100);
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
