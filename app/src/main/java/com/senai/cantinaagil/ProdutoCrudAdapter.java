package com.senai.cantinaagil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import java.util.List;
import java.util.Locale;

public class  ProdutoCrudAdapter extends RecyclerView.Adapter<ProdutoCrudAdapter.ProdutoViewHolder> {

    public interface OnProdutoActionListener {
        void onEditar(Produto produto);
        void OnExcluir(Produto produto);
    }

    private final List<Produto>produtos;

    private final OnProdutoActionListener listener;

    public ProdutoCrudAdapter(List<Produto> produtos, OnProdutoActionListener listener) {
        this.produtos = produtos;
        this.listener = listener;
    }



    @NonNull
    @Override
    public ProdutoCrudAdapter.ProdutoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_produto_crud,parent,false);

        return new ProdutoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutoCrudAdapter.ProdutoViewHolder holder, int position) {

        Produto produto = produtos.get(position);

        holder.tvNome.setText(produto.getNome());
        holder.tvCategoria.setText(produto.getCategoria());
        holder.tvPreco.setText(String.format(Locale.getDefault(), "Preço: R$ %.2f", produto.getPreco()));
        holder.tvQuantidade.setText("Estoque: "+ produto.getQuantidade());
        holder.btnEditar.setOnClickListener(v ->listener.onEditar(produto));
        holder.btnExcluir.setOnClickListener(v ->listener.OnExcluir(produto));
    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }

    public class ProdutoViewHolder extends RecyclerView.ViewHolder {

        TextView tvNome, tvCategoria, tvPreco, tvQuantidade;
        MaterialButton btnEditar, btnExcluir;


        public ProdutoViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNome = itemView.findViewById(R.id.tv_crud_nome);
            tvCategoria = itemView.findViewById(R.id.tv_crud_categoria);
            tvPreco = itemView.findViewById(R.id.tv_crud_preco);
            tvQuantidade = itemView.findViewById(R.id.tv_crud_quantidade);
            btnEditar = itemView.findViewById(R.id.btn_crud_editar);
            btnExcluir = itemView.findViewById(R.id.btn_crud_excluir);
            btnExcluir = itemView.findViewById(R.id.btn_crud_excluir);
        }
    }
}
