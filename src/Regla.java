import java.util.List;

public class Regla {
	private int num;
	private List<AnalizadorSintactico.simbolos> l;
	
	public Regla(List<AnalizadorSintactico.simbolos> l, int num) {
		this.l = l;
		this.num = num;
	}
	
	public int getNum() {
		return num;
	}
	
	public List<AnalizadorSintactico.simbolos> getList(){
		return l;
	}
	
	
	

}
