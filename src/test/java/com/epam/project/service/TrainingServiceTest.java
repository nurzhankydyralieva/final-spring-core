package com.epam.project.service;

import com.epam.project.dao.TrainingDAO;
import com.epam.project.model.Training;
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
class TrainingServiceTest {
    @Mock
    private TrainingDAO trainingDAO;
    @InjectMocks
    private TrainingService trainingService;
    private Map<Integer, Training> trainings;

    @BeforeEach
    public void setUp() {
        trainingDAO = mock(TrainingDAO.class);
        trainingService = new TrainingService(trainingDAO);
        trainings = new HashMap<>();
        trainings.put(1, new Training(1, "Dance"));
        trainings.put(2, new Training(2, "Basketball"));

    }

    @Test
    @DisplayName("Training is created")
    void create() {
        trainingService.create(trainings);
        assertTrue(trainings.containsKey(2));
    }

    @Test
    @DisplayName("Training are selected")
    void select() {
        trainingService.select();
        assertEquals(2, trainings.size());
    }
}