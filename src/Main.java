import Service.Employee;
import Service.UserService;

/**
 * Tests UserService class methods
 */
public class Main {
    public static void main(String[] args) {
        UserService service = new UserService();
        Employee emp = new Employee("Kit Kat");
        //try to ad new users for an employee
        service.createUser("main_user", emp);
        service.createUser("system_user", emp);
        //try to add new user with existing login
        service.createUser("system_user", emp);
        //try to delete user passing an non-existent login
        service.deleteUser("user");
        //read information about employee with given login from user table
        System.out.println(service.readUser("main_user"));
    }
}
