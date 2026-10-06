package com.sebasdevone.practiceCiCd.domain.entities;

import com.sebasdevone.practiceCiCd.domain.vo.Email;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import java.util.UUID;

public class User {
    private static final int HOURS_PER_DAY = 24;
    private static final float MIN_HEALTH_SCORE = 0f;
    private static final float MAX_HEALTH_SCORE = 10f;

    private final UUID id;
    private String firstName;
    private String lastName;
    private Email email;
    private LocalDate dateOfBirth;
    private boolean isServiceNetwork;
    private char gender;
    private String address;
    private String phone;
    private Integer age;
    private Integer freeTime;
    private Integer workTime;
    private Integer excerciseTime;
    private Integer sleepTime;
    private float healthScore;
    private boolean isHealthy;
    private boolean isDiabetes;
    private boolean isHypertension;

    public User( String firstName, String lastName, String email, LocalDate dateOfBirth, boolean isServiceNetwork, char gender, String address, String phone, Integer age, Integer freeTime, Integer workTime, Integer excerciseTime, Integer sleepTime, float healthScore, boolean isHealthy, boolean isDiabetes, boolean isHypertension) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = new Email(email);
        this.dateOfBirth = dateOfBirth;
        this.isServiceNetwork = isServiceNetwork;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.age = age;
        this.freeTime = freeTime;
        this.workTime = workTime;
        this.excerciseTime = excerciseTime;
        this.sleepTime = sleepTime;
        this.healthScore = healthScore;
        this.isHealthy = isHealthy;
        this.isDiabetes = isDiabetes;
        this.isHypertension = isHypertension;
    }

    public void updatePersonalInfo(String firstName, String lastName, char gender) {
        this.firstName = requireNotBlank(firstName, "firstName");
        this.lastName = requireNotBlank(lastName, "lastName");
        this.gender = gender;
    }

    public void updateContactInfo(String email, String phone, String address) {
        requireNotBlank(email, "email");
        this.email = new Email(email);
        this.phone = requireNotBlank(phone, "phone");
        this.address = requireNotBlank(address, "address");
    }

    public void updateDateOfBirth(LocalDate dateOfBirth) {
        Objects.requireNonNull(dateOfBirth, "dateOfBirth must not be null");
        if (dateOfBirth.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("dateOfBirth cannot be in the future");
        }
        this.dateOfBirth = dateOfBirth;
        this.age = Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    public void updateDailyRoutine(Integer freeTime, Integer workTime, Integer excerciseTime, Integer sleepTime) {
        requireNonNegative(freeTime, "freeTime");
        requireNonNegative(workTime, "workTime");
        requireNonNegative(excerciseTime, "excerciseTime");
        requireNonNegative(sleepTime, "sleepTime");
        if (freeTime + workTime + excerciseTime + sleepTime > HOURS_PER_DAY) {
            throw new IllegalArgumentException("daily routine cannot exceed " + HOURS_PER_DAY + " hours");
        }
        this.freeTime = freeTime;
        this.workTime = workTime;
        this.excerciseTime = excerciseTime;
        this.sleepTime = sleepTime;
    }

    public void updateHealthStatus(float healthScore, boolean isHealthy, boolean isDiabetes, boolean isHypertension) {
        if (healthScore < MIN_HEALTH_SCORE || healthScore > MAX_HEALTH_SCORE) {
            throw new IllegalArgumentException(
                    "healthScore must be between " + MIN_HEALTH_SCORE + " and " + MAX_HEALTH_SCORE);
        }
        this.healthScore = healthScore;
        this.isHealthy = isHealthy;
        this.isDiabetes = isDiabetes;
        this.isHypertension = isHypertension;
    }

    public void updateServiceNetwork(boolean isServiceNetwork) {
        this.isServiceNetwork = isServiceNetwork;
    }

    private static String requireNotBlank(String value, String field) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(field + " must not be blank");
        }
        return value.trim();
    }

    private static void requireNonNegative(Integer value, String field) {
        Objects.requireNonNull(value, field + " must not be null");
        if (value < 0) {
            throw new IllegalArgumentException(field + " must not be negative");
        }
    }
}
