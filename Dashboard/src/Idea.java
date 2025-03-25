import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Idea {

    // Main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new IDS());
    }
}

// Main dashboard class
class MainDashboard {
    public MainDashboard() {
        JFrame frame = new JFrame("Main Dashboard");
        JButton addInstructorsButton = new JButton("Add Instructors");

        addInstructorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the instructor registration dashboard
                new InstructorRegistrationDashboard();
                frame.dispose(); // Close the main dashboard
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(null);
        addInstructorsButton.setBounds(80, 80, 140, 30);
        frame.add(addInstructorsButton);
        frame.setVisible(true);
    }
}

// Instructor registration dashboard class
class InstructorRegistrationDashboard {
    public InstructorRegistrationDashboard() {
        JFrame frame = new JFrame("Register Instructor");
        JLabel nameLabel = new JLabel("Instructor Name:");
        JTextField nameField = new JTextField();
        JButton registerButton = new JButton("Register");

        // Set layout and add components
        frame.setLayout(null);
        nameLabel.setBounds(20, 30, 120, 30);
        nameField.setBounds(150, 30, 120, 30);
        registerButton.setBounds(80, 80, 140, 30);

        // Add action listener for registration (for demonstration)
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String instructorName = nameField.getText();
                // Here you could add code to register the instructor
                JOptionPane.showMessageDialog(frame, "Instructor " + instructorName + " registered!");
            }
        });

        // Add components to frame
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(registerButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}