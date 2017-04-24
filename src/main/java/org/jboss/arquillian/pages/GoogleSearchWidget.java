package org.jboss.arquillian.pages;

import org.jboss.arquillian.graphene.Graphene;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchWidget {

    @FindBy(name="q")
    private WebElement searchBox;

    @FindBy(name="btnG")
    private WebElement searchButton;

    public void searchFor(String searchString){
        searchBox.clear();

        //Google makes ajax calls during search
        int length = searchString.length();
        searchBox.sendKeys(searchString.substring(0, length-1));
        Graphene.guardAjax(searchBox).sendKeys(searchString.substring(length-1));
    }

    public void search(){
        Graphene.guardAjax(searchButton).click();
    }
}