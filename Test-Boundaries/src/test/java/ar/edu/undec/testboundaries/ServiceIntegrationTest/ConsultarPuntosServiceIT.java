package ar.edu.undec.testboundaries.ServiceIntegrationTest;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConsultarPuntosServiceIT {

    private String url = "http://localhost:8080/";

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ScriptSql/ServiceSql/ConsultarPuntosAntes.sql")
    public void A_ConsultarPuntos_TieneCursos_Devuelve200() throws IOException {
        HttpUriRequest request = new HttpGet(url + "/puntos/rabazan");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ScriptSql/ServiceSql/ConsultarPuntosDespues.sql")
    public void B_ConsultarPuntos_NoTieneCursos_Devuelve204() throws IOException {
        HttpUriRequest request = new HttpGet(url + "/puntos/rabazan");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_NO_CONTENT));
    }

}
