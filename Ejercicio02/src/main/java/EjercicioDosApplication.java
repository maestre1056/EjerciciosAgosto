import java.io.IOException;

public class EjercicioDosApplication {
    public static void main(String[] args) throws IOException {

        CrearObjeto crearObjeto;
        try {
            crearObjeto = new CrearObjeto();
            crearObjeto.PrintList(crearObjeto.openFile());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
