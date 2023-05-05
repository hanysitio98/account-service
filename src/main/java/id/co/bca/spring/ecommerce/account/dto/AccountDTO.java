package id.co.bca.spring.ecommerce.account.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AccountDTO {

    private String name;
    private String email;
    private String username;
    private String password;
    private String role;
    private String phoneNumber;
    private Double balance;
}
