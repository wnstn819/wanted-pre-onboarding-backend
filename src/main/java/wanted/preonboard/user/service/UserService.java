package wanted.preonboard.user.service;

import wanted.preonboard.user.model.Token;

public interface UserService {
    public void join(String email, String password);

    boolean validate(String email, String password);

    boolean duplicatedCheck(String email);

    public Token login(String email, String password);

    boolean pwcheck(String password, String dbPw);
}
