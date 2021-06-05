package com.nextasksolution.activities.loginActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.nextasksolution.R;
import com.nextasksolution.activities.homePageActivity.HomePageActivity;
import com.nextasksolution.databinding.ActivityLoginBinding;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.lang_spinner)
    Spinner langSpinner;

    @BindArray(R.array.lang_list)
    String[] langList;

    private ActivityLoginBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        binding = ActivityLoginBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//        langSpinner = binding.langSpinner;
//        langList = getResources().getStringArray(R.array.lang_list);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        setSpinner();
    }

    private void setSpinner() {
        LangSpinner adapter = new LangSpinner(LoginActivity.this,
                android.R.layout.simple_spinner_item, langList);

        adapter.setDropDownViewResource(R.layout.lang_item);
        langSpinner.setAdapter(adapter);
        langSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @OnClick(R.id.signInBt)
    void OnClickSignInBtn (){
        Intent openHomePageActivity = new Intent(this, HomePageActivity.class);
        startActivity(openHomePageActivity);
    }
}