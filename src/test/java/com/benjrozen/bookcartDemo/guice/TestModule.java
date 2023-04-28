package com.benjrozen.bookcartDemo.guice;


import com.benjrozen.bookcartDemo.Context;
import com.benjrozen.bookcartDemo.restAssured.BookCartApiExecutor;
import com.benjrozen.bookcartDemo.restAssured.RestHttp;
import com.benjrozen.bookcartDemo.selenium.webdriver.ChromeDriverProvider;
import com.google.inject.AbstractModule;
import io.cucumber.guice.ScenarioScoped;
import org.openqa.selenium.WebDriver;

public class TestModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(WebDriver.class).toProvider(ChromeDriverProvider.class).in(ScenarioScoped.class);
        bind(BookCartApiExecutor.class).in(ScenarioScoped.class);
        bind(Context.class).in(ScenarioScoped.class);
        bind(RestHttp.class).in(ScenarioScoped.class);
    }
}

