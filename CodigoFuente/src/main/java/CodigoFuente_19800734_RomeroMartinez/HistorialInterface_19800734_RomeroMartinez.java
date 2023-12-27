package CodigoFuente_19800734_RomeroMartinez;

import java.time.LocalDateTime;
import java.util.List;
public interface HistorialInterface_19800734_RomeroMartinez {

    /**
     * Metodo selector de interface obtiene el nombre del usuario
     * @return devuelve el nombre
     */
    String getNombreUsuario();

    /**
     * Metodo selector de interface obtiene las keywords
     * @return devuelve las keywords
     */
    List<String> getKeywords();

    /**
     * Metodo selector de interface para obtener la fecha del historial
     * @return devuelve dicha ficha
     */
    LocalDateTime getTimestamp();

    /**
     * Metodo selector de interface para obtener el flujo del historial
     * @return devuelve el flujo
     */
    String getFlujo();

    /**
     * Metodo selector de interface para obtener la respuesta o mensaje principal de opcion del historial
     * @return devuelve dicho mensaje
     */
    String getRespuestaChatbot();

    /**
     * Metodo de representacion grafica del historial
     * @return devuelve el historial por consola
     */
    String toString();
}
