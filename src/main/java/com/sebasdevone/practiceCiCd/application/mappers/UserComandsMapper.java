package com.sebasdevone.practiceCiCd.application.mappers;

import com.sebasdevone.practiceCiCd.application.dtos.UserCompletedDto;
import com.sebasdevone.practiceCiCd.application.useCases.commands.RegisterUserCommand;
import com.sebasdevone.practiceCiCd.domain.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserComandsMapper {
    RegisterUserCommand toRegisterUserCommand(User user);
    User toUser(RegisterUserCommand registerUserCommand);
    UserCompletedDto toUserCompletedDto(RegisterUserCommand command);
    UserCompletedDto toUserCompletedDto(User user);
}

