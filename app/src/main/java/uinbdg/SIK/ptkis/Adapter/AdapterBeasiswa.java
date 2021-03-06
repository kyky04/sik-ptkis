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
import uinbdg.SIK.ptkis.Model.Response.DataItemBeasiswa;
import uinbdg.SIK.ptkis.R;

/**
 * Created by Comp on 2/11/2018.
 */

public class AdapterBeasiswa extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<DataItemBeasiswa> listUniv;



    private OnLoadMoreListener onLoadMoreListener;

    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public AdapterBeasiswa(Context ctx) {
        this.ctx = ctx;
    }

    public AdapterBeasiswa(Context ctx, List<DataItemBeasiswa> itemUniversitas) {
        this.listUniv = itemUniversitas;
        this.ctx = ctx;
    }


    public class OriginalViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_kategori)
        TextView tvKategori;
        @BindView(R.id.tv_judul)
        TextView tvAlamat;
        @BindView(R.id.tv_desc)
        TextView tvNoTelp;
        @BindView(R.id.lay)
        LinearLayout lay;
        @BindView(R.id.tv_rank)
        TextView tvRank;

        public OriginalViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);

        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_beasiswa, parent, false);
        vh = new OriginalViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof OriginalViewHolder) {
            OriginalViewHolder view = (OriginalViewHolder) holder;
            view.tvKategori.setText(listUniv.get(position).getMahasiswa().getNama());
            view.tvAlamat.setText(listUniv.get(position).getMahasiswa().getAlamat());
            view.tvNoTelp.setText(listUniv.get(position).getMahasiswa().getNo_telp());
            view.tvRank.setText(String.valueOf("RANK : "+listUniv.get(position).getVectorV()));
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
