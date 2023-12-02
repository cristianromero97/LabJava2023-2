package CodigoFuente_19800734_RomeroMartinez;
import java.util.List;
import java.util.ArrayList;

public interface UserInterface_19800734_RomeroMartinez {

    /**
     * Metodo de interface para obtener el nombre de usuario
     * @return devuelve el nombre de usuario
     */
    String getNombreUsuario();

    /**
     * Metodo de interface para obtener el rol del usuario
     * @return devuelve normal o administrador (roles) del usuario
     */
    UserRole getRole();

    /**
     * Metodo de interface para cambiar el nombre del usuario
     * @param nuevoNombre
     */
    void setNombreUsuario(String nuevoNombre);

    /**
     * Metodo de interface para cambiar el rol del usuario
     * @param role
     */
    void setRole(UserRole role);
    /**
     * Metodo para obtener una lista de usuarios a partir de una lista de nombres de usuario y un rol
     * @param nombresUsuarios
     * @param role
     * @return devuelvve una lista de usuarios
     */
    static List<User_19800734_RomeroMartinez> getUsuarios(List<String> nombresUsuarios, UserRole role) {
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
     * @return devuelve al usuario añadido verificando existencia
     */
    static List<User_19800734_RomeroMartinez> addUsuario(String nuevoUsuario, List<User_19800734_RomeroMartinez> usuarios) {
        usuarios.add(new User_19800734_RomeroMartinez(nuevoUsuario, usuarios));
        return usuarios;
    }

    /**
     * Metodo para anadir un usuario administrador a la lista verificando que no exista previamente
     * @param nuevoUsuario
     * @param usuarios
     * @return devuelve al usuario adminitrador verificando existencia
     */
    static List<User_19800734_RomeroMartinez> addUsuarioAdmin(String nuevoUsuario, List<User_19800734_RomeroMartinez> usuarios) {
        usuarios.add(new User_19800734_RomeroMartinez(nuevoUsuario, UserRole.ADMINISTRATOR, usuarios));
        return usuarios;
    }
}
