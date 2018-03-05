package uinbdg.skirpsi.futsal.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import uinbdg.skirpsi.futsal.Model.DataItem;
import uinbdg.skirpsi.futsal.Model.DataItemLapangan;
import uinbdg.skirpsi.futsal.R;

/**
 * Created by Comp on 2/11/2018.
 */

public class AdapterLapangan extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<DataItem> lapanganList;

    private OnLoadMoreListener onLoadMoreListener;

    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, String obj, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public AdapterLapangan(Context ctx) {
        this.ctx = ctx;
    }

    public AdapterLapangan(Context ctx, List<DataItem> lapanganResponses) {
        this.lapanganList = lapanganResponses;
        this.ctx = ctx;
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_nama_lapang)
        TextView tvNamaLapang;
        @BindView(R.id.et_alamat)
        EditText etAlamat;
        @BindView(R.id.et_phone)
        EditText etPhone;
        public OriginalViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);

        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lapangan, parent, false);
        vh = new OriginalViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        DataItem lapang = lapanganList.get(position);
        if (holder instanceof OriginalViewHolder) {
            ((OriginalViewHolder) holder).tvNamaLapang.setText(lapang.getNama());
        }
    }

    @Override
    public int getItemCount() {
        return lapanganList.size();
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
    }

    public interface OnLoadMoreListener {
        void onLoadMore(int current_page);
    }

}
