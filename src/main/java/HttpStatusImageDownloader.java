import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class HttpStatusImageDownloader{
    HttpStatusChecker httpStatusChecker = new HttpStatusChecker();

    public void downloadStatusImage(int code) throws IOException, InterruptedException {
        String webPage = httpStatusChecker.getStatusImage(code);

        Path folder = Paths.get("images");
        if (!Files.exists(folder)) {
            Files.createDirectories(folder);
        }

        try(InputStream in = new URL(webPage).openStream()){
            Files.copy(in, Paths.get("images/" + webPage.substring(17)), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}