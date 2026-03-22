//package chap08;
//
//public class LoginService {
//    private String authKey = "somekey";
//    private CustomerRepository customerRepo;
//
//    public LoginService(CustomerRepository customerRepository) {
//        this.customerRepo = customerRepo;
//    }
//
//    public LoginResult login(String id, String pw) {
//        int resp = 0;
//        boolean authorized = AuthUtil.authorize(authKey);
//        if (authorized) {
//            resp = Authorized.authorize(authKey);
//        } else {
//            resp = -1;
//        }
//        if (resp == -1) return LoginResult.badAuthKey();
//
//        if (resp == 1) {
//            Customor c = customerRepo.findOne(id);
//            return LoginResult.authenticated(c);
//        } else {
//            return LoginResult.fail(resp);
//        }
//    }
//}
