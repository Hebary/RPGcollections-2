import java.util.TreeMap;

/**
 * Clase Habitacion - Una habitacion en un juego de aventuras
 *
 * Esta clase es parte de la apliciacion "World of Zuul". 
 * "World of Zuul" es un juego de aventuras sencillo basado en texto.  
 *
 * Un objeto "Habitacion" representa una ubicacion en el juego. Las
 * habitaciones tienen salidas que conducen a otras habitaciones, indicadas
 * como norte, sur, este y oeste. Para cada direccion, una habitacion 
 * mantiene una referencia a la habitacion vecina, o null si no existe una
 * en es direccion.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */

public class Habitacion 
{
    private String descripcion;
    // almacena las salidas de esta habitacion
    protected TreeMap<Salida, Habitacion> salidas;
    // almacena los elementos de la habitacion
    protected TreeMap<String, Elemento> elementos;
    
/* *** Modificacion para el TP **************************** */
/* Informatica Avanzada - 2021 */
    // Esta version utiliza la informacion del enumerado LugaresMapa
    protected LugaresMapa lugar;
    
    /**
     * Crea una habitacion descrita por "descripcion". 
     * Inicialmente, la habitacion no tiene salidas, "descripcion"
     * es algo asi como "una cocina" o "un patio".
     * 
     * Se incorpora el String nombre y el TreeMap de elementos para
     * adaptarlo al TP de Informatica Avanzada.
     * 
     * @param nombre El nombre de la habitacion
     * @param descripcion La descripcion de la habitacion.
     */
    public Habitacion (LugaresMapa lugar) {
        // TODO - Modificar metodo
        this.lugar = lugar;
        descripcion = lugar.getDescripcion();
        salidas = new TreeMap<>();
        elementos = new TreeMap<>();
        
    }

    /**
     * Devuelve el nombre de la habitacion.
     * 
     * @return El nombre de la habitacion.
     */
    public String getNombre () {
        // TODO - Implementar metodo
        return lugar.getNombre();
    }

    /**
     * @return La descripcion corta de esta habitacion
     * (la que se definio en el constructor).
     */
    public String getDescripcionCorta(){
        // TODO - Implementar metodo
        return descripcion;
    }

    /**
     * Devuelve una descripcion de la habitacion en la forma:
     * 
     *     Usted esta en la cocina
     *     Salidas: norte oeste
     *     Elementos: Pan Pluma Flecha
     * 
     * MODIFICAR el metodo para que la descripcion incluya la
     * lista de elementos:
     * 
     * @return Una descripcion larga de esta habitacion
     */
    public String getDescripcionLarga(){
        // TODO - Modificar metodo
        return "Usted esta en  " + lugar.getNombre() + ".\n"+ "Salidas: " + getStringDeSalidas() + ".\n" + getStringDeElementos();        
    }

    /**
     * Agrega un elemento a la habitacion.
     * 
     * Si el elemento es de tipo liquido, no se agrega al mapa
     * y se debe imprimir:
     *     "<nombre>: se acaba de derramar en el piso"
     * donde <nombre> es el nombre del liquido derramado.
     * 
     * @param elemento El elemento a agregar.
     */
    public void addElemento (Elemento elemento) {
        // TODO - Implementar metodo
        if(elemento.getTipo().equals(TipoElemento.LIQUIDO)){
            System.out.println(elemento.getNombre()+" se acaba de derramar en el piso");
        } else {
            elementos.put(elemento.getNombre(), elemento);
        }
        
    }

    /**
     * Quita el elemento de la habitacion.
     * 
     * Si el elemento es de tipo fijo (parte del escenario)
     * no debe quitarlo, devuelve null e imprime el mensaje:
     *     "<nombre>: No se puede tomar"
     * donde <nombre> es el elemento solicitado.
     * 
     * Si el elemento no existe, devuelve null e imprime el mensaje:
     *     "<nombre>: No existe"
     * donde <nombre> es el elemento solicitado.
     * 
     * @param nombre El nombre del elemento a tomar.
     * @return El elemento a tomar.
     */
    public Elemento getElemento (String nombre) {
        // TODO - Implementar metodo
            Elemento aux = null;
            if(elementos.containsKey(nombre)){   
                if(elementos.get(nombre).getTipo().equals(TipoElemento.FIJO)){
                    System.out.println(nombre +": No se puede tomar");
                    return aux;
                } else {
                aux = elementos.get(nombre);    
                elementos.remove(nombre);
                return aux;
            }
        } else {
            System.out.println(nombre+": No existe");
            return aux;
        }
    }
    /**
     * Devuelve una cadena describiendo los elementos de la habitacion,
     * por ejemplo:
     *    "Elementos: Pan Pluma Flecha".
     * En caso de no haber elementos, devuelve la cadena:
     *    "No hay elementos en este lugar"
     * 
     * @return Detalles de las salidas de la habitacion
     */
    protected String getStringDeElementos (){
        // TODO - Implementar metodo
        String stringElementos="";
        for(String e: elementos.keySet()){
            stringElementos+= e+" ";
        }
        return "Elementos: "+stringElementos;
    }

    /**
     * Devuelve la habitacion a la que se llega si vamos desde esta habitacion
     * en la direccion indicada. Si no hay habitaciones en esa direccion,
     * se devuelve a si misma e imprime el mensaje:
     *  
     *    "No hay salida en direccion <direccion>"
     * donde <direccion> es la direccion indicada.
     * 
     * @param direccion La direccion de salida
     * @return La habitacion en la direccion indicada
     */
    public Habitacion getSalida (Salida direccion) {
        // TODO - Modificar metodo
        if(salidas.containsKey(direccion)){
            return salidas.get(direccion);            
        }
        System.out.println("No hay salida en dirección "+ direccion);
        return this;
    }
    /**
     * Define las salidas de esta habitacion.
     * @param direccion La direccion de la salida
     * @param vecina  La habitacion a la cual esta salida conduce.
     */
    public void establecerSalida (Salida direccion, Habitacion vecina) {
        salidas.put(direccion, vecina);
    }

    /**
     * Devuelve una cadena describiendo las salidas de la habitacion,
     * por ejemplo
     * 
     * "Salidas: norte oeste".
     * 
     * @return Detalles de las salidas de la habitacion
     */
    private String getStringDeSalidas (){
        StringBuilder cadena = new StringBuilder("Salidas: ");
        for(Salida salida : salidas.keySet()) {
            cadena.append(salida.toString());
        }
        return cadena.toString();
    }

}

