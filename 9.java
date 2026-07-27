import java.sql.*;

public class StudentJDBC {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "1234"; // Change to your MySQL password

        try {

            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect Database
            Connection con = DriverManager.getConnection(url, user, password);

            System.out.println("Database Connected Successfully.");

            // INSERT
            String insertQuery = "INSERT INTO student(roll_no,name,department,marks) VALUES(?,?,?,?)";

            PreparedStatement insert = con.prepareStatement(insertQuery);

            insert.setInt(1, 101);
            insert.setString(2, "Rahul");
            insert.setString(3, "CSE");
            insert.setInt(4, 90);
            insert.executeUpdate();

            insert.setInt(1, 102);
            insert.setString(2, "Sneha");
            insert.setString(3, "ISE");
            insert.setInt(4, 91);
            insert.executeUpdate();

            System.out.println("Records Inserted Successfully.");

            // SEARCH
            String searchQuery = "SELECT * FROM student WHERE roll_no=?";
            PreparedStatement search = con.prepareStatement(searchQuery);

            search.setInt(1, 101);

            ResultSet rs = search.executeQuery();

            if (rs.next()) {
                System.out.println("\nStudent Details");
                System.out.println("Roll No : " + rs.getInt("roll_no"));
                System.out.println("Name : " + rs.getString("name"));
                System.out.println("Department : " + rs.getString("department"));
                System.out.println("Marks : " + rs.getInt("marks"));
            }

            rs.close();

            // UPDATE
            String updateQuery = "UPDATE student SET marks=? WHERE roll_no=?";
            PreparedStatement update = con.prepareStatement(updateQuery);

            update.setInt(1, 95);
            update.setInt(2, 101);

            int rows = update.executeUpdate();

            if (rows > 0) {
                System.out.println("\nRecord Updated Successfully.");
            }

            // DISPLAY
            String displayQuery = "SELECT * FROM student";
            PreparedStatement display = con.prepareStatement(displayQuery);

            ResultSet result = display.executeQuery();

            System.out.println("\n------------------------------");
            System.out.println("Roll\tName\tDepartment\tMarks");
            System.out.println("------------------------------");

            while (result.next()) {

                System.out.println(
                        result.getInt("roll_no") + "\t"
                                + result.getString("name") + "\t"
                                + result.getString("department") + "\t\t"
                                + result.getInt("marks"));
            }

            result.close();

            insert.close();
            search.close();
            update.close();
            display.close();
            con.close();

            System.out.println("\nDatabase Connection Closed.");

        } catch (ClassNotFoundException e) {

            System.out.println("JDBC Driver Not Found.");
            e.printStackTrace();

        } catch (SQLException e) {

            System.out.println("Database Error.");
            e.printStackTrace();
        }
    }
}
