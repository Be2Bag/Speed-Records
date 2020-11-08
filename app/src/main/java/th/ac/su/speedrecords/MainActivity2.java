package th.ac.su.speedrecords;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    db dbh;
    EditText editText_t,editText_s;
    Button button_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button nextButton2 = findViewById(R.id.button_save);
        nextButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity();
            }
        });

        editText_t = findViewById(R.id.editText_t);
        editText_s = findViewById(R.id.editText_s);

        button_save = findViewById(R.id.button_save);

        dbh = new db(this);

        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float m_t = Float.parseFloat(editText_t.toString());
                float m_s = Float.parseFloat(editText_s.toString());
                boolean A = dbh.addAllData(m_t,m_s);
            }
        });

    }

    public void openActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}