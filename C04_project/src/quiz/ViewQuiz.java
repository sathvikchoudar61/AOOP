package quiz;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import static quiz.application.Test.i;

public class ViewQuiz extends JInternalFrame {
    NumberOfQuestions numberOfQuestions = new NumberOfQuestions();
    public int numberofQuestion = numberOfQuestions.getCount();
    
    String Questions[][] = new String[numberofQuestion][5];
    String Answers[][]   = new String[numberofQuestion][1];
    JLabel[] question, option1, option2, option3, option4;

    public ViewQuiz() {
        // Initialize arrays for storing questions and options
        question = new JLabel[numberofQuestion];
        option1 = new JLabel[numberofQuestion];
        option2 = new JLabel[numberofQuestion];
        option3 = new JLabel[numberofQuestion];
        option4 = new JLabel[numberofQuestion];
        
        // Set up the layout
        setLayout(new GridLayout(numberofQuestion, 1));
        
        Connection con = ConnectionProvider.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("select * from question");
            ResultSet rs = ps.executeQuery();
            int i = 0; // Reset the index here to avoid errors
            while(rs.next()) {
                // Fill the questions and answers arrays
                Questions[i][0] = rs.getString(2); // Question
                Questions[i][1] = rs.getString(3); // Option 1
                Questions[i][2] = rs.getString(4); // Option 2
                Questions[i][3] = rs.getString(5); // Option 3
                Questions[i][4] = rs.getString(6); // Option 4
                Answers[i][0] = rs.getString(7);   // Correct answer
                i++; // Increment index for next question
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        // Add the questions and options to the panel
        for (int i = 0; i < numberofQuestion; i++) {
            add(question[i] = new JLabel("Q: " + Questions[i][0]));
            add(option1[i] = new JLabel("1. " + Questions[i][1]));
            add(option2[i] = new JLabel("2. " + Questions[i][2]));
            add(option3[i] = new JLabel("3. " + Questions[i][3]));
            add(option4[i] = new JLabel("4. " + Questions[i][4]));
        }
        
        // Set up the internal frame
        setSize(500, 500);
        setClosable(true);
        setVisible(true);
        setTitle("All Questions");
    }

    public static void main(String args[]) {
        new ViewQuiz();
    }
}
