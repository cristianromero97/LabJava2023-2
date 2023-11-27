package lab3;

import java.util.ArrayList;
import java.util.List;

// Enumeración para representar los roles de usuario
enum UserRole {
    NORMAL, ADMINISTRATOR
}

public class User {

    // Atributos
    private String nombreUsuario;
    private UserRole role;

    // Constructor para un usuario normal con verificación de duplicados
    public User(String nombreUsuario, List<User> usuarios) {
        if (usuarioExiste(nombreUsuario, usuarios)) {
            throw new IllegalArgumentException("Error: Usuario con nombre '" + nombreUsuario + "' ya existe.");
        }
        this.nombreUsuario = nombreUsuario;
        this.role = UserRole.NORMAL;
    }

    // Constructor para un usuario administrador con verificación de duplicados
    public User(String nombreUsuario, UserRole role, List<User> usuarios) {
        if (usuarioExiste(nombreUsuario, usuarios)) {
            throw new IllegalArgumentException("Error: Usuario con nombre '" + nombreUsuario + "' ya existe.");
        }
        this.nombreUsuario = nombreUsuario;
        this.role = role;
    }

    // Método para verificar si un usuario ya existe en la lista
    private boolean usuarioExiste(String nombreUsuario, List<User> usuarios) {
        for (User user : usuarios) {
            if (user.getNombreUsuario().equals(nombreUsuario)) {
                return true;
            }
        }
        return false;
    }

    // Selector para el nombre de usuario
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    // Selector para el rol del usuario
    public UserRole getRole() {
        return role;
    }

    // Modificador para cambiar el nombre de usuario
    public void setNombreUsuario(String nuevoNombre) {
        this.nombreUsuario = nuevoNombre;
    }

    // Modificador para cambiar el rol del usuario
    public void setRole(UserRole role) {
        this.role = role;
    }

    // Método para obtener una lista de usuarios a partir de una lista de nombres de usuario y un rol
    public static List<User> getUsuarios(List<String> nombresUsuarios, UserRole role) {
        List<User> usuarios = new ArrayList<>();
        for (String nombreUsuario : nombresUsuarios) {
            usuarios.add(new User(nombreUsuario, role, usuarios));
        }
        return usuarios;
    }

    // Método para añadir un usuario a la lista verificando que no exista previamente
    public static List<User> addUsuario(String nuevoUsuario, List<User> usuarios) {
        usuarios.add(new User(nuevoUsuario, usuarios));
        return usuarios;
    }

    // Método para añadir un usuario administrador a la lista verificando que no exista previamente
    public static List<User> addUsuarioAdmin(String nuevoUsuario, List<User> usuarios) {
        usuarios.add(new User(nuevoUsuario, UserRole.ADMINISTRATOR, usuarios));
        return usuarios;
    }

    public static void main(String[] args) {
        // Ejemplo de uso con usuario normal
        List<User> usuariosNormales = getUsuarios(List.of("Usuario1", "Usuario2"), UserRole.NORMAL);
        System.out.println("Lista de Usuarios Normales: " + usuariosNormales);

        // Intentar agregar un usuario normal con un nombre existente
        try {
            usuariosNormales = addUsuario("Usuario3", usuariosNormales);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Agregar un usuario normal nuevo
        usuariosNormales = addUsuario("NuevoUsuarioNormal", usuariosNormales);
        System.out.println("Lista Usuarios Normales actualizada: " + usuariosNormales);

        // Intentar crear un usuario normal con un nombre existente
        try {
            User usuarioNormal2 = new User("Usuario4", usuariosNormales);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        List<User> usuariosAdmin = getUsuarios(List.of("Admin1", "Admin2"), UserRole.ADMINISTRATOR);
        System.out.println("Lista de Usuarios Administradores: " + usuariosAdmin);

        // Intentar agregar un usuario administrador con un nombre existente
        try {
            usuariosAdmin = addUsuarioAdmin("Admin3", usuariosAdmin);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Agregar un usuario administrador nuevo
        usuariosAdmin = addUsuarioAdmin("NuevoAdmin", usuariosAdmin);
        System.out.println("Lista Usuarios Administradores actualizada: " + usuariosAdmin);

        // Intentar crear un usuario administrador con un nombre existente
        try {
            User admin2 = new User("Admin4", usuariosAdmin);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
