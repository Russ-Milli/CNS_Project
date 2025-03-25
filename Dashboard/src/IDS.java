import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IDS   {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(IDS::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Main Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLayout(new GridLayout(5, 1, 10, 10)); // 5 rows, 1 column with spacing

        // View Course Button
        JButton viewCourseButton = new JButton("View Course");
        viewCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simulate fetching data from a database
                JOptionPane.showMessageDialog(frame, "Displaying courses from the database...");
            }
        });
        frame.add(viewCourseButton);

        // View Students Button
        JButton viewStudentsButton = new JButton("View Students");
        viewStudentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simulate fetching data from a database
                JOptionPane.showMessageDialog(frame, "Displaying students from the database...");
            }
        });
        frame.add(viewStudentsButton);

        // View Instructors Button
        JButton viewInstructorsButton = new JButton("View Instructors");
        viewInstructorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simulate fetching data from a database
                JOptionPane.showMessageDialog(frame, "Displaying instructors from the database...");
            }
        });
        frame.add(viewInstructorsButton);

        // Add Student Button
        JButton addStudentButton = new JButton("Add Student");
        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddStudentForm(); // Open the add student form
                frame.dispose(); // Close the main dashboard
            }
        });
        frame.add(addStudentButton);

        // Add Instructor Button
        JButton addInstructorButton = new JButton("Add Instructor");
        addInstructorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddInstructorForm(); // Open the add instructor form
                frame.dispose(); // Close the main dashboard
            }
        });
        frame.add(addInstructorButton);

        frame.setVisible(true);
    }
}

// Add Student Form Class
class AddStudentForm {
    public AddStudentForm() {
        JFrame frame = new JFrame("Add Student");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(3, 2));

        // Student Name Field
        frame.add(new JLabel("Student Name:"));
        JTextField studentNameField = new JTextField();
        frame.add(studentNameField);

        // Student ID Field
        frame.add(new JLabel("Student ID:"));
        JTextField studentIdField = new JTextField();
        frame.add(studentIdField);

        // Add Button
        JButton addButton = new JButton("Add Student");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentName = studentNameField.getText();
                String studentId = studentIdField.getText();
                // Here you could add logic to save the student details
                JOptionPane.showMessageDialog(frame, "Student " + studentName + " with ID " + studentId + " added!");
                frame.dispose(); // Close the form
            }
        });
        frame.add(addButton);

        frame.setVisible(true);
    }
}

// Add Instructor Form Class
class AddInstructorForm {
    public AddInstructorForm() {
        JFrame frame = new JFrame("Add Instructor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(3, 2));

        // Instructor Name Field
        frame.add(new JLabel("Instructor Name:"));
        JTextField instructorNameField = new JTextField();
        frame.add(instructorNameField);

        // Instructor ID Field
        frame.add(new JLabel("Instructor ID:"));
        JTextField instructorIdField = new JTextField();
        frame.add(instructorIdField);

        // Add Button
        JButton addButton = new JButton("Add Instructor");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String instructorName = instructorNameField.getText();
                String instructorId = instructorIdField.getText();
                // Here you could add logic to save the instructor details
                JOptionPane.showMessageDialog(frame, "Instructor " + instructorName + " with ID " + instructorId + " added!");
                frame.dispose(); // Close the form
            }
        });
        frame.add(addButton);

        frame.setVisible(true);
    }
}
