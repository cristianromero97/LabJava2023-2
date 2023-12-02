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

    // Constructor
    public Option_19800734_RomeroMartinez(int codigo, String mensaje, int chatbotCodeLink, int initialFlowCodeLink, List<String> keywords) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.chatbotCodeLink = chatbotCodeLink;
        this.keywords = new ArrayList<>(keywords);
    }

    // Getter methods
    public int getCodigo() {
        return codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public int getChatbotCodeLink() {
        return chatbotCodeLink;
    }

    public int getInitialFlowCodeLink() {
        return initialFlowCodeLink;
    }

    public List<String> getKeywords() {
        return new ArrayList<>(keywords);
    }

    // Modifier methods
    public void setCodigo(int nuevoCodigo) {
        this.codigo = nuevoCodigo;
    }

    public void setMensaje(String nuevoMensaje) {
        this.mensaje = nuevoMensaje;
    }

    public void setChatbotCodeLink(int nuevoChatbotCodeLink) {
        this.chatbotCodeLink = nuevoChatbotCodeLink;
    }

    public void setInitialFlowCodeLink(int nuevoInitialFlowCodeLink) {
        this.initialFlowCodeLink = nuevoInitialFlowCodeLink;
    }

    public void setKeywords(List<String> nuevoKeywords) {
        this.keywords = new ArrayList<>(nuevoKeywords);
    }
    public static List<Option_19800734_RomeroMartinez> addOptionToOption(Option_19800734_RomeroMartinez nuevaOption, List<Option_19800734_RomeroMartinez> options) {
        List<Option_19800734_RomeroMartinez> listaActualizada = new ArrayList<>(options);
        listaActualizada.add(nuevaOption);
        return listaActualizada;
    }
    // Override equals and hashCode
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
    @Override
    public int hashCode() {
        return Objects.hash(codigo, mensaje, chatbotCodeLink, initialFlowCodeLink, keywords);
    }
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
