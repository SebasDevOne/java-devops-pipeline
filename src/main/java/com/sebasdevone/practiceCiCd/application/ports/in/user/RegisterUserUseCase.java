package com.sebasdevone.practiceCiCd.application.ports.in.user;

import com.sebasdevone.practiceCiCd.application.dtos.UserCompletedDto;
import com.sebasdevone.practiceCiCd.application.useCases.commands.RegisterUserCommand;

public interface RegisterUserUseCase {
    UserCompletedDto execute(RegisterUserCommand user);
}
