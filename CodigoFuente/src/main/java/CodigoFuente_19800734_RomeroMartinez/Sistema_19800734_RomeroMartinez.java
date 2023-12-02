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

}
