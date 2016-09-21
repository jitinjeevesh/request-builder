import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.HashMap;

/**
 * Util class used for default initilizations.
 */
public class ApiRequestUtil {

    /**
     * This method gives the HttpHeaders with application/json.
     *
     * @return HttpHeaders with application/json
     */
    public static HttpHeaders getHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }

    /**
     * This method give the empty request body.
     *
     * @return Request body
     */
    public static HashMap<String, Object> getRequestBody() {
        return new HashMap<String, Object>();
    }
}
