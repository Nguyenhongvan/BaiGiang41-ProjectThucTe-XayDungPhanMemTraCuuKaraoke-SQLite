package com.vansuzy.adapter;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.vansuzy.baigiang41_projectthucte_xaydungphanmemtracuukaraoke_sqlite.MainActivity;
import com.vansuzy.baigiang41_projectthucte_xaydungphanmemtracuukaraoke_sqlite.R;
import com.vansuzy.model.Music;

import java.util.List;

/**
 * Created by keeps on 6/2/2017.
 */

public class MusicAdapter extends ArrayAdapter<Music> {
    Activity context;
    int resource;
    List<Music> objects;

    public MusicAdapter(@NonNull Activity context, @LayoutRes int resource, @NonNull List<Music> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource,null);
        TextView txtMa = (TextView) row.findViewById(R.id.txtMa);
        TextView txtTen = (TextView) row.findViewById(R.id.txtTen);
        TextView txtCaSi = (TextView) row.findViewById(R.id.txtCaSi);
        ImageButton btnLike = (ImageButton) row.findViewById(R.id.btnLike);
        ImageButton btnDislike = (ImageButton) row.findViewById(R.id.btnDislike);

        final Music music = this.objects.get(position);
        txtMa.setText(music.getMa());
        txtTen.setText(music.getTen());
        txtCaSi.setText(music.getCaSi());
        if (music.isThich()) {
            btnLike.setVisibility(View.INVISIBLE);
            btnDislike.setVisibility(View.VISIBLE);
        } else {
            btnLike.setVisibility(View.VISIBLE);
            btnDislike.setVisibility(View.INVISIBLE);
        }

        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyThich(music);
            }
        });
        btnDislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyKhongThich(music);
            }
        });
        return row;
    }

    private void xuLyKhongThich(Music music) {
        ContentValues row = new ContentValues();
        row.put("YEUTHICH", 0);
        MainActivity.database.update("ArirangSongList", row, "MABH=?", new String[]{music.getMa()});
    }

    private void xuLyThich(Music music) {
        ContentValues row = new ContentValues();
        row.put("YEUTHICH", 1);
        MainActivity.database.update("ArirangSongList", row, "MABH=?", new String[]{music.getMa()});
    }
}
