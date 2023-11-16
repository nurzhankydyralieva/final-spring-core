package com.epam.project.service;

import com.epam.project.dao.TrainerDAO;
import com.epam.project.model.Trainer;
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
class TrainerServiceTest {
    @Mock
    private TrainerDAO trainerDAO;
    @InjectMocks
    private TrainerService trainerService;
    private Map<Integer, Trainer> trainers;

    @BeforeEach
    public void setUp() {
        trainerDAO = mock(TrainerDAO.class);
        trainerService = new TrainerService(trainerDAO);
        trainers = new HashMap<>();
        trainers.put(1, new Trainer(1, "John Doe"));
        trainers.put(2, new Trainer(2, "Jane Smith"));
        trainers.put(3, new Trainer(3, "Maks Leo"));
    }

    @Test
    @DisplayName("Trainer is created")
    void create() {
        trainerService.create(trainers);
        assertTrue(trainers.containsKey(1));
    }

    @Test
    @DisplayName("Trainers are selected")
    void select() {
        trainerService.select();
        assertEquals(3, trainers.size());
    }

    @Test
    @DisplayName("Trainer is updated")
    void update() {
        int idToUpdate = 1;
        Trainer updatedTrainer = new Trainer(1, "Updated Name");
        trainers.put(idToUpdate, updatedTrainer);
        trainerService.update(idToUpdate, updatedTrainer);

        assertTrue(trainers.containsKey(1));
        assertEquals(3, trainers.size());
    }
}