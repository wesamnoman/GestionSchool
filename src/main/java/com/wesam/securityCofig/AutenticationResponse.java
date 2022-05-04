package com.wesam.securityCofig;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class AutenticationResponse {
     private final String jwt;
}
