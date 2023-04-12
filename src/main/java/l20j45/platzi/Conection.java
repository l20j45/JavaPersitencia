package l20j45.platzi;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection {
    Conection(){

    }


    //variable que almacena el estado de la conexion de la base de datos
    private static Connection connection;

    //variable para crear una sola instancia
    private static Conection instancia;

    //variables de la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/mensajes_app";
    private static final String USERNAME = "l20j45";
    private static final String PASSWORD = "Pickner12.";

    public static Connection getConnection(){

        try {

            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);



            return connection;

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro: " + e);
            System.exit(0);
        }

        return connection;

    }


    public void closeConnetion () throws SQLException{

        try {
            connection.close();
            JOptionPane.showMessageDialog(null,"DESCONEXIÓN");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro: " + e);
            connection.close();
        } finally {
            connection.close();
        }
    }

/*    public static Connection getConnection() {
        if (connection != null) return connection;

        try {
            String url = "jdbc:mysql://localhost:3306/";
            String database = "mensajes_app";
            String user = "l20j45";
            String pass = "Pickner12.";

            // Si el programa se cierra se ejecuta getClose
            Runtime.getRuntime().addShutdownHook(new getClose());
            connection = DriverManager
                    .getConnection(url.concat(database), user, pass);

            return connection;

        } catch (SQLException e) {
            throw new RuntimeException("Error al conectarse a la DB %s", e);
        }
    }

    static class getClose extends Thread {
        @Override
        public void run() {
            try {
                Connection connection = Conection.getConnection();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }*/

/*    public Connection get_connection() {
        Connection conection = null;
        try {
            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app", "l20j45", "Pickner12.");

            if (conection != null) {

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conection;
    }*/


}