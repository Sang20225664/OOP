import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhap so thu nhat: ");
        String strNum1 = scanner.nextLine();
        double num1 = Double.parseDouble(strNum1);
        
        System.out.print("Nhap so thu hai: ");
        String strNum2 = scanner.nextLine();
        double num2 = Double.parseDouble(strNum2);
        
        double tong = num1 + num2;
        double hieu = num1 - num2;
        double tich = num1 * num2;
 
        System.out.println("Tong: " + tong);
        System.out.println("Hieu: " + hieu);
        System.out.println("Tich: " + tich);
        if (num2 != 0) {
            double thuong = num1 / num2;
            System.out.println("Thuong: " + thuong);
        } else {
            System.out.println("Khong the chia cho 0.");
        }
        scanner.close();
    }
}
