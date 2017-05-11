package mynotepad.app.tecsup.com.mynotepad.repositories;

import com.orm.SugarRecord;

import java.util.List;

import mynotepad.app.tecsup.com.mynotepad.models.Note;

/**
 * Created by JShanksX13 on 2/05/2017.
 */

public class NoteRepository {
    public static List<Note> list() {
        List<Note> notes = SugarRecord.listAll(Note.class);
        return notes;
    }

    public static Note read(Long id) {
        Note note = SugarRecord.findById(Note.class, id);
        return note;
    }

    public static void create(String title, String fecha, String descripcion) {
        Note note = new Note(title, fecha, descripcion);
        SugarRecord.save(note);
    }

}
