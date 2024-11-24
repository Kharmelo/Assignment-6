public class User {
    private String username;
    private int age;
    private String gender;
    private String region;

    public User(String username, int age, String gender, String region) {
        this.username = username;
        this.age = age;
        this.gender = gender;
        this.region = region;
    }

    public String getGender() {
        return gender;
    }

    public String getRegion() {
        return region;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return username + " (Age: " + age + ", Gender: " + gender + ", Region: " + region + ")";
    }
}