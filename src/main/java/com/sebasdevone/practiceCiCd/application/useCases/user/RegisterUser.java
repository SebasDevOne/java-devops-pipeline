package com.sebasdevone.practiceCiCd.application.useCases.user;

import com.sebasdevone.practiceCiCd.application.dtos.UserCompletedDto;
import com.sebasdevone.practiceCiCd.application.mappers.UserComandsMapper;
import com.sebasdevone.practiceCiCd.application.ports.in.user.RegisterUserUseCase;
import com.sebasdevone.practiceCiCd.application.useCases.commands.RegisterUserCommand;
import com.sebasdevone.practiceCiCd.domain.ports.out.UserRepositoryPort;

public class RegisterUser implements RegisterUserUseCase {
    private final UserComandsMapper userCommandsMapper;
    private final UserRepositoryPort userRepositoryPort;

    public RegisterUser(UserComandsMapper userCommandsMapper, UserRepositoryPort userRepositoryPort) {
        this.userCommandsMapper = userCommandsMapper;
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public UserCompletedDto execute(RegisterUserCommand user) {
        return userCommandsMapper.toUserCompletedDto(userRepositoryPort.save(userCommandsMapper.toUser(user)));
    }
}
