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
public class Ejercicio3App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("EJERCICIO 3 - STOCK");
		Scanner sc = new Scanner(System.in);
		Hashtable<String, Hashtable<Double, Double>> contenedorProducto = new Hashtable<String, Hashtable<Double, Double>>();

		// LLAMAMOS A LA FUNCION PARA GENERAL LISTA DE PRODUCTOS
		String opcion = "";
		do {
			System.out.println("ELIJE UNA OPCION: ");
			System.out.println("1-Introducir articulos");
			System.out.println("2-Consultar un articulo");
			System.out.println("3-Ver todos los articulos");
			System.out.println("4-Modificar algun producto");
			System.out.println("5-SALIR");
			opcion = sc.nextLine();
			String producto = "";
			
			switch (opcion) {
			case "1":
				generarListaProducto(sc, contenedorProducto);
				break;
			case "2":
				System.out.println("Introduce el nombre del producto: ");
				producto = sc.nextLine();
				consultarUnSoloArticulo(contenedorProducto, producto);
				break;
			case "3":
				consultarTodosArticulos(contenedorProducto);
				break;
			case "4":
				cambiarPrecioCantidadProducto(contenedorProducto, sc);
				break;
			case "5":
				System.out.println("Que tenga un buen dia");
				break;
			}
			
		} while (!opcion.equals("5"));
		sc.close();
		

	}

	// FUNCION GENERAR LISTA PRODUCTO-PRECIO-CANTIDAD
	public static void generarListaProducto(Scanner sc, Hashtable<String, Hashtable<Double, Double>> contenedorProducto) {
		String end = "NO";

		do {
			Hashtable<Double, Double> contenedorPrecioCantidad = new Hashtable<Double, Double>();
			String producto = "";
			double precio = 0.0;
			double cantidad = 0.0;
			System.out.print("Introduce el nombre del producto: ");
			producto = sc.nextLine();

			System.out.print("Introduce el precio del producto: ");
			precio = Double.parseDouble(sc.nextLine());

			System.out.print("Introduce la cantidad de articulos: ");
			cantidad = Double.parseDouble(sc.nextLine());

			contenedorPrecioCantidad.put(precio, cantidad);
			contenedorProducto.put(producto, contenedorPrecioCantidad);

			System.out.print("Has terminado? YES / NO : ");
			end = sc.nextLine();

		} while (!end.equals("YES"));
	}
	
	//CAMBIAR PRECIO O CANTIDAD DE UN PRODUCTO
	public static void cambiarPrecioCantidadProducto(Hashtable<String, Hashtable<Double, Double>> contenedorProducto, Scanner sc) {
		
		System.out.println("Introduce el nombre del producto: ");
		String producto = sc.nextLine();
		String eleccion = "";
		double precio = contenedorProducto.get(producto).keys().nextElement();
		double cantidad = contenedorProducto.get(producto).elements().nextElement();
		Hashtable<Double, Double> contenedorPrecioCantidad = new Hashtable<Double, Double>();
		
		do {
			System.out.println("ELIGE UNA OPCION: ");
			System.out.println("1-Cambiar el precio: ");
			System.out.println("2-Cambiar la cantidad: ");
			System.out.println("3-Guardar y Salir");
			eleccion = sc.nextLine();
			
			switch(eleccion) {
			case "1":
				System.out.println("Inroduce el nuevo precio: ");
				precio = Double.parseDouble(sc.nextLine());
				contenedorProducto.remove(producto);
				contenedorPrecioCantidad.put(precio, cantidad);
				contenedorProducto.put(producto, contenedorPrecioCantidad);
				break;
			case "2":
				System.out.println("Inroduce la nueva cantidad: ");
				cantidad = Double.parseDouble(sc.nextLine());
				contenedorProducto.remove(producto);
				contenedorPrecioCantidad.put(precio, cantidad);
				contenedorProducto.put(producto, contenedorPrecioCantidad);
				break;
			case "3":
				System.out.println("Gracias!!");
				break;
			}
			
		}while(!eleccion.equals("3"));
		
		
	}
	
	
	//FUNCION CONSULTAR UN PRODUCTO
	public static void consultarUnSoloArticulo(Hashtable<String, Hashtable<Double, Double>> contenedorProducto, String producto) {
		double precio = contenedorProducto.get(producto).keys().nextElement();
		double cantidad = contenedorProducto.get(producto).elements().nextElement();
		
		System.out.println("PRODUCTO: "+producto);
		System.out.println("PRECIO: "+precio);
		System.out.println("CANTIDAD: "+cantidad);
		
	}
	

	// FUNCION CONSULTAR LISTA DE PRODUCTOS
	public static void consultarTodosArticulos(Hashtable<String, Hashtable<Double, Double>> contenedorProducto) {
		Enumeration<String> enumerationProducto = contenedorProducto.keys();
		Enumeration<Hashtable<Double, Double>> enumerationLista = contenedorProducto.elements();
		
		while(enumerationProducto.hasMoreElements()) {
			String producto = enumerationProducto.nextElement();
			Hashtable<Double, Double> lista = enumerationLista.nextElement();
			double precio = lista.keys().nextElement();
			double cantidad = lista.elements().nextElement();
			
			System.out.println("Producto: "+producto+" Precio: "+precio+" Cantidad: "+cantidad);
		}
		
		
		
	}

}
