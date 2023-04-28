package com.benjrozen.bookcartDemo.restAssured.responses;

import com.benjrozen.bookcartDemo.logging.MaskSensitiveData;
import lombok.Data;

@Data
public class LoginResponse {
    @MaskSensitiveData
    String token;
    UserDetails userDetails;

    @Data
    public static class UserDetails{
        int userId;
        Object firstName;
        Object lastName;
        String username;
        Object password;
        Object gender;
        int userTypeId;
    }
}
