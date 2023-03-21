import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author aitor
 *
 */
public class Ejercicio4App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Ejercicio 4 - CONTROL DE VENTAS-STOCK");
		Scanner sc = new Scanner(System.in);
		//GENERAMOS LISTA DE LA COMPRA PRODUCTO-PRECIO BRUTO
		Hashtable<String, Double[]> listaCompra = new Hashtable<String, Double[]>();
		Hashtable<String, Double> listaCompraPrecioFinal = new Hashtable<String, Double>();
		listaCompra = generarListaProducto(sc);
		listaCompraPrecioFinal = calcularIVA(listaCompra);
		
		

	}
	

	//FUNCION GENERAR LISTA PRODUCTO-PRECIO BRUTO DEL CLIENTE QUE VIENE A COMPRAR
		public static Hashtable<String,Double[]> generarListaProducto(Scanner sc) {
			Hashtable<String, Double[]> contenedorProductoMasPrecioBruto = new Hashtable<String, Double[]>();
			String end = "NO";
			do {
				Double[] precio = new Double[2];
				System.out.print("Introduce el nombre del producto: ");
				String producto = sc.nextLine();
				System.out.print("Introduce el precio del producto: ");
				precio[0] = Double.parseDouble(sc.nextLine());
				System.out.print("Introduce el IVA del producto(4% o 21%): ");
				precio[1] = (Double.parseDouble(sc.nextLine()))/100;
				contenedorProductoMasPrecioBruto.put(producto, precio);
				System.out.print("Has terminado? YES / NO : ");
				end = sc.nextLine();
			}while(!end.equals("YES"));
			return contenedorProductoMasPrecioBruto;
		}
		
		//FUNCION APLICAR IVA
		public static Hashtable<String,Double> calcularIVA(Hashtable<String,Double[]> listaGenerada) {
			
			Enumeration<String> enumerationProducto = listaGenerada.keys();
			Hashtable<String, Double> listaConIVA = new Hashtable<String, Double>();
			while(enumerationProducto.hasMoreElements()) {
				
				String producto = enumerationProducto.nextElement();
				double precio = listaGenerada.get(producto)[0];
				double iva = listaGenerada.get(producto)[1];
				double precioConIVA = (precio * iva) + precio;
				listaConIVA.put(producto, precioConIVA);
			}
			return listaConIVA;
		}
		
		
	//FUNCION RELLENAR PRODUCTOS ALEATORIAMENTE
		public static void rellenarProductos(Hashtable<String, Hashtable<Double, Double>> contenedorProducto) {
			for(int i =1; i<11; i++) {
				Hashtable<Double, Double> contenedorPrecioCantidad = new Hashtable<Double, Double>();
				contenedorPrecioCantidad.put((double)i, (double)i);
				contenedorProducto.put("Articulo"+i, contenedorPrecioCantidad);
			}
			
		}

}
