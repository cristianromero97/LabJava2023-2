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
    
    public int getInitialFlowId() {
        return startFlowInitial;
    }
}

