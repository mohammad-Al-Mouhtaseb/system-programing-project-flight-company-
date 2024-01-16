
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author malmo
 */
public class main_load extends Thread {

    public static void main(String[] args) throws InterruptedException, IOException, ParseException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                Server s=new Server();
                try {
                    s.main(args);
                } catch (IOException ex) {
                    Logger.getLogger(main_load.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                Client c=new Client();
                c.main(args);
            }
        };
        t1.start();
        sleep(3000);
        t2.start();
        
        
//        String[] items = {"OSDI", "OSAP", "OSLK", "OSKL"};
//        Random rand = new Random();
//
//        for (int i = 0; i < 365; i++) {
//            String firstItem = items[rand.nextInt(items.length)];
//            String secondItem = items[rand.nextInt(items.length)];
//            int minDay = 1, maxDay = 28; // To ensure we don't get an invalid day for February
//            int minMonth = 1, maxMonth = 8;
//            int minYear = 2024, maxYear = 2024; // Adjust these values as needed
//
//            int randomDay = rand.nextInt(maxDay - minDay + 1) + minDay;
//            int randomMonth = rand.nextInt(maxMonth - minMonth + 1) + minMonth;
//            int randomYear = rand.nextInt(maxYear - minYear + 1) + minYear;
//
//            LocalDate randomDate = LocalDate.of(randomYear, randomMonth, randomDay);
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d_M_yyyy");
//            String formattedDate = randomDate.format(formatter);
//            if(!firstItem.equals(secondItem)){
//                String doc="Passport";
//                if(i%2==0){
//                    doc="Visa";
//                }
//                int x=(i%11)+1;
//                System.out.println(firstItem + "," + secondItem+",,"+doc+",Normal,"+formattedDate+","+x+":00,100.0,2:");//00,35
//                System.out.println(firstItem + "," + secondItem+",,"+doc+",High,"+formattedDate+","+x+":00,200.0,2:");
//                System.out.println(firstItem + "," + secondItem+",,"+doc+",Business,"+formattedDate+","+x+":00,300.0,2:");
//            }
//        }
        
        
        
        
        
        
    }
}
