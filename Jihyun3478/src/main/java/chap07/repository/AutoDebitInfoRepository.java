package chap07.repository;

import chap07.dto.AutoDebitInfo;

public interface AutoDebitInfoRepository {
    void save(AutoDebitInfo info);
    AutoDebitInfo findOne(String userId);
}
