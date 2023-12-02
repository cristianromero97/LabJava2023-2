package CodigoFuente_19800734_RomeroMartinez;
import java.util.List;
import java.util.ArrayList;

public interface UserInterface_19800734_RomeroMartinez {

    String getNombreUsuario();

    UserRole getRole();

    void setNombreUsuario(String nuevoNombre);
    
    void setRole(UserRole role);

    // Método para obtener una lista de usuarios a partir de una lista de nombres de usuario y un rol
    static List<User_19800734_RomeroMartinez> getUsuarios(List<String> nombresUsuarios, UserRole role) {
        List<User_19800734_RomeroMartinez> usuarios = new ArrayList<>();
        for (String nombreUsuario : nombresUsuarios) {
            usuarios.add(new User_19800734_RomeroMartinez(nombreUsuario, role, usuarios));
        }
        return usuarios;
    }

    // Método para añadir un usuario a la lista verificando que no exista previamente
    static List<User_19800734_RomeroMartinez> addUsuario(String nuevoUsuario, List<User_19800734_RomeroMartinez> usuarios) {
        usuarios.add(new User_19800734_RomeroMartinez(nuevoUsuario, usuarios));
        return usuarios;
    }

    // Método para añadir un usuario administrador a la lista verificando que no exista previamente
    static List<User_19800734_RomeroMartinez> addUsuarioAdmin(String nuevoUsuario, List<User_19800734_RomeroMartinez> usuarios) {
        usuarios.add(new User_19800734_RomeroMartinez(nuevoUsuario, UserRole.ADMINISTRATOR, usuarios));
        return usuarios;
    }
}
