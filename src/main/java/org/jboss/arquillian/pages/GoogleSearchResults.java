package org.jboss.arquillian.pages;

import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.graphene.findby.FindByJQuery;
import org.openqa.selenium.By;

import java.util.List;

public class GoogleSearchResults {

    @FindByJQuery(".rc")
    private List<GoogleSearchResult> results;

    public int getCount(){
        return results.size();
    }

    public void show(){
        Graphene.waitGui().until().element(By.className("rc")).is().present();
        System.out.println("\nResults:\n");
        for(GoogleSearchResult result: results)
            System.out.println(result.getResultHeader());
    }
}
