package pe.edu.upeu.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import pe.edu.upeu.model.Cliente;
import pe.edu.upeu.service.ClienteService;
import pe.edu.upeu.service.ClienteServiceImp;

public class ClienteController {
    @FXML
    Button btnGuardar, btnActualizar, btnLimpiar, btnEliminar;
    @FXML
    TextField txtDni, txtNombre, txtTelefono, txtEmail, txtBuscar;
    @FXML
    TableView<Cliente> regClienteTabla;
    private TableColumn<Cliente, String> colDni, colNombre, colTelefono, colEmail;
    ObservableList<Cliente> clientes;
    int index=-1;
    ClienteService cs=ClienteServiceImp.getInstance();
    @FXML
    public void initialize(){
        definirColumnas();
        listar();
        agregarEventoSeleccion();
        btnEliminar.setOnAction(e->{
            if(index!=-1){
                cs.delete(index);
                listar();
                limiparForm();
            }
        });
        btnLimpiar.setOnAction(e->{
            limiparForm();
        });
    }
    void limiparForm(){
        txtDni.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
    }

    public void definirColumnas(){
        colDni=new TableColumn<>("DNI");
        colNombre=new TableColumn<>("Nombre");
        colTelefono=new TableColumn<>("Telefono");
        colEmail=new TableColumn<>("Email");
        regClienteTabla.getColumns().addAll(colDni, colNombre, colTelefono, colEmail);
    }

    private void listar(){
        colDni.setCellValueFactory(
                cellData->new SimpleStringProperty(cellData.getValue().getIdDni()));
        colNombre.setCellValueFactory(
                cellData->new SimpleStringProperty(cellData.getValue().getNombre()));
        colTelefono.setCellValueFactory(
                cellData->new SimpleStringProperty(cellData.getValue().getTelefono()));
        colEmail.setCellValueFactory(
                cellData->new SimpleStringProperty(cellData.getValue().getEmail()));
        clientes= FXCollections.observableArrayList(cs.finAll());
        regClienteTabla.setItems(clientes);
    }

    private void agregarEventoSeleccion(){
        regClienteTabla.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue)->{
                   if(newValue!=null){
                       index=regClienteTabla.getItems().indexOf(newValue);
                       txtDni.setText(newValue.getIdDni());
                       txtNombre.setText(newValue.getNombre());
                       txtTelefono.setText(newValue.getTelefono());
                       txtEmail.setText(newValue.getEmail());
                   }
                });
    }


}
