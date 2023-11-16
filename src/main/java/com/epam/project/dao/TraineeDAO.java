package com.epam.project.dao;

import com.epam.project.model.Trainee;
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
public class TraineeDAO {
    @Autowired
    private Storage storage;

    @Value("${data.file.path.trainee}")
    private String dataFilePath;

    public void writeDataToTraineeFile(Map<Integer, Trainee> trainees) {
        try (FileWriter writer = new FileWriter("data_trainee.txt")) {
            for (Map.Entry<Integer, Trainee> entry : trainees.entrySet()) {
                Trainee trainee = entry.getValue();
                writer.write(trainee.getId() + "," + trainee.getDateOfBirth() + "," + trainee.getAddress() + ", " + trainee.getUserId() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<Integer, Trainee> readDataFromTraineeFile() {
        Map<Integer, Trainee> trainees = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(dataFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0]);
                    String address = parts[2];
                    trainees.put(id, new Trainee(id, address));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        storage.setTrainees(trainees);
        return trainees;
    }


    public void updateDataInTraineeFile(int id, Trainee updatedTrainee) {

        Map<Integer, Trainee> existingData = readDataFromTraineeFile();

        existingData.put(id, updatedTrainee);

        writeDataToTraineeFile(existingData);
    }


    public String setDataFilePath(String dataFilePath) {
        return dataFilePath;
    }

    public void deleteDataInTraineeFile(int id) {
        Map<Integer, Trainee> existingData = readDataFromTraineeFile();

        existingData.remove(id);

        writeDataToTraineeFile(existingData);
    }
}
