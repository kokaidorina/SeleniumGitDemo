package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DualListPage {

    WebDriver driver;

    public DualListPage(WebDriver driver){
        this.driver=driver;
    }
    private final String url="https://demo.seleniumeasy.com/bootstrap-dual-list-box-demo.html";
    private final By serchInputFieldLeft= By.xpath("//div[@class='dual-list list-left col-md-5']//input[@name='SearchDualList']");
    private final By selectButtonLeft=By.xpath("//div[@class='dual-list list-left col-md-5']//a");
    private final By addItem=By.xpath("//button[@class='btn btn-default btn-sm move-right']");
    private final By rightList= By.xpath("//div[@class='dual-list list-right col-md-5']");
    private String rightListElement = "//div[@class='dual-list list-right col-md-5']//input/following::li[contains(text(),'%s')]";

    public void navigate(){
        driver.navigate().to(url);
    }
    public void searchLeft(String message){
        driver.findElement(serchInputFieldLeft).sendKeys(message);

    }
    public void addToRightList(){
        driver.findElement(selectButtonLeft).click();
        driver.findElement(addItem).click();
    }
    public boolean findInRightList(String testData){
        try{
            rightListElement =String.format(rightListElement,testData);
             //  rigtListElement=rigtListElement.replace("%s", testData);
            driver.findElement(By.xpath(rightListElement));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
