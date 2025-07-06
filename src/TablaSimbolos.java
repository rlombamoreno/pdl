

import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class TablaSimbolos {
	private static int id = 100;
	private int i;
	private int ident;
	private FileWriter fw2;
	private Map<Integer, EntradaTS> tabla;
	private Map<String, Integer> tabladeLex;
	public int desp;

	public TablaSimbolos(FileWriter fw2) {
		ident = id++;
		i = 1;
		desp = 0;
		tabla = new HashMap<>();
		tabladeLex = new HashMap<>();
		this.fw2 = fw2;
	}

	public int insertar(String lexema) {
		tabla.put(i, new EntradaTS(lexema));
		tabladeLex.put(lexema, i);
		return i++;
	}

	public Integer buscar(String lexema) {
		Integer i = tabladeLex.get(lexema);
		if (i == null) {
			return -1;
		}
		return i;
	}
	public String buscarTipo(int pos) {
		EntradaTS aux = tabla.get(pos);
		if (aux == null) {
			return null;
		}
		if(aux.getTipo().equals("func")) {
			return aux.getTipoParam();
		}
		return aux.getTipo();
	}
	public String getRetorno(int pos) {
		EntradaTS aux = tabla.get(pos);
		if (aux == null) {
			return null;
		}
		return aux.getRetorno();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("CONTENIDO DE LA TABLA # %d:%n", this.ident));
		for (Map.Entry<Integer, EntradaTS> entry : tabla.entrySet()) {
			EntradaTS entrada = entry.getValue();
			sb.append(entrada.toString());
		}
		return sb.toString();

	}

	public void añadirTipoyDesp(int pos, String atrib) {
		EntradaTS aux = tabla.get(pos);
		aux.setTipo(atrib);
		aux.setDesp(desp);
	}
	
	public void setEtiq(int pos) {
		EntradaTS aux = tabla.get(pos);
		aux.setEtiq("Et"+aux.getLexema());
	}
	
	public void setTipoParamRet(int pos, String tipo,String param, String tipoRet) {
		EntradaTS aux = tabla.get(pos);
		aux.setTipo(tipo);
		aux.setTipoParam(param.split("x"),param);
		aux.setTipoRet(tipoRet);
	}
}

class EntradaTS {

	private String lexema;
	private String tipo;
	private int desplazamiento;
	private int numParam;
	private String tipoParam2;
	private String[] tipoParam;
	private String tipoRet;
	private String etiq;

	public EntradaTS(String lexema) {
		this.lexema = lexema;
	}

	public String getRetorno() {
		return tipoRet;
	}

	public String getTipoParam() {
		return tipoParam2;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipoRet(String tipoRet) {
		this.tipoRet = tipoRet;
		
	}

	public void setTipoParam(String[] split,String tipoParam2) {
		this.tipoParam = split;
		this.numParam = split.length;
		this.tipoParam2 = tipoParam2;
		
	}

	public void setEtiq(String etiq) {
		this.etiq = etiq;
		
	}

	public void setDesp(int desp) {
		desplazamiento = desp;
	}

	public void setTipo(String atrib) {
		tipo = atrib;
		
	}

	public String getLexema() {
		return lexema;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("* LEXEMA : '").append(lexema).append("'\n");
		if(tipo!= null) {
		sb.append("Atributos :\n");
		sb.append(" + tipo : ");
			switch (tipo) {
			case "int":
				sb.append("'int'");
				sb.append("\n");
				sb.append(" + despl : ").append(desplazamiento).append("\n");
				break;
			case "log":
				sb.append("'log'");
				sb.append("\n");
				sb.append(" + despl : ").append(desplazamiento).append("\n");
				break;
			case "cad":
				sb.append("'cad'");
				sb.append("\n");
				sb.append(" + despl : ").append(desplazamiento).append("\n");
				break;
			case "func":
				sb.append("'func'");
				sb.append("\n");
				if(!tipoParam2.equals("void")) {
					if (numParam > 0) {
						sb.append(" 	+ numParam : ").append(numParam).append("\n");
						
						for (int i = 0; i < numParam; i++) {
							sb.append(" 	+ tipoParam" + (i+1) +" : ");
							sb.append("'").append(tipoParam[i]).append("'");
							sb.append("\n");
							sb.append(" 		+ modoParam" + (i+1) +" : 1 ");
							sb.append("\n");
						}
					}
				}else {
					sb.append(" 	+ numParam : ").append(0).append("\n");
				}
				sb.append(" 		+ TipoRetorno : '").append(tipoRet).append("'\n");
				sb.append(" 	+ etiqFuncion: '").append(etiq).append("'\n");
			default:
				break;
			}
		}
		sb.append("--------- ----------\n");
		return sb.toString();

	}

}
