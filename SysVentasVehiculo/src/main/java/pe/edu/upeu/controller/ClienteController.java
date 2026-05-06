package pe.edu.upeu.controller;

import jakarta.inject.Inject;
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
    //int index=-1;
    String dni="";

    @Inject
    ClienteService cs;

    @FXML
    public void initialize(){
        definirColumnas();
        listar();
        agregarEventoSeleccion();
        desacActBotton(true);
        btnEliminar.setOnAction(e->{
            if(!dni.equals("")){
                cs.delete(dni);
                listar();
                limpiarForm();
                desacActBotton(true);
            }
        });
        btnLimpiar.setOnAction(e->{
            limpiarForm();
        });
        btnGuardar.setOnAction(e->{
            guardarCliente();
        });
        btnActualizar.setOnAction(e->{
            if (!dni.equals("")){
                guardarCliente();
                desacActBotton(true);
            }
        });
    }

    void desacActBotton(boolean valor){
        btnActualizar.setDisable(valor);
        btnEliminar.setDisable(valor);
    }


    void guardarCliente(){
        Cliente c=new Cliente();
        c.setIdDni(txtDni.getText());
        c.setNombre(txtNombre.getText());
        c.setTelefono(txtTelefono.getText());
        c.setEmail(txtEmail.getText());
        if(dni.equals("")){
            cs.save(c);
            limpiarForm();
        }else{
            c.setIdDni(dni);
            cs.update(c);
            limpiarForm();
            dni="";
        }
        listar();
    }

    void limpiarForm(){
        txtDni.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
        dni="";
        regClienteTabla.getSelectionModel().clearSelection();
        desacActBotton(true);
        btnGuardar.setDisable(false);
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
        clientes= FXCollections.observableArrayList(cs.findAll());
        regClienteTabla.setItems(clientes);
    }

    private void agregarEventoSeleccion(){
        regClienteTabla.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue)->{
                   if(newValue!=null){
                       dni=newValue.getIdDni();
                       txtDni.setText(newValue.getIdDni());
                       txtNombre.setText(newValue.getNombre());
                       txtTelefono.setText(newValue.getTelefono());
                       txtEmail.setText(newValue.getEmail());
                       desacActBotton(false);
                       btnGuardar.setDisable(true);
                   }
                });
    }


}
