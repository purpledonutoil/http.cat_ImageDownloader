import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpStatusChecker {
    public static final HttpClient CLIENT = HttpClient.newHttpClient();

    public String getStatusImage(int code) throws IOException, InterruptedException {
        String webPage = "https://http.cat/" + code + ".jpg";
        String webPageError = "https://http.cat/404.jpg";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(webPage))
                .build();

        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        if(response.statusCode() == HttpURLConnection.HTTP_NOT_FOUND){
            return webPageError;
        }
        else{
            return webPage;
        }
    }
}
