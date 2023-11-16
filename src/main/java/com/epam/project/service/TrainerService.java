package com.epam.project.service;

import com.epam.project.dao.TrainerDAO;
import com.epam.project.model.Trainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TrainerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TrainerService.class);

    private TrainerDAO trainerDAO;

    @Autowired
    public TrainerService(TrainerDAO trainerDAO) {
        this.trainerDAO = trainerDAO;
    }

    public void create(Map<Integer, Trainer> trainers) {
        LOGGER.info("Trainer is created");
        trainerDAO.writeDataToTrainerFile(trainers);
    }

    public Map<Integer, Trainer> select() {
        LOGGER.info("All trainers are selected");
        return trainerDAO.readDataFromTrainerFile();
    }

    public void update(int id, Trainer updatedTrainer) {
        LOGGER.info("Trainer is updated");
        trainerDAO.updateDataInTrainerFile(id, updatedTrainer);
    }
}
