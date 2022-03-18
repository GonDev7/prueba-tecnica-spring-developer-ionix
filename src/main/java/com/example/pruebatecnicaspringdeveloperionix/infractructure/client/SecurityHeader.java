package com.example.pruebatecnicaspringdeveloperionix.infractructure.client;

import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.SoapMessage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.IOException;

/**
 * Security Header class for added header call SOAP Web Services
 * @version 1.0.0 - 18 Mar 2022
 * @author Gonzalo Rojas - gonzalo.rojasmardones@gmail.com
 * @since 1.0.0 - 18 Mar 2022
 */
public class SecurityHeader implements WebServiceMessageCallback {

    private Object authentication;
    private Class<?> contextClass;
    private String soapAction;

    /**
     * public constructor
     * @param authentication object with user ans pass header service
     * @param contextClass package class service
     * @param soapAction action method soap
     */
    public SecurityHeader(Object authentication, Class<?> contextClass, String soapAction) {
        this.authentication = authentication;
        this.contextClass = contextClass;
        this.soapAction = soapAction;
    }

    /* (non-javadoc)
     * @see org.springframework.ws.client.core.WebServiceMessageCallBack#doWithMessage(WebServiceMessage)
     */
    @Override
    public void doWithMessage(WebServiceMessage message) throws IOException {
        SoapHeader header = ((SoapMessage)message).getSoapHeader();
        if(this.soapAction != null) {
            ((SoapMessage) message).setSoapAction(this.soapAction);
        }
        try {
            JAXBContext context = JAXBContext.newInstance(this.contextClass);
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(authentication, header.getResult());
        } catch (Exception e) {
            throw new IOException("error while marshalling autheentication.");
        }
    }
}
