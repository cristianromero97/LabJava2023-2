package CodigoFuente_19800734_RomeroMartinez;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Sistema por defecto (no borrar)
        Sistema_19800734_RomeroMartinez sistema = new Sistema_19800734_RomeroMartinez("Sistema de Chatbots", 101, Arrays.asList(new Chatbot_19800734_RomeroMartinez(101, "Chatbot1", "¡Hola! Soy un chatbot.", 101)));
        Menu_19800734_RomeroMartinez menu = new Menu_19800734_RomeroMartinez(sistema);
        menu.mostrarMenu();
    }
}