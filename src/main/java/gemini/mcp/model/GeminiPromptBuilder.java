package gemini.mcp.model;

import org.springframework.stereotype.Component;

@Component
public class GeminiPromptBuilder {

    public String buildIntentExtractionPrompt(String userInput) {
        return String.format("""
            사용자의 요청에서 의도(intent), location(지역), role(직종)을 추출해 **반드시 JSON만** 출력하세요.
            다른 설명, 줄바꿈, 마크다운은 금지합니다.
    
            예시 1
            입력: "의성군에 근무 가능한 사회복지사 알려줘"
            출력: {"intent":"find_available_worker","location":"의성군","role":"사회복지사"}
    
            예시 2
            입력: "서울에서 일할 수 있는 간병인 구해줘"
            출력: {"intent":"find_available_worker","location":"서울","role":"간병인"}
    
            입력: "%s"
            출력:
        """, userInput);    }

    // public String buildSummarizationPrompt(String originalCommand, List<Caregiver> results) {
    //     return "사용자가 \"" + originalCommand + "\"라고 물었고, 다음 데이터를 DB에서 조회했어: "
    //             + results.toString() + "\n이걸 친절한 서술형 문장으로 바꿔줘.";
    // }
}
