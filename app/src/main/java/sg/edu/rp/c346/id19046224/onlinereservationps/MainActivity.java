package sg.edu.rp.c346.id19046224.onlinereservationps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    Button reset, confirm;
    CheckBox smokeBox;
    EditText phoneText, nameText, paxText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        reset = findViewById(R.id.btnReset);
        confirm = findViewById(R.id.btnConfirm);
        smokeBox = findViewById(R.id.checkBox);
        phoneText = findViewById(R.id.phoneText);
        nameText = findViewById(R.id.nameText);
        paxText = findViewById(R.id.paxText);

        dp.updateDate(2020, 05,01);
        tp.setCurrentHour(19);
        tp.setCurrentMinute(30);

        reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                smokeBox.setChecked(false);
                nameText.setText("");
                phoneText.setText("");
                paxText.setText("");

                dp.updateDate(2020, 05,01);
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);

            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(smokeBox.isChecked()){
                    String datemsg = dp.getDayOfMonth() + "/" + dp.getMonth() + "/" + dp.getYear();
                    String timemsg = tp.getCurrentHour() + ":" + tp.getCurrentMinute();

                    String textmsg = "Hi " + nameText.getText().toString()
                            + " your reservation has been booked for " +
                            datemsg + " at " + timemsg + " with " + paxText.getText().toString()
                            + " person(s). Includes smoking area." +
                            "We will call you at " + phoneText.getText().toString()
                            + " for any updates. Thank you!";
                    Toast.makeText(MainActivity.this, textmsg, Toast.LENGTH_LONG).show();

                }
                else{
                    String datemsg = dp.getDayOfMonth() + "/" + dp.getMonth() + "/" + dp.getYear();
                    String timemsg = tp.getCurrentHour() + ":" + tp.getCurrentMinute();

                    String textmsg = "Hi " + nameText.getText().toString()
                            + " your reservation has been booked for " +
                            datemsg + " at " + timemsg + " with " + paxText.getText().toString()
                            + " person(s). No smoking area. " +
                            "We will call you at " + phoneText.getText().toString()
                            + " for any updates. Thank you!";
                    Toast.makeText(MainActivity.this, textmsg, Toast.LENGTH_LONG).show();

                }

            }
        });

    }
}
