package topic_2.class_problems;

public class MaskedPhoneNumberFormatter {
    public String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10 || !phone.matches("\\d{10}")) {
            return "Invalid phone number";
        }

        StringBuilder maskedPhone = new StringBuilder("XXXXXX");
        maskedPhone.append(phone, 6, 10);
        return maskedPhone.toString();
    }

    public static void main(String[] args) {
        MaskedPhoneNumberFormatter formatter = new MaskedPhoneNumberFormatter();
        System.out.println(formatter.maskPhoneNumber("9876543210"));
        System.out.println(formatter.maskPhoneNumber("98765"));
    }
}
