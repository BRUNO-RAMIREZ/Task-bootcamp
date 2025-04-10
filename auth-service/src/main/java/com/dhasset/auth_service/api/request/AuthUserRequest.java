package com.dhasset.auth_service.api.request;

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
public class AuthUserRequest {

    private String userName;

    private String password;
}
