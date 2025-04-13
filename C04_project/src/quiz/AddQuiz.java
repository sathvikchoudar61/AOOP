package quiz;
import java.sql.*;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AddQuiz extends JInternalFrame {
    private NumberOfQuestions numberOfQuestions = new NumberOfQuestions();
    private int i;
    private int numberofQuestion = numberOfQuestions.getCount();
      
    private JPanel panel = new JPanel(); 
    private JLabel question = new JLabel("Question");
    private JLabel options1 = new JLabel("Option1");
    private JLabel options2 = new JLabel("Option2");
    private JLabel options3 = new JLabel("Option3");
    private JLabel options4 = new JLabel("Option4");
    private JLabel answer = new JLabel("Answer");
    private JTextField tf_question = new JTextField();
    private JTextField tf_option1 = new JTextField();
    private JTextField tf_option2 = new JTextField();
    private JTextField tf_option3 = new JTextField();
    private JTextField tf_option4 = new JTextField();
    private JTextField tf_answer = new JTextField();
    private JButton btn_add_question = new JButton("Add Question");
    private JComboBox<String> cb_quiz;
    private DefaultComboBoxModel<String> quizModel;
    private String[] Quiz = new String[10];
    
    public AddQuiz() {
        AddQuizes();
        
        quizModel = new DefaultComboBoxModel<>(Quiz);
        cb_quiz = new JComboBox<>(quizModel);

        question.setBounds(10, 10, 80, 30);
        options1.setBounds(10, 40, 80, 30);
        options2.setBounds(10, 70, 80, 30);
        options3.setBounds(10, 110, 80, 30);
        options4.setBounds(10, 150, 80, 30);
        answer.setBounds(10, 190, 80, 30);
        tf_question.setBounds(100, 10, 200, 30);
        tf_option1.setBounds(100, 40, 80, 30);
        tf_option2.setBounds(100, 70, 80, 30);
        tf_option3.setBounds(100, 110, 80, 30);
        tf_option4.setBounds(100, 150, 80, 30);
        tf_answer.setBounds(100, 190, 80, 30);
        cb_quiz.setBounds(40, 230, 100, 40);
        btn_add_question.setBounds(40, 280, 80, 30);
        
        panel.add(question);
        panel.add(options1);
        panel.add(options2);
        panel.add(options3);
        panel.add(options4);
        panel.add(answer);
        panel.add(tf_question);
        panel.add(tf_option1);
        panel.add(tf_option2);
        panel.add(tf_option3);
        panel.add(tf_option4);
        panel.add(tf_answer);
        panel.add(btn_add_question);
        panel.add(cb_quiz);

        btn_add_question.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  
                AddQuestion(); 
            }  
        });

        panel.setLayout(null);
        add(panel);  
        setSize(600, 600);  
        setClosable(true);
        setVisible(true);  
        setTitle("Add New Question");
        pack();
    }
        
    private void AddQuestion() {
        String Question = tf_question.getText();
        String Option1 = tf_option1.getText();
        String Option2 = tf_option2.getText();
        String Option3 = tf_option3.getText();
        String Option4 = tf_option4.getText();
        String Answer = tf_answer.getText();
        
        // Validate inputs
        if (Question.isEmpty() || Option1.isEmpty() || Option2.isEmpty() || Option3.isEmpty() || Option4.isEmpty() || Answer.isEmpty()) {
            JOptionPane.showMessageDialog(btn_add_question, "All fields must be filled out.");
            return;
        }

        // Get selected quiz name from JComboBox
        String selectedQuiz = (String) cb_quiz.getSelectedItem();

        // Assuming you have a method to get the quiz ID based on the selected name
        int quizID = getQuizID(selectedQuiz);

        // Insert into database
        try (Connection con = ConnectionProvider.getConnection()) {
            String query = "INSERT INTO question (Name, Option1, Option2, Option3, Option4, Answer, QuizID) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setString(1, Question);
                ps.setString(2, Option1);
                ps.setString(3, Option2);
                ps.setString(4, Option3);
                ps.setString(5, Option4);
                ps.setString(6, Answer);
                ps.setInt(7, quizID);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(btn_add_question, "Question Saved Successfully");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(btn_add_question, "Error saving the question.");
        }
    }

    private int getQuizID(String quizName) {
        // Get the QuizID from the database based on the quiz name
        try (Connection con = ConnectionProvider.getConnection()) {
            String query = "SELECT QuizID FROM quiz WHERE Name = ?";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setString(1, quizName);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return rs.getInt("QuizID");
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return -1; // Return -1 if quiz not found
    }
    
    private void AddQuizes() {
        try (Connection con = ConnectionProvider.getConnection()) {
            String query = "SELECT * FROM quiz";
            try (PreparedStatement ps = con.prepareStatement(query);
                 ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Quiz[i] = rs.getString("Name");
                    i++;
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
