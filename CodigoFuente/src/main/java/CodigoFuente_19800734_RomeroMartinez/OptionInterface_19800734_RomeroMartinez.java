package CodigoFuente_19800734_RomeroMartinez;

import java.util.List;

public interface OptionInterface_19800734_RomeroMartinez {

    /**
     * Metodo de interface que implementa la obtencion del codigo de opcion
     * @return devuelve el codigo
     */
    int getCodigo();
    /**
     * Metodo de interface que implementa la obtencion del mensaje de opcion
     * @return devuelve el mensaje
     */
    String getMensaje();
    /**
     * Metodo de interface que implementa la obtencion del chatbotcodelink de opcion
     * @return devuelve el chatbotcodelink
     */
    int getChatbotCodeLink();
    /**
     * Metodo de interface que implementa la obtencion del initialflowcodelink de opcion
     * @return devuelve el initialflowcodelink
     */
    int getInitialFlowCodeLink();
    /**
     * Metodo de interface que implementa la obtencion del keywords de opcion
     * @return devuelve las keywords
     */
    List<String> getKeywords();

    /**
     * Metodo modificador que permite alterar el codigo de una opcion
     * @param nuevoCodigo
     */
    void setCodigo(int nuevoCodigo);

    /**
     * Metodo modificador que permite alterar el mensaje de una opcion
     * @param nuevoMensaje
     */
    void setMensaje(String nuevoMensaje);

    /**
     * Metodo modificador que permite alterar el chatbotcodelink de una opcion
     * @param nuevoChatbotCodeLink
     */
    void setChatbotCodeLink(int nuevoChatbotCodeLink);

    /**
     * Metodo modificador que permite alterar el initialflowcodelink de una opcion
     * @param nuevoInitialFlowCodeLink
     */
    void setInitialFlowCodeLink(int nuevoInitialFlowCodeLink);

    /**
     * Metodo modificador que permite alterar las keywords de una opcion
     * @param nuevoKeywords
     */
    void setKeywords(List<String> nuevoKeywords);

    /**
     * Metodo que busca igualdad entre opciones (para no tener repetidas)
     * @param o
     * @return devuelve opciones sin repetir
     */
    boolean equals(Object o);

    int hashCode();
    /**
     * Metodo de representacion de una opcion en el menu
     * @return Devuelve los atributos de la opcion en el menu
     */
    String toString();
}
