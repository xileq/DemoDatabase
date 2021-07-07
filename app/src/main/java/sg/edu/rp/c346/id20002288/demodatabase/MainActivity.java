package sg.edu.rp.c346.id20002288.demodatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
Button btninsert,btngettask;
TextView tvresult;
ListView lv;
ArrayAdapter<Task> aa;
ArrayList<Task> al;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btninsert  =   findViewById(R.id.button);
        btngettask  =   findViewById(R.id.button2);
        tvresult  =   findViewById(R.id.tvresult);
        lv  =   findViewById(R.id.lv);

        al  =   new ArrayList<Task>();
        aa  =    new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,al);
        lv.setAdapter(aa);
        




        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db   =    new DBHelper(MainActivity.this);

                db.insertTask("submit rj" ,"25 april 2021");
            }
        });
        btngettask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh   =   new DBHelper(MainActivity.this);
                ArrayList<String> data   =    dbh.getTaskContent();

                String txt   =   "";
                for(int i   =    0; i<data.size();i++){
                    txt +=   i+ ". " + data.get(i) + "\n";

                }
                    tvresult.setText(txt);
                
                
                al   =    dbh.getTasks();
                aa.notifyDataSetChanged();


            }
        });


    }
}