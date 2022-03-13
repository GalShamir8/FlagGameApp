package com.example.gameapp_rc1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textview.MaterialTextView;

public class Activity_game extends AppCompatActivity {
    private ImageView[] main_IMG_hearts;

    private ImageView main_IMG_flag;

    private Button main_BTN_yes;
    private Button main_BTN_no;

    private MaterialTextView main_LBL_countryName;
    private MaterialTextView main_LBL_score;

    private final GameManager gameManager = new GameManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setViews();
        updateUI();
        main_BTN_yes.setOnClickListener(e -> answered(true));
        main_BTN_no.setOnClickListener(e -> answered(false));
    }

    private int getImageResource(String name) {
        Resources resources = this.getResources();
        return resources.getIdentifier(name, "drawable",
                this.getPackageName());
    }

    private void updateCountryDisplay(){
        try{
            Country country = gameManager.getCurrentCountry();

            String resource_name = String.format("flag_%s", country.getName());
            main_IMG_flag.setImageResource(getImageResource(resource_name));

            main_LBL_countryName.setText(country.getName());
        }catch (Exception e){
            toastMessage(e.getMessage());
        }
    }

    private void next(){
        gameManager.addCurrentCountry();
        updateUI();
    }

    private void updateUI() {
        updateCountryDisplay();
        main_LBL_score.setText(String.valueOf(gameManager.getScore()));
    }

    private void answered(boolean answer){
        try {
            Country country = gameManager.getCurrentCountry();
            if (answer == country.isPeace()){
                gameManager.addScore();
            }else{
                gameManager.reduceLives();
            }
            next();
            for(int i = 0; i < main_IMG_hearts.length; i++){
                main_IMG_hearts[i].setVisibility(gameManager.getLives() > i ? View.VISIBLE: View.INVISIBLE);
            }
        }catch (Exception e){
            toastMessage(e.getMessage());
        }

    }

    private void toastMessage(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();
        finishGame();
    }

    private void finishGame(){
        finish();
    }

    private void setViews() {
        main_IMG_flag = findViewById(R.id.main_IMG_flag);
        main_BTN_yes = findViewById(R.id.main_BTN_yes);
        main_BTN_no = findViewById(R.id.main_BTN_no);
        main_LBL_countryName = findViewById(R.id.main_LBL_countryName);
        main_LBL_score = findViewById(R.id.main_LBL_score);
        main_IMG_hearts = new ImageView[]{
                findViewById(R.id.main_IMG_heart1),
                findViewById(R.id.main_IMG_heart2),
                findViewById(R.id.main_IMG_heart3)
        };
    }
}