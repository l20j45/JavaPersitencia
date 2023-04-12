package l20j45.platzi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public Connection get_connection() {
        Connection conection = null;
        try {
            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app", "l20j45", "Pickner12.");

            if (conection != null) {

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conection;
    }

    ;

}
