
package gemini.mcp.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
 *  @Brief
 *  Gemini API 요청구조에 맞추기
 */
@NoArgsConstructor
@Getter
public class GeminiRequest {

    private List<Content> contents;

    public GeminiRequest(String text) {
        Part part = new TextPart(text);
        Content content = new Content(Collections.singletonList(part));
        this.contents = Arrays.asList(content);
    }

    public GeminiRequest(String text, InlineData inlineData) {
        List<Content> contents = List.of(
            new Content(
                List.of(
                    new TextPart(text),
                    new InlineDataPart(inlineData)
                )
            )
        );

        this.contents = contents;
    }

    @Getter
    @AllArgsConstructor
    private static class Content {
        private List<Part> parts;
    }

    interface Part {}

    @Getter
    @AllArgsConstructor
    private static class TextPart implements Part {
        public String text;
    }

    @Getter
    @AllArgsConstructor
    private static class InlineDataPart implements Part {
        public InlineData inlineData;
    }

    @Getter
    @AllArgsConstructor
    public static class InlineData {
        private String mimeType;
        private String data;
    }
}


/*
 Gemini 요청 JSON 포맷
 {
  "contents": [
    {
      "parts": [
        { "text": "hello" },
        { "inlineData": { "mimeType": "text/plain", "data": "..." } }
      ]
    }
  ]
}
 */