package pages;

import com.microsoft.playwright.Page;

public class HomePage {

    private final Page page;

    public HomePage(Page page) {

        this.page = page;
    }

    public boolean isAccountOverviewDisplayed() {

        var accountsOverview =
                page.locator("a[href='overview.htm']");

        accountsOverview.waitFor();

        if (accountsOverview.isVisible()) {

            accountsOverview.click();

            return true;
        }

        return false;
    }

    public String getAccountBalance() {

        page.locator("#accountTable")
                .waitFor();

        return page.locator(
                        "#accountTable tbody tr td")
                .nth(1)
                .textContent();
    }
}