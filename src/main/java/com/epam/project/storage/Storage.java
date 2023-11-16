package com.epam.project.storage;

import com.epam.project.model.Trainee;
import com.epam.project.model.Trainer;
import com.epam.project.model.Training;
import com.epam.project.model.User;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class Storage {
    private Map<Integer, Trainer> trainers = new HashMap<>();
    private Map<Integer, Trainee> trainees = new HashMap<>();
    private Map<Integer, Training> trainings = new HashMap<>();

    public Map<Integer, Trainee> getTrainees() {
        return trainees;
    }

    public Map<Integer, Trainer> getTrainers() {
        return trainers;
    }

    public Map<Integer, Training> getTrainings() {
        return trainings;
    }

    private Map<String, User> users = new HashMap<>();

    public void setTrainers(Map<Integer, Trainer> trainers) {
        this.trainers = trainers;
    }

    public void setTrainees(Map<Integer, Trainee> trainees) {
        this.trainees = trainees;
    }

    public void setTrainings(Map<Integer, Training> trainings) {
        this.trainings = trainings;
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }

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
    public void writeDataToTraineeFile(Map<Integer, Trainee> trainees) {
        try (FileWriter writer = new FileWriter("data_trainee.txt")) {
            for (Map.Entry<Integer, Trainee> entry : trainees.entrySet()) {
                Trainee trainee = entry.getValue();
                writer.write(trainee.getId() + "," + trainee.getDateOfBirth() + "," + trainee.getAddress() + ", " + trainee.getUser() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeDataToTrainerFile(Map<Integer, Trainer> trainers) {
        try (FileWriter writer = new FileWriter("data_trainer.txt")) {
            for (Map.Entry<Integer, Trainer> entry : trainers.entrySet()) {
                Trainer trainer = entry.getValue();
                writer.write(trainer.getId() + "," + trainer.getName() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeDataToTrainingFile(Map<Integer, Training> trainings) {
        try (FileWriter writer = new FileWriter("data_training.txt")) {
            for (Map.Entry<Integer, Training> entry : trainings.entrySet()) {
                Training training = entry.getValue();
                writer.write(training.getId() + "," + training.getTrainerId() + ", "
                        + training.getTrainingName() + ", " + training.getTrainingTypeId()
                        + ", " + training.getTrainingDate() + ", " + training.getTrainingDuration() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void initBean() {
        System.out.println("Init Bean for : Storage");
    }

    public void destroyBean() {
        System.out.println("Destroy Bean for : Storage");
    }
}