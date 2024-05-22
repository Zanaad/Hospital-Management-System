package controller;

import app.Navigator;
import database.DatabaseUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.dto.DepartmentDto;
import service.DepartmentService;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class AddDepController implements Initializable {

    @FXML
    private Button addDepartment_btn;

    @FXML
    private TableColumn<?, ?> dep_col_ID;

    @FXML
    private TableColumn<?, ?> dep_col_desc;

    @FXML
    private TableColumn<?, ?> dep_col_emp;

    @FXML
    private TableColumn<?, ?> dep_col_name;

    @FXML
    private AnchorPane department_form;

    @FXML
    private TableView<DepartmentDto> department_table;

    @FXML
    private TextArea txtDepartmentDescription;

    @FXML
    private TextField txtDepartmentName;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        depDisplayData();
    }

    public ObservableList<DepartmentDto> getDepartments() {
        ObservableList<DepartmentDto> listDepartments = FXCollections.observableArrayList();
        String query = "select * from departments";
        Connection con = DatabaseUtil.getConnection();
        try {
            PreparedStatement prepare = con.prepareStatement(query);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                DepartmentDto depData = new DepartmentDto(result.getString("department_name"), result.getString("department_description"));
                listDepartments.add(depData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDepartments;
    }

    public void depDisplayData() {
        dep_col_name.setCellValueFactory(new PropertyValueFactory<>("departmentName"));
        dep_col_desc.setCellValueFactory(new PropertyValueFactory<>("departmentDescription"));
        department_table.setItems(getDepartments());
    }

    @FXML
    void registerDepartment(ActionEvent event) {
        DepartmentDto department = new DepartmentDto(this.txtDepartmentName.getText(), this.txtDepartmentDescription.getText());
        boolean departmentCreated = DepartmentService.createDepartment(department);
        if (departmentCreated) Navigator.navigate(event, Navigator.AdminMainForm);
    }

}
