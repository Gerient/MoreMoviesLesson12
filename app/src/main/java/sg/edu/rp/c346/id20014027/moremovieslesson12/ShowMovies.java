package sg.edu.rp.c346.id20014027.moremovieslesson12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.sql.Array;
import java.util.ArrayList;

public class ShowMovies extends AppCompatActivity {

    Button btnShowPG13;
    ListView lvMovies;
    CustomAdapter caMovies;
    ArrayList<Movie> filteredList;
    ArrayList<Movie> pg13List;
    Boolean state = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_movies);

        btnShowPG13 = findViewById(R.id.btnPg13);
        lvMovies = findViewById(R.id.lvMovies);
        filteredList = new ArrayList<Movie>();
        pg13List = new ArrayList<Movie>();
        caMovies = new CustomAdapter(this, R.layout.row, filteredList);
        lvMovies.setAdapter(caMovies);

        DBHelper dbh = new DBHelper(ShowMovies.this);
        pg13List.clear();
        pg13List.addAll(dbh.getAllMovies());
        filteredList.addAll(dbh.getAllMovies());
        caMovies.notifyDataSetChanged();

        lvMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long identity) {
                Movie data = filteredList.get(pos);
                Intent i = new Intent(ShowMovies.this,
                        ModifyMovies.class);
                i.putExtra("data", data);
                startActivity(i);
            }
        });

    }
}