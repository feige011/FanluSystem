package com.sunnyweather.fsystem.activity.ui.notifications;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProjectListItemDecoration extends RecyclerView.ItemDecoration {

    private int space;

    public ProjectListItemDecoration(int space){
        this.space = space;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.bottom = space;

        if (parent.getChildLayoutPosition(view) == 0)
            outRect.top = space;
    }

    public static int px2dp(float dpValue) {

        return (int) (0.5f + dpValue * Resources.getSystem().getDisplayMetrics().density);

    }
}
