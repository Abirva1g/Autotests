import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.net.ConnectException;
import java.sql.*;

public class examp {



    public static void main(String[] args) {

        String url = "jdbc:postgresql://172.24.120.5:5432/postgres";
        String login = "root";
        String password = "root";

        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            Statement statement = connection.createStatement();
            String sqlQuery ="SELECT ID FROM nfaut.users WHERE login = 'ASSEROV'";
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                System.out.println("id: " + id);
                statement.close();
                resultSet.close();
                connection.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}