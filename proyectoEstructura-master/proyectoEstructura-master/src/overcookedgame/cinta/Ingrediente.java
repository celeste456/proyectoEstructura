package overcookedgame.cinta;

public class Ingrediente {
    private String ingrediente;
    private int id;
    
    //constructores
    public Ingrediente() {
    }
    
    public Ingrediente(String ingrediente, int id) {
        this.ingrediente = ingrediente;
        this.id = id;
    }
    
    //setters and getters
    public String getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Ingrediente{" + "ingrediente=" + ingrediente + ", id=" + id + '}';
    }
    
}
