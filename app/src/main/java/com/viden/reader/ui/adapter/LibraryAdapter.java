package com.viden.reader.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.viden.reader.data.models.Manga;
import com.viden.reader.databinding.ItemLibraryBinding;

import java.util.List;


/**
 * @ProjectName: Manga
 * @Package: com.viden.reader.ui.adapter
 * @ClassName: LibraryAdapter
 * @Description: java类作用描述
 * @Author: Viden
 * @CreateDate: 2021/8/28 17:48
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/8/28 17:48
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class LibraryAdapter extends ArrayAdapter<Manga> {
    private final Context mContext;
    private final int mResourceId;
    private final List<Manga> mDataList;

    public LibraryAdapter(@NonNull Context context, @LayoutRes int resourceId, @NonNull List<Manga> dataList) {
        super(context, resourceId, dataList);
        mContext = context;
        mResourceId = resourceId;
        mDataList = dataList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
        MangaHolder holder;
        if (itemView == null) {
            LayoutInflater layoutInflater = ((Activity) mContext).getLayoutInflater();
            itemView = ItemLibraryBinding.inflate(layoutInflater,parent,false).getRoot();
            holder = new MangaHolder(itemView);
            itemView.setTag(holder);
        } else {
            holder = (MangaHolder) itemView.getTag();
        }
        Manga mangaItem = mDataList.get(position);
        holder.mTvName.setText(mangaItem.title);
        Glide.with(getContext())
                .load(getImageUrl(position))
                .centerCrop()
                .into(holder.mThumbnail);
        return itemView;
    }

    public void setData(List<Manga> mangaList) {
        // Avoid calling dataSetChanged twice
        mDataList.clear();
        addAll(mangaList);
    }

    private String getImageUrl(int position) {
        switch (position % 4) {
            case 0:
                return "https://imgpic.idmzj.com/img/webpic/3/1117201831604035860.jpg";
            case 1:
                return "https://imgpic.idmzj.com/img/webpic/11/1147788311694445490.jpg";
            case 2:
                return "https://images.dmzj.com/webpic/4/qingyejun0516.jpg";
            case 3:
                return "https://images.dmzj.com/webpic/1/onepunchmanfengmianl.jpg";
        }
        return "http://img1.wikia.nocookie.net/__cb20090524204255/starwars/images/thumb/1/1a/R2d2.jpg/400px-R2d2.jpg";

    }

    static class MangaHolder {
        ImageView mThumbnail;

        TextView mTvName;

        public MangaHolder(View view) {
            ItemLibraryBinding binding = ItemLibraryBinding.bind(view);
            mThumbnail = binding.ivThumbnail;
            mTvName = binding.tvName;
        }
    }
}
