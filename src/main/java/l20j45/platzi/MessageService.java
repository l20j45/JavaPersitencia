package l20j45.platzi;

import java.util.Scanner;

public class MessageService {

    public static void createMessage(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();
        System.out.println("Escribe tu nombre");
        String nombre = sc.nextLine();
        Message registro = new Message(mensaje,nombre);
        System.out.println(registro);
        MessageDAO.crearMensajeDb(registro);

    };
    public static void listarMessage(){};
    public static void borrarMessage(){};
    public static void editarMessage(){};

}
