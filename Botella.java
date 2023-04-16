        
        
public class Botella extends Elemento {
    private static final Integer PESO_PROPIO = 4;
    private Elemento contenido;

    public Botella() {
        setPeso(PESO_PROPIO);
        generarNombre();
        setTipo(TipoElemento.RECIPIENTE);
    }    

    /**
     * Llena la botella con el liquido indicado agregando el peso del
     * nuevo liquido. Genera el nuevo nombre de la botella y actualiza
     * el peso.
     * 
     * Solo puede rellenarse cuando esta vacia. Si tiene contenido,
     * debe imprimir el mensaje:
     *    "<botella>: Se encuentra llena"
     * siendo <botella> el texto provisto por toString().
     * 
     * Si el elemento no es del tipo "liquido", debe imprimir el mensaje:
     *    "<botella>: No admite <elemento>"
     * siendo <botella> el texto provisto por toString() y <elemento> la
     * descripcion del elemento entregado (toString()).
     * 
     * @param liquido El liquido para rellenar la botella
     */
    public void llenarBotella (Elemento liquido) {
        // TODO - Implementar metodo
        if(isVacia()) {
            if( liquido.getTipo().equals(TipoElemento.LIQUIDO) ){
                setContenido( liquido );    
                generarNombre();
                setPeso( getPeso() + liquido.getPeso() );
            } else {
                System.out.println( toString() + ": No admite"+ liquido.toString() );
            }
        } else {
            System.out.println( toString() + " se encuentra llena" );
        }
        
    }

    /**
     * Vacia el contenido de la botella y actualiza el peso.
     * La botella queda lista para recargar.
     * Genera el nuevo nombre de la botella.
     * 
     * @return El contenido de la botella.
     */
    public Elemento vaciarBotella () {
        // TODO - Implementar metodo
        Elemento aux = null;
        if(getContenido()!=null){
            aux = getContenido();
            setContenido(null);
            setPeso(PESO_PROPIO);
            generarNombre();
        }
        return aux;
    }

    /**
     * Establece la descripcion de la botella con su contenido
     * correspondiente, por ej. "Botella con Agua".
     * En caso de que no tenga contenido, utiliza el texto
     * "Botella vacia"
     */
    public void generarNombre () {
        // TODO - Implementar metodo
        if(getContenido()!=null){
            System.out.println("Botella con "+getContenido().getNombre());
        } else {
            System.out.println("Botella vacía");
        }
    }

    /**
     * Devuelve verdadero en caso de contener algun tipo de pocima
     * y falso si esta vacia o contiene otro tipo de liquido.
     * 
     * @return true en caso de contener algun tipo de pocima.
     */
    public Boolean hasPocima () {
        // TODO - Implementar metodo
        return contenido instanceof Pocima;
    }

    /**
     * Devuelve verdadero en caso de contener agua
     * y falso si esta vacia o contiene otro tipo de liquido.
     * 
     * @return true en caso de contener agua
     */
    public Boolean hasAgua () {
        // TODO - Implementar metodo
        if(contenido != null && contenido.getNombre().startsWith("Agua")){
            return true;
        }
        return false;
    }
  
    /**
     * Devuelve verdadero en caso de contener vino
     * y falso si esta vacia o contiene otro tipo de liquido.
     * 
     * @return true en caso de contener vino
     */
    public Boolean hasVino () {
        // TODO - Implementar metodo
        if(contenido != null && contenido instanceof Vino){
            return true;
        }
        return false;
    }
  
    /**
     * Devuelve verdadero o falso segun tenga o no contenido.
     * 
     * @return true en caso de estar vacia
     */
    public Boolean isVacia () { 
        return contenido == null;
    }

    public Elemento getContenido() {
        return contenido;
    }

    public void setContenido(Elemento contenido) {
        this.contenido = contenido;
    }

}