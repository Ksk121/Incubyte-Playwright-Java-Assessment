package pages;

import com.microsoft.playwright.Page;

public class HomePage {

    private final Page page;

    public HomePage(Page page) {
        this.page = page;
    }

    public String getAccountBalance() {

        String balance = page
                .locator("#accountTable tbody tr")
                .first()
                .locator("td")
                .nth(1)
                .textContent();

        System.out.println("Account Balance : " + balance);

        return balance;
    }

    public boolean isAccountOverviewDisplayed() {

        return page.locator("text=Accounts Overview").isVisible();
    }
}