import java.io.FileWriter;
import java.io.IOException;
import java.util.EnumSet;
import java.util.Stack;

public class AnalizadorSintactico {
	private FileWriter fw2;
	private FileWriter fw3;
	private AnalizadorLexico al;
	private AnalizadorSemantico asem;
	private GestorErrores ger;
	private TablaReg tr;
	private Token tk;
	TablaSimbolos tsg;
	TablaSimbolos tsl;
	Stack<simbolos> pila;
	Stack<simbolos> pilaAux;
	Stack<Integer> reglas;
	Stack<Object> pilaAtrib;
	Stack<Object> pilaAuxAtrib;
	public boolean zonaDecla;
	public boolean puedApReturn;
	public boolean func;
	
	public enum simbolos{$,PP,P,B, Z,Y,F,H,A,K,C,T,S,SS,L,Q,X,E,EE,R,RR,U,UU,V,J,
		eof,var,id,abrePar,cierraPar,ifS,elseS,function,voidS,intS,coma,booleanS,stringS,
		output,input,returnS,igual,menor,resta,distinto,masmas,ent,cad,puntComa,abreLlav,cierraLlav,uno,dos,tres,cuatro,cinco,seis,siete,ocho,nueve,diez,once,doce,trece,catorce,quince,
		dieciseis,diecisiete,dieciocho,diecinueve,veinte,veintiuno,veintidos,veintitres,veinticuatro,veinticinco,veintiseis,veintisiete,veintiocho,veintinueve,treinta,treintaiuno,treintaidos,treintaitres,
		treintaicuatro,treintaicinco,treintaiseis,treintaisiete,treintaiocho,treintainueve,cuarenta,cuarentayuno,
		cuarentaydos,cuarentaytres,cuarentaycuatro,cuarentaycinco,cuarentayseis,cuarentaysiete,cuarentayocho,cuarentaynueve,cincuenta}
	
	public enum simbolosTerminales{$,eof,var,id,abrePar,cierraPar,ifS,elseS,function,voidS,intS,coma,booleanS,stringS,
		output,input,returnS,igual,menor,resta,distinto,masmas,ent,cad,puntComa,abreLlav,cierraLlav}
	
	public enum simbolosNoTerminales{PP,P,B,Z,Y,F,H,A,K,C,T,S,SS,L,Q,X,E,EE,R,RR,U,UU,V,J}
	
	
	public AnalizadorSintactico(AnalizadorLexico al,FileWriter fw3, GestorErrores ger, FileWriter fw2, AnalizadorSemantico asem) {
		this.al = al;
		this.fw2 = fw2;
		this.fw3=fw3;
		this.ger = ger;
		this.asem = asem;
		tr = new TablaReg();
		pila = new Stack<simbolos>();
		reglas = new Stack<Integer>();
		pilaAux = new Stack<simbolos>();
		pilaAtrib = new Stack<Object>();
		pilaAuxAtrib = new Stack<Object>();
		tsg = new TablaSimbolos(fw2);
		tsl = null; 
		puedApReturn = false;
		func = false;
		try {
			fw3.write("Descendente ");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void parse() {
		int nlinea;
		pila.push(simbolos.$);
		pilaAtrib.push(null);
		reglas.push(0);
		pila.push(simbolos.PP);
		pilaAtrib.push(null);
		reglas.push(0);
		tk = al.getToken(zonaDecla,tsg,tsl);
		boolean fin = false;
		simbolos cima;
		simbolos aux;	
		try {
			while(pila.peek()!= simbolos.$) {
				if(!fin) {
					aux = tk.tokenToSimb();
				}else {
					aux = simbolos.$;
				}
				cima = pila.peek();
				if(esTerm(cima)) {
					if(cima != aux) {
						nlinea = AnalizadorLexico.contLinea;
						ger.errorSintactico(1,nlinea,cima,aux);
					}
					else {
						simbolos pasante = pila.pop();
						reglas.pop();
						pilaAtrib.pop();
						pilaAux.push(pasante);
						if(pasante == simbolos.id) {
							Object pos =  tk.getNombre();
							pilaAuxAtrib.push(pos);
						}
						else {
							pilaAuxAtrib.push(null);
						}
						if(!tk.equals(new Token("eof", null))) {
							tk = al.getToken(zonaDecla,tsg,tsl);
						}
						else {
							fin = true;
						}
					}
				}
				else if(esNoTerm(cima)) {
					int poscima = simbolosNoTerminales.valueOf(cima.name()).ordinal();		
					int posaux = simbolosTerminales.valueOf(aux.name()).ordinal();
					if(tr.reg[poscima][posaux]!=null) {
						reglas.pop();
						simbolos pasante = pila.pop();
						pilaAux.push(pasante);
						Object atribPasante = pilaAtrib.pop();
						pilaAuxAtrib.push(atribPasante);
						int i = 0;
						Regla reg = tr.reg[poscima][posaux];
						for(;i<reg.getList().size();i++) {
							pila.push(reg.getList().get(i));
							reglas.push(reg.getNum());
							pilaAtrib.push(null);
						}
						fw3.write(reg.getNum() + " ");
					}else {
						nlinea = AnalizadorLexico.contLinea;
						ger.errorSintactico(reglas.pop(),nlinea,cima,aux);
					}
					
				}
				else {
					simbolos regla = pila.pop();
					pilaAtrib.pop();
					nlinea = AnalizadorLexico.contLinea;
					asem.realizarRegla(regla,pilaAux,pilaAuxAtrib,nlinea,tsg,tsl,puedApReturn,func);	
				}
			}
			fw2.write(tsg.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean esTerm(simbolos s) {
		try {
			EnumSet<simbolosTerminales> terminales = EnumSet.allOf(simbolosTerminales.class);
			 return terminales.contains(simbolosTerminales.valueOf(s.name()));	
		}catch (IllegalArgumentException e) {
	        return false; 
	    }
		 
	}
	public boolean esNoTerm(simbolos s) {
		try {
			EnumSet<simbolosNoTerminales> noTerminales = EnumSet.allOf(simbolosNoTerminales.class);
			 return noTerminales.contains(simbolosNoTerminales.valueOf(s.name()));
		}catch (IllegalArgumentException e) {
	        return false;
	    }
	}
	
	public void nuebaTabla() {
		tsl = new TablaSimbolos(fw2);
	}
	
	public void destriurTabla() throws IOException {
		fw2.write(tsl.toString());
		tsl = null;
	}
	
	public void setZonaDecla (boolean valor) {
		zonaDecla = valor;
	}
	
	
	

}
