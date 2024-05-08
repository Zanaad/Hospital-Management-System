package service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;
import java.util.List;

public class ChoiceBox {

    public static void ChoiceBoxList(ComboBox<?>combox,String [] items){
        List<String> list=new ArrayList<>();
        for(String d:items) list.add(d);
        ObservableList listData= FXCollections.observableList(list);
        combox.setItems(listData);
    }
}
