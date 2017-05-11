package mynotepad.app.tecsup.com.mynotepad.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import mynotepad.app.tecsup.com.mynotepad.R;
import mynotepad.app.tecsup.com.mynotepad.models.Note;

/**
 * Created by JShanksX13 on 2/05/2017.
 */

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
    private List<Note> notes;

    public NoteAdapter(List<Note> notes) {
        this.notes = notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nota, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NoteAdapter.ViewHolder viewHolder, int position) {
        Note note = this.notes.get(position);
        viewHolder.title.setText(note.getTitle());
        viewHolder.fecha.setText(note.getFecha());
        viewHolder.descripcion.setText(note.getDescripcion());
    }

    @Override
    public int getItemCount() {
        return this.notes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView fecha;
        public TextView descripcion;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title_text);
            fecha = (TextView) itemView.findViewById(R.id.fecha_text);
            descripcion = (TextView) itemView.findViewById(R.id.descripcion_text);
        }
    }
}
