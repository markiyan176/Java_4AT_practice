package aqa.course.task5;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Task5 {
    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        XmlMapper xmlMapper = new XmlMapper();

        Path inputJson = Paths.get(System.getProperty("user.dir"), "input.json");
        Path outputJson = Paths.get(System.getProperty("user.dir"), "output.json");

        User userJson;

        if (!inputJson.toFile().exists()) {
            userJson = new User("Emily", 22, Arrays.asList("Alice", "Bob", "David"));
            objectMapper.writeValue(inputJson.toFile(), userJson);
            System.out.println("input.json не знайдено, створено новий файл з початковими даними");
        } else {
            userJson = objectMapper.readValue(inputJson.toFile(), User.class);
        }

        System.out.println("JSON before update: " + userJson);

        // Оновлення полів
        userJson.age = 30;
        userJson.name = "Updated Emily";

        objectMapper.writeValue(outputJson.toFile(), userJson);
        System.out.println("JSON after update written to " + outputJson.toAbsolutePath());

        InputStream in = Task5.class.getResourceAsStream("/output.xml");
        User userXml;

        if (in == null) {
            userXml = new User("Emily", 22, Arrays.asList("Alice", "Bob", "David"));
            System.out.println("output.xml не знайдено в ресурсах, створено об’єкт з початковими даними");
        } else {
            userXml = xmlMapper.readValue(in, User.class);
            System.out.println("XML before update: " + userXml);
            in.close();
        }

        // Оновлення полів
        userXml.age = 25;
        userXml.name = "Updated Emily XML";

        Path xmlOut = Paths.get(System.getProperty("user.dir"), "output.xml");
        xmlMapper.writeValue(xmlOut.toFile(), userXml);
        System.out.println("XML after update written to " + xmlOut.toAbsolutePath());

        int numUsers = 10;
        if (args.length > 0) {
            numUsers = Integer.parseInt(args[0]);
        }

        List<User> randomUsers = new ArrayList<>();
        Random rnd = new Random();
        String[] names = {"Alice", "Bob", "Charlie", "David", "Emily", "Frank"};

        for (int i = 0; i < numUsers; i++) {
            String name = names[rnd.nextInt(names.length)];
            int age = 18 + rnd.nextInt(20);
            List<String> friends = Arrays.asList(
                    names[rnd.nextInt(names.length)],
                    names[rnd.nextInt(names.length)]
            );
            randomUsers.add(new User(name, age, friends));
        }

        List<User> processedUsers = randomUsers.stream()
                .sorted(Comparator.comparingInt((User u) -> u.age)
                        .thenComparing(u -> u.name))
                .filter(u -> u.age > 20 && !u.name.equals("Bob"))
                .map(u -> new User(u.name, u.age, null))
                .collect(Collectors.toList());

        System.out.println("Stream API processed users:");
        processedUsers.forEach(System.out::println);
    }
}
