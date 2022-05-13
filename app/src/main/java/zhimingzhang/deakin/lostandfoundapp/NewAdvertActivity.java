package zhimingzhang.deakin.lostandfoundapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Objects;

public class NewAdvertActivity extends AppCompatActivity {
    EditText name,phone,description,date,location;
    RadioButton found,lost;

    Button save;
    DatabaseHelper dbHelper;
    public void makeMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
    String type;

    public void addData(String name,String type,String date,String phone,String description,String location){
        boolean insertData= dbHelper.insertData(name,type,date,phone,description,location);
        if(insertData){
            makeMessage("Successful entry!!");
        }
        else{
            makeMessage("Unsuccessful entry!!");
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_advert);
        name=findViewById(R.id.name);
        date=findViewById(R.id.date);
        phone=findViewById(R.id.phone);
        description=findViewById(R.id.description);
        location=findViewById(R.id.location);


        found=findViewById(R.id.found);
        lost=findViewById(R.id.lost);

        save=findViewById(R.id.Save);

        dbHelper=new DatabaseHelper(this);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Objects.equals(name.length(), 0)) {
                    name.setText("");

                }
                if(Objects.equals(date.length(), 0)) {
                    date.setText("");

                }
                if(Objects.equals(phone.length(), 0)) {
                    phone.setText("");

                }
                if(Objects.equals(description.length(), 0)) {
                    description.setText("");

                }
                if(Objects.equals(location.length(), 0)) {
                    location.setText("");

                }
                if(found.isChecked()){
                    type="Found";

                }
                else{
                    type="Lost";
                }
                addData(name.getText().toString(),type,date.getText().toString(),phone.getText().toString(),description.getText().toString(),location.getText().toString());
            }
        });
    }
}