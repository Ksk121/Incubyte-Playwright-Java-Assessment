package pages;

import com.microsoft.playwright.Page;

public class RegisterPage {

    private final Page page;

    public RegisterPage(Page page) {
        this.page = page;
    }

    private final String registerLink = "text=Register";

    public void openRegistrationPage() {
        page.click(registerLink);
    }

    public void registerUser(String username, String password) {

        page.fill("#customer\\.firstName", "Karthik");
        page.fill("#customer\\.lastName", "KS");
        page.fill("#customer\\.address\\.street", "Bangalore");
        page.fill("#customer\\.address\\.city", "Bangalore");
        page.fill("#customer\\.address\\.state", "Karnataka");
        page.fill("#customer\\.address\\.zipCode", "560001");
        page.fill("#customer\\.phoneNumber", "7348965879");
        page.fill("#customer\\.ssn", "123456");

        page.fill("#customer\\.username", username);
        page.fill("#customer\\.password", password);
        page.fill("#repeatedPassword", password);

        page.click("input[value='Register']");
    }

    public boolean isRegistrationSuccessful() {

        return page.locator("text=Your account was created successfully").isVisible();
    }
}