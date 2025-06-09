package gemini.mcp.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import gemini.mcp.model.GeminiIntentResponse;
import gemini.mcp.model.GeminiPromptBuilder;

@Service
@RequiredArgsConstructor
public class McpService {

    private final GeminiPromptBuilder promptBuilder;
    private final GeminiService geminiService;
    //private final QueryExecutor queryExecutor;
    //private final ResponseSummarizer summarizer;

    public GeminiIntentResponse handleUserCommand(String command) {
        // 1. Prompt 생성
        String intentPrompt = promptBuilder.buildIntentExtractionPrompt(command);

        // 2. Gemini 호출 → DSL(JSON) 파싱
        GeminiIntentResponse intentResponse = geminiService.askForIntent(intentPrompt);
        System.out.println(intentResponse.getIntent());
        System.out.println(intentResponse.getLocation());
        System.out.println(intentResponse.getRole());
        System.out.println(intentResponse);

        return intentResponse;
        // 3. DSL 기반 Querydsl 실행
        // List<Caregiver> caregivers = queryExecutor.execute(intentResponse);

        // // 4. Gemini에게 결과 요약 요청
        // String summaryPrompt = promptBuilder.buildSummarizationPrompt(command, caregivers);
        // return geminiService.summarize(summaryPrompt);
    }
}
