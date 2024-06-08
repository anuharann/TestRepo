import java.util.ArrayList;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Post {
    private int postID;
    private String postTitle;
    private String postBody;
    private String[] postTags;
    private String[] postTypes = {"Very Difficult", "Difficult", "Easy"};
    private String[] postEmergency = {"Immediately Needed", "Highly Needed", "Ordinary"};
    private ArrayList<String> postComments = new ArrayList<>();
    
private boolean containsUpperCase(String str) {
    for (int i = 0; i < str.length(); i++) {
        if (Character.isUpperCase(str.charAt(i))) { // Method to check if a string contains any uppercase letters
            return true;
        }
    }
    return false;
}

    public boolean addPost() { // checks if they are all valid
        if (postTitle.length() < 10 || postTitle.length() > 250 || !postTitle.substring(0, 5).matches("^[a-zA-Z]{5}.*$")) {
            return false;
        }
        if (postBody.length() < 250) {
            return false;
        }
        if (postTags.length < 2 || postTags.length > 5) {
            return false;
        }
        for (int i = 0; i < postTags.length; i++) {
            String tag = postTags[i];
            if (tag.length() < 2 || tag.length() > 10 || containsUpperCase(tag)) {
                return false;
            }
        }
        if ((postTypes.equals("Very Difficult") || postTypes.equals("Difficult")) && postBody.length() < 300) {
            return false;
        }
        if (postTypes.equals("Easy") && postTags.length > 3) {
            return false;
        }
        if (postTypes.equals("Easy") && (postEmergency.equals("Immediately Needed") || postEmergency.equals("Highly Needed"))) {
            return false;
        }
        if ((postTypes.equals("Very Difficult") || postTypes.equals("Difficult")) && postEmergency.equals("Ordinary")) {
            return false;
        }
        return true; // if all above is false, post is invalid
    }

    public boolean addComment(String comment) {
        if (comment.split(" ").length < 4 || comment.split(" ").length > 10 || !Character.isUpperCase(comment.charAt(0))) { // checks if the first character is uppercase
            return false;
        }
        if (postComments.size() >= 5) {
            return false;
        }
        if (postTypes.equals("Easy") || postEmergency.equals("Ordinary")) {
            return postComments.size() < 3;
        }
        return true; // if all above is false, comment is invalid
    }

    @Override
    public String toString() {
        return "PostID: " + postID + ", Title: " + postTitle + ", Body: " + postBody + ", Tags: " + Arrays.toString(postTags) + ", Type: " + postTypes + ", Emergency: " + postEmergency;
    }
}

