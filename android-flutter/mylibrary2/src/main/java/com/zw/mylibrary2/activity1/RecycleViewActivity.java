package com.zw.mylibrary2.activity1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.zw.mylibrary2.R;

import java.util.ArrayList;
import java.util.List;

/**
 * ViewHolder复用逻辑
 * <p>
 * 在 RecyclerView 中，并不是每次绘制表项，都会重新创建 ViewHolder 对象，也不是每次都会重新绑定 ViewHolder 数据。
 * RecyclerView 通过Recycler获得下一个待绘制表项。
 * Recycler有4个层次用于缓存 ViewHolder 对象，优先级从高到底依次为:
 * ArrayList<ViewHolder> mAttachedScrap、
 * ArrayList<ViewHolder> mCachedViews、
 * ViewCacheExtension mViewCacheExtension、
 * RecycledViewPool mRecyclerPool。
 * 如果四层缓存都未命中，则重新创建并绑定 ViewHolder 对象。
 * <p>
 * RecycledViewPool 对 ViewHolder 按viewType分类存储（通过SparseArray），同类 ViewHolder 存储在默认大小为5的ArrayList中。
 * <p>
 * 从mRecyclerPool中复用的 ViewHolder 需要重新绑定数据，从mAttachedScrap 中复用的 ViewHolder 不需要重新创建也不需要重新绑定数据。
 * 从mRecyclerPool中复用的ViewHolder ，只能复用于viewType相同的表项，从mCachedViews中复用的 ViewHolder ，只能复用于指定位置的表项。
 * mCachedViews是离屏缓存，用于缓存指定位置的 ViewHolder ，只有“列表回滚”这一种场景（刚滚出屏幕的表项再次进入屏幕），才有可能命中该缓存。该缓存存放在默认大小为 2 的ArrayList中。
 */
public class RecycleViewActivity extends AppCompatActivity {
    public static final String TAG = RecycleViewActivity.class.getSimpleName() + "-xxx";

    private List<Integer> list = new ArrayList<>();

    private RecyclerView recycleview;
    private MyViewCacheExtension myViewCacheExtension;
    private RecyclerView.RecycledViewPool recycledViewPool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        ListView listView = new ListView(this);
        listView.setAdapter(null);

        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        recycleview = findViewById(R.id.recycleview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleview.setLayoutManager(linearLayoutManager);
        recycledViewPool = new RecyclerView.RecycledViewPool();
        recycleview.setRecycledViewPool(recycledViewPool);
        myViewCacheExtension = new MyViewCacheExtension();
        recycleview.setViewCacheExtension(myViewCacheExtension);
        recycleview.setAdapter(new MyAdapter());
    }

    private class MyViewCacheExtension extends RecyclerView.ViewCacheExtension {
        @Nullable
        @Override
        public View getViewForPositionAndType(@NonNull RecyclerView.Recycler recycler, int position, int type) {
            Log.i(TAG, "getViewForPositionAndType ......");
            return null;
        }
    }

    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        @Override
        public int getItemCount() {
            return list.size();
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(RecycleViewActivity.this).inflate(R.layout.item_layout, parent, false);
            ViewHolder viewHolder = new ViewHolder(v);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.tv.setText(list.get(position) + "");
        }

        private class ViewHolder extends RecyclerView.ViewHolder {
            private TextView tv;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                tv = itemView.findViewById(R.id.tv);
            }
        }
    }
}