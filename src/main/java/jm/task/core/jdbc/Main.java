package jm.task.core.jdbc;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        List<User> testList = new ArrayList<>();
        testList.add(new User("Сергей", "Жуков", (byte) 20));
        testList.add(new User("Михаил", "Семенов", (byte) 30));
        testList.add(new User("Катя", "Белова", (byte) 44));
        testList.add(new User("Петя", "Дубовый", (byte) 56));
        testList.forEach(name -> {
            userService.saveUser(name.getName(), name.getLastName(), name.getAge());
            System.out.format("User с именем – %s добавлен в базу данных%n", name.getName());
        });
        userService.getAllUsers().forEach(user -> System.out.println(user.toString())); ;
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
