
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class AnalizadorLexico {
	public static int contLinea;
	private FileReader fr;
	private FileWriter fw1;
	private FileWriter fw2;
	private GestorErrores ger;
	private Map<String, Integer> palabrasReservadas;
	static boolean fin = true;
	static boolean sig = false;
	static int i;
	static char caracter;

	public AnalizadorLexico(FileReader fr, FileWriter fw1, FileWriter fw2, GestorErrores ger) {
		this.fr = fr;
		this.fw1 = fw1;
		this.fw2 = fw2;
		this.ger = ger;
		inicializarMapPalRes();
		contLinea = 1;	
	}

	public Token getToken(boolean zonaDec,TablaSimbolos tsg, TablaSimbolos tsl) {
		TablaSimbolos ts = (tsl == null? tsg:tsl);
		int cont;
		String strP = "";
		Token token;
		boolean detectado = false;
		try {
			if (!sig) {
				fin = ((i = fr.read()) != -1);
			}
			sig = false;
			strP = "";
			token = null;
			caracter = (char) i;
			if (esDelimitador(caracter)) {
				return getToken(zonaDec,tsg,tsl);
			}
			if (caracter == '/') {
				caracter = (char) fr.read();
				if (caracter == '/') {
					while ((i = fr.read()) != -1) {
						if ((char) i == '\n') {
							contLinea++;
							break;
						}
					}
					if (i != -1) {
						return getToken(zonaDec,tsg,tsl);
					} else {
						token = new Token("eof", null);
						fw1.write(token.toString());
						fw1.write(System.lineSeparator());
						fw2.write(ts.toString());
						return token;
					}
				}
				ger.errorLexico(1,contLinea);
			}
			if (caracter >= '0' && caracter <= '9') {
				int x = Character.getNumericValue(caracter);
				i = fr.read();
				caracter = (char) i;
				if ((caracter >= 'A' && caracter <= 'Z') || (caracter >= 'a' && caracter <= 'z') || caracter == '_') {
					ger.errorLexico(2,contLinea);
				}
				while (caracter >= '0' && caracter <= '9') {
					x = x * 10 + Character.getNumericValue(caracter);
					i = fr.read();
					caracter = (char) i;
				}
				if ((caracter >= 'A' && caracter <= 'Z') || (caracter >= 'a' && caracter <= 'z') || caracter == '_') {
					ger.errorLexico(2,contLinea);
				}
				if (x <= 32767) {
					// Genera token <CteEnt,x>
					token = new Token("CteEnt", x);
					fw1.write(token.toString());
					fw1.write(System.lineSeparator());
					fin = (i != -1);
					sig = true;
					return token;
				} else {
					ger.errorLexico(3,contLinea);
				}

			}
			if ((caracter >= 'A' && caracter <= 'Z') || (caracter >= 'a' && caracter <= 'z')) {
				String str = String.valueOf(caracter);
				i = fr.read();
				caracter = (char) i;
				while ((caracter >= '0' && caracter <= '9') || (caracter >= 'A' && caracter <= 'Z')
						|| (caracter >= 'a' && caracter <= 'z') || caracter == '_') {
					str = str + String.valueOf(caracter);
					i = fr.read();
					caracter = (char) i;
				}
				// Comprobar si es palabra reservada
				// Si lo es Genera token <str,->
				Integer idPal = palabrasReservadas.get(str);
				int p;
				if (idPal != null) {
					token = new Token(str, null);
					fw1.write(token.toString());
					fw1.write(System.lineSeparator());
				}
				// Si no es palabra reservada(es ID) se mirada si esta en la tabla de simbolos actual
				// Si no esta se inserta(Se devuelve en que posicion esta),
				// dependiendo si estamos declarando explicimante se deja sin tipo, pero si no se inserta ya el tipo entero
				// Si esta se obtiene la posicion en la tabla
				// Genera token <ID,p>
				// token = new Token("ID",p);
				// fw1.write(token); 
				else if (tsl == null) {
					if((p = ts.buscar(str)) != -1) {
						if(zonaDec) {
							String error = "Variable ya declarada";
							ger.errorSemantico(3, contLinea, error);
						}
							token = new Token("ID", p,str);
							fw1.write(token.toString());
							fw1.write(System.lineSeparator());
					}else {
							p = ts.insertar(str);
							token = new Token("ID", p,str);
							fw1.write(token.toString());
							fw1.write(System.lineSeparator());
							if(!zonaDec) {
								tsg.añadirTipoyDesp(p,"int");
								tsg.desp +=1;
							}
					}
				}
				else {
					if((p = ts.buscar(str)) != -1) {
						if(zonaDec) {
							String error = "Variable ya declarada";
							ger.errorSemantico(3, contLinea, error);
						}
							token = new Token("ID", p,str);
							fw1.write(token.toString());
							fw1.write(System.lineSeparator());
					} else {
						if(zonaDec) {
							p = ts.insertar(str);
							token = new Token("ID", p,str);
							fw1.write(token.toString());
							fw1.write(System.lineSeparator());
						}
						else if((p = tsg.buscar(str)) != -1) {
							token = new Token("ID", p,str);
							fw1.write(token.toString());
							fw1.write(System.lineSeparator());			
						}else {
							p = tsg.insertar(str);
							token = new Token("ID", p,str);
							fw1.write(token.toString());
							fw1.write(System.lineSeparator());
							tsg.añadirTipoyDesp(p,"int");
							tsg.desp +=1;
						}
					}
				}
				fin = (i != -1);
				sig = true;
				return token;
			}
			if (caracter == '"') {
				StringBuilder str = new StringBuilder();
				str.append(caracter);
				cont = 0;
				i = fr.read();
				caracter = (char) i;
				while (caracter != '"') {
					if (i == -1) {
						ger.errorLexico(4,contLinea);
					}
					str.append(caracter);
					i = fr.read();
					caracter = (char) i;
					cont++;

				}
				if (i == -1) {
					token = new Token("eof", null);
					fw1.write(token.toString());
					fw1.write(System.lineSeparator());
					fw2.write(ts.toString());
					return token;
				}
				str.append(caracter);
				if (cont <= 64) {
					// Genera token <cadena,str>
					token = new Token("cadena", str.toString());
					fw1.write(token.toString());
					fw1.write(System.lineSeparator());
					return token;
				} else {
					ger.errorLexico(5,contLinea);
				}
			}
			if (caracter == '+') {
				i = fr.read();
				caracter = (char) i;
				if (caracter == '+') {
					// Genera token <MASMAS,->
					token = new Token("MASMAS", null);
					fw1.write(token.toString());
					fw1.write(System.lineSeparator());
					return token;
				} else {
					ger.errorLexico(6,contLinea);
				}
			}
			if (caracter == '=') {
				strP = "Igual";
				detectado = true;
			}
			if (caracter == ',') {
				strP = "Coma";
				detectado = true;
			}
			if (caracter == ';') {
				strP = "PuntoyComa";
				detectado = true;
			}
			if (caracter == '(') {
				strP = "ParentesisIzq";
				detectado = true;
			}
			if (caracter == ')') {
				strP = "ParentesisDer";
				detectado = true;
			}
			if (caracter == '{') {
				strP = "LlaveIzq";
				detectado = true;
			}
			if (caracter == '}') {
				strP = "LlaveDer";
				detectado = true;
			}
			if (caracter == '-') {
				strP = "Resta";
				detectado = true;
			}
			if (caracter == '!') {
				strP = "Negacion";
				detectado = true;
			}
			if (caracter == '<') {
				strP = "Menor";
				detectado = true;
			}
			if (detectado) {
				// Genera token <strP,->
				token = new Token(strP, null);
				fw1.write(token.toString());
				fw1.write(System.lineSeparator());
				detectado = false;
				return token;
			}
			if (caracter == '_') {
				ger.errorLexico(2,contLinea);
			}
			if (!fin) {
				// Genera token <eof,->
				token = new Token("eof", null);
				fw1.write(token.toString());
				fw1.write(System.lineSeparator());
				return token;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ger.errorLexico(7,contLinea);
		return null;

	}

	private void inicializarMapPalRes() {
		palabrasReservadas = new HashMap<String, Integer>();
		palabrasReservadas.put("boolean", 0);
		palabrasReservadas.put("else", 1);
		palabrasReservadas.put("function", 2);
		palabrasReservadas.put("if", 3);
		palabrasReservadas.put("int", 4);
		palabrasReservadas.put("output", 5);
		palabrasReservadas.put("return", 6);
		palabrasReservadas.put("string", 7);
		palabrasReservadas.put("var", 8);
		palabrasReservadas.put("void", 9);
		palabrasReservadas.put("input", 10);
	}

	private boolean esDelimitador(char car) {
		if (car == '\n') {
			contLinea++;
			return true;
		}
		if (car == ' ' || car == '\0' || car == '\r' || car == '\t')
			return true;
		return false;

	}

}
