package chap07;

import chap07.dto.AutoDebitInfo;
import chap07.dto.AutoDebitReq;
import chap07.dto.RegisterResult;
import chap07.repository.AutoDebitInfoRepository;
import java.time.LocalDateTime;

public class AutoDebitRegister {
    private CardNumberValidator validator;
    private AutoDebitInfoRepository repository;

    public AutoDebitRegister(CardNumberValidator validator, AutoDebitInfoRepository repository) {
        this.validator = validator;
        this.repository = repository;
    }

    public RegisterResult register(AutoDebitReq req) {
        CardValidity validity = validator.validate(req.cardNumber());

        if (validity != CardValidity.VALID) {
            return RegisterResult.error(validity);
        }
        AutoDebitInfo info = repository.findOne(req.userId());
        if (info != null) {
            info.changeCardNumber(req.cardNumber());
        } else {
            AutoDebitInfo newInfo = new AutoDebitInfo(req.userId(), req.cardNumber(), LocalDateTime.now());
            repository.save(newInfo);
        }
        return RegisterResult.success();
    }
}
