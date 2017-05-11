package mynotepad.app.tecsup.com.mynotepad.models;

import com.orm.dsl.Table;

/**
 * Created by JShanksX13 on 2/05/2017.
 */

@Table
public class Note {

    private Long id;
    private String title;
    private String fecha;
    private String descripcion;

    public Note() {

    }

    public Note(String title, String fecha, String descripcion) {
        this.title = title;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", fecha='" + fecha + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}

