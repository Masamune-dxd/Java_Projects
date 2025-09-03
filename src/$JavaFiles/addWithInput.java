package $JavaFiles;

import java.util.Scanner;

public class addWithInput {
    public static void main(String[] args) {
        int x, y, sum;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type a number: ");
        x = scanner.nextInt();
        System.out.print("Type another number: ");
        y = scanner.nextInt();
        sum = x + y;
        System.out.println("Sum: " + sum);
        scanner.close();
    }
}
