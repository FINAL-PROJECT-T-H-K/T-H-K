package test.cases.socialNetwork.socialnetwork;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class CreatePost extends BaseTestSetup {

    String postDescription;

    @Test
    public void create_public_post() {
        loginSocial(); ///maybe in beforeAll

        postDescription = postPageSocial.generateDescription();
        postPageSocial.create_public_post(postDescription);

        postPageSocial.verifyPostCreated(postDescription);
        postPageSocial.verifyPublicPostCreated();

    }

    @Test
    public void create_private_post() {
        loginSocial();    ///maybe in beforeAll

        postDescription = postPageSocial.generateDescription();
        postPageSocial.create_private_post(postDescription);

        postPageSocial.verifyPostCreated(postDescription);
        postPageSocial.verifyPrivatePostCreated();
    }
}
