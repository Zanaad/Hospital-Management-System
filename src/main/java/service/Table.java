package service;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class Table {
    public static void staffDisplayData(TableColumn<?, ?> colID, TableColumn<?, ?> colName, TableColumn<?, ?> colSurname, TableColumn<?, ?> colDepartment, TableColumn<?, ?> colPhone, TableColumn<?, ?> colEmail, TableColumn<?, ?> colUniversity, TableColumn<?, ?> colAddress) {
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colSurname.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colDepartment.setCellValueFactory(new PropertyValueFactory<>("department"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colUniversity.setCellValueFactory(new PropertyValueFactory<>("university"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
    }

    public static void doctorDisplayData(TableColumn<?, ?> colID, TableColumn<?, ?> colName, TableColumn<?, ?> colSurname, TableColumn<?, ?> colDepartment, TableColumn<?, ?> colPhone, TableColumn<?, ?> colEmail, TableColumn<?, ?> colUniversity, TableColumn<?, ?> colSpecialty, TableColumn<?, ?> colAddress) {
        staffDisplayData(colID, colName, colSurname, colDepartment, colPhone, colEmail, colUniversity, colAddress);
        colSpecialty.setCellValueFactory(new PropertyValueFactory<>("specialty"));
    }
}
