package gemini.mcp.service;

import org.springframework.stereotype.Service;
import com.google.gson.Gson;

import gemini.mcp.config.GeminiInterface;
import gemini.mcp.model.GeminiIntentResponse;
import gemini.mcp.model.GeminiRequest;
import gemini.mcp.model.GeminiResponse;

@Service
public class GeminiService {
    public static final String GEMINI_MODEL = "gemini-2.0-flash";

    private final GeminiInterface geminiInterface;
    private final Gson gson;

    public GeminiService(GeminiInterface geminiInterface) {
        this.geminiInterface = geminiInterface;
        this.gson = new Gson();
    }

    private GeminiResponse getCompletion(GeminiRequest request) {
        return geminiInterface.getCompletion(GEMINI_MODEL, request);
    }

    public String getCompletion(String text) {
        GeminiRequest geminiRequest = new GeminiRequest(text);
        GeminiResponse response = getCompletion(geminiRequest);

        return response.getCandidates()
            .stream()
            .findFirst().flatMap(candidate -> candidate.getContent().getParts()
                .stream()
                .findFirst()
                .map(GeminiResponse.TextPart::getText))
            .orElse(null);
    }
    /* intent 추출용: JSON → DTO */
    public GeminiIntentResponse askForIntent(String prompt) {
        String json = getCompletion(prompt);
        return gson.fromJson(json, GeminiIntentResponse.class);
    }

    /* 요약용 */
    public String summarize(String prompt) {
        return getCompletion(prompt);
    }    
}