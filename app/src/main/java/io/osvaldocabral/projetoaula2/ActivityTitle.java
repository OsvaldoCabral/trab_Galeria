package io.osvaldocabral.projetoaula2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ActivityTitle extends AppCompatActivity {

    ImageView imageViewMain;
    TextView name_toy;
    TextView contador;

    int selectedImage = 0;
    String images[] = new String[]{
            "toy_jhon_snow",
            "toy_khal_drogo",
            "toy_night_king",
            "toy_rob_stark",
            "toy_tyrion",
            "toy_ygritte"
    };

    int allImages = images.length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        imageViewMain = findViewById(R.id.imageView);
        name_toy = findViewById(R.id.name_toy);
        contador = findViewById(R.id.contador);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            String aux = extras.getString("user_name");
            setTitle("Bem-vindo " + aux);
        }
    }

    public void changeImage() {
        // Set Image
        Drawable drawable = getResources().getDrawable(getResources().getIdentifier(images[selectedImage], "drawable", getPackageName()), this.getTheme());
        imageViewMain.setImageDrawable(drawable);

        // Set Name toy
        name_toy.setText(getNameCurrentToy());

        // Set counter
        contador.setText(getCurrentCount());
    }

    public String getNameCurrentToy() {
        String util_name_toy = images[selectedImage];
        util_name_toy = util_name_toy
                .replaceAll("toy_", "")
                .replaceAll("_", " ");

        List<String> nameToy = new ArrayList<>();
        for (String name : util_name_toy.split(" ")) {
            nameToy.add(name.substring(0, 1).toUpperCase() + name.substring(1));
        }

        return String.join(" ", nameToy);
    }

    public String getCurrentCount() {
        return (selectedImage+1) + "/" + allImages;
    }

    public void showNextImage(View view) {
        if(selectedImage == images.length -1) return;
        selectedImage++;
        changeImage();
    }

    public void showPrevImage(View view) {
        if(selectedImage == 0) return;
        selectedImage--;
        changeImage();
    }
}