public class Persona {
    private String nombre;
    private Integer edad;
    private String direccion;

    public String getNombre() {
        return nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return
                "nombre='" + nombre + '\'' +
                        ", edad=" + edad +
                        ", direccion='" + direccion + '\''
                ;
    }


}
