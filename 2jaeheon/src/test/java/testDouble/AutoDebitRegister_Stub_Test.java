//package testDouble;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static testDouble.CardValidity.INVALID;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//public class AutoDebitRegister_Stub_Test {
//    private AutoDebitRegister register;
//    private StubCardNumberValidator stubValidator;
//    private StubAutoDebitInfoRepository stubRepository;
//
//    @BeforeEach
//    void setUp() {
//        stubValidator = new StubCardNumberValidator();
//        stubRepository = new StubAutoDebitInfoRepository();
//        register = new AutoDebitRegister(stubValidator, stubRepository);
//    }
//
//    @Test
//    void invalidCard() {
//        stubValidator.setInvalidNo("111122223333");
//
//        AutoDebitReq req = new AutoDebitReq("user1", "111122223333");
//        RegisterResult result = register.register(req);
//
//        assertEquals(INVALID, result.getValidity());
//    }
//
//    @Test
//    void theftCard() {
//        stubValidator.setTheftNo("123456789013456");
//
//        AutoDebitReq req = new AutoDebitReq("user1", "123456789013456");
//        RegisterResult result = this.register.regitser(req);
//
//        assertEquals(CardValidity.THEFT, result.getValidity());
//    }
//}
