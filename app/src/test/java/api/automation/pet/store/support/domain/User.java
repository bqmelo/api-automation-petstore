package api.automation.pet.store.support.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    @Builder.Default
    private int id = 10;
    @Builder.Default
    private String username = "bmelo";
    @Builder.Default
    private String firstName = "Bruna";
    @Builder.Default
    private String lastName = "Melo";
    @Builder.Default
    private String email = "bruna@mailinator.com";
    @Builder.Default
    private String password = "5435234";
    @Builder.Default
    private String phone = "254352";
    @Builder.Default
    private int userStatus = 1;
}
