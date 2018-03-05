package uinbdg.skirpsi.futsal.Adapter;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import butterknife.ButterKnife;
import uinbdg.skirpsi.futsal.R;
import uinbdg.skirpsi.futsal.Util.Tools;
import uinbdg.skirpsi.futsal.Util.ViewAnimation;

/**
 * Created by Comp on 2/11/2018.
 */

public class AdapterRiwayatKlaim extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private OnLoadMoreListener onLoadMoreListener;

    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public AdapterRiwayatKlaim(Context ctx) {
        this.ctx = ctx;
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder {


        public OriginalViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);

        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_riwayat_klaim, parent, false);
        vh = new OriginalViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof OriginalViewHolder) {



            OriginalViewHolder view = (OriginalViewHolder) holder;
            view.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(position);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
    }

    public interface OnLoadMoreListener {
        void onLoadMore(int current_page);
    }


    private void toggleSectionText(View view, final LinearLayout lyt_expand_text, final NestedScrollView nested_scroll_view) {
        boolean show = toggleArrow(view);
        if (show) {
            ViewAnimation.expand(lyt_expand_text, new ViewAnimation.AnimListener() {
                @Override
                public void onFinish() {
                    Tools.nestedScrollTo(nested_scroll_view, lyt_expand_text);
                }
            });
        } else {
            ViewAnimation.collapse(lyt_expand_text);
        }
    }

//    private void toggleSectionInput(View view,final LinearLayout lyt_expand_text, final NestedScrollView nested_scroll_view) {
//        boolean show = toggleArrow(view);
//        if (show) {
//            ViewAnimation.expand(lyt_expand_input, new ViewAnimation.AnimListener() {
//                @Override
//                public void onFinish() {
//                    Tools.nestedScrollTo(nested_scroll_view, lyt_expand_input);
//                }
//            });
//        } else {
//            ViewAnimation.collapse(lyt_expand_input);
//        }
//    }

    public boolean toggleArrow(View view) {
        if (view.getRotation() == 0) {
            view.animate().setDuration(200).rotation(180);
            return true;
        } else {
            view.animate().setDuration(200).rotation(0);
            return false;
        }
    }

}
