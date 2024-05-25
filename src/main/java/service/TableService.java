package service;

import controller.EditController;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.dto.StaffDto.DoctorDto;
import model.dto.StaffDto.NurseDto;
import model.dto.StaffDto.ReceptionistDto;
import model.dto.StaffDto.StaffDto;
import javafx.util.Callback;
import repository.Staff.DoctorRepository;
import repository.Staff.NurseRepository;
import repository.Staff.ReceptionistRepository;
import service.Staff.DepartmentService;

import java.io.File;
import java.net.URL;

public class TableService {
    public static void staffDisplayData(TableView<?> tableView, TableColumn<?, ?> colID, TableColumn<?, ?> colName, TableColumn<?, ?> colSurname, TableColumn<?, ?> colDepartment, TableColumn<?, ?> colPhone, TableColumn<?, ?> colEmail, TableColumn<?, ?> colUniversity, TableColumn<?, ?> colAddress, TableColumn<StaffDto, Void> colAction) {
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colSurname.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colDepartment.setCellValueFactory(new PropertyValueFactory<>("department"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colUniversity.setCellValueFactory(new PropertyValueFactory<>("university"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colAction.setCellFactory(createButtonCellFactory(tableView));
    }

    public static void doctorDisplayData(TableView<?> tableView, TableColumn<?, ?> colID, TableColumn<?, ?> colName, TableColumn<?, ?> colSurname, TableColumn<?, ?> colDepartment, TableColumn<?, ?> colPhone, TableColumn<?, ?> colEmail, TableColumn<?, ?> colUniversity, TableColumn<?, ?> colSpecialty, TableColumn<?, ?> colAddress, TableColumn<StaffDto, Void> colActions) {
        staffDisplayData(tableView, colID, colName, colSurname, colDepartment, colPhone, colEmail, colUniversity, colAddress, colActions);
        colSpecialty.setCellValueFactory(new PropertyValueFactory<>("specialty"));
    }

    private static Callback<TableColumn<StaffDto, Void>, TableCell<StaffDto, Void>> createButtonCellFactory(TableView<?> tableView) {
        return new Callback<TableColumn<StaffDto, Void>, TableCell<StaffDto, Void>>() {
            @Override
            public TableCell<StaffDto, Void> call(final TableColumn<StaffDto, Void> param) {
                return new TableCell<StaffDto, Void>() {
                    private final Button editButton = new Button();
                    private final Button deleteButton = new Button();

                    {
                        FontAwesomeIcon editIcon = new FontAwesomeIcon();
                        editIcon.setGlyphName("PENCIL");
                        editButton.setGraphic(editIcon);
                        FontAwesomeIcon deleteIcon = new FontAwesomeIcon();
                        deleteIcon.setGlyphName("TRASH");
                        deleteButton.setGraphic(deleteIcon);

                        editButton.setOnAction(event -> {
                            StaffDto staff = getTableView().getItems().get(getIndex());
                            try {
                                URL url = new File("src/main/resources/app/Edit.fxml").toURI().toURL();
                                FXMLLoader loader = new FXMLLoader(url);
                                Parent root = loader.load();
                                Scene scene = new Scene(root);

                                EditController controller = loader.getController();
                                controller.setStaff(staff);
                                Stage stage = (Stage) editButton.getScene().getWindow();
                                stage.setScene(scene);

                                stage.show();

                                tableView.refresh();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });

                        deleteButton.setOnAction(event -> {
                            StaffDto staff = getTableView().getItems().get(getIndex());
                            if (staff instanceof DoctorDto) {
                                boolean success = DoctorRepository.deleteDoctor(staff.getId());
                                if (success) {
                                    tableView.getItems().remove(staff);
                                    DepartmentService.updateDepTable(staff.getDepartment());
                                } else {
                                    Alerts.errorMessage("Doctor was not deleted!");
                                }
                            } else if (staff instanceof NurseDto) {
                                boolean success = NurseRepository.deleteNurse(staff.getId());
                                if (success) {
                                    tableView.getItems().remove(staff);
                                    DepartmentService.updateDepTable(staff.getDepartment());
                                } else {
                                    Alerts.errorMessage("Nurse was not deleted!");
                                }
                            } else if (staff instanceof ReceptionistDto) {
                                boolean success = ReceptionistRepository.deleteRec(staff.getId());
                                if (success) {
                                    tableView.getItems().remove(staff);
                                } else {
                                    Alerts.errorMessage("Receptionist was not deleted!");
                                }
                            }
                        });

                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) setGraphic(null);
                        else setGraphic(new HBox(editButton, deleteButton));
                    }
                };
            }
        };
    }
}
