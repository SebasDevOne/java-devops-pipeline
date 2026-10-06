package com.sebasdevone.practiceCiCd.application.ports.in.user;

import com.sebasdevone.practiceCiCd.application.dtos.UserCompletedDto;

import java.util.UUID;

public interface FindCustomerByIDUseCase {
    UserCompletedDto execute(String id);
}
