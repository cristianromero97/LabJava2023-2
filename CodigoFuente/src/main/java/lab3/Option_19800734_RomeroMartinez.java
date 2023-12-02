package lab3;

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
    /*public static void main(String[] args) {
        // Example usage
        Option option1 = new Option(1, "Hello", 123, 456, List.of("keyword1", "keyword2"));
        Option option2 = new Option(2, "Hi", 789, 101, List.of("keyword3", "keyword4"));

        List<Option> optionsList = new ArrayList<>();
        optionsList = Option.addOptionToOption(option1, optionsList);
        optionsList = Option.addOptionToOption(option2, optionsList);

        // Accessing option details
        for (Option option : optionsList) {
            System.out.println("Codigo: " + option.getCodigo());
            System.out.println("Mensaje: " + option.getMensaje());
            System.out.println("ChatbotCodeLink: " + option.getChatbotCodeLink());
            System.out.println("InitialFlowCodeLink: " + option.getInitialFlowCodeLink());
            System.out.println("Keywords: " + option.getKeywords());
            System.out.println("---------------");
        }
    }*/
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