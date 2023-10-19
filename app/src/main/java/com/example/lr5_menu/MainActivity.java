package com.example.lr5_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

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
}