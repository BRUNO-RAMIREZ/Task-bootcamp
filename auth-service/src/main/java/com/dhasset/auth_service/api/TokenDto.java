package com.dhasset.auth_service.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Bruno Ramirez
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TokenDto {

    private String token;
}
