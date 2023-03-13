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
public class Ejercicio2App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Hashtable<String, Double> contenedorPrecioFinal = new Hashtable<String, Double>();
		Hashtable<String, Double[]> contenedorProducto = new Hashtable<String, Double[]>();
		double bruto = 0.0;
		double neto = 0.0;
		double cantidadPagada = 0.0;
		
		//PEDIR PRODUCTOS AL CLIENTE
		System.out.println("Bienvenido al Ejercicio 2 - Caja registradora");
		contenedorProducto = generarListaProducto(sc);
		contenedorPrecioFinal = calcularIVA(contenedorProducto);
		
		//IVA APLICADO (21% o 4%)
		// precio total bruto y precio mas IVA
		imprimirProductos(contenedorProducto,contenedorPrecioFinal);
		bruto = precioTotalSucio(contenedorProducto);
		neto = precioTotalNeto(contenedorPrecioFinal); 
		System.out.println("El precio total BRUTO es de: "+bruto);
		System.out.println("El precio total NETO es de: "+neto);
		
		//Numero de articulos comprado
		System.out.println("Se han comprado "+contenedorProducto.size()+" articulos");
		
		//Cantidad pagada
		cantidadPagada = cantidadPagada(sc);
		
		//Cambio a devolver al cliente
		double cambio = devolverCambio(cantidadPagada, neto);
		System.out.println("El cambio a devolver es de: "+cambio);
		
		sc.close();
		
		

		
	}
	
	
	//FUNCION GENERAR LISTA PRODUCTO-PRECIO BRUTO
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
	
	//FUNCION IMPRIMIR HASHTABLE PRECIO BRUTO + PRECIO IVA
	public static void imprimirProductos(Hashtable<String, Double[]> contenedorProducto, Hashtable<String, Double> contenedorPrecioFinal) {
		Enumeration<String> enumarationProducto = contenedorProducto.keys();
		
		while(enumarationProducto.hasMoreElements()) {
			String producto = enumarationProducto.nextElement();
			Double bruto = contenedorProducto.get(producto)[0];
			Double neto = contenedorPrecioFinal.get(producto);
			System.out.println("Producto: "+producto+" Precio Bruto: "+bruto+" Precio Final: "+neto);
		}
	}
	
	//FUNCION CALCULAR PRECIO TOTAL SUCIO
	public static double precioTotalSucio(Hashtable<String, Double[]> contenedorProducto) {
		Enumeration<String> enumarationProducto = contenedorProducto.keys();
		
		double precioFinal = 0.0;
		
		while(enumarationProducto.hasMoreElements()) {
			String producto = enumarationProducto.nextElement();
			Double bruto = contenedorProducto.get(producto)[0];
			precioFinal = precioFinal + bruto;
		}
		return precioFinal;
		
	}
	
	//FUNCION CALCULAR PRECIO TOTAL lIMPIO
	public static double precioTotalNeto(Hashtable<String, Double> contenedorPrecioFinal) {
		Enumeration<String> enumarationProducto = contenedorPrecioFinal.keys();
		
		double precioFinal = 0.0;
		
		while(enumarationProducto.hasMoreElements()) {
			String producto = enumarationProducto.nextElement();
			Double precioProducto = contenedorPrecioFinal.get(producto);
			precioFinal = precioFinal + precioProducto;
		}
		return precioFinal;
		
	}
	
	//FUNCION INTRODUCIT CANTIDAD PAGADA
	public static double cantidadPagada(Scanner sc) {
		System.out.print("Introduce el importe recibido: ");
		double importe = sc.nextDouble();
		return importe;
	}
	
	//FUNCION QUE DEVUELVE EL CAMBIO
	public static double devolverCambio(double pagado, double precioTotal) {
		return precioTotal - pagado;
	}
}
