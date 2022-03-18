package com.example.pruebatecnicaspringdeveloperionix.infractructure.client;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.transport.http.ClientHttpRequestMessageSender;

/**
 * Generic class data for call SOAP Web Services with message
 * @version 1.0.0 - 18 Mar 2022
 * @author Gonzalo Rojas - gonzalo.rojasmardones@gmail.com
 * @since 1.0.0 - 18 Mar 2022
 * @param <R> custom generic request
 * @param <Q> custom generic response
 */
public abstract class WSClientWithMessage<R, Q> extends WebServiceGatewaySupport {

    //@Value(ConstantsProperties.WS_TIME_OUT)
    protected int timeOut;

    protected String uri;

    /**
     * protected constructor
     * @param uri uri endpoint for the call service
     */
    protected WSClientWithMessage(String uri) {this.uri = uri;}

    /**
     * Call WS
     * @param rq request body
     * @return response service
     */
    public R callWS(Q rq, Object... messages) {
        config();
        getTimeOut();
        return buildResponse(getWebServiceTemplate().marshalSendAndReceive(this.uri, buildRequest(rq),
                buildMessageCallBack(messages)));
    }

    /**
     * Builds the request
     * @param rq th rq
     * @return the object
     */
    protected abstract Object buildRequest(Q rq);

    /**
     * Builds the response
     * @param o the o
     * @return the rs
     */
    protected abstract R buildResponse(Object o);

    /**
     * Builds the response
     * @param o the o
     * @return the rs
     */
    protected abstract WebServiceMessageCallback buildMessageCallBack(Object... o);

    /**
     * Gets the context path
     * @return the context path
     */
    protected abstract Class<?> getContextPath();

    /**
     * config
     */
    private void config() {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setContextPath(getContextPath().getPackage().getName());
        setMarshaller(jaxb2Marshaller);
        setUnmarshaller(jaxb2Marshaller);
    }

    /**
     * Time out the service
     */
    private void getTimeOut() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(this.timeOut);
        requestFactory.setReadTimeout(this.timeOut);
        getWebServiceTemplate().setMessageSender(new ClientHttpRequestMessageSender(requestFactory));
    }
}
