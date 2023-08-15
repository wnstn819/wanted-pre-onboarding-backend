package wanted.preonboard.user.service;



import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wanted.preonboard.config.WebSecurityConfig;
import wanted.preonboard.user.entity.UserEntity;
import wanted.preonboard.user.repository.UserRepository;
import wanted.preonboard.user.support.converter.UserConverter;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final WebSecurityConfig webSecurityConfig;

    @Override
    public void join(String email, String password) {
        if(validate(email,password) && duplicatedCheck(email)) {
            String encodePW = webSecurityConfig.getPasswordEncoder().encode(password);
            userRepository.save(UserConverter.to(email, encodePW));
        }
    }

    @Override
    public boolean validate(String email, String password){
        if(!email.contains("@")){
            throw new IllegalArgumentException("이메일에 @가 포함되지 않았습니다. 다시 입력해주세요!");
        }

        if(password.length() < 8 ){
            throw new IllegalArgumentException("비밀번호를 8자 이상 입력해주세요!");
        }

        return true;
    }

    @Override
    public boolean duplicatedCheck(String email){
        UserEntity userEntity = userRepository.findByEmail(email);
        if(userEntity == null){
            return true;
        }else{
            throw new IllegalArgumentException("이미 등록된 이메일이 있습니다.");
        }
    }

    @Override
    public void login(String email, String password) {

        if(validate(email,password)) {
            String encodePW = webSecurityConfig.getPasswordEncoder().encode(password);

            userRepository.save(UserConverter.to(email, encodePW));
        }

    }
}
