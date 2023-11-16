package com.epam.project.facade;

import com.epam.project.model.Trainee;
import com.epam.project.model.Trainer;
import com.epam.project.model.Training;
import com.epam.project.service.TraineeService;
import com.epam.project.service.TrainerService;
import com.epam.project.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ServiceFacade {
    private final TrainerService trainerService;
    private final TraineeService traineeService;
    private final TrainingService trainingService;

    @Autowired
    public ServiceFacade(TrainerService trainerService, TraineeService traineeService, TrainingService trainingService) {
        this.trainerService = trainerService;
        this.traineeService = traineeService;
        this.trainingService = trainingService;
    }

    public void createTrainer(Map<Integer, Trainer> trainers) {
        trainerService.create(trainers);
    }

    public Map<Integer, Trainer> selectTrainer() {
        return trainerService.select();
    }

    public void updateTrainer(int id, Trainer updatedTrainer) {
        trainerService.update(id, updatedTrainer);
    }


    public void createTrainee(Map<Integer, Trainee> trainees) {
        traineeService.create(trainees);
    }

    public Map<Integer, Trainee> selectTrainee() {
        return traineeService.select();
    }

    public void updateTrainee(int id, Trainee updatedTrainee) {
        traineeService.update(id, updatedTrainee);
    }

    public boolean deleteTrainee(int id){
        traineeService.delete(id);
        return true;
    }


    public void createTraining(Map<Integer, Training> trainings) {
        trainingService.create(trainings);
    }

    public Map<Integer, Training> selectTraining() {
        return trainingService.select();
    }

}
