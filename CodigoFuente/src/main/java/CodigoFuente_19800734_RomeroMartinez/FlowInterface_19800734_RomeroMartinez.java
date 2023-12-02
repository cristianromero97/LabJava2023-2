package CodigoFuente_19800734_RomeroMartinez;

import java.util.List;

public interface FlowInterface_19800734_RomeroMartinez {

    int getId();

    String getMsg();

    List<Option_19800734_RomeroMartinez> getOptions();

    void setId(int newId);

    void setMsg(String newMsg);

    void setOptions(List<Option_19800734_RomeroMartinez> newOptions);

    void addOption(Option_19800734_RomeroMartinez newOption);

    void filterOptions();
    
    void removeDuplicates();

    String toString();
}

