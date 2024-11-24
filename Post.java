import java.util.HashSet;
import java.util.Set;

public class Post {
    private String content;
    private Set<User> viewers;

    public Post(String content) {
        this.content = content;
        this.viewers = new HashSet<>();
    }

    public void addView(User user) {
        viewers.add(user);
    }

    public String getContent() {
        return content;
    }

    public Set<User> getViewers() {
        return viewers;
    }
}