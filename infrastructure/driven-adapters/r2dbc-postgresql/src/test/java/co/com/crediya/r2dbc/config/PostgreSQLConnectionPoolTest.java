package co.com.crediya.r2dbc.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class PostgreSQLConnectionPoolTest {

    @InjectMocks
    private PostgreSQLConnectionPool connectionPool;

    @Mock
    private PostgresqlConnectionProperties properties;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        when(properties.host()).thenReturn("localhost");
        when(properties.port()).thenReturn(5434);
        when(properties.database()).thenReturn("request_db");
        when(properties.schema()).thenReturn("schema");
        when(properties.username()).thenReturn("crediya_user");
        when(properties.password()).thenReturn("crediya_password");
    }

    @Test
    void getConnectionConfigSuccess() {
        assertNotNull(connectionPool.getConnectionConfig(properties));
    }
}
