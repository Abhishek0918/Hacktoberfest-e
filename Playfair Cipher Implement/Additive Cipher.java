import java.util.Scanner;

public class AdditiveCipher {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("\nWelcome to the Additive Cipher Program!");
        
        int choice = 0;
        do {
            System.out.println("\nSelect an option:");
            System.out.println("1. Encryption");
            System.out.println("2. Decryption");
            System.out.println("3. Brute Force");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    encryption();
                    break;
                case 2:
                    decryption();
                    break;
                case 3:
                    bruteForce();
                    break;
                case 4:
                    System.out.println("\nEXIT");
                    break;
                default:
                    System.out.println("\nInvalid choice. Please choose from 1-4.");
                    break;
            }            
        } while (choice != 4);
        input.close();
    }

    public static void encryption() {
        Scanner input = new Scanner(System.in);
        System.out.println("\nYou selected Encryption.");
        System.out.print("Enter the plaintext: ");
        String plainText = input.nextLine();
        System.out.print("Enter the key (an integer): ");
        int key = input.nextInt();
        String cipherText = "";
        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                    ch = (char) ((ch - 'A' - key + 26) % 26 + 'A');
                }else
             if (ch >= 'a' && ch <= 'z' && ch !=33 && ch!=64) {
                ch = (char) ((ch - 'a' + key) % 26 + 'a');
            }
            cipherText += ch;
        }
        System.out.println("The ciphertext is: " + cipherText);
    }

    public static void decryption() {
        Scanner input = new Scanner(System.in);
        System.out.println("\nYou selected Decryption   .");
        System.out.print("Enter the ciphertext: ");
        String cipherText = input.nextLine();
        System.out.print("Enter the key (an integer): ");
        int key = input.nextInt();
        String plainText = "";
        for (int i = 0; i < cipherText.length(); i++) {
            char ch = cipherText.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                    ch = (char) ((ch - 'A' - key + 26) % 26 + 'A');
                }
              else if (ch >= 'a' && ch <= 'z') {
                ch = (char) ((ch - 'a' - key + 26) % 26 + 'a');
            }
            plainText += ch;
        }
        System.out.println("The plaintext is: " + plainText);
    }

    public static void bruteForce() {
        Scanner input = new Scanner(System.in);
        System.out.println("\nYou selected Brute Force.");
        System.out.print("Enter the ciphertext: ");
        String cipherText = input.nextLine();
        for (int key = 0; key < 26; key++) {
            String plainText = "";
            for (int i = 0; i < cipherText.length(); i++) {
                char ch = cipherText.charAt(i);
                if (ch >= 'A' && ch <= 'Z') {
                    ch = (char) ((ch - 'A' - key + 26) % 26 + 'A');
                }
                else if (ch >= 'a' && ch <= 'z') {
                    ch = (char) ((ch - 'a' - key + 26) % 26 + 'a');
                }
                plainText += ch;
            }
            System.out.println("Key: " + key + " ==> Plaintext: " + plainText);
        }
    }    
}
