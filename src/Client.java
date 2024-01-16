import java.io.*;
import java.net.*;
import java.util.*;

class Client {
  public static void main(String[] args) {
    try (Socket socket = new Socket("localhost", 7000)) {
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      String line = null;
      Scanner sc = null;
      while (!"exit".equalsIgnoreCase(line)) {
      sc = new Scanner(System.in);
        line = sc.nextLine();
        out.println(line);
        out.flush();
      }
      sc.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
