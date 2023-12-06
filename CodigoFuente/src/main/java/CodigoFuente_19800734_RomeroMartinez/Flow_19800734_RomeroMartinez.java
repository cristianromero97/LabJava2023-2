package CodigoFuente_19800734_RomeroMartinez;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Flow_19800734_RomeroMartinez implements FlowInterface_19800734_RomeroMartinez {
    private int id;
    private String msg;
    private List<Option_19800734_RomeroMartinez> options;

    /**
     * Constructor de flujos
     * @param id
     * @param msg
     * @param options
     */
    public Flow_19800734_RomeroMartinez(int id, String msg,List<Option_19800734_RomeroMartinez> options) {
        this.id = id;
        this.msg = msg;
        this.options = new ArrayList<>(options);

    }
    /**
     * Metodo que obtiene el ID de un flujo
     * @return devuelve el id del flujo
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo que obtiene el mensaje que posee el flujo (MSG)
     * @return devuelve el mensaje del flujo
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Metodo que obtiene las opciones alojadas dentro de un flujo
     * @return devuelve las opciones dentro del flujo
     */
    public List<Option_19800734_RomeroMartinez> getOptions() {
        return new ArrayList<>(options);
    }

    /**
     * Metodo que modifica el ID de un flujo
     * @param newId
     */
    public void setId(int newId) {
        this.id = newId;
    }

    /**
     * Metodo que modifica el mensaje que posee un flujo
     * @param newMsg
     */
    public void setMsg(String newMsg) {
        this.msg = newMsg;
    }

    /**
     * Metodo que modifica las opciones dentro de un flujo, se complementa con la clase option
     * @param newOptions
     */
    public void setOptions(List<Option_19800734_RomeroMartinez> newOptions) {
        this.options = new ArrayList<>(newOptions);
    }

    /**
     * Metodo para anadir una nueva opcion a un flujo (flow-add-option tipo modificador)
     * @param newOption
     */
    public void addOption(Option_19800734_RomeroMartinez newOption) {
        if (options == null) {
            options = new ArrayList<>();
        }
        boolean exists = options.stream().anyMatch(option -> option.getCodigo() == newOption.getCodigo());
        if (!exists) {
            options.add(newOption);
        }
    }

    /**
     * Metodo que permite filtrar flujos segun ID
     */
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

    /**
     * Metodo que permite remover opciones duplicadas, se complementa con metodos de la clase option
     */
    public void removeDuplicates() {
        Set<Option_19800734_RomeroMartinez> uniqueOptions = new HashSet<>(options);
        setOptions(new ArrayList<>(uniqueOptions));
    }

    /**
     * Metodo para anadir flujos dentro de otros flujos (metodo opcional)
     * @param newFlow
     * @param flows
     * @return devuelve una lista de flujos actualizada
     */
    public static List<Flow_19800734_RomeroMartinez> addFlowToFlow(Flow_19800734_RomeroMartinez newFlow, List<Flow_19800734_RomeroMartinez> flows) {
        List<Flow_19800734_RomeroMartinez> listanueva = new ArrayList<>(flows);
        listanueva.add(newFlow);
        return listanueva;
    }
    /**
     * Metodo de representacion de un flujo en el menu
     * @return  devuelve los atributos del flujo para ser vistos en el menu
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Flow{id=").append(id);
        sb.append(", mensaje='").append(msg).append('\'');
        sb.append(", opciones=[");

        for (Option_19800734_RomeroMartinez option : options) {
            sb.append("\n\t\t").append(option);
        }

        sb.append("\n\t]");
        sb.append("\n}");

        return sb.toString();
    }
}
