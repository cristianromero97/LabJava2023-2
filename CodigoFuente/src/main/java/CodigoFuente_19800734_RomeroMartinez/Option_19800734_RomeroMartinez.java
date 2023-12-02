package CodigoFuente_19800734_RomeroMartinez;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Option_19800734_RomeroMartinez implements OptionInterface_19800734_RomeroMartinez {

    private int codigo;
    private String mensaje;
    private int chatbotCodeLink;
    private int initialFlowCodeLink;
    private List<String> keywords;

    /**
     * Constructor de opciones
     * @param codigo
     * @param mensaje
     * @param chatbotCodeLink
     * @param initialFlowCodeLink
     * @param keywords
     */
    public Option_19800734_RomeroMartinez(int codigo, String mensaje, int chatbotCodeLink, int initialFlowCodeLink, List<String> keywords) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.chatbotCodeLink = chatbotCodeLink;
        this.keywords = new ArrayList<>(keywords);
    }
    /**
     * Metodo selector para obtener el codigo de la opcion
     * @return devuelve el codigo de la opcion
     */
    public int getCodigo() {
        return codigo;
    }
    /**
     * Metodo selector para obtener el mensaje de la opcion
     * @return devuelve el mensaje de la opcion
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Metodo selector para obtener el chatbotcodelink al cual esta vinculado la opcion con respecto a su chatbot
     * @return devuelve el chatbotcodelink
     */
    public int getChatbotCodeLink() {
        return chatbotCodeLink;
    }

    /**
     * Metodo selector para obtener el initialflowcodelink al cual esta vinculado la opcion con respecto a su flujo
     * @return devuelve el initialflowcodelink
     */
    public int getInitialFlowCodeLink() {
        return initialFlowCodeLink;
    }

    /**
     * Metodo selector para obtener una list de keywords o sinonimos de una opcion definida
     * @return devuelve una lista de keywords (sinonimos)
     */
    public List<String> getKeywords() {
        return new ArrayList<>(keywords);
    }

    /**
     * Metodo modificador para el codigo de la opcion
     * @param nuevoCodigo
     */
    public void setCodigo(int nuevoCodigo) {
        this.codigo = nuevoCodigo;
    }

    /**
     * Metodo modificador para el mensaje de la opcion
     * @param nuevoMensaje
     */
    public void setMensaje(String nuevoMensaje) {
        this.mensaje = nuevoMensaje;
    }

    /**
     * Metodo modificador para el chatbotcodelink de la opcionv
     * @param nuevoChatbotCodeLink
     */
    public void setChatbotCodeLink(int nuevoChatbotCodeLink) {
        this.chatbotCodeLink = nuevoChatbotCodeLink;
    }

    /**
     * Metodo modificador para el initialflowcodelink de la opcion
     * @param nuevoInitialFlowCodeLink
     */
    public void setInitialFlowCodeLink(int nuevoInitialFlowCodeLink) {
        this.initialFlowCodeLink = nuevoInitialFlowCodeLink;
    }

    /**
     * Metodo modificador para la lista de keywords(sinonimos) de la opcion
     * @param nuevoKeywords
     */
    public void setKeywords(List<String> nuevoKeywords) {
        this.keywords = new ArrayList<>(nuevoKeywords);
    }

    /**
     * Metodo addopcion para añadir una opcion por sobre otra opcion, es decir, opciones de opciones en una lista nueva
     * @param nuevaOption
     * @param options
     * @return devuelve una lista con todas las opciones creadas
     */
    public static List<Option_19800734_RomeroMartinez> addOptionToOption(Option_19800734_RomeroMartinez nuevaOption, List<Option_19800734_RomeroMartinez> options) {
        List<Option_19800734_RomeroMartinez> listaActualizada = new ArrayList<>(options);
        listaActualizada.add(nuevaOption);
        return listaActualizada;
    }
    // Override equals and hashCode

    /**
     * Metodo de sobreescritur para opciones iguales, en caso de encontrar similitudes de opciones
     * @param o
     * @return deuelve los atributos actualizados
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Option_19800734_RomeroMartinez option = (Option_19800734_RomeroMartinez) o;
        return codigo == option.codigo &&
                chatbotCodeLink == option.chatbotCodeLink &&
                initialFlowCodeLink == option.initialFlowCodeLink &&
                Objects.equals(mensaje, option.mensaje) &&
                Objects.equals(keywords, option.keywords);
    }

    /**
     *  Metodo que retorna la opcion de unica (para casos duplicados)
     * @return devuelve la opcion con sus atributos una vez alcanzada la igualdad
     */
    @Override
    public int hashCode() {
        return Objects.hash(codigo, mensaje, chatbotCodeLink, initialFlowCodeLink, keywords);
    }

    /**
     * Metodo para usarse en el menu, representa los atributos de opciones creados por el usuario
     * @return  devuelve una representacion de la opcion en el menu para el usuario
     */
    @Override
    public String toString() {
        return "Option{" +
                "codigo=" + codigo +
                ", mensaje='" + mensaje + '\'' +
                ", chatbotCodeLink=" + chatbotCodeLink +
                ", initialFlowCodeLink=" + initialFlowCodeLink +
                ", keywords=" + keywords +
                '}';
    }
}
