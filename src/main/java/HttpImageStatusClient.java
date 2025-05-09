import java.io.IOException;
import java.util.Scanner;

public class HttpImageStatusClient {
    HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();

    public void askStatus(){
        int code;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter HTTP status code");
        while (true){
            String variable = in.nextLine();
            if (variable.matches("-?\\d+")){
                code = Integer.parseInt(variable);
                try {
                    httpStatusImageDownloader.downloadStatusImage(code);
                } catch (IOException | InterruptedException e) {
                    System.out.println("There is not image for HTTP status " + code);
                }
                break;
            }else {
                System.out.println("Please enter a valid number");
            }
        }
    }

    public static void main(String[] args) {
        HttpImageStatusClient h = new HttpImageStatusClient();
        h.askStatus();
    }
}
