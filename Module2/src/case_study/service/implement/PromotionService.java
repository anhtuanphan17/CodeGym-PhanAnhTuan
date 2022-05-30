package case_study.service.implement;

import case_study.models.Booking;
import case_study.service.IPromotionService;

import java.text.SimpleDateFormat;
import java.util.*;

public class PromotionService implements IPromotionService {

    static Scanner scanner = new Scanner(System.in);


    @Override
    public void displayCustomersUseService() {
        System.out.println("input year of using service of customer ");
        int yearBooking = Integer.parseInt(scanner.nextLine());
        String year = Integer.toString(yearBooking);
        for (Booking booking : BookingService.bookingSet) {
            if (booking.getStartDay().indexOf(year) > 0 || booking.getEndDay().indexOf(year) > 0) {
                System.out.println(booking);
            }
        }
    }

    @Override
    public void displayListCustomersGetVoucher() {
        Map<String, Integer> voucher = new TreeMap<>();
        Stack<Booking> bookingStack = new Stack<>();
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dateString = formatter.format(date);

        System.out.println("input number of voucher 10%");
        int voucher10 = scanner.nextInt();
        System.out.println("input number of voucher 20%");
        int voucher20 = scanner.nextInt();
        System.out.println("input number voucher 50%");
        int voucher50 = scanner.nextInt();

        for (Booking booking : BookingService.bookingSet) {
            if ((booking.getStartDay().substring(3).equals(dateString.substring(3)) || booking.getEndDay().substring(3).equals(dateString.substring(3))) && !booking.getTypeOfService().equals("Room")) {
                bookingStack.add(booking);
            }
        }
        voucher.put("voucher10", voucher10);
        voucher.put("voucher20", voucher20);
        voucher.put("voucher50", voucher50);

        while (!bookingStack.isEmpty()) {
            if (voucher.get("voucher10") > 0) {
                System.out.println(bookingStack.pop() + " receive voucher of 10%");
                voucher.put("voucher10", voucher.get("voucher10") - 1);
            }
            if (voucher.get("voucher20") > 0) {
                System.out.println(bookingStack.pop() + " receive voucher of 20%");
                voucher.put("voucher20", voucher.get("voucher20") - 1);

            }
            if (voucher.get("voucher50") > 0) {
                System.out.println(bookingStack.pop() + " receive voucher of 50%");
                voucher.put("voucher50", voucher.get("voucher50") - 1);
            }
        }

    }

    @Override
    public void returnMainMenu() {

    }

}
