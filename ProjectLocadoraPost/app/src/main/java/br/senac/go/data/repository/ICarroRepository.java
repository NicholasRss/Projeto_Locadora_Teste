package br.senac.go.data.repository;

import android.telecom.Call;

import java.util.List;

import br.senac.go.data.model.Carro;

public interface ICarroRepository {

    void getAll(Callback<List<Carro>> callback);

    void createCarro(Callback<Carro> callback, Carro carro);

    interface Callback<Resultado> {
        void onResult(Resultado result);

        void onError(Exception e);

        void onEmpty();
    }
}
