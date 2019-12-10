package ar.edu.undec.testboundaries.ServiceIntegrationTest;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CrearCursoServiceIT {

    private String url = "http://localhost:8080/";

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ScriptSql/ServiceSql/CrearCursoAntes.sql")
    public void A_CrearCurso_DatosCorrectos_Devuelve200() throws JSONException, IOException {
        JSONObject curso = new JSONObject();
        curso.put("idCurso", null);
        curso.put("titulo", "Nuevo Curso");
        curso.put("inscriptos", new JSONArray());
        curso.put("fechaLimiteInscripcion", LocalDateTime.now().plusDays(5));
        HttpPost post = new HttpPost(url + "/curso");
        StringEntity se = new StringEntity(curso.toString());
        se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        post.setEntity(se);
        post.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpUriRequest request = post;
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:ScriptSql/ServiceSql/CrearCursoDespues.sql")
    public void B_CrearCurso_CursoExiste_Devuelve412() throws JSONException, IOException {
        JSONObject curso = new JSONObject();
        curso.put("idCurso", null);
        curso.put("titulo", "Nuevo Curso");
        curso.put("inscriptos", new JSONArray());
        curso.put("fechaLimiteInscripcion", LocalDateTime.now().plusDays(5));
        HttpPost post = new HttpPost(url + "/curso");
        StringEntity se = new StringEntity(curso.toString());
        se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        post.setEntity(se);
        post.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpUriRequest request = post;
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_PRECONDITION_FAILED));
    }
}
