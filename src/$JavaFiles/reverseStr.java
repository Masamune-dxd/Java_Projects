package $JavaFiles;

public class reverseStr {
    public static void main(String[] args) {
        String origStr = "Hello World";
        String revStr = "";
        System.out.println("Original String: " + origStr);
        for (int i = 0; i < origStr.length(); i++) {
            revStr = origStr.charAt(i) + revStr; 
        }
        System.out.println("Reversed String so far: " + revStr);
    }   
}