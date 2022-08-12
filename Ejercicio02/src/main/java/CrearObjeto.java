import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrearObjeto {


    private List<Persona> lista;

    public CrearObjeto() throws FileNotFoundException {

        lista= new ArrayList<>();

      /*  p1.setNombre("antonio");
        p1.setEdad(49);
        p1.setDireccion("cordoba");

        p2.setNombre("Fran");
        p2.setEdad(52);
        p2.setDireccion("Madrid");

        p3.setNombre("Jose");
        p3.setEdad(25);
        p3.setDireccion("Sanse");

        lista = new ArrayList<>();
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);

        */

    }


    public void PrintList(List<Persona> lista) {

        lista.forEach(p -> System.out.println("Nombre...:" + p.getNombre() + " Edad: " + p.getEdad() + " Ciudad: " + p.getDireccion()));
        System.out.println("-----\n----\nPERSONAS CON EDAD INFERIOR A 15 AÑOS ");
        //List<Persona> newLista=
        lista.stream()
                .filter(p -> p.getEdad() < 15)
                .forEach(p -> System.out.println("Nombre...:" + p.getNombre() + " Con edad de: " + p.getEdad()));
        //.collect(toList());

        //newLista.forEach( p ->  System.out.println("Nombre...:"+p.getNombre()+ " Con edad de: "+p.getEdad()));
    }
    public List<Persona> openFile() throws FileNotFoundException
    {

        List<String> people = new ArrayList<>();
        File f = new File("C:\\Java\\EjerciciosGitLab\\Ejercicio02\\src\\main\\resources\\datos.txt");
        Scanner sc = new Scanner(f);
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            String[] person = s.split(":");
            Persona p=  new Persona();
            p.setNombre(person[0]);
            p.setDireccion(person[1]);
            p.setEdad(person.length>2
                    ?Integer.parseInt(person[2]):0);
            lista.add(p);
        }
        return lista;
    }
}
