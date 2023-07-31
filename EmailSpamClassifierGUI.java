import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EmailSpamClassifierGUI extends JFrame {
    private JTextField emailTextField;
    private JButton classifyButton;
    private JLabel resultLabel;

    public EmailSpamClassifierGUI() {
        setTitle("Email Spam Classifier");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        JPanel panel = new JPanel(new FlowLayout());
        JLabel emailLabel = new JLabel("Email:");
        emailTextField = new JTextField(20);
        classifyButton = new JButton("Classify");
        resultLabel = new JLabel("");

        // Add components to panel
        panel.add(emailLabel);
        panel.add(emailTextField);
        panel.add(classifyButton);
        panel.add(resultLabel);

        // Set panel as content pane
        setContentPane(panel);

        // Register button action listener
        classifyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == classifyButton) {
                    String email = emailTextField.getText();

                    // Perform email classification
                    boolean isSpam = classifyEmail(email);

                    // Display the result
                    if (isSpam) {
                        resultLabel.setText("Spam");
                    } else {
                        resultLabel.setText("Not Spam");
                    }
                }
            }
        });
    }

    private boolean classifyEmail(String email) {
        // Perform email classification using a decision tree algorithm
        // Replace with your own implementation or model loading code

        // Sample dataset
        String[] spamKeywords = {"sale", "offer", "discount", "arrivals", "price", "promotion"};
        for (String keyword : spamKeywords) {
            if (email.toLowerCase().contains(keyword)) {
                return true; // Considered as spam
            }
        }

        return false; // Not considered as spam
    }

    public static void main(String[] args) {
        EmailSpamClassifierGUI gui = new EmailSpamClassifierGUI();
        gui.setVisible(true);
    }
}
