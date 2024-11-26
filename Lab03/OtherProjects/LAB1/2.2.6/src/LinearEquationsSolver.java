import java.util.Scanner;

public class LinearEquationsSolver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Giai phuong trinh bac nhat ax + b = 0
        System.out.println("Giai phuong trinh bac nhat ax + b = 0");
        System.out.print("Nhap he so a: ");
        double a = scanner.nextDouble();
        System.out.print("Nhap hang so b: ");
        double b = scanner.nextDouble();

        if (a == 0) {
            if (b == 0) {
                System.out.println("Phuong trinh co vo so nghiem.");
            } else {
                System.out.println("Phuong trinh vo nghiem.");
            }
        } else {
            double x = -b / a;
            System.out.println("Nghiem cua phuong trinh la: x = " + x);
        }

        // Giai he phuong trinh bac nhat hai an
        System.out.println("\nGiai he phuong trinh bac nhat:");
        System.out.println("a11 * x1 + a12 * x2 = b1");
        System.out.println("a21 * x1 + a22 * x2 = b2");
        
        System.out.print("Nhap he so a11: ");
        double a11 = scanner.nextDouble();
        System.out.print("Nhap he so a12: ");
        double a12 = scanner.nextDouble();
        System.out.print("Nhap hang so b1: ");
        double b1 = scanner.nextDouble();
        
        System.out.print("Nhap he so a21: ");
        double a21 = scanner.nextDouble();
        System.out.print("Nhap he so a22: ");
        double a22 = scanner.nextDouble();
        System.out.print("Nhap hang so b2: ");
        double b2 = scanner.nextDouble();

        double determinant = a11 * a22 - a12 * a21;

        if (determinant == 0) {
            if (a11 * b2 == a21 * b1 && a12 * b2 == a22 * b1) {
                System.out.println("He phuong trinh co vo so nghiem.");
            } else {
                System.out.println("He phuong trinh vo nghiem.");
            }
        } else {
            double x1 = (b1 * a22 - b2 * a12) / determinant;
            double x2 = (a11 * b2 - a21 * b1) / determinant;
            System.out.println("Nghiem cua he phuong trinh la: x1 = " + x1 + ", x2 = " + x2);
        }

        scanner.close();
    }
}
