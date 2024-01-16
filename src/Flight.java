/**
 * Class Name : Flight
 * @author Madhushi
 * Purpose : To maintain information about a flight. The maintained information are
 *           the flight number, departure date,departure airport,
 *           destination airport, departure time, arrival time and the flight sections.
 */



import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;


public class Flight {
    private String departurePlace;
    private String destinationPlace;
    private String Type;
    private String RequiredDocuments;
    private String classType;
    private String Date;
    private String Time;
    private Double Cost;
    private String approximateTime;
    private int sets;

    //costructor 01
    public Flight() {
    }

    public Flight(String departurePlace, String destinationPlace, String Type, String RequiredDocuments, String classType, int day, int month, int year, String Time, double Cost, String approximateTime, int sets) {
        this.departurePlace = departurePlace;
        this.destinationPlace = destinationPlace;
        this.Type = Type;
        this.RequiredDocuments = RequiredDocuments;
        this.classType = classType;
        setDepartureDate( day,  month,  year);
        this.Time = Time;
        this.Cost = Cost;
        this.approximateTime = approximateTime;
        this.sets=sets;
    }

    Flight(String flightID, int deptDay, int deptMonth, int deptYear, String departureAirport, String destinationAirport, String departureTime, String arrivalTime, int sets) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getDeparturePlace() {
        return departurePlace;
    }

    public int getSets() {
        return sets;
    }

    public void setDeparturePlace(String departurePlace) {
        this.departurePlace = departurePlace;
    }

    public String getDestinationPlace() {
        return destinationPlace;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public void setCost(Double Cost) {
        this.Cost = Cost;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public void setDestinationPlace(String destinationPlace) {
        this.destinationPlace = destinationPlace;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getRequiredDocuments() {
        return RequiredDocuments;
    }

    public void setRequiredDocuments(String RequiredDocuments) {
        this.RequiredDocuments = RequiredDocuments;
    }

    public String getclassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getDate() {
        return Date;
    }

    public String getDate2() throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("d MMM yyyy", Locale.ENGLISH);
        Date date = inputFormat.parse(Date);
        SimpleDateFormat outputFormat = new SimpleDateFormat("d_M_yyyy", Locale.ENGLISH);
        String outputDate = outputFormat.format(date);
        return outputDate;
    }
    
    public void setDepartureDate(int day,
            int month, int year) {
        SimpleDateFormat sdf = new SimpleDateFormat("d MMM yyyy");
        Calendar calendar1 = new GregorianCalendar(year, month - 1, day);   //creates a date from Calendar class   
        this.Date = sdf.format(calendar1.getTime());
    }
    public static String convertDate(String date) {
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("d MMM yyyy", Locale.ENGLISH);
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("d_M_yyyy");
        LocalDate parsedDate = LocalDate.parse(date, inputFormat);
        return parsedDate.format(outputFormat);
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public double getCost() {
        return Cost;
    }

    public void setCost(double Cost) {
        this.Cost = Cost;
    }

    public String getApproximateTime() {
        return approximateTime;
    }

    public void setApproximateTime(String approximateTime) {
        this.approximateTime = approximateTime;
    }
   
    @Override
    public String toString() {
        return "Flight{" + "departurePlace=" + departurePlace + ", destinationPlace=" + destinationPlace + ", Type=" + Type + ", RequiredDocuments=" + RequiredDocuments + ", classType=" + classType + ", Date=" + Date + ", Time=" + Time + ", Cost=" + Cost + ", approximateTime=" + approximateTime + '}';
    }
}
