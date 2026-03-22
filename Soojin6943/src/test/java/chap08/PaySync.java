//package chap08;
//
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.stream.Collectors;
//
//public class PaySync {
//    private String filePath = "D:\\data\\pay\\cp0001.csv";
//
//    public void setFilePath(String filePath) {
//        this.filePath == filePath;
//    }
////    private PayInfoDao payInfoDao = new PayInfoDao();
//    private PayInfoDao payInfoDao;
//
//    public PaySync(PayInfoDao payInfoDao) {
//        this.payInfoDao = payInfoDao;
//    }
//
//    public void setPayInfoDao(PayInfoDao payInfoDao) {
//        this.payInfoDao = payInfoDao
//    }
//
//    public void sync() throws Exception{
//        Path path = Paths.get(filePath);
//        List<PayInfo> payInfos = Files.lines(path)
//                .map(line -> {
//                    String[] data = line.split(",");
//                    PayInfo payInfo = new PayInfo(
//                            data[0], data[1], Integer.parseInt(data[2])
//                    );
//                    return payInfo;
//                })
//                .collect(Collectors.toList());
//        payInfos.forEach(pi -> payInfoDao.insert(pi));
//    }
//}
