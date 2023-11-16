package com.epam.project.service;

import com.epam.project.dao.TraineeDAO;
import com.epam.project.dao.TrainerDAO;
import com.epam.project.model.Trainee;
import com.epam.project.model.Trainer;
import com.epam.project.model.User;
import com.epam.project.storage.Storage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
class ProfileServiceTest {
    @Mock
    private TraineeDAO traineeDAO;
    @Mock
    private TrainerDAO trainerDAO;
    @InjectMocks
    private TraineeService traineeService;
    @InjectMocks
    private TrainerService trainerService;
    private Map<Integer, Trainee> trainees;
    private Map<Integer, Trainer> trainers;
    private ProfileService service = new ProfileService();

    @BeforeEach
    public void setUp() {
        traineeDAO = mock(TraineeDAO.class);
        traineeService = new TraineeService(traineeDAO);
        trainees = new HashMap<>();
        trainees.put(1, new Trainee(1, "Bishkek"));
        trainees.put(2, new Trainee(2, "New York"));
        trainees.put(3, new Trainee(3, "Astana"));

        trainerDAO = mock(TrainerDAO.class);
        trainerService = new TrainerService(trainerDAO);
        trainers = new HashMap<>();
        trainers.put(1, new Trainer(1, "John Doe"));
        trainers.put(2, new Trainer(2, "Jane Smith"));
        trainers.put(3, new Trainer(3, "Maks Leo"));
    }

    @Test
    void createTraineeProfile() {
        traineeService.create(trainees);
        assertTrue(trainees.containsKey(1));
    }

    @Test
    void createTrainerProfile() {
        trainerService.create(trainers);
        assertTrue(trainers.containsKey(1));
    }



    @Test
    void loadUserData() {
        Map<Integer, User> users = new HashMap<>();
        users.put(1, new User(1, "Andrea", "Bocelli", "Music", "password", true));
        users.put(2, new User(2, "Sarah", "Conor", "Smith", "password", true));
        writeDataToUserStorageFile(users);

        User traineeProfile = service.createTraineeProfile("Andrea", "Bocelli", new Date(), "1575 Evergreen Ave");
        System.out.println("Trainee UserName: " + traineeProfile.getUserName());
        System.out.println("Trainee Password: " + traineeProfile.getPassword());
        assertEquals("Andrea.Bocelli", traineeProfile.getUserName());
    }

    private void writeDataToUserStorageFile(Map<Integer, User> users) {
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
