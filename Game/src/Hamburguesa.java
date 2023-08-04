


public class Hamburguesa {
    private int tiempoIngreso = 20000;
    private String hamburguesaTipo;
    private int puntaje;
    private String ingredientes;
    
    //constructores
    public Hamburguesa() {
    }

    public Hamburguesa(String hamburguesaTipo, int puntaje, String ingredientes) {
        this.hamburguesaTipo = hamburguesaTipo;
        this.puntaje = puntaje;
        this.ingredientes = ingredientes;
    }


    //getters ansd setters
    public int getTiempoIngreso() {
        return tiempoIngreso;
    }

    public void setTiempoIngreso(int tiempoIngreso) {
        this.tiempoIngreso = tiempoIngreso;
    }

    public String getHamburguesaTipo() {
        return hamburguesaTipo;
    }

    public void setHamburguesaTipo(String hamburguesaTipo) {
        this.hamburguesaTipo = hamburguesaTipo;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    
    @Override
    public String toString() {
        return "Preparar: " +  hamburguesaTipo + "\n" + "Ingredientes:" + ingredientes ;
    }
    
    
}
