package hooks;

import com.microsoft.playwright.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.nio.file.Paths;

public class Hooks {

    public static Playwright playwright;
    public static Browser browser;
    public static BrowserContext context;
    public static Page page;

    @Before
    public void setup() {

        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false));

        context = browser.newContext();

        page = context.newPage();

        page.setDefaultTimeout(30000);
    }

    @After
    public void tearDown(Scenario scenario) {

        try {

            if (scenario.isFailed()) {

                page.screenshot(
                        new Page.ScreenshotOptions()
                                .setFullPage(true)
                                .setPath(Paths.get(
                                        "screenshots/"
                                                + scenario.getName()
                                                + ".png")));
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        if (context != null)
            context.close();

        if (browser != null)
            browser.close();

        if (playwright != null)
            playwright.close();
    }
}