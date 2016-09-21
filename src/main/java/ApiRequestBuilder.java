import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * This class is used to execute request.
 *
 */
@Component
public class ApiRequestBuilder {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    private RestTemplate restTemplate;


    /**
     * This method is used to execute the request.
     *
     * @param requestBuilderData Request data with Headers, Request Body, URL
     * @param responseClass In which response is bind
     * @return ResponseEntity with the type of response class
     * @throws JsonProcessingException
     */
    public <T> ResponseEntity<T> executeRequest(RequestBuilderDTO requestBuilderData, Class<T> responseClass) throws JsonProcessingException {
        return restTemplate.exchange(
                requestBuilderData.getUrl(),
                requestBuilderData.getHttpMethod(),
                new HttpEntity<String>(OBJECT_MAPPER.writeValueAsString(requestBuilderData.getRequestBody()), requestBuilderData.getHttpHeaders()),
                responseClass);
    }

    /**
     * This method is used to execute the request.
     *
     * @param requestBuilderData Request data with Headers, Request Body, URL
     * @param responseClass In which response is bind
     * @param responseExecutor Implement this class and Defines functionality for all the codes i.e 200, 401 etc..
     * @return ResponseEntity with the type of response class
     * @throws JsonProcessingException
     *
     */
    public <T> ResponseEntity<T> executeRequest(RequestBuilderDTO requestBuilderData, Class<T> responseClass, ResponseExecutor responseExecutor) throws JsonProcessingException {
        restTemplate.setErrorHandler(new ResponseHandler(responseExecutor));
        return restTemplate.exchange(
                requestBuilderData.getUrl(),
                requestBuilderData.getHttpMethod(),
                new HttpEntity<String>(OBJECT_MAPPER.writeValueAsString(requestBuilderData.getRequestBody()), requestBuilderData.getHttpHeaders()),
                responseClass);
    }

}
