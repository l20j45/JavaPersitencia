package l20j45.platzi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MessageDAO {

    public static void crearMensajeDb(Message message) {

        try (Connection conection = Conection.getConnection()) {

            PreparedStatement ps = null;

            try {
                String query = "INSERT INTO `mensajes_app`.`mensajes` (`mensaje`, `autor_mensaje`) VALUES (?, ?);";
                ps = conection.prepareStatement(query);
                ps.setString(1, message.getMensaje());
                ps.setString(2, message.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("mensaje creado");
            } catch (SQLException ex) {
                System.out.println(ex);
            }

        } catch (SQLException e) {
            System.out.println(e);

        }
    }

    public static void leerMensajesDb() {

    }

    public static void borrarMensajeDb(int id_mensaje) {

    }

    public static void editarMensajeDb() {

    }
}
