package bichngan.ueh.edu.vn.form_btvn_buoi4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;

    private TextView age1, mage, male, female;
    private ProgressBar prbar;
    private SeekBar age;

    private EditText name, phone;
    private Switch gender;
    private CheckBox sport;
    private RadioButton rock, pop, rap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.level);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.levels_array, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        age1=this.findViewById(R.id.age1);
        prbar=this.findViewById(R.id.progress);
        age=this.findViewById(R.id.age);
        age.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                prbar.setProgress(progress);
                age1.setText(""+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        mage = findViewById(R.id.age1);
        male = findViewById(R.id.txt_male);
        female = findViewById(R.id.txt_female);
        gender = findViewById(R.id.gender);
        sport = findViewById(R.id.sport);
        rock = findViewById(R.id.rock);
        pop = findViewById(R.id.pop);
        rap = findViewById(R.id.rap);

        Button register = findViewById(R.id.btnregister);
        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowInformationActivity.class);
                String rname = name.getText().toString();
                intent.putExtra("NAME", rname);

                String rphone = phone.getText().toString();
                intent.putExtra("PHONE", rphone);

                String rage = mage.getText().toString();
                intent.putExtra("AGE", rage);

                String rgender;
                if(gender.isChecked()){
                    rgender = male.getText().toString();
                }else {
                    rgender = female.getText().toString();
                }
                intent.putExtra("GENDER", rgender);

                String rlevel = spinner.getSelectedItem().toString();
                intent.putExtra("LEVEL", rlevel);

                String rsport;
                if(sport.isChecked()){
                    rsport = "Có";
                }else {
                    rsport = "Không";
                }
                intent.putExtra("SPORT", rsport);

                String rmusic = "Không";
                if(rock.isChecked()){
                    rmusic = "Rock";
                }else if(pop.isChecked()){
                    rmusic = "Pop";
                }else if(rap.isChecked()){
                    rmusic = "Rap";
                }
                intent.putExtra("MUSIC", rmusic);

                startActivity(intent);
            }
        });

        Button cancel = findViewById(R.id.btncancel);
        cancel.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                name.setText("");
                phone.setText("");
                age.setProgress(1);
                age1.setText("1");
                gender.setChecked(false);
                spinner.setSelection(0);
                sport.setChecked(false);
                rock.setChecked(false);
                pop.setChecked(false);
                rap.setChecked(false);
            }
        });
    }
}