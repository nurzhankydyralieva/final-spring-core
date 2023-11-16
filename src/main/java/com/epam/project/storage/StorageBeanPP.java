package com.epam.project.storage;

import com.epam.project.model.Trainee;
import com.epam.project.model.Trainer;
import com.epam.project.model.Training;
import com.epam.project.model.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class StorageBeanPP implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Storage) {
            Map<Integer, User> users = new HashMap<>();
            users.put(1, new User(1, "Andrea", "Bocelli", "Music", "password", true));
            users.put(2, new User(2, "Sarah", "Conor", "Smith", "password", true));
            ((Storage) bean).writeDataToUserStorageFile(users);

            Map<Integer, Trainer> trainers = new HashMap<>();
            trainers.put(1, new Trainer(1, "Tom"));
            trainers.put(2, new Trainer(2, "Sarah"));
            trainers.put(3, new Trainer(3, "Andrea"));
            ((Storage)bean).writeDataToTrainerFile(trainers);

            Map<Integer, Trainee> trainees = new HashMap<>();
            trainees.put(1, new Trainee(1, "Kyrgyzstan"));
            trainees.put(2, new Trainee(2, "Berlin"));
            trainees.put(3, new Trainee(3, "New York"));
            ((Storage) bean).writeDataToTraineeFile(trainees);

            Map<Integer, Training> trainings = new HashMap<>();
            trainings.put(1, new Training(1, "Cross-country running"));
            trainings.put(2, new Training(2, "Olympic weightlifting"));
            trainings.put(3, new Training(3, "Chess boxing"));
            ((Storage)bean).writeDataToTrainingFile(trainings);
        }
        //   System.out.println("Called postProcessBeforeInitialization() for: " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //  System.out.println("Called postProcessAfterInitialization() for: " + beanName);
        return bean;
    }
}
