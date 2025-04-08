package com.godtv;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PlaylistExporter {

    private Context context;

    public PlaylistExporter(Context context) {
        this.context = context;
    }

    public void export() {
        String playlistContent = generatePlaylistContent();
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        String fileName = "playlist_" + timeStamp + ".m3u";
        File downloadDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(downloadDir, fileName);

        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(playlistContent.getBytes());
            Toast.makeText(context, "Playlist exported: " + file.getAbsolutePath(), Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Toast.makeText(context, "Error exporting playlist: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private String generatePlaylistContent() {
        // Sementara dummy data, nanti dihubungkan dengan auto update dari Bittv
        return "#EXTM3U\n"
                + "#EXTINF:-1 tvg-id=\"\" tvg-name=\"Channel 1\" tvg-logo=\"\" group-title=\"Group\",Channel 1\n"
                + "http://example.com/stream1\n"
                + "#EXTINF:-1 tvg-id=\"\" tvg-name=\"Channel 2\" tvg-logo=\"\" group-title=\"Group\",Channel 2\n"
                + "http://example.com/stream2\n";
    }
}