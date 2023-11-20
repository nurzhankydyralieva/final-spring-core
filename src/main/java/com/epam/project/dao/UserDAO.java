package com.epam.project.dao;

import com.epam.project.model.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class UserDAO {
    public void writeDataToUserStorageFile(Map<Integer, User> users) {
        try (FileWriter writer = new FileWriter("data_user.txt")) {
            for (Map.Entry<Integer, User> entry : users.entrySet()) {
                User user = entry.getValue();
                writer.write(user.getId() + ", " + user.getFirstName() + ", " + user.getLastName() + ", " + user.getUserName() + ", " + user.getPassword() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
