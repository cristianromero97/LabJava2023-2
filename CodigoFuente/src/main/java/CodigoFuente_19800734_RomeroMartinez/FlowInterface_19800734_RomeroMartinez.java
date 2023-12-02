package CodigoFuente_19800734_RomeroMartinez;

import java.util.List;

public interface FlowInterface_19800734_RomeroMartinez {
    /**
     * Metodo de interface para obtener el ID de un flujo
     * @return devuelve el ID del flujo
     */
    int getId();
    /**
     * Metodo de interface para obtener el mensaje de un flujo
     * @return devuelve el mensaje del flujo
     */
    String getMsg();
    /**
     * Metodo de interface para obtener las opciones fijadas a un flujo
     * @return devuelve las opciones dentro del flujo
     */
    List<Option_19800734_RomeroMartinez> getOptions();
    /**
     * Metodo de interface para modificar el ID de un flujo
     * @param newId
     */
    void setId(int newId);
    /**
     * Metodo de interface para modificar el mensaje de un flujo
     * @param newMsg
     */
    void setMsg(String newMsg);
    /**
     * Metodo de interface para modificar las opciones de un flujo
     * @param newOptions
     */
    void setOptions(List<Option_19800734_RomeroMartinez> newOptions);
    /**
     * Metodo de interface para añadir opciones a un flujo
     * @param newOption
     */
    void addOption(Option_19800734_RomeroMartinez newOption);
    /**
     * Metodo de interface para filtrar opciones de un flujo
     */
    void filterOptions();
    /**
     * Metodo de interface para remover duplicados de un flujo
     */
    void removeDuplicates();
    /**
     * Metodo de interface para entregar un representacion de los atributos de un flujo dentro del menu
     * @return devuelve los atributos del menu organizado dentro de la clase menu, en el menu
     */
    String toString();
}

