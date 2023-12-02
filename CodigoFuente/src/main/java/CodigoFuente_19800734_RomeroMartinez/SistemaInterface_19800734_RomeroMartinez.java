package CodigoFuente_19800734_RomeroMartinez;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public interface SistemaInterface_19800734_RomeroMartinez {

    /**
     * Metodo de interface para obtener el nombre del sistema
     * @return devuelve el nombre del sistema
     */
    String getNombreSistema();

    /**
     * Metodo de interface para obtener la fecha de creacion del sistema
     * @return devuelve la fecha de creacion del mismo
     */
    Date getFechaCreacion();

    /**
     * Metodo de interface para obtener al usuario logeado dentro del sistema
     * @return devuelve al usuario actualmente logeado
     */
    String getUsuarioActual();

    /**
     * Metodo de interface para obtener el chatbotcodelink del sistema
     * @return devuelve el chatbotcodelink
     */
    int getInitialChatbotCodeLink();

    /**
     * Metodo de interface que obtiene la lista de chatbots dentro del sistema
     * @return devuelve los chatbots en una lista
     */
    List<Chatbot_19800734_RomeroMartinez> getChatbots();

    /**
     * Metodo de interface que obtiene a una lista de usuarios registrados en el sistema
     * @return devuelve la lista de usuarios
     */
    List<User_19800734_RomeroMartinez> getUsuarios();

    /**
     * Metodo de interface para obtener a los usarios tipo administrador dentro del sistema
     * @return devuelve la lista de usuarios administradores
     */
    User_19800734_RomeroMartinez getUsuarioAdministrador();

    /**
     * Metodo de interface para obtener todos los chatbots dentro del sistema
     * @return devuelve una lista con todos los chatbots
     */
    List<Chatbot_19800734_RomeroMartinez> getAllChatbots();

    /**
     * Metodo de interface para modificar al usuario actual del sistema
     * @param usuarioActual
     */
    void setUsuarioActual(String usuarioActual);

    /**
     * Metodo interface para modificar el nombre del sistema
     * @param NombreSistema
     */
    void setNombreSistema(String NombreSistema);

    /**
     * Metodo interface para modificar el initialchatbotcodelink del sistema
     * @param initialChatbotCodeLink
     */
    void setInitialChatbotCodeLink(int initialChatbotCodeLink);

    /**
     * Metodo para modificar los chatbots de un sistema
     * @param nuevosChatbots
     */
    void  setChatbots(List<Chatbot_19800734_RomeroMartinez> nuevosChatbots);

    /**
     * Metodo de interface para anadir a un nuevo chatbot al sistema
     * @param newChatbot
     */
    void addChatbot(Chatbot_19800734_RomeroMartinez newChatbot);

    /**
     * Metodo de interface para anadir chatbots segun ID
     * @param chatbot
     */
    void addChatbotIfIdMatches(Chatbot_19800734_RomeroMartinez chatbot);

    /**
     * Metodo de interface pora registrar usuarios dentro del sistema (system-add-user)
     * @param NombreUsuario
     */
    void register(String NombreUsuario);

    /**
     * Metodo de interface para registrar usuarios adminitradores dentro del sistema
     * @param nuevoUsuarioAdmin
     * @param role
     */
    void addUsuarioAdmin(String nuevoUsuarioAdmin, UserRole role);

    /**
     * Metodo de interface para iniciar sesion dentro del sistema
     * @param usuario
     */
    void login(String usuario);

    /**
     * Metodo de interface para cerra sesion dentro del sistema
     */
    void logout();

    //METODOS AUXILIARES
    /**
     * Metodo para obtener una lista de usuarios a partir de una lista de nombres de usuario y un rol
     * @param nombresUsuarios
     * @param role
     * @return devuelve una lista de usuarios verificados
     */
    default List<User_19800734_RomeroMartinez> getUsuarios(List<String> nombresUsuarios, UserRole role) {
        List<User_19800734_RomeroMartinez> usuarios = new ArrayList<>();
        for (String nombreUsuario : nombresUsuarios) {
            usuarios.add(new User_19800734_RomeroMartinez(nombreUsuario, role, usuarios));
        }
        return usuarios;
    }

    /**
     * Metodo para anadir un usuario a la lista verificando que no exista previamente
     * @param nuevoUsuario
     * @param usuarios
     * @return devuelve al usuario añadido verificado (una lista)
     */
    default List<User_19800734_RomeroMartinez> addUsuario(String nuevoUsuario, List<User_19800734_RomeroMartinez> usuarios) {
        usuarios.add(new User_19800734_RomeroMartinez(nuevoUsuario, usuarios));
        return usuarios;
    }

    /**
     * Metodo para anadir un usuario administrador a la lista verificando que no exista previamente
     * @param nuevoUsuario
     * @param usuarios
     * @return devuelve al usuario administrador añadido verificado (una lista)
     */
    default List<User_19800734_RomeroMartinez> addUsuarioAdmin(String nuevoUsuario, List<User_19800734_RomeroMartinez> usuarios) {
        usuarios.add(new User_19800734_RomeroMartinez(nuevoUsuario, UserRole.ADMINISTRATOR, usuarios));
        return usuarios;
    }
}
