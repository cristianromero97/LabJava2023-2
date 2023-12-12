package CodigoFuente_19800734_RomeroMartinez;

import java.util.Arrays;
import java.lang.String;

public class Main {
    public static void main(String[] args) {
        //Sistema por defecto (no borrar)
        Sistema_19800734_RomeroMartinez sistema = new Sistema_19800734_RomeroMartinez("Sistema de Error", 1, Arrays.asList(new Chatbot_19800734_RomeroMartinez(1, "Chatbot Error", "Error de escritura.", 1,Arrays.asList(new Flow_19800734_RomeroMartinez(1,"flujo error",Arrays.asList(new Option_19800734_RomeroMartinez(2,"opcion error",1,1,Arrays.asList("error","fallos"))))))));
        Menu_19800734_RomeroMartinez menu = new Menu_19800734_RomeroMartinez(sistema);
        menu.mostrarMenu();
    }
}