package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.RegisterPage;
import utils.TestDataGenerator;

public class RegisterSteps {

    private String username;

    private final String password =
            TestDataGenerator.PASSWORD;

    RegisterPage registerPage =
            new RegisterPage(Hooks.page);

    HomePage homePage =
            new HomePage(Hooks.page);

    @Given("User launches ParaBank application")
    public void user_launches_parabank_application() {

        Hooks.page.navigate(
                "https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
    }

    @When("User navigates to registration page")
    public void user_navigates_to_registration_page() {

        registerPage.openRegistrationPage();
    }

    @When("User enters valid registration details")
    public void user_enters_valid_registration_details() {

        username =
                TestDataGenerator.generateUsername();

        System.out.println(
                "Generated Username : "
                        + username);

        registerPage.registerUser(
                username,
                password);
    }

    @Then("User account should be created successfully")
    public void user_account_should_be_created_successfully() {

        if (!registerPage
                .isRegistrationSuccessful()) {

            throw new AssertionError(
                    "Registration failed");
        }
    }

    @Then("User should see account overview page")
    public void user_should_see_account_overview_page() {

        if (!homePage
                .isAccountOverviewDisplayed()) {

            throw new AssertionError(
                    "Account Overview not displayed");
        }
    }

    @Then("User should print account balance")
    public void user_should_print_account_balance() {

        String balance =
                homePage.getAccountBalance();

        System.out.println(
                "Account Balance : "
                        + balance);
    }
}