package CodigoFuente_19800734_RomeroMartinez;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public interface SistemaInterface_19800734_RomeroMartinez {

    String getNombreSistema();
    Date getFechaCreacion();
    String getUsuarioActual();
    int getInitialChatbotCodeLink();
    List<Chatbot_19800734_RomeroMartinez> getChatbots();
    List<User_19800734_RomeroMartinez> getUsuarios();
    User_19800734_RomeroMartinez getUsuarioAdministrador();
    List<Chatbot_19800734_RomeroMartinez> getAllChatbots();

    void setUsuarioActual(String usuarioActual);
    void addChatbot(Chatbot_19800734_RomeroMartinez newChatbot);
    void addChatbotIfIdMatches(Chatbot_19800734_RomeroMartinez chatbot);
    void sistema_synthesis(User_19800734_RomeroMartinez user, Chatbot_19800734_RomeroMartinez chatbot);

    void register(String NombreUsuario);
    void addUsuarioAdmin(String nuevoUsuarioAdmin, UserRole role);
    void login(String usuario);
    void logout();

    // Método para obtener una lista de usuarios a partir de una lista de nombres de usuario y un rol
    default List<User_19800734_RomeroMartinez> getUsuarios(List<String> nombresUsuarios, UserRole role) {
        List<User_19800734_RomeroMartinez> usuarios = new ArrayList<>();
        for (String nombreUsuario : nombresUsuarios) {
            usuarios.add(new User_19800734_RomeroMartinez(nombreUsuario, role, usuarios));
        }
        return usuarios;
    }

    // Método para añadir un usuario a la lista verificando que no exista previamente
    default List<User_19800734_RomeroMartinez> addUsuario(String nuevoUsuario, List<User_19800734_RomeroMartinez> usuarios) {
        usuarios.add(new User_19800734_RomeroMartinez(nuevoUsuario, usuarios));
        return usuarios;
    }

    // Método para añadir un usuario administrador a la lista verificando que no exista previamente
    default List<User_19800734_RomeroMartinez> addUsuarioAdmin(String nuevoUsuario, List<User_19800734_RomeroMartinez> usuarios) {
        usuarios.add(new User_19800734_RomeroMartinez(nuevoUsuario, UserRole.ADMINISTRATOR, usuarios));
        return usuarios;
    }
}
