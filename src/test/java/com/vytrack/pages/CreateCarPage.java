package com.vytrack.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BrowserUtils;
import utils.Driver;

public class CreateCarPage extends BasePage {

    @FindBy(css = "[id^='custom_entity_type_LicensePlate']")
    public WebElement licensePlateElement;

    @FindBy(name = "custom_entity_type[Driver]")
    public WebElement driverElement;

    @FindBy(name = "custom_entity_type[Location]")
    public WebElement locationElelement;

    @FindBy(xpath = "//div[@class='btn-group pull-right']/button[contains(text(),'Save and Close')]")
    public WebElement saveAndCloseButtonElement;

    @FindBy(css = "div[id*='FuelType']")
    public WebElement fuelTypeElement;

    @FindBy(name = "[name='custom_entity_type[Logo][file]']>span[class='action']")
    public WebElement logoElement;

    @FindBy(name = "custom_entity_type[ModelYear]")
    public WebElement modelYearElement;

    @FindBy(name = "custom_entity_type[Color]")
    public WebElement colorElement;


    //this method stands for selecting tags
    //Provide tag name to select
    // if checkbox already selected, it will not do anything


     // calling method:
    // WebElement element = selectTags("Senior");
    //or
    //CreateCarPage createCarPAge = new CreateCarPage();
    //createCarPage.selectTags("Senior"); Senior tag will be selected
    public WebElement selectTags(String tagName){
        //locator for checkbox is based on label name
        //label and checkbox are siblings
        String locator = "//label[text()='" +tagName+ "']/preceding-sibling::input[@type= 'checkbox']";
        WebElement checkBox = Driver.get().findElement(By.xpath(locator));
        BrowserUtils.waitForVisibility(checkBox, 15);
        BrowserUtils.waitForClickablility(checkBox, 15);
        if(!checkBox.isSelected()){
            checkBox.click();
        }
        return checkBox; //return webelement of checkbox that was selected
    }

    /*
    this method select fuel type by visible type
    @param fuelType - Diesel, Electric, Hybrid
    usage : CreateCarPage createCarPage = new CreateCarPage();

    to select gasoline type
    createCarPage.selectFuelType("Diesel"); - if diesel is wanted
     */
    public void selectFuleType(String fuelType){
        String locator = "//div[@class='select2-result-label' and text()='"+fuelType+"']";
        BrowserUtils.waitForClickablility(fuelTypeElement, 15);
        fuelTypeElement.click();
        WebElement fuelTypeSelectionElement = Driver.get().findElement(By.xpath(locator));
        BrowserUtils.waitForClickablility(fuelTypeSelectionElement, 15);
        fuelTypeSelectionElement.click();

    }


    /*
    this method will upload a file
    file from your computer
    @param pathToTheFile that you want to upload
     */
    public void uploadLogo(String pathToTheFile){
        BrowserUtils.waitForVisibility(logoElement, 15);
        logoElement.sendKeys(pathToTheFile);
    }
}
