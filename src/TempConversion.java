import java.util.Scanner;

public class TempConversion {
    static final Scanner input = new Scanner(System.in);

    public static double convertC2F(double celsius) {
        return (celsius * (9.0/5)) + 32.0;
    }

    public static double convertC2K(double celsius) {
        return celsius + 273.15;
    }

    public static double convertF2C(double fahrenheit) {
        return 5.0 * (fahrenheit - 32) / 9.0;
    }

    public static double convertF2K(double fahrenheit) {
        return convertC2K(convertF2C(fahrenheit));
    }

    public static double convertK2C(double kelvin) {
        return kelvin - 273.15;
    }
    public static double convertK2F(double kelvin){
        return convertC2F(convertK2C(kelvin));
    }

    public static double getTemp(String unit) {
        System.out.printf("%-40s : ", String.format("Please enter °%s temperature to convert", unit));
        return Double.parseDouble(input.nextLine());
    }

    public static String getUnitChoice() {
        System.out.printf("%-4s : %40s%n", "C).", "To convert a °C temperature");
        System.out.printf("%-4s : %40s%n", "F).", "To convert a °F temperature");
        System.out.printf("%-4s : %40s%n", "K).", "To convert a °K temperature");
        System.out.printf("%-4s : %40s%n", "Q).", "To quit");
        return input.next();
    }

    public static void main(String[] args) {
        while(true) {
            System.out.println("Enter Unit of temperature you would like to convert from.");
            String choice = getUnitChoice();
            System.out.println("What would you like to convert it to?");
            String choice2 = input.next();
            System.out.println("What is the temp you would like to convert?");
            double temp = input.nextDouble();
            double result = -460;
            switch (choice+choice2){
                case "cq","fq","kq","qq","qc","qk","qf":
                    return;
                case "cc","ff","kk":
                    result = temp;
                    break;

                case "cf":
                    result = convertC2F(temp);
                    break;

                case "ck":
                    result = convertC2K(temp);
                    break;

                case "kc":
                    result = convertK2C(temp);
                    break;

                case "kf":
                    result = convertK2F(temp);
                    break;

                case "fk":
                    result = convertF2K(temp);
                    break;

                case "fc":
                    result = convertF2C(temp);
                    break;

                default:
                    System.out.println("Unrecognized input, try again.");

                    break;
            }
            if (result != -460){
                System.out.println("Result "+temp+choice+"° is "+result+choice2+"°");
            }
        }
    }
}