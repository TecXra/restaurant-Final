package com.example.fasigujar.copyproject.Utils;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by Mian Mohsin on 10/9/2016.
 */
public class LruCacheImage extends LruCache<String,Bitmap> implements ImageLoader.ImageCache {


    public static int getDefaultLruCacheSize() {
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        final int cacheSize = maxMemory / 8;

        return cacheSize;
    }
    public LruCacheImage() {
        this(getDefaultLruCacheSize());
    }
    public LruCacheImage(int maxSize) {
        super(maxSize);
    }
    @Override
    protected int sizeOf(String key, Bitmap value) {
        return value.getRowBytes() * value.getHeight() / 1024;
    }


    @Override
    public Bitmap getBitmap(String url) {
        return get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        put(url, bitmap);
    }
}

