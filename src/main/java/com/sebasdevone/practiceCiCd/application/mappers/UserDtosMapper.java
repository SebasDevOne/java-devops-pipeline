package com.sebasdevone.practiceCiCd.application.mappers;

import com.sebasdevone.practiceCiCd.application.dtos.UserCompletedDto;
import com.sebasdevone.practiceCiCd.application.dtos.UserUpdatedDto;
import com.sebasdevone.practiceCiCd.application.useCases.commands.RegisterUserCommand;
import com.sebasdevone.practiceCiCd.domain.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserCompletedDtosMapper {
    //Para los mappers de  Completed DTOs
    UserCompletedDto toUserCompletedDto(User user);
    User toUser(UserCompletedDto userCompletedDto);

    //Zona para el mapper de los Dtos de updated
    @Mapping(target = "updatedAt", expression = "java(java.time.Instant.now())")
    UserUpdatedDto toUserUpdatedDto(User user);

}
