package com.example.a10ngawang.top10downloader;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by 10ngawang on 2/15/2019.
 */

public class FeedAdapter extends ArrayAdapter {
    private static final String TAG = "FeedAdapter";
    private final int layoutResourse;
    private final LayoutInflater layoutInflater;
    private List<FeedEntry> application;

    public FeedAdapter(Context context, int resource, List<FeedEntry> application) {
        super(context, resource);
        this.application = application;
        this.layoutResourse = resource;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return application.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = layoutInflater.inflate(layoutResourse,parent,false);

        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        TextView tvArtist = (TextView) convertView.findViewById(R.id.tvArtist);
        TextView tvSummary = (TextView) convertView.findViewById(R.id.tvSummary);
        ImageView tvImage = (ImageView) convertView.findViewById(R.id.tvImage);

        FeedEntry currentApp = application.get(position);

        tvName.setText(currentApp.getName());
        tvArtist.setText(currentApp.getArtist());
        tvSummary.setText(currentApp.getSummary());
        Picasso.with(this.getContext()).load(currentApp.getImageURL()).into(tvImage);

        return convertView;
    }
}
