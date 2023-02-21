package bichngan.ueh.edu.vn.form_btvn_buoi4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowInformationActivity extends AppCompatActivity {

    private TextView rname, rphone, rage, rgender, rlevel, rsport, rmusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_information);

        rname = findViewById(R.id.txt_name);
        rphone = findViewById(R.id.txt_phone);
        rage = findViewById(R.id.txt_age);
        rgender = findViewById(R.id.txt_gender);
        rlevel = findViewById(R.id.txt_level);
        rsport = findViewById(R.id.txt_sport);
        rmusic = findViewById(R.id.txt_music);

        Intent intent = getIntent();

        String name = intent.getStringExtra("NAME");
        rname.setText(name);

        String phone = intent.getStringExtra("PHONE");
        rphone.setText(phone);

        String age = intent.getStringExtra("AGE");
        rage.setText(age);

        String gender = intent.getStringExtra("GENDER");
        rgender.setText(gender);

        String level = intent.getStringExtra("LEVEL");
        rlevel.setText(level);

        String sport = intent.getStringExtra("SPORT");
        rsport.setText(sport);

        String music = intent.getStringExtra("MUSIC");
        rmusic.setText(music);
    }
}