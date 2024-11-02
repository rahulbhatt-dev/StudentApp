package org.example;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static String LOAD_Driver = "com.mysql.cj.jdbc.Driver";
    public static String URL = "jdbc:mysql://localhost:3306/studentdb";
    public static String USER = "root";
    public static String PASSWORD = "root";
    public static void main( String[] args )
    {
        try{
            //Load Driver
            Class.forName(LOAD_Driver);

            //making connection
            Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);

            //Create statement
            Statement statement = connection.createStatement();

            //create query
            String query = "select * from student";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next())
            {
                int id =resultSet.getInt("Id");
                String name=resultSet.getString("Sname");
                String course=resultSet.getString("course");
                System.out.println("ID: "+id +", Name: "+name +", Course: "+course);
            }
            connection.close();
    
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
