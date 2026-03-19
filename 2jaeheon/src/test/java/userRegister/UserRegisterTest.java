package userRegister;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testDouble.StubWeakPasswordChecker;

public class UserRegisterTest {
    private UserRegister register;
    private StubWeakPasswordChecker stubPasswordChecker = new StubWeakPasswordChecker();

    @BeforeEach
    void setUp() {
        register = new UserRegister(stubPasswordChecker);
    }

    @DisplayName("약한 암호면 가입 실패")
    @Test
    void weakPassword() {
        stubPasswordChecker.setWeak(true); // 암호가 약하다고 응답하도록 설정
        /*
        여기는 스텁으로 하여금 암호 확인 요청에 대해 암호가 약하다고 응답하도록 한다.
        아직 구현 전이라 이를 위한 목적으로 작성한 코드이다.
        아직 메서드를 정하지 않았지만, 대신할 스텁이 setWeak() 메서드로 true를 전달받으면 암호가 약하다고 응답하게 구현할 것이다.
        */

        assertThrows(WeakPasswordException.class, () -> {
            register.register("id", "pw", "email");
        });
    }
}
