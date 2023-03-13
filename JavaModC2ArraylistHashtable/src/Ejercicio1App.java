import java.util.ArrayList;
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
public class Ejercicio1App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("EJERCICIO 1 - CALCULAR NOTA MEDIA");
		Scanner sc = new Scanner(System.in);
		ArrayList<Double> notas = new ArrayList<>();
		Hashtable<String, Double> contenedorNotas = new Hashtable<String, Double>();
		
		System.out.print("¿Cuantos alumnos hay en clase?");
		int numeroAlumnos = sc.nextInt();
		
		
		do {
			sc.nextLine();
			System.out.println("Escribe el nombre del Alumno: ");
			String alumno = sc.nextLine();
			notas = rellenarNotas(sc, alumno);
			double notaMedia = calcularNotaMedia(notas);
			contenedorNotas.put(alumno, notaMedia);
			numeroAlumnos--;
		} while(numeroAlumnos>0);
		imprimirResultado(contenedorNotas);
	}
	
	
	//FUNCION PARA CALCULAR NOTA MEDIA
	public static double calcularNotaMedia(ArrayList<Double> notas) {
		double notaMedia = 0.0;
		double notaTotal = 0.0;
		int totalNotas = notas.size();
		for(int i = 0; i<totalNotas; i++) {
			notaTotal = notaTotal + notas.get(i);
		}
		notaMedia = notaTotal / totalNotas;
		return notaMedia;
	}
	
	//RELLENAR ARRAYLIST DE NOTAS
	public static ArrayList<Double> rellenarNotas(Scanner sc, String alumno) {
		ArrayList<Double> notas = new ArrayList<>();
		for(int i = 0; i<6; i++) {
			System.out.print("Escribe la nota del modulo "+(i+1)+" para "+alumno+" : ");
			double nota = sc.nextDouble();
			notas.add(nota);
		}
		return notas;
	}
	
	//IMPRIMIR HASHTABLE POR PANTALLA
	public static void imprimirResultado(Hashtable<String, Double> contenedorNotas) {
		Enumeration<Double> enumerationNota = contenedorNotas.elements();
		Enumeration<String> enumerationNombre = contenedorNotas.keys();
		
		while(enumerationNota.hasMoreElements()) {
			System.out.println("El alumno "+enumerationNombre.nextElement()+" tiene una NOTA MEDIA de: "+enumerationNota.nextElement());
		}
	}
}
