package com.epam.project.service;

import com.epam.project.dao.TraineeDAO;
import com.epam.project.model.Trainee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
class TraineeServiceTest {
    @Mock
    private TraineeDAO traineeDAO;
    @InjectMocks
    private TraineeService traineeService;
    private Map<Integer, Trainee> trainees;

    @BeforeEach
    public void setUp() {
        traineeDAO = mock(TraineeDAO.class);
        traineeService = new TraineeService(traineeDAO);
        trainees = new HashMap<>();
        trainees.put(1, new Trainee(1, "Bishkek"));
        trainees.put(2, new Trainee(2, "New York"));
        trainees.put(3, new Trainee(3, "Astana"));

    }

    @Test
    @DisplayName("Trainee is created")
    void create() {
        traineeService.create(trainees);
        assertTrue(trainees.containsKey(1));
    }

    @Test
    @DisplayName("Trainees are selected")
    void select() {
        traineeService.select();
        assertEquals(3, trainees.size());
    }

    @Test
    @DisplayName("Trainee is updated")
    void update() {
        int idToUpdate = 1;
        Trainee updatedTrainee = new Trainee(1, "Updated address - Tashkent");
        trainees.put(idToUpdate, updatedTrainee);
        traineeService.update(idToUpdate, updatedTrainee);

        assertTrue(trainees.containsKey(1));
        assertEquals(3, trainees.size());
    }

    @Test
    @DisplayName("Trainee is deleted")
    void delete() {
        boolean deletedId = traineeService.delete(1);
        assertTrue(deletedId);
    }
}