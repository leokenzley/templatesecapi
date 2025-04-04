package com.leokenzley.templatesecapi.api;

import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.context.request.NativeWebRequest;

import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ApiUtilTest {

    private NativeWebRequest req;
    private HttpServletResponse res;
    private PrintWriter writer;

    @BeforeEach
    public void setUp() throws IOException {
        req = mock(NativeWebRequest.class);
        res = mock(HttpServletResponse.class);
        writer = mock(PrintWriter.class);

        when(req.getNativeResponse(HttpServletResponse.class)).thenReturn(res);
        when(res.getWriter()).thenReturn(writer);
    }

    @Test
    public void testSetExampleResponse() throws IOException {
        String contentType = "application/json";
        String example = "{\"key\":\"value\"}";

        ApiUtil.setExampleResponse(req, contentType, example);

        verify(res).setCharacterEncoding("UTF-8");
        verify(res).addHeader("Content-Type", contentType);
        verify(writer).print(example);
    }

    @Test
    public void testSetExampleResponse_IOException() throws IOException {
        when(res.getWriter()).thenThrow(new IOException());

        assertThrows(RuntimeException.class, () -> {
            ApiUtil.setExampleResponse(req, "application/json", "{\"key\":\"value\"}");
        });
    }
}