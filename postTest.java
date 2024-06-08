import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class postTest {

    @Test
    public void testAddPostValid() {
        Post post = new Post(1, "Valid Post Title", "This is a valid body with more than 250 characters. ".repeat(5), new String[]{"tag1", "tag2"}, "Difficult", "Immediately Needed");
        assertTrue(post.addPost());
    }

    @Test
    public void testAddPostInvalidBodyLength() {
        Post post = new Post(3, "Valid Post Title", "Short body", new String[]{"tag1", "tag2"}, "Difficult", "Immediately Needed");
        assertFalse(post.addPost());
    }

    @Test
    public void testAddCommentTooManyComments() {
        Post post = new Post(3, "Valid Post Title", "This is a valid body with more than 250 characters. ".repeat(5), new String[]{"tag1", "tag2"}, "Difficult", "Immediately Needed");
        post.addPost();
        post.addComment("First valid comment");
        post.addComment("Second valid comment");
        post.addComment("Third valid comment");
        post.addComment("Fourth valid comment");
        post.addComment("Fifth valid comment");
        assertFalse(post.addComment("Sixth comment"));
    }

    @Test
    public void testAddCommentEasyTooMany() {
        Post post = new Post(4, "Valid Post Title", "This is a valid body with more than 250 characters. ".repeat(5), new String[]{"tag1", "tag2"}, "Easy", "Ordinary");
        post.addPost();
        post.addComment("First valid comment");
        post.addComment("Second valid comment");
        post.addComment("Third valid comment");
        assertFalse(post.addComment("Fourth comment"));
    }
}
