package CodigoFuente_19800734_RomeroMartinez;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDateTime;
import java.util.Random;

public class Sistema_19800734_RomeroMartinez implements SistemaInterface_19800734_RomeroMartinez {

    private String nombreSistema;
    private Date fechaCreacion;
    private List<String> usuarios;
    private String usuarioActual;
    private int initialChatbotCodeLink;
    private List<Chatbot_19800734_RomeroMartinez> chatbots;

    private List<Historial_19800734_RomeroMartinez> historialGlobal = new ArrayList<>();

    /**
     * Constructor del sistema, metodo que recibe un nombre, un initialchatbotcodelink y una lista de chatbots para crear un sistema
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
        this.historialGlobal = new ArrayList<>();
    }

    /**
     * Registra a un usuario en el sistema, si el usuario ya existe entrega un mensaje de error.
     *
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
     * Registra a un usuario Administrador en el sistema, si el usuario admministrador existe entrega un mensaje de error.
     *
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
     *
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
     * Deslogea un usuario de un sistema, si no existe ningun usuario logeado devuelve mensaje de error.
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
     *
     * @return devuelve el nombre del sistema.
     */
    public String getNombreSistema() {
        return nombreSistema;
    }

    /**
     * Metodo fecha para obtener la fecha de creacion del sistema.
     *
     * @return devuelve la fecha de creacion del sistema.
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Metodo para obtener el usuario actual logeado del sistema
     *
     * @return devuelve el usuarioActual del sistema
     */
    public String getUsuarioActual() {
        return usuarioActual;
    }

    /**
     * Metodo para obtener el InitialChatbotCodeLink del sistema
     *
     * @return devuelve el InitialChatbotCodeLink localizado por el sistema
     */
    public int getInitialChatbotCodeLink() {
        return initialChatbotCodeLink;
    }

    /**
     * Metodo para obtener una listas de chatbots que estan dentro del sistema
     *
     * @return devuelve un lista de chatbots
     */
    public List<Chatbot_19800734_RomeroMartinez> getChatbots() {
        return new ArrayList<>(chatbots);
    }

