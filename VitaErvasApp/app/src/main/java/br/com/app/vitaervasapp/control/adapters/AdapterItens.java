package br.com.app.vitaervasapp.control.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.app.vitaervasapp.R;
import br.com.app.vitaervasapp.model.Produto;

/**
 * Created by marcos on 13/01/18.
 */

public class AdapterItens extends RecyclerView.Adapter<AdapterItens.ViewHolder> {

    private List<Produto> produtos;

    public AdapterItens(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v = inflater.inflate(R.layout.itens_adapter, parent, false);
        AdapterItens.ViewHolder vh = new AdapterItens.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Produto produto = produtos.get(position);

        holder.ivItem.setImageResource(produto.getImg());
        holder.tvNomeItem.setText(produto.getNome());
        holder.tvPrecoItem.setText(produto.getDiv()+"x de R$" + String.valueOf(produto.getPreco() / 10));
        holder.ibCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Adiciona produto ao carrinho", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNomeItem;
        private TextView tvPrecoItem;
        private ImageView ivItem;
        private ImageButton ibCart;

        public ViewHolder(View v) {
            super(v);
            tvNomeItem = (TextView) v.findViewById(R.id.tv_nome_item);
            tvPrecoItem = (TextView) v.findViewById(R.id.tv_preco_item);
            ivItem = (ImageView) v.findViewById(R.id.iv_item);
            ibCart = (ImageButton) v.findViewById(R.id.ib_cart);

        }

    }
}
