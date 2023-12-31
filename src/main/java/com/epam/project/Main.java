package com.epam.project;

import com.epam.project.config.AppConfig;
import com.epam.project.facade.ServiceFacade;
import com.epam.project.model.Trainee;
import com.epam.project.model.Trainer;
import com.epam.project.model.Training;
import com.epam.project.storage.Storage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ServiceFacade facade = context.getBean(ServiceFacade.class);
        Storage storage = context.getBean(Storage.class);
        // This is Trainer entity
        Map<Integer, Trainer> trainers = new HashMap<>();
        trainers.put(1, new Trainer(1, "Tom Obama"));
        trainers.put(2, new Trainer(2, "Sarah Smith"));
        trainers.put(3, new Trainer(3, "Andrea Bocelli"));


       facade.createTrainer(trainers);
     //   facade.updateTrainer(1, new Trainer(1, "Katy Perry"));
       facade.selectTrainer();

        Map<Integer, Trainer> trainers2 = storage.getTrainers();

        for (Map.Entry<Integer, Trainer> entry : trainers2.entrySet()) {
            Trainer trainer = entry.getValue();
            System.out.println("Trainer id: " + trainer.getId() + ", Trainer name: " + trainer.getName());
        }
        // This is Trainee entity
        Map<Integer, Trainee> trainees = new HashMap<>();
        trainees.put(1, new Trainee(1, "Kyrgyzstan"));
        trainees.put(2, new Trainee(2, "Berlin"));

//        facade.createTrainee(trainees);
//        facade.updateTrainee(1, new Trainee(1, "Dubai"));
//        facade.selectTrainee();
//        facade.deleteTrainee(1);

        Map<Integer, Trainee> trainees2 = storage.getTrainees();

        for (Map.Entry<Integer, Trainee> entry : trainees2.entrySet()) {
            Trainee trainee = entry.getValue();
            System.out.println("Trainee id: " + trainee.getId() + ", " + trainee.getDateOfBirth() + ", Address: " + trainee.getAddress() + ", " + trainee.getUserId());
        }
        // This is Training entity
        Map<Integer, Training> trainings = new HashMap<>();
        trainings.put(1, new Training(1, "Dance"));

        facade.createTraining(trainings);
      //  facade.selectTraining();

        Map<Integer, Training> trainings2 = storage.getTrainings();

        for (Map.Entry<Integer, Training> entry : trainings2.entrySet()) {
            Training training = entry.getValue();
            System.out.println("Training id: " + training.getId() + ", " + training.getTrainerId() + ", Training name: " + training.getTrainingName()
                    + ", Training date: " + training.getTrainingDate() + ", Training type: " + training.getTrainingTypeId() + ", Training duration: " + training.getTrainingDuration());
        }

        context.close();
    }
}
