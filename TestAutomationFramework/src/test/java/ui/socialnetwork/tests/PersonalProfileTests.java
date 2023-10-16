package ui.socialnetwork.tests;

import apisocialnetwork.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.socialnetwork.base.BaseTestSetup;

import java.util.logging.Logger;

import static com.telerikacademy.testframework.Constants.*;

public class PersonalProfileTests extends BaseTestSetup {

    @BeforeEach
    public void setupUser() {
        registerAndLoginUser();
    }

    @Test
    @Tag("FHKT-280")
    public void updateUserProfileWithMustHaveFieldsTest() {

        registerAndLoginUser();
        personalProfilePage.enterPersonalProfile();
        firstName += Utils.generateFirstName();
        lastName += Utils.generateLastName();
        personalProfilePage.setFirstLastNamesAndBirthdate(firstName, lastName);
        personalProfilePage.clickOnUpdateProfileButton();
        personalProfilePage.backToProfileInfo();

        //assert
        personalProfilePage.assertFirstLastNamesUpdated(firstName, lastName);

    }

    @Test
    @Tag("FHKT-96")
    public void updateUserProfileWithFirstLastNameBirthdayGenderEmailPublicInfoCityTest() {
        personalProfilePage.enterPersonalProfile();
        firstName += Utils.generateFirstName();
        lastName += Utils.generateLastName();
        personalProfilePage.setFirstLastNamesAndBirthdate(firstName, lastName);
        email = personalProfilePage.generateRandomEmail();
        personalProfilePage.updateUserProfileWithEmailAddress(email);
        personalProfilePage.updateUserProfileWithGender();
        personalInfo += personalProfilePage.generateInfo();
        personalProfilePage.updateUserPublicInfo(personalInfo);
        personalProfilePage.updateCity();
        personalProfilePage.clickOnUpdateProfileButton();
        personalProfilePage.backToProfileInfo();

        //assert
        personalProfilePage.assertFirstLastNamesUpdated(firstName, lastName);
        personalProfilePage.assertEmailUpdated(email);

    }


    @Test
    @Tag("FHKT-250")
    public void updatePersonalJobTittleInformationTest() {
        personalProfilePage.enterPersonalProfile();
        personalProfilePage.updateJobSection();

        //assert
        personalProfilePage.assertJobTitleUpdated();
    }

    @Test
    @Tag("FHKT-251")
    public void updatePersonalSkillsInformationTest() {
        personalProfilePage.enterPersonalProfile();
        personalProfilePage.updateSkillsSection();

        //assert
        personalProfilePage.assertAvailability();
      //  personalProfilePage.assertAvailabilityUpdated();

    }


}
