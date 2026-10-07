package com.sebasdevone.practiceCiCd.application.ports.in.user;

import com.sebasdevone.practiceCiCd.application.dtos.UserUpdatedDto;

import java.time.LocalDate;
import java.util.UUID;

public interface UpdateUserDateBirthdayUseCase {
    UserUpdatedDto execute(String id, LocalDate dateOfBirth);
}