    /**
     * Metodo para modificar el usuario actual logeado del sistema
     *
     * @param usuarioActual
     */
    public void setUsuarioActual(String usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    /**
     * Metodo para modifica el nombre de un sistema
     *
     * @param NombreSistema
     */
    public void setNombreSistema(String NombreSistema) {
        this.nombreSistema = nombreSistema;
    }

    /**
     * Metodo que modifica el initialchatbotcodelink del sistema
     *
     * @param initialChatbotCodeLink
     */
    public void setInitialChatbotCodeLink(int initialChatbotCodeLink) {
        this.initialChatbotCodeLink = initialChatbotCodeLink;
    }

    /**
     * Metodo para modificar la lista de chatbos de un sistema
     *
     * @param nuevosChatbots
     */
    public void setChatbots(List<Chatbot_19800734_RomeroMartinez> nuevosChatbots) {
        this.chatbots = new ArrayList<>(nuevosChatbots);
    }

    /**
     * Metodo para anadir un nuevo chatbot al sistema, con su respectiva restriccion de ID con respecto al InitialChatbotCodeLink
     *
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
     *
     * @return devuelve la lista de chatbots
     */
    public List<Chatbot_19800734_RomeroMartinez> getAllChatbots() {
        return new ArrayList<>(chatbots);
    }

    /**
     * Metodo que obtiene a los usuarios dentro del sistema, siempre y cuando esten registrados y tambien por Rol (NORMAL)
     *
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
     *
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
     *
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

    /**
     * Metodo de interaccion system talkrec para usuario Administrador, recibe un chatbot y un string y busca coincidencia para interactuar
     *
     * @param chatbot
     * @param keyword
     */
    public void talkRecAdministrador(Chatbot_19800734_RomeroMartinez chatbot, String keyword) {  // hize ese cambio en la entrada para facilitar el manejo de codigo, por alguna razon generaba error y llamaba al sistema de la clase main y no a los creados en menu
        System.out.println("### Estoy buscando alguna coincidencia ###");
        // Mostrar las opciones del chatbot
        List<Flow_19800734_RomeroMartinez> flows = chatbot.getFlows();
        for (Flow_19800734_RomeroMartinez flow : flows) {
            System.out.println("Flujo: " + flow.getId() + " - " + flow.getMsg());
            List<Option_19800734_RomeroMartinez> opciones = flow.getOptions();
            for (Option_19800734_RomeroMartinez opcion : opciones) {
                System.out.println("  Opción " + opcion.getCodigo() + ": " + opcion.getMensaje());
            }
        }
        // Buscar y mostrar mensajes o keywords coincidentes
        for (Flow_19800734_RomeroMartinez flow : flows) {
            List<Option_19800734_RomeroMartinez> opciones = flow.getOptions();
            for (Option_19800734_RomeroMartinez opcion : opciones) {
                if (opcion.getMensaje().equalsIgnoreCase(keyword) || opcion.getKeywords().contains(keyword)) {
                    System.out.println("Coincidencia encontrada en el chatbot " + chatbot.getChatbotId());
                    System.out.println("Mensaje: " + opcion.getMensaje());
                    System.out.println("Keywords: " + opcion.getKeywords());
                    // Registrar la interacción en el historial
                    LocalDateTime timestamp = LocalDateTime.now();
                    Historial_19800734_RomeroMartinez interaccion = new Historial_19800734_RomeroMartinez("administrador",timestamp, flow.getMsg(), opcion.getMensaje(),opcion.getKeywords());
                    agregarAlHistorial(interaccion);
                    System.out.println("Al parecer esto es lo que he encontrado, es bastante interasnte");
                    System.out.println("Es curioso, si necesitas que te responda alguna otra cosa, vuelve a interactuar conmigo");
                    System.out.println("Favor de colocar solo palabras que hayan sido cargadas, me ayudara a facilitar una busqueda y ver como respondo....");
                }
            }
        }
    }

    /**
     * Metodo de interaccion system talkrec para usuario Normal, recibe un chatbot y un string y busca coincidencia para interactua
     * @param mensaje
     * @param chatbots
     */
    public void talkRecNormal(String mensaje, List<Chatbot_19800734_RomeroMartinez> chatbots) { // hize ese cambio en la entrada para facilitar el manejo de codigo, por alguna razon generaba error y llamaba al sistema de la clase main y no a los creados en menu
        boolean opcionEncontrada = false;
        for (Chatbot_19800734_RomeroMartinez chatbot : chatbots) {
            for (Flow_19800734_RomeroMartinez flow : chatbot.getFlows()) {
                for (Option_19800734_RomeroMartinez option : flow.getOptions()) {
                    if (option.getMensaje().equalsIgnoreCase(mensaje) || option.getKeywords().contains(mensaje)) {
                        opcionEncontrada = true;
                        System.out.println("Opción encontrada en el Chatbot: " + chatbot.getNombre());
                        System.out.println("Flujo asociado: " + flow.getMsg());
                        System.out.println("Mensaje de la Opción: " + option.getMensaje());
                        System.out.println("Keywords: " + option.getKeywords());
                        System.out.println("---------------");
                        // Registrar la interacción en el historial
                        LocalDateTime timestamp = LocalDateTime.now();
                        Historial_19800734_RomeroMartinez interaccion = new Historial_19800734_RomeroMartinez("normal",timestamp, flow.getMsg(), option.getMensaje(),option.getKeywords());
                        agregarAlHistorial(interaccion);

                        System.out.println("Al parecer esto es lo que he encontrado, es bastante interasnte");
                        System.out.println("Es curioso, si necesitas que te responda alguna otra cosa, vuelve a interactuar conmigo");
                        System.out.println("Favor de colocar solo palabras que hayan sido cargadas, me ayudara a facilitar una busqueda y ver como respondo....");
                        break;
                    }
                }
                if (opcionEncontrada) {
                    break;
                }
            }
            if (opcionEncontrada) {
                break;
            }
        }
        if (!opcionEncontrada) {
            System.out.println("No se encontró ninguna opción con el mensaje proporcionado.");
        }
    }

    /**
     * Metodo que añade al historial la interaccion
     * @param interaccion
     */
    public void agregarAlHistorial(Historial_19800734_RomeroMartinez interaccion) {
        historialGlobal.add(interaccion);
    }

    /**
     * Metodo auxiliar para obtener el historial global del sistema
     * @return devuelve dicho historial
     */
    public List<Historial_19800734_RomeroMartinez> getHistorialGlobal() {
        return historialGlobal;
    }

    /**
     * Metodo principal para obtener el Historial del Usuario
     * @param nombreUsuario
     * @return devuelve el historial, se complementa con sintesis
     */
    public List<String> obtenerHistorialUsuario(String nombreUsuario) {
        List<String> historialUsuario = new ArrayList<>();
        for (Historial_19800734_RomeroMartinez entrada : historialGlobal) {
            if (entrada.getNombreUsuario().equals(nombreUsuario)) {
                historialUsuario.add(entrada.toString());
            }
        }
        return historialUsuario;
    }

    /**
     * Metodo synthesis, devuelve el historial del usuario, es apoyado por otros metodos y clases
     * @param nombreUsuario
     */
    public void synthesis(String nombreUsuario) {
        List<String> historialUsuario = obtenerHistorialUsuario(nombreUsuario);
        for (String entrada : historialUsuario) {
            System.out.println(entrada);
        }
    }
}