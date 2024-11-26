import java.util.Scanner;

public class InputFromKeyboard {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.println("What is your name?");
		String strname = keyboard.nextLine();
		System.out.println("how old are you?");
		int age = keyboard.nextInt();
		System.out.println("how tall are you?");
		Double height = keyboard.nextDouble();

		System.out.println("hello: " + strname + "\nage: " + age + "\nheight: " + height);
	}
}