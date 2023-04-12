package l20j45.platzi.DAO;

import l20j45.platzi.Conection;
import l20j45.platzi.model.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public static ArrayList<Message> leerMensajesDb() {
        ArrayList<Message> messages = new ArrayList<Message>();
        try (Connection conection = Conection.getConnection()) {

            PreparedStatement ps = null;
            ResultSet rs = null;

            try {
                String query = "Select * from mensajes";
                ps = conection.prepareStatement(query);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Message message = new Message(rs.getString("id_mensaje"), rs.getString("mensaje"), rs.getString("autor_mensaje"), rs.getString("fecha_mensaje"));
                    messages.add(message);
                }


            } catch (SQLException ex) {
                System.out.println("there`re no messages to show");
                System.out.println(ex);
            }

        } catch (SQLException e) {
            System.out.println("unable to connect to the server");
            System.out.println(e);
        }
        return messages;
    }

    public static void borrarMensajeDb(int id_mensaje) {

        try (Connection conection = Conection.getConnection()) {

            PreparedStatement ps = null;

            try {
                String query = "Delete from mensajes where id_mensaje = ?";
                ps = conection.prepareStatement(query);
                ps.setString(1, String.valueOf(id_mensaje));
                int countRowsUpdated = ps.executeUpdate();
                if (countRowsUpdated != 0) {
                    System.out.println("has been deleted successfully.");
                } else {
                    System.out.println("was not found.");
                }
                System.out.println("mensaje borrado");
            } catch (SQLException ex) {
                System.out.println(ex);
            }

        } catch (SQLException e) {
            System.out.println(e);

        }

    }

    public static void editarMensajeDb() {

    }
}
