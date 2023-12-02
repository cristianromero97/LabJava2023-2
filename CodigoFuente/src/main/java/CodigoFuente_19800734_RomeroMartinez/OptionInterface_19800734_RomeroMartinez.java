package CodigoFuente_19800734_RomeroMartinez;

import java.util.List;

public interface OptionInterface_19800734_RomeroMartinez {

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

    boolean equals(Object o);

    int hashCode();
    
    String toString();
}
