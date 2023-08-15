package wanted.preonboard.user.support.converter;


import lombok.experimental.UtilityClass;
import wanted.preonboard.user.entity.UserEntity;

@UtilityClass
public class UserConverter {

    public static UserEntity to(String email, String password ) {
        return UserEntity.builder()
                .email(email)
                .passowrd(password)
                .build();
    }
}
