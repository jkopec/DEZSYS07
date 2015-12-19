package at.ernhofer.kopec.dezsys07.soa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import at.ernhofer.kopec.dezsys07.DataRepository;

/**
 * The endpoint for the SOA service. <br>
 * Request are mapped to their related responses in this class
 *
 * @author Andreas Ernhofer & Jakub Kopec
 * @version 20151219
 */
@Endpoint
public class DataEndpoint {
    public static final String NAMESPACE_URI = "http://at/ernhofer/kopec/dezsys07/soa";

	private DataRepository dataRepository;

    /**
     * Spring uses this constructor to auto-inject a repository
     *
     * @param dataRepository Injected repository
     */
    @Autowired
    public DataEndpoint(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    /**
     * Maps the DataRecord search request. <br>
     * To be exact, a request with a GatDataRecord request payload will be mapped
     * to a related response.
     *
     * @param request The SOAP Request
     * @return A response with the first 100 entries
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getDataRequest")
    @ResponsePayload
    public GetDataResponse getDataRecord(@RequestPayload GetDataRequest request) {
        GetDataResponse response = new GetDataResponse();
        response.setData(dataRepository.findBySuchbegriff(request.getSuchbegriff()));

        return response;
    }
}
