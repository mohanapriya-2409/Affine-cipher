import java.util.*;
public class Affine
{
    static int a;
    static int b;
    public static String encrypt(int a,int b,String msg){
        String cipher =" ";
        for(int i=0;i<msg.length();i++){
            if (msg.charAt(i)!=' '){
                   cipher=cipher+(char)((((a * (msg.charAt(i) - 'A')) + b) % 26) + 'A');
            }
            else{
                cipher=cipher+msg.charAt(i);
            }
        }
        return cipher;
    }
    public static String decrypt(int a,int b,String cipher){
        String msg = "";
        int a_inv = 0;
        int flag = 0;
        for(int i=0;i<26;i++){
            flag=(a*i)%26;
            if(flag==1){
                a_inv=i;
            }
        }
        for (int i = 0; i < cipher.length(); i++)
        {
           
            if (cipher.charAt(i) != ' ')
            {
                msg = msg + (char) (((a_inv *
                        ((cipher.charAt(i) + 'A' - b+26)) % 26)) + 'A');
            }
            else //else simply append space character
            {
                msg += cipher.charAt(i);
            }
        }
 
        return msg;
    }


    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        a=sc.nextInt();
        b=sc.nextInt();
        String plain = sc.next();
        System.out.println(plain);
        String encrypted = encrypt(a,b,plain);
        System.out.println("CIPHER TEXT:");
        System.out.println(encrypted);
        String decrypted = decrypt(a,b,encrypted);
        System.out.println("DECRYPTED CIPHER TEXT:");
        System.out.println(decrypted);


        sc.close();
    }
}
