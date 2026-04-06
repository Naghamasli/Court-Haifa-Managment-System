package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BackgroundPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private ImageIcon backgroundImage;


    public BackgroundPanel() {
        setLayout(null);
        backgroundImage = new ImageIcon("others/video.gif");       
        JLabel label = new JLabel("welcome to the Court system!");
        label.setBounds(10, 358, 343, 49); // Set the label's position and size
        label.setForeground(new Color(0, 64, 128));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBackground(new Color(204, 204, 153));
        label.setFont(new Font("Arial Narrow", Font.BOLD, 20));
        add(label); 
    }
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Draw the background image
		if (backgroundImage != null) {
			g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
		}
	}
	
}
