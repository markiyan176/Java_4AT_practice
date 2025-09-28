package aqa.course.task5;

//1.
//The general task for all:
//Serialization-Deserialization:
//a) Make some complex models using your variant.
//b) Make it serializable.
//c) Read JSON from “input.json”
//d) and deserialize it to POJO.
//e) Then change a few fields and save it to “output.json”.
//f) Do the same for XML.
//
//
//2.
//Stream:
//a) Generate 10 random objects using a class from a previous task
//b) Sort it using any two fields using stream.
//c) Filter it by any two fields custom filter.
//d) Collect it to List with *main field(s).
//
//
//   3. Write a maven command for executing one of your tasks with arguments (number of elements).
//
//
//V8
//{
//  "name": "Emily",
//  "age": 22,
//  "friends": ["Alice", "Bob", "David"]
//}
//<person>
//  <name>Emily</name>
//  <age>22</age>
//  <friends>
//    <friend>Alice</friend>
//    <friend>Bob</friend>
//    <friend>David</friend>
//  </friends>
//</person>

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Task5 {
    public static void main(String[] args) throws IOException {

        // ==== 1. JSON ====
        ObjectMapper objectMapper = new ObjectMapper();
        User userJson = objectMapper.readValue(
                new File("C:\\Users\\goro1\\Desktop\\AT\\lab1\\java_aqa\\src\\main\\resources\\output.json"), User.class
        );
        System.out.println("JSON before update: " + userJson);

        userJson.age = 30;
        userJson.name = "Updated Emily";

        objectMapper.writeValue(new File("C:\\Users\\goro1\\Desktop\\AT\\lab1\\java_aqa\\src\\main\\resources\\output.json"), userJson);
        System.out.println("JSON after update written to output.json");

        // ==== 2. XML ====
        XmlMapper xmlMapper = new XmlMapper();
        User userXml = xmlMapper.readValue(
                new File("C:\\Users\\goro1\\Desktop\\AT\\lab1\\java_aqa\\src\\main\\resources\\output.xml"), User.class
        );
        System.out.println("XML before update: " + userXml);

        userXml.age = 25;
        userXml.name = "Updated Emily XML";

        xmlMapper.writeValue(new File("C:\\Users\\goro1\\Desktop\\AT\\lab1\\java_aqa\\src\\main\\resources\\output.xml"), userXml);
        System.out.println("XML after update written to output.xml");

        // ==== 3. Stream API: генерація випадкових користувачів ====
        int numUsers = 10; // за замовчуванням 10
        if(args.length > 0) {
            try {
                numUsers = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Аргумент не є числом, використовується 10 користувачів");
            }
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

        // Сортування за age, потім name, фільтр age>20 і name != "Bob", збір у список тільки з name та age
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
