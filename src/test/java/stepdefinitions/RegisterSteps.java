package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import utils.TestDataGenerator;

public class RegisterSteps {

    private static String username;
    private static final String password = TestDataGenerator.PASSWORD;

    RegisterPage registerPage =
            new RegisterPage(Hooks.page);

    LoginPage loginPage =
            new LoginPage(Hooks.page);

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

        username = TestDataGenerator.generateUsername();

        registerPage.registerUser(
                username,
                password);
    }

    @Then("User account should be created successfully")
    public void user_account_should_be_created_successfully() {

        if (!registerPage.isRegistrationSuccessful()) {
            throw new RuntimeException(
                    "Registration failed");
        }

        System.out.println(
                "Registration Successful");
    }

    @Given("User is on ParaBank login page")
    public void user_is_on_login_page() {

        Hooks.page.navigate(
                "https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
    }

    @When("User enters newly registered credentials")
    public void user_enters_registered_credentials() {

        loginPage.login(
                username,
                password);
    }

    @Then("User should be logged into the application")
    public void user_should_be_logged_in() {

        if (!loginPage.isLoginSuccessful()) {
            throw new RuntimeException(
                    "Login failed");
        }

        System.out.println(
                "Login Successful");
    }

    @Given("User is logged into ParaBank application")
    public void user_is_logged_into_application() {

        if (!loginPage.isLoginSuccessful()) {

            loginPage.login(
                    username,
                    password);
        }
    }

    @Then("User should see account overview page")
    public void user_should_see_account_overview_page() {

        if (!homePage.isAccountOverviewDisplayed()) {

            throw new RuntimeException(
                    "Account overview page not displayed");
        }
    }

    @Then("User should print account balance")
    public void user_should_print_account_balance() {

        String balance =
                homePage.getAccountBalance();

        System.out.println(
                "Account Balance = "
                        + balance);
    }
}