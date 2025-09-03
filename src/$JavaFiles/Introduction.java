package $JavaFiles;

import java.util.Scanner;

public class Introduction {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.println("What is your name?");
    String userName = input.next();
    System.out.printf("Hello %s! It's nice to meet you.", userName);
  }
}