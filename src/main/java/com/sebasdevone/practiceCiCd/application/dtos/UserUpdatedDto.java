package com.sebasdevone.practiceCiCd.application.dtos;

import java.time.Instant;
import java.util.UUID;

public record UserUpdatedDto (
        UUID id,
        String firstName,
        String lastName,
        String email,
        Instant updatedAt
) {
}
