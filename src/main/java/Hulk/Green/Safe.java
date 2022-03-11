package Hulk.Green;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public final class Safe {

    private String secret;
    private HashMap<String, Credentials> validCertificates
            = new HashMap<String, Credentials>();

    public Safe(String aSecret) {
        this.secret = aSecret;
    }

    public final class Credentials {
        private String user;
        private Credentials(String user) {
            this.user = user;
        }
    }

    public final Credentials getCredential(String user) {
        // Following test is just for illustrating the intention...
        if ( "accepted".equals(user) ) {
            return new Credentials(user);
        } else {
            return null;
        }
    }

    public String gimmeTheSecret(Credentials cred) {
        if ( this.validCertificates.get(cred.user) == cred ) {
            return secret;
        } else {
            return null;
        }
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        throw new RuntimeException("No no no no no no no!!!");
    }

}