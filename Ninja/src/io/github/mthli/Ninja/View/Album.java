package io.github.mthli.Ninja.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import io.github.mthli.Ninja.Browser.BrowserController;
import io.github.mthli.Ninja.R;

public class Album {
    private static final int ALPHA_255 = 255;
    private static final int ALPHA_153 = 153;

    private Context context;

    private View albumView;
    public View getAlbumView() {
        return albumView;
    }

    private ImageView albumCover;
    public void setAlbumCover(Bitmap bitmap) {
        albumCover.setImageBitmap(bitmap);
    }

    private TextView albumTitle;
    public void setAlbumTitle(String title) {
        albumTitle.setText(title);
    }

    private BrowserController browserController;
    public void setBrowserController(BrowserController browserController) {
        this.browserController = browserController;
    }

    public Album(Context context, BrowserController browserController) {
        this.context = context;
        this.browserController = browserController;
        initUI();
    }

    private void initUI() {
        albumView = LayoutInflater.from(context).inflate(R.layout.album, null, false);
        albumView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO
            }
        });
        albumView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(context, albumTitle.getText().toString(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        albumCover = (ImageView) albumView.findViewById(R.id.album_cover);
        albumCover.setImageAlpha(ALPHA_255);

        albumTitle = (TextView) albumView.findViewById(R.id.album_title);
        albumTitle.setText(context.getString(R.string.album_untitled));
    }

    public void activate() {
        albumView.setBackgroundResource(R.drawable.round_corner_shape_blue);
    }

    public void deactivate() {
        albumView.setBackgroundResource(R.drawable.round_corner_shape_dark);
    }
}