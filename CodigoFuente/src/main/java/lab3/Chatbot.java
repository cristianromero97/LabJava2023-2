package lab3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Chatbot{
    private int chatbotId;
    private String nombre;
    private String mensajeBienvenida;
    private int startFlowInitial;
    private List<Flow> flows;

    // Constructor
    public Chatbot(int chatbotId, String nombre, String mensajeBienvenida, int startFlowInitial, List<Flow> flows) {
        this.chatbotId = chatbotId;
        this.nombre = nombre;
        this.mensajeBienvenida = mensajeBienvenida;
        this.startFlowInitial = startFlowInitial;
        this.flows = new ArrayList<>(flows);
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

    public List<Flow> getFlows() {
        return new ArrayList<>(flows);
    }

    // Modifier methods
    public void setChatbotId(int newChatbotId) {
        this.chatbotId = newChatbotId;
    }

    public void setNombre(String newNombre) {
        this.nombre = newNombre;
    }

    public void setMensajeBienvenida(String newMensajeBienvenida) {
        this.mensajeBienvenida = newMensajeBienvenida;
    }

    public void setStartFlowInitial(int newStartFlowInitial) {
        this.startFlowInitial = newStartFlowInitial;
    }

    public void setFlows(List<Flow> newFlows) {
        this.flows = new ArrayList<>(newFlows);
    }

    // Method to add a new flow to the list of flows
    public void addFlow(Flow newFlow) {
        flows.add(newFlow);
    }

    // Method to filter flows based on startFlowInitial
    private void filterFlows() {
        List<Flow> filteredFlows = new ArrayList<>();

        for (Flow flow : flows) {
            if (flow.getId() == startFlowInitial) {
                filteredFlows.add(flow);
            }
        }

        setFlows(filteredFlows);
    }

    // Method to remove duplicate flows
    private void removeDuplicateFlows() {
        Set<Flow> uniqueFlows = new HashSet<>(flows);
        setFlows(new ArrayList<>(uniqueFlows));
    }
    public void addOptionToFlow(int flowId, Option newOption) {
        for (Flow flow : flows) {
            if (flow.getId() == flowId) {
                flow.addOption(newOption);
                break;
            }
        }
    }

    public static void main(String[] args) {
        // ... (resto del código)

        Flow flow1 = new Flow(456, "Hello", new ArrayList<>());
        Flow flow2 = new Flow(2, "Hi", new ArrayList<>());

        List<Flow> flowsList = new ArrayList<>();
        flowsList.add(flow1);
        flowsList.add(flow2);

        Option option1 = new Option(1, "Hello", 123, 456, List.of("keyword1", "keyword2"));
        Option option2 = new Option(2, "Hi", 789, 102, List.of("keyword3", "keyword4"));

        List<Option> optionsList = new ArrayList<>();
        optionsList.add(option1);
        optionsList.add(option2);

        Chatbot chatbot = new Chatbot(123, "ChatbotName", "Welcome!", 456, flowsList);

        // Agregar opciones a flujos específicos
        chatbot.addOptionToFlow(456, option1);
        chatbot.addOptionToFlow(2, option2);

        // Apply filterFlows and removeDuplicateFlows
        chatbot.filterFlows();
        chatbot.removeDuplicateFlows();

        Flow newFlow = new Flow(3, "Hola", new ArrayList<>());
        chatbot.addFlow(newFlow);
        chatbot.filterFlows();
        chatbot.removeDuplicateFlows();

        // Accessing chatbot details
        System.out.println("Chatbot ID: " + chatbot.getChatbotId());
        System.out.println("Chatbot Name: " + chatbot.getNombre());
        System.out.println("Chatbot Welcome Message: " + chatbot.getMensajeBienvenida());
        System.out.println("Start Flow Initial: " + chatbot.getStartFlowInitial());
        System.out.println("Flows:");
        for (Flow flow : chatbot.getFlows()) {
            System.out.println("  Flow ID: " + flow.getId());
            System.out.println("  Flow Message: " + flow.getMsg());
            System.out.println("  ---------------");
            for (Option option : flow.getOptions()) {
                System.out.println("  Codigo: " + option.getCodigo());
                System.out.println("  Mensaje: " + option.getMensaje());
                System.out.println("  ChatbotCodeLink: " + option.getChatbotCodeLink());
                System.out.println("  InitialFlowCodeLink: " + option.getInitialFlowCodeLink());
                System.out.println("  Keywords: " + option.getKeywords());
                System.out.println("  ---------------");
            }
        }
    }
}

