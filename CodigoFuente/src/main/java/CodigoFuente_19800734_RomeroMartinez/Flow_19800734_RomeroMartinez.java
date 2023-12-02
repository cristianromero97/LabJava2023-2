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
    @Override
    public String toString() {
        return "Flow{" +
                "id=" + id +
                ", mensaje='" + msg + '\'' +
                ", opciones=" + options +
                '}';
    }
}
