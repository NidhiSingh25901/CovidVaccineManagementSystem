package Vaccine;
import java.sql.*;
public class Conn { 
    Connection c;
    Statement s;
    public Conn() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           c =  DriverManager.getConnection("jdbc:mysql:///CovidVaccineManagementSystem", "root", "");
           //c =  DriverManager.getConnection("jdbc:mysql:CovidVaccineManagementSystem.sql");
           s = c.createStatement();

        } catch(Exception e) {

        }
    }
}
