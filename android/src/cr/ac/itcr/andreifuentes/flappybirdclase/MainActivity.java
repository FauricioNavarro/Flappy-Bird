package cr.ac.itcr.andreifuentes.flappybirdclase;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private SharedPreferences sharedpreferences;
    private final String nombre ="android_references";
    private MediaPlayer song;
    private boolean song_state;
    private Button btn_song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_song = findViewById(R.id.song);
        song = new MediaPlayer();
        song = MediaPlayer.create(getApplicationContext(), R.raw.soundtrack);
        song.setLooping(true);
        song.start();
        btn_song.setBackgroundColor(getResources().getColor(R.color.color_button));
        song_state = true;
    }

    public void facil(View view){
        load_configuration(0.2f,0.8f,10);
        start_activity_laucher();
    }

    public void medio(View view){
        load_configuration(0.6f,0.6f,20);
        start_activity_laucher();
    }

    public void dificil(View view){
        load_configuration(1f,0.45f,30);
        start_activity_laucher();
    }

    public void setSound(View view) {
        if (song_state) {
            btn_song.setBackgroundColor(getResources().getColor(R.color.color_cielo));
            song.pause();
            song_state = false;
        } else {
            btn_song.setBackgroundColor(getResources().getColor(R.color.color_button));
            song.start();
            song_state = true;
        }
    }

    public void load_configuration(float gravity, float distancia_seleccionada, int elevar){
        sharedpreferences = getSharedPreferences(nombre, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putFloat("gravity", gravity);
        editor.putFloat("distancia_seleccionada", distancia_seleccionada);
        editor.putInt("elevar",elevar);
        editor.apply();
        editor.commit();
    }

    public void start_activity_laucher(){
        startActivity(new Intent(this,AndroidLauncher.class));
    }
}
