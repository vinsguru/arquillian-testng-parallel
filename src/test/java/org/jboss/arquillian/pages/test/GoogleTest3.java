package org.jboss.arquillian.pages.test;

import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.graphene.page.Page;
import org.jboss.arquillian.pages.GooglePage;
import org.jboss.arquillian.testng.Arquillian;
import org.testng.Assert;
import org.testng.annotations.Test;

@RunAsClient
public class GoogleTest3 extends Arquillian {

    @Page
    GooglePage google;

    @Test(priority = 1)
    public void launchGoogle(){
        Graphene.goTo(GooglePage.class);
        Assert.assertEquals(true, google.isAt());
    }


    @Test(priority = 2)
    public void canGoogleSuggest(){
        google.getSearchWidget().searchFor("Arquillian");
        google.getSuggestions().show();
        Assert.assertEquals(google.getSuggestions().getCount(), 4);
    }

    @Test(priority = 3)
    public void canGoogleShowResult(){
        google.getSearchWidget().searchFor("Test Automation Guru");
        google.getSearchWidget().search();
        google.getSearchResults().show();
        Assert.assertEquals(google.getSearchResults().getCount(), 7);
    }
}