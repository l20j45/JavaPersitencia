package l20j45.platzi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection {
    private static Connection connection = null;

    public static Connection getConnection() {
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
    }

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
