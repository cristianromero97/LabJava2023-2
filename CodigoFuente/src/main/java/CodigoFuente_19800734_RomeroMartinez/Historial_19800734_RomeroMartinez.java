package CodigoFuente_19800734_RomeroMartinez;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Historial_19800734_RomeroMartinez implements HistorialInterface_19800734_RomeroMartinez {
    private String nombreUsuario;
    private LocalDateTime timestamp;
    private String flujo;
    private String respuestaChatbot;

    private List<String> keywords;

    /**
     * Constructor Historial o history anexado a la clase Sistema, sirve para ir guardando las interacciones
     * @param nombreUsuario
     * @param timestamp
     * @param flujo
     * @param respuestaChatbot
     * @param keywords
     */
    public Historial_19800734_RomeroMartinez(String nombreUsuario, LocalDateTime timestamp, String flujo, String respuestaChatbot,List<String> keywords) {
        this.nombreUsuario = nombreUsuario;
        this.timestamp = timestamp;
        this.flujo = flujo;
        this.respuestaChatbot = respuestaChatbot;
        this.keywords = new ArrayList<>(keywords);
    }

    /**
     * Metodo selector para obtener el nombre del usuario
     * @return devuelve el nombre del usuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Metodo selector para obtener las keywords de opciones
     * @return devuelve la keyword al historial
     */
    public List<String> getKeywords() {
        return new ArrayList<>(keywords);
    }

    /**
     * Metodo selector para obtener la fecha ingresada al historial
     * @return devuelve la fecha especifica de la interaccion
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * Metodo selector para obtener el flujo de la interaccion
     * @return devuelve el flujo o flow
     */
    public String getFlujo() {
        return flujo;
    }

    /**
     * Metodo selector para obtener la respuesta o mensaje de la opcion
     * @return devuelve dicho mensaje
     */
    public String getRespuestaChatbot() {
        return respuestaChatbot;
    }

    /**
     * Metodo de visualizacion del history se complementa con sintesis
     * @return devuelve el historial del usuario
     */
    @Override
    public String toString() {
        return timestamp + " ROL " + nombreUsuario + ": " +  "\n" +
                "->" + flujo + "\n" + "->" + respuestaChatbot + "\n" + "->"+ keywords;
    }
}
