import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;


public class AnalizadorSemantico {
	private GestorErrores ger;
	private AnalizadorSintactico asin;
	public AnalizadorSemantico(GestorErrores ger) {
		this.ger = ger;
	}
	public void set_asint(AnalizadorSintactico asin) {
		this.asin = asin;
	}
	public void realizarRegla(AnalizadorSintactico.simbolos regla, Stack<AnalizadorSintactico.simbolos> pilaAux, Stack<Object> pilaAuxAtrib, int nlinea, TablaSimbolos tsg,
			TablaSimbolos tsl, boolean puedApReturn, boolean func) {
		String tipo_ret;
		String tipo_retAux;
		String tipo_param;
		String pos;
		String atrib;
		String idTipo;
		String retorno;
		int p;
		AnalizadorSintactico.simbolos aux;
		switch(regla) {
			case uno:
				//1
				pilaAux.pop();
				pilaAuxAtrib.pop();
				break;
			case dos:
				//2
				pilaAux.pop();
				pilaAuxAtrib.pop();
				//1
				pilaAux.pop();
				pilaAuxAtrib.pop();
				break;
			case tres:
				asin.setZonaDecla(true);
				break;
			case cuatro:
				// ;
				pilaAux.pop();
				pilaAuxAtrib.pop();
				// id
				pos = (String) pilaAuxAtrib.pop();
				pilaAux.pop();
				//T
				atrib = (String) pilaAuxAtrib.pop();
				pilaAux.pop();
				if(tsl != null) {
					tsl.añadirTipoyDesp(tsl.buscar(pos),atrib);
					if(atrib.equals("int") || atrib.equals("log")) {
						tsl.desp +=1;
					}
					else {
						tsl.desp +=64;
					}	
				}
				else {
					tsg.añadirTipoyDesp(tsg.buscar(pos),atrib);
					if(atrib.equals("int") || atrib.equals("log")) {
						tsg.desp +=1;
					}
					else {
						tsg.desp +=64;
					}	
				}
				//var
				pilaAux.pop();
				pilaAuxAtrib.pop();
				
				pilaAuxAtrib.pop();
				pilaAuxAtrib.push("void");
				
				break;
			case cinco:
				//Z
				pilaAux.pop();
				tipo_ret = (String) pilaAuxAtrib.pop();
				// )
				pilaAux.pop();
				pilaAuxAtrib.pop();
				// E
				pilaAux.pop();
				String tipo_E = (String) pilaAuxAtrib.pop();
				// )
				pilaAux.pop();
				pilaAuxAtrib.pop();
				// if
				pilaAux.pop();
				pilaAuxAtrib.pop();
				
				if(tipo_E.equals("log")) {
					pilaAuxAtrib.pop();
					pilaAuxAtrib.push(tipo_ret);
				}
				else {
					String error = "Expresion del if no logica";
					ger.errorSemantico(3, nlinea, error);
				}
				break;
			case seis:
				//1
				pilaAux.pop();
				tipo_ret = (String) pilaAuxAtrib.pop();
				// 2
				pilaAuxAtrib.pop();
				pilaAuxAtrib.push(tipo_ret);
				break;
			case siete:
				//Y
				pilaAux.pop();
				tipo_ret = (String) pilaAuxAtrib.pop();
				//}
				pilaAux.pop();
				pilaAuxAtrib.pop();
				//C
				pilaAux.pop();
				tipo_retAux = (String) pilaAuxAtrib.pop();
				//{
				pilaAux.pop();
				pilaAuxAtrib.pop();
				
				pilaAuxAtrib.pop();
				if(tipo_ret.equals(tipo_retAux)) {
					pilaAuxAtrib.push(tipo_ret);
				}
				else if(tipo_ret.equals("void")) {
					pilaAuxAtrib.push(tipo_retAux);
				}
				else if(tipo_retAux.equals("void")) {
					pilaAuxAtrib.push(tipo_ret);
				}
				else {
					String error = "No coinciden los tipos que se intentan devolver";
					ger.errorSemantico(3, nlinea, error);
				}
				break;
			case ocho:
				// }
				pilaAux.pop();
				pilaAuxAtrib.pop();
				
				// C
				pilaAux.pop();
				tipo_ret = (String) pilaAuxAtrib.pop();
				
				// {
				pilaAux.pop();
				pilaAuxAtrib.pop();
				
				// else
				pilaAux.pop();
				pilaAuxAtrib.pop();
				
				//Y
				pilaAuxAtrib.pop();
				pilaAuxAtrib.push(tipo_ret);
				break;
				
			case nueve: 
				pilaAuxAtrib.pop();
				pilaAuxAtrib.push("void");
				break;
			case diez:
				asin.nuebaTabla();
				break;
			case once:
				asin.setZonaDecla(false);
				break;
			case doce:
				// )
				pilaAux.pop();
				pilaAuxAtrib.pop();
				//A
				pilaAux.pop();
				tipo_param= (String) pilaAuxAtrib.pop();
				//(
				pilaAux.pop();
				pilaAuxAtrib.pop();
				//id
				pilaAux.pop();
				pos = (String) pilaAuxAtrib.pop();
				//H
				tipo_ret = (String) pilaAuxAtrib.peek();
				
				tsg.setTipoParamRet(tsg.buscar(pos), "func", tipo_param, tipo_ret);
				tsg.setEtiq(tsg.buscar(pos));
				asin.puedApReturn = true;
				break;
			case trece: 
				// }
				pilaAux.pop();
				pilaAuxAtrib.pop();
				
				// C
				pilaAux.pop();
				tipo_ret = (String) pilaAuxAtrib.pop();
				
				// {
				pilaAux.pop();
				pilaAuxAtrib.pop();
				
				//H
				pilaAux.pop();
				tipo_retAux = (String) pilaAuxAtrib.pop();
				
				//function
				pilaAux.pop();
				pilaAuxAtrib.pop();
				
				if(!tipo_ret.equals(tipo_retAux)) {
					String error = "No coincide el tipo que se intenta devolver con el que se ha definido en la funcion";
					ger.errorSemantico(3, nlinea, error);
				}
				try {
					asin.destriurTabla();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				asin.puedApReturn = false;
				break;
			case catorce:
				// T
				pilaAux.pop();
				tipo_ret = (String) pilaAuxAtrib.pop();
				//H
				pilaAuxAtrib.pop();
				pilaAuxAtrib.push(tipo_ret);
				break;
			case quince:
				// void
				pilaAux.pop();
				pilaAuxAtrib.pop();
				//H || A
				pilaAuxAtrib.pop();
				pilaAuxAtrib.push("void");
				break;
			case dieciseis:
				//id
				aux = pilaAux.pop();
				pos = (String) pilaAuxAtrib.pop();
				//T
				pilaAux.pop();
				atrib = (String) pilaAuxAtrib.pop();
				
				tsl.añadirTipoyDesp(tsl.buscar(pos),atrib);
				if(atrib.equals("int") || atrib.equals("log")) {
					tsl.desp +=1;
				}
				else {
					tsl.desp +=64;
				}	
				pilaAux.push(aux);
				pilaAuxAtrib.push(pos);
				break;
			case diecisiete:
				//id
				aux = pilaAux.pop();
				pos = (String) pilaAuxAtrib.pop();
				//T
				pilaAux.pop();
				atrib = (String) pilaAuxAtrib.pop();
				
				tsl.añadirTipoyDesp(tsl.buscar(pos),atrib);
				if(atrib.equals("int") || atrib.equals("log")) {
					tsl.desp +=1;
				}
				else {
					tsl.desp +=64;
				}				
				// ,
				pilaAux.pop();
				pilaAuxAtrib.pop();
				
				pilaAux.push(aux);
				pilaAuxAtrib.push(pos);		
				break;
			case dieciocho:
				pilaAuxAtrib.pop();
				pilaAuxAtrib.push("");
				break;
			case diecinueve:
				//C
				pilaAux.pop();
				tipo_ret = (String) pilaAuxAtrib.pop();
				
				//B
				pilaAux.pop();
				tipo_retAux = (String) pilaAuxAtrib.pop();
				
				pilaAuxAtrib.pop();
				if(tipo_ret.equals(tipo_retAux)) {
					pilaAuxAtrib.push(tipo_ret);
				}
				else if(tipo_ret.equals("void")) {
					pilaAuxAtrib.push(tipo_retAux);
				}
				else if(tipo_retAux.equals("void")) {
					pilaAuxAtrib.push(tipo_ret);
				}
				else {
					String error = "No coinciden los tipos que se intentan devolver";
					ger.errorSemantico(3, nlinea, error);
				}
				
				break;
			case veinte:
				pilaAuxAtrib.pop();
				pilaAuxAtrib.push("void");
				break;
			case veintiuno:
				pilaAux.pop();
				pilaAuxAtrib.pop();
				
				pilaAuxAtrib.pop();
				pilaAuxAtrib.push("int");
				break;
			case veintidos:
				pilaAux.pop();
				pilaAuxAtrib.pop();
				
				pilaAuxAtrib.pop();
				pilaAuxAtrib.push("log");
				break;
			case veintitres:
				pilaAux.pop();
				pilaAuxAtrib.pop();
				
				pilaAuxAtrib.pop();
				pilaAuxAtrib.push("cad");
				break;
			case veinticuatro:
				//SS
				pilaAux.pop();
				tipo_ret = (String) pilaAuxAtrib.pop();
				//id
				pilaAux.pop();
				pos = (String) pilaAuxAtrib.pop();
				
				if(tsl != null) {
					if((p = (tsl.buscar(pos))) != -1) {
						idTipo = tsl.buscarTipo(p);
						retorno = tsl.getRetorno(tsg.buscar(pos));
					}
					else{
						idTipo = tsg.buscarTipo(tsg.buscar(pos));
						retorno = tsg.getRetorno(tsg.buscar(pos));
					}
					if(!func) {
						if(!idTipo.equals(tipo_ret)) {
							String error = "No coinciden los tipos de la asignacion";
							ger.errorSemantico(3, nlinea, error);
						}
					}
					else {
						if(retorno == null) {
							String error = "Funcion no declarada";
							ger.errorSemantico(3, nlinea, error);
						}
					}
						
				}else {
					idTipo = tsg.buscarTipo(tsg.buscar(pos));
					if(!func) {
						if(!idTipo.equals(tipo_ret)) {
							String error = "No coinciden los tipos de la asignacion";
							ger.errorSemantico(3, nlinea, error);
						}
					}
					else {
						if(tsg.getRetorno(tsg.buscar(pos))==null) {
							String error = "funcion no declarada";
							ger.errorSemantico(3, nlinea, error);
						}
						if(!idTipo.equals(tipo_ret)) {
							String error = "Parametros incorrectos";
							ger.errorSemantico(3, nlinea, error);
						}
					
					}
				}
				pilaAuxAtrib.pop();
				pilaAuxAtrib.push("void");
				asin.func = false;
				break;
			case veinticinco:
				// ;
				pilaAux.pop();
				pilaAuxAtrib.pop();
				//E
				pilaAux.pop();
				pilaAuxAtrib.pop();
				// output
				pilaAux.pop();
				pilaAuxAtrib.pop();
				
				pilaAuxAtrib.pop();
				pilaAuxAtrib.push("void");
				break;
			case veintiseis:
				//;
				pilaAux.pop();
				pilaAuxAtrib.pop();
				//id
				pilaAux.pop();
				pos = (String) pilaAuxAtrib.pop();
				// input
				pilaAux.pop();
				pilaAuxAtrib.pop();
				if(tsl != null) {
					if((p = (tsl.buscar(pos))) != -1) {
						idTipo = tsl.buscarTipo(p);
					}
					else{
						idTipo = tsg.buscarTipo(tsg.buscar(pos));
					}
					if(idTipo.equals("log")) {
						String error = "La variable del input debe ser un entero o una cadena";
						ger.errorSemantico(3, nlinea, error);
					}	
				}else {
					idTipo = tsg.buscarTipo(tsg.buscar(pos));
					if(idTipo.equals("log")) {
						String error = "La variable del input debe ser un entero o una cadena";
						ger.errorSemantico(3, nlinea, error);
					}
				}
				pilaAuxAtrib.pop();
				pilaAuxAtrib.push("void");
				break;
				
			case veintisiete:
				// ;
				pilaAux.pop();
				pilaAuxAtrib.pop();
				// E
				pilaAux.pop();
				tipo_ret = (String) pilaAuxAtrib.pop();
				// =
				pilaAux.pop();
				pilaAuxAtrib.pop();
				// SS
				pilaAuxAtrib.pop();
				pilaAuxAtrib.push(tipo_ret);
				break;
			case veintiocho:
				asin.func = true;
				// ;
				pilaAux.pop();
				pilaAuxAtrib.pop();
				//)
				pilaAux.pop();
				pilaAuxAtrib.pop();
				//L
				pilaAux.pop();
				tipo_ret = (String) pilaAuxAtrib.pop();
				//(
				pilaAux.pop();
				pilaAuxAtrib.pop();
				// SS
				pilaAuxAtrib.pop();
				pilaAuxAtrib.push(tipo_ret);
				break;
			case veintinueve:	
				//Q
				pilaAux.pop();
				tipo_ret = (String) pilaAuxAtrib.pop();
				
				//E
				pilaAux.pop();
				atrib = (String) pilaAuxAtrib.pop();
					
				if(tipo_ret.equals("")) {
					tipo_retAux = atrib;
				}else{
					tipo_retAux = atrib +"x" + tipo_ret;
				}
				
				// L := E.tipo x Q.tipo
				pilaAuxAtrib.pop();
				pilaAuxAtrib.push(tipo_retAux);			
				break;
			case treinta:	
				pilaAuxAtrib.pop();
				pilaAuxAtrib.push("void");
				break;
			case treintaiuno:	
				//Q
				pilaAux.pop();
				tipo_ret = (String) pilaAuxAtrib.pop();
				
				//E
				pilaAux.pop();
				atrib = (String) pilaAuxAtrib.pop();
				
				//,
				pilaAux.pop();
				pilaAuxAtrib.pop();
				
				if(tipo_ret.equals("")) {
					tipo_retAux = atrib;
				}else{
					tipo_retAux = atrib +"x" + tipo_ret;
				}
				
				// L := E.tipo x Q.tipo
				pilaAuxAtrib.pop();
				pilaAuxAtrib.push(tipo_retAux);		
				break;
			case treintaidos:	
				pilaAuxAtrib.pop();
				pilaAuxAtrib.push("");
				break;
			case treintaitres:		
				pilaAux.pop();
				tipo_ret = (String) pilaAuxAtrib.pop();
				pilaAuxAtrib.pop();
				pilaAuxAtrib.push(tipo_ret);	
				break;
			case treintaicuatro:
				pilaAuxAtrib.pop();
				pilaAuxAtrib.push("void");
				break;
			case treintaicinco:
				//EE
				pilaAux.pop();
				tipo_ret = (String) pilaAuxAtrib.pop();
				//R
				pilaAux.pop();
				tipo_retAux = (String) pilaAuxAtrib.pop();
				if(tipo_ret.equals("vacio")) {
					pilaAuxAtrib.pop();
					pilaAuxAtrib.push(tipo_retAux);
				}
				else {
					if(tipo_retAux.equals("int")) {
						pilaAuxAtrib.pop();
						pilaAuxAtrib.push("log");
					}
					else {
						String error = "No se puede hacer una operación de relación si no es un dato o variable entera";
						ger.errorSemantico(3, nlinea, error);
					}
				}
				break;
				
			case treintaiseis:
				//EE1
				pilaAux.pop();
				tipo_ret = (String) pilaAuxAtrib.pop();
				//R
				pilaAux.pop();
				tipo_retAux = (String) pilaAuxAtrib.pop();
				//<
				pilaAux.pop();
				pilaAuxAtrib.pop();
				if(tipo_retAux.equals("int")) {
					pilaAuxAtrib.pop();
					pilaAuxAtrib.push("ok");
				}
				else {
					String error = "No se puede hacer una operación de relación si no es un dato o variable entera";
					ger.errorSemantico(3, nlinea, error);
				}
				break;
			case treintaisiete:
				pilaAuxAtrib.pop();
				pilaAuxAtrib.push("vacio");
				break;
			case treintaiocho:
				//RR
				pilaAux.pop();
				tipo_ret = (String) pilaAuxAtrib.pop();
				//U
				pilaAux.pop();
				tipo_retAux = (String) pilaAuxAtrib.pop();
				
				if(tipo_ret.equals("vacio")) {
					pilaAuxAtrib.pop();
					pilaAuxAtrib.push(tipo_retAux);
				}
				else {
					if(tipo_retAux.equals("int")) {
						pilaAuxAtrib.pop();
						pilaAuxAtrib.push(tipo_retAux);
					}
					else {
						String error = "No se puede hacer una resta si no es un dato o variable entera";
						ger.errorSemantico(3, nlinea, error);
					}
				}
				break;
				
			case treintainueve:
				//RR
				pilaAux.pop();
				tipo_ret = (String) pilaAuxAtrib.pop();
				//U
				pilaAux.pop();
				tipo_retAux = (String) pilaAuxAtrib.pop();
				
				//-
				pilaAux.pop();
				pilaAuxAtrib.pop();
				
				
				if(tipo_retAux.equals("int")) {
					pilaAuxAtrib.pop();
					pilaAuxAtrib.push("ok");
				}
				else {
					String error = "No se puede hacer una resta si no es un dato o variable entera";
					ger.errorSemantico(3, nlinea, error);
					
				}
				break;
				
			case cuarenta:
				pilaAuxAtrib.pop();
				pilaAuxAtrib.push("vacio");
				break;
			case cuarentayuno:
				//V
				pilaAux.pop();
				tipo_retAux = (String) pilaAuxAtrib.pop();
				
				//!
				pilaAux.pop();
				pilaAuxAtrib.pop();
				
				if(tipo_retAux.equals("log")) {
					pilaAuxAtrib.pop();
					pilaAuxAtrib.push(tipo_retAux);
				}
				else {
					String error = "No se puede hacer una negacion si no es un dato o variable logico";
					ger.errorSemantico(3, nlinea, error);
					
				}
				break;
			case cuarentaydos:
				//UU
				pilaAux.pop();
				tipo_ret = (String) pilaAuxAtrib.pop();
				//V
				pilaAux.pop();
				tipo_retAux = (String) pilaAuxAtrib.pop();
				
				if(tipo_ret.equals("vacio")) {
					pilaAuxAtrib.pop();
					pilaAuxAtrib.push(tipo_retAux);
				}
				else {
					if(tipo_retAux.equals("int")) {
						pilaAuxAtrib.pop();
						pilaAuxAtrib.push(tipo_retAux);
					}
					else {
						String error = "No se puede hacer un incremento si no es una variable entera";
						ger.errorSemantico(3, nlinea, error);
					}
				}
				break;
			case cuarentaytres:
				// UU
				pilaAux.pop();
				pilaAuxAtrib.pop();
				//++
				pilaAux.pop();
				pilaAuxAtrib.pop();
				//UU
				pilaAuxAtrib.pop();
				pilaAuxAtrib.push("ok");
				break;
			case cuarentaycuatro:
				//UU
				pilaAuxAtrib.pop();
				pilaAuxAtrib.push("vacio");
				break;
			case cuarentaycinco:
				//J
				pilaAux.pop();
				tipo_ret = (String) pilaAuxAtrib.pop();
				//id
				pilaAux.pop();
				pos = (String) pilaAuxAtrib.pop();
				
				if(tsl != null) {
					if((p = (tsl.buscar(pos))) != -1) {
						idTipo = tsl.buscarTipo(p);
						retorno = tsl.getRetorno(p);
					}
					else{
						idTipo = tsg.buscarTipo(tsg.buscar(pos));
						retorno = tsg.getRetorno(tsg.buscar(pos));
					}
				}else {
					idTipo = tsg.buscarTipo(tsg.buscar(pos));
					retorno = tsg.getRetorno(tsg.buscar(pos));
				}
				
				if(tipo_ret.equals("vacio")) {
					pilaAuxAtrib.pop();
					pilaAuxAtrib.push(idTipo);
				}
				else {
					if(idTipo.equals(tipo_ret)) {
						pilaAuxAtrib.pop();
						pilaAuxAtrib.push(retorno);
					}else if(retorno == null) {
						String error = "Funcion no declarada";
						ger.errorSemantico(3, nlinea, error);
					}
					else {
						String error = "Los tipos de los argumentos de la funcion no son correctos";
						ger.errorSemantico(3, nlinea, error);
					}
				}
				break;
			case cuarentayseis:
				// )
				pilaAux.pop();
				pilaAuxAtrib.pop();
				//E
				pilaAux.pop();
				tipo_ret = (String) pilaAuxAtrib.pop();
				//(
				pilaAux.pop();
				pilaAuxAtrib.pop();
				
				pilaAuxAtrib.pop();
				pilaAuxAtrib.push(tipo_ret);	
				break;
				
			case cuarentaysiete:
				pilaAuxAtrib.pop();
				pilaAuxAtrib.push("vacio");
				break;
				
			case cuarentayocho:
				if(!puedApReturn) {
					String error = "No puede aparecer un return fuera de una funcion";
					ger.errorSemantico(3, nlinea, error);
				}
				// ;
				pilaAux.pop();
				pilaAuxAtrib.pop();
				//X 
				pilaAux.pop();
				tipo_ret = (String) pilaAuxAtrib.pop();
				// return 
				pilaAux.pop();
				pilaAuxAtrib.pop();
				// S 
				pilaAuxAtrib.pop();
				pilaAuxAtrib.push(tipo_ret);
				break;
				
			case cuarentaynueve:
				//K
				pilaAux.pop();
				tipo_ret = (String) pilaAuxAtrib.pop();
				
				//id
				pilaAux.pop();
				pos = (String) pilaAuxAtrib.pop();
				
				atrib = tsl.buscarTipo(tsl.buscar(pos));
				
				if(tipo_ret.equals("")) {
					tipo_retAux = atrib;
				}else{
					tipo_retAux = atrib +"x" + tipo_ret;
				}
				// A := T.tipo x K.tipo
				pilaAuxAtrib.pop();
				pilaAuxAtrib.push(tipo_retAux);	
				break;
			case cincuenta:
				// )
				pilaAux.pop();
				pilaAuxAtrib.pop();
				//L
				pilaAux.pop();
				tipo_ret = (String) pilaAuxAtrib.pop();
				//(
				pilaAux.pop();
				pilaAuxAtrib.pop();
				
				pilaAuxAtrib.pop();
				pilaAuxAtrib.push(tipo_ret);	
				break;
		}
		
		
	}
	


}
