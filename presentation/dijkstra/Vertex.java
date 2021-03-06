package presentation.dijkstra;

/**
 * Created with IntelliJ IDEA.
 * User: luissousa
 * Date: 29/08/13
 * Time: 22:51
 * To change this template use File | Settings | File Templates.
 */
public class Vertex {
    final private String id;
    final private String name;
    final public int x;
    final public int y;


    public Vertex(String id, String name, int x, int y) {
        this.id = id;
        this.name = name;
        this.x=x;
        this.y=y;
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertex other = (Vertex) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return name;
    }

}
