package com.godtv;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

public class AutoUpdater {

    private Context context;
    private Handler handler;
    private Runnable runnable;

    private static final int UPDATE_INTERVAL = 6 * 60 * 60 * 1000; // 6 jam

    public AutoUpdater(Context context) {
        this.context = context;
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                updatePlaylist();
                handler.postDelayed(this, UPDATE_INTERVAL);
            }
        };
    }

    public void start() {
        handler.post(runnable);
    }

    public void stop() {
        handler.removeCallbacks(runnable);
    }

    private void updatePlaylist() {
        // Placeholder update logic, nanti dihubungkan parsing dari Bittv
        Toast.makeText(context, "Auto updating playlist...", Toast.LENGTH_SHORT).show();
        PlaylistExporter exporter = new PlaylistExporter(context);
        exporter.export();
    }
}