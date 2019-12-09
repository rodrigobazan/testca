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
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CrearCuentaServiceIT {

    private String url = "http://localhost:8080/";

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ScriptSql/ServiceSql/CrearCuentaAntes.sql")
    public void A_crearCuenta_DatosCorrectos_Devuelve200() throws JSONException, IOException {
        JSONObject cuenta = new JSONObject();
        cuenta.put("idCuenta", null);
        cuenta.put("usuario", "rabazan");
        cuenta.put("fechaCreacion", LocalDateTime.now());
        cuenta.put("nombre", "Rodrigo Bazan");
        cuenta.put("pass", "123456");
        HttpPost post = new HttpPost(url + "/cuenta");
        StringEntity se = new StringEntity(cuenta.toString());
        se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        post.setEntity(se);
        post.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpUriRequest request = post;
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:ScriptSql/ServiceSql/CrearCuentaDespues.sql")
    public void B_crearCuenta_CuentaExiste_Devuelve412() throws JSONException, IOException {
        JSONObject cuenta = new JSONObject();
        cuenta.put("idCuenta", null);
        cuenta.put("usuario", "rabazan");
        cuenta.put("fechaCreacion", LocalDateTime.now());
        cuenta.put("nombre", "Rodrigo Bazan");
        cuenta.put("pass", "123456");
        HttpPost post = new HttpPost(url + "/cuenta");
        StringEntity se = new StringEntity(cuenta.toString());
        se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        post.setEntity(se);
        post.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpUriRequest request = post;
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_PRECONDITION_FAILED));
    }


}
