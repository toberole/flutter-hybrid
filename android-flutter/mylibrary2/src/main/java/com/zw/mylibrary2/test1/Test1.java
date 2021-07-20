package com.zw.mylibrary2.test1;

import android.util.LruCache;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class Test1 {
    public void test1() {
        LruCache<String, String> lruCache = new LruCache(100) {
            @Override
            protected int sizeOf(Object key, Object value) {
                return super.sizeOf(key, value);
            }

            @Override
            public void trimToSize(int maxSize) {
                super.trimToSize(maxSize);
            }
        };

        lruCache.put("", "");
    }

    public void test2() {
        // https://www.jianshu.com/p/f592f3715ae2
        RecyclerView recyclerView = null;
        recyclerView.setAdapter(new MyAdapter());

        ListView listView = null;
        listView.setAdapter(null);
        

    }

    private class MyAdapter extends RecyclerView.Adapter<VH> {

        @NonNull
        @NotNull
        @Override
        public VH onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull @NotNull VH holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }

    private class VH extends RecyclerView.ViewHolder {

        public VH(@NonNull @NotNull View itemView) {
            super(itemView);
        }
    }
} 