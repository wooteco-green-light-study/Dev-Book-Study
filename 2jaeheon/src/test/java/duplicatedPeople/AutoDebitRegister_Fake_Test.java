package duplicatedPeople;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testDouble.StubWeakPasswordChecker;
import userRegister.DupIddException;
import userRegister.EmailNotifier;
import userRegister.MemoryUserRepository;
import userRegister.SpyEmailNotifier;
import userRegister.User;
import userRegister.UserRegister;

public class AutoDebitRegister_Fake_Test {
    private UserRegister userRegister;
    private StubWeakPasswordChecker stubPasswordChecker = new StubWeakPasswordChecker();
    private MemoryUserRepository fakeRepository = new MemoryUserRepository();
    private EmailNotifier emailNotifier = new SpyEmailNotifier();

    @BeforeEach
    void setUp() {
        userRegister = new UserRegister(stubPasswordChecker, fakeRepository, emailNotifier);
    }

    @DisplayName("이미 같은 ID가 존재하면 가입 실패")
    @Test
    void dupIdExists() {
        // 이미 같은 ID 존재하는 상황 만들기
        fakeRepository.save(new User("id", "pw1", "email@email.com"));

        assertThrows(DupIddException.class, () -> {
            userRegister.register("id", "pw", "email");
        });
    }
}
