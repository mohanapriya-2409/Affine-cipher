import java.util.*;

public class Main {
    static int a;
    static int b;

    public static String encrypt(int a, int b, String msg) {
        String cipher = "";
        for (int i = 0; i < msg.length(); i++) {
            if (msg.charAt(i) != ' ') {
                cipher = cipher + (char) ((((a * (msg.charAt(i) - 'A')) + b) % 26) + 'A');
            } else {
                cipher = cipher + msg.charAt(i);
            }
        }
        return cipher;
    }

    public static String decrypt(int a, int b, String cipher) {
        String msg = "";
        int a_inv = 0;
        int flag = 0;
        for (int i = 0; i < 26; i++) {
            flag = (a * i) % 26;
            if (flag == 1) {
                a_inv = i;
                break;
            }
        }
        for (int i = 0; i < cipher.length(); i++) {
            if (cipher.charAt(i) != ' ') {
                int charValue = ((a_inv * ((cipher.charAt(i) - 'A' - b + 26)) % 26) + 'A');
                msg = msg + (char) charValue;
            } else {
                msg = msg + cipher.charAt(i);
            }
        }
        return msg;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter key a: ");
        a = sc.nextInt();
        System.out.print("Enter key b: ");
        b = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter plain text: ");
        String plain = sc.nextLine().toUpperCase();
        System.out.println("Plain Text: " + plain);
        String encrypted = encrypt(a, b, plain);
        System.out.println("CIPHER TEXT: " + encrypted);
        String decrypted = decrypt(a, b, encrypted);
        System.out.println("DECRYPTED CIPHER TEXT: " + decrypted);
        sc.close();
    }
}
