package com.sebasdevone.practiceCiCd.application.mappers;

import com.sebasdevone.practiceCiCd.application.dtos.UserCompletedDto;
import com.sebasdevone.practiceCiCd.domain.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserCompletedDtoMapper {
    UserCompletedDto toUserCompletedDto(User user);
    User toUser(UserCompletedDto userCompletedDto);
}
