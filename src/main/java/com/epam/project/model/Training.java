package com.epam.project.model;

import java.util.Date;

public class Training {
    private Integer id;
    private Trainee traineeId;
    private Trainer trainerId;
    private String trainingName;
    private TrainingType trainingTypeId;
    private Date trainingDate;
    private Number trainingDuration;

    public Training(Integer id, String trainingName) {
        this.id = id;
        this.trainingName = trainingName;
    }

    public Training(Integer id, String trainingName, Number trainingDuration) {
        this.id = id;
        this.trainingName = trainingName;
        this.trainingDuration = trainingDuration;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Trainee getTraineeId() {
        return traineeId;
    }

    public Trainer getTrainerId() {
        return trainerId;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public TrainingType getTrainingTypeId() {
        return trainingTypeId;
    }

    public Date getTrainingDate() {
        return trainingDate;
    }

    public Number getTrainingDuration() {
        return trainingDuration;
    }

    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", traineeId=" + traineeId +
                ", trainerId=" + trainerId +
                ", trainingName='" + trainingName + '\'' +
                ", trainingTypeId=" + trainingTypeId +
                ", trainingDate=" + trainingDate +
                ", trainingDuration=" + trainingDuration +
                '}';
    }
}
