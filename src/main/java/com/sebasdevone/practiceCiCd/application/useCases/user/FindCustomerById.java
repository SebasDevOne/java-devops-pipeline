package com.sebasdevone.practiceCiCd.application.useCases.user;

import com.sebasdevone.practiceCiCd.application.dtos.UserCompletedDto;
import com.sebasdevone.practiceCiCd.application.mappers.UserCompletedDtoMapper;
import com.sebasdevone.practiceCiCd.application.ports.in.user.FindCustomerByIDUseCase;
import com.sebasdevone.practiceCiCd.domain.ports.out.UserRepositoryPort;

import java.util.UUID;

public class FindCustomerById implements FindCustomerByIDUseCase {
    private final UserRepositoryPort userRepositoryPort;
    private final UserCompletedDtoMapper userCompletedDtoMapper;

    public FindCustomerById(UserRepositoryPort userRepositoryPort, UserCompletedDtoMapper userCompletedDtoMapper) {
        this.userRepositoryPort = userRepositoryPort;
        this.userCompletedDtoMapper = userCompletedDtoMapper;
    }

    @Override
    public UserCompletedDto execute(String id) {
        UUID uuid = UUID.fromString(id);
        return userCompletedDtoMapper.toUserCompletedDto(userRepositoryPort.findById(uuid));
    }
}
