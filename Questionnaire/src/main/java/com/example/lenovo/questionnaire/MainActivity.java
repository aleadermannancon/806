package com.example.lenovo.questionnaire;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     private Button Button01;
    private Button Button02;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("TAG","onCreate() is call");
      Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "什么都没有", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        Button01=(Button)findViewById(R.id.Button01);

        Button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this,"开始答题",Toast.LENGTH_SHORT).show();
                Intent Intent01= new Intent(MainActivity.this,QuestionFragmentActivity.class);

                startActivity(Intent01);
            }
        });

        Button02=(Button)findViewById(R.id.Button02);
        Button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this,"开始录题",Toast.LENGTH_SHORT).show();
                Intent Intent01= new Intent(MainActivity.this,AddQuestion.class);

                startActivity(Intent01);
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu);
        //	setIconEnable(menu,true);
       /* menu.add(Menu.NONE,1,1,"a").setIcon(android.R.drawable.ic_menu_delete);
       */


        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(MainActivity.this,
                    ""+Runtime.getRuntime().totalMemory()+" \n"
                            +Runtime.getRuntime().freeMemory()+"\n"
                            +Runtime.getRuntime().maxMemory() ,
                    Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
