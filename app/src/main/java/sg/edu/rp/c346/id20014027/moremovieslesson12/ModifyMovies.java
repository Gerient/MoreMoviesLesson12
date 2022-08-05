package sg.edu.rp.c346.id20014027.moremovieslesson12;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ModifyMovies extends AppCompatActivity {

    Button btnUpdate, btnDelete, btnCancel;
    EditText etId, etTitle, etGenre, etYear;
    Spinner spinRating;
    Movie data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_movies);

        etId = findViewById(R.id.editTextId);
        etTitle = findViewById(R.id.etTitle);
        etGenre = findViewById(R.id.editTextGenre);
        etYear = findViewById(R.id.editTextYear);
        spinRating = findViewById(R.id.spinnerRating);
        btnUpdate = findViewById(R.id.btnInsert);
        btnDelete = findViewById(R.id.buttonDelete);
        btnCancel = findViewById(R.id.buttonCancel);

        Intent i = getIntent();
        data = (Movie) i.getSerializableExtra("data");

        String id = String.valueOf(data.getId());

        etId.setText(id);
        etTitle.setText(data.getMovieTitle());
        etGenre.setText(data.getMovieGenre());
        etYear.setText(data.getMovieYear());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DBHelper dbh = new DBHelper(ModifyMovies.this);
                data.setMovieTitle(etTitle.getText().toString());
                data.setMovieGenre(etGenre.getText().toString());
                data.setMovieYear(Integer.parseInt(etYear.getText().toString()));
                data.setMovieRating(spinRating.getSelectedItem().toString());

                dbh.updateMovie(data);
                dbh.close();
                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(ModifyMovies.this);

                myBuilder.setTitle("Danger");
                myBuilder.setMessage("Are you sure you want to delete this movie " + etTitle.getText().toString());
                myBuilder.setCancelable(true);

                DBHelper dbh = new DBHelper(ModifyMovies.this);
                dbh.deleteMovie(data.getId());
                finish();

                myBuilder.setNegativeButton("DELETE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dbh.deleteMovie(data.getId());
                        Toast.makeText(ModifyMovies.this, "The movie " + etTitle.getText().toString() + " has been successfully deleted", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
                myBuilder.setPositiveButton("CANCEL", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}