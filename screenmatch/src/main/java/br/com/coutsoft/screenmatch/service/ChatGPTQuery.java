package br.com.coutsoft.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ChatGPTQuery {

    public static String getTranslation(String lang, String text) {
        OpenAiService service = new OpenAiService(System.getenv("GPT3_KEY"));

        CompletionRequest request = CompletionRequest.builder()
//                .model("gpt-4o-mini-2024-07-18")
                .model("gpt-3.5-turbo")
                .prompt("please translate the following text to " + lang + ": " + text)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var response = service.createCompletion(request);
        return response.getChoices().get(0).getText();
    }
}
