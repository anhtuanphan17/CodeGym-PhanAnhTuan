package ss19_string_regex.thuc_hanh;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailExample {

    public static void main(String[] args) {
    String EMAIL_REGEX = "^[a-zA-Z][a-zA-Z0-9]+@(\\.[a-z]{2,}){1,3}";

        String email1 = "test1@gmail.com.vn";
        String email2 = "123test@gmail.com.vn";
        String email3 = "test2@gmail.com";
        String email4 = "test3-1@gmail.com";
        String email5 = "test4@@gmail.com";
        String email6 = "test5@domain.com";
        String email7 = "test6@gmail";

        System.out.println(email1+" is " + Pattern.matches(EMAIL_REGEX,email1));
        System.out.println(email2+" is " + Pattern.matches(EMAIL_REGEX,email2));
        System.out.println(email3+" is " + Pattern.matches(EMAIL_REGEX,email3));
        System.out.println(email4+" is " + Pattern.matches(EMAIL_REGEX,email4));
        System.out.println(email5+" is " + Pattern.matches(EMAIL_REGEX,email5));
        System.out.println(email6+" is " + Pattern.matches(EMAIL_REGEX,email6));
        System.out.println(email7+" is " + Pattern.matches(EMAIL_REGEX,email7));


    }

}
