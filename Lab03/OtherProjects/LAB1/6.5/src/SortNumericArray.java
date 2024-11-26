import java.util.Arrays;
import java.util.Scanner;

public class SortNumericArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhap so luong phan tu: ");
        int n = scanner.nextInt();
        int[] a = new int[n];

        System.out.println("Nhap cac gia tri trong mang:");
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        System.out.println("Mang truoc khi sap xep: " + Arrays.toString(a));

        Arrays.sort(a);

        System.out.println("Mang sau khi sap xep: " + Arrays.toString(a));

        int sum = 0;
        for (int num : a) {
            sum += num;
        }

        double average = (double) sum / n;
        System.out.println("Tong cac phan tu: " + sum);
        System.out.println("Gia tri trung binh: " + average);

        scanner.close();
    }
}

