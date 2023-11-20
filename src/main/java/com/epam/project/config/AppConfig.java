package com.epam.project.config;

import com.epam.project.dao.TraineeDAO;
import com.epam.project.dao.TrainerDAO;
import com.epam.project.dao.TrainingDAO;
import com.epam.project.service.TraineeService;
import com.epam.project.service.TrainerService;
import com.epam.project.service.TrainingService;
import com.epam.project.storage.Storage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.epam.project")
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Bean(initMethod = "initBean", destroyMethod = "destroyBean")
    public Storage storage() {
        return new Storage();
    }

    @Bean
    public TrainerService trainerService() {
        return new TrainerService(trainerDAO());
    }

    @Bean
    public TraineeService traineeService() {
        return new TraineeService(traineeDAO());
    }

    @Bean
    public TrainingService trainingService() {
        return new TrainingService(trainingDAO());
    }

    @Bean
    public TrainerDAO trainerDAO() {
        TrainerDAO object = new TrainerDAO();
        return object;
    }

    @Bean
    public TraineeDAO traineeDAO() {
        TraineeDAO object = new TraineeDAO();
        return object;
    }

    @Bean
    public TrainingDAO trainingDAO() {
        TrainingDAO object = new TrainingDAO();
        return object;
    }
}
