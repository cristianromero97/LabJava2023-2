package CodigoFuente_19800734_RomeroMartinez;

import java.util.List;

public interface ChatbotInterface_19800734_RomeroMartinez {

    /**
     * Metodo de interface para obtener el ID de un chabot
     * @return devuelve el id de un chatbot
     */
    int getChatbotId();

    /**
     * Metodo de interface para obtener el nombre de un chatbot
     * @return devuelve el nombre del chatbot
     */
    String getNombre();

    /**
     * Metodo de interface para obtener el mensaje de bienvenida de un chatbot
     * @return devuelve el mensaje de bienvenida
     */
    String getMensajeBienvenida();

    /**
     * Metodo de interface para obtener el startflowinitial de un chatbot
     * @return devuelve el startflowinitial
     */
    int getStartFlowInitial();

    /**
     * Metodo de interface para obtener una lista de flujos asociados al chatbot
     * @return devuelve la lista de flujos
     */
    List<Flow_19800734_RomeroMartinez> getFlows();

    /**
     * Metodo de interface para modificar el nombre del chatbot
     * @param nuevoNombre
     */
    void setNombre(String nuevoNombre);

    /**
     * Metodo de interface para modificar el mensaje de bienvenida del chatbot
     * @param nuevoMensajeBienvenida
     */
    void setMensajeBienvenida(String nuevoMensajeBienvenida);

    /**
     * Metodo de interface para modificar el startflowinitial del chatbot
     * @param nuevoStartFlowInitial
     */
    void setStartFlowInitial(int nuevoStartFlowInitial);

    /**
     * Metodo de interface para modificar la lista de flujos del chatbot
     * @param nuevosFlows
     */
    void setFlows(List<Flow_19800734_RomeroMartinez> nuevosFlows);

    /**
     * Metodo de interface para modificar el ID del chatbot
     * @param nuevoId
     */
    void setChatbotId(int nuevoId);

    /**
     * Metodo de interface para anadir flujos al chatbot
     * @param newFlow
     */
    void addFlow(Flow_19800734_RomeroMartinez newFlow);

    /**
     * Metodo de interface para remover duplicados (flujos) en el chatbot
     */
    void removeDuplicateFlows();

    /**
     * Metodo de interface para filtrar flujos segun ID del chatbot
     * @param flowId
     */
    void filterFlowsById(int flowId);

    /**
     * Metodo de interface, auxiliar con respecto al anterior, permite realizar un flitro segun IDs
     * @param startFlowInitial
     */
    void filterFlowsByStartFlowInitial(int startFlowInitial);

    /**
     * Metodo de interface para representar al chatbot dentro del sistema
     * @return devuelve los atributos del chatbot dentro del menu en la clase menu, para ser vistas por el usuario
     */
    String toString();
}
