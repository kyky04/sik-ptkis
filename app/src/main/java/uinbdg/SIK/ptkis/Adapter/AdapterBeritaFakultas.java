package uinbdg.SIK.ptkis.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import uinbdg.SIK.ptkis.Model.Response.DataItemBeritaFakultas;
import uinbdg.SIK.ptkis.R;

/**
 * Created by Comp on 2/11/2018.
 */

public class AdapterBeritaFakultas extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<DataItemBeritaFakultas> listUniv;


    private OnLoadMoreListener onLoadMoreListener;

    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public AdapterBeritaFakultas(Context ctx) {
        this.ctx = ctx;
    }

    public AdapterBeritaFakultas(Context ctx, List<DataItemBeritaFakultas> itemUniversitas) {
        this.listUniv = itemUniversitas;
        this.ctx = ctx;
    }


    public class OriginalViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_kategori)
        TextView tvKategori;
        @BindView(R.id.tv_judul)
        TextView tvJudul;
        @BindView(R.id.tv_desc)
        TextView tvDesc;
        @BindView(R.id.lay)
        LinearLayout lay;

        public OriginalViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);

        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_berita_universitas, parent, false);
        vh = new OriginalViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof OriginalViewHolder) {
            OriginalViewHolder view = (OriginalViewHolder) holder;
            view.tvKategori.setText(listUniv.get(position).getKategori());
            view.tvJudul.setText(listUniv.get(position).getJudul());
            view.tvDesc.setText(listUniv.get(position).getDesc());
//            view.lay.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    mOnItemClickListener.onItemClick(position);
//                }
//            });
        }
    }

    @Override
    public int getItemCount() {
        return listUniv.size();
    }

    @Override
    public long getItemId(int position) {
        return listUniv.get(position).getId();
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
    }

    public interface OnLoadMoreListener {
        void onLoadMore(int current_page);
    }

}
