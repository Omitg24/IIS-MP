/**
 * 
 */
package uo.mp.ui.s1.helloworld;

/**
 * @author Omitg
 *
 */
public class HelloWorld {
	
	private int i;
	private String myString;
	/**
	 * Método main principal
	 * @param args listado de argumentos de entrada
	 */
	public static void main(String[] args) {
		// metodo main
		/*
		 * shdgdadad
		 * adsadda
		 * ffsadasda
		 */
		System.out.println("Hola Mundo, me llamo " + args[0]);
		if (true)
			System.out.println("Adios");
//		else
//			System.out.println("Adios2");
	}
	
	private void setI(int i) {
		this.i = i;
		
	}
	
	private void setMyString(String myString) {
		this.myString = myString;
		
	}

	public HelloWorld() {
		super();
	}

	public HelloWorld(int i, String myString) {
		super();
		this.i = i;
		this.myString = myString;
	}

	

}
