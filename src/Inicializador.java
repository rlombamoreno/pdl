

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Inicializador {
	public static void main(String[] args) {
		AnalizadorLexico al;
		FileReader fr;
		FileWriter fw1;
		FileWriter fw2;
		FileWriter fw3;
		AnalizadorSintactico asin;
		AnalizadorSemantico asem;
		GestorErrores ger;
		
		try {
			fr = new FileReader(args[0]);
			fw1 = new FileWriter("Tokens.txt");
			fw2 = new FileWriter("TabSim.txt");
			fw3 = new FileWriter("Parse.txt");
			ger = new GestorErrores(fr, fw1, fw2,fw3);
			al = new AnalizadorLexico(fr, fw1, fw2,ger);
			asem = new AnalizadorSemantico(ger);
			asin = new AnalizadorSintactico(al,fw3,ger,fw2,asem);
			asem.set_asint(asin);
			asin.parse();
			fr.close();
			fw1.close();
			fw2.close();
			fw3.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

}
