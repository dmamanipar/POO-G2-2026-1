package pe.edu.upeu.controller;

import io.micronaut.http.annotation.Controller;
import jakarta.inject.Inject;
import jakarta.validation.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import pe.edu.upeu.component.ToltipCustom;
import pe.edu.upeu.component.validation.DniUnicoValidator;
import pe.edu.upeu.model.Cliente;
import pe.edu.upeu.service.ClienteService;
import pe.edu.upeu.service.ClienteServiceImp;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


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

        initValidation();

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
            guardarCliente(false);
        });
        btnActualizar.setOnAction(e->{
            if (!dni.equals("")){
                guardarCliente(true);
                desacActBotton(true);
            }
        });
    }

    private Validator validator;
    ToltipCustom ttc=new ToltipCustom();

    private void initValidation(){
        Configuration<?> config= Validation.byDefaultProvider().configure();
        config.constraintValidatorFactory(new ConstraintValidatorFactory() {
            @Override
            public <T extends ConstraintValidator<?, ?>> T getInstance(Class<T> key) {
                if(key== DniUnicoValidator.class){
                    DniUnicoValidator v=new DniUnicoValidator();
                    v.initialize(cs);
                    return key.cast(v);
                }

                try {
                    return  key.getDeclaredConstructor().newInstance();
                } catch (Exception e) {
                    throw new RuntimeException("No se puede instanciar:"+ key, e);
                }
            }
            @Override
            public void releaseInstance(ConstraintValidator<?, ?> instance) {
            }
        });
        validator=config.buildValidatorFactory().getValidator();
    }

    private void limpiarCampo(TextField campo){
        campo.setStyle(ttc.ESTILO_NORMAL);
        Tooltip.install(campo,null);
    }
    private boolean validar(Cliente c, boolean esActualizar){
        limpiarForm();
        Set<ConstraintViolation<Cliente>> violations=validator.validate(c);
        Map<String, StringBuilder> mensajesporCampo=new HashMap<>();
        for(ConstraintViolation<Cliente> v: violations){
            String campo=v.getPropertyPath().toString();
            String anotation=v.getConstraintDescriptor().getAnnotation()
                    .annotationType().getSimpleName();
            if(esActualizar) continue;
            mensajesporCampo.computeIfAbsent(campo, k->new StringBuilder())
                    .append(v.getMessage()).append(" ");
        }
        if(mensajesporCampo.isEmpty()) return true;
        mensajesporCampo.forEach((campo, msg)->{
            String texto=msg.toString().trim();
            switch (campo){
                case "idDni" ->ttc.marcarError(txtDni, texto);
                case "nombre" ->ttc.marcarError(txtNombre, texto);
                case "telefono" ->ttc.marcarError(txtTelefono, texto);
                case "email" ->ttc.marcarError(txtEmail, texto);
            }
        });
        return false;
    }

    void desacActBotton(boolean valor){
        btnActualizar.setDisable(valor);
        btnEliminar.setDisable(valor);
    }
    boolean guardarCliente(boolean esActualizar){

        Cliente c=new Cliente();
        c.setIdDni(txtDni.getText());
        c.setNombre(txtNombre.getText());
        c.setTelefono(txtTelefono.getText());
        c.setEmail(txtEmail.getText());

        if(!validar(c, esActualizar)) return false;
        System.out.println(dni);
        if(dni.isEmpty()){
            cs.save(c);
            limpiarForm();
            limpiar();
        }else{
            c.setIdDni(dni);
            cs.update(c);
            limpiarForm();
            dni="";
            limpiar();
        }
        listar();
        return true;
    }

    private void limpiar(){
        txtDni.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
        dni="";
        regClienteTabla.getSelectionModel().clearSelection();
        desacActBotton(true);
        btnGuardar.setDisable(false);
        limpiarForm();
    }
    void limpiarForm(){
        limpiarCampo(txtDni);
        limpiarCampo(txtNombre);
        limpiarCampo(txtTelefono);
        limpiarCampo(txtEmail);
        //dni="";
        //regClienteTabla.getSelectionModel().clearSelection();
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
