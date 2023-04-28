package com.benjrozen.bookcartDemo.restAssured.requests;

import com.benjrozen.bookcartDemo.logging.MaskSensitiveData;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequest {
    String username;
    @MaskSensitiveData
    String password;
}
