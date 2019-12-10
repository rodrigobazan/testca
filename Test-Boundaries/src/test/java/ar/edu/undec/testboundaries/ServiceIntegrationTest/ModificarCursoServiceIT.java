package ar.edu.undec.testboundaries.ServiceIntegrationTest;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPut;
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

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ModificarCursoServiceIT {

    private String url = "http://localhost:8080/";


    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ScriptSql/ServiceSql/ModificarCursoAntes.sql")
    public void A_ModificarCurso_DatosCorrectos_Devuelve200() throws JSONException, IOException {
        JSONObject curso = new JSONObject();
        curso.put("idCurso", 1);
        curso.put("titulo", "Ionic 4");
        curso.put("inscriptos", new JSONArray());
        curso.put("fechaLimiteInscripcion", LocalDateTime.now().plusDays(5));
        curso.put("puntos", 10);
        HttpPut post = new HttpPut(url + "/curso");
        StringEntity se = new StringEntity(curso.toString());
        se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        post.setEntity(se);
        post.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpUriRequest request = post;
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void B_ModificarCurso_CursoExiste_Devuelve412() throws JSONException, IOException {
        JSONObject curso = new JSONObject();
        curso.put("idCurso", 1);
        curso.put("titulo", "Ionic 5");
        curso.put("inscriptos", new JSONArray());
        curso.put("fechaLimiteInscripcion", LocalDateTime.now().plusDays(5));
        curso.put("puntos", 10);
        HttpPut post = new HttpPut(url + "/curso");
        StringEntity se = new StringEntity(curso.toString());
        se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        post.setEntity(se);
        post.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpUriRequest request = post;
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_PRECONDITION_FAILED));
    }

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:ScriptSql/ServiceSql/ModificarCursoDespues.sql")
    public void C_ModificarCurso_FechaIncorrecta_Devuelve412() throws JSONException, IOException {
        JSONObject curso = new JSONObject();
        curso.put("idCurso", 1);
        curso.put("titulo", "Ionic 4");
        curso.put("inscriptos", new JSONArray());
        curso.put("fechaLimiteInscripcion", LocalDateTime.now().minusDays(1));
        curso.put("puntos", 10);
        HttpPut post = new HttpPut(url + "/curso");
        StringEntity se = new StringEntity(curso.toString());
        se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        post.setEntity(se);
        post.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpUriRequest request = post;
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_PRECONDITION_FAILED));
    }

}
