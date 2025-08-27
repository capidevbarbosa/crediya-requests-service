package co.com.crediya.r2dbc;

import co.com.crediya.r2dbc.entity.SolicitudEntiry;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

// TODO: This file is just an example, you should delete or modify it
public interface MyReactiveRepository extends ReactiveCrudRepository<SolicitudEntiry, Long>, ReactiveQueryByExampleExecutor<SolicitudEntiry> {

}
