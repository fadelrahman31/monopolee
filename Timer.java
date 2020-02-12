import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Timer extends Thread{
    String message = "eiy";
    boolean cek = false;
    Scanner sc = new Scanner(System.in);
    public void run() {
        BufferedReader masuk = new BufferedReader(new InputStreamReader(System.in));
        while(!isInterrupted()) {
            try {
                if(masuk.ready()) {
                    message = sc.next();
                    System.out.println("WAIT FOR A MOMENT");
                    cek =true;
                }
            }
            catch (IOException event) {
                event.printStackTrace();
            }
        }
    }

    public String getMessage() {
        return (message);
    }

}
