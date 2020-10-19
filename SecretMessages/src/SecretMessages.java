import java.util.Scanner;

public class SecretMessages {
	public static void main(String[] args) {
		//ask the user for a message to encode or decode
		System.out.println("Enter a message to encode or decode:");
		Scanner scan = new Scanner(System.in);
		String message = scan.nextLine();
		
		String out = "";
		
		while( message.length() > 0) {
			System.out.println("Enter a secret key (-26 to 26)");
			
			//char key = 13;
			//char key = 5;
			int intKey = Integer.parseInt(scan.nextLine());
			//^ code shift value
			
			//for(int x=message.length()- 1 ; x>= 0; x--) {
			//for(int x=message.length()- 1 ; x>= 0; x--) {
			for(int x = 0; x < message.length(); x++) {
				//out += (message.charAt(x));
				//out += (char)(message.charAt(x) + key);
				char in = message.charAt(x);
				if (in >= 'A' && in <= 'Z') {
					//in += key;
					in += intKey;
					if (in > 'Z') {
						in -= 26;
					}
					
				}
				
				if (in >= 'a' && in <= 'z') {
					//in += key;
					in += intKey;
					if (in > 'z') {
						in -= 26;
					}
					
				}
				out += in;
			}
			System.out.println();
			System.out.println(out);
			System.out.println();
			System.out.println("Enter another message, or press ENTER to end");
			
			message = scan.nextLine();
			
		}
		
		
		

		
		
		
	}

}
