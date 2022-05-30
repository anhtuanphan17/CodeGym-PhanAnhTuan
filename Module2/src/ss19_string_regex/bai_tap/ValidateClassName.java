package ss19_string_regex.bai_tap;

public class ValidateClassName {
    public static void main(String[] args) {

        String Regex = "^[CAP][0-9]{4}[G-M]$";
        String [] Classname  = {"M0318G, P0323A","C0318G"};

        for(String element : Classname){
            boolean isvalid = element.matches(Regex);
            System.out.println(element + ": "+ isvalid);
        }


    }
}
