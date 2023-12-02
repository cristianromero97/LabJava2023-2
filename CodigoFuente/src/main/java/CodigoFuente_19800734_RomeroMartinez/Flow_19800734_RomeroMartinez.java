package CodigoFuente_19800734_RomeroMartinez;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Flow_19800734_RomeroMartinez implements FlowInterface_19800734_RomeroMartinez {
    private int id;
    private String msg;
    private List<Option_19800734_RomeroMartinez> options;

    // Constructor
    public Flow_19800734_RomeroMartinez(int id, String msg) {
        this.id = id;
        this.msg = msg;
        this.options = new ArrayList<>();

    }
    // Getter methods
    public int getId() {
        return id;
    }
    public String getMsg() {
        return msg;
    }
    public List<Option_19800734_RomeroMartinez> getOptions() {
        return new ArrayList<>(options);
    }
    // Modifier methods
    public void setId(int newId) {
        this.id = newId;
    }
    public void setMsg(String newMsg) {
        this.msg = newMsg;
    }
    public void setOptions(List<Option_19800734_RomeroMartinez> newOptions) {
        this.options = new ArrayList<>(newOptions);
    }
    // Method to add a new option to the list of options
    public void addOption(Option_19800734_RomeroMartinez newOption) {
        options.add(newOption);
    }
    // Method to filter options based on initialFlowCodeLink
    public void filterOptions() {
        List<Option_19800734_RomeroMartinez> filteredOptions = new ArrayList<>();
        int currentId = getId();

        for (Option_19800734_RomeroMartinez option : options) {
            if (option.getInitialFlowCodeLink() == currentId || option.getInitialFlowCodeLink() == 0) {
                filteredOptions.add(option);
            }
        }
        setOptions(filteredOptions);
    }
    // Method to remove duplicate options
    public void removeDuplicates() {
        Set<Option_19800734_RomeroMartinez> uniqueOptions = new HashSet<>(options);
        setOptions(new ArrayList<>(uniqueOptions));
    }
    public static List<Flow_19800734_RomeroMartinez> addFlowToFlow(Flow_19800734_RomeroMartinez newFlow, List<Flow_19800734_RomeroMartinez> flows) {
        List<Flow_19800734_RomeroMartinez> listanueva = new ArrayList<>(flows);
        listanueva.add(newFlow);
        return listanueva;
    }
    /*public static void main(String[] args) {
        // Example usage
        Flow flow1 = new Flow(456, "Flujo de ejemplo");
        Flow flow2 = new Flow(102, "Otro flujo");

        Option option1 = new Option(1, "Hello", 123, 456, List.of("keyword1", "keyword2"));
        Option option2 = new Option(2, "Hi", 789, 102, List.of("keyword3", "keyword4"));

        flow1.addOption(option1);
        flow2.addOption(option2);

        List<Flow> flowList = new ArrayList<>();
        flowList = Flow.addFlowToFlow(flow1, flowList);
        flowList = Flow.addFlowToFlow(flow2, flowList);

        // Accessing flow details
        for (Flow flow : flowList) {
            System.out.println("Flow ID: " + flow.getId());
            System.out.println("Flow Message: " + flow.getMsg());
            System.out.println("Options:");
            for (Option option : flow.getOptions()) {
                System.out.println("  Codigo: " + option.getCodigo());
                System.out.println("  Mensaje: " + option.getMensaje());
                System.out.println("  ChatbotCodeLink: " + option.getChatbotCodeLink());
                System.out.println("  InitialFlowCodeLink: " + option.getInitialFlowCodeLink());
                System.out.println("  Keywords: " + option.getKeywords());
                System.out.println("  ---------------");
            }
        }
    }*/

    @Override
    public String toString() {
        return "Flow{" +
                "id=" + id +
                ", mensaje='" + msg + '\'' +
                ", opciones=" + options +
                '}';
    }
}
