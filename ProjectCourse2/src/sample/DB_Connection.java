package sample;

import java.sql.*;
import java.sql.DriverManager;
public class DB_Connection {


        String url = "jdbc:mysql://127.0.0.1:3306/mixnmatch?user=root&password=root";
        Statement statement;
        boolean exists;

        public DB_Connection() {
            try {
                Connection c = (Connection) DriverManager.getConnection(url);
                statement = c.createStatement();
            } catch (SQLException ex) {
                System.out.println("the connection fails");
            }
        }

        public void checklogin(String email,String password) {
            exists = false;
            try {
                ResultSet rs = statement.executeQuery("SELECT * FROM Profile WHERE Email ='" + email + "'And Password='" + password + "'");

                while (rs.next()) {
                    System.out.println(" The Password " + password + " is in the database with the Email " + rs.getString(8));
                    exists = true;
                    return;
                }
                if (exists==false){
                    System.out.println("doesnt exist");
                }
            }

            catch(SQLException ex)
            {
                System.out.println("error on executing the query");
            }

        }
        public void newprofile(String SSN,String name,String Gender,String Program,String email,String Biography,String Password){
            try {
                String sqlUpdate="Insert INTO Profile(SSN,Name,Gender,Program,Email,Biography,Password) Values('"+SSN+"','"+name+"','"+Gender+"','"+Program+"','"+email+"','"+Biography+"','"+Password+"')";
                statement.executeUpdate(sqlUpdate);
                System.out.println();
                System.out.println("Table updated!");
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("Not working");
            }

        }
    }

