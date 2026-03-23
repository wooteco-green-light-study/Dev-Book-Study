package chap08;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PaySync {
    private String filePath = "D:\\data\\pay\\cp0001.csv";
    private PayInfoDao payInfoDao = new PayInfoDao();

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void sync(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        List<PayInfo> payInfos = Files.lines(path)
                .map(line -> {
                    String[] data = line.split(",");
                    PayInfo payInfo = new PayInfo(
                            data[0], data[1], Integer.parseInt(data[2])
                    );
                    return payInfo;
                })
                .toList();
        payInfos.forEach(payInfo -> payInfoDao.insert(payInfo));
    }
}
