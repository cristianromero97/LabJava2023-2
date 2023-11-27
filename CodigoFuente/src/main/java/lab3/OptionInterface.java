package lab3;

import java.util.List;

public interface OptionInterface {

    int getCodigo();

    String getMensaje();

    int getChatbotCodeLink();

    int getInitialFlowCodeLink();

    List<String> getKeywords();

    void setCodigo(int nuevoCodigo);

    void setMensaje(String nuevoMensaje);

    void setChatbotCodeLink(int nuevoChatbotCodeLink);

    void setInitialFlowCodeLink(int nuevoInitialFlowCodeLink);

    void setKeywords(List<String> nuevoKeywords);
}
