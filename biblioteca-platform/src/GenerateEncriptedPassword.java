import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class GenerateEncriptedPassword {
	public static void main(String[] args) {	
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = "admin";
		String hashedPassword = passwordEncoder.encode(password);
		System.out.println(password +" encriptado es: " + hashedPassword);
		String _accountLocked = "true";
		System.out.println(_accountLocked);
		Boolean _accountLockedB = Boolean.valueOf(_accountLocked);
		System.out.println(_accountLockedB);
		
	}
}

