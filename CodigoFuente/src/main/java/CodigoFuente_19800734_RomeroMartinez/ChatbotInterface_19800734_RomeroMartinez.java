package CodigoFuente_19800734_RomeroMartinez;

import java.util.List;

public interface ChatbotInterface_19800734_RomeroMartinez {

    int getChatbotId();

    String getNombre();

    String getMensajeBienvenida();

    int getStartFlowInitial();

    List<Flow_19800734_RomeroMartinez> getFlows();

    void setNombre(String nuevoNombre);

    void setMensajeBienvenida(String nuevoMensajeBienvenida);

    void setStartFlowInitial(int nuevoStartFlowInitial);

    void setFlows(List<Flow_19800734_RomeroMartinez> nuevosFlows);

    void setChatbotId(int nuevoId);

    void addFlow(Flow_19800734_RomeroMartinez newFlow);

    void removeDuplicateFlows();

    void filterFlowsById(int flowId);

    void filterFlowsByStartFlowInitial(int startFlowInitial);

    String toString();
}
