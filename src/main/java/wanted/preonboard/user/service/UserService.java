package wanted.preonboard.user.service;

public interface UserService {
    public void join(String email, String password);

    boolean validate(String email, String password);

    boolean duplicatedCheck(String email);

    public void login(String email, String password);

    boolean pwcheck(String password, String dbPw);
}
