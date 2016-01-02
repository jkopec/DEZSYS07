package at.ernhofer.kopec.dezsys07.client;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

/**
 * The SOAP Message creator class which send requests to the server
 * and returns the received response
 *
 * @author Andreas Ernhofer & Jakub Kopec
 * @version 20151223
 */
public interface SOAPMessageCreator {

    /**
     * Creates the SOAP request envelope
     *
     * @return The SOAP Request Envelope to search for DataRecords
     * @throws SOAPException Will be thrown if a SOAP related feature fails
     */
    SOAPMessage create() throws SOAPException;
}
