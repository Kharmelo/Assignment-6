import java.util.*;

public class WordCloudGenerator {
    private List<Post> posts;
    
    public WordCloudGenerator(List<Post> posts) {
        this.posts = posts;
    }

    // Filter posts based on user attributes and keywords
    public List<String> filterPosts(String keyword, String gender, String region, int minAge, int maxAge) {
        List<String> filteredContent = new ArrayList<>();

        for (Post post : posts) {
            boolean matchesKeyword = keyword == null || post.getContent().contains(keyword);
            for (User viewer : post.getViewers()) {
                boolean matchesGender = gender.equals("any") || viewer.getGender().equalsIgnoreCase(gender);
                boolean matchesRegion = region.equals("any") || viewer.getRegion().equalsIgnoreCase(region);
                boolean matchesAge = viewer.getAge() >= minAge && viewer.getAge() <= maxAge;

                if (matchesKeyword && matchesGender && matchesRegion && matchesAge) {
                    filteredContent.add(post.getContent());
                    break; // Include post once per viewer match
                }
            }
        }

        return filteredContent;
    }

    // Calculate word frequency from filtered posts
    public Map<String, Integer> getWordFrequency(List<String> postsContent, List<String> excludeWords) {
        Map<String, Integer> wordFreq = new HashMap<>();
        Set<String> exclusions = new HashSet<>(excludeWords);

        for (String content : postsContent) {
            String[] words = content.toLowerCase().split("\\W+"); // Split by non-word characters
            for (String word : words) {
                if (!exclusions.contains(word) && word.length() > 1) { // Exclude words from the list
                    wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
                }
            }
        }

        return wordFreq;
    }

    // Generate a simple text-based word cloud (console output)
    public void printWordCloud(Map<String, Integer> wordFreq) {
        wordFreq.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(50) // Display top 50 words
                .forEach(entry -> {
                    System.out.println(entry.getKey() + " : " + "*".repeat(Math.max(0, entry.getValue())));
                });
    }
}