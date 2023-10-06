package apiSocialNetwork;

public class JSONRequests {
    public static final String REGISTRATION_BODY = "{\n" +
            "    \"category\": {\n" +
            "        \"id\": 100,\n" +
            "        \"name\": \"All\"\n" +
            "    },\n" +
            "    \"confirmPassword\": \"alabala123\",\n" +
            "    \"email\": \"telerikacademy@abv.bg\",\n" +
            "    \"password\": \"alabala123\",\n" +
            "    \"username\": \"%s\"\n" +
            "}";

    public static final String POST_BODY = "{\n" +
            "    \"content\": \"string\",\n" +
            "    \"picture\": \"string\",\n" +
            "    \"public\": true\n" +
            "}";

    public static final String COMMENT_BODY =
            "{\n" +
                    "    \"content\": \"CommentContent\",\n" +
                    "    \"postId\": \"YourPostId\",\n" +
                    "    \"userId\": \"YourGeneratedIdUser\"\n" +
                    "}";


    public static final String PROFILE_POST = "{\n" +
            "  \"index\": 0,\n" +
            "  \"next\": true,\n" +
            "  \"searchParam1\": \"\",\n" +
            "  \"searchParam2\": \"\",\n" +
            "  \"size\": 10\n" +
            "}";
}
