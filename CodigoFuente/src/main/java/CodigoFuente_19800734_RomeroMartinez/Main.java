package CodigoFuente_19800734_RomeroMartinez;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Sistema por defecto (no borrar)
        Sistema_19800734_RomeroMartinez sistema = new Sistema_19800734_RomeroMartinez("Sistema de Error", 1, Arrays.asList(new Chatbot_19800734_RomeroMartinez(1, "Chatbot Error", "Error de escritura.", 1)));
        Menu_19800734_RomeroMartinez menu = new Menu_19800734_RomeroMartinez(sistema);
        menu.mostrarMenu();
    }
}