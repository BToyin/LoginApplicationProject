package com.sparta.toyin.authentication;

import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;
import java.util.HashSet;

public class InMemoryIdentityStore implements IdentityStore {

    @Override
    public CredentialValidationResult validate(Credential credential) {
        UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) credential;

        if (usernamePasswordCredential.getCaller().equals("Toyin") && usernamePasswordCredential.getPasswordAsString().equals("password")) {
            HashSet<String> roles = new HashSet<>();
            roles.add("ADMIN");
            return new CredentialValidationResult("Toyin", roles);
        } else if (usernamePasswordCredential.getCaller().equals("Basit") && usernamePasswordCredential.getPasswordAsString().equals("password")) {
            HashSet<String> roles = new HashSet<>();
            roles.add("USER");
            return new CredentialValidationResult("Basit", roles);
        } else {
            return CredentialValidationResult.NOT_VALIDATED_RESULT;
        }

    }
}
