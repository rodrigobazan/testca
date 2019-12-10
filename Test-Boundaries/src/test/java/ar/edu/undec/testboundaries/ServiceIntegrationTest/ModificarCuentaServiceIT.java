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

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ModificarCuentaServiceIT {

    private String url = "http://localhost:8080/";

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ScriptSql/ServiceSql/EditarCuentaAntes.sql")
    public void A_ModificarCuenta_DatosCorrectos_Devuelve200() throws JSONException, IOException {
        JSONObject cuenta = new JSONObject();
        cuenta.put("idCuenta", 10);
        cuenta.put("usuario", "rabazan");
        cuenta.put("fechaCreacion", LocalDateTime.now());
        cuenta.put("nombre", "Rodrigo Bazan");
        cuenta.put("pass", "654321");
        HttpPut post = new HttpPut(url + "/cuenta");
        StringEntity se = new StringEntity(cuenta.toString());
        se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        post.setEntity(se);
        post.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpUriRequest request = post;
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:ScriptSql/ServiceSql/EditarCuentaDespues.sql")
    public void B_ModificarCuenta_CuentaExiste_Devuelve412() throws JSONException, IOException {
        JSONObject cuenta = new JSONObject();
        cuenta.put("idCuenta", 10);
        cuenta.put("usuario", "gtorres");
        cuenta.put("fechaCreacion", LocalDateTime.now());
        cuenta.put("nombre", "Rodrigo Bazan");
        cuenta.put("pass", "654321");
        HttpPut post = new HttpPut(url + "/cuenta");
        StringEntity se = new StringEntity(cuenta.toString());
        se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        post.setEntity(se);
        post.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpUriRequest request = post;
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_PRECONDITION_FAILED));
    }
}
