package aqa.course.task5;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    public String name;
    public Integer age;
    public List<String> friends;

    // === Додати конструктор без аргументів для Jackson ===
    public User() {
    }

    // === Додати конструктор з параметрами для Stream API ===
    public User(String name, Integer age, List<String> friends) {
        this.name = name;
        this.age = age;
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", friends=" + friends +
                '}';
    }
}
