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
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InscripcionCursoServiceIT {

    private String url = "http://localhost:8080/";


    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ScriptSql/ServiceSql/InscripcionCursoAntes.sql")
    public void A_InscripcionCurso_NoEstaInscripto_Devuelve200() throws JSONException, IOException {
        JSONObject inscripcion = new JSONObject();
        inscripcion.put("curso", factoryCurso());
        inscripcion.put("cuenta", factoryCuenta());
        HttpPost post = new HttpPost(url + "/inscripcion");
        StringEntity se = new StringEntity(inscripcion.toString());
        se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        post.setEntity(se);
        post.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpUriRequest request = post;
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void B_InscripcionCurso_EstaInscripto_Devuelve412() throws JSONException, IOException {
        JSONObject inscripcion = new JSONObject();
        inscripcion.put("curso", factoryCurso());
        inscripcion.put("cuenta", factoryCuenta());
        HttpPost post = new HttpPost(url + "/inscripcion");
        StringEntity se = new StringEntity(inscripcion.toString());
        se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        post.setEntity(se);
        post.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpUriRequest request = post;
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_PRECONDITION_FAILED));
    }

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:ScriptSql/ServiceSql/InscripcionCursoDespues.sql")
    public void C_InscripcionCurso_FechaLimitePaso_Devuelve412() throws JSONException, IOException {
        JSONObject inscripcion = new JSONObject();
        inscripcion.put("curso", factoryCursoVencido());
        inscripcion.put("cuenta", factoryCuenta());
        HttpPost post = new HttpPost(url + "/inscripcion");
        StringEntity se = new StringEntity(inscripcion.toString());
        se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        post.setEntity(se);
        post.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpUriRequest request = post;
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_PRECONDITION_FAILED));
    }

    private JSONObject factoryCursoVencido() throws JSONException {
        JSONObject curso = new JSONObject();
        curso.put("idCurso", 10);
        curso.put("titulo", "Nuevo Curso");
        curso.put("inscriptos", new JSONArray());
        curso.put("fechaLimiteInscripcion", LocalDateTime.of(2019, 11, 10, 0, 0, 0));
        curso.put("puntos", 5);
        return curso;
    }

    private JSONObject factoryCurso() throws JSONException {
        JSONObject curso = new JSONObject();
        curso.put("idCurso", 1);
        curso.put("titulo", "Ionic 4");
        curso.put("inscriptos", new JSONArray());
        curso.put("fechaLimiteInscripcion", LocalDateTime.now().plusDays(5));
        curso.put("puntos", 5);
        return curso;
    }

    private JSONObject factoryCuenta() throws JSONException {
        JSONObject cuenta = new JSONObject();
        cuenta.put("idCuenta", 1);
        cuenta.put("usuario", "rabazan");
        cuenta.put("fechaCreacion", LocalDateTime.now());
        cuenta.put("nombre", "Rodrigo Bazan");
        cuenta.put("pass", "123456");
        return cuenta;
    }
}
