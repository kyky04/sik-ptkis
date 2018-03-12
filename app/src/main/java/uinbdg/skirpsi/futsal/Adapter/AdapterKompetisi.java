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
import uinbdg.skirpsi.futsal.Model.DataItemKompetisi;
import uinbdg.skirpsi.futsal.R;

/**
 * Created by Comp on 2/11/2018.
 */

public class AdapterKompetisi extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<DataItemKompetisi> itemKompetisis;


    public AdapterKompetisi(Context ctx, List<DataItemKompetisi> itemKompetisis) {
        this.itemKompetisis = itemKompetisis;
        this.ctx = ctx;
    }

    private OnLoadMoreListener onLoadMoreListener;

    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, String obj, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public AdapterKompetisi(Context ctx) {
        this.ctx = ctx;
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_nama_kompetisi)
        TextView tvNamaKompetisi;
        @BindView(R.id.et_waktu)
        EditText etWaktu;
        @BindView(R.id.et_keterangan)
        EditText etKeterangan;
        public OriginalViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);

        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kompetisi, parent, false);
        vh = new OriginalViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof OriginalViewHolder) {
        ((OriginalViewHolder) holder).tvNamaKompetisi.setText(itemKompetisis.get(position).getNama());
        ((OriginalViewHolder) holder).etWaktu.setText(itemKompetisis.get(position).getWaktu());
        ((OriginalViewHolder) holder).etKeterangan.setText(itemKompetisis.get(position).getKeterangan());

        }
    }

    @Override
    public int getItemCount() {
        return itemKompetisis.size();
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
    }

    public interface OnLoadMoreListener {
        void onLoadMore(int current_page);
    }

}
