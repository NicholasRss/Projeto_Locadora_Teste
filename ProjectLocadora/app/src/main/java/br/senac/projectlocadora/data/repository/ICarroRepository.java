package br.senac.projectlocadora.data.repository;

import java.util.List;

import br.senac.projectlocadora.data.Model.Carro;

public interface ICarroRepository {

    void crie(Carro model, Callback<Carro> callback);

    void getAll(Callback<List<Carro>> callback);

    interface Callback<Resultado> {
        void onResult(Resultado result);

        void onError(Exception e);

        void onEmpty();
    }
}
