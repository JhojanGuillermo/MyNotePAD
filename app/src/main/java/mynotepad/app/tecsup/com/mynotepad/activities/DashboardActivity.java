package mynotepad.app.tecsup.com.mynotepad.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import mynotepad.app.tecsup.com.mynotepad.R;
import mynotepad.app.tecsup.com.mynotepad.adapters.NoteAdapter;
import mynotepad.app.tecsup.com.mynotepad.models.Note;
import mynotepad.app.tecsup.com.mynotepad.repositories.NoteRepository;

public class DashboardActivity extends AppCompatActivity {

    private static final String TAG = DashboardActivity.class.getSimpleName();
    private static final int REGISTER_FORM_REQUEST = 100;
    private SharedPreferences sharedPreferences;
    private RecyclerView notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //init SharedPreferences
        sharedPreferences = this.getSharedPreferences(MainActivity.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);

        //Configure RecyclerView
        notesList = (RecyclerView) findViewById(R.id.note_list);
        notesList.setLayoutManager(new LinearLayoutManager(this));

        // Set Data Adapter to RecyclerView
        List<Note> notes = NoteRepository.list();
        notesList.setAdapter(new NoteAdapter(notes));
    }

    public void callRegisterForm(View view) {
        startActivityForResult(new Intent(this, RegisterActivity.class), REGISTER_FORM_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // refresh data
        NoteAdapter adapter = (NoteAdapter) notesList.getAdapter();

        List<Note> notes = NoteRepository.list();
        adapter.setNotes(notes);
        adapter.notifyDataSetChanged();
    }

    public void callLogout(View view) {
        // remove from SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        boolean success = editor.putBoolean("islogged", false).commit();
//        boolean success = editor.clear().commit(); // not recommended

        finish();
    }
}
