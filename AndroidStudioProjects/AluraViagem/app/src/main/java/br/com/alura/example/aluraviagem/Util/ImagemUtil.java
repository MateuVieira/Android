package br.com.alura.example.aluraviagem.Util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import br.com.alura.example.aluraviagem.models.Pacote;

public class ImagemUtil {

    public static Drawable getDrawableImage(String imagePath, Context contex) {
        Resources resources = contex.getResources();
        int idDoDrawable = resources.getIdentifier(imagePath,
                "drawable",
                contex.getPackageName());
        return resources.getDrawable(idDoDrawable);
    }
}
