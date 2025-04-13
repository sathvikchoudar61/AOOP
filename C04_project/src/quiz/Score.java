package quiz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Score extends JFrame implements ActionListener {

    Score(String username, int score) {
        setBounds(500, 150, 600, 400);
        getContentPane().setBackground(new Color(240, 240, 240));
        setLayout(null);
        
        JLabel title = new JLabel("Quiz Completed!");
        title.setBounds(150, 30, 300, 40);
        title.setFont(new Font("Serif", Font.BOLD, 28));
        title.setForeground(new Color(50, 50, 50));
        add(title);
        
        JLabel message = new JLabel("Thank you, " + username + ", for participating!");
        message.setBounds(120, 100, 400, 30);
        message.setFont(new Font("SansSerif", Font.PLAIN, 18));
        add(message);
        
        JLabel scoreLabel = new JLabel("Your Score: " + score);
        scoreLabel.setBounds(200, 160, 200, 50);
        scoreLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        scoreLabel.setForeground(new Color(0, 102, 204));
        add(scoreLabel);
        
        JButton playAgain = new JButton("Play Again");
        playAgain.setBounds(200, 250, 180, 40);
        playAgain.setBackground(new Color(0, 102, 204));
        playAgain.setForeground(Color.WHITE);
        playAgain.setFont(new Font("SansSerif", Font.BOLD, 16));
        playAgain.setFocusPainted(false);
        playAgain.setBorder(BorderFactory.createEmptyBorder());
        playAgain.addActionListener(this);
        add(playAgain);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        this.setVisible(false);
        new Test("User");
    }
    
    public static void main(String[] args) {
        new Score("TestUser", 85).setVisible(true);
    }
}
