/**
 * 
 */
package uo.mp.logging;


import java.util.Random;



public class LoggerManager {

	public static final String INVALID_LOGIN = "invalid login";
	public static final boolean LARG_FAMILY = true; // familia numerosa
	

	// información del usuario login,password, si es o no familia numerosa
	// se almacena información de 3 usuarios
	private Object[][] users = { 
			{ "mary@w3c.org", "dD_66%j", !LARG_FAMILY },  
			{ "john@gmail.com", "@34abX!", LARG_FAMILY }, 				
			{ "rose@uniovi.es", "yY9/aaab", LARG_FAMILY }, 
			{ "juan@uniovi.es", "xXx0/abcd", LARG_FAMILY }, 
		};


		// para generar el shopperID
		private Random random = new Random();

		
		/**
		 * Comprueba que exista usuario en la base de datos
		 * y genera un identificador de manera aleatoria 
		 * añadiendo L (Large) o S (short) si el usuario
		 * tiene categoría de familia numerosa (largeFamily) o no
		 * @param username
		 * @param password
		 * @return identificador de usuario o null si no existe
		 * ninguno con dicho nombre y clave
		 */
		public String validate(String username, String password) {
			for(Object[] row : users) {
				String login = (String) row[0];
				String pass = (String) row[1];
				boolean largeFamily = (boolean) row[2];
				
				if ( login.equals( username) && pass.equals(password) ) {
					String shopperID = generateID(largeFamily);					
					return shopperID;				
				}
			}
			return null;  // si el usuario no se puede logear
		}
		
		
		private String generateID(boolean largeFamily) {			
			String id = String.valueOf( random.nextLong() );
			if (largeFamily) {
				return "L"+ id;
			} else {
				return "S" + id;
			}	
		}
	
}
