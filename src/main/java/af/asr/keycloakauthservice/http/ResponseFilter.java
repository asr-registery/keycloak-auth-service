package af.asr.keycloakauthservice.http;

import java.lang.annotation.*;

/**
 * Used to process filter on request and response for a REST service.*
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface ResponseFilter {
}
