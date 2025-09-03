package $JavaFiles;

public class MutiplicationTable {
    public static void main(String[] args) {
        // SECTION 1: Multiplication Table (1 to 10)
        System.out.println("Multiplication Table:");
        System.out.println("---------------------");
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }
    }
}