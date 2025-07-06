
public class Token {
	
	private String identifier;
	private Object attribute;
	private String nombre;
	
	public Token(String id, Object attrib) {
		switch(id) {
		case "boolean":
			identifier="BOOLEAN";
			attribute=null;
			break;
		case "else":
			identifier="ELSE";
			attribute=null;
			break;
		case "function":
			identifier="FUNCTION";
			attribute=null;
			break;
		case "if":
				identifier="IF";
				attribute=null;
				break;
		case "int":
			identifier="INT";
			attribute=null;
			break;
		case "output":
			identifier="OUTPUT";
			attribute=null;
			break;
		case "return":
			identifier="RETURN";
			attribute=null;
			break;
		case "string":
			identifier="STRING";
			attribute=null;
			break;
		case "var":
			identifier="VAR";
			attribute=null;
			break;
		case "void":
			identifier="VOID";
			attribute=null;
			break;
		case "input":
			identifier="INPUT";
			attribute=null;
			break;
		case "MASMAS":
			identifier=id;
			attribute=null;
			break;
		case "CteEnt":
			identifier= id;
			attribute= attrib;
			break;
		case "cadena":
			identifier= id;
			attribute= attrib;
			break;
		case "ID":
			identifier= id;
			attribute= attrib;
			break;
		case "Igual":
			identifier= id;
			attribute= null;
			break;
		case "Coma":
			identifier= id;
			attribute= attrib;
			break;
		case "PuntoyComa":
			identifier= id;
			attribute= null;
			break;
		case "ParentesisIzq":
			identifier= id;
			attribute= null;
			break;
		case "ParentesisDer":
			identifier= id;
			attribute= null;
			break;
		case "LlaveIzq":
			identifier= id;
			attribute= null;
			break;
		case "LlaveDer":
			identifier= id;
			attribute= null;
			break;
		case "Resta":
			identifier= id;
			attribute= null;
			break;
		case "Negacion":
			identifier= id;
			attribute= null;
			break;
		case "Menor":
			identifier= id;
			attribute= null;
			break;
		case "eof":
			identifier= id;
			attribute= null;
			break;
		}
		
	}
	public Token(String id, Object attrib,String nombre) {
		identifier= id;
		attribute= attrib;
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	
	public String getId() {
		return identifier;
	}
	
	public Object getAtribute() {
		return attribute;
	}
	
	public AnalizadorSintactico.simbolos tokenToSimb(){
		switch(identifier) {
		case "BOOLEAN":
			return AnalizadorSintactico.simbolos.booleanS;
		case "ELSE":
			return AnalizadorSintactico.simbolos.elseS;
		case "FUNCTION":
			return AnalizadorSintactico.simbolos.function;
		case "IF":
			return AnalizadorSintactico.simbolos.ifS;
		case "INT":
			return AnalizadorSintactico.simbolos.intS;
		case "OUTPUT":
			return AnalizadorSintactico.simbolos.output;
		case "RETURN":
			return AnalizadorSintactico.simbolos.returnS;
		case "STRING":
			return AnalizadorSintactico.simbolos.stringS;
		case "VAR":
			return AnalizadorSintactico.simbolos.var;
		case "VOID":
			return AnalizadorSintactico.simbolos.voidS;
		case "INPUT":
			return AnalizadorSintactico.simbolos.input;
		case "MASMAS":
			return AnalizadorSintactico.simbolos.masmas;
		case "CteEnt":
			return AnalizadorSintactico.simbolos.ent;
		case "cadena":
			return AnalizadorSintactico.simbolos.cad;
		case "ID":
			return AnalizadorSintactico.simbolos.id;
		case "Igual":
			return AnalizadorSintactico.simbolos.igual;
		case "Coma":
			return AnalizadorSintactico.simbolos.coma;
		case "PuntoyComa":
			return AnalizadorSintactico.simbolos.puntComa;
		case "ParentesisIzq":
			return AnalizadorSintactico.simbolos.abrePar;
		case "ParentesisDer":
			return AnalizadorSintactico.simbolos.cierraPar;
		case "LlaveIzq":
			return AnalizadorSintactico.simbolos.abreLlav;
		case "LlaveDer":
			return AnalizadorSintactico.simbolos.cierraLlav;
		case "Resta":
			return AnalizadorSintactico.simbolos.resta;
		case "Negacion":
			return AnalizadorSintactico.simbolos.distinto;
		case "Menor":
			return AnalizadorSintactico.simbolos.menor;
		case "eof":
			return AnalizadorSintactico.simbolos.eof;
		
		}
		return null;
	}
	
	@Override
	public String toString() {
		if (this.attribute == null) {
			return "<" + this.identifier + ", >";
		}
		return "<" + this.identifier + ", " + this.attribute + ">";
	}
	@Override
	public boolean equals(Object obj) {
		Token tok = (Token) obj;
		return identifier.equals(tok.getId());
	}
}
