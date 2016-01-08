package at.ernhofer.kopec.dezsys07.soa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import at.ernhofer.kopec.dezsys07.DataRepository;

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

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getDataRequest")
    @ResponsePayload
    public GetDataResponse getDataRecord(@RequestPayload GetDataRequest request) {
        GetDataResponse response = new GetDataResponse();
        response.setData(dataRepository.findTop100BySuchbegriffContainingIgnoreCase(request.getSuchbegriff()));

        return response;
    }
}
