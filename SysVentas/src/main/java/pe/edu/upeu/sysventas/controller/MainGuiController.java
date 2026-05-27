package pe.edu.upeu.sysventas.controller;

import pe.edu.upeu.sysventas.service.IMenuMenuItemDao;

public class MainGuiController {
    private final IMenuMenuItemDao sv;

    public MainGuiController(IMenuMenuItemDao sv) {
        this.sv = sv;
    }
}
