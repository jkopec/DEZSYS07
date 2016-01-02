package at.ernhofer.kopec.dezsys07.client;

import javax.xml.soap.*;

/**
 * The creates the SOAP request envelope with the required information
 *
 * @author Andreas Ernhofer & Jakub Kopec
 * @version 20151223
 */
public class DezSysSOAPMessageCreator implements SOAPMessageCreator {

    private String name;

    private static final String NAMESPACE = "http://at/ernhofer/kopec/dezsys07/soa";

    public DezSysSOAPMessageCreator(String name) {
        this.name = name;
    }

    /**
     * @see SOAPMessageCreator#create
     */
    @Override
    public SOAPMessage create() throws SOAPException {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("gs", NAMESPACE);

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement requestElement = soapBody.addChildElement("getDataRequest", "gs");
        SOAPElement nameElement = requestElement.addChildElement("suchbegriff", "gs");
        nameElement.addTextNode(this.name);

        // Headers
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", NAMESPACE + "getDataRequest");

        soapMessage.saveChanges();

        return soapMessage;
    }
}
