import javax.swing.ImageIcon;

public class Ingrediente {
    //ingredients class
    private String ingrediente;
    private int id;
    private ImageIcon imagen;
    private int posicion;
            
    //constructores
    public Ingrediente() {
    }

    public Ingrediente(String ingrediente, int id, ImageIcon imagen) {
        this.ingrediente = ingrediente;
        this.id = id;
        this.imagen = imagen;
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

    public ImageIcon getImagen() {
        return imagen;
    }

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
     
}
