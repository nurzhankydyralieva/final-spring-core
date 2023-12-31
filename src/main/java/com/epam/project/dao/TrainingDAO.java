package com.epam.project.dao;

import com.epam.project.model.Training;
import com.epam.project.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Repository
public class TrainingDAO {
    @Autowired
    private Storage storage;

    @Value("${data.file.path.training}")
    private String dataFilePath;

    public void writeDataToTrainingFile(Map<Integer, Training> trainings) {
        try (FileWriter writer = new FileWriter("data_training.txt")) {
            for (Map.Entry<Integer, Training> entry : trainings.entrySet()) {
                Training training = entry.getValue();
                writer.write(training.getId() + "," + training.getTrainerId() + ", "
                        + training.getTrainingName() + ", " + training.getTrainingTypeId()
                        + ", " + training.getTrainingDate() + ", " + training.getTrainingDuration() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<Integer, Training> readDataFromTrainingFile() {
        Map<Integer, Training> trainings = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(dataFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    int id = Integer.parseInt(parts[0]);
                    String trainingName = parts[2];
                    trainings.put(id, new Training(id, trainingName));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        storage.setTrainings(trainings);
        return trainings;
    }

    public String setDataFilePath(String dataFilePath) {
        return dataFilePath;
    }

}
