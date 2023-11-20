package com.epam.project.storage;

import com.epam.project.dao.TraineeDAO;
import com.epam.project.dao.TrainerDAO;
import com.epam.project.dao.TrainingDAO;
import com.epam.project.dao.UserDAO;
import com.epam.project.model.Trainee;
import com.epam.project.model.Trainer;
import com.epam.project.model.Training;
import com.epam.project.model.User;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class Storage {
    private Map<Integer, Trainer> trainers = new HashMap<>();
    private Map<Integer, Trainee> trainees = new HashMap<>();
    private Map<Integer, Training> trainings = new HashMap<>();
    private Map<String, User> users = new HashMap<>();

    public Map<Integer, Trainee> getTrainees() {
        return trainees;
    }

    public Map<Integer, Trainer> getTrainers() {
        return trainers;
    }

    public Map<Integer, Training> getTrainings() {
        return trainings;
    }

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


    public void initBean() {
        UserDAO userDAO = new UserDAO();
        Map<Integer, User> users = new HashMap<>();
        users.put(1, new User(1, "Andrea", "Bocelli", "Music", "password", true));
        users.put(2, new User(2, "Sarah", "Conor", "Smith", "password", true));
        users.put(3, new User(3, "Martina", "Liberty", "Smith", "password", true));
        userDAO.writeDataToUserStorageFile(users);

        TrainerDAO trainerDAO = new TrainerDAO();
        Map<Integer, Trainer> trainers = new HashMap<>();
        trainers.put(1, new Trainer(1, "Tom"));
        trainers.put(2, new Trainer(2, "Sarah"));
        trainers.put(3, new Trainer(3, "Andrea"));
        trainerDAO.writeDataToTrainerFile(trainers);

        TraineeDAO traineeDAO = new TraineeDAO();
        Map<Integer, Trainee> trainees = new HashMap<>();
        trainees.put(1, new Trainee(1, new Date(), "Kyrgyzstan"));
        trainees.put(2, new Trainee(2, new Date(), "Berlin"));
        trainees.put(3, new Trainee(3, new Date(), "New York"));
        traineeDAO.writeDataToTraineeFile(trainees);

        TrainingDAO trainingDAO = new TrainingDAO();
        Map<Integer, Training> trainings = new HashMap<>();
        trainings.put(1, new Training(1, "Cross-country running", 55));
        trainings.put(2, new Training(2, "Olympic weightlifting", 40));
        trainings.put(3, new Training(3, "Chess boxing", 22));
        trainingDAO.writeDataToTrainingFile(trainings);
    }

    public void destroyBean() {
        System.out.println("Destroy Bean for : Storage");
    }
}