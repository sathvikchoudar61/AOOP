package quiz;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class QuizApplication implements ActionListener {

    JFrame f;
    JPanel p, p1;
    CardLayout card;
    JButton addQuiz = new JButton("Add Question");
    JButton updateQuiz = new JButton("Update Or Remove Question");
    JButton viewQuiz = new JButton("View Questions");
    JButton exit = new JButton("Exit");
    JButton logout = new JButton("Logout");

    QuizApplication() {
        f = new JFrame();
        p = new JPanel();
        p1 = new JPanel();

        // Initialize CardLayout and set the layout of p1
        card = new CardLayout();
        p1.setLayout(card);
        
        p.add(addQuiz);
        p.add(updateQuiz);
        p.add(viewQuiz);
        p.add(exit);
        p.add(logout);
        p.setLayout(new GridLayout(5, 1));

        // Add panels to the CardLayout container
        f.add(p, BorderLayout.LINE_START);
        
        // Creating the different panels for each view
        AddQuiz addPanel = new AddQuiz();
        EditQuiz editPanel = new EditQuiz();
        ViewQuiz viewPanel = new ViewQuiz();
        
        p1.add(addPanel, "Add Quiz");
        p1.add(editPanel, "Edit Quiz");
        p1.add(viewPanel, "View Quiz");

        f.add(p1, BorderLayout.CENTER);

        addQuiz.addActionListener(this);
        updateQuiz.addActionListener(this);
        viewQuiz.addActionListener(this);
        exit.addActionListener(this);
        logout.addActionListener(this);

        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setSize(300, 300);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addQuiz) {
            card.show(p1, "Add Quiz"); // Show AddQuiz panel
        }
        if (e.getSource() == updateQuiz) {
            card.show(p1, "Edit Quiz"); // Show EditQuiz panel
        }
        if (e.getSource() == viewQuiz) {
            card.show(p1, "View Quiz"); // Show ViewQuiz panel
        }
        if (e.getSource() == exit) {
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
            f.setVisible(false);
        }
        if (e.getSource() == logout) {
            f.setVisible(false); 
            new Registration(); // Assuming you have a Registration class
        }
    }

    public static void main(String[] args) {
        new QuizApplication();
    }
}
