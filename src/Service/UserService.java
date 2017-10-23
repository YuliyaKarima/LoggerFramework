package Service;

import Framework.*;
import Framework.Error;

import java.util.*;

/**
 * Class provides methods for creating, deleting and reading user in
 * user table presented by Map object
 */
@Level(level = ErrorLevel.ERROR)
public class UserService {
    Map<String, Employee> users = new HashMap<String, Employee>();

    /**
     * Method for creating new user
     *
     * @param login    user's login
     * @param employee Employee instance
     */
    @Info
    public void createUser(String login, Employee employee) {
        if (!users.containsKey(login)) {
            users.put(login, employee);
            Logger.logger("Request to add new User: "
                    + login + " has been added to user table");
        } else {
            Logger.logger("Request to add new User: "
                    + login + " is already exists in user table");
        }
    }

    /**
     * Method for reading information about user
     *
     * @param login user's login
     * @return Employee instance
     */
    @Debug
    public Employee readUser(String login) {
        Logger.logger(login);
        if (users.containsKey(login)) {
            Logger.logger("Read request: User " + login);
            return users.get(login);
        } else {
            Logger.logger("Read request: User " + login + " doesn't exists");
            return null;
        }
    }

    /**
     * Method for deleting user
     *
     * @param login user's login
     */
    @Error
    public void deleteUser(String login) {
        if (users.containsKey(login)) {
            users.remove(login);
            Logger.logger("Delete request: User " + login + " has been deleted from user table");
        } else {
            Logger.logger("Delete request: User " + login + " doesn't exists");
        }
    }
}
