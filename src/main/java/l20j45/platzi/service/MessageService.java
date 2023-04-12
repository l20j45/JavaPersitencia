package l20j45.platzi.service;

import l20j45.platzi.DAO.MessageDAO;
import l20j45.platzi.model.Message;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MessageService {

    public static void createMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();
        System.out.println("Escribe tu nombre");
        String nombre = sc.nextLine();
        Message registro = new Message(mensaje, nombre);
        System.out.println(registro);
        MessageDAO.crearMensajeDb(registro);

    }



    public static void listarMessage() throws SQLException {
        System.out.println("---------------------------------");
        ArrayList<Message> messages = MessageDAO.leerMensajesDb();
        if (messages.size() > 0) {
            for (Message message : messages) {
                System.out.print("id: " + message.getId_mensaje() + "|");
                System.out.print(" Message: " + message.getMensaje() + "|");
                System.out.print(" Author: " + message.getAutor_mensaje() + "|");
                System.out.print(" Date: " + message.getFecha_mensaje());
                System.out.println();
            }
        }
        else {
            System.out.println("No hay registros");
        }
    }


    public static void borrarMessage() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el codigo a borrar");
        int codigo = sc.nextInt();
        MessageDAO.borrarMensajeDb(codigo);

    }



    public static void editarMessage() {
    }



}
