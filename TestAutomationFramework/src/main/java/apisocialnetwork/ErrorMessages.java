package apisocialnetwork;

import static apisocialnetwork.Constants.COMMENT_DESCRIPTION;
import static apisocialnetwork.Constants.COMMENT_ID;
import static java.lang.String.format;
import static org.apache.http.HttpStatus.SC_OK;

public class ErrorMessages {
    public static final String RESPONSE_HAS_A_NON_EMPTY_BODY = "Response has a non-empty body.";
    public static final String ERROR_MESSAGE_LIKED_POST = "Expected status should be true for liked post";
    public static final String ERROR_MESSAGE_FOR_DISLIKE_POST = "Expected status should be false for disliked comment";
    public static final String ERROR_MESSAGE_COMMENT_ID = format("Incorrect comment ID. Expected %s", COMMENT_ID);
    public static final String ERROR_MESSAGE_LIKED_SHOULD_BE_FALSE = "Expected status should be false for disliked comment";
    public static final String ERROR_MESSAGE_LIKED_SHOULD_BE_TRUE = "Expected status should be true for liked comment";
    public static final String ERROR_MESSAGE_RESPONSE_CONTENT = format("Response body content does not match the expected. Expected %s", COMMENT_DESCRIPTION);
    public static final String ERROR_MESSAGE_STATUS_CODE = format("Incorrect status code. Expected %s.", SC_OK);
    public static final String ERROR_MESSAGE_RESPONSE_BODY_EMPTY = "Response body should be empty";
}
