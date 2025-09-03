package $JavaFiles;
// import java.util.Arrays; // Unused import

public class Array {
  public static void main(String[] args) {
    // Declares and initializes a string array for student names
    String[] students = {"Sade", "Alexus", "Sam", "Koma"};
    // Declares an integer array for math scores with a size of 4
    int[] mathScores = new int[4];
    // Assigns scores to specific indices in the mathScores array
    mathScores[0] = 64;
    mathScores[2] = 76;
    mathScores[1] = 57;
    mathScores[3] = 98;
    
    // Loops through the arrays and prints each student's name and score
    for(int i = 0; i < students.length; i++){
      System.out.println(students[i] + ": " + mathScores[i]);
    }
  }
}