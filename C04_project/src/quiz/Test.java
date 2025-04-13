package quiz;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Test implements ActionListener, WindowFocusListener {
    JFrame frame;
    JLabel question;
    JRadioButton option1, option2, option3, option4;
    JButton save, submit, cancel;
    String[][] Questions;
    String[][] Answers;
    String[][] pa;
    String Username;
    ButtonGroup options;
    public static int i = 0;
    public static int count = 0;
    public int score = 0;
    public int numberofQuestion;
    private boolean allowExit = false; // Prevents tab switching except when exiting

    public Test(String Username) {
        this.Username = Username;
        frame = new JFrame();
        frame.addWindowFocusListener(this); // Listen for focus changes

        // Set full-screen mode
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);

        // Panel for question & options
        JPanel quizPanel = new JPanel();
        quizPanel.setLayout(new GridLayout(5, 1, 10, 10)); // Grid layout for structured alignment
        quizPanel.setBounds(100, 50, 800, 300);
        quizPanel.setBorder(BorderFactory.createTitledBorder("Question"));
        quizPanel.setBackground(new Color(240, 240, 240)); // Light grey background
        quizPanel.setOpaque(true);

        // **Highlighted Question Label**
        question = new JLabel("", JLabel.CENTER);
        question.setFont(new Font("Arial", Font.BOLD, 24)); // Increased Font Size
        question.setForeground(new Color(0, 102, 204)); // Highlighted Color (Blue)

        option1 = new JRadioButton();
        option2 = new JRadioButton();
        option3 = new JRadioButton();
        option4 = new JRadioButton();
        save = new JButton("Save & Next");
        submit = new JButton("Submit");
        cancel = new JButton("Cancel"); // Cancel button

        options = new ButtonGroup();
        options.add(option1);
        options.add(option2);
        options.add(option3);
        options.add(option4);

        quizPanel.add(question);
        quizPanel.add(option1);
        quizPanel.add(option2);
        quizPanel.add(option3);
        quizPanel.add(option4);

        // Positioning buttons
        save.setBounds(150, 400, 150, 50);
        submit.setBounds(350, 400, 150, 50);
        cancel.setBounds(550, 400, 150, 50); 

        Connection con = ConnectionProvider.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM question", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = ps.executeQuery();

            rs.last();
            numberofQuestion = rs.getRow();
            rs.beforeFirst();

            Questions = new String[numberofQuestion][5];
            Answers = new String[numberofQuestion][1];
            pa = new String[numberofQuestion][1];

            i = 0;
            while (rs.next()) {
                Questions[i][0] = rs.getString(2); // Question
                Questions[i][1] = rs.getString(3); // Option 1
                Questions[i][2] = rs.getString(4); // Option 2
                Questions[i][3] = rs.getString(5); // Option 3
                Questions[i][4] = rs.getString(6); // Option 4
                Answers[i][0] = rs.getString(7); // Correct Answer
                i++;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        save.addActionListener(this);
        submit.addActionListener(this);
        cancel.addActionListener(e -> {
            allowExit = true; // Temporarily allow exit

            int choice = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Exit Quiz", JOptionPane.YES_NO_OPTION);

            if (choice == JOptionPane.YES_OPTION) {
                frame.dispose(); // Close the quiz window
            } else {
                allowExit = false; // Prevent tab switching again
            }
        });

        frame.add(quizPanel);
        frame.add(save);
        frame.add(submit);
        frame.add(cancel); // Add cancel button

        frame.setLayout(null);
        frame.setVisible(true);
        frame.setTitle("Test is Running");
        frame.setAlwaysOnTop(true); // Keeps window on top
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Prevent closing

        start(0); // Start the test with the first question
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == save) {
            if (options.getSelection() == null) {
                pa[count][0] = "";
            } else {
                pa[count][0] = options.getSelection().getActionCommand();
            }

            if (count == (numberofQuestion - 2)) {
                save.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);
        } else if (ae.getSource() == submit) {
            if (options.getSelection() == null) {
                pa[count][0] = "";
            } else {
                pa[count][0] = options.getSelection().getActionCommand();
            }

            for (int ii = 0; ii < pa.length; ii++) {
                if (pa[ii][0].equals(Answers[ii][0])) {
                    score += 10;
                }
            }
            allowExit = true; // Allow tab switching after submission
            frame.setVisible(false);
            new Score(Username, score).setVisible(true);
        }
    }

    public void start(int count) {
        question.setText("<html><b>" + Questions[count][0] + "</b></html>"); // Highlight question
        option1.setText(Questions[count][1]);
        option1.setActionCommand(Questions[count][1]);
        option2.setText(Questions[count][2]);
        option2.setActionCommand(Questions[count][2]);
        option3.setText(Questions[count][3]);
        option3.setActionCommand(Questions[count][3]);
        option4.setText(Questions[count][4]);
        option4.setActionCommand(Questions[count][4]);
        options.clearSelection();
    }

    @Override
    public void windowGainedFocus(WindowEvent e) {
        // Keep window in focus
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        if (!allowExit) { // Only prevent tab switching if the quiz is active
            JOptionPane.showMessageDialog(frame, "You cannot switch tabs during the quiz!", "Warning", JOptionPane.WARNING_MESSAGE);
            frame.toFront();
            frame.requestFocus();
        }
    }
}
