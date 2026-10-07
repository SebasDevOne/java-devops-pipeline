package com.sebasdevone.practiceCiCd.application.useCases.user;

import com.sebasdevone.practiceCiCd.application.dtos.UserCompletedDto;
import com.sebasdevone.practiceCiCd.application.mappers.UserDtosMapper;
import com.sebasdevone.practiceCiCd.application.ports.in.user.FindCustomerByIDUseCase;
import com.sebasdevone.practiceCiCd.domain.ports.out.UserRepositoryPort;

import java.util.UUID;

public class FindCustomerById implements FindCustomerByIDUseCase {
    private final UserRepositoryPort userRepositoryPort;
    private final UserDtosMapper userCommandsMapper;

    public FindCustomerById(UserRepositoryPort userRepositoryPort, UserDtosMapper userCommandsMapper) {
        this.userRepositoryPort = userRepositoryPort;
        this.userCommandsMapper = userCommandsMapper;
    }

    @Override
    public UserCompletedDto execute(String id) {
        UUID uuid = UUID.fromString(id);
        return userCommandsMapper.toUserCompletedDto(userRepositoryPort.findById(uuid));
    }
}
