package CodigoFuente_19800734_RomeroMartinez;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sistema_19800734_RomeroMartinez implements SistemaInterface_19800734_RomeroMartinez{

    private String nombreSistema;
    private Date fechaCreacion;
    private List<String> usuarios;
    private String usuarioActual;
    private int initialChatbotCodeLink;
    private List<Chatbot_19800734_RomeroMartinez> chatbots;

    // Constructor
    public Sistema_19800734_RomeroMartinez(String nombreSistema, int initialChatbotCodeLink, List<Chatbot_19800734_RomeroMartinez> chatbots) {
        this.nombreSistema = nombreSistema;
        this.fechaCreacion = new Date();
        this.usuarios = new ArrayList<>();
        this.usuarioActual = null;
        this.initialChatbotCodeLink = initialChatbotCodeLink;
        this.chatbots = new ArrayList<>(chatbots);

        // Asignar el initialChatbotCodeLink al chatbotId del primer chatbot en la lista
        if (!chatbots.isEmpty()) {
            chatbots.get(0).setChatbotId(initialChatbotCodeLink);
        }
    }

    // Métodos para registro, inicio de sesión y cierre de sesión de usuarios
    public void register(String NombreUsuario) {
        if (!usuarios.contains(NombreUsuario.toUpperCase())) {
            usuarios.add(NombreUsuario.toUpperCase());
            System.out.println("Usuario registrado con exito!");
        } else {
            System.out.println("El usuario " + NombreUsuario + " ya se encuentra registrado");
        }
    }
    public void addUsuarioAdmin(String nuevoUsuarioAdmin, UserRole role) {
        if (!usuarios.contains(nuevoUsuarioAdmin.toUpperCase())) {
            usuarios.add(nuevoUsuarioAdmin.toUpperCase());
            System.out.println("Usuario administrador registrado con éxito!");
        } else {
            System.out.println("El usuario " + nuevoUsuarioAdmin + " ya se encuentra registrado");
        }
    }
    public void login(String usuario) {
        if (getUsuarioActual() != null) {
            System.out.println("Ya se encuentra un usuario registrado.");
        } else {
            if (usuarios.contains(usuario.toUpperCase())) {
                setUsuarioActual(usuario.toUpperCase());
                System.out.println("Usuario logeado con exito!");
            } else {
                System.out.println("Usuario no registrado.");
            }

        }
    }
    public void logout() {
        if (getUsuarioActual() == null) {
            System.out.println("No se encuentra ningún usuario logeado.");
        } else {
            setUsuarioActual(null);
            System.out.println("Usuario deslogeado con exito!");
        }
    }
    // Getters y setters
    public String getNombreSistema() {
        return nombreSistema;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /*public List<String> getUsuarios() {
        return usuarios;
    }*/

    public void setUsuarioActual(String usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    public String getUsuarioActual() {
        return usuarioActual;
    }

    public int getInitialChatbotCodeLink() {
        return initialChatbotCodeLink;
    }

    public List<Chatbot_19800734_RomeroMartinez> getChatbots() {
        return new ArrayList<>(chatbots);
    }

    // Método para agregar un nuevo chatbot al sistema
    public void addChatbot(Chatbot_19800734_RomeroMartinez newChatbot) {
        if (newChatbot.getChatbotId() == initialChatbotCodeLink) {
            chatbots.add(newChatbot);
            System.out.println("Chatbot agregado al sistema con éxito!");
        } else {
            System.out.println("Error: El ChatbotId no coincide con el InitialChatbotCodeLink del sistema.");
        }
    }
    public List<Chatbot_19800734_RomeroMartinez> getAllChatbots() {
        return new ArrayList<>(chatbots);
    }


    // Método en la clase Sistema
    public List<User_19800734_RomeroMartinez> getUsuarios() {
        List<User_19800734_RomeroMartinez> listaUsuarios = new ArrayList<>();

        // Convertir las cadenas a objetos User y agregarlos a la lista
        for (String nombreUsuario : usuarios) {
            listaUsuarios.add(new User_19800734_RomeroMartinez(nombreUsuario, UserRole.NORMAL, listaUsuarios));
        }

        // Devuelve la lista de usuarios
        return listaUsuarios;
    }
    public User_19800734_RomeroMartinez getUsuarioAdministrador() {
        String usuarioActual = getUsuarioActual();
        List<User_19800734_RomeroMartinez> usuarios = getUsuarios();
        for (User_19800734_RomeroMartinez user : usuarios) {
            if (user.getNombreUsuario().equals(usuarioActual) && user.getRole() == UserRole.ADMINISTRATOR) {
                return user;
            }
        }
        return null;
    }

    // Método para agregar un chatbot al sistema solo si el ID coincide
    public void addChatbotIfIdMatches(Chatbot_19800734_RomeroMartinez chatbot) {
        if (chatbot.getChatbotId() == initialChatbotCodeLink) {
            chatbots.add(chatbot);
            System.out.println("Chatbot agregado al sistema.");
        } else {
            System.out.println("Error: El ID del chatbot no coincide con el ID del sistema.");
        }
    }


    // Método para ofrecer una síntesis del chatbot para un usuario particular
    public void sistema_synthesis(User_19800734_RomeroMartinez user, Chatbot_19800734_RomeroMartinez chatbot) {
        if (user == null || chatbot == null) {
            System.out.println("Error: Usuario o Chatbot no válido.");
            return;
        }

        // Verificar que el usuario actual sea un administrador
        if (user.getRole() != UserRole.ADMINISTRATOR) {
            System.out.println("Error: Este método solo está disponible para usuarios administradores.");
            return;
        }

        // Obtener el historial de chat del chatbot
        List<ChatMessage> chatHistory = chatbot.getChatHistory();

        // Imprimir la síntesis del chatbot para el usuario administrador
        System.out.println("Síntesis del chatbot para el usuario administrador:");
        for (ChatMessage message : chatHistory) {
            System.out.println(message);
        }
    }

    // Método para obtener el historial de chat del sistema
    private List<ChatMessage> obtenerChatHistory() {
        // Ejemplo:
        List<ChatMessage> chatHistory = new ArrayList<>();
        return chatHistory;
    }

    public static void main(String[] args) {
        // Ejemplo de uso para el Sistema
        Chatbot_19800734_RomeroMartinez chatbot1 = new Chatbot_19800734_RomeroMartinez(101, "Chatbot1", "¡Hola! Soy un chatbot.", 101);
        Chatbot_19800734_RomeroMartinez chatbot2 = new Chatbot_19800734_RomeroMartinez(201, "Chatbot2", "Saludos. Soy otro chatbot.", 201);

        // Creación de flujos y opciones para el Chatbot1
        Flow_19800734_RomeroMartinez flow1Chatbot1 = new Flow_19800734_RomeroMartinez(101, "Flujo de inicio para Chatbot1");
        Option_19800734_RomeroMartinez option1Chatbot1 = new Option_19800734_RomeroMartinez(1, "Opción 1", 1, 101, List.of("keyword1", "keyword2"));
        Option_19800734_RomeroMartinez option2Chatbot1 = new Option_19800734_RomeroMartinez(2, "Opción 2", 1, 101, List.of("keyword3", "keyword4"));
        flow1Chatbot1.addOption(option1Chatbot1);
        flow1Chatbot1.addOption(option2Chatbot1);

        Flow_19800734_RomeroMartinez flow2Chatbot1 = new Flow_19800734_RomeroMartinez(102, "Otro flujo para Chatbot1");
        Option_19800734_RomeroMartinez option3Chatbot1 = new Option_19800734_RomeroMartinez(3, "Opción 3", 1, 102, List.of("keyword5", "keyword6"));
        flow2Chatbot1.addOption(option3Chatbot1);

        // Añadir flujos al Chatbot1
        chatbot1.addFlow(flow1Chatbot1);
        chatbot1.addFlow(flow2Chatbot1);

        // Creación de flujos y opciones para el Chatbot2
        Flow_19800734_RomeroMartinez flow1Chatbot2 = new Flow_19800734_RomeroMartinez(201, "Flujo de inicio para Chatbot2");
        Option_19800734_RomeroMartinez option1Chatbot2 = new Option_19800734_RomeroMartinez(1, "Opción 1", 2, 201, List.of("keyword7", "keyword8"));
        flow1Chatbot2.addOption(option1Chatbot2);

        // Añadir flujos al Chatbot2
        chatbot2.addFlow(flow1Chatbot2);

        // Lista de chatbots
        List<Chatbot_19800734_RomeroMartinez> chatbots = List.of(chatbot1, chatbot2);

        // Crear el sistema
        Sistema_19800734_RomeroMartinez sistema = new Sistema_19800734_RomeroMartinez("Sistema de Chatbots", 101, chatbots);

        // Accediendo a los detalles del sistema y chatbots
        System.out.println("Detalles del Sistema:");
        System.out.println("Nombre del Sistema: " + sistema.getNombreSistema());
        System.out.println("Fecha de Creación: " + sistema.getFechaCreacion());
        System.out.println("InitialChatbotCodeLink: " + sistema.getInitialChatbotCodeLink());

        System.out.println("Chatbots en el Sistema:");
        for (Chatbot_19800734_RomeroMartinez chatbot : sistema.getChatbots()) {
            System.out.println("  ID del Chatbot: " + chatbot.getChatbotId());
            System.out.println("  Nombre del Chatbot: " + chatbot.getNombre());

            // Accediendo a los detalles de los flujos y opciones del chatbot
            for (Flow_19800734_RomeroMartinez flow : chatbot.getFlows()) {
                System.out.println("    ID del Flujo: " + flow.getId());
                System.out.println("    Mensaje del Flujo: " + flow.getMsg());
                System.out.println("    Opciones:");
                for (Option_19800734_RomeroMartinez option : flow.getOptions()) {
                    System.out.println("      Codigo: " + option.getCodigo());
                    System.out.println("      Mensaje: " + option.getMensaje());
                    System.out.println("      ChatbotCodeLink: " + option.getChatbotCodeLink());
                    System.out.println("      InitialFlowCodeLink: " + option.getInitialFlowCodeLink());
                    System.out.println("      Keywords: " + option.getKeywords());
                    System.out.println("      ---------------");
                }
                System.out.println("    ---------------");
            }

            System.out.println("  ---------------");
        }
        System.out.println("---------------");
    }
}
