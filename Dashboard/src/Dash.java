import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dash extends JFrame {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/PlungerSchool"; // Update with your database
    private static final String USER = "postgres"; // Update with your username
    private static final String PASSWORD = "Godisawesome@21"; // Update with your password

    public Dash() {
        setTitle("Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setContentPane(new JLabel(new ImageIcon("src/school_badge.jpg"))); // Set background image
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Spacing between buttons

        // View Courses Button
        JButton viewCoursesButton = new JButton("View Courses");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        viewCoursesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fetchData("courses");
            }
        });
        add(viewCoursesButton, gbc);

        // View Students Button
        JButton viewStudentsButton = new JButton("View Students");
        gbc.gridy = 1; // Move to the next row
        viewStudentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fetchData("students");
            }
        });
        add(viewStudentsButton, gbc);

        // View Instructors Button
        JButton viewInstructorsButton = new JButton("View Instructors");
        gbc.gridy = 2; // Move to the next row
        viewInstructorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fetchData("instructors");
            }
        });
        add(viewInstructorsButton, gbc);
    }

    private void fetchData(String type) {
        String query = "";
        switch (type) {
            case "courses":
                query = "SELECT * FROM course"; // Adjust your table name and columns
                break;
            case "students":
                query = "SELECT * FROM student"; // Adjust your table name and columns
                break;
            case "instructors":
                query = "SELECT * FROM instructor"; // Adjust your table name and columns
                break;
        }

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            StringBuilder result = new StringBuilder("<html>");
            while (resultSet.next()) {
                // Assuming a simple structure for display
                if (type.equals("course")) {
                    result.append("Course ID: ").append(resultSet.getString("id")).append(", ");
                    result.append("Course Name: ").append(resultSet.getString("name")).append("<br>");
                } else if (type.equals("student")) {
                    result.append("Student ID: ").append(resultSet.getString("id")).append(", ");
                    result.append("Student Name: ").append(resultSet.getString("name")).append("<br>");
                } else if (type.equals("instructor")) {
                    result.append("Instructor ID: ").append(resultSet.getString("id")).append(", ");
                    result.append("Instructor Name: ").append(resultSet.getString("name")).append("<br>");
                }
            }
            result.append("</html>");
            JOptionPane.showMessageDialog(this, result.toString(), type + " Data", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Dashboard dashboard = new Dashboard();
            dashboard.setVisible(true);
        });
    }
}