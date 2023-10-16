package ui.socialnetwork.tests;

import apisocialnetwork.Utils;
import org.junit.jupiter.api.Test;
import ui.socialnetwork.base.BaseTestSetup;

import java.util.logging.Logger;

import static com.telerikacademy.testframework.Constants.*;

public class ConnectionTests extends BaseTestSetup {
//   public String USERNAME_SENDER_UI;
//   public String PASSWORD_SENDER_UI;
//   public String PASSWORD_RECEIVER_UI;
//   public String USERNAME_RECEIVER_UI;

    Logger logger = Logger.getLogger("");

    @Test
    public void sendingConnectionRequestToAnotherUserTest() {
        USERNAME_RECEIVER_UI = Utils.generateUniqueUsername();
        PASSWORD_RECEIVER_UI = Utils.generateUniquePassword();
        registerAndLoginUserWithParams(USERNAME_RECEIVER_UI, PASSWORD_RECEIVER_UI);

        personalProfilePage.enterPersonalProfile();
        personalProfilePage.setFirstLastNamesAndBirthdate(USERNAME_RECEIVER_UI, USERNAME_RECEIVER_UI);
        personalProfilePage.clickOnUpdateProfileButton();
        personalProfilePage.backToProfileInfo();
        logoutPage.logoutSuccessfully();

        USERNAME_SENDER_UI = Utils.generateUniqueUsername();
        PASSWORD_SENDER_UI = Utils.generateUniquePassword();
        registerAndLoginUserWithParams(USERNAME_SENDER_UI, PASSWORD_SENDER_UI);
        homePage.searchUserByKnownUsername(USERNAME_RECEIVER_UI);
        homePage.clickOnUserAfterSearch();
        homePage.sendConnectionToSearchedUser();

        homePage.validateSearchedUsernameInSearchResults(USERNAME_RECEIVER_UI, USERNAME_RECEIVER_UI);
        homePage.verifySuccessfulConnectionRequestMessage();

    }

    @Test
    public void approveAlreadySentConnectionRequestTest() {

        USERNAME_RECEIVER_UI = Utils.generateUniqueUsername();
        PASSWORD_RECEIVER_UI = Utils.generateUniquePassword();
        registerAndLoginUserWithParams(USERNAME_RECEIVER_UI, PASSWORD_RECEIVER_UI);

        personalProfilePage.enterPersonalProfile();
        personalProfilePage.setFirstLastNamesAndBirthdate(USERNAME_RECEIVER_UI, USERNAME_RECEIVER_UI);
        personalProfilePage.clickOnUpdateProfileButton();
        personalProfilePage.backToProfileInfo();
        logoutPage.logoutSuccessfully();

        USERNAME_SENDER_UI = Utils.generateUniqueUsername();
        PASSWORD_SENDER_UI = Utils.generateUniquePassword();
        registerAndLoginUserWithParams(USERNAME_SENDER_UI, PASSWORD_SENDER_UI);
        homePage.searchUserByKnownUsername(USERNAME_RECEIVER_UI);
        homePage.clickOnUserAfterSearch();
        homePage.sendConnectionToSearchedUser();

        logoutPage.logoutSuccessfully();
        loginPage.loginUser(USERNAME_RECEIVER_UI, PASSWORD_RECEIVER_UI);
        homePage.clickOnPersonalProfile();
        personalProfilePage.approveReceivedConnectionRequest();

        personalProfilePage.validateReceivedConnectionRequestApproved();
        //assert friendlist increased by 1

    }

    @Test
    public void disconnectFromAlreadyConnectedUserTest() {

        USERNAME_RECEIVER_UI = Utils.generateUniqueUsername();
        PASSWORD_RECEIVER_UI = Utils.generateUniquePassword();
        registerAndLoginUserWithParams(USERNAME_RECEIVER_UI, PASSWORD_RECEIVER_UI);

        personalProfilePage.enterPersonalProfile();
        personalProfilePage.setFirstLastNamesAndBirthdate(USERNAME_RECEIVER_UI, USERNAME_RECEIVER_UI);
        personalProfilePage.clickOnUpdateProfileButton();
        personalProfilePage.backToProfileInfo();
        logoutPage.logoutSuccessfully();

        USERNAME_SENDER_UI = Utils.generateUniqueUsername();
        PASSWORD_SENDER_UI = Utils.generateUniquePassword();
        registerAndLoginUserWithParams(USERNAME_SENDER_UI, PASSWORD_SENDER_UI);
        homePage.searchUserByKnownUsername(USERNAME_RECEIVER_UI);
        homePage.clickOnUserAfterSearch();
        homePage.sendConnectionToSearchedUser();

        logoutPage.logoutSuccessfully();
        loginPage.loginUser(USERNAME_RECEIVER_UI, PASSWORD_RECEIVER_UI);
        homePage.clickOnPersonalProfile();
        personalProfilePage.approveReceivedConnectionRequest();

        logoutPage.logoutSuccessfully();
        loginPage.loginUser(USERNAME_SENDER_UI, PASSWORD_SENDER_UI);
        homePage.searchUserByKnownUsername(USERNAME_RECEIVER_UI);
        homePage.clickOnUserAfterSearch();
        homePage.disconnectFromAlreadyConnectedUser();

        homePage.validateDisconnectionFromAlreadyConnectedUser();

    }
}
