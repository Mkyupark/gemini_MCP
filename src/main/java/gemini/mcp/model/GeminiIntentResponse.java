package gemini.mcp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeminiIntentResponse {
    private String intent;
    private String location;
    private String role;
    // getters & setters
}