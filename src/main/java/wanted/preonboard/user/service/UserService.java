package wanted.preonboard.user.service;

public interface UserService {
    public void join(String email, String password);

    boolean validate(String email, String password);
}
