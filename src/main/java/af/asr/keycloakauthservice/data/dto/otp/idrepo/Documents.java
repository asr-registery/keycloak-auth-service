package af.asr.keycloakauthservice.data.dto.otp.idrepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class Documents.
 */

/**
 * Instantiates a new documents.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Documents {

	/** The doc type. */
	private String category;

	/** The doc value. */
	private String value;
}
