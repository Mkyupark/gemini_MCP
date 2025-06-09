package gemini.mcp.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gemini.mcp.model.GeminiIntentResponse;
import gemini.mcp.service.McpService;

@RestController
@RequestMapping("/mcp")
public class McpController {

    private final McpService mcpService;

    public McpController(McpService mcpService) {
        this.mcpService = mcpService;
    }

    @PostMapping(value = "/ask")
    public ResponseEntity<GeminiIntentResponse> ask(@RequestBody String userCommand) {
        GeminiIntentResponse response = mcpService.handleUserCommand(userCommand);
        return ResponseEntity.ok(response);
    }
}
