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

    /**
     *
     * Constructor del sistema
     * @param nombreSistema
     * @param initialChatbotCodeLink
     * @param chatbots
     */
    public Sistema_19800734_RomeroMartinez(String nombreSistema, int initialChatbotCodeLink, List<Chatbot_19800734_RomeroMartinez> chatbots) {
        this.nombreSistema = nombreSistema;
        this.fechaCreacion = new Date();
        this.usuarios = new ArrayList<>();
        this.usuarioActual = null;
        this.initialChatbotCodeLink = initialChatbotCodeLink;
        this.chatbots = new ArrayList<>(chatbots);
        if (!chatbots.isEmpty()) {
            chatbots.get(0).setChatbotId(initialChatbotCodeLink);
        }
    }
    /**
     *
     * Registra a un usuario en el sistema, si el usuario ya existe entrega un mensaje de error.
     * @param NombreUsuario
     */
    public void register(String NombreUsuario) {
        if (!usuarios.contains(NombreUsuario.toUpperCase())) {
            usuarios.add(NombreUsuario.toUpperCase());
            System.out.println("Usuario registrado con exito!");
        } else {
            System.out.println("El usuario " + NombreUsuario + " ya se encuentra registrado");
        }
    }
    /**
     *
     * Registra a un usuario Administrador en el sistema, si el usuario admministrador existe entrega un mensaje de error.
     * @param nuevoUsuarioAdmin
     * @param role
     */
    public void addUsuarioAdmin(String nuevoUsuarioAdmin, UserRole role) {
        if (!usuarios.contains(nuevoUsuarioAdmin.toUpperCase())) {
            usuarios.add(nuevoUsuarioAdmin.toUpperCase());
            System.out.println("Usuario administrador registrado con éxito!");
        } else {
            System.out.println("El usuario " + nuevoUsuarioAdmin + " ya se encuentra registrado");
        }
    }
    /**
     * Metodo que permite al usuario iniciar sesion, para ello se necesita estar registrado, lanzara un error en caso de que no se encuentre en el sistema.
     * @param usuario
     */
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
    /**
     *  Deslogea un usuario de un sistema, si no existe ningun usuario logeado devuelve mensaje de error.
     */
    public void logout() {
        if (getUsuarioActual() == null) {
            System.out.println("No se encuentra ningún usuario logeado.");
        } else {
            setUsuarioActual(null);
            System.out.println("Usuario deslogeado con exito!");
        }
    }
    /**
     * Metodo selector para obtener un nombre del sistema.
     * @return devuelve el nombre del sistema.
     */
    public String getNombreSistema() {
        return nombreSistema;
    }
    /**
     * Metodo fecha para obtener la fecha de creacion del sistema.
     * @return devuelve la fecha de creacion del sistema.
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Metodo para obtener el usuario actual logeado del sistema
     * @return devuelve el usuarioActual del sistema
     */
    public String getUsuarioActual() {
        return usuarioActual;
    }
    /**
     * Metodo para obtener el InitialChatbotCodeLink del sistema
     * @return devuelve el InitialChatbotCodeLink localizado por el sistema
     */
    public int getInitialChatbotCodeLink() {
        return initialChatbotCodeLink;
    }
    /**
     * Metodo para obtener una listas de chatbots que estan dentro del sistema
     * @return devuelve un lista de chatbots
     */
    public List<Chatbot_19800734_RomeroMartinez> getChatbots() {
        return new ArrayList<>(chatbots);
    }
    /**
     * Metodo para modificar el usuario actual logeado del sistema
     * @param usuarioActual
     */
    public void setUsuarioActual(String usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    /**
     * Metodo para modifica el nombre de un sistema
     * @param NombreSistema
     */
    public void setNombreSistema(String NombreSistema){
        this.nombreSistema = nombreSistema;
    }

    /**
     * Metodo que modifica el initialchatbotcodelink del sistema
     * @param initialChatbotCodeLink
     */
    public void setInitialChatbotCodeLink(int initialChatbotCodeLink){
        this.initialChatbotCodeLink = initialChatbotCodeLink;
    }
    /**
     * Metodo para modificar la lista de chatbos de un sistema
     * @param nuevosChatbots
     */
    public void setChatbots(List<Chatbot_19800734_RomeroMartinez> nuevosChatbots){
        this.chatbots = new ArrayList<>(nuevosChatbots);
    }
    /**
     * Metodo para anadir un nuevo chatbot al sistema, con su respectiva restriccion de ID con respecto al InitialChatbotCodeLink
     * @param newChatbot
     */
    public void addChatbot(Chatbot_19800734_RomeroMartinez newChatbot) {
        if (newChatbot.getChatbotId() == initialChatbotCodeLink) {
            chatbots.add(newChatbot);
            System.out.println("Chatbot agregado al sistema con éxito!");
        } else {
            System.out.println("Error: El ChatbotId no coincide con el InitialChatbotCodeLink del sistema.");
        }
    }
    /**
     * Metodo que devuelve todos los chatbots dentro de una nueva lista
     * @return devuelve la lista de chatbots
     */
    public List<Chatbot_19800734_RomeroMartinez> getAllChatbots() {
        return new ArrayList<>(chatbots);
    }
    /**
     * Metodo que obtiene a los usuarios dentro del sistema, siempre y cuando esten registrados y tambien por Rol (NORMAL)
     * @return devuelve a los usuarios en una lista
     */
    public List<User_19800734_RomeroMartinez> getUsuarios() {
        List<User_19800734_RomeroMartinez> listaUsuarios = new ArrayList<>();
        for (String nombreUsuario : usuarios) {
            listaUsuarios.add(new User_19800734_RomeroMartinez(nombreUsuario, UserRole.NORMAL, listaUsuarios));
        }
        return listaUsuarios;
    }
    /**
     * Metodo que obtiene a los usuarios dentro del sistema, siempre y cuando esten registrados y tambien por Rol (ADMINISTRADOR)
     * @return devuelve a los usuarios en una lista
     */
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
    /**
     * Metodo para agregar un chatbot al sistema solo si el ID coincide (complementario)
     * @param chatbot
     */
    public void addChatbotIfIdMatches(Chatbot_19800734_RomeroMartinez chatbot) {
        if (chatbot.getChatbotId() == initialChatbotCodeLink) {
            chatbots.add(chatbot);
            System.out.println("Chatbot agregado al sistema.");
        } else {
            System.out.println("Error: El ID del chatbot no coincide con el ID del sistema.");
        }
    }

}
