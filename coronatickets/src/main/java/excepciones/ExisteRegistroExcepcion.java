package excepciones;

public class ExisteRegistroExcepcion extends Exception{

	private static final long serialVersionUID = 1L;
	public ExisteRegistroExcepcion(String string) {
        super(string);
    }
}
