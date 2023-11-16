package com.epam.project.service;

import com.epam.project.model.Specialization;
import com.epam.project.model.Trainee;
import com.epam.project.model.Trainer;
import com.epam.project.model.User;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class ProfileService {

    private Map<String, User> userDataBase;

    public ProfileService() {
        userDataBase = loadUserData();
    }

    private String generateUserName(String firstName, String lastName, Class<?> type) {
        String baseUserName = firstName + "." + lastName;
        String userName = baseUserName;
        int serialNumber = 1;

        while (userDataBase.containsKey(userName)) {
            userName = baseUserName + serialNumber;
            serialNumber++;
        }
        return userName;
    }

    private String generateRandomPassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            int index = new Random().nextInt(characters.length());
            password.append(characters.charAt(index));
        }
        return password.toString();
    }

    private User createUser(String userName, String password) {
        return new User(userName, password, true);
    }

    private void saveUser(User user) {
        userDataBase.put(user.getUserName(), user);
    }

    public User createTraineeProfile(String firstName, String lastName, Date dateOfBirth, String address) {
        String userName = generateUserName(firstName, lastName, Trainee.class);
        String password = generateRandomPassword();
        Trainee trainee = new Trainee(dateOfBirth, address, createUser(userName, password));
        saveUser(trainee.getUser());
        return trainee.getUser();
    }

    public User createTrainerProfile(String firstName, String lastName, Specialization specialization) {
        String userName = generateUserName(firstName, lastName, Trainer.class);
        String password = generateRandomPassword();
        Trainer trainer = new Trainer(specialization, createUser(userName, password));
        saveUser(trainer.getUser());
        return trainer.getUser();
    }

    public Map<String, User> loadUserData() {
        Map<String, User> userData = new HashMap<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("data_user.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                String[] parts = line.split(",");
                if (parts.length == 6) {
                    int id = Integer.parseInt(parts[0]);
                    String firstName = parts[1];
                    String lastName = parts[2];
                    String userName = parts[3];
                    String password = parts[4];
                    boolean isActive = Boolean.parseBoolean(parts[5]);

                    User user = new User(id, firstName, lastName, userName, password, isActive);
                    userData.put(userName, user);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return userData;
    }
}
