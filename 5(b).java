import java.util.Scanner;

public class CountCharacters {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        int v = 0, c = 0, d = 0, sp = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = Character.toLowerCase(s.charAt(i));

            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                    v++;
                else
                    c++;
            }
            else if (ch >= '0' && ch <= '9')
                d++;
            else if (ch != ' ')
                sp++;
        }

        System.out.println("Vowels: " + v);
        System.out.println("Consonants: " + c);
        System.out.println("Digits: " + d);
        System.out.println("Special Characters: " + sp);
    }
}