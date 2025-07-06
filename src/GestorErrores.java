import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GestorErrores {
	FileReader fr;
	FileWriter fw1;
	FileWriter fw2;
	FileWriter fw3;
	
	public GestorErrores(FileReader fr, FileWriter fw1, FileWriter fw2, FileWriter fw3) {
		this.fr = fr;
		this.fw1 = fw1;
		this.fw2 = fw2;
		this.fw3=fw3;
		
	}
	
	public void cerrarDesc() {
		try {
			fr.close();
			fw1.close();
			fw2.close();
			fw3.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void errorLexico(int i, int contLinea) {
		switch (i) {
			case 1:
				System.err.println("Error lexico[linea " + contLinea + "] comentario no permitido");
				break;
			case 2: 
				System.err.println("Error lexico[linea " + contLinea + "] id incorrecto, debe empezar por letra");
				break;
			case 3:
				System.err.println("Error lexico[linea " + contLinea + "] numero fuera de rango");
				break;
			case 4:
				System.err.println("Error lexico[linea " + contLinea + "]: No se encontró la comilla de cierre.");
				break;
			case 5 :
				System.err.println("Error lexico[linea " + contLinea + "] tamaño de cadena no permitido");
				break;
			case 6: 
				System.err.println("Error lexico[ linea " + contLinea + "] operador no permitido");
				break;
			case 7:
				System.err.println("Error lexico[linea " + contLinea + "] caracter no reconocido");
				break;
		}
		cerrarDesc();
		System.exit(0);
		
	}
	
	public void errorSintactico(int i,int contLinea,AnalizadorSintactico.simbolos cima, AnalizadorSintactico.simbolos aux) {
		switch (i) {
		case 1:
			System.err.println("Error sintactico[linea " + contLinea + "]:Se esperaba un  " + cima.name() + " y se ha recibido " + aux.name());
			break;
		case 5:
			System.err.println("Error sintactico[linea " + contLinea + "]:Falta el tipo del identificador en su declaracion");
			break;
		case 6:
			System.err.println("Error sintactico[linea " + contLinea + "]:If sin expresion entre parentesis");
			break;
		case 12:
			if(cima == AnalizadorSintactico.simbolos.H) {
				System.err.println("Error sintactico[linea " + contLinea + "]:Falta tipo retorno de funcion");
			}
			else {
				System.err.println("Error sintactico[linea " + contLinea + "]:Falta declarar entrada de la funcion");
			}
			break;
		case 15:
			System.err.println("Error sintactico[linea " + contLinea + "]:Falta el tipo del identificador en su declaracion");
			break;
		case 17:
			System.err.println("Error sintactico[linea " + contLinea + "]:Falta el tipo del identificador en su declaracion");
			break;
		case 25:
			System.err.println("Error sintactico[linea " + contLinea + "]:Falta la expresion del output");
		    break;
		case 28:
			System.err.println("Error sintactico[linea " + contLinea + "]:Falta expresion de la asignacion");
			break;
		default:
			System.err.println("Error sintactico[linea " + contLinea + "]:sintaxis incorrecta ");
			break;
		}
		cerrarDesc();
		System.exit(0);
	}
	public void errorSemantico(int i,int contLinea,String str) {
		switch (i) {
		case 3:
			System.err.println("Error semantico[linea " + contLinea + "]:" + str);
			break;
		}
		cerrarDesc();
		System.exit(0);
	}
}
