import java.sql.*;

public class JdbcExample {
    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/jdbcdemo";
        String username = "root";
        String password = "Gluestick141!";
        Statement statement = null;
        ResultSet resultSet = null;
        Connection conn = null;
        try {
             conn = DriverManager.getConnection(dbUrl,username,password);
            System.out.println("Connected succesfully");
             statement = conn.createStatement();
             resultSet = statement.executeQuery("Select * FROM employees");
            statement = conn.createStatement();
            statement.execute("INSERT INTO EMPLOYEES VALUES(NULL, 'JACK', 44)");


            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("Age");

                System.out.println("ID: "+ id+ " Name: " + name + " Age: " + age);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //Execute the sql statements

    }
}
