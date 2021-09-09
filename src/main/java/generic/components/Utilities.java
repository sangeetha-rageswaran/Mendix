package generic.components;

import com.github.javafaker.Faker;

public class Utilities {
    public static Faker faker = new Faker();

    public static String generateRandomName() {
        return faker.name().fullName();
    }
}
