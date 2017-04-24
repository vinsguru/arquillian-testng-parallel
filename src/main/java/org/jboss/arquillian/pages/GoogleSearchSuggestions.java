package org.jboss.arquillian.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class GoogleSearchSuggestions {

    @FindBy(css="li div.sbqs_c")
    private List<WebElement> suggesions;

    public int getCount(){
        return suggesions.size();
    }

    public void show(){
        for(WebElement s: suggesions)
            System.out.println(s.getText());
    }

}