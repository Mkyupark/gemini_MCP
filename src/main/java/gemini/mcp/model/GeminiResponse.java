package gemini.mcp.model;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class GeminiResponse {

    private List<Candidate> candidates;

    @Getter
    public static class Candidate {
        private Content content;
        private String finishReason;
        private int index;
        List<SafetyRating> safetyRatings;
    }

    @Getter
    public static class Content {
        private List<TextPart> parts;
        private String role;
    }

    @Getter
    public static class TextPart {
        private String text;
    }

    @Getter
    public static class SafetyRating {
        private String category;
        private String probability;
    }
}

/*
Gemini API 반환 구조
{
  "candidates": [
    {
      "content": {
        "parts": [
          { "text": "안녕하세요! 무엇을 도와드릴까요?" }
        ],
        "role": "model"
      },
      "finishReason": "STOP",
      "index": 0,
      "safetyRatings": [
        { "category": "harassment", "probability": "LOW" },
        { "category": "violence", "probability": "VERY_LOW" }
      ]
    }
  ]
}

 */