package com.sebasdevone.practiceCiCd.application.useCases.user;

import com.sebasdevone.practiceCiCd.application.dtos.UserUpdatedDto;
import com.sebasdevone.practiceCiCd.application.mappers.UserDtosMapper;
import com.sebasdevone.practiceCiCd.application.ports.in.user.UpdateUserDateBirthdayUseCase;
import com.sebasdevone.practiceCiCd.domain.entities.User;
import com.sebasdevone.practiceCiCd.domain.ports.out.UserRepositoryPort;

import java.time.LocalDate;
import java.util.UUID;

public class UpdateUserDateBirthday implements UpdateUserDateBirthdayUseCase {

    private final UserRepositoryPort userRepositoryPort;
    private final UserDtosMapper userDtosMapper;

    public UpdateUserDateBirthday(UserRepositoryPort userRepositoryPort, UserDtosMapper userDtosMapper) {
        this.userRepositoryPort = userRepositoryPort;
        this.userDtosMapper = userDtosMapper;
    }

    @Override
    public UserUpdatedDto execute(String id, LocalDate dateOfBirth) {
        User user = userRepositoryPort.findById(UUID.fromString(id));
        return user.updateDateOfBirth(dateOfBirth);
    }
}
