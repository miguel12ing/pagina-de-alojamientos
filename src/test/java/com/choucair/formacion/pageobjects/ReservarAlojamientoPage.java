package com.choucair.formacion.pageobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.WebElementFacadeImpl;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.regex.Pattern;

@DefaultUrl("https://www.airbnb.com.co/")


public class ReservarAlojamientoPage extends PageObject {

    @FindBy(xpath = "//*[@id='Koan-magic-carpet-koan-search-bar__input']")
    WebElementFacade clickDonde;

    @FindBy(xpath = "//div[@class='_1h5uiygl']")
    WebElementFacade pagFechaSiguiente;

    @FindBy(xpath = "//div[@data-visible='true']//strong")
    WebElementFacade lblNombreMesEntrada;

    @FindBy(xpath = "//td[contains(text(),'31')]")
    WebElementFacade dateFechaLlegada;

    @FindBy(xpath = "//td[@class='_16zigr23'][contains(text(),'10')]")
    WebElementFacade dateFechaSalida;

    @FindBy(xpath = "//div[@class='_j1kt73']")
    WebElementFacade cmbHuespedes;

    @FindBy(xpath = "//div[@class='_9cfq872']//div//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//div[3]//button[1]")
    WebElementFacade btnMasAdultos;

    @FindBy(xpath = "//div[@class='_e296pg']//div[2]//div[1]//div[1]//div[1]//div[2]//div[1]//div[3]//button[1]")
    WebElementFacade btnMasNinos;

    @FindBy(xpath = "//button[@class='_b0ybw8s']")
    WebElementFacade btnGuardar;

    @FindBy(xpath = "//button[@class='_1vs0x720']")
    WebElementFacade btnBuscar;

    @FindBy(xpath = "//div[@class='_1bdke5s'][contains(text(),'2')]")
    WebElementFacade btnPagina2;

    @FindBy(xpath = "//div[@class='_1bdke5s'][contains(text(),'3')]")
    WebElementFacade btnPagina3;

    @FindBy(xpath = "//div[@itemprop='itemListElement']//*[contains(text(),'huéspedes')]")
    List<WebElementFacade> listDepartamentos;

    public void llenarInformacion() {
        Actions act = new Actions(getDriver());
        int coor = $("//button[@class='_7ykwo4']").getCoordinates().onPage().getY();
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("window.scrollTo(0," + coor + ");");


        act.moveToElement(clickDonde).click().perform();
        clickDonde.sendKeys("Kuwait City, Al Asimah, Kuwait");
        clickDonde.sendKeys(Keys.ENTER);

    }

    public void escogerFechas() {

        Actions act = new Actions(getDriver());

        for (int i = 1; i <= 12; i++) {
            String lblNombreLlegadaMesText = lblNombreMesEntrada.getTextValue();
            if (lblNombreLlegadaMesText.equals("octubre 2019")) {
                act.moveToElement(dateFechaLlegada).click().perform();

                break;

            } else {

                act.moveToElement(pagFechaSiguiente).click().perform();
            }
        }

        for (int a = 1; a <= 12; a++) {
            String lblNombreSalidaMesText = lblNombreMesEntrada.getTextValue();

            if (lblNombreSalidaMesText.equals("noviembre 2019")) {
                act.moveToElement(dateFechaSalida).click().perform();
                break;
            } else {

                act.moveToElement(pagFechaSiguiente).click().perform();
            }
        }

    }

    public void huespedes() {

        Actions act = new Actions(getDriver());
        act.moveToElement(cmbHuespedes).click().perform();
        act.moveToElement(btnMasAdultos).click().perform();
        act.moveToElement(btnMasAdultos).click().perform();
        act.moveToElement(btnMasNinos).click().perform();


    }

    public void guardar() {

        Actions act = new Actions((getDriver()));
        act.moveToElement(btnGuardar).click().perform();
    }

    public void buscar() {

        Actions act = new Actions(getDriver());
        act.moveToElement(btnBuscar).click().perform();
    }

    //@Test
    public void EscogerNumeroDepaginaAleatorio() {

        int num = (int) (Math.random() * (3 - 2) + 2);

        if (num == 2) {
            btnPagina2.click();

        }
        if (num == 3) {
            btnPagina3.click();
        }

        for (int i = 0; i < listDepartamentos.size() ; i++) {// tomanos el tamaño de la lista 

            if (Pattern.matches("[5-99]\\shuéspedes.+", listDepartamentos.get(i).getText())) {// hace un get text y compara
               // con patter machest si ka expresion tiene el mismo texto y el da click
                listDepartamentos.get(i).click();
            }
        }

    }


}