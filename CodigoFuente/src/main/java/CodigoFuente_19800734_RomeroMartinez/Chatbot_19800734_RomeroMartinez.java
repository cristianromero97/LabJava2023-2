package CodigoFuente_19800734_RomeroMartinez;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Chatbot_19800734_RomeroMartinez implements ChatbotInterface_19800734_RomeroMartinez {
    private int chatbotId;
    private String nombre;
    private String mensajeBienvenida;
    private int startFlowInitial;
    private List<Flow_19800734_RomeroMartinez> flows;

    private List<ChatMessage> chatHistory;

    // Constructor
    public Chatbot_19800734_RomeroMartinez(int chatbotId, String nombre, String mensajeBienvenida, int startFlowInitial) {
        this.chatbotId = chatbotId;
        this.nombre = nombre;
        this.mensajeBienvenida = mensajeBienvenida;
        this.startFlowInitial = startFlowInitial;
        this.flows = new ArrayList<>();
        this.chatHistory = new ArrayList<>();
    }

    // Getter methods
    public int getChatbotId() {
        return chatbotId;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMensajeBienvenida() {
        return mensajeBienvenida;
    }

    public int getStartFlowInitial() {
        return startFlowInitial;
    }

    public List<Flow_19800734_RomeroMartinez> getFlows() {
        return new ArrayList<>(flows);
    }

    // Modifier methods
    public void setChatbotId(int nuevoId) {
        this.chatbotId = nuevoId;
    }
    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    public void setMensajeBienvenida(String nuevoMensajeBienvenida) {
        this.mensajeBienvenida = nuevoMensajeBienvenida;
    }

    public void setStartFlowInitial(int nuevoStartFlowInitial) {
        this.startFlowInitial = nuevoStartFlowInitial;
    }

    public void setFlows(List<Flow_19800734_RomeroMartinez> nuevosFlows) {
        this.flows = new ArrayList<>(nuevosFlows);
    }

    // Method to add a new flow to the list of flows
    public void addFlow(Flow_19800734_RomeroMartinez newFlow) {
        flows.add(newFlow);
    }
    @Override
    public void removeDuplicateFlows() {
        // Implementación para remover flujos duplicados
        List<Flow_19800734_RomeroMartinez> uniqueFlows = new ArrayList<>(new HashSet<>(flows));
        setFlows(uniqueFlows);
    }

    // Método para filtrar flujos por ID
    @Override
    public void filterFlowsById(int flowId) {
        // Implementación para filtrar flujos por ID
        List<Flow_19800734_RomeroMartinez> filteredFlows = flows.stream()
                .filter(flow -> flow.getId() == flowId || containsOptionWithInitialFlowCodeLink(flow, flowId))
                .collect(Collectors.toList());
        setFlows(filteredFlows);
    }
    private boolean containsOptionWithInitialFlowCodeLink(Flow_19800734_RomeroMartinez flow, int initialFlowCodeLink) {
        return flow.getOptions().stream()
                .anyMatch(option -> option.getInitialFlowCodeLink() == initialFlowCodeLink);
    }
    // Método para filtrar flujos por StartFlowInitial
    @Override
    public void filterFlowsByStartFlowInitial(int startFlowInitial) {
        // Implementación para filtrar flujos por StartFlowInitial
        List<Flow_19800734_RomeroMartinez> filteredFlows = flows.stream()
                .filter(flow -> flow.getOptions().stream()
                        .anyMatch(option -> option.getInitialFlowCodeLink() == startFlowInitial))
                .collect(Collectors.toList());
        setFlows(filteredFlows);
    }

    // Getter para el historial de chat
    public List<ChatMessage> getChatHistory() {
        return new ArrayList<>(chatHistory);
    }

    // Método para añadir un mensaje al historial de chat
    public void addMessage(String sender, String content) {
        ChatMessage message = new ChatMessage(sender, content);
        chatHistory.add(message);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Chatbot{")
                .append("ID=").append(chatbotId)
                .append(", Nombre del Chatbot ='").append(nombre).append('\'')
                .append(", Mensaje de Bienvenida='").append(mensajeBienvenida).append('\'')
                .append(", StarFlowInitial=").append(startFlowInitial)
                .append(", Flujos=[");

        for (Flow_19800734_RomeroMartinez flow : flows) {
            sb.append("\n\t").append(flow.toString());
        }

        sb.append("\n]}");

        return sb.toString();
    }
    /*public static void main(String[] args) {
        // Example usage
        Chatbot chatbot1 = new Chatbot(1, "Chatbot1", "¡Hola! Soy un chatbot.", 101);
        Chatbot chatbot2 = new Chatbot(2, "Chatbot2", "Saludos. Soy otro chatbot.", 201);

        Flow flow1 = new Flow(101, "Flujo de inicio para Chatbot1");
        Flow flow2 = new Flow(102, "Otro flujo para Chatbot1");
        Option option1 = new Option(1, "Opción 1", 1, 101, List.of("keyword1", "keyword2"));
        Option option2 = new Option(2, "Opción 2", 1, 102, List.of("keyword3", "keyword4"));
        flow1.addOption(option1);
        flow2.addOption(option2);
        chatbot1.addFlow(flow1);
        chatbot1.addFlow(flow2);

        Flow flow3 = new Flow(201, "Flujo de inicio para Chatbot2");
        Option option3 = new Option(3, "Opción 3", 2, 201, List.of("keyword5", "keyword6"));
        flow3.addOption(option3);
        chatbot2.addFlow(flow3);

        // Accessing chatbot details
        System.out.println("Chatbot1:");
        System.out.println("ID: " + chatbot1.getChatbotId());
        System.out.println("Nombre: " + chatbot1.getNombre());
        System.out.println("Mensaje de Bienvenida: " + chatbot1.getMensajeBienvenida());
        System.out.println("StartFlowInitial: " + chatbot1.getStartFlowInitial());
        System.out.println("Flows:");
        for (Flow flow : chatbot1.getFlows()) {
            System.out.println("  ID del Flujo: " + flow.getId());
            System.out.println("  Mensaje del Flujo: " + flow.getMsg());
            System.out.println("  Opciones:");
            for (Option option : flow.getOptions()) {
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

        // Similar details for Chatbot2
    }*/
    public int getInitialFlowId() {
        return startFlowInitial;
    }
}

