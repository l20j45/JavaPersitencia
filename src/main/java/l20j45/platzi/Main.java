package l20j45.platzi;

import com.mysql.cj.protocol.MessageSender;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Conexion conexion = new Conexion();

        Scanner sc = new Scanner(System.in);

        int option = 0;

        try (Connection cnx = conexion.get_connection()) {

            do {
                System.out.println("---------------------");
                System.out.println("Aplicacion de mensajes");
                System.out.println("1.- crear mensaje");
                System.out.println("2.- listar mensajes");
                System.out.println("3.- editar mensaje");
                System.out.println("4.- eliminar mensaje");
                System.out.println("5.- salir del menu");

                option = sc.nextInt();


                switch (option) {
                    case 1:
                        MessageService.createMessage();
                        break;
                    case 2:
                        MessageService.listarMessage();
                        break;
                    case 3:
                        MessageService.editarMessage();
                        break;
                    case 4:
                        MessageService.borrarMessage();
                        break;
                    case 5:
                        System.out.println("estoy saliendo");
                        break;
                    default:
                        break;
                }
            } while (option != 5);

            System.out.println("salir");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}