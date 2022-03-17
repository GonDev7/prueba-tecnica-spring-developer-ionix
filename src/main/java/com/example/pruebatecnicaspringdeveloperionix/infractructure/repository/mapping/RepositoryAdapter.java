package com.example.pruebatecnicaspringdeveloperionix.infractructure.repository.mapping;

/**
 * Response mapper interface
 * @version 1.0.0 - 17 Mar 2022
 * @author Gonzalo Rojas - gonzalo.rojasmardones@gmail.com
 * @since 1.0.0 - 17 Mar 2022
 */
public interface RepositoryAdapter<R, T> {

    /**
     * Allow get DTO model object instance with service entoty data
     * @param parameters model service object
     * @return DTO model data
     */
    R getRequest(Object... parameters);

    /**
     * Allow get microservice model object instance with service entoty data
     * @param parameters DTO model request object
     * @return service entity data
     */
    T getResponse(Object... parameters);
}
