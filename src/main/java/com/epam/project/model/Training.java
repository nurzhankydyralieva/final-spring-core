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

    public Training() {
    }

    public Training(Integer id, String trainingName) {
        this.id = id;
        this.trainingName = trainingName;
    }

    public Training(Integer id, Trainee traineeId, Trainer trainerId, String trainingName, TrainingType trainingTypeId, Date trainingDate, Number trainingDuration) {
        this.id = id;
        this.traineeId = traineeId;
        this.trainerId = trainerId;
        this.trainingName = trainingName;
        this.trainingTypeId = trainingTypeId;
        this.trainingDate = trainingDate;
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

    public void setTraineeId(Trainee traineeId) {
        this.traineeId = traineeId;
    }

    public Trainer getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Trainer trainerId) {
        this.trainerId = trainerId;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public TrainingType getTrainingTypeId() {
        return trainingTypeId;
    }

    public void setTrainingTypeId(TrainingType trainingTypeId) {
        this.trainingTypeId = trainingTypeId;
    }

    public Date getTrainingDate() {
        return trainingDate;
    }

    public void setTrainingDate(Date trainingDate) {
        this.trainingDate = trainingDate;
    }

    public Number getTrainingDuration() {
        return trainingDuration;
    }

    public void setTrainingDuration(Number trainingDuration) {
        this.trainingDuration = trainingDuration;
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
