package cr.ac.itcr.andreifuentes.flappybirdclase;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

public class AndroidLauncher extends AndroidApplication {
	private SharedPreferences sharedpreferences;
	private final String nombre ="android_references";
	private float gravity;
	private  float distancia_seleccionada;
	private  int elevar;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		sharedpreferences = getSharedPreferences(nombre, MODE_PRIVATE);
		gravity = sharedpreferences.getFloat("gravity",0.5f);
		distancia_seleccionada = sharedpreferences.getFloat("distancia_seleccionada",0.8f);
		elevar = sharedpreferences.getInt("elevar",10);
		initialize(new FlappyBird(gravity,distancia_seleccionada,elevar), config);
	}
}
