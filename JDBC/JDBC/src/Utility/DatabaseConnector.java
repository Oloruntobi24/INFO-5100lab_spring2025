/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import java.sql.*;
import java.util.ArrayList;
import model.User;

/**
 *
 * @author rishabhkaushick
 */
public class DatabaseConnector {
    
    // DB_URL = "jdbc:<database>://ip_address:port/database_name";
    static final String DB_URL = "jdbc:mysql://localhost:3306/userdb";
    static final String DB_USERNAME = "root";
    static final String DB_PASSWORD = "root";
    
    // Create a connection
    
    // CRUD Operations
    
    // CRUD Operations on Database
    
    // C - Create: Inserting data into the database
    public static void addUser(User u1) throws SQLException{
        String query = "INSERT INTO student( first_name, last_name, age, gender, phone_number, email, college, hobbies) VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
        try{
            // Create a connection
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, u1.getfName());
            stmt.setString(2, u1.getlName());
            stmt.setInt(3, u1.getAge());
            stmt.setString(4, u1.getGender());
            stmt.setString(5, u1.getPhoneNumber());
            stmt.setString(7, u1.getCollege());
            stmt.setString(6, u1.getEmail());
            stmt.setString(8, u1.getHobby());
            
            // After this query will look like:
            // "INSERT INTO patient(first_name, age, college, hobbies) VALUES ('Rish', 28, 'COE', 'Football, guitar') "
            int rows = stmt.executeUpdate();
            System.out.println("Rows inserted: "+rows);
            
            // Close the connection
            conn.close();
        } catch (SQLException sqle){
            System.out.println("SQL Exception Occured.");            
            System.out.println(sqle);
        } catch (Exception ex){
            System.out.println(ex);
        }
        
        
    }
    // R - Read: Getting all the values from the database
    public static ArrayList<User> getUsers(){
        ArrayList <User> users = new ArrayList();
        String query = "SELECT * FROM student";
        try{
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                User u1 = new User();
                u1.setUserID(rs.getInt("student_id"));
                u1.setfName(rs.getString("first_name"));
                u1.setlName(rs.getString("last_name"));
                u1.setCollege(rs.getString("college"));
                u1.setPhoneNumber(rs.getString("phone_number"));
                u1.setAge(rs.getInt("age"));
                u1.setGender(rs.getNString("gender"));
                u1.setEmail(rs.getNString("email"));
                u1.setHobby(rs.getString("hobbies"));
                users.add(u1);
            }
            rs.close();
            conn.close();
        } catch (SQLException sqle){
            System.out.println("SQL Exception Occured.");            
            System.out.println(sqle);
        } catch (Exception ex){
            System.out.println(ex);
        }
        return users;
    }
    
    // U - Update: Changing a value in the database
    public static void updateUser(User oldUser, User updatedUser){
            String query = "UPDATE student SET first_name = ?, last_name = ?, age = ?, gender = ?, email = ?, phone_number = ?, college = ?, hobbies = ? WHERE student_id = ? ";
            // Update the query
        try{
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, updatedUser.getfName());
            stmt.setString(2, updatedUser.getlName());
            stmt.setString(7, updatedUser.getCollege());
            stmt.setInt(3, updatedUser.getAge());
            stmt.setString(5, updatedUser.getEmail());
            stmt.setString(4, updatedUser.getGender());
            stmt.setString(6, updatedUser.getPhoneNumber());
            stmt.setString(8, updatedUser.getHobby());
            stmt.setInt(9, oldUser.getUserID());
            int rows = stmt.executeUpdate();
            System.out.println("Rows updated: "+rows);
            conn.close();
        } catch (SQLException sqle){
            System.out.println("SQL Exception Occured.");            
            System.out.println(sqle);
        } catch (Exception ex){
            System.out.println(ex);
        }
    }
    
    // D - Delete 
    public static void deleteUser(User u1){
        String query = "DELETE FROM student WHERE student_id = ?";
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, u1.getUserID());
            int rows = stmt.executeUpdate();
            System.out.println("Rows deleted: "+rows);
            conn.close();
        } catch (SQLException sqle){
            System.out.println("SQL Exception Occured.");            
            System.out.println(sqle);
        } catch (Exception ex){
            System.out.println(ex);
        }
    }
}
