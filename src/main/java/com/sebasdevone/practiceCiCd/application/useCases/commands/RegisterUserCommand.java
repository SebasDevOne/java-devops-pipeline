package com.sebasdevone.practiceCiCd.application.useCases.commands;

import java.time.LocalDate;
import java.util.UUID;

public record RegisterUserCommand(
        String firstName,
        String lastName,
        String email,
        LocalDate dateOfBirth,
        boolean isServiceNetwork,
        char gender,
        String address,
        String phone,
        Integer age,
        Integer freeTime,
        Integer workTime,
        Integer excerciseTime,
        Integer sleepTime,
        float healthScore,
        boolean isHealthy,
        boolean isDiabetes,
        boolean isHypertension
) {
}
