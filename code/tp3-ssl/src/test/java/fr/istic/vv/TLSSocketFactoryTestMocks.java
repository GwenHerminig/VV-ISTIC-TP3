package fr.istic.vv;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TLSSocketFactoryTestMocks {
    @Test
    public void preparedSocket_NullProtocols()  {
        TLSSocketFactory f = new TLSSocketFactory();
        SSLSocket socket = Mockito.mock(SSLSocket.class);
        Mockito.when(socket.getSupportedProtocols()).thenReturn(null);
        Mockito.when(socket.getEnabledProtocols()).thenReturn(null);
        f.prepareSocket(socket);
    }

    @Test
    public void test()  {
        TLSSocketFactory f = new TLSSocketFactory();
        SSLSocket socket = Mockito.mock(SSLSocket.class);
        Mockito.when(socket.getSupportedProtocols())
                .thenReturn(new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"});
        Mockito.when(socket.getEnabledProtocols()).thenReturn(new String[]{"SSLv3", "TLSv1"});

        f.prepareSocket(socket);

        String[] expectedEnabledProtocols = new String[]{"TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3"};
        Mockito.verify(socket).setEnabledProtocols(expectedEnabledProtocols);
    }
}