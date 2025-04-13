package quiz;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UserProfile {

    JFrame f;
    JPanel panel, top_panel;
    JLabel l = new JLabel();

    UserProfile(String Username) {
        f = new JFrame();
        panel = new JPanel();
        top_panel = new JPanel();
        
        // Create a label with the welcome message
        l.setText("Welcome to Quiz World , " + Username);
        
        // Create buttons for different directions and quiz
        JButton b1 = new JButton("NORTH");
        JButton b2 = new JButton("SOUTH");
        JButton b3 = new JButton("EAST");
        JButton b4 = new JButton("WEST");
        JButton b5 = new JButton("Take Quiz");

        // Set the size and layout for buttons and label
        b5.setBounds(200, 200, 150, 30); // Position "Take Quiz" button
        l.setBounds(500, 50, 300, 30);   // Position the welcome label

        // Add components to the panel
        panel.setLayout(null);  // Using null layout for manual positioning
        panel.add(b5);
        panel.add(l);
        
        // Setup the top panel (empty, just for organization)
        top_panel.setLayout(null);
        top_panel.add(b1);

        // Add panels to frame
        f.setLayout(new BorderLayout());
        f.add(top_panel, BorderLayout.NORTH);
        f.add(panel, BorderLayout.CENTER);

        // Action listener for the "Take Quiz" button
        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Test(Username);  // Start the quiz
                f.setVisible(false); // Close the UserProfile window
            }
        });

        // Window settings
        f.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the window
        f.setTitle("Welcome " + Username);
        f.setSize(800, 600); // Set an appropriate size for the window
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the application exits when the window is closed
        f.setVisible(true); // Make the frame visible
    }

    public static void main(String[] args) {
        // Example usage with a test username
        new UserProfile("JohnDoe");
    }
}
