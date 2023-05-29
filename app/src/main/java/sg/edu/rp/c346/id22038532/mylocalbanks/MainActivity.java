package sg.edu.rp.c346.id22038532.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS, tvOCBC, tvUOB;

    String wordClicked = "";


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }

    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the Bank");
        menu.add(0, 2, 2, "Toggle Favourite");
        menu.add(0, 3, 3, "Toggle Unfavourite");

        if (v == tvDBS) {
            wordClicked = "DBS";
        } else if (v == tvOCBC) {
            wordClicked = "OCBC";
        } else if (v == tvUOB) {
            wordClicked = "UOB";
        }
    }

    public boolean onContextItemSelected(MenuItem item) {

        if (wordClicked.equalsIgnoreCase("dbs")) {
            if (item.getItemId() == 0) // check whether the selected menu item ID is 0
            {
                Intent intentWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.dbswebsite)));
                startActivity(intentWebsite);
            }
            else if (item.getItemId() == 1)
            {
                Intent intentCallDBS = new Intent(Intent.ACTION_DIAL, Uri.parse("tel" + getResources().getString(R.string.dbsnum)));
                startActivity(intentCallDBS);
            }
            else if(item.getItemId() == 2)
            {
                tvDBS.setTextColor(Color.RED);
            }
            else if(item.getItemId() == 3)
            {
                tvDBS.setTextColor(Color.BLACK);
            }
        }

        if (wordClicked.equalsIgnoreCase("ocbc")) {
            if (item.getItemId() == 0) // check whether the selected menu item ID is 0
            {
                Intent intentWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ocbcwebsite)));
                startActivity(intentWebsite);
            }
            else if (item.getItemId() == 1)
            {
                Intent intentCallDBS = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 180036 + 33333));
                startActivity(intentCallDBS);
            }
            else if(item.getItemId() == 2)
            {
                tvOCBC.setTextColor(Color.RED);
            }
            else if(item.getItemId() == 3)
            {
                tvOCBC.setTextColor(Color.BLACK);
            }
        }

        if (wordClicked.equalsIgnoreCase("uob")) {
            if (item.getItemId() == 0) // check whether the selected menu item ID is 0
            {
                Intent intentWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.uobwebsite)));
                startActivity(intentWebsite);
            }
            else if (item.getItemId() == 1)
            {
                Intent intentCallDBS = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 180022 + 22121));
                startActivity(intentCallDBS);
            }
            else if(item.getItemId() == 2)
            {
                tvUOB.setTextColor(Color.RED);
            }
            else if(item.getItemId() == 3)
            {
                tvUOB.setTextColor(Color.BLACK);
            }
        }


        return super.onContextItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if(id == R.id.EnglishSelection)
        {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        }
        else if (id == R.id.ChineseSelection)
        {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
            return true;
        }
        else
        {
            tvDBS.setText("Error translation");
            tvOCBC.setText("Error translation");
            tvUOB.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }
}


