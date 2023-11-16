package com.epam.project.dao;

import com.epam.project.model.Trainer;
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
public class TrainerDAO {
    @Autowired
    private Storage storage;

    @Value("${data.file.path.trainer}")
    private String dataFilePath;

    public void writeDataToTrainerFile(Map<Integer, Trainer> trainers) {
        try (FileWriter writer = new FileWriter("data_trainer.txt")) {
            for (Map.Entry<Integer, Trainer> entry : trainers.entrySet()) {
                Trainer trainer = entry.getValue();
                writer.write(trainer.getId() + "," + trainer.getName() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateDataInTrainerFile(int id, Trainer updatedTrainer) {

        Map<Integer, Trainer> existingData = readDataFromTrainerFile();

        existingData.put(id, updatedTrainer);

        writeDataToTrainerFile(existingData);
    }

    public Map<Integer, Trainer> readDataFromTrainerFile() {
        Map<Integer, Trainer> trainers = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(dataFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    trainers.put(id, new Trainer(id, name));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        storage.setTrainers(trainers);
        return trainers;
    }


    public String setDataFilePath(String dataFilePath) {
        return dataFilePath;
    }
}
