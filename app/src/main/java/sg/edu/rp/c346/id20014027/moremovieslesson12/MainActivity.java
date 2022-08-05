package sg.edu.rp.c346.id20014027.moremovieslesson12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvTitle, tvGenre, tvYear, tvRating;
    EditText etTitle, etGenre, etYear;
    Button btnInsert, btnShowList;
    Spinner spnRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = findViewById(R.id.tvMovieTitle);
        tvGenre = findViewById(R.id.tvGenre);
        tvYear = findViewById(R.id.tvYear);
        tvRating = findViewById(R.id.tvRating);
        etTitle = findViewById(R.id.etMovieTitle);
        etGenre = findViewById(R.id.etGenre);
        etYear = findViewById(R.id.etYear);
        btnInsert = findViewById(R.id.btnInsert);
        btnShowList = findViewById(R.id.btnShowList);
        spnRating = findViewById(R.id.spnRating);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = etTitle.getText().toString();
                String genre = etGenre.getText().toString();
                int year = Integer.parseInt(etYear.getText().toString());
                String rating = spnRating.getSelectedItem().toString();

                DBHelper dbh = new DBHelper(MainActivity.this);
                long inserted_id = dbh.insertMovie(title, genre, year, rating);

                if(inserted_id != 1){
                    Toast.makeText(MainActivity.this, "Insert successful", Toast.LENGTH_LONG).show();
                }
                etTitle.setText("");
                etGenre.setText("");
                etYear.setText("");
                spnRating.setSelection(0);
                }
             });
                btnShowList.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(MainActivity.this, ShowMovies.class);
                        startActivity(i);
                    }
                });
    }
}