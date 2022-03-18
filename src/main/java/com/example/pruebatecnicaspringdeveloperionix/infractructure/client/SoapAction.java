package com.example.pruebatecnicaspringdeveloperionix.infractructure.client;

import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.soap.SoapMessage;

/**
 * Soap Header class for added header call SOAP Web Services.
 * @version 1.0.0 - 18 Mar 2022
 * @author Gonzalo Rojas - gonzalo.rojasmardones@gmail.com
 * @since 1.0.0 - 18 Mar 2022
 */
public class SoapAction implements WebServiceMessageCallback {

    private String soapAction;

    /**
     * public constructor
     * @param soapAction action method soap
     */
    public SoapAction(String soapAction) {
        this.soapAction = soapAction;
    }

    /* (non-javadoc)
     * @see org.springframework.ws.client.core.WebServiceMessageCallBack#doWithMessage(WebServiceMessage)
     */
    @Override
    public void doWithMessage(WebServiceMessage message) {
        if (this.soapAction != null) {
            ((SoapMessage) message).setSoapAction(this.soapAction);
        }
    }
}
