package lab3;

import java.util.List;

import java.util.List;

public interface ChatbotInterface {

    int getChatbotId();

    String getNombre();

    String getMensajeBienvenida();

    int getStartFlowInitial();

    List<Flow> getFlows();

    void setNombre(String nuevoNombre);

    void setMensajeBienvenida(String nuevoMensajeBienvenida);

    void setStartFlowInitial(int nuevoStartFlowInitial);

    void setFlows(List<Flow> nuevosFlows);

    void addFlow(Flow newFlow);

    void removeDuplicateFlows();

    void filterFlowsById(int flowId);

    void filterFlowsByStartFlowInitial(int startFlowInitial);
}
