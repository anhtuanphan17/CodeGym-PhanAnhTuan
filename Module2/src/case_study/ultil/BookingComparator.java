package case_study.ultil;

import case_study.models.Booking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

public class BookingComparator implements Comparator<Booking> {

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");


    @Override
    public int compare(Booking o1, Booking o2) {
        Calendar calendar = Calendar.getInstance();
         int date =1;
        try {
            Date o1StartDay = formatter.parse(o1.getStartDay());
            Date  o1EndDay = formatter.parse(o1.getEndDay());
            Date o2StartDay = formatter.parse(o2.getStartDay());
            Date o2EndDay = formatter.parse(o2.getEndDay());

            if(o1StartDay.compareTo(o2StartDay)==0){
                date = o1EndDay.compareTo(o2EndDay);
                return date;
            }else{
                date = o1StartDay.compareTo(o2StartDay);
                return date;
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
