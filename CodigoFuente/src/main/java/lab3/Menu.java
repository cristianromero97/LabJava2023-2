package lab3;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Menu {
    private Sistema sistema;
    private Scanner scanner;

    private User usuarioActual;

    public Menu(Sistema sistema) {
        this.sistema = sistema;
        this.scanner = new Scanner(System.in);
        this.usuarioActual = null;
    }

    // Método para mostrar el menú principal
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("### Sistema de Chatbots - Inicio ###");
            System.out.println("1. Login de Usuario");
            System.out.println("2. Registro de Usuario");
            System.out.println("0. Salir");
            System.out.print("INTRODUZCA SU OPCIÓN: ");

            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea después de leer el número

            switch (opcion) {
                case 1:
                    loginUsuario();
                    break;
                case 2:
                    mostrarMenuRegistro();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }

    // Método para realizar el login de usuario
    private void loginUsuario() {
        System.out.print("Ingrese su nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();

        // Verificar si el usuario está registrado en el sistema
        if (sistema.getUsuarios().contains(nombreUsuario.toUpperCase())) {
            sistema.login(nombreUsuario);
            System.out.println("Inicio de sesión exitoso. ¡Bienvenido!");
            // Mostrar el menú después del inicio de sesión
            mostrarMenuDespuesLogin();
        } else {
            System.out.println("Error: No se encontró el usuario o no está registrado.");
        }
    }

    private void mostrarMenuDespuesLogin() {
        String nombreUsuarioActual = sistema.getUsuarioActual();
        if (esUsuarioAdministrador(nombreUsuarioActual)) {
            mostrarMenuAdministrador(nombreUsuarioActual);
        } else {
            mostrarMenuUsuarioNormal();
        }
    }

    private boolean esUsuarioAdministrador(String nombreUsuario) {
        List<User> usuarios = sistema.getUsuarios();
        for (User user : usuarios) {
            if (user.getNombreUsuario().equals(nombreUsuario) && user.getRole() == UserRole.ADMINISTRATOR) {
                return true;
            }
        }
        return false;
    }

    // Método para mostrar el menú de Usuario Administrador
    private void mostrarMenuAdministrador(String nombreUsuarioAdmin) {
        List<Option> opciones = new ArrayList<>();
        Chatbot chatbotCreado = null;
        int opcion;
        do {
            System.out.println("### Sistema de Chatbots - Usuario Administrador ###");
            System.out.println("Bienvenido " + nombreUsuarioAdmin + ", usted es administrador.");
            System.out.println("1. Crear un Chatbot");
            System.out.println("2. Modificar un Chatbot");
            System.out.println("3. Ejecutar un Chatbot");
            System.out.println("4. Visualizar todos los chatbots existentes en el sistema");
            System.out.println("5. Visualizar todos los chatbots con sus flujos y opciones creadas");
            System.out.println("6. Ejecutar una simulación del sistema de chatbot");
            System.out.println("7. Salir");
            System.out.print("INTRODUZCA SU OPCIÓN: ");

            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea después de leer el número

            switch (opcion) {
                case 1:
                    System.out.println("### Crear un nuevo Chatbot ###");

                    // Paso 1: Crear opciones
                    opciones.clear();  // Limpiar la lista antes de agregar nuevas opciones
                    int numOpciones = obtenerNumeroOpciones();

                    for (int i = 1; i <= numOpciones; i++) {
                        System.out.println("### Crear Opción " + i + " ###");
                        Option nuevaOpcion = crearNuevaOpcion();
                        opciones.add(nuevaOpcion);
                    }

                    // Paso 2: Crear flujo
                    System.out.println("### Crear un nuevo Flujo ###");
                    Flow nuevoFlujo = crearNuevoFlujo(opciones);

                    // Paso 3: Crear chatbot
                    System.out.println("### Crear un nuevo Chatbot ###");
                    Chatbot nuevoChatbot = crearNuevoChatbot(nuevoFlujo);

                    // Asignar el chatbot creado a la variable
                    chatbotCreado = nuevoChatbot;

                    // Agregar el nuevo chatbot al sistema
                    sistema.addChatbot(nuevoChatbot);
                    System.out.println("Chatbot creado exitosamente!");

                    break;

                case 2:
                    // Lógica para modificar un chatbot
                    break;
                case 3:
                    // Lógica para ejecutar un chatbot
                    break;
                case 4:
                    // Lógica para visualizar todos los chatbots en el sistema
                    break;
                case 5:
                    if (chatbotCreado != null) {
                        System.out.println("### Información del Chatbot Creado ###");
                        System.out.println(chatbotCreado);
                    } else {
                        System.out.println("Aún no se ha creado ningún chatbot.");
                    }
                    break;
                case 6:
                    // Lógica para ejecutar una simulación del sistema de chatbot
                    break;
                case 7:
                    System.out.println("Saliendo del menú de Usuario Administrador.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 7);
    }

    // Método para mostrar el menú de Usuario Normal
    private void mostrarMenuUsuarioNormal() {
        // Lógica para el menú de usuario normal
        // ...
    }

    // Método para mostrar el menú de registro y manejar las opciones
    private void mostrarMenuRegistro() {
        int opcion;
        do {
            System.out.println("### Sistema de Chatbots - Registro ###");
            System.out.println("1. Registrar usuario normal");
            System.out.println("2. Registrar usuario administrador");
            System.out.println("0. Volver al menú principal");
            System.out.print("INTRODUZCA SU OPCIÓN: ");

            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea después de leer el número

            switch (opcion) {
                case 1:
                    registrarUsuarioNormal();
                    break;
                case 2:
                    registrarUsuarioAdministrador();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }

    // Método para registrar un usuario normal
    private void registrarUsuarioNormal() {
        System.out.print("INTRODUZCA NOMBRE DE USUARIO: ");
        String nuevoUsuario = scanner.nextLine();
        sistema.register(nuevoUsuario);
        System.out.println("Registro exitoso. ¡Bienvenido!");
    }

    // Método para registrar un usuario administrador
    private void registrarUsuarioAdministrador() {
        System.out.println("### Sistema de Chatbots - Registro Usuario Administrador ###");
        System.out.print("INTRODUZCA NOMBRE DEL USUARIO ADMINISTRADOR: ");
        String nuevoUsuarioAdmin = scanner.nextLine();
        sistema.addUsuarioAdmin(nuevoUsuarioAdmin, UserRole.ADMINISTRATOR);
        System.out.println("Registro exitoso. ¡Bienvenido!");
        mostrarMenuAdministrador(nuevoUsuarioAdmin);
    }

    private Option crearNuevaOpcion() {
        int codigo;
        String mensaje;
        int chatbotCodeLink;
        int initialFlowCodeLink;
        List<String> keywords;

        System.out.print("Ingrese el código de la opción: ");
        codigo = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea después de leer el número

        System.out.print("Ingrese el mensaje de la opción: ");
        mensaje = scanner.nextLine();

        System.out.print("Ingrese el código del chatbot vinculado a la opción: ");
        chatbotCodeLink = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea después de leer el número

        System.out.print("Ingrese el código del flujo inicial vinculado a la opción: ");
        initialFlowCodeLink = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea después de leer el número

        System.out.print("Ingrese las palabras clave de la opción (separadas por comas): ");
        String keywordsInput = scanner.nextLine();
        keywords = Arrays.asList(keywordsInput.split(","));

        // Crear y devolver la nueva opción
        return new Option(codigo, mensaje, chatbotCodeLink, initialFlowCodeLink, keywords);
    }

    private Flow crearNuevoFlujo(List<Option> opciones) {
        int id;
        String mensaje;

        System.out.print("Ingrese el ID del flujo: ");
        id = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea después de leer el número

        System.out.print("Ingrese el mensaje del flujo: ");
        mensaje = scanner.nextLine();

        // Crear y devolver el nuevo flujo
        Flow nuevoFlujo = new Flow(id, mensaje);
        opciones.forEach(nuevoFlujo::addOption); // Agregar opciones al flujo
        return nuevoFlujo;
    }

    private Chatbot crearNuevoChatbot(Flow flujoInicial) {
        int chatbotId;
        String nombre;
        String mensajeBienvenida;
        int startFlowInitial;

        System.out.print("Ingrese el ID del chatbot: ");
        chatbotId = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea después de leer el número

        System.out.print("Ingrese el nombre del chatbot: ");
        nombre = scanner.nextLine();

        System.out.print("Ingrese el mensaje de bienvenida del chatbot: ");
        mensajeBienvenida = scanner.nextLine();

        System.out.print("Ingrese el código del flujo inicial del chatbot: ");
        startFlowInitial = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea después de leer el número

        // Crear y devolver el nuevo chatbot
        Chatbot nuevoChatbot = new Chatbot(chatbotId, nombre, mensajeBienvenida, startFlowInitial);
        nuevoChatbot.addFlow(flujoInicial);
        return nuevoChatbot;
    }

    private int obtenerNumeroOpciones() {
        int numOpciones;
        do {
            System.out.print("Ingrese el número de opciones para el flujo (debe ser mayor que 0): ");
            numOpciones = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea después de leer el número

            if (numOpciones <= 0) {
                System.out.println("Error: El número de opciones debe ser mayor que 0. Intente de nuevo.");
            }
        } while (numOpciones <= 0);

        return numOpciones;
    }


    public static void main(String[] args) {
        Sistema sistema = new Sistema("Sistema de Chatbots", 101, Arrays.asList(new Chatbot(101, "Chatbot1", "¡Hola! Soy un chatbot.", 101)));
        Menu menu = new Menu(sistema);
        menu.mostrarMenu();
    }
}
