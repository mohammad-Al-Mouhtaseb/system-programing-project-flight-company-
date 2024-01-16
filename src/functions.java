
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author malmo
 */
public class functions {

    public static void users_file_register(String var) throws FileNotFoundException, IOException {
        String read = "";
        File file = new File("users.txt"); // Specify the file name
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            read = read + line + "\n"; // Print each line of the file
        }
        br.close();
        PrintWriter out = new PrintWriter("users.txt");
        out.println(read + var);
        System.out.println(read + var + "\n");
        out.close();
    }

    public static boolean users_file_login(String username, String password) {
        BufferedReader br = null;
        try {
            String sub_string = "username:" + username + " password:" + password;
            File file = new File("users.txt"); // Specify the file name
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(sub_string)) {
                    br.close();
                    return true;
                }
            }
            br.close();
            return false;
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        return false;
    }

    public static ArrayList<String> searchFlight(int day, int month, int year, String departurePlace, String destinationPlace) {
        Flight flight1 = new Flight();
        flight1.setDepartureDate(day, month, year);
        int availableSeatCount = 0;
        ArrayList<String> str = new ArrayList<>();
        for (Flight flight : Server.flights) {
            if (flight.getDeparturePlace().compareTo(departurePlace) == 0 && flight.getDestinationPlace().compareTo(destinationPlace) == 0) {
                if (flight.getDate().compareTo(flight1.getDate()) == 0 && flight.getSets() > 0) {
                    str.add(flight.getDeparturePlace() + "@" + flight.getDestinationPlace() + "@" + flight.getclassType() + "@" + flight.getRequiredDocuments() + "@" + flight.getDate() + "_" + flight.getTime() + "@" + flight.getCost() + "@" + flight.getApproximateTime());
                }
            }
        }
        return str;
    }

    public static void add_flight(Flight var) throws FileNotFoundException, IOException, ParseException {
        String read = "";
        File file = new File("mainfilght.txt"); // Specify the file name
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            read = read + line + "\n"; // Print each line of the file
        }
        br.close();
        PrintWriter out = new PrintWriter("mainfilght.txt");
        out.println(read + var.getDeparturePlace() + "," + var.getDestinationPlace() + "," + var.getType() + "," + var.getRequiredDocuments() + "," + var.getclassType() + "," + var.getDate2() + "," + var.getTime() + "," + var.getCost() + "," + var.getApproximateTime() + "," + var.getSets());
        JOptionPane.showMessageDialog(null, "Success");
        out.close();
    }

    public static void delete_flight(String departure, String arrival, String date, String time) throws FileNotFoundException, IOException, ParseException {
        String read = "";
        File file = new File("mainfilght.txt"); // Specify the file name
        BufferedReader br = new BufferedReader(new FileReader(file));
        boolean isdeleted=false;
        String line;
        while ((line = br.readLine()) != null) {
            if (line.contains(departure) && line.contains(arrival) && line.contains(date) && line.contains(time)) {
                JOptionPane.showMessageDialog(null, "Deleted: "+line);
                isdeleted=true;
            } else {
                read = read + line + "\n"; // Print each line of the file
            }
        }
        br.close();
        PrintWriter out = new PrintWriter("mainfilght.txt");
        out.println(read);
        if (!isdeleted) {
            JOptionPane.showMessageDialog(null, "No Flight Deleted");
        }
        out.close();
    }

    public static ArrayList<String> searchPreviosFilght() {

        int availableSeatCount = 0;
        ArrayList<String> str = new ArrayList<>();
        String[] flightDetails = new String[10];
        String user;
        String departurePlace;
        String destinationPlace;
        String Type;
        String RequiredDocuments;
        String classType;
        String[] Date;
        String Time;
        double Cost;
        String approximateTime;

        try (Scanner read = new Scanner(new FileInputStream("previosfilght.txt"));) {
            boolean end = false;
            while (!end) {
                if (!read.hasNextLine()) {
                    end = true;
                }
                String line = read.nextLine();
                flightDetails = line.split(",");
                user = flightDetails[0];
                departurePlace = flightDetails[1];
                destinationPlace = flightDetails[2];
                Type = flightDetails[3];
                RequiredDocuments = flightDetails[4];
                classType = flightDetails[5];
                Date = flightDetails[6].split("_");
                int deptDay = Integer.parseInt(Date[0]);
                int deptMonth = Integer.parseInt(Date[1]);
                int deptYear = Integer.parseInt(Date[2]);
                Flight flight1 = new Flight();
                flight1.setDepartureDate(deptDay, deptMonth, deptYear);
                Time = flightDetails[7];
                Cost = Double.parseDouble(flightDetails[8]);
                approximateTime = flightDetails[9];
                str.add(user + "@" + departurePlace + "@" + destinationPlace + "@" + Type + "@" + RequiredDocuments + "@" + classType + "@" + flight1.getDate() + "_" + Time + "@" + Cost + "@" + approximateTime);

            }

        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return str;
    }
    
    public static ArrayList<String> searchMyPreviosFilght(String uname) {

        int availableSeatCount = 0;
        ArrayList<String> str = new ArrayList<>();
        String[] flightDetails = new String[10];
        String user;
        String departurePlace;
        String destinationPlace;
        String Type;
        String RequiredDocuments;
        String classType;
        String[] Date;
        String Time;
        double Cost;
        String approximateTime;

        try (Scanner read = new Scanner(new FileInputStream("previosfilght.txt"));) {
            boolean end = false;
            while (!end) {
                if (!read.hasNextLine()) {
                    end = true;
                }
                String line = read.nextLine();
                if (line.contains(uname+",OS")) {
                    flightDetails = line.split(",");
                    user = flightDetails[0];
                    departurePlace = flightDetails[1];
                    destinationPlace = flightDetails[2];
                    Type = flightDetails[3];
                    RequiredDocuments = flightDetails[4];
                    classType = flightDetails[5];
                    Date = flightDetails[6].split("_");
                    int deptDay = Integer.parseInt(Date[0]);
                    int deptMonth = Integer.parseInt(Date[1]);
                    int deptYear = Integer.parseInt(Date[2]);
                    Flight flight1 = new Flight();
                    flight1.setDepartureDate(deptDay, deptMonth, deptYear);
                    Time = flightDetails[7];
                    Cost = Double.parseDouble(flightDetails[8]);
                    approximateTime = flightDetails[9];
                    str.add(user + "@" + departurePlace + "@" + destinationPlace + "@" + Type + "@" + RequiredDocuments + "@" + classType + "@" + flight1.getDate() + "_" + Time + "@" + Cost + "@" + approximateTime);
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return str;
    }

    public static String get_balance(String uname) {
        BufferedReader br = null;
        try {
            String sub_string = "username:" + uname + " password:";
            File file = new File("users.txt"); // Specify the file name
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(sub_string)) {
                    String[] subline = new String[4];
                    subline = line.split(" ");
                    String balance = subline[2];
                    String sub_balance = balance.substring(8);
                    br.close();
                    return sub_balance;
                }
            }
            br.close();
            return "Error";
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        return "Error";
    }

    public static void add_booking(String var, String uname, double new_balanced) throws FileNotFoundException, IOException {
        String read = "";
        File file = new File("previosfilght.txt"); // Specify the file name
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            read = read + line + "\n"; // Print each line of the file
        }
        br.close();
        PrintWriter out = new PrintWriter("previosfilght.txt");
        out.println(read + var);
        edit_user_balanced(uname, new_balanced);
        System.out.println(read + var + "\n");
        out.close();
    }

    public static void edit_user_balanced(String username, double new_balanced) throws FileNotFoundException, IOException {
        String read = "";
        File file = new File("users.txt"); // Specify the file name
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            if (line.contains("username:" + username)) {
                String[] l = new String[4];
                l = line.split(" ");
                line = l[0] + " " + l[1] + " " + "balance:" + new_balanced + " " + l[3];
            }
            read = read + line + "\n"; // Print each line of the file
        }
        br.close();
        PrintWriter out = new PrintWriter("users.txt");
        out.println(read);
        System.out.println(read + "\n");
        out.close();
    }

    public static double discount(String uname, String class_type) {
        int counter = 0;
        BufferedReader br = null;
        try {
            File file = new File("previosfilght.txt"); // Specify the file name
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(uname) && line.contains(class_type)) {
                    counter++;
                }
            }
            br.close();
            if (counter >= 3) {
                if (class_type.equals("High")) {
                    JOptionPane.showMessageDialog(null, "discount 50%");
                    return 0.5;
                } else if (class_type.equals("Business")) {
                    JOptionPane.showMessageDialog(null, "discount 30%");
                    return 0.3;
                }
            }
            return 1;

        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        return 1;
    }
}
