/**
 * 
 */
package uo.mp.shopping.processor;

import java.io.FileNotFoundException;

import uo.mp.collections.List;
import uo.mp.collections.impl.ArrayList;
import uo.mp.file.TxtFileUtil;
import uo.mp.invoice.Billable;
import uo.mp.invoice.InvoiceManager;
import uo.mp.log.Logger;
import uo.mp.logging.LoggerManager;
import uo.mp.shopping.exception.ShoppingException;
import uo.mp.shopping.model.Product;
import uo.mp.shopping.processor.loader.ProductLoader;
import uo.mp.shopping.processor.service.Shopper;

public class ShoppingProcessor {
	public static final String CLIENT_DATA = "clientData.txt";
	
	private Shopper shopper;

	public void run() {
		try {
			process();
		} catch (RuntimeException e) {
			handlleSysError(e);
		} catch (Exception e) {
			handleUserError(e);
		}
	}	
	
	private void handlleSysError(RuntimeException e) {
		System.out.println("FATAL ERROR. Pongase en contacto con su proveedor");
		Logger.log(e.getMessage());
		Logger.log(e);
	}
	
	private void handleUserError(Exception e) {
		System.out.println("ERROR DE APLICACION. Revise este error: " + e.getMessage());
	}
	
	private void process() throws ShoppingException, FileNotFoundException {
		
		// Leer datos del cliente de fichero clientData.txt
		List<String> clientData = readClientData();
		
		String clientName = clientData.get(0);
		String clientPassword = clientData.get(1);
		String clientFile = clientData.get(2);
	
		// Validar que es un cliente y tiene cuenta
		String clientID = login(clientName, clientPassword);
		
		// crear un shopper para el cliente
		shopper = new Shopper(clientID);	
		
		// Llenar el carrito con la lista de la compra en shopper
		fillCart(clientFile);
		
		// mostrar productos del carrito ordenados por precio y código
		showCartByPriceAndCode();
		
				
		// mostrar coste del carrito (precio final con iva) sin el descuento
		showCartCost();
		
				
		// imprimir la factura en fichero 
		printInvoice(clientName);
		}

	
	/**
	 * Lee los datos del fichero CLIENT_DATA
	 * @return
	 * @throws FileNotFoundException 
	 */
	private List<String> readClientData() throws FileNotFoundException   {
		List<String> lines = new TxtFileUtil().readLines( CLIENT_DATA );
		return lines;						
	}

	
	/**
	 * Valida el usuario y clave.
	 * Devuelve un identificador que comienza por L (si es familia numerosa)
	 * o por S (si no lo es)
	 * Si el usuario es desconocido lanza una excepción para que el programa 
	 * acabe
	 * 
	 *
	 */
	public String login(String username, String password)  {					
		String id = new LoggerManager().validate(username, password);
		return id;
		
	}
	
	/**
	 * Lee la lista de la compra (lista de productos) y se los
	 * pasa al shopper, que los guarda en el carrito (cart)
	 * 
	 * @param clientFile
	 * @throws FileNotFoundException 
	 */
	private void fillCart(String clientFile) throws FileNotFoundException  {			
		List<Product> products = new ProductLoader( clientFile ).load();
		shopper.addProducts(products);		
	}
	
	/**
	 * Muestra los productos del carrito ORDENADOS POR PRECIO y 
	 * a igualdad de precio por código
	 */
	private void showCartByPriceAndCode() {		
		List<Product> sortedProducts = shopper.getSortedProducts();
		printProducts(sortedProducts);
		
	}
	
	/**
	 * Muestra el coste de los productos del carrito con descuento de familia
	 * numerosa si lo tiene el cliente
	 */
	private void showCartCost() {
		
		System.out.print(	"\n----- Total de la compra en el carrito-------");				
		System.out.println(shopper.calculateCost() + "\n");
	}
	
	/**
	 * Imprime la factura de la compra en un fichero cuyo nombre es 
	 * el nombre del usuario con extensión .invoice
	 * Se realiza a través de una aplicación externa que recibe la lista de
	 * productos en forma de facturables
	 * 
	 * @param user
	 */
	public void printInvoice(String user) {		
		String header = "------------- Factura de compra de " + user + " ----------\n";
		System.out.println(header);
		// COMPLETAR
		// incluir aquí el código que falta para obtener
		// la lista de Billables y  el discount
		List<Billable> list = shopper.getBillables();
		double discount = shopper.getDiscount();
				
		String invoice = new InvoiceManager().generateInvoice(list,discount);
		String totalWithoutD = "Total.........." + shopper.calculateCostWithoutDiscount();
		String totalWithD = "Total con descuento    ..............." + shopper.calculateCost();
		System.out.println(invoice);      // se muestra factura por pantalla		 
		System.out.println(totalWithoutD);
		System.out.println(totalWithD);		
		// COMPLETAR
		// GUARDAR la factura en un fichero llamado "nombreUsuario.invoice"
		List<String> file = new ArrayList<>();
		file.add(header);
		file.add(invoice);
		file.add("\n" + totalWithoutD);
		file.add("\n" + totalWithD);
		new TxtFileUtil().saveToFile( user + ".invoice", file );
	}	

	/**
	 * Imprime la lista de productos
	 * @param products
	 */

	private void printProducts(List<Product> products) {
		
		System.out.println("----- Contenido del carrito de la compra-----");
		for (Product product: products) {
			System.out.println(product);			
		}
		
	}
}
