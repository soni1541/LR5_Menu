package com.example.lr5_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private SupportFragment supportFragment = new SupportFragment();
    private TestingFragment testingFragment = new TestingFragment();
    private NotificationFragment notificationFragment = new NotificationFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.support_btn:

                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragment1, supportFragment)
                                .commit();
                        return true;

                    case R.id.testing_btn:

                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragment1, testingFragment)
                                .commit();
                        return true;
                    case R.id.notification_btn:

                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragment1, notificationFragment)
                                .commit();
                        return true;

                }
                return false;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.support_btn);
    }

    public void onclick_support(View view){
        EditText fio = findViewById(R.id.editTextTextPersonName);
        fio.getText().clear();
        EditText email = findViewById(R.id.editTextTextPersonName2);
        email.getText().clear();
        Toast toast = Toast.makeText(getApplicationContext(), "Данные отправлены успешно", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onclick_test (View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.baseline_done_outline_24);
        String[] items = {"Огурец","Жёлудь","Апельсин","Смородина"};

        List<String> fruit_list = Arrays.asList(items);

        boolean[] checkItems = {false, false, false, false};

        builder.setMultiChoiceItems(items, checkItems, (dialog, which, isChecked) -> {
            checkItems[which] = isChecked;
            String currentItem = fruit_list.get(which);
            if(currentItem == "Апельсин")
            {
                Toast toast = Toast.makeText(getApplicationContext(), "Всё верно", Toast.LENGTH_SHORT);
                toast.show();
            }
            else
            {
                Toast toast = Toast.makeText(getApplicationContext(), currentItem +" - это не фрукт", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        builder.show();
        builder.create();

    }
}