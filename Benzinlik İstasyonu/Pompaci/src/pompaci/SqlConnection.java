/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pompaci;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author mustafa
 */
public class SqlConnection {
    private Connection connection = null;
    private ResultSet rs = null;
    private Statement statement;

    public SqlConnection()
    {
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://saat-odev-do-user-9660646-0.b.db.ondigitalocean.com:25060/defaultdb", "doadmin", "AVNS_zVuqNBaIN8GDio1");

        } catch (Exception exception) {
            exception.printStackTrace();

        }
    }
    public ResultSet executeQuery(String query)
    {
        try
        {
            statement = connection.createStatement();
            
            rs = statement.executeQuery(query);
            
            return rs;
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public int executeUpdate(String query)
    {
        int result = 0;
        try
        {
            statement = connection.createStatement();
            
            result = statement.executeUpdate(query);

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }
    public void closeConnection()
    {
        try
        {
            statement.close();
            connection.close();
        }catch (Exception e)
        {
           e.printStackTrace();
        }

    }
}
