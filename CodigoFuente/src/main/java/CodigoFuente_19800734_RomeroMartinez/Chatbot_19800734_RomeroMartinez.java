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

    /**
     * Constructor de chatbots
     * @param chatbotId
     * @param nombre
     * @param mensajeBienvenida
     * @param startFlowInitial
     */
    public Chatbot_19800734_RomeroMartinez(int chatbotId, String nombre, String mensajeBienvenida, int startFlowInitial) {
        this.chatbotId = chatbotId;
        this.nombre = nombre;
        this.mensajeBienvenida = mensajeBienvenida;
        this.startFlowInitial = startFlowInitial;
        this.flows = new ArrayList<>();
    }
    /**
     * Metodo que obtiene el chatbotID de un chatbot en especifico
     * @return devuelve el chatbotID
     */
    public int getChatbotId() {
        return chatbotId;
    }
    /**
     * Metodo que obtiene el nombre de un chatbot
     * @return devuelve el nombre del chatbot
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Metodo que obtiene el mensaje de bienvenida del chatbot
     * @return devuelve su mensaje de bienvenida
     */
    public String getMensajeBienvenida() {
        return mensajeBienvenida;
    }
    /**
     * Metodo que obtiene el startflowinitial del chatbot, vale decir, el flujo asociado a este mediante esta id
     * @return devuelve el startflowinitial
     */
    public int getStartFlowInitial() {
        return startFlowInitial;
    }
    /**
     * Metodo que obtiene los flujos de un chatbot
     * @return devuelve los flujos asociados al chatbot
     */
    public List<Flow_19800734_RomeroMartinez> getFlows() {
        return new ArrayList<>(flows);
    }
    /**
     * Metodo para modificar el ID de un chatbot
     * @param nuevoId
     */
    public void setChatbotId(int nuevoId) {
        this.chatbotId = nuevoId;
    }
    /**
     * Metodo para modificar el nombre de un chatbot
     * @param nuevoNombre
     */
    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }
    /**
     * Metodo para modificar el mensaje de bienvenida de un chatbot
     * @param nuevoMensajeBienvenida
     */
    public void setMensajeBienvenida(String nuevoMensajeBienvenida) {
        this.mensajeBienvenida = nuevoMensajeBienvenida;
    }
    /**
     * Metodo para modificar el startflowinital de un chatbot, vale decir , el id de otro flujo asociado a un chatbot especifico
     * @param nuevoStartFlowInitial
     */
    public void setStartFlowInitial(int nuevoStartFlowInitial) {
        this.startFlowInitial = nuevoStartFlowInitial;
    }
    /**
     * Metodo para modificar la lista de flujos asociados a un chatbot
     * @param nuevosFlows
     */
    public void setFlows(List<Flow_19800734_RomeroMartinez> nuevosFlows) {
        this.flows = new ArrayList<>(nuevosFlows);
    }
    /**
     * Metodo para anadir flujos a un chatbot
     * @param newFlow
     */
    public void addFlow(Flow_19800734_RomeroMartinez newFlow) {
        flows.add(newFlow);
    }
    /**
     * Metodo para remover flujos duplicados de un chatbot
     */
    @Override
    public void removeDuplicateFlows() {
        List<Flow_19800734_RomeroMartinez> uniqueFlows = new ArrayList<>(new HashSet<>(flows));
        setFlows(uniqueFlows);
    }
    /**
     * Metodo para filtrar flujos segun ID del chatbot (startinitialflow con chatbotID)
     * @param flowId
     */
    @Override
    public void filterFlowsById(int flowId) {
        List<Flow_19800734_RomeroMartinez> filteredFlows = flows.stream()
                .filter(flow -> flow.getId() == flowId || containsOptionWithInitialFlowCodeLink(flow, flowId))
                .collect(Collectors.toList());
        setFlows(filteredFlows);
    }
    /**
     * Metodo que indica las opciones contenidas dentro del flujo, hace comparacion de ID con el flujo y chatbot
     * @param flow
     * @param initialFlowCodeLink
     * @return devuelve un booleano en caso de haber corcordancia de IDs
     */
    private boolean containsOptionWithInitialFlowCodeLink(Flow_19800734_RomeroMartinez flow, int initialFlowCodeLink) {
        return flow.getOptions().stream()
                .anyMatch(option -> option.getInitialFlowCodeLink() == initialFlowCodeLink);
    }
    /**
     * Metodo anexo para filtar segun starFlowInitial (similar al filtroporID)
     * @param startFlowInitial
     */
    @Override
    public void filterFlowsByStartFlowInitial(int startFlowInitial) {
        List<Flow_19800734_RomeroMartinez> filteredFlows = flows.stream()
                .filter(flow -> flow.getOptions().stream()
                        .anyMatch(option -> option.getInitialFlowCodeLink() == startFlowInitial))
                .collect(Collectors.toList());
        setFlows(filteredFlows);
    }
    /**
     * Metodo de representacion de un chatbot en la clase menu, para ser visualizado en el menu del usuario
     * @return devuelve los atributos del chatbot en el menu
     */
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
}

