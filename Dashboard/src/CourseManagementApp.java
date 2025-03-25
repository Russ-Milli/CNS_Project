import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CourseManagementApp {

    private static final String DB_URL = "jdbc:mysql://localhost:5432/PlungerSchool"; // Change your_database
    private static final String USER = "postgres"; // Change your_username
    private static final String PASS = "Godisawesome_21"; // Change your_password

    public static void main(String[] args) {
        JFrame frame = new JFrame("Course Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JButton coursesButton = new JButton("View Courses");
        JButton studentsButton = new JButton("View Students");
        JButton instructorsButton = new JButton("View Instructors");

        coursesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fetchAndDisplayData("SELECT * FROM course");
            }
        });

        studentsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fetchAndDisplayData("SELECT * FROM student");
            }
        });

        instructorsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fetchAndDisplayData("SELECT * FROM instructor");
            }
        });

        panel.add(coursesButton);
        panel.add(studentsButton);
        panel.add(instructorsButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    private static void fetchAndDisplayData(String query) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            StringBuilder output = new StringBuilder("<html>");
            while (rs.next()) {
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    output.append(rs.getMetaData().getColumnName(i)).append(": ").append(rs.getString(i)).append("<br>");
                }
                output.append("<br>");
            }
            output.append("</html>");

            JOptionPane.showMessageDialog(null, output.toString(), "Data", JOptionPane.INFORMATION_MESSAGE);

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error fetching data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
