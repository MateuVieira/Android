package br.com.alura.example.aluraviagem.Util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class ImagemUtil {

    public static final String DRAWABLE = "drawable";

    public static Drawable getDrawableImage(String imagePath, Context contex) {
        Resources resources = contex.getResources();
        int idDoDrawable = resources.getIdentifier(imagePath,
                DRAWABLE,
                contex.getPackageName());
        return resources.getDrawable(idDoDrawable);
    }
}
