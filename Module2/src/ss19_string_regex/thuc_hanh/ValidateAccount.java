package ss19_string_regex.thuc_hanh;

public class ValidateAccount {
    public static void main(String[] args) {

        String Regex = "^[_a-z0-9]{6,}$";

        String[] validAccount = {"123abc_", "_abc123", "______", "123456", "abcdefgh"};
        String[] inValidAcount = {".@", "12345", "1234_", "abcde"};

        for(String element : validAccount){
            boolean isValid = element.matches(Regex);
            System.out.println(element +": "+ isValid);
        }

        for(String element : inValidAcount){
            boolean isValid = element.matches(Regex);
            System.out.println(element +": "+ isValid);
        }


    }

}
