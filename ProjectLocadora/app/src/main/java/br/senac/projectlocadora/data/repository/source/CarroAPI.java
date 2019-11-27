package br.senac.projectlocadora.data.repository.source;

import java.lang.ref.Reference;
import java.util.List;

import br.senac.projectlocadora.data.Model.Carro;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CarroAPI {

//    @GET("modelo/1")
//    Call<Carro> getCarro();

    @GET("/carro")
    Call<List<Carro>> getAll();
}
