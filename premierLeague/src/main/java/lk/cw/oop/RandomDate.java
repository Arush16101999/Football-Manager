package lk.cw.oop;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RandomDate {
    public static int createRandomIntBetween(int start,int end){
        return start + (int) Math.round(Math.random()*(end - start));
    }

    public static Date createRandomDate(int startYear,int endYear) throws ParseException{
        int day=createRandomIntBetween(1,28);
        int month=createRandomIntBetween(1,12);
        int year=createRandomIntBetween(startYear,endYear);
        String dateFormat=month+"-"+day+"-"+year;
        Date date=new SimpleDateFormat("MM-dd-yyyy").parse(dateFormat);

        return date;
    }
}
