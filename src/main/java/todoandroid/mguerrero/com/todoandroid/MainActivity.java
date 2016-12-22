package todoandroid.mguerrero.com.todoandroid;


import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity  {

    Button btnSave;
    ArrayList<String> addArray = new ArrayList<String>();
    EditText txtInput;
    ListView listView;

    Button btnNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_edit);

        Intent intent = getIntent();


        txtInput = (EditText)findViewById(R.id.txtInput);
        listView = (ListView)findViewById(R.id.listView);
        btnSave = (Button)findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = txtInput.getText().toString();

            if(addArray.contains(getInput)){
                Toast.makeText(getBaseContext(), "Item already added", Toast.LENGTH_LONG).show();
            }
            else if (getInput == null || getInput.trim().equals("")){
                Toast.makeText(getBaseContext(),"Input is empty", Toast.LENGTH_LONG).show();
            }
            else {
                addArray.add(getInput);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, addArray);
                listView.setAdapter(adapter);
                ((EditText)findViewById(R.id.txtInput)).setText(" ");
            }
            }
        });

        btnNext = (Button)findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                String getInput = txtInput.getText().toString();
                intent.putExtra("Text from first", getInput);

                startActivity(intent);

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }


}
