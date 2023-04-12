package l20j45.platzi;

public class Message {
    String autor_mensaje, fecha_mensaje, id_mensaje, mensaje;



    public String getAutor_mensaje() {
        return autor_mensaje;
    }

    public void setAutor_mensaje(String autor_mensaje) {
        this.autor_mensaje = autor_mensaje;
    }

    public String getFecha_mensaje() {
        return fecha_mensaje;
    }

    public void setFecha_mensaje(String fecha_mensaje) {
        this.fecha_mensaje = fecha_mensaje;
    }

    public String getId_mensaje() {
        return id_mensaje;
    }

    public void setId_mensaje(String id_mensaje) {
        this.id_mensaje = id_mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }


    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    //Constructors

    public Message(String autor_mensaje, String fecha_mensaje, String id_mensaje, String mensaje) {
        this.autor_mensaje = autor_mensaje;
        this.fecha_mensaje = fecha_mensaje;
        this.id_mensaje = id_mensaje;
        this.mensaje = mensaje;
    }

    public Message( String mensaje ,String autor_mensaje) {
        this.mensaje = mensaje;
        this.autor_mensaje = autor_mensaje;
    }

    public Message() {
    }

    @Override
    public String toString() {
        return "mensaje: "+getMensaje()+" autor: "+ getAutor_mensaje();
    }
}
