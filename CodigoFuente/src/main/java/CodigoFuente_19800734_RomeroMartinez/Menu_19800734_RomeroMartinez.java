package CodigoFuente_19800734_RomeroMartinez;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Menu_19800734_RomeroMartinez {
    private Sistema_19800734_RomeroMartinez sistema;
    private Scanner scanner;
    private List<Chatbot_19800734_RomeroMartinez> chatbotsCreados;
    private List<Chatbot_19800734_RomeroMartinez> chatbots = new ArrayList<>();
    private User_19800734_RomeroMartinez usuarioActual;

    public Menu_19800734_RomeroMartinez(Sistema_19800734_RomeroMartinez sistema) {
        this.sistema = sistema;
        this.scanner = new Scanner(System.in);
        this.usuarioActual = null;
        this.chatbotsCreados = new ArrayList<>();
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
            mostrarMenuUsuarioNormal(nombreUsuarioActual);
        }
    }

    private boolean esUsuarioAdministrador(String nombreUsuario) {
        List<User_19800734_RomeroMartinez> usuarios = sistema.getUsuarios();
        for (User_19800734_RomeroMartinez user : usuarios) {
            if (user.getNombreUsuario().equals(nombreUsuario) && user.getRole() == UserRole.ADMINISTRATOR) {
                return true;
            }
        }
        return false;
    }

    // Método para mostrar el menú de Usuario Administrador
    private void mostrarMenuAdministrador(String nombreUsuarioAdmin) {
        List<Option_19800734_RomeroMartinez> opciones = new ArrayList<>();
        Chatbot_19800734_RomeroMartinez chatbotCreado = null;
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
                        Option_19800734_RomeroMartinez nuevaOpcion = crearNuevaOpcion();
                        opciones.add(nuevaOpcion);
                    }

                    // Paso 2: Crear flujo
                    System.out.println("### Crear un nuevo Flujo ###");
                    Flow_19800734_RomeroMartinez nuevoFlujo = crearNuevoFlujo(opciones);

                    // Paso 3: Crear chatbot
                    System.out.println("### Crear un nuevo Chatbot ###");
                    Chatbot_19800734_RomeroMartinez nuevoChatbot = crearNuevoChatbot(nuevoFlujo);

                    // Asignar el chatbot creado a la variable
                    chatbotCreado = nuevoChatbot;

                    // Agregar el nuevo chatbot al sistema
                    sistema.addChatbot(nuevoChatbot);
                    chatbotsCreados.add(nuevoChatbot);
                    System.out.println("Chatbot creado exitosamente!");

                    break;

                case 2:
                    // Lógica para modificar un chatbot
                    if (chatbotsCreados.isEmpty()) {
                        System.out.println("No hay chatbots disponibles para modificar.");
                    } else {
                        System.out.println("### Modificar un Chatbot ###");
                        mostrarChatbotsDisponibles(chatbotsCreados);

                        System.out.print("Seleccione el ID del chatbot que desea modificar: ");
                        int chatbotIdSeleccionado = scanner.nextInt();
                        scanner.nextLine(); // Consumir la nueva línea después de leer el número

                        Chatbot_19800734_RomeroMartinez chatbotAModificar = buscarChatbotPorId(chatbotIdSeleccionado, chatbotsCreados);

                        if (chatbotAModificar != null) {
                            // Realizar modificaciones en el chatbot
                            modificarChatbot(chatbotAModificar);
                            System.out.println("Chatbot modificado exitosamente.");
                        } else {
                            System.out.println("No se encontró ningún chatbot con el ID seleccionado.");
                        }
                    }
                    break;
                case 3:
                    // Lógica para ejecutar un chatbot
                    System.out.println("Metodo no implementado.");
                    break;
                case 4:
                    // Lógica para visualizar todos los chatbots en el sistema
                    Sistema_19800734_RomeroMartinez nuevoSistema = crearSistema();
                    anadirChatbotsAlSistema(nuevoSistema);
                    eliminarChatbotsNoCoincidentes(nuevoSistema);
                    mostrarSistema(nuevoSistema);
                    break;

                case 5:
                    // Opción para visualizar la información de todos los chatbots creados
                    if (!chatbotsCreados.isEmpty()) {
                        System.out.println("### Información de Chatbots Creados ###");
                        for (Chatbot_19800734_RomeroMartinez chatbot : chatbotsCreados) {
                            System.out.println(chatbot);
                        }
                    } else {
                        System.out.println("Aún no se ha creado ningún chatbot.");
                    }
                    break;
                case 6:
                    // Lógica para ejecutar una simulación del sistema de chatbot
                    System.out.println("Metodo no implementado.");
                    break;
                case 7:
                    sistema.logout(); // Cerrar sesión antes de salir
                    System.out.println("Saliendo del menu de Usuario Administrador.");
                    System.out.println("Limpiando datos del sistema.");
                    System.out.println("Cerrando Sesion............");
                    System.out.println("Espero que tenga un buen dia!");
                    System.exit(0); // Salir del programa
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (true);
    }

    // Método para mostrar el menú de Usuario Normal
    private void mostrarMenuUsuarioNormal(String nuevoUsuario) {
        // Lógica para el menú de usuario normal
        int opcion;
        do {
            System.out.println("### Sistema de Chatbots - Usuario NORMAL ###");
            System.out.println("Bienvenido " + nuevoUsuario + ", usted es usuario normal.");
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
                    System.out.println("Usted es usuario normal no puede crear un chatbot.");
                    break;
                case 2:
                    // Lógica para modificar un chatbot
                    System.out.println("Usted es usuario normal no puede modificar un chatbot.");
                    break;
                case 3:
                    // Lógica para ejecutar un chatbot
                        System.out.println("Metodo no implementado.");
                    break;
                case 4:
                    // Lógica para visualizar todos los chatbots en el sistema
                    cargarSistemaPrueba();
                    cargarChatbotPrueba();
                    break;
                case 5:
                    cargarChatbotPrueba();
                    break;
                case 6:
                    // Lógica para ejecutar una simulación del sistema de chatbot
                    System.out.println("Metodo no implementado.");
                    break;
                case 7:
                    sistema.logout(); // Cerrar sesión antes de salir
                    System.out.println("Saliendo del menu de Usuario Normal.");
                    System.out.println("Limpiando datos del sistema.");
                    System.out.println("Cerrando Sesion............");
                    System.out.println("Espero que tenga un buen dia!");
                    System.exit(0); // Salir del programa
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (true);
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
        mostrarMenuUsuarioNormal(nuevoUsuario);
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

    private Option_19800734_RomeroMartinez crearNuevaOpcion() {
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
        return new Option_19800734_RomeroMartinez(codigo, mensaje, chatbotCodeLink, initialFlowCodeLink, keywords);
    }

    private Flow_19800734_RomeroMartinez crearNuevoFlujo(List<Option_19800734_RomeroMartinez> opciones) {
        int id;
        String mensaje;

        System.out.print("Ingrese el ID del flujo: ");
        id = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea después de leer el número

        System.out.print("Ingrese el mensaje del flujo: ");
        mensaje = scanner.nextLine();

        // Crear y devolver el nuevo flujo
        Flow_19800734_RomeroMartinez nuevoFlujo = new Flow_19800734_RomeroMartinez(id, mensaje);
        opciones.forEach(nuevoFlujo::addOption); // Agregar opciones al flujo
        return nuevoFlujo;
    }

    private Chatbot_19800734_RomeroMartinez crearNuevoChatbot(Flow_19800734_RomeroMartinez flujoInicial) {
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
        Chatbot_19800734_RomeroMartinez nuevoChatbot = new Chatbot_19800734_RomeroMartinez(chatbotId, nombre, mensajeBienvenida, startFlowInitial);
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
    private Sistema_19800734_RomeroMartinez crearSistema() {
        System.out.println("### Crear un nuevo Sistema ###");
        System.out.print("Ingrese el nombre del sistema: ");
        String nombreSistema = scanner.nextLine();

        System.out.print("Ingrese el initialChatbotCodeLink del sistema: ");
        int initialChatbotCodeLink = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea después de leer el número

        return new Sistema_19800734_RomeroMartinez(nombreSistema, initialChatbotCodeLink, new ArrayList<>());
    }
    private void mostrarSistema(Sistema_19800734_RomeroMartinez sistema) {
        // Mostrar el sistema por pantalla
        System.out.println("### Información del Sistema ###");
        System.out.println("Nombre del Sistema: " + sistema.getNombreSistema());
        System.out.println("Fecha de Creación: " + sistema.getFechaCreacion());
        System.out.println("InitialChatbotCodeLink: " + sistema.getInitialChatbotCodeLink());

        List<Chatbot_19800734_RomeroMartinez> chatbots = sistema.getChatbots();
        if (!chatbots.isEmpty()) {
            System.out.println("### Chatbots en el Sistema ###");
            for (Chatbot_19800734_RomeroMartinez chatbot : chatbots) {
                System.out.println(chatbot);
            }
        } else {
            System.out.println("No hay chatbots en el sistema.");
        }
    }
    private void anadirChatbotsAlSistema(Sistema_19800734_RomeroMartinez sistema) {
        for (Chatbot_19800734_RomeroMartinez chatbot : chatbotsCreados) {
            sistema.addChatbotIfIdMatches(chatbot);
        }
        System.out.println("Chatbots añadidos al sistema.");
    }

    private void eliminarChatbotsNoCoincidentes(Sistema_19800734_RomeroMartinez sistema) {
        List<Chatbot_19800734_RomeroMartinez> chatbots = sistema.getChatbots();
        chatbots.removeIf(chatbot -> chatbot.getChatbotId() != sistema.getInitialChatbotCodeLink());
        System.out.println("Chatbots no coincidentes eliminados del sistema.");
    }

    private void cargarSistemaPrueba(){
        Sistema_19800734_RomeroMartinez sistema = new Sistema_19800734_RomeroMartinez("Sistema de Chatbots de prueba", 101, chatbots);
        // Accediendo a los detalles del sistema y chatbots
        System.out.println("Detalles del Sistema:");
        System.out.println("Nombre del Sistema: " + sistema.getNombreSistema());
        System.out.println("Fecha de Creación: " + sistema.getFechaCreacion());
        System.out.println("InitialChatbotCodeLink: " + sistema.getInitialChatbotCodeLink());
    }
    private void cargarChatbotPrueba(){
        Chatbot_19800734_RomeroMartinez chatbot1 = new Chatbot_19800734_RomeroMartinez(1, "Chatbot de prueba", "¡Hola! ¿Que deseas estudiar?", 101);
        Flow_19800734_RomeroMartinez flow1 = new Flow_19800734_RomeroMartinez(101, "Flujo de estudios");
        Flow_19800734_RomeroMartinez flow2 = new Flow_19800734_RomeroMartinez(101, "Flujo de materias");
        Option_19800734_RomeroMartinez option1 = new Option_19800734_RomeroMartinez(1, "Estudiar Ingenieria", 1, 101, List.of("Ejecucion", "Civil" , "Tecnico"));
        Option_19800734_RomeroMartinez option2 = new Option_19800734_RomeroMartinez(2, "Programacion", 1, 101, List.of("Paradigmas", "Metodos" , "Analisis" , "Fundamentos"));
        Option_19800734_RomeroMartinez option3 = new Option_19800734_RomeroMartinez(3,"Matematica",1,101,List.of("Calculo", "Algebra" , "Ecuaciones" , "Analisis estadistico"));
        Option_19800734_RomeroMartinez option4 = new Option_19800734_RomeroMartinez(4,"Ciencia",1,101,List.of("Fisica", "Electro" , "Quimica"));
        flow1.addOption(option1);
        flow2.addOption(option2);
        flow2.addOption(option3);
        flow2.addOption(option4);
        chatbot1.addFlow(flow1);
        chatbot1.addFlow(flow2);
        System.out.println("Chatbot1:");
        System.out.println("ID: " + chatbot1.getChatbotId());
        System.out.println("Nombre: " + chatbot1.getNombre());
        System.out.println("Mensaje de Bienvenida: " + chatbot1.getMensajeBienvenida());
        System.out.println("StartFlowInitial: " + chatbot1.getStartFlowInitial());
        System.out.println("Flows:");
        for (Flow_19800734_RomeroMartinez flow : chatbot1.getFlows()) {
            System.out.println("  ID del Flujo: " + flow.getId());
            System.out.println("  Mensaje del Flujo: " + flow.getMsg());
            System.out.println("  Opciones:");
            for (Option_19800734_RomeroMartinez option : flow.getOptions()) {
                System.out.println("    Codigo: " + option.getCodigo());
                System.out.println("    Mensaje: " + option.getMensaje());
                System.out.println("    ChatbotCodeLink: " + option.getChatbotCodeLink());
                System.out.println("    InitialFlowCodeLink: " + option.getInitialFlowCodeLink());
                System.out.println("    Keywords: " + option.getKeywords());
                System.out.println("    ---------------");
            }
            System.out.println("  ---------------");
        }
        System.out.println("---------------");
        Chatbot_19800734_RomeroMartinez chatbot2 = new Chatbot_19800734_RomeroMartinez(1, "Chatbot de prueba 2 ", "Interesante, ¿Cual son tus pasatiempos?", 102);
        Flow_19800734_RomeroMartinez flow3 = new Flow_19800734_RomeroMartinez(102, "Flujo de pasatiempos principal");
        Flow_19800734_RomeroMartinez flow4 = new Flow_19800734_RomeroMartinez(102, "Flujo de otros pasatiempos");
        Option_19800734_RomeroMartinez option5 = new Option_19800734_RomeroMartinez(5, "Programar", 1, 102, List.of("Crear", "Disenar" , "Aprender"));
        Option_19800734_RomeroMartinez option6 = new Option_19800734_RomeroMartinez(6, "Escuchar Musica", 1, 102, List.of("Rock", "Metal" , "Pop" , "Hip-hop"));
        Option_19800734_RomeroMartinez option7 = new Option_19800734_RomeroMartinez(7,"Jugar videojuegos",1,102,List.of("Fantasia", "RPG" , "Shooter" , "Gacha"));
        Option_19800734_RomeroMartinez option8 = new Option_19800734_RomeroMartinez(8,"Leer libros",1,102,List.of("Misterio", "Fantasia" , "Romance"));
        flow3.addOption(option5);
        flow4.addOption(option6);
        flow4.addOption(option7);
        flow4.addOption(option8);
        chatbot2.addFlow(flow3);
        chatbot2.addFlow(flow4);
        System.out.println("Chatbot2:");
        System.out.println("ID: " + chatbot2.getChatbotId());
        System.out.println("Nombre: " + chatbot2.getNombre());
        System.out.println("Mensaje de Bienvenida: " + chatbot2.getMensajeBienvenida());
        System.out.println("StartFlowInitial: " + chatbot2.getStartFlowInitial());
        System.out.println("Flows:");
        for (Flow_19800734_RomeroMartinez flow : chatbot2.getFlows()) {
            System.out.println("  ID del Flujo: " + flow.getId());
            System.out.println("  Mensaje del Flujo: " + flow.getMsg());
            System.out.println("  Opciones:");
            for (Option_19800734_RomeroMartinez option : flow.getOptions()) {
                System.out.println("    Codigo: " + option.getCodigo());
                System.out.println("    Mensaje: " + option.getMensaje());
                System.out.println("    ChatbotCodeLink: " + option.getChatbotCodeLink());
                System.out.println("    InitialFlowCodeLink: " + option.getInitialFlowCodeLink());
                System.out.println("    Keywords: " + option.getKeywords());
                System.out.println("    ---------------");
            }
            System.out.println("  ---------------");
        }
        System.out.println("---------------");
    }

    private void mostrarChatbotsDisponibles(List<Chatbot_19800734_RomeroMartinez> chatbots) {
        System.out.println("### Chatbots Disponibles ###");
        for (Chatbot_19800734_RomeroMartinez chatbot : chatbots) {
            System.out.println(chatbot);
        }
    }

    // Método para buscar un chatbot por su ID
    private Chatbot_19800734_RomeroMartinez buscarChatbotPorId(int id, List<Chatbot_19800734_RomeroMartinez> chatbots) {
        for (Chatbot_19800734_RomeroMartinez chatbot : chatbots) {
            if (chatbot.getChatbotId() == id) {
                return chatbot;
            }
        }
        return null; // Retorna null si no se encuentra ningún chatbot con el ID especificado
    }

    // Método para modificar un chatbot
    private void modificarChatbot(Chatbot_19800734_RomeroMartinez chatbot) {
        System.out.println("### Modificar Chatbot ###");
        System.out.print("Nuevo nombre: ");
        String nuevoNombre = scanner.nextLine();
        chatbot.setNombre(nuevoNombre);
        System.out.print("Nuevo mensaje de bienvenida: ");
        String nuevoMensajeBienvenida = scanner.nextLine();
        chatbot.setMensajeBienvenida(nuevoMensajeBienvenida);
        System.out.print("Nuevo ID del chatbot: ");
        int nuevoChatbotID = scanner.nextInt();
        chatbot.setChatbotId(nuevoChatbotID);
        System.out.print("Nuevo inicio del flujo: ");
        int nuevostartFlowInitial = scanner.nextInt();
        chatbot.setStartFlowInitial(nuevostartFlowInitial);
        // Modificar flujos
        List<Flow_19800734_RomeroMartinez> flujos = chatbot.getFlows();
        for (Flow_19800734_RomeroMartinez flujo : flujos) {
            modificarFlujo(flujo);
        }
        // Modificar opciones en cada flujo
        for (Flow_19800734_RomeroMartinez flow : flujos) {
            List<Option_19800734_RomeroMartinez> opciones = flow.getOptions();
            for (Option_19800734_RomeroMartinez opcion : opciones) {
                modificarOpcion(opcion);
            }
        }
    }

    private void modificarFlujo(Flow_19800734_RomeroMartinez flow) {
        System.out.println("### Modificar Flujo ###");
        System.out.print("Nuevo ID del flujo: ");
        int nuevoFlujoID = scanner.nextInt();
        flow.setId(nuevoFlujoID);
        scanner.nextLine();
        System.out.print("Nuevo Mensaje del flujo: ");
        String nuevoMSG = scanner.nextLine();
        flow.setMsg(nuevoMSG);
    }

    private void modificarOpcion(Option_19800734_RomeroMartinez opcion) {
        System.out.println("### Modificar Opción ###");
        System.out.print("Nuevo mensaje de la opcion: ");
        String nuevoTEXTO = scanner.nextLine();
        opcion.setMensaje(nuevoTEXTO);
        System.out.print("Nuevo Codigo de la opción: ");
        int nuevoOpcionID = scanner.nextInt();
        opcion.setCodigo(nuevoOpcionID);
        System.out.print("Nuevo chatbotCodeLink de la opción: ");
        int nuevoChatbotCodeLink = scanner.nextInt();
        opcion.setChatbotCodeLink(nuevoChatbotCodeLink);
        System.out.print("Nuevo initialFlowCodeLink de la opción: ");
        int nuevoinitialFlowCodeLink = scanner.nextInt();
        opcion.setInitialFlowCodeLink(nuevoinitialFlowCodeLink);
        System.out.print("Nuevas keywords de la opción (separadas por comas): ");
        scanner.nextLine();
        String nuevaKeywordInput = scanner.nextLine();
        List<String> nuevasKeywords = Arrays.asList(nuevaKeywordInput.split(","));
        opcion.setKeywords(nuevasKeywords);
    }
}