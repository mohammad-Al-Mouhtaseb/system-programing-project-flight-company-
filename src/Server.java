
import java.io.*;
import java.net.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import jdk.nashorn.internal.parser.DateParser;

class Server {

    public static ArrayList<Flight> flights = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        readFlightDetails();
        int count = 0;
        long[] ids = new long[10];
        try (ServerSocket ss = new ServerSocket(7000)) {
            System.out.println("Listening...");
            while (true) {
                count++;
                Socket s = ss.accept();
                Runnable r = new ClientHandler(s, count);
                Thread t = new Thread(r);
                t.start();
                ids[count - 1] = t.getId();
                if (Thread.activeCount() != count + 1) {
                    count = Thread.activeCount();
                }
            }
        }
    }

    public static void readFlightDetails() {

        String[] flightDetails = new String[10];
        String departurePlace;
        String destinationPlace;
        String Type;
        String RequiredDocuments;
        String classType;
        String[] Date;
        String Time;
        double Cost;
        String approximateTime;
        int sets;

        try (Scanner read = new Scanner(new FileInputStream("mainfilght.txt"));) {
            boolean end = false;
            while (!end) {
                if (!read.hasNextLine()) {
                    end = true;
                } else {
                    String line = read.nextLine();
                    flightDetails = line.split(",");
                    departurePlace = flightDetails[0];
                    destinationPlace = flightDetails[1];
                    Type = flightDetails[2];
                    RequiredDocuments = flightDetails[3];
                    classType = flightDetails[4];
                    Date = flightDetails[5].split("_");
                    int deptDay = Integer.parseInt(Date[0]);
                    int deptMonth = Integer.parseInt(Date[1]);
                    int deptYear = Integer.parseInt(Date[2]);
                    Time = flightDetails[6];
                    Cost = Double.parseDouble(flightDetails[7]);
                    approximateTime = flightDetails[8];
                    sets=Integer.parseInt( flightDetails[9]);
                    flights.add(new Flight(departurePlace, destinationPlace, Type, RequiredDocuments, classType, deptDay, deptMonth, deptYear, Time, Cost, approximateTime, sets));
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }   

    void main() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

class ClientHandler implements Runnable {

    private Socket s;
    private int count;
    private long id;
    InputStream io;
    OutputStream os;
    private PrintWriter pw;

    ClientHandler(Socket s, int count) {
        this.s = s;
        this.count = count;
    }

    public long getId() {
        id = Thread.currentThread().getId();
        return id;
    }

    @Override
    public void run() {
        Main_Jframe m = new Main_Jframe();
        m.setVisible(true);
        try {
            io = s.getInputStream();
        } catch (IOException e) {
            System.err.println(e);
        }
        try (Scanner sc = new Scanner(io)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
//        System.out.println(line+"asdsda");
            }
        } finally {
        }
    }
}
