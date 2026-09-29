package com.senai.cantinaagil;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public interface ProdutoDao {
    @Insert
    void inserir(Produto produto);

    @Update
    void atualizar(Produto produto);

    @Delete
    void excluir(Produto produto);

    @Query("SELECT * FROM produtos ORDEM BY nome ASC")
    List<Produto> listarTodos();

    @Query("SELECT * FROM PRODUTOS WHERE categoria = :categoria ORDER BY nome ASC ")
    List<Produto> listarPorCategoria(String categoria);

    @Query("SELECT * FROM produtos WHERE id= :id LIMIT 1")
    Produto buscarPorId(int id);
}
