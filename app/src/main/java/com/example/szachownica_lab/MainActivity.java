package com.example.szachownica_lab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    private Panel chessPanelView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chessPanelView = findViewById(R.id.chess_panel_view);
        registerForContextMenu(chessPanelView);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        return handleMenuAction(item.getItemId()) || super.onOptionsItemSelected(item);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.main, menu);
        menu.setHeaderTitle("Opcje szachownicy");
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item){
        return handleMenuAction(item.getItemId()) || super.onContextItemSelected(item);
    }
    private boolean handleMenuAction(int id){
        if(id == R.id.menu_creator){
            View v = getLayoutInflater().inflate(R.layout.custom_toast, null);
            ((TextView)v.findViewById(R.id.toast_text)).setText("3 Td Bartosz Arcab");
            Toast t = new Toast(this);
            t.setView(v);
            t.setDuration(Toast.LENGTH_LONG);
            t.show();
            return true;
        } else if(id == R.id.menu_black_white){
            chessPanelView.setBlackWhiteColors();
            Toast.makeText(this, "Ustawiono czarno-białą szachownicę", Toast.LENGTH_SHORT).show();
            return true;
        } else if(id == R.id.menu_red_yellow){
            chessPanelView.setRedYellowColors();
            Toast.makeText(this, "Ustawiono czerwono-żółtą szachownicę", Toast.LENGTH_SHORT).show();
            return true;
        } else if(id == R.id.menu_exit){
            finish();
            return true;
        }
        return false;
    }
}
