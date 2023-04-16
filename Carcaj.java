import java.util.ArrayList;
import java.util.List;

/**
 * Modela el Carcaj que lleva el personaje para
 * tranportar sus flechas.
 */
public class Carcaj extends Elemento {
    private final Integer PESO_PROPIO = 10;
    private Integer capacidad;
    private List<Flecha> flechas;

    /**
     * Constructor para un Carcaj generico chico. Su capacidad
     * es de 5 flechas pero se inicializa vacio.
     * Recordar que es de tipo recipiente y tiene un peso inicial.
     */
    public Carcaj() {
        // TODO - Implementar metodo
        super.setNombre("Carcaj chico");
        super.setPeso(PESO_PROPIO);
        super.setTipo(TipoElemento.RECIPIENTE);
        capacidad = 5;
        flechas = new ArrayList<>();
    }

    /**
     * Constructor para un Carcaj de nombre y capacidad indicados
     * por parametro.  Se inicializa vacio.
     * Recordar que es de tipo recipiente y tiene un peso inicial.
     * 
     * @param nombre El nombre del carcaj.
     * @param capacidad Cantidad maxima de flechas.
     */
    public Carcaj(String nombre, Integer capacidad) {
        // TODO - Implementar metodo
        super(nombre, 10, TipoElemento.RECIPIENTE);
        flechas = new ArrayList<>();
        this.capacidad = capacidad;
    }

    /**
     * Agrega una flecha al carcaj.
     * 
     * Debe actualizarse el peso total.
     * 
     * Si no tiene capacidad disponible, debe imprimir
     *     "<nombre>: Capacidad completa"
     * donde <nombre> es el nombre del carcaj.
     * 
     * Si el elemento a agregar no es una flecha, debe imprimir:
     *     "<nombre>: No es una flecha"
     * donde <nombre> es el nombre del elemento entregado.
     * 
     * @param flecha La flecha a agregar.
     */
    public void addFlecha (Elemento flecha) {
        // TODO - Implementar metodo
        if( !getCapacidad().equals(getCantidadFlechas()) ){    
            if( flecha.getTipo().equals(TipoElemento.MUNICION) ){
                    flechas.add( (Flecha)flecha );
                    capacidad--;
                    addPeso( flecha.getPeso() );
                } else {
                    System.out.println(flecha.getNombre()+": No es una flecha");
                }
        } else {
            System.out.println(getNombre()+" Capacidad Completa");
        }
    }

    /**
     * Quita del carcaj una flecha.
     * 
     * Debe actualizarse el peso total.
     * 
     * Si no hay mas flechas, devuelve null y debe imprimir:
     *      "<nombre>: No quedan flechas"
     * donde <nombre> es el nombre del carcaj.
     * 
     * 
     * 
     * @return Una flecha.
     */
    public Flecha getFlecha () {
        // TODO - Implementar metodo
        Flecha flecha = null;
        if(flechas.size() > 0){
            flecha = flechas.get(0);
            flechas.remove(0);
            addPeso( -flecha.getPeso() );
            capacidad++;
        }   
        return flecha;
    }

    /**
     * Modifica el peso del carcaj.
     * Puede sumar o restar peso.
     * 
     * @param peso El peso a modificar.
     */
    public void addPeso (Integer peso) {
        // TODO - Implementar metodo
        super.setPeso(getPeso() +( peso ));
    }

    /**
     * Devuelve informacion sobre el carcaj de la forma:
     *     "<nombre>: Flechas <cant>/<max>"
     * donde <nombre> es el nombre del carcaj,
     * <cant> es la cantidad de flechas que contiene y
     * <max> la capacidad maxima.
     */
    @Override        
    public String toString() {
        // TODO - Implementar metodo
        return getNombre()+": Flechas" + getCantidadFlechas()+"/"+getCapacidad(); 
    }

    public Integer getCantidadFlechas () {
        return flechas.size();
    }

    public Integer getCapacidad () {
        return capacidad;
    }
    
}
