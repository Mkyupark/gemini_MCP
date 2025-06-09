package gemini.mcp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import gemini.mcp.service.GeminiService;

@SpringBootTest
class GeminiServiceTest {
    @Autowired
    private GeminiService service;

    @Test
    void getCompletion() {
        String text = service.getCompletion("고구마에 감자");
        System.out.println(text);
    }
}