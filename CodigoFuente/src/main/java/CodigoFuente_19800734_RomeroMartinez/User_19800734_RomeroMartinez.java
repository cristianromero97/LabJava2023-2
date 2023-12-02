package CodigoFuente_19800734_RomeroMartinez;

import java.util.ArrayList;
import java.util.List;

/**
 * Enumeracion de roles, NORMAL o Administrador
 */
enum UserRole {
    NORMAL, ADMINISTRATOR
}

public class User_19800734_RomeroMartinez implements UserInterface_19800734_RomeroMartinez {

    private String nombreUsuario;
    private UserRole role;

    /**
     * Constructor de usuarios normales con verificacion de duplicados
     * @param nombreUsuario
     * @param usuarios
     */
    public User_19800734_RomeroMartinez(String nombreUsuario, List<User_19800734_RomeroMartinez> usuarios) {
        if (usuarioExiste(nombreUsuario, usuarios)) {
            throw new IllegalArgumentException("Error: Usuario con nombre '" + nombreUsuario + "' ya existe.");
        }
        this.nombreUsuario = nombreUsuario;
        this.role = UserRole.NORMAL;
    }

    /**
     * Constructor para un usuario administrador con verificacion de duplicados
     * @param nombreUsuario
     * @param role
     * @param usuarios
     */
    public User_19800734_RomeroMartinez(String nombreUsuario, UserRole role, List<User_19800734_RomeroMartinez> usuarios) {
        if (usuarioExiste(nombreUsuario, usuarios)) {
            throw new IllegalArgumentException("Error: Usuario con nombre '" + nombreUsuario + "' ya existe.");
        }
        this.nombreUsuario = nombreUsuario;
        this.role = role;
    }

    /**
     * Metodo para verificar si un usuario ya existe en la lista
     * @param nombreUsuario
     * @param usuarios
     * @return devuelve un booleano de true o false dependiendo de si esta o no
     */
    private boolean usuarioExiste(String nombreUsuario, List<User_19800734_RomeroMartinez> usuarios) {
        for (User_19800734_RomeroMartinez user : usuarios) {
            if (user.getNombreUsuario().equals(nombreUsuario)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Selector para el nombre de usuario
     * @return devuelve el nombre del usuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    /**
     * Selector para el rol del usuario
     * @return devuelve el rol del usuario
     */
    public UserRole getRole() {
        return role;
    }
    /**
     * Modificador para cambiar el nombre de usuario
     * @param nuevoNombre
     */
    public void setNombreUsuario(String nuevoNombre) {
        this.nombreUsuario = nuevoNombre;
    }
    /**
     * Modificador para cambiar el rol del usuario
     * @param role
     */
    public void setRole(UserRole role) {
        this.role = role;
    }
    /**
     * Metodo para obtener una lista de usuarios a partir de una lista de nombres de usuario y un rol
     * @param nombresUsuarios
     * @param role
     * @return devuelve a la lista de usuarios
     */
    public static List<User_19800734_RomeroMartinez> getUsuarios(List<String> nombresUsuarios, UserRole role) {
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
     * @return devuelve una lista de usuarios verificada (se evita duplicados)
     */
    public static List<User_19800734_RomeroMartinez> addUsuario(String nuevoUsuario, List<User_19800734_RomeroMartinez> usuarios) {
        usuarios.add(new User_19800734_RomeroMartinez(nuevoUsuario, usuarios));
        return usuarios;
    }

    /**
     * Metodo para anadir un usuario administrador a la lista verificando que no exista previamente
     * @param nuevoUsuario
     * @param usuarios
     * @return devuelve al usuario ADMINISTRADOR de la lista verificando previamente su existencia
     */
    public static List<User_19800734_RomeroMartinez> addUsuarioAdmin(String nuevoUsuario, List<User_19800734_RomeroMartinez> usuarios) {
        usuarios.add(new User_19800734_RomeroMartinez(nuevoUsuario, UserRole.ADMINISTRATOR, usuarios));
        return usuarios;
    }
}
