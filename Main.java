import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Create users
        User alice = new User("Alice", 25, "Female", "North America");
        User bob = new User("Bob", 30, "Male", "Europe");
        User charlie = new User("Charlie", 22, "Female", "Asia");

        // Create posts
        Post post1 = new Post("Learning Java is fun! Java is powerful.");
        Post post2 = new Post("I love coding and problem-solving!");
        Post post3 = new Post("Java has a steep learning curve, but it's worth it!");

        // Add viewers
        post1.addView(alice);
        post2.addView(bob);
        post3.addView(charlie);

        // List of posts
        List<Post> posts = new ArrayList<>(Arrays.asList(post1, post2, post3));

        // Word Cloud Generator
        WordCloudGenerator wordCloudGenerator = new WordCloudGenerator(posts);

        // Filter posts and calculate word frequency
        List<String> filteredPosts = wordCloudGenerator.filterPosts(null, "Female", "any", 20, 30);
        List<String> excludeWords = Arrays.asList("is", "the", "a", "and", "to", "it");
        Map<String, Integer> wordFreq = wordCloudGenerator.getWordFrequency(filteredPosts, excludeWords);

        // Print word cloud
        wordCloudGenerator.printWordCloud(wordFreq);
    }
}