package chap07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import chap07.dto.AutoDebitReq;
import chap07.dto.RegisterResult;
import chap07.repository.AutoDebitInfoRepository;
import chap07.repository.JpaAutoDebitInfoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AutoDebitRegisterTest {
    private AutoDebitRegister register;

    @BeforeEach
    void setUp() {
        CardNumberValidator validator = new CardNumberValidator();
        AutoDebitInfoRepository repository = new JpaAutoDebitInfoRepository();
        register = new AutoDebitRegister(validator, repository);
    }

    @Test
    void validCard() {
        AutoDebitReq req = new AutoDebitReq("user1", "1234123412341234");
        RegisterResult result = this.register.register(req);
        assertEquals(CardValidity.VALID, result.getValidity());
    }

    @Test
    void theftCard() {
        AutoDebitReq req = new AutoDebitReq("user1", "1234567890123456");
        RegisterResult result = this.register.register(req);
        assertEquals(CardValidity.THEFT, result.getValidity());
    }
}
