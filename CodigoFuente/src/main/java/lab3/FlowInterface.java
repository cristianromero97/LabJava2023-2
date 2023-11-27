package lab3;

import java.util.List;

public interface FlowInterface {

    int getId();

    String getMsg();

    List<Option> getOptions();

    void setId(int newId);

    void setMsg(String newMsg);

    void setOptions(List<Option> newOptions);

    void addOption(Option newOption);
}

