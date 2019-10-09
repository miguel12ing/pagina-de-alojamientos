package com.choucair.formacion.steps;

import com.choucair.formacion.pageobjects.ReservarAlojamientoPage;
import net.thucydides.core.annotations.Step;

public class ReservarAlojamientoStep {
    ReservarAlojamientoPage reservarAlojamientoPage;

    @Step
    public void abrirExplorador() {
        reservarAlojamientoPage.open();
    }

    @Step
    public void llenarFormulario() {
        reservarAlojamientoPage.llenarInformacion();
        reservarAlojamientoPage.escogerFechas();
        reservarAlojamientoPage.huespedes();
        reservarAlojamientoPage.guardar();
        reservarAlojamientoPage.buscar();
        reservarAlojamientoPage.EscogerNumeroDepaginaAleatorio();
    }
}
