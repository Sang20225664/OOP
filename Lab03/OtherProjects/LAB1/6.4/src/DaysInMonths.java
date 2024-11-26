import java.util.Scanner;

public class DaysInMonths {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = -1;
        String monthInput;
        int month = 0;

        while (year < 0) {
            System.out.print("Nhap nam : ");
            year = scanner.nextInt();
            if (year < 0) {
                System.out.println("Nam khong hop le");
            }
        }
   
        scanner.nextLine(); 
        while (month == 0) {
            System.out.print("Nhap thang : ");
            monthInput = scanner.nextLine().trim();

            month = getMonthFromInput(monthInput);
            if (month == 0) {
                System.out.println("Thang khong hop le");
            }
        }

        int days = getDaysInMonth(month, year);
        System.out.println("Thang " + month + " nam " + year + " co " + days + " ngay.");

        scanner.close();
    }

    public static int getMonthFromInput(String monthInput) {
        switch (monthInput.toLowerCase()) {
            case "1": case "jan": case "jan.": case "january": return 1;
            case "2": case "feb": case "feb.": case "february": return 2;
            case "3": case "mar": case "mar.": case "march": return 3;
            case "4": case "apr": case "apr.": case "april": return 4;
            case "5": case "may": return 5;
            case "6": case "jun": case "jun.": case "june": return 6;
            case "7": case "jul": case "jul.": case "july": return 7;
            case "8": case "aug": case "aug.": case "august": return 8;
            case "9": case "sep": case "sept": case "sept.": case "september": return 9;
            case "10": case "oct": case "oct.": case "october": return 10;
            case "11": case "nov": case "nov.": case "november": return 11;
            case "12": case "dec": case "dec.": case "december": return 12;
            default: return 0;
        }
    }

    public static int getDaysInMonth(int month, int year) {
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        
        switch (month) {
            case 1: return 31;
            case 2: return isLeapYear ? 29 : 28;
            case 3: return 31;
            case 4: return 30;
            case 5: return 31;
            case 6: return 30;
            case 7: return 31;
            case 8: return 31;
            case 9: return 30;
            case 10: return 31;
            case 11: return 30;
            case 12: return 31;
            default: return 0;
        }
    }
}
